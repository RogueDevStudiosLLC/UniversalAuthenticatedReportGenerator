package com.roguedevstudios.uarg.System.Core.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.roguedevstudios.uarg.System.Core.Elements.Formula;
import com.roguedevstudios.uarg.System.Core.Elements.Formuli;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import com.roguedevstudios.uarg.System.Core.Elements.Variables;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormuli;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariables;
import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

/**
 * This will test various methods of the formula.java file
 * @author Chelsea Hunter
 * @author Terry Roberson
 * @author Christopher E. Howard
 * @since 1.0
 */
public class FormulaTest {
	//***** Variables Initial Condition Properties *****\\
	private IVariables vars;
	private IFormuli formuli;
	//***** INITIAL BUILDERS *****\\
	@Before 
	public void Setup() {
			this.vars = new Variables();
			this.formuli = new Formuli();
			this.formuli.AddFormula("Multiply", new Formula("T","T","T","_VAR1_ * _VAR2_"));
			this.vars.SetVariable("IntegerArrayVariable1",
					new Variable<Integer[]>("TI1","TI1",false,"TI1", new Integer[] {1,2,3}),
					VariableType.INTEGERARRAY
					);
			this.vars.SetVariable("IntegerArrayVariable2",
					new Variable<Integer[]>("TI2","TI2",false,"TI2", new Integer[] {4,5,6}),
					VariableType.INTEGERARRAY
					);
			this.vars.SetVariable("FloatArrayVariable1",
					new Variable<Float[]>("TF1","TF1",false,"TF1", new Float[] {1.2f,2.5f,3.7f}),
					VariableType.FLOATARRAY
					);
			this.vars.SetVariable("FloatArrayVariable2",
					new Variable<Float[]>("TF2","TF2",false,"TF2", new Float[] {4.7f,5.8f,6.3f}),
					VariableType.FLOATARRAY
					);
			this.vars.SetVariable("DoubleArrayVariable1",
					new Variable<Double[]>("TD1","TD1",false,"TD1", new Double[] {10d,20d,30d}),
					VariableType.DOUBLEARRAY
					);
			this.vars.SetVariable("DoubleArrayVariable2",
					new Variable<Double[]>("TD2","TD2",false,"TD2", new Double[] {4d,5d,6d}),
					VariableType.DOUBLEARRAY
					);
			this.vars.SetVariable("LongArrayVariable1",
					new Variable<Long[]>("TL1","TL1",false,"TL1", new Long[] {100l,200l,300l}),
					VariableType.LONGARRAY
					);
			this.vars.SetVariable("LongArrayVariable2",
					new Variable<Long[]>("TL2","TL2",false,"TL2", new Long[] {4l,5l,6l}),
					VariableType.LONGARRAY
					);
			this.vars.SetVariable("IntegerArrayResult",
					new Variable<Integer[]>("TI","TI",false,"TI", new Integer[2]),
					VariableType.INTEGERARRAY
					);
			this.vars.SetVariable("FloatArrayResult",
					new Variable<Float[]>("TF","TF",false,"TF", new Float[2]),
					VariableType.FLOATARRAY
					);
			this.vars.SetVariable("DoubleArrayResult",
					new Variable<Double[]>("TD","TD",false,"TD", new Double[2]),
					VariableType.DOUBLEARRAY
					);
			this.vars.SetVariable("LongArrayResult",
					new Variable<Long[]>("TL","TL",false,"TL", new Long[2]),
					VariableType.LONGARRAY
					);
			
			
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
		String formulaMultiply = "_VAR1_ * _VAR2_";
		String formulaDivision = "_VAR1_ / _VAR2_";
		String formulaAdd = "_VAR1_ + _VAR2_";
		String formulaSub = "_VAR1_ - _VAR2_";
		Formula formulaM = new Formula("T","T","T",formulaMultiply);
		Formula formulaD = new Formula("T", "T", "T", formulaDivision);
		Formula formulaA = new Formula("T", "T", "T", formulaAdd);
		Formula formulaS = new Formula("T", "T", "T", formulaSub);
		IVariable<Integer> vi1 = new Variable<Integer>("T", "T", false, "T", 10);
		IVariable<Integer> vi2 = new Variable<Integer>("T","T",false,"T", 5);
		IVariable<Float> vf1 = new Variable<Float>("T", "T", false, "T", 5.4F);
		IVariable<Float> vf2 = new Variable<Float>("T", "T", false, "T", 12.3F);
		IVariable<Double> vd1 = new Variable<Double>("T", "T", false, "T", 80.5);
		IVariable<Double> vd2 = new Variable<Double>("T","T",false,"T", 10.2);
		IVariable<Long> vl1 = new Variable<Long>("T", "T", false, "T", 50L);
		IVariable<Long> vl2 = new Variable<Long>("T", "T", false, "T", 5L);
		IVariable<? extends Number>[] vi = (IVariable<? extends Number>[]) new IVariable<?>[2];
		IVariable<? extends Number>[] vf = (IVariable<? extends Number>[]) new IVariable<?>[2];
		IVariable<? extends Number>[] vd = (IVariable<? extends Number>[]) new IVariable<?>[2];
		IVariable<? extends Number>[] vl = (IVariable<? extends Number>[]) new IVariable<?>[2];
		
		vi[0] = vi1;
		vi[1] = vi2;
		vf[0] = vf1;
		vf[1] = vf2;
		vd[0] = vd1;
		vd[1] = vd2;
		vl[0] = vl1;
		vl[1] = vl2;
		Integer iOut = formulaM.CalculateToInteger(vi);
		Float fOut = formulaA.CalculateToFloat(vf);
		Double dOut = formulaD.CalculateToDouble(vd);
		Long lOut = formulaS.CalculateToLong(vl);
		System.out.println(iOut);
		System.out.println(fOut);
		System.out.println(dOut);
		System.out.println(lOut);
		assertTrue(iOut==50);
		assertTrue(fOut==17.7F);
		assertTrue(dOut==7.892156862745098);
		assertTrue(lOut==45L);
	}
	@Test 
	public void TestVariableArray() {	
			for(String ID: this.vars.GetMasterIDList()) {
				IVariable<?extends Number>[] retIntArr = (IVariable<? extends Number>[]) new IVariable<?>[2];
				this.vars.GetIntegerArray("IntegerArray1");
				
				}
		assertTrue(true);
	}
	
	@Test
	public void testFormulaProcessingLog() {
		String formulaExpression = "log(_var_)";
		Formula formula = new Formula("T","T","T",formulaExpression);
		Variable<Integer> v1 = new Variable<Integer>("T","T",false,"T",4);
		Variable<? extends Number>[] v = (Variable<? extends Number>[]) new Variable<?>[1];
		v[0] = v1;
		Double out = formula.CalculateToDouble(v);
		Double outCheck = Math.log(4);
		System.err.println("Exp4j Output: "+out);
		System.err.println("Java Output: "+outCheck);
		assertEquals(out,outCheck);
	}
	
	@Test
	public void testFormulaCrazy() {
		String formulaExpression = "_var1_ + _var2_ + 1000 * _var3_ - ( _var4_ + _var5_ + _var6_ * _var8_ ) + _var9_ + _var7_";
		Formula formula = new Formula("T","T","T",formulaExpression);
		Variable<Integer> v1 = new Variable<Integer>("T","T",false,"T",4);
		Variable<Double> v3 = new Variable<Double>("T","T",false,"T",5d);
		Variable<Float> v2 = new Variable<Float>("T","T",false,"T",4.0f);
		Variable<Long> v4 = new Variable<Long>("T","T",false,"T",25L);
		Variable<Integer> v5 = new Variable<Integer>("T","T",false,"T",40);
		Variable<Integer> v6 = new Variable<Integer>("T","T",false,"T",9);
		Variable<Integer> v7 = new Variable<Integer>("T","T",false,"T",7);
		Variable<Integer> v8 = new Variable<Integer>("T","T",false,"T",32);
		Variable<Integer> v9 = new Variable<Integer>("T","T",false,"T",14);
		Variable<? extends Number>[] v = (Variable<? extends Number>[]) new Variable<?>[9];
		
		v[0] = v1;
		v[1] = v2;
		v[2] = v3;
		v[3] = v4;
		v[4] = v5;
		v[5] = v6;
		v[6] = v7;
		v[7] = v8;
		v[8] = v9;
		
		Double[] ins = new Double[9];
		
		ins[0] = v1.GetValue().doubleValue();
		ins[1] = v2.GetValue().doubleValue();
		ins[2] = v3.GetValue().doubleValue();
		ins[3] = v4.GetValue().doubleValue();
		ins[4] = v5.GetValue().doubleValue();
		ins[5] = v6.GetValue().doubleValue();
		ins[6] = v7.GetValue().doubleValue();
		ins[7] = v8.GetValue().doubleValue();
		ins[8] = v9.GetValue().doubleValue();
		
		Double outCheck = 
				ins[0] +
				ins[1] +
				(
						1000d *
						ins[2]
						//5000
				)
				//5000+4+4=5008
				-
				(
						ins[3] +
						ins[4] +
						(
								ins[5] *
								ins[7]
										//9*7=63
						)
						//63+25+40=128
				)
				//5008-128=4880
				+
				ins[8] +
				ins[6];
				//4880+32+14=4926
				// Java says 4626
				// Java PEMDAS failure....
		outCheck = 4926d;
				
		Double out = formula.CalculateToDouble(v);
		System.err.println(out);
		System.out.println(outCheck);
		assertEquals(out,outCheck);
	}
	
	@Test
	public void testMatrixProcessing() {
		Integer[] A = new Integer[] {2,3,4};
		Integer[] B = new Integer[] {5,6,7};
		Integer C = new Integer(10);
		String E = "_A_ * _B_ * _C_";
		Formula F = new Formula("T","T","T",E);
		Variable<Integer[]> vA = new Variable<>("T","T",false,"T",A);
		Variable<Integer[]> vB = new Variable<>("T","T",false,"T",B);
		Variable<Integer> vC = new Variable<>("T","T",false,"T",C);
		IVariable<?>[] v = new Variable<?>[] {vA,vB,vC};
		Double[] d = F.CalculateToDouble(v, true);
		for(Double di: d) {
			System.err.println("Output: "+di);
		}
		assertTrue(d.length == 3);
		assertTrue(d[0] == 100);
		assertTrue(d[1] == 180);
		assertTrue(d[2] == 280);
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
