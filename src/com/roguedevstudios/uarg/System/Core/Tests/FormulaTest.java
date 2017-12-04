package com.roguedevstudios.uarg.System.Core.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.roguedevstudios.uarg.System.Core.Elements.Formula;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;

import java.util.ArrayList;

import java.util.regex.Pattern;

import java.util.regex.Matcher;

/**
 * This will test various methods of the formula.java file
 * @author Chel
 * @since 1.0
 */
public class FormulaTest {
	//***** Variables Initial Condition Properties *****\\
	private ArrayList<Integer[]> _initialVariableCondIntArrVals;
	private ArrayList<Float[]> _initialVariableCondFloatArrVals;
	private ArrayList<Double[]> _initialVariableCondDoubleArrVals;
	private ArrayList<String[]> _initialVariableCondStringArrVals;
	private ArrayList<Long[]> _initialVariableCondLongArrVals;
	private ArrayList<Boolean[]> _initialVariableCondBoolArrVals;
	//***** INITIAL BUILDERS *****\\
		@Before 
		public void VariablesStart() {
			//Populate initial int[] values
			this._initialVariableCondIntArrVals = new ArrayList<Integer[]>();
			// 0 slot = [99,12,3]
			this._initialVariableCondIntArrVals.add(new Integer[] {99,12,3});
			// 1 slot = [10,11,12]
			this._initialVariableCondIntArrVals.add(new Integer[] {10,11,12});
			// 2 slot = [15,20,25]
			this._initialVariableCondIntArrVals.add(new Integer[] {15,20,25});
			//Populate initial String[] values
			this._initialVariableCondStringArrVals = new ArrayList<String[]>();
			// 0 slot = [A,B,C]
			this._initialVariableCondStringArrVals.add(new String[] {"A","B","C"});
			// 1 slot = [B,C,D]
			this._initialVariableCondStringArrVals.add(new String[] {"B","C","D"});
			// 2 slot = [C,D,E]
			this._initialVariableCondStringArrVals.add(new String[] {"C","D","E"});
			//Populate initial Float[] values
			this._initialVariableCondDoubleArrVals = new ArrayList<Double[]>();
			// 0 slot = [990.2,30.5,.04]
			this._initialVariableCondDoubleArrVals.add(new Double[] {990.2,30.5,.04});
			// 1 slot = [10.1,35.5,401.5]
			this._initialVariableCondDoubleArrVals.add(new Double[] {10.1,35.5,401.5});
			// 2 slot = [15.36,5.2,4.8]
			this._initialVariableCondDoubleArrVals.add(new Double[] {15.36,5.2,4.8});
			//Populate initial Long[] values
			this._initialVariableCondLongArrVals = new ArrayList<Long[]>();
			// 0 slot = [99,50,8]
			this._initialVariableCondLongArrVals.add(new Long[] {99L,50L,8L});
			// 1 slot = [10,5,8000]
			this._initialVariableCondLongArrVals.add(new Long[] {10L,5L,8000L});
			// 2 slot = [15,8,56]
			this._initialVariableCondLongArrVals.add(new Long[] {15L,8L,56L});
			//Populate initial Float[] values
			this._initialVariableCondFloatArrVals = new ArrayList<Float[]>();
			// 0 slot = [99, 12,5.2]
			this._initialVariableCondFloatArrVals.add(new Float[] {99F, 12F,5.2F});
			// 1 slot = [10, 58.2,500.1]
			this._initialVariableCondFloatArrVals.add(new Float[] {10F, 58.2F,500.1F});
			// 2 slot = [15, 64.2,69.1]
			this._initialVariableCondFloatArrVals.add(new Float[] {15F, 64.2F,69.1F});
			//Populate initial Boolean[] values
			this._initialVariableCondBoolArrVals = new ArrayList<Boolean[]>();
			// 0 slot = [true, false, true]
			this._initialVariableCondBoolArrVals.add(new Boolean[] {true, false, true});
			// 1 slot = [false, true, false]
			this._initialVariableCondBoolArrVals.add(new Boolean[] {false, true, false});
			// 2 slot = [false, true, true]
			this._initialVariableCondBoolArrVals.add(new Boolean[] {false, true, true});
		}
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
		String stringToSplice = "_varA_ * _varB_ + _varC_ someSALAD -!? _varD_";
		// Set up a matcher for our pattern
		Matcher goodStringMatcher = formulaRegex.matcher(stringToSplice);
		// Make an ArrayList and fill it with results of test values
		ArrayList<String> testStrings = new ArrayList<String>();
		while(goodStringMatcher.find()) {
			/*
			for (int i=0; i<=goodStringMatcher.groupCount(); i++) {
				testStrings.add(goodStringMatcher.group(i));
			}
			*/
			testStrings.add(goodStringMatcher.group().replaceAll("\\s+",""));
		}
		//System.out.println(testStrings.toString());
		// Make ArrayList for expected values
		ArrayList<String> expectedStrings = new ArrayList<String>();
		expectedStrings.add("_varA_");
		expectedStrings.add("_varB_");
		expectedStrings.add("_varC_");
		expectedStrings.add("_varD_");
		// Make try/catch for exception handling
		try {
			for (String entry: testStrings) {
				//System.err.println("String: "+entry);
				//System.err.println("Array: "+expectedStrings.toString());
				//System.err.println(expectedStrings.contains(entry));
				assertTrue(expectedStrings.contains(entry));
			}
			assertTrue(testStrings.size() == expectedStrings.size());
		} catch (Exception e) {
			// If exception tossed, test failed
			System.err.println(e.getMessage());
			assertFalse(true);
		}
		
	}
	
	@Test
	public void testFormulaProcessing() {
		String formulaExpression = "_VAR1_ * _VAR2_";
		Formula formula = new Formula("T","T","T",formulaExpression);
		Variable<Integer> v1 = new Variable<Integer>("T", "T", false, "T", 10);
		Variable<Integer> v2 = new Variable<Integer>("T","T",false,"T", 5);
		Variable<? extends Number>[] v = (Variable<? extends Number>[]) new Variable<?>[2];
		v[0] = v1;
		v[1] = v2;
		Integer out = formula.CalculateToInteger(v);
		//System.out.println(out);
		assertTrue(out==50);
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
		ArrayList<String> testFormulaVarNamesList = new ArrayList<String>(ourTestFormula.GetFormulaExpressionVariableNames());
		// Now test if variables gotten are proper; test each
		// variable name against what variables are expected.
		try {
			for (int i=0; i<=ourTestFormula.GetFormulaInputArraySize()-1; i++) {
				assertTrue(testFormulaVarNamesList.get(i).equals("_varA_") ||
						testFormulaVarNamesList.get(i).equals("_varB_") ||
						testFormulaVarNamesList.get(i).equals("_varC_") ||
						testFormulaVarNamesList.get(i).equals("_varD_"));
				//System.out.println(i + ": " +testFormulaVarNamesList.get(i));
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
		String testFormulaEquation = "_varA_ * _varB_ + _varC_ - _varD_";
		
		// Build Formula Object
		Formula FO = new Formula(testFormulaName, testFormulaDesc, testFormulaID, testFormulaEquation);
		
		// Expectations
		ArrayList<String> ExpectedVars = new ArrayList<String>();
		ExpectedVars.add("_varA_");
		ExpectedVars.add("_varB_");
		ExpectedVars.add("_varC_");
		ExpectedVars.add("_varD_");
		// Actuals
		ArrayList<String> ActualVars = FO.GetFormulaExpressionVariableNames();
		
		// Check that Actuals are in Expectations
		for(String Actual: ActualVars) {
			assertTrue(ExpectedVars.contains(Actual));
		}
		
		// Check that the Actual and Expected sets have equal cardinality
		assertTrue(ActualVars.size() == ExpectedVars.size());
	}
	
}
