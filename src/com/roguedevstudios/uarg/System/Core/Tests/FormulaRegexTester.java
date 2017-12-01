package com.roguedevstudios.uarg.System.Core.Tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

/**
 * This class is to test any incoming strings versus our established formula regex.
 * @author Chel
 */
public class FormulaRegexTester {
	public Pattern formulaRegex = Pattern.compile("\\s?_[a-zA-z0-9_]*_\\s?");
	public String stringToSlice;
	
	/* Constructor */
	/**
	 * This is the constructor for the FormulaRegexTester object.
	 * @param stringForRegex	Some string to be parsed through with regex to find formula regex-compliant bits.
	 */
	public FormulaRegexTester(String stringForRegex) {
		this.stringToSlice = stringForRegex;
	}
	
	/**
	 * This method should find all regex-compliant string bits in a full string and
	 * put them into a String ArrayList.
	 * @return ArrayList<String> goodStrings	Formula regex-compliant strings pulled from the string given to the FormulaRegexTester object.
	 */
	public ArrayList<String> getGoodStrings() {
		// Make a new matcher with the pattern we've got
		Matcher goodStringMatcher = this.formulaRegex.matcher(this.stringToSlice);
		// Make a string arraylist to hold formula regex-compliant bits we find!
		ArrayList<String> goodStrings = new ArrayList<String>();
		while(goodStringMatcher.find()) {
			for (int i=0; i<=goodStringMatcher.groupCount(); i++) {
				goodStrings.add(goodStringMatcher.group(i));
			}
		}
		return goodStrings;
	}
}
