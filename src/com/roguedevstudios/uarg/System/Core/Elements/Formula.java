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
import net.objecthunter.exp4j.function.*;
import net.objecthunter.exp4j.operator.*;
import net.objecthunter.exp4j.tokenizer.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formula {
    /* Class Attributes */

    /* The name meta of a formula */
    private String _formulaName;
    /* The description of a formula */
    private String _formulaDesc;
    /* The ID of a formula */
    private String _formulaId;
    /* The base equation this formula uses */
    private String _formulaEquation;
    /* The exp4j expression of the formula object*/
    private Expression _formulaExp4jExpression; // Does this need a getter?
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
        this._formulaExp4jExpression = _buildExpression();
        // Validate new exp4j expression here
        // if validate unsuccessful then throw and abort?
        // if success continue
        // ==See what to do for this in terms of how to do
        this._formulaInputArray = new double[this._inputCount()];
    }
    
    /**
     * A method to build an exp4j expression for a formula object,
     * given that a valid formula equation was input by the configuration file.
     * @throws An exception if _formulaEquation cannot be parsed.
     * @return A new exp4j expression to be re-used by the object.
     */
    private Expression _buildExpression() {
    	// Expression e = new ExpressionBuilder(this._formulaEquation)
    		//RegEx should separate _variableX_ between operators or functions
    		//Make an expression variable for _variableX_
    		//Parse operator or function into expression
    		//Do as many times as needed
    		//==(Exp4j may be able to do this without any RegEx?)
    		//==Are we making this a new string to use in builder oooor?
    		//==Either way, once done setting up
    		//.build
    	// Return e
    }
    
    /**
    * Method that counts the input variables in an equation and returns that number.
    * Used to initialize the formula input array size.
    * @return An integer representing the amount of input variables in an equation.
    */
    private int _inputCount () {
         /* Maybe every string in expression.getVariableNames() = one input expected
         */
        // TODO: Return an integer that is the number of inputs expected by a formula.
        return 0;
    }
    
    /**
    * Checks if array size is correct, then converts variable
    * array elements into Double format. Then it outputs the variable
    * array elements as Doubles to be processed by exp4j.
    * Finally, it cleans out the temporary array.
    * 
    * @param vars	The Variable objects with the desired input values.
    * @throws InvalidNumberOfArgumentsException	If the variable object array given does not have the correct amount of elements.
    * @throws InvalidArgumentException	If array values cannot be parsed into a numerical value.
    */
    public Integer processToInteger(Variable<?>[] vars){
        // If the array is the wrong size throw an exception
        if(vars.length != this._formulaInputArray.length){
            throw new InvalidNumberOfArgumentsExceptionPleaseWriteMe(); // TODO: Make exception
        }
        // If the array values can not be parsed to a numerical value, throw an invalid argument exception
        try{
            // Convert the vars to a format we can use
            this._tempArrayDoubleConversion(vars);
            // Process the vars to an output of Double
            Double out = this._process(); // TODO: 23 Oct 2017: process() currently undefined
            // Clean up our temp array
            this._clearTempArray();
            // Convert the output into what was asked for and return it
            return Integer.parseInt(out);
        }
        catch(Exception e){
            throw new InvalidArgumentException(); // TODO: Make exception
        }
        //TODO:
        return null;
    }
    
    /**
    * Populate the temporary input array with doubles of the input values
    * @param vars		The Variable objects with the desired input values.
    * @throws Exception	If one of the argument values given is not capable of being parsed into a Double.
    */
    private void _tempArrayDoubleConversion(Variable<?>[] vars) throws Exception{
        int i = 0;
        try{
        	for(Variable<?> var : vars){
        		this._formulaInputArray[i] = Double.parseDouble(var.GetValue());
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
    
   private double _process() {
    	// Exp4j processing here using expression
    	// For loop
    		// For string in this.expression.getVariableNames()
    		// this.expression.setVariable(String, this._formulaInputArray[i])
    		// i++
    	// Return this.expression.evaluate()
    }
    
    /**
     * Method to clear the temporary variables array.
     * Called by processToInteger().
     */
    private void _clearTempArray(){
        for( int i=0; i <= this._formulaInputArray.length; i++){
            this._formulaInputArray[i] = 0d; // Set element to Double 0
        }
    }
    
    /**
     * Gets the formula name.
     * @return The formula name (String).
     */
    public String GetName(){
        return this._formulaName;
    }
    
    /**
     * Gets the formula description.
     * @return The formula description (String).
     */
    public String GetDesc(){
        return this._formulaDesc;
    }
    
    /**
     * Gets the formula id.
     * @return The formula id (String).
     */
    public String GetId(){
        return this._formulaId;
    }
    
    /**
     * Gets the formula base equation.
     * @return The formula base equation (String).
     */
    public String GetEquation(){
        return this._formulaEquation;
    }
    
    /**
     * Gets the formula variable input array's size.
     * @return The size of the formula variable input array (int).
     */
    public int GetInputArraySize(){
        return this._formulaInputArray.length;
    }
}