package com.roguedevstudios.uarg.System.Core.Tests;

import java.lang.Double;
import java.lang.Integer;
import java.util.ArrayList;
import com.roguedevstudios.uarg.System.Core.Tests.FormulaInputArrayProcessTest;

/**
 * This class is the main method for FormulaInputArrayProcessTest.java
 * @author Chel
 * @since 1.0
 */
public class FIAPMain {
// THIS CLASS WILL NOT WORK IN REPO AS IS. SIMPLY FOR REFERENCE.
	public static void main(String[] args) {
		// Setup initial object to use for testing
		String equation = "_A_*_B_";
		System.out.println("\n***MAIN: Attempting to create a formula object using \"" + equation + "\" as our equation string . . .\n");
		FormulaInputArrayProcessTest testFormula = new FormulaInputArrayProcessTest(equation);
		// Now setup initial array to use for testing
		System.out.println("\n***MAIN: Setting up an Integer array: [2, 3].");
		Integer[] inputs = new Integer[2];
		inputs[0] = new Integer(2);
		inputs[1] = new Integer(3);
		// Now test GetIntegerResult() by putting result in a new variable
		System.out.println("***MAIN: Attempting to get an integer result from our formula object . . .\n");
		Integer resultVal = testFormula.GetIntegerResult(inputs);
		System.out.println("\n***MAIN: Resulting value from our testFormula object is " + resultVal + ".\n");
		// Snippet to say if success or fail using equation
		if (resultVal == 2*3) {
			System.out.println("Success!");
		} else {
			System.out.println("Something went wrong.");
		}

	}

}
