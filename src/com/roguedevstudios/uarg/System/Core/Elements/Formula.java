/************************************************
 * Formula Class File                           *
 * File name: Formula.java                      *
 * The class file for formulas.                *
 ***********************************************/

package com.roguedevstudios.uarg.System.Core.Elements;

/**
 * This class is the formula class.
 * 
 * @author Chelsea Hunter
 * @author Christopher E. Howard
 * @since 1.0
 */

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
import java.util.ArrayList;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Float;
import java.lang.Long;

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
    *
    * @param formulaName	A formula's name, taken from _formulaName
    * @param formulaDesc	A formula's description, taken from _formulaDesc
    * @param formulaId		A formula's id, taken from _formulaId
    * @param formulaEquation	A formula's equation, taken from _formulaEquation
    * @throws An exception if validation of the exp4j expression is unsuccessful.
    */
    public Formula (String formulaName, String formulaDesc, String formulaId, String formulaEquation) {
        this._formulaName = formulaName;
        this._formulaDesc = formulaDesc;
        this._formulaId = formulaId;
        this._formulaEquation = formulaEquation;
        /* Build and Validate Expression using Exp4j here*/
        this._formulaVariableNames = this._initializeVarNames();
        this._formulaExpression = this._buildExpression();
        // Validate new exp4j expression here
        // if validate unsuccessful then throw and abort?
        // if success continue
        // ==See what to do for this in terms of how to do
        this._formulaInputArray = new double[this._formulaVariableNames.size()];
        try {
        	for (int i=0; i<=this._formulaInputArray.length; i++) {
        		this._formulaInputArray[i] = 1;
        		this._validateExpression();
        	}
        } catch (Exception e) {
        		throw new IllegalStateException("The Formula's Exp4j Expression is invalid.");
        }
        this._clearTempArray();
    }
    
    /**
     * A method to initialize the variable names to be used by our exp4j expression.
     * @return A list of variable names (ArrayList<String>)
     */
    private ArrayList<String> _initializeVarNames() {
    	// Make a new ArrayList to populate with variable names we isolate via regex.
    	ArrayList<String> _formulaVarNames = new ArrayList<String>();
    	// Setup regex pattern we want to use to isolate formula variables from _formulaEquation string
    	Pattern _formulaRegex = Pattern.compile("\\s?_[a-zA-z0-9_]*_\\s?");
    	// Make a matcher to get the variables out of the formula equation string given, using above pattern
    	Matcher _formulaVarMatcher = _formulaRegex.matcher(this._formulaEquation);
    	// While regex matcher can find matching values, add them to the ArrayList
    	while (_formulaVarMatcher.find()) {
    		for (int i=_formulaVarMatcher.groupCount(); i>=0;i--) {
    			_formulaVarNames.add(_formulaVarMatcher.group(i));
    		}
    	}
    	return _formulaVarNames;
    }
    
    /**
     * A method to build an exp4j expression for a formula object,
     * given that a valid formula equation was input by the configuration file.
     * @return An Exp4j Expression object for use in calculating formulas (Expression).
     */
    //TODO: Add exceptions for nulls, bad ins, w.e.
    private Expression _buildExpression() {
    	// Make base Exp4j ExpressionBuilder using _formulaEquation string as input
    	ExpressionBuilder _formulaExpressionBuilder = new ExpressionBuilder(this._formulaEquation);
    	// For every string in our ArrayList<String> of formula variable names, 
    	// set that string as a variable in our expression.
    	for (String s : this._formulaVariableNames) {
    		_formulaExpressionBuilder.variable(s);
    	}
    	// Once regex stuff is done and variables are set, properly build the expression.
    	Expression _formulaExpression = _formulaExpressionBuilder.build();
    	return _formulaExpression;
    }
    
    /**
     * Validates an expression.
     * @throws An exception if the expression is invalid or cannot be evaluated.
     */
    private void _validateExpression() throws Exception {
 	   for (int i=0; i <= this._formulaVariableNames.size(); i++) {
		   this._formulaExpression.setVariable(this._formulaVariableNames.get(i), this._formulaInputArray[i]);
	   }
 	   ValidationResult _formulaExpressionValidation = this._formulaExpression.validate();
 	   if (_formulaExpressionValidation.isValid() != true) {
 		   throw new Exception();
 	   }
 	   try {
 		   this._formulaExpression.evaluate();
 	   } catch (Exception e) {
 		   throw e;
 	   }
    }
    /**
    * Gets the double result of calculating the Formula object's Exp4j Expression.
    * 
    * @param vars	The Variable objects with the desired input values in array format.
    * @throws InvalidNumberOfArgumentsException	If the variable object array given does not have the correct amount of elements.
    * @throws IllegalArgumentException	If array values cannot be parsed into a numerical value.
    * @return The result of calculating the Formula object's Expression (double).
    */
    private double _calculateExpression(IVariable<?>[] vars) {
    	  // If the array is the wrong size throw an exception
        if(vars.length != this._formulaInputArray.length){
            throw new IllegalArgumentException("Please write an invalid number of arguments exception Chel"); // TODO: Make exception
        }
        // If the array values can not be parsed to a numerical value, throw an invalid argument exception
        try{
            // Convert the vars to a format we can use
            this._tempArrayDoubleConversion(vars);
            try {
                // Validate before processing
                this._validateExpression();
            } catch (Exception v) {
            	throw new IllegalStateException("The Formula's Exp4j Expression is invalid.");
            }
            // Process the vars to an output of Double
            double out = this._process();
            // Clean up our temp array
            this._clearTempArray();
            // Convert the output into what was asked for and return it
            return out;
        }
        catch(Exception e){
            throw new IllegalArgumentException("The input array could not be parsed into a numerical value.");
        }
        //TODO:
        return null;
    }
    
    public Double CalculateToDouble(IVariable<?>[] vars) {
    	return new Double(this._calculateExpression(vars));
    }
    
    /**
     * Gets the Integer result of calculating the Formula object's Exp4j Expression.
     * 
     * @param vars	The Variable objects with the desired input values in array format.
     * @return The result of calculating the Formula object's Expression in Integer format.
     */
    public Integer CalculateToInteger(IVariable<?>[] vars) {
    	return new Integer((int)this._calculateExpression(vars));
    }
    
    /**
     * Gets the Float result of calculating the Formula object's Exp4j Expression.
     * 
     * @param vars	The Variable objects with the desired input values in array format.
     * @return The result of calculating the Formula object's Expression in Float format.
     */
    public Float CalculateToFloat(IVariable<?>[] vars) {
    	return new Float((float)this._calculateExpression(vars));
    }
    
    /**
     * Gets the Long result of calculating the Formula object's Exp4j Expression.
     * 
     * @param vars	The Variable objects with the desired input values in array format.
     * @return The result of calculating the Formula object's Expression in Long format.
     */
    public Long CalculateToLong(IVariable<?>[] vars) {
    	return new Long((long)this._calculateExpression(vars));
    }
    
    /**
    * Populates the temporary input array with doubles of the input values from the incoming Variable object array.
    * @param vars		The Variable objects with the desired input values in array format.
    * @throws Exception	If one of the argument values given is not capable of being parsed into a Double.
    */
    private void _tempArrayDoubleConversion(IVariable<?>[] vars) throws Exception{
        int i = 0;
        try{
        	for(IVariable<?> var : vars){
        		this._formulaInputArray[i] = Double(var.GetValue()); //TODO: resolve this
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
     * Sets the Exp4j Expression variables to the proper values from the temporary input array, then evaluates the Expression.
     * @return	The result
     */
    private double _process() {
    	// Exp4j processing here using expression
    	// For loop
    		// For string in this.expression.getVariableNames()
    		// this.expression.setVariable(String, this._formulaInputArray[i])
    		// i++
    	// Return this.expression.evaluate()
	   for (int i=0; i <= this._formulaVariableNames.size(); i++) {
		   this._formulaExpression.setVariable(this._formulaVariableNames.get(i), this._formulaInputArray[i]);
	   }
	   return this._formulaExpression.evaluate();
    }
    
    /**
     * Method to clear the temporary variables array.
     * Called by processToInteger().
     */
    private void _clearTempArray(){
        for(int i=0; i <= this._formulaInputArray.length; i++){
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
        return Integer(this._formulaInputArray.length);
    }
}