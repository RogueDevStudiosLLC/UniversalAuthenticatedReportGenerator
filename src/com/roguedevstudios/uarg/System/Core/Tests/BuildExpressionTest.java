package com.roguedevstudios.uarg.System.Core.Tests;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chel
 * This is a class for testing the _buildExpression() method in the Formula Class.
 */
public class BuildExpressionTest {
	
	public String anEquation;
	public Expression anExpression;
	
	public BuildExpressionTest (String someEquation) {
		this.anEquation = someEquation;
		this.anExpression = _buildExpression();
	} // End BuildExpressionTest Constructor
	/**
	 * A method to build an expression object from variables parsed from an equation.
	 * @return _formulaExpression	An Expression object containing variables parsed from an equation string.
	 */
    public Expression _buildExpression() {
    	// Make base Exp4j ExpressionBuilder using _formulaEquation string as input
    	ExpressionBuilder _formulaExpressionBuilder = new ExpressionBuilder(this.anEquation);
    	// Setup regex pattern we want to use to isolate formula variables from _formulaEquation string
    	// ==In terms of modularity, should we keep the regex string we use as a field for formulas that can be changed by config? Dunno, probably not, would be interesting though
    	Pattern _formulaRegex = Pattern.compile("\\s?_[a-zA-z0-9_]*_\\s?");
    	// Make a matcher to get the variables out of the formula equation string given, using above pattern
    	Matcher _formulaVarMatcher = _formulaRegex.matcher(this.anEquation);
    	// While regex matcher can find matching values, set them as variables in exp4j expressionbuilder
    	while (_formulaVarMatcher.find()) {
    		// While index i, starting at 1, is less than matcher.groupCount(), which inherently does not include groupCount(0)
    		for (int i=0; i<=_formulaVarMatcher.groupCount(); i++) {
    			// Say what we've got as a match!
    			System.out.println(_formulaVarMatcher.group(i));
    			// Set ith match from regex as a variable in the formula expression builder
    			_formulaExpressionBuilder.variable(_formulaVarMatcher.group(i));
    		}
    	}
    	// Once regex stuff is done and variables are set, properly build the expression.
    	Expression _formulaExpression = _formulaExpressionBuilder.build();
    	return _formulaExpression;
    } // end _buildExpression
    
    public Set<String> getExpressionVars() {
    	return this.anExpression.getVariableNames();
    } // end getExpressionVars
}// End class