package com.roguedevstudios.uarg.System.Core.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.roguedevstudios.uarg.System.Core.Elements.Variable;

import java.lang.reflect.*;

import java.util.*;

/**
*<p>
*this will test the Variable.java file
*<p>
*
*@author Christopher E. Howard
*@author Terry Roberson
*@since 1.0
*/
public class VariableTest{
	
	//***** INTEGER TESTING SECTION *****\\
	
	 /**
	  * Test creation of Integer Variable
	  * Expectation: Success
	  */
	@Test
	public void createIntegerObjectVariable() {
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		Integer value = 10;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Variable<Integer> testVarNoValue = new Variable<Integer>(name, id, requiresInput, description);
				Variable<Integer> testVarWithValue = new Variable<Integer>(name, id, requiresInput, description, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
			
				//Test the value set properly or is properly null
				assertEquals(value, testVarWithValue.GetValue());
				assertNull(testVarNoValue.GetValue());
			
		} catch (Exception e) {
			
				// If this tosses an Exception we failed
				assertFalse(true);
				
		}
		
	}
	
	/**
	 * Test re-setting the value of an Integer Variable
	 */
	@Test
	public void resetValueOfIntegerObjectVariable(){
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		Integer value = 2;
		Integer newValue = 5;
		
		//Set up a valid test variable with a value 
		Variable<Integer> testVarValueUpdate = new Variable<Integer>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
		//Test the value set properly
		assertEquals(value, testVarValueUpdate.GetValue());
		
		//Test the value updates properly
		testVarValueUpdate.SetValue(newValue); 
		
		//Test the updated value displays properly
		assertEquals(newValue, testVarValueUpdate.GetValue());
		
		
		
		
		
	}
	
	/**
	 * Test nullifying the value of an Integer Variable
	 */
	
	/**
	 * Test creating a variable with all possible nullables as null
	 */
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoIntegerObjectType() {
		Variable<Integer> testVarWithPrimitive = new Variable<Integer>("TEST", "TEST", false, "TEST", 5);
		assertEquals(5, (int) testVarWithPrimitive.GetValue());
		
	}
	
	
}