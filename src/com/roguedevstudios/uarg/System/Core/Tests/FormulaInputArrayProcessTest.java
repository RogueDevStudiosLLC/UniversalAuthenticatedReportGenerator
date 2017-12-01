package com.roguedevstudios.uarg.System.Core.Tests;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.ArrayList;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

/**
 * This class is to test the processing of input arrays by a test formula object.
 * Its main method is FIAPMain.java.
 * @author Chel
 * @since 1.0
 */
public class FormulaInputArrayProcessTest {
// THIS CLASS WILL NOT WORK IN REPO AS-IS. SIMPLY FOR REFERENCE.
	
	// CLASS PROPERTIES \\
	public String _formulaEquation;
	public ArrayList<String> _formulaVariableNames;
	public Expression _formulaExpression;
	public double[] _formulaInputArray;
	
	// CLASS CONSTRUCTOR \\
	public FormulaInputArrayProcessTest(String formulaEquation) {
		this._formulaEquation = formulaEquation;
		this._formulaVariableNames = this._initializeVarNames();
		this._formulaExpression = this._buildExpression();
		this._formulaInputArray = new double[this._formulaVariableNames.size()];
	} // end constructor
	
	// CLASS METHODS \\
	public ArrayList<String> _initializeVarNames() {
    	// Make a new ArrayList to populate with variable names we isolate via regex.
    	ArrayList<String> _formulaVarNames = new ArrayList<String>();
    	// Setup regex pattern we want to use to isolate formula variables from _formulaEquation string
    	Pattern _formulaRegex = Pattern.compile("\\s?_[a-zA-z0-9_]*_\\s?");
    	// Make a matcher to get the variables out of the formula equation string given, using above pattern
    	Matcher _formulaVarMatcher = _formulaRegex.matcher(this._formulaEquation);
    	// While regex matcher can find matching values, add them to the ArrayList
    	while (_formulaVarMatcher.find()) {
    		for (int i=_formulaVarMatcher.groupCount(); i>=0; i--) {
    			_formulaVarNames.add(_formulaVarMatcher.group(i));
    			System.out.println("~_initializeVarNames(): Added String \"" + _formulaVarMatcher.group(i) + "\" to our variable names ArrayList." );
    		}
    	}
    	return _formulaVarNames;
	}
	
	public Expression _buildExpression() {
    	// Make base Exp4j ExpressionBuilder using _formulaEquation string as input
    	ExpressionBuilder _formulaExpressionBuilder = new ExpressionBuilder(this._formulaEquation);
    	// For every string in our ArrayList<String> of formula variable names, 
    	// set that string as a variable in our expression.
    	for (String s : this._formulaVariableNames) {
    		_formulaExpressionBuilder.variable(s);
    		System.out.println("~_buildExpression(): " + s + " set as an expression variable. ");
    	}
    	// Once regex stuff is done and variables are set, properly build the expression.
    	System.out.println("~_buildExpression(): Building expression . . .");
    	Expression _formulaExpression = _formulaExpressionBuilder.build();
    	return _formulaExpression;
	}
	
	public Integer GetIntegerResult(Integer[] vars){
        // If the array is the wrong size throw an exception
        if(vars.length != this._formulaInputArray.length){
        	System.out.println("~GetIntegerResult: Size mismatch");
        	
            //throw new InvalidNumberOfArgumentsExceptionPleaseWriteMe(); // TODO: Make exception
        }
        // If the array values can not be parsed to a numerical value, throw an invalid argument exception
        try{
            // Convert the vars to a format we can use
        	System.out.println("~GetIntegerResult: Attempting to convert Integer[] to Double[] for _formulaInputArray . . .");
            this._tempArrayDoubleConversion(vars);
            // Process the vars to an output of Double
            Double out = this._process(); // TODO: 23 Oct 2017: process() currently undefined
            System.out.println("~GetIntegerResult: Variable \"out\" now has value " + out + ".");
            // Clean up our temp array
            this._clearTempArray();
            // Convert the output into what was asked for and return it
            return out.intValue();
        }
        catch(Exception e){
        	System.out.println("~GetIntegerResult: Invalid argument.");
            //throw new InvalidArgumentException(); // TODO: Make exception
        }
        //TODO:
        return null;
    } // end getintegerresult();
	
	private double _process() {
    	// Exp4j processing here using expression
    	// For loop
    		// For string in this.expression.getVariableNames()
    		// this.expression.setVariable(String, this._formulaInputArray[i])
    		// i++
    	// Return this.expression.evaluate()
		// LOGIC FIX: i MUST BE LESS THAN the size of _formulaVariableNames as ArrayList returns the actual number of elements which is indexes+1
		System.out.println("~_process(): Beginning expression processing . . .");
	   for (int i=0; i < this._formulaVariableNames.size(); i++) {
		   System.out.println("~_process(): Variable " + this._formulaVariableNames.get(i) + " set to value " + this._formulaInputArray[i] + ".");
		   this._formulaExpression.setVariable(this._formulaVariableNames.get(i), this._formulaInputArray[i]);
	   }
	   System.out.println("~_process(): Evaluating expression . . . ");
	   System.out.println("~_process(): In-method result is " + this._formulaExpression.evaluate() + ".");
	   return this._formulaExpression.evaluate();
    } // end _process
	
	private void _tempArrayDoubleConversion(Integer[] vars) throws Exception{
        int i = 0;
        try{
        	for(Integer var : vars){
        		this._formulaInputArray[i] = vars[i].doubleValue();
        		i++;
        	}
        }
        catch(Exception e){
        	throw e;
        }
        System.out.println("~_tempArrayDoubleConversion(): Conversion success!");
    } // end doubleconversion
	
	 private void _clearTempArray(){
		 // FIX: Trying to compare to Double array length does not work. Compare to ArrayList size for consistency. Once again, i must be LESS THAN size().
	     for( int i=0; i < this._formulaVariableNames.size(); i++){
	       	System.out.println("~_clearTempArray(): Clearing temp array element [" + i + "].");
	        this._formulaInputArray[i] = 0d; // Set element to Double 0
	     }
	     System.out.println("~_clearTempArray(): Temp array [0] reset to " + this._formulaInputArray[0] + ".");
	     System.out.println("~_clearTempArray(): Temp array [1] reset to " + this._formulaInputArray[1] + ".");
	 } //end cleartemparray
    	 
    	 
}
