package com.roguedevstudios.uarg.System.Core.Tests;

import com.roguedevstudios.uarg.System.Core.Tests.FormulaRegexTester;
import java.util.ArrayList;

/**
 * This class is the main method for the FormulaRegexTester.java file.
 * Used for testing formula regex for the Formula.java class.
 * @author Chel
 *
 */
public class FRTMain {

	public static void main(String[] args) {
		String aString = "_varA_*_varB_+_varC_someSALAD-!?_varD_";
		FormulaRegexTester testFormulaRegex = new FormulaRegexTester(aString);
		ArrayList<String> formulaStrings = testFormulaRegex.getGoodStrings();
		for (String var : formulaStrings) {
			System.out.println(var);
		}
	}

}
