package com.roguedevstudios.uarg.System.Core.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.roguedevstudios.uarg.System.Core.Elements.Variable;

import java.lang.reflect.*;

import java.util.*;

/**
 * <P>
 * this will test the Variable.java file
 * <P>
 * 
 * @author Terry Roberson
 * @since 1.0
 */
public class VariableTest{
	
	//***** INTEGER TESTING SECTION *****\\
	
	/**
	 * Test creation of Integer Variable
	 * Expectation: Success
	 */
	@Test
	public void createIntegerObjectVariable(){
		
		// Set up initial conditions 
		String name = "TestVar";
		String ID = "TestID";
		String Description = "A Test Variable";
		boolean RequiresInput = false;
		Integer value = 10;
		
		// Wrap in Try/Catch for exception handling
		try {
			// Setup a valid test variable both with and without a value
			Variable<Integer> testVarNoValue = new Variable<Integer>(name,ID,RequiresInput,Description);
			Variable<Integer> testVarWithValue = new Variable<Integer>(name,ID,RequiresInput,Description,value);
			
			// Test the name is correct
			assertEquals(name, testVarNoValue.GetName());
			assertEquals(name, testVarWithValue.GetName());
			
			// Test the ID is correct
			assertEquals(ID, testVarNoValue.GetId());
			assertEquals(ID, testVarWithValue.GetId());
			
			// Test the Description is correct
			assertEquals(Description, testVarNoValue.GetDescription());
			assertEquals(Description, testVarWithValue.GetDescription());
			
			// Test the value set properly or is properly null
			assertEquals(value, testVarWithValue.GetValue());
			assertNull(testVarNoValue.GetValue());
			
		} catch (Exception e) {
			
			// If this tosses an exception we failed
			assertFalse(true);
			
		}
		
	}
	/**
	 * Test re-setting the value of an Integer Variable
	 */
	
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
	public void setPrimitiveIntoIntegerObjectType(){
		Variable<Integer> testVar = new Variable<Integer>("TEST", "TEST", false, "TEST", 5);
		assertEquals(5, (int) testVar.GetValue());
	}
	
	/**
	 * Test creation of String Variable
	 * Expectation: Success
	 */
	
	/**
	 * Test creation of Long Variable
	 * Expectation: Success
	 */
	
	/**
	 * Test creation of Float Variable
	 * Expectation: Success
	 */
	
	/**
	 * Test creation of Double Variable
	 * Expectation: Success
	 */
	
	/**
	 * Test creation of Boolean Variable
	 * Expectation: Success
	 */
	
	/**
	 * Test creation of Integer Array Variable
	 * Expectation: Success
	 */
	
	/**
	 * Test creation of String Array Variable
	 * Expectation: Success
	 */
	
	/**
	 * Test creation of Long Array Variable
	 * Expectation: Success
	 */
	
	/**
	 * Test creation of Float Array Variable
	 * Expectation: Success
	 */
	
	/**
	 * Test creation of Double Array Variable
	 * Expectation: Success
	 */
	
	/**
	 * Test creation of Boolean Array Variable
	 * Expectation: Success
	 */

}