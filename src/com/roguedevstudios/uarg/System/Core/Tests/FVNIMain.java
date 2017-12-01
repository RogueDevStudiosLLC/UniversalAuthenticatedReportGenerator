package com.roguedevstudios.uarg.System.Core.Tests;

import com.roguedevstudios.uarg.System.Core.Tests.FormulaVarNameInitTest;
/**
 * This class is the main method for FormulaVarNameInitTest.java
 * @author Chel
 * @since 1.0
 */
// This class and its method will not work inside the repo as is.
public class FVNIMain {

	public static void main(String[] args) {
		String aString = "_varA_*_varB_+_varC_-_varD_";
		System.out.println("Using equation \"" + aString + "\" to initialize a test Formula object . . .");
		FormulaVarNameInitTest testFormulaVarArrayList = new FormulaVarNameInitTest(aString);
		System.out.println("Getting variable names from our test Formula object's ArrayList . . . ");
		testFormulaVarArrayList.GetVarNames();
		System.out.println("Getting variable names from our test Formula object's Expression (out of order) . . . ");
		for (String s : testFormulaVarArrayList._formulaExpression.getVariableNames()) {
			System.out.println(s);
		}
	}
}
