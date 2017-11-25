package com.roguedevstudios.uarg.System.Core.Tests;

import java.util.Set;
import com.roguedevstudios.uarg.System.Core.Tests.BuildExpressionTest;

/**
 * This class is the main method for the BuildExpressionTest.java file
 * Used for testing the _buildExpression() method in the Formula Class.
 * @author Chel
 */
public class BETMain {

	public static void main(String[] args) {
		// Feel free to modify to make new equations, etc etc.
		// If the String incoming has some salad in it that cannot be parsed the exp4j automatically throws an UnknownVariable something something exception!
		String anEquation = "_varA_*_varB_+_varC_-_varD_";
		BuildExpressionTest anExpressionObject = new BuildExpressionTest(anEquation);
		Set<String> anExpressionObjectsVarsSet = anExpressionObject.getExpressionVars();
		for (String var : anExpressionObjectsVarsSet) {
			System.out.println(var);
		}
	}
}
