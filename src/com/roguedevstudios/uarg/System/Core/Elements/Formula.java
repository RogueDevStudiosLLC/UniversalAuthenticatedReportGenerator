/************************************************
 * Formula Class File                           *
 * File name: Formula.java                      *
 * The class file for formulas.                *
 ***********************************************/

package com.roguedevstudios.uarg.System.Core.Elements;

import net.objecthunter.exp4j.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.*;
import net.objecthunter.exp4j.operator.*;
import net.objecthunter.exp4j.tokenizer.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormula;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;

import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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
    * equation given, and sets up
    * a Double array based off of the base equation
    * given for storing input variable object values.
    * @author Chelsea Hunter
    * @author Christopher E. Howard
    * @param formulaName	A formula's name, taken from _formulaName
    * @param formulaDesc	A formula's description, taken from _formulaDesc
    * @param formulaId		A formula's id, taken from _formulaId
    * @param formulaEquation	A formula's equation, taken from _formulaEquation
    * @throws IllegalStateException	If validation of the exp4j expression is unsuccessful.
    */
    public Formula (String formulaName, String formulaDesc, String formulaId, String formulaEquation) throws IllegalStateException{
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
        
        // TODO: Check necessity of this?
        this._formulaExpression = this._buildExpression();
        
        // Input Array Size
        this._formulaInputArray = new double[this._formulaVariableNames.size()];
        
        //System.err.println("Double Array Size: "+this._formulaInputArray.length);
        try {
        	// Bind dummy values to our temp input array
        	for (int i=0; i<=this._formulaInputArray.length-1; i++) {
        		//System.out.println("Setting index "+i);
        		this._formulaInputArray[i] = 1;
        	}
        	// Validate using our ._process() method
        	this._process();
        } catch (Exception e) {
        	//System.err.println(e.getMessage());
        	// If an exception is thrown, constructor should abort
        	throw e;
        	//	throw new IllegalStateException("The Formula's Exp4j Expression is invalid.");
        }
        // Clear our temp array from our dummy values when we're done validating.
        this._clearTempArray();
    }
    
    /**
     * A method to initialize the variable names to be used by our exp4j expression.
     * @author Chelsea Hunter
     * @return A list of variable names (ArrayList<String>)
     */
    private ArrayList<String> _initializeVarNames() {
    	// Make a new ArrayList to populate with variable names we isolate via regex.
    	ArrayList<String> _formulaVarNames = new ArrayList<String>();
    	
    	// Setup regex pattern we want to use to isolate formula variables from _formulaEquation string
    	Pattern _formulaRegex = Pattern.compile("\\s?_[a-zA-z0-9_]*_\\s?");
    	
    	// Make a matcher to get the variables out of the formula equation string given, using above pattern
    	Matcher _formulaVarMatcher = _formulaRegex.matcher(this._formulaEquation);
    	// While regex matcher can find matching values, add them to the ArrayList stripping out excess whitespace
    	while (_formulaVarMatcher.find()) {
    			_formulaVarNames.add(_formulaVarMatcher.group().replaceAll("\\s+",""));
    	}
    	//System.err.println("Var Names Array: "+_formulaVarNames.toString());
    	return _formulaVarNames;
    }
    
    /**
     * A method to build an exp4j expression for a formula object,
     * given that a valid formula equation was input by the configuration file.
     * @author Chelsea Hunter
     * @return An Exp4j Expression object for use in calculating formulas (Expression).
     */
    private Expression _buildExpression() {
    	// Make base Exp4j ExpressionBuilder using _formulaEquation string as input
    	//System.out.println(this._formulaEquation);
    	ExpressionBuilder _formulaExpressionBuilder = new ExpressionBuilder(this._formulaEquation);
    	// For every string in our ArrayList<String> of formula variable names, 
    	// set that string as a variable in our expression.
    	for (String s : this._formulaVariableNames) {
    		//System.err.println("Var Name: "+s);
    		_formulaExpressionBuilder.variable(s);
    	}
    	// Once regex stuff is done and variables are set, properly build the expression.
    	Expression _formulaExpression = _formulaExpressionBuilder.build();
    	return _formulaExpression;
    }
    
    /**
    * Gets the double result of calculating the Formula object's Exp4j Expression.
    * @author Chelsea Hunter
    * @author Christopher E. Howard
    * @param vars	The Variable objects with the desired input values in array format.
    * @throws InvalidNumberOfArgumentsException	If the variable object array given does not have the correct amount of elements.
    * @throws IllegalArgumentException	If the incoming array is the wrong size, or if values in the array cannot be parsed into a numerical value.
    * @return The result of calculating the Formula object's Expression (double).
    */
    private double _calculateExpression(IVariable<? extends Number>[] vars) throws IllegalArgumentException {
    	  // If the array is the wrong size throw an exception
        if(vars.length != this._formulaInputArray.length){
            throw new IllegalArgumentException("Invalid number of elements in the incoming input array.");
        }
        // If the array values can not be parsed to a numerical value, throw an invalid argument exception
        try{
            // Convert the vars to a format we can use
            this._tempArrayDoubleConversion(vars);
        } catch(Exception e) {
            throw new IllegalArgumentException("The input variables array could not be parsed into a numerical value.");
        }
        try {
            // Validate expression, then evaluate expression and get double result
            double out = this._process();
            // Clear our temp array to 0d elements
            this._clearTempArray();
            // Return our double result for casting to other numerical objects
            return out;
        } catch (Exception e) {
            // If an exception was thrown, the Expression is invalid and something is wrong.
            throw new IllegalStateException("The Formula's Exp4j Expression is invalid.");
        }
    } 
    
    /**
     * Adapted expression calculator using Double Arrays
     * @param vars
     * @return
     * @throws IllegalArgumentException
     * @author Christopher Howard
     * @author Chelsea Hunter
     */
    private double _calculateExpression(Double[] vars) throws IllegalArgumentException {
  	  // If the array is the wrong size throw an exception
      if(vars.length != this._formulaInputArray.length){
    	  //System.err.println(vars.length + " =/= " + this._formulaInputArray.length + "Inputs: " + vars[2]);
          throw new IllegalArgumentException("Invalid number of elements in the incoming input array.");
      }
      // If the array values can not be parsed to a numerical value, throw an invalid argument exception
      try{
          // Convert the vars to a format we can use
          this._tempArrayDoubleConversion(vars);
      } catch(Exception e) {
          throw new IllegalArgumentException("The input doubles array could not be parsed into a numerical value.");
      }
      try {
          // Validate expression, then evaluate expression and get double result
          double out = this._process();
          // Clear our temp array to 0d elements
          this._clearTempArray();
          // Return our double result for casting to other numerical objects
          return out;
      } catch (Exception e) {
          // If an exception was thrown, the Expression is invalid and something is wrong.
          throw new IllegalStateException("The Formula's Exp4j Expression is invalid.");
      }
  } 
    
    /**
     * Gets the Double result of calculating the Formula object's Exp4j Expression.
     * @author Chelsea Hunter
     * @param vars	The Variable objects with the desired input values in array format.
     * @return The result of calculating the Formula object's Expression in Double format.
     */
    public Double CalculateToDouble(IVariable<? extends Number>[] vars) {
    	return new Double(this._calculateExpression(vars));
    }
    
    /**
     * Gets a Double Array result of calculating the Formula object's Exp4j Expression
     * @param vars
     * @param ArrayPresent
     * @return Double[]
     * @author Christopher Howard
     */
    public Double[] CalculateToDouble(IVariable<?>[] vars, boolean ArrayPresent) {
    	// If the flag is false then we need to just generate a Double
    	// and place in a single item array to complete the contract.
    	if(!ArrayPresent) {
    		Double[] ret = new Double[1];
    		ret[0] = CalculateToDouble((IVariable<? extends Number>[]) vars);
    		return ret;
    	}
    	// If the flag is true we need to start the nasty procedure of detecting mixed
    	// singles and arrays and handle accordingly.
    	
    	// Ordered mapping to track processing through iteration
    	TreeMap<Integer, Double[]> setup = new TreeMap<>();
    	int len = -1;
    	// Find the first array and grab it's length value
    	for(IVariable<?> var: vars) {
    		if(var.GetValue().getClass().isArray())
    			len = ((Object[])var.GetValue()).length;
    		break;
    	}
    	// If no array detected we are in an illegal state.
    	if(len == -1)
    		throw new IllegalStateException("Call to CalculateToDouble for Array Type has no Arrays.");
    	// Initialize the ordering counter
    	Integer order = 0;
    	// Detect and handle the setup of arrays for matrix processing
    	for(IVariable<?> var: vars) {
    		// Array Detection
    		if(var.GetValue().getClass().isArray()) {
    			// Check that the array is numerical in nature using reflection
    			if(!Number.class.isAssignableFrom(var.GetValue().getClass().getComponentType()))
    				//if not throw IllegalArgumentException
    				throw new IllegalArgumentException("Array of non-numerical type detected.");
    			// generate the Double array in the force casted value size
    			Double[] d = new Double[((Number[])var.GetValue()).length];
    			for(int i=0;i<=((Number[])var.GetValue()).length-1;i++) {
    				// Force cast and convert to double storing in the temp array
    				d[i] = ((Number[])var.GetValue())[i].doubleValue();
    			}
    			// add to the setup map
    			setup.put(order, d);
    		}else {
    			// Convert singleton to array double
    			Double[] single = this._singleToDoubleArray(((Number)var.GetValue()).doubleValue(), len);
    			setup.put(order, single);
    		}
    		// increment the order counter
    		order++;
    	}
    	
    	// Check matrix calculation compatibility
    	if(!this._lenCompatCheck(setup.values()))
    		throw new IllegalArgumentException("Incompatible Matricies Detected.");
    	
    	// Setup the output double array
    	Double[] out = new Double[len];
    	
    	// Setup the array of arguments to process
    	Double[][] in = new Double[len][setup.size()];

    	// Loop the map ordering to create an arguments matrix of IxJ size
    	int i = 0, j = 0;
    	for( i = 0; i <= setup.size() - 1; i++) {
    		for( j = 0; j <= setup.get(i).length - 1; j++) {
    			in[j][i] = setup.get(i)[j];
    		}
    	}
    	
    	// Process each argument row into the output array
    	for( i=0; i<=in.length-1; i++) {
    		out[i] = this._calculateExpression(in[i]);
    	}
    	
    	// Return the matrix answer
    	return out;
    }
    
    /**
     * Verifies that array lengths are the same for matrix
     * processing prep.
     * @param items
     * @return boolean
     */
    private boolean _lenCompatCheck(Collection<Double[]> items) {
    	// Initialize len check as negative to
    	// tell the loop the first len hasn't been detected
    	int len = -1;
    	// Iterate over all the arrays
    	for(Double[] item: items) {
    		// If the len is less than 0 then set it
    		// to the first arrays length
    		if(len < 0) {
    			len = item.length;
    			continue;
    		}else {
    			// If a non-compatable array is detected return false
    			if(item.length != len) {
    				//System.err.println("Length Max = "+len+", Length Found = "+item.length);
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
     * @param value
     * @param size
     * @return Double[]
     * @author Christopher Howard
     */
    private Double[] _singleToDoubleArray(Double value, int size) {
    	// Set up the double array
    	Double[] d = new Double[size];
    	// Populate with the singleton
    	for(int i=0;i<=size-1;i++) {
    		d[i] = value;
    	}
    	// Return the array
    	return d;
    }
    
    /**
     * Gets the Integer result of calculating the Formula object's Exp4j Expression.
     * @author Chelsea Hunter
     * @param vars	The Variable objects with the desired input values in array format.
     * @return The result of calculating the Formula object's Expression in Integer format.
     */
    public Integer CalculateToInteger(IVariable<? extends Number>[] vars) {
    	return new Integer((int)this._calculateExpression(vars));
    }
    
    /**
     * Gets an Integer Array result from the Formula Results
     * @param vars
     * @param ArrayPresent
     * @return Integer[]
     * @author Christopher Howard
     */
    public Integer[] CalculateToInteger(IVariable<?>[] vars, boolean ArrayPresent) {
    	Double[] d = this.CalculateToDouble(vars, ArrayPresent);
    	Integer[] out = new Integer[d.length];
    	for(int i = 0; i <= d.length-1; i++) {
    		out[i] = d[i].intValue();
    	}
    	return out;
    }
    
    /**
     * Gets the Float result of calculating the Formula object's Exp4j Expression.
     * @author Chelsea Hunter
     * @param vars	The Variable objects with the desired input values in array format.
     * @return The result of calculating the Formula object's Expression in Float format.
     */
    public Float CalculateToFloat(IVariable<? extends Number>[] vars) {
    	return new Float((float)this._calculateExpression(vars));
    }
    
    /**
     * Gets a Float Array result from the Formula Results
     * @param vars
     * @param ArrayPresent
     * @return
     */
    public Float[] CalculateToFloat(IVariable<?>[] vars, boolean ArrayPresent) {
    	Double[] d = this.CalculateToDouble(vars, ArrayPresent);
    	Float[] out = new Float[d.length];
    	for(int i = 0; i <= d.length-1; i++) {
    		out[i] = d[i].floatValue();
    	}
    	return out;
    }
    
    /**
     * Gets the Long result of calculating the Formula object's Exp4j Expression.
     * @author Chelsea Hunter
     * @param vars	The Variable objects with the desired input values in array format.
     * @return The result of calculating the Formula object's Expression in Long format.
     */
    public Long CalculateToLong(IVariable<? extends Number>[] vars) {
    	return new Long((long)this._calculateExpression(vars));
    }
    
    public Long[] CalculateToLong(IVariable<?>[] vars, boolean ArrayPresent) {
    	Double[] d = this.CalculateToDouble(vars, ArrayPresent);
    	Long[] out = new Long[d.length];
    	for(int i = 0; i <= d.length-1; i++) {
    		out[i] = d[i].longValue();
    	}
    	return out;
    }
    
    /**
    * Populates the temporary input array with doubles of the input values from the incoming Variable object array.
    * @author Christopher E. Howard
    * @param vars		The Variable objects with the desired input values in array format.
    * @throws Exception	If one of the argument values given is not capable of being parsed into a Double.
    */
    private void _tempArrayDoubleConversion(IVariable<? extends Number>[] vars) throws Exception {
    	//System.err.println("VarsCount: "+vars.length);
        int i = 0;
        try{
        	for(IVariable<? extends Number> var : vars){
        		//System.out.println(var.GetValue());
        		
        		this._formulaInputArray[i] = var.GetValue().doubleValue(); 
        		//System.err.println(this._formulaInputArray[i]);
        		i++;
        	}
        }
        catch(Exception e){
        	e.printStackTrace();
        	System.err.println(e.getMessage());
        	throw e;
        }
    }
    
    /**
     * Populates the temporary array with doubles of the input values from incoming Doubles Array
     * @param vars
     * @throws Exception
     * @author Christopher Howard
     * @author Chelsea Hunter
     */
    private void _tempArrayDoubleConversion(Double[] vars) throws Exception {
        int i = 0;
        try{
        	for(Double var : vars){
        		this._formulaInputArray[i] = var; //TODO: resolve this
        		i++;
        	}
        }
        catch(Exception e){
        	throw e;
        }
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
     * @author Chelsea Hunter
     * @return	The result of evaluating the Formula object's Exp4j Expression, in double format.
     */
    private double _process() {
    	// For every String in our ArrayList of variable names, set variablename to corresponding value in the input array.
    	// These should be inherently ordered by the nature of the cascade map.
	   for (int i=0; i <= this._formulaVariableNames.size()-1; i++) {
		   //System.out.println("Var "+this._formulaVariableNames.get(i)+" to "+this._formulaInputArray[i]);
		   this._formulaExpression.setVariable(this._formulaVariableNames.get(i), this._formulaInputArray[i]);
	   }
 	   // Create a ValidationResult object for the formula expression to test upon.
 	   ValidationResult _formulaExpressionValidation = this._formulaExpression.validate();
 	   // If .isValid() returns false, the Expression is invalid and therefore illegal.
 	   if (_formulaExpressionValidation.isValid() != true) {
 		   this._clearTempArray();
 		   throw new IllegalStateException();
 	   }
 	   // Try to evaluate the expression if basic validation is a success. If the evaluation fails here, it is mostly likely a mathematical issue.
 	   try {
 		   //System.out.println("Evaluation: "+this._formulaExpression.evaluate());
 		   //System.out.println("Data: "+this._formulaExpression.getVariableNames().toString());
 		  //System.out.println(this._formulaExpression.);
 		   return this._formulaExpression.evaluate();
 	   } catch (Exception e) {
 		   //System.err.println(e.getMessage());
 		   throw e;
 		   //throw new ArithmeticException("Evaluation of Formula's Exp4j Expression has failed." + e.getMessage());
 	   } finally {
 		   this._clearTempArray();
 	   }
    }
    
    /**
     * Method to clear the temporary variables array by setting all elements to double 0.
     * @author Christopher E. Howard
     */
    private void _clearTempArray(){
    	// Set all values to 0, indexes are valued 0..n-1
        for(int i=0; i <= this._formulaInputArray.length-1; i++){
            this._formulaInputArray[i] = 0d; // Set element to Double 0
        }
    }
    
    /**
     * Gets the formula name.
     * @return The formula name (String).
     */
    public String GetFormulaName(){
        return this._formulaName;
    }
    
    /**
     * Gets the formula description.
     * @return The formula description (String).
     */
    public String GetFormulaDesc(){
        return this._formulaDesc;
    }
    
    /**
     * Gets the formula id.
     * @return The formula id (String).
     */
    public String GetFormulaId(){
        return this._formulaId;
    }
    
    /**
     * Gets the formula base equation.
     * @return The formula base equation (String).
     */
    public String GetFormulaEquation(){
        return this._formulaEquation;
    }
    
    /**
     * Gets the formula expression variable names.
     * @return The names of variables in the formula expression (ArrayList<String>)
     */
    public ArrayList<String> GetFormulaExpressionVariableNames() {
    	return this._formulaVariableNames;
    }
    /**
     * Gets the formula variable input array's size.
     * @return The size of the formula variable input array (Integer).
     */
    public Integer GetFormulaInputArraySize(){
        return new Integer(this._formulaInputArray.length);
    }
}