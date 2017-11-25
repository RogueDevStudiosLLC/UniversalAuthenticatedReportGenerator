package com.roguedevstudios.uarg.System.Core.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.roguedevstudios.uarg.System.Core.Elements.Formula;

import java.lang.reflect.*;

import java.util.*;

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
	
}
