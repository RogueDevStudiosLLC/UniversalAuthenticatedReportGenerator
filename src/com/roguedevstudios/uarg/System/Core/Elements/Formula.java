/************************************************
 * Formula Class File                           *
 * File name: Formula.java                      *
 * The class file for formulas.                 *
 ***********************************************/

package com.roguedevstudios.uarg.System.Core.Elements;

import net.objecthunter.exp4j.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormula;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Float;
import java.lang.Long;

/**
 * This class is the formula class.
 * 
 * @author Chelsea Hunter
 * @author Christopher E. Howard
 * @since 1.0
 */
public class Formula implements IFormula
{
    /* Class Attributes */

    /* The name meta of a formula */
    private String _formulaName;
    
    /* The description of a formula */
    private String _formulaDesc;
    
    /* The ID of a formula */
    private String _formulaId;
    
    /* The equation string this formula uses to build an exp4j expression */
    private String _formulaEquation;
    
    /* An ArrayList<String> of formula input variable names*/
    private ArrayList<String> _formulaVariableNames;
    
    /* The Exp4j Expression this formula builds from _formulaEquation*/
    private Expression _formulaExpression;
    
    /* Input array of variables converted to doubles*/
    private double[] _formulaInputArray;

    /* Class Methods */
    
    /**
    * Constructor for Formula class
    * Sets values for object fields, establishes
    * an exp4j compatible expression using the base
    * equation given, creates an ArrayList of variable
    * names to use in the formula's expression, and sets up
    * a Double array based off of the base equation
    * given for storing input variable object values.
    * 
    * @param formulaName	A formula's name, taken from _formulaName
    * @param formulaDesc	A formula's description, taken from _formulaDesc
    * @param formulaId		A formula's id, taken from _formulaId
    * @param formulaEquation	A formula's equation, taken from _formulaEquation
    * 
    * @throws IllegalArgumentException	If the constructed formula expression is invalid or cannot be evaluated.
    * @throws RuntimeException	If the constructed formula expression is invalid or cannot be evaluated.
    * 
    * @author Chelsea Hunter
    * @author Christopher E. Howard
    */
    public Formula ( String formulaName, 
    				 String formulaDesc, 
    				 String formulaId, 
    				 String formulaEquation
    				 ) 
    		throws IllegalArgumentException,
    			   RuntimeException
    {
        // Set the Formula Name
    	this._formulaName = formulaName;
    	
    	// Set the Formula Description
        this._formulaDesc = formulaDesc;
        
        // Set the Formula ID
        this._formulaId = formulaId;
        
        // Consume the Formula origin String
        this._formulaEquation = formulaEquation;
        
        /* Build and Validate Expression using Exp4j here*/
        this._formulaVariableNames = this._initializeVarNames();
        
        //TODO: Check necessity of this?
        this._formulaExpression = this._buildExpression();
        
        // Input Array Size
        this._formulaInputArray = new double[this._formulaVariableNames.size()];

        try {
        	
        	// Bind dummy values to our temp input array
        	for ( int i=0; 
        			  i<=this._formulaInputArray.length-1; 
        			  i++
        		)
        	{
        		this._formulaInputArray[i] = 1;
        	}
        	
        	// Validate using our ._process() method
        	this._process();
        	
        }
        catch ( IllegalArgumentException eIAE ) {
        	throw new IllegalArgumentException("IN FORMULA: " + this.GetFormulaId() + " -- The formula expression is invalid or cannot be evaluated.");
        }catch (RuntimeException eRTE ) {
        	throw new RuntimeException("IN FORMULA: " + this.GetFormulaId() + " -- The formula expression is invalid or cannot be evaluated.");
        }
        
        // Clear our temp array from our dummy values when we're done validating.
        this._clearTempArray();
    }
    
    /**
     * A method to initialize the variable names to be used by the formula's Exp4j expression.
     * @return ArrayList<String>	A list of variable names to be used in the formula's expression.
     * @author Chelsea Hunter
     */
    private ArrayList< String > _initializeVarNames() 
    {
    	
    	// Make a new ArrayList to populate with variable names we isolate via regex.
    	ArrayList<String> _formulaVarNames = new ArrayList<String>();
    	
    	// Setup regex pattern we want to use to isolate formula variables from _formulaEquation string
    	Pattern _formulaRegex = Pattern.compile( "\\s?_[a-zA-z0-9_]*_\\s?" );
    	
    	// Make a matcher to get the variables out of the formula equation string given, using above pattern
    	Matcher _formulaVarMatcher = _formulaRegex.matcher( this._formulaEquation );
    	
    	// While regex matcher can find matching values, add them to the ArrayList stripping out excess whitespace
    	while ( _formulaVarMatcher.find() ) 
    	{
    			_formulaVarNames.add( _formulaVarMatcher.
    													group().
    													replaceAll( "\\s+", 
    																"" )
    								);
    	}
    	
    	//System.err.println("Var Names Array: "+_formulaVarNames.toString());
    	return _formulaVarNames;
    	
    }
    
    /**
     * A method to build an exp4j expression for a formula object,
     * given that a valid formula equation was input by the configuration file.
     * @return Expression	An Exp4j Expression object for use in calculating formulas.
     * @throws IllegalArgumentException	If the formula's expression fails to build because there are bad variables or because the equation is bad and operators/functions failed to parse.
     * @author Chelsea Hunter
     * 
     */
    private Expression _buildExpression() 
    {
    	// Make base Exp4j ExpressionBuilder using _formulaEquation string as input
    	ExpressionBuilder _formulaExpressionBuilder = new ExpressionBuilder( this._formulaEquation );
    	
    	// For every string in our ArrayList<String> of formula variable names, 
    	// set that string as a variable in our expression.
    	try {
	    	for ( String s: 
	    		         this._formulaVariableNames
	    		) 
	    	{
	    		_formulaExpressionBuilder.variable(s);
	    	}
	    	
	    	// Once regex is done and variables are set, properly build the expression.
	    	Expression _formulaExpression = _formulaExpressionBuilder.build();
	    	
	    	return _formulaExpression;
    	} catch (IllegalArgumentException eIAE) {
    		throw new IllegalArgumentException("IN FORMULA: " + this.GetFormulaId() + " -- Failed to build the formula's expression.");
    	}
    	
    }
    
    /**
    * Gets the double result of calculating the Formula object's Exp4j Expression.
    * @param vars	The Variable Number objects with the desired input values in array format.
    * @return double	The result of calculating the Formula object's Expression.
    * @throws IllegalArgumentException	If the incoming array is the wrong size, or if values in the Variable array cannot be parsed into a numerical value.
    * @throws IllegalStateException	If the formula's Exp4j Expression is invalid.
    * @author Chelsea Hunter
    * @author Christopher E. Howard
    */
    private double _calculateExpression( IVariable<? extends Number>[] vars ) 
    		throws IllegalArgumentException 
    
    {
    	  // If the array is the wrong size throw an exception
        if( vars.length != this._formulaInputArray.length )
            throw new IllegalArgumentException("IN FORMULA: " + this.GetFormulaId() + " -- Invalid number of elements in the incoming input array.");
        
        // If the array values can not be parsed to a numerical value, throw an invalid argument exception
        try{
        	
            // Convert the vars to a format we can use
            this._tempArrayDoubleConversion(vars);
            
        } catch( IllegalArgumentException e ) { //TODO: Is this okay?
        	
            throw new IllegalArgumentException("IN FORMULA: " + this.GetFormulaId() + " -- The input variables array could not be parsed into a numerical value. Message: " + e.getMessage());
        
        }
        
        try {
        	
            // Validate expression, then evaluate expression and get double result
            double out = this._process();
            
            // Clear our temp array to 0d elements
            this._clearTempArray();
            
            // Return our double result for casting to other numerical objects
            return out;
            
        } catch ( Exception e ) {
        	
            // If an exception was thrown, the Expression is invalid and something is wrong.
            throw new IllegalStateException( "IN FORMULA: " + this.GetFormulaId() + " -- The formula's Exp4j expression is invalid. Message: " + e.getMessage() );
            
        }
    } 
    
    /**
     * Adapted expression calculator using Double Arrays
     * @param vars	A Double array of the input values for the formula's expression.
     * @return double	The result of evaluating the formula's expression in double format.
     * @throws IllegalArgumentException	If there is an invalid number of elements in the incoming input array.
     * @throws IllegalStateException	If the formula's Exp4j Expression is invalid.
     * @author Christopher Howard
     * @author Chelsea Hunter
     */
    private double _calculateExpression( Double[] vars ) 
    		throws IllegalArgumentException 
    {
    	
  	  // If the array is the wrong size throw an exception
      if( vars.length != this._formulaInputArray.length )
      {

          throw new IllegalArgumentException("Invalid number of elements in the incoming input array.");
          
      }
      
      // If the array values can not be parsed to a numerical value, throw an invalid argument exception
      try{
    	  
          // Convert the vars to a format we can use
          this._tempArrayDoubleConversion(vars); 

          // Validate expression, then evaluate expression and get double result
          double out = this._process();
          
          // Clear our temp array to 0d elements
          this._clearTempArray();
          
          // Return our double result for casting to other numerical objects
          return out;
          
      }catch (Exception e) {
    	  
          // If an exception was thrown, the Expression is invalid and something is wrong.
          throw new IllegalStateException("The Formula's Exp4j Expression is invalid.");
          
      }
  } 
    
    /**
     * Gets the Double result of calculating the Formula object's Exp4j Expression.
     * @param vars	The Variable Number objects with the desired input values in array format.
     * @return Double	The result of calculating the Formula object's Expression in Double format.
     * @throws IllegalArgumentException	If the evaluation of the formula's expression fails.
     * @author Chelsea Hunter
     */
    public Double CalculateToDouble( IVariable<? extends Number>[] vars )
		   throws IllegalArgumentException
	    {
	    	try {
	    		return new Double( this._calculateExpression(vars) );
	    	}
	    	catch( IllegalArgumentException eIAE ) {
	    		throw new IllegalArgumentException("IN FORMULA: " + this.GetFormulaId() + " -- The formula's expression could not be evaluated.");
	    	}
	    }
    
    /**
     * Gets a Double Array result of calculating the Formula object's Exp4j Expression
     * @param vars	The Variable objects with the desired input values in array format.
     * @param ArrayPresent	A boolean that says whether or not an input of array-type is present in an array of Variables to be used for input.
     * @return Double[]	The Double array result of calculating the formula's expression.
     * @throws ClassCastException	If some array cannot be classified as a Double array.
     * @throws IllegalStateException	If there is no array input type detected in the Variable object input array when the ArrayPresent boolean is true.
     * @throws IllegalArgumentException	If some Variable's input, of type Array, has a type that is not numerical, or if array-type inputs from the Variable object array are not all of the same size.
     * @throws NullPointerException	If the pointer to an array or an index is null.
     * @throws IndexOutOfBoundsException	If, when making an argument matrix, there is some error with the indices. 
     * @author Christopher Howard
     */
    public Double[] CalculateToDouble( IVariable<?>[] vars, 
    								   boolean ArrayPresent
    								   ) 
    	   throws ClassCastException,
    	   		  IllegalStateException,
    	   		  IllegalArgumentException,
    	   		  NullPointerException,
    	   		  IndexOutOfBoundsException
    {
    	
    	// If the flag is false then we need to just generate a Double
    	// and place in a single item array to complete the contract.
    	if( !ArrayPresent ) 
    	{
    		Double[] ret = new Double[1];
    		
    		try {
    			
    			ret[0] = CalculateToDouble( ( (IVariable<? extends Number>[]) vars ) );
    			
    		}catch ( ClassCastException eCCE ) {
    			
    			throw eCCE;
    			
    		}
    		
    		return ret;
    	}
    	
    	// If the flag is true we need to start the nasty procedure of detecting mixed
    	// singles and arrays and handle accordingly.
    	
    	// Ordered mapping to track processing through iteration
    	TreeMap< Integer, Double[] > setup = new TreeMap<>();
    	
    	int len = -1;
    	
    	// Find the first array and grab it's length value
    	for(IVariable<?> var: vars) {
    		
    		if( var.GetValue().getClass().isArray() ) 
    		{
    			
    			len = ( (Object[]) var.GetValue()).length;
    			
    			break;
    			
    		}
    		
    	}
    	
    	// If no array detected we are in an illegal state.
    	if(len == -1)
    		throw new IllegalStateException("IN FORMULA: " + this.GetFormulaId() + " -- Call to CalculateToDouble for Array Type has no Arrays.");
    	
    	// Initialize the ordering counter
    	Integer order = 0;
    	
    	// Detect and handle the setup of arrays for matrix processing
    	for(IVariable<?> var: vars) 
    	{
    		
    		// Array Detection
    		if( var.GetValue().getClass().isArray() ) 
    		{
    			
    			// Check that the array is numerical in nature using reflection
    			if( !Number.class.isAssignableFrom( var.GetValue().getClass().getComponentType() ) )
    				
    				//if not throw IllegalArgumentException
    				throw new IllegalArgumentException("IN FORMULA: " + this.GetFormulaId() + " -- Array of non-numerical type detected.");
    			
    			// generate the Double array in the force casted value size
    			Double[] d = new Double[((Number[])var.GetValue()).length];
    			
    			for( int i=0;
    					 i<= ( (Number[]) var.GetValue() ).length-1;
    					 i++
    				) 
    			{
    				
    				// Force cast and convert to double storing in the temp array
    				d[i] = ( (Number[]) var.GetValue() )[i].doubleValue();
    				
    			}
    			
    			try {
    				
    				// add to the setup map
        			setup.put(order, d);
        			
    			}
    			catch( ClassCastException eCCE ) {
    				throw eCCE;
    			}
    			catch( NullPointerException eNPE ) {
    				throw eNPE;
    			}
    			
    			
    		} else {
    			
    			// Convert singleton to array double
    			Double[] single = this._singleToDoubleArray(((Number)var.GetValue()).doubleValue(), len);
    			
    			try {
    				
    				setup.put(order, single);
    			
	    		}
				catch( ClassCastException eCCE ) {
					throw eCCE;
				}
				catch( NullPointerException eNPE ) {
					throw eNPE;
				}
    			
    			
    		}
    		
    		// increment the order counter
    		order++;
    		
    	}
    	
    	// Check matrix calculation compatibility
    	if( !this._lenCompatCheck( setup.values() ) )
    		
    		throw new IllegalArgumentException("IN FORMULA: " + this.GetFormulaId() + " -- Incompatible Matricies Detected.");
    	
    	
    	// Setup the output double array
    	Double[] out = new Double[len];
    	
    	// Setup the array of arguments to process
    	Double[][] in = new Double[len][setup.size()];

    	try {
    		
	    	// Loop the map ordering to create an arguments matrix of IxJ size
	    	int i = 0, j = 0;
	    	
	    	for( i = 0; 
	    		 i <= setup.size() - 1; 
	    		 i++
	    	   ) 
	    	{
	    		
	    		for( j = 0; 
	    			 j <= setup.get(i).length - 1; 
	    			 j++
	    		   ) 
	    		{
	    			in[j][i] = setup.get(i)[j];
	    		}
	    		
	    	}
	    	
	    	// Process each argument row into the output array
	    	for( i=0; 
	    		 i<=in.length-1; 
	    		 i++
	    	   ) {
	    		
	    		out[i] = this._calculateExpression(in[i]);
	    		
	    	}
	    	
    	}
    	catch ( NullPointerException eNPE ) {
    		throw eNPE;
    	}
    	catch ( IndexOutOfBoundsException eIOOBE ) {
    		throw eIOOBE;
    	}
    	
    	// Return the matrix answer
    	return out;
    	
    }
    
    /**
     * Verifies that array lengths are the same for matrix
     * processing preparation.
     * @param items	A collection of Double arrays.
     * @return boolean	true	If all the arrays in the collection "items" are of the same size and therefore are compatible.
     * @return boolean	false	If an array in the collection "items" is not the same size as the other arrays given, and is therefore incompatible.
     */
    private boolean _lenCompatCheck( Collection<Double[]> items ) 
    {
    	
    	// Initialize len check as negative to
    	// tell the loop the first len hasn't been detected
    	int len = -1;
    	
    	// Iterate over all the arrays
    	for( Double[] item: items ) 
    	{
    		
    		// If the len is less than 0 then set it
    		// to the first arrays length
    		if(len < 0) 
    		{
    			
    			len = item.length;
    			continue;
    			
    		} else {
    			
    			// If a non-compatable array is detected return false
    			if( item.length != len ) 
    			{
    				
    				return false;
    				
    			}
    		}
    	}
    	
    	// All arrays compatible, return true;
    	return true;
    	
    }
    
    
    
    /**
     * Converts a single value item into a Double Array for equal items
     * for ease of use in formula processing of mixed variable types.
     * @param value	A single Double value to start with that will populate the entire Double array.
     * @param size	An integer that declares what size the Double array should be.
     * @return Double[]	A double array populated with the single Double value for use in processing mixed-type Variable inputs.
     * @author Christopher Howard
     */
    private Double[] _singleToDoubleArray( Double value, int size ) 
    {
    	
    	// Set up the double array
    	Double[] d = new Double[size];
    	
    	// Populate with the singleton
    	for( int i=0;
    			 i<=size-1;
    			 i++
    	   ) 
    	{
    		
    		d[i] = value;
    		
    	}
    	
    	// Return the array
    	return d;
    	
    }
    
    /**
     * Gets the Integer result of calculating the Formula object's Exp4j Expression.
     * @author Chelsea Hunter
     * @param vars	The Variable Number objects with the desired input values in array format.
     * @return Integer	The result of calculating the Formula object's Expression in Integer format.
     * @throws IllegalArgumentException	If the evaluation of the formula's expression fails.
     */
    public Integer CalculateToInteger( IVariable<? extends Number>[] vars ) 
    	   throws IllegalArgumentException
    {
    	try {
    		return new Integer( ( new Double( this._calculateExpression(vars) ) ).intValue() );
    	}
    	catch( IllegalArgumentException eIAE ) {
    		throw new IllegalArgumentException("IN FORMULA: " + this.GetFormulaId() + " -- The formula's expression could not be evaluated.");
    	}
    	
    	
    }
    
    /**
     * Gets an Integer Array result from the Formula Results
     * @param vars	The Variable objects with the desired input values in array format.
	 * @param ArrayPresent	A boolean that says whether or not an input of array-type is present in an array of Variables to be used for input.
     * @return Integer[]	The Integer array result of calculating the formula's expression.
     * @throws ClassCastException	If some array cannot be classified as a Double or Integer array.
     * @throws IllegalStateException	If there is no array input type detected in the Variable object input array when the ArrayPresent boolean is true.
     * @throws IllegalArgumentException	If some Variable's input, of type Array, has a type that is not numerical, or if array-type inputs from the Variable object array are not all of the same size.
     * @throws NullPointerException	If the pointer to an array or an index is null.
     * @throws IndexOutOfBoundsException	If, when making an argument matrix, there is some error with the indices. 
     * @author Christopher Howard
     */
    public Integer[] CalculateToInteger( IVariable<?>[] vars, 
						   				 boolean ArrayPresent
						   			   ) 
			throws  ClassCastException,
					IllegalStateException,
					IllegalArgumentException,
					NullPointerException,
					IndexOutOfBoundsException
    {
    	try {
    		
	    	Double[] d = this.CalculateToDouble(vars, ArrayPresent);
	    	
	    	Integer[] out = new Integer[d.length];
	    	
	    	for(int i = 0; i <= d.length-1; i++) 
	    	{
	    		
	    		out[i] = d[i].intValue();
	    		
	    	}
	    	
	    	return out;
    	}
    	catch ( ClassCastException eCCE) 			{ throw eCCE;   }
    	catch ( IllegalStateException eISE ) 		{ throw eISE;   }
    	catch ( IllegalArgumentException eIAE )		{ throw eIAE;   }
    	catch ( NullPointerException eNPE )			{ throw eNPE;   }
    	catch ( IndexOutOfBoundsException eIOOBE)	{ throw eIOOBE; }
    		
    	
    	
    }
    
    /**
     * Gets the Float result of calculating the Formula object's Exp4j Expression.
     * @author Chelsea Hunter
     * @param vars	The Variable objects with the desired input values in array format.
     * @return Float	The result of calculating the Formula object's Expression in Float format.
     * @throws IllegalArgumentException If the evaluation of the formula's expression fails.
     */
    public Float CalculateToFloat(IVariable<? extends Number>[] vars)
		   throws IllegalArgumentException
	    {
	    	try {
	    		return new Float( ( new Double( this._calculateExpression(vars) ) ).floatValue() );
	    	}
	    	catch( IllegalArgumentException eIAE ) {
	    		throw new IllegalArgumentException("IN FORMULA: " + this.GetFormulaId() + " -- The formula's expression could not be evaluated.");
	    	}
	    	
	    	
	    }
    /**
     * Gets a Float Array result from the Formula Results
     * @param vars	The Variable objects with the desired input values in array format.
     * @param ArrayPresent	A boolean that says whether or not an input of array-type is present in an array of Variables to be used for input.
     * @return Float[]	The Float array result of calculating the formula's expression.
     * @throws ClassCastException	If some array cannot be classified as a Double or Float array.
     * @throws IllegalStateException	If there is no array input type detected in the Variable object input array when the ArrayPresent boolean is true.
     * @throws IllegalArgumentException	If some Variable's input, of type Array, has a type that is not numerical, or if array-type inputs from the Variable object array are not all of the same size.
     * @throws NullPointerException	If the pointer to an array or an index is null.
     * @throws IndexOutOfBoundsException	If, when making an argument matrix, there is some error with the indices. 
     * @return
     */
    public Float[] CalculateToFloat( IVariable<?>[] vars, 
								 	 boolean ArrayPresent
    							   ) 
    	   throws   ClassCastException,
					IllegalStateException,
					IllegalArgumentException,
					NullPointerException,
					IndexOutOfBoundsException
    {
    	try {
    		
	    	Double[] d = this.CalculateToDouble( vars, ArrayPresent ); 
	    	
	    	Float[] out = new Float[d.length];
	    	
	    	for(int i = 0; i <= d.length-1; i++) 
	    	{
	    		
	    		out[i] = d[i].floatValue();
	    		
	    	}
	    	
	    	return out;
	    	
    	}
    	catch ( ClassCastException eCCE) 			{ throw eCCE;   }
    	catch ( IllegalStateException eISE ) 		{ throw eISE;   }
    	catch ( IllegalArgumentException eIAE )		{ throw eIAE;   }
    	catch ( NullPointerException eNPE )			{ throw eNPE;   }
    	catch ( IndexOutOfBoundsException eIOOBE)	{ throw eIOOBE; }
    
    }
    
    /**
     * Gets the Long result of calculating the Formula object's Exp4j Expression.
     * @param vars	The Variable objects with the desired input values in array format.
     * @return Long	The result of calculating the Formula object's Expression in Long format.
     * @throws IllegalArgumentException	If the evaluation of the formula's expression fails.
     * @author Chelsea Hunter
     */
    public Long CalculateToLong(IVariable<? extends Number>[] vars)
		   throws IllegalArgumentException
	    {
	    	try {
	    		return new Long( ( new Double( this._calculateExpression(vars) ) ).longValue() );
	    	}
	    	catch( IllegalArgumentException eIAE ) {
	    		throw new IllegalArgumentException("IN FORMULA: " + this.GetFormulaId() + " -- The formula's expression could not be evaluated.");
	    	}
	    	
	    	
	    }
    
    /**
     * Gets a Long Array result from the Formula Results
     * @param ArrayPresent	A boolean that says whether or not an input of array-type is present in an array of Variables to be used for input.
     * @return Float[]	The Float array result of calculating the formula's expression.
     * @throws ClassCastException	If some array cannot be classified as a Double or Float array.
     * @throws IllegalStateException	If there is no array input type detected in the Variable object input array when the ArrayPresent boolean is true.
     * @throws IllegalArgumentException	If some Variable's input, of type Array, has a type that is not numerical, or if array-type inputs from the Variable object array are not all of the same size.
     * @throws NullPointerException	If the pointer to an array or an index is null.
     * @throws IndexOutOfBoundsException	If, when making an argument matrix, there is some error with the indices. 
     * @author Christopher Howard
     */
    public Long[] CalculateToLong( IVariable<?>[] vars, 
		 	 					   boolean ArrayPresent
			   				     ) 
		   throws   ClassCastException,
		   			IllegalStateException,
		   			IllegalArgumentException,
		   			NullPointerException,
		   			IndexOutOfBoundsException
    {
    	try {
    		
    	Double[] d = this.CalculateToDouble(vars, ArrayPresent);
    	
    	Long[] out = new Long[d.length];
    	
    	for(int i = 0; i <= d.length-1; i++) 
    	{
    		
    		out[i] = d[i].longValue();
    		
    	}
    	
    	return out;
    	
    	}
    	catch ( ClassCastException eCCE) 			{ throw eCCE;   }
    	catch ( IllegalStateException eISE ) 		{ throw eISE;   }
    	catch ( IllegalArgumentException eIAE )		{ throw eIAE;   }
    	catch ( NullPointerException eNPE )			{ throw eNPE;   }
    	catch ( IndexOutOfBoundsException eIOOBE)	{ throw eIOOBE; }
    	
    }
    
    /**
    * Populates the temporary input array with doubles of the input values from the incoming Variable object array.
    * @param vars	The Variable objects with the desired input values in array format.
    * @throws NullPointerException	If a pointer to some variable is null.
    * @throws IndexOutOfBoundsException	If there is an error in the temporary input array's indices.
    * @author Christopher E. Howard
    */
    private void _tempArrayDoubleConversion( IVariable<? extends Number>[] vars ) 
    		throws NullPointerException, IndexOutOfBoundsException 
    {
   
        int i = 0;
        try{
        	for( IVariable<? extends Number> var: 
        									 vars
        		)
        	{
        		
        		this._formulaInputArray[i] = var.GetValue().doubleValue(); 

        		i++;
        		
        	}
        }
        catch( NullPointerException eNPE ){
        	throw eNPE;
        }catch( IndexOutOfBoundsException eIOOBE ) {
        	throw eIOOBE;
        }
        
    }
    
    /**
     * Populates the temporary array with doubles of the input values from incoming Double array
     * @param vars	The Double objects with the desired input values in array format.
     * @throws NullPointerException	If a pointer to some variable is null.
     * @throws IndexOutOfBoundsException	If there is an error in the temporary input array's indices.
     * @author Christopher Howard
     * @author Chelsea Hunter
     */
    private void _tempArrayDoubleConversion(Double[] vars)
    		throws NullPointerException,
    			   IndexOutOfBoundsException
    {
    	
        int i = 0;
        
        try{
        	
        	for(Double var : vars){
        		
        		this._formulaInputArray[i] = var;
        		
        		i++;
        		
        	}
        	
        }
        catch( IndexOutOfBoundsException eIOOBE )	{ throw eIOOBE; }
        catch( NullPointerException eNPE )			{ throw eNPE; 	}
    }
        
    // Initialize a loop counter so we can tell which index we are on
    // == Almost always takes on the format "int i = 0"
    // Loop through the variables and convert them to doubles, place them into array
    // == Almost always a for or foreach iterative loop
    // increase the index number to the next array slot
    // == Almost always takes the form "i++" or "++i"
    // if there's a problem we need to throw an exception
    // == Almost always means we wrap our process in a try catch block and spit the exception back to the user
    
    /**
     * Sets the Exp4j Expression variables to the proper values from the temporary input array, validates the Expression,
     * then returns the result of evaluating the expression.
     * @return double	The result of evaluating the formula's expression, in double format.
     * @throws IllegalStateException	If the expression fails to validate.
     * @throws IllegalArgumentException	If the expression fails to evaluate.
     * @throws RuntimeException	If the expression fails to evaluate.
     * @author Chelsea Hunter
     * @author Christopher Howard
     */
    private double _process() 
    		throws IllegalStateException,
    			   IllegalArgumentException,
    			   RuntimeException
    {
    	
    	// For every String in our ArrayList of variable names, set variablename to corresponding value in the input array.
    	// These should be inherently ordered by the nature of the cascade map.
	   for (int i=0; i <= this._formulaVariableNames.size()-1; i++) 
	   {
		   
		   //System.out.println("Var "+this._formulaVariableNames.get(i)+" to "+this._formulaInputArray[i]);
		   this._formulaExpression.setVariable(this._formulaVariableNames.get(i), this._formulaInputArray[i]);
		   
	   }
	   
 	   // Create a ValidationResult object for the formula expression to test upon.
 	   ValidationResult _formulaExpressionValidation = this._formulaExpression.validate();
 	   
 	   // If .isValid() returns false, the Expression is invalid and therefore illegal.
 	   if (_formulaExpressionValidation.isValid() != true) 
 	   {
 		   this._clearTempArray();
 		   throw new IllegalStateException("IN FORMULA: " + this.GetFormulaId() + " -- Expression failed to validate.");
 	   }
 	   
 	   // Try to evaluate the expression if basic validation is a success. If the evaluation fails here, it is mostly likely a mathematical issue.
 	   try {
 		   
 		   return this._formulaExpression.evaluate();
 		   
 	   } catch(IllegalArgumentException eRTE) {
 		   
 		   throw eRTE;
 		   
 	   } catch( RuntimeException eIAE) {
 		   
 		   throw eIAE;
 		   
       }finally {
    	   
 		   this._clearTempArray();
 		   
 	   }
    }
    
    /**
     * Method to clear the temporary variables array by setting all elements to double 0.
     * @author Christopher E. Howard
     */
    private void _clearTempArray()
    {
    	
    	// Set all values to 0, indexes are valued 0..n-1
        for(int i=0; i <= this._formulaInputArray.length-1; i++){
        	
            this._formulaInputArray[i] = 0d; 
            
        }
        
    }
    
    /**
     * Gets the formula name.
     * @return The formula name (String).
     */
    public String GetFormulaName()
    {
        return this._formulaName;
    }
    
    /**
     * Gets the formula description.
     * @return The formula description (String).
     */
    public String GetFormulaDesc()
    {
        return this._formulaDesc;
    }
    
    /**
     * Gets the formula id.
     * @return The formula id (String).
     */
    public String GetFormulaId()
    {
        return this._formulaId;
    }
    
    /**
     * Gets the formula base equation.
     * @return The formula base equation (String).
     */
    public String GetFormulaEquation()
    {
        return this._formulaEquation;
    }
    
    /**
     * Gets the formula expression variable names.
     * @return The names of variables in the formula expression (ArrayList<String>)
     */
    public ArrayList<String> GetFormulaExpressionVariableNames() 
    {
    	return this._formulaVariableNames;
    }
    
    /**
     * Gets the formula variable input array's size.
     * @return The size of the formula variable input array (Integer).
     */
    public Integer GetFormulaInputArraySize()
    {
        return new Integer( this._formulaInputArray.length );
    }
}