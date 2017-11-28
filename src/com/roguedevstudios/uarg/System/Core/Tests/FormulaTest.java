package com.roguedevstudios.uarg.System.Core.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.roguedevstudios.uarg.System.Core.Elements.Formula;

import net.objecthunter.exp4j.Expression;

import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Set;

import java.lang.reflect.*;

import java.util.ArrayList;

import java.util.regex.Pattern;

import java.util.regex.Matcher;

/**
 * This will test various methods of the formula.java file
 * @author Chel
 * @since 1.0
 */
public class FormulaTest {
	
	// METHOD TESTS \\
	
	/**
	 * Test the validity of our formula regex
	 * Expectation: success
	 * @throws An exception if what the formula regex grabs is incorrect
	 */
	@Test
	public void testFormulaRegex() {
		// Set up initial regex and string to splice with regex.
		Pattern formulaRegex = Pattern.compile("\\s?_[a-zA-z0-9_]*_\\s?");
		String stringToSplice = "_varA_*_varB_+_varC_someSALAD-!?_varD_";
		// Set up a matcher for our pattern
		Matcher goodStringMatcher = formulaRegex.matcher(stringToSplice);
		// Make an ArrayList and fill it with results of test values
		ArrayList<String> testStrings = new ArrayList<String>();
		while(goodStringMatcher.find()) {
			for (int i=0; i<=goodStringMatcher.groupCount(); i++) {
				testStrings.add(goodStringMatcher.group(i));
			}
		}
		// Make ArrayList for expected values
		ArrayList<String> expectedStrings = new ArrayList<String>();
		expectedStrings.add("_varA_");
		expectedStrings.add("_varB_");
		expectedStrings.add("_varC_");
		expectedStrings.add("_varD_");
		// Make try/catch for exception handling
		try {
			for (int i=0; i<=expectedStrings.size(); i++) {
				assertTrue(testStrings.get(i).equals(expectedStrings.get(i)));
			}
		} catch (Exception e) {
			// If exception tossed, test failed
			assertFalse(true);
		}
		
	}
	
	/**
	 * Test creation of a formula object, then test getters for that formula object.
	 * Expectation: success
	 */
	/*
	public boolean createTestFormula {
		String testFormulaName = "testFormula";
		String testFormulaDesc = "A test formula.";
		String formulaID = "TSTFRM1";
		String testFormulaEquation = "_varA_*_varB_+_varC_-_varD_";
		Formula ourTestFormula = new Formula(testFormulaName, testFormulaDesc, formulaID, testFormulaEquation);
		
		// TEST GETTERS \\
		ourTestFormula.GetName();
		ourTestFormula.GetDesc();
		ourTestFormula.GetId();
		ourTestFormula.GetEquation();
		ourTestFormula.GetNumberOfExpressionVars();
		ourTestFormula.GetExpressionVariableNames();
		ourTestFormula.GetInputArraySize();
		return true;
	}
*/
	
	/**
	 * Test that assigning variables using _buildExpression() works
	 * Expectation: success, lists expression vars
	 * @throws An exception if unexpected variable in expression
	 * @return An ArrayList<String> of the test expression's variable names
	 */
	@Test
	public void testBuildExpressionMethod() {
		// Set up initial Formula object
		// TODO: CURRENTLY TESTING ON CONSTRUCTOR ONLY UP TO _BUILDEXPRESSION(), AS CONSTRUCTOR
		// 			GETS BUILT THIS TEST MUST BE UPDATED
		String testFormulaName = "testFormula";
		String testFormulaDesc = "A test formula.";
		String formulaID = "TSTFRM1";
		String testFormulaEquation = "_varA_*_varB_+_varC_-_varD_";
		Formula ourTestFormula = new Formula(testFormulaName, testFormulaDesc, formulaID, testFormulaEquation);
		ArrayList<String> testFormulaVarNamesList = new ArrayList<String>(ourTestFormula.GetExpressionVariableNames());
		// Now test if variables gotten are proper; test each
		// variable name against what variables are expected.
		try {
			for (int i=0; i<=ourTestFormula.GetNumberOfExpressionVars(); i++) {
				assertTrue(testFormulaVarNamesList.get(i).equals("_varA_") ||
						testFormulaVarNamesList.get(i).equals("_varB_") ||
						testFormulaVarNamesList.get(i).equals("_varC_") ||
						testFormulaVarNamesList.get(i).equals("_varD_"));
				System.out.println(i + ": " +testFormulaVarNamesList.get(i));
			} 
		} catch (Exception e) {
				// If exception here, one variable did not match expected
				assertFalse(true);
		}
	}
	
	/**
	 * Example optimization of the above method
	 * 
	 * @author Christopher Howard
	 */
	@Test
	public void testBuildExpressionMethodOptimized() {
		// Initial Conditions
		String testFormulaName = "testFormula";
		String testFormulaDesc = "testFormulaDesc";
		String testFormulaID = "testFormulaID";
		String testFormulaEquation = "_varA_*_varB_+_varC_-_varD_";
		
		// Build Formula Object
		Formula FO = new Formula(testFormulaName, testFormulaDesc, testFormulaID, testFormulaEquation);
		
		// Expectations
		ArrayList<String> ExpectedVars = new ArrayList<String>();
		ExpectedVars.add("_varA_");
		ExpectedVars.add("_varB_");
		ExpectedVars.add("_varC_");
		ExpectedVars.add("_varD_");
		// Actuals
		ArrayList<String> ActualVars = FO.GetExpressionVariableNames();
		
		// Check that Actuals are in Expectations
		for(String Actual: ActualVars) {
			assertTrue(ExpectedVars.contains(Actual));
		}
		
		// Check that the Actual and Expected sets have equal cardinality
		assertTrue(ActualVars.size() == ExpectedVars.size());
	}
	
}
