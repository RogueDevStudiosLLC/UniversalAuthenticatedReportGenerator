package com.roguedevstudios.uarg.System.Core.Tests;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * This class is used to test Formula.java methods
 * Methods tested: Constructor, _initializeVarNames(), _buildExpression()
 * Main method for running is FVNIMain.java
 * @author Chel
 */
public class FormulaVarNameInitTest {
	// PROPERTIES OF CLASS \\
	public String _formulaEquation;
	public ArrayList<String> _formulaVariableNames;
	public Expression _formulaExpression;
	
	// METHODS OF CLASS \\
	public FormulaVarNameInitTest(String anEquation) {
		this._formulaEquation = anEquation;
		this._formulaVariableNames = this._initializeVarNames();
		this._formulaExpression = this._buildExpression();
	}
	
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
    			System.out.println("Adding element " + _formulaVarMatcher.group(i) + " to our ArrayList<String> . . ." );
    			_formulaVarNames.add(_formulaVarMatcher.group(i));
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
    		System.out.println("Setting " + s + " as an expression variable . . . ");
    		_formulaExpressionBuilder.variable(s);
    	}
    	// Once regex stuff is done and variables are set, properly build the expression.
    	Expression _formulaExpression = _formulaExpressionBuilder.build();
    	return _formulaExpression;
    }
    
    public void GetVarNames() {
    	for (int i=0; i<this._formulaVariableNames.size(); i++) {
    		System.out.println("The element in ArrayList<String>.get(" + i + ") is " + _formulaVariableNames.get(i) + ".");
    	}
    }
}
