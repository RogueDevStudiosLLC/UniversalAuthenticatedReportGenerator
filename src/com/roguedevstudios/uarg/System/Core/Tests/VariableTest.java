//TODO: Cleanup #2
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
	 * Expectation: Success
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
		System.out.println(testVarValueUpdate.GetValue());
		
	}
	
	/**
	 * Test nullifying the value of an Integer Variable
	 * Expectation: Success
	 */
	@Test
	public void nullValueOfIntegerObjectVariable() {
		
		//Set value of variable to null
		Integer value = null;
		Variable<Integer> testNullValue = new Variable<Integer>("TEST", "TEST", false, "TEST", value);
		assertNull(testNullValue.GetValue());

	}
		
	/**
	 * Test creating a variable with all possible nullables as null
	 * Expectation: Success
	 */
	@Test
	public void nullIntegerObjectVariable() {
		
		//Set up initial conditions
		String name = null;
		String id = null;
		String description = null;
		boolean requiresInput = false;
		Integer value = null;
		
		//Set up a valid test variable with a value 
		Variable<Integer> nullIntegerObjectVariable = new Variable<Integer>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoIntegerObjectType() {
		Variable<Integer> testVarWithPrimitive = new Variable<Integer>("TEST", "TEST", false, "TEST", 5);
		assertEquals(5, (int) testVarWithPrimitive.GetValue());
		
	}
	
	//***** STRING TESTING SECTION *****\\
	
	 /**
	  * Test creation of String Variable
	  * Expectation: Success
	  */
	@Test
	public void createStringObjectVariable() {
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		String value = "A";
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Variable<String> testVarNoValue = new Variable<String>(name, id, requiresInput, description);
				Variable<String> testVarWithValue = new Variable<String>(name, id, requiresInput, description, value);
		
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
	 * Test re-setting the value of a String Variable
	 * Expectation: Success
	 */
	@Test
	public void resetValueOfStringObjectVariable(){
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		String value = "A";
		String newValue = "B";
		
		//Set up a valid test variable with a value 
		Variable<String> testVarValueUpdate = new Variable<String>(name, id, requiresInput, description, value);
		
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
		System.out.println(testVarValueUpdate.GetValue());
	}
	
	/**
	 * Test nullifying the value of a String Variable
	 * Expectation: Success
	 */
	@Test
	public void nullValueOfStringObjectVariable() {
		
		//Set value of variable to null
		String value = null;
		Variable<String> testNullValue = new Variable<String>("TEST", "TEST", false, "TEST", value);
		assertNull(testNullValue.GetValue());

	}
		
	/**
	 * Test creating a variable with all possible nullables as null
	 * Expectation: Success
	 */
	@Test
	public void nullStringObjectVariable() {
		
		//Set up initial conditions
		String name = null;
		String id = null;
		String description = null;
		boolean requiresInput = false;
		String value = null;
		
		//Set up a valid test variable with a value 
		Variable<String> nullIntegerObjectVariable = new Variable<String>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoStringObjectType() {
		Variable<String> testVarWithPrimitive = new Variable<String>("TEST", "TEST", false, "TEST", "A");
		assertEquals("A", (String) testVarWithPrimitive.GetValue());
		
	}
	
	//***** DOUBLE TESTING SECTION *****\\
	
	 /**
	  * Test creation of Double Variable
	  * Expectation: Success
	  */
	@Test
	public void createDoubleObjectVariable() {
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		Double value = 5.8;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Variable<Double> testVarNoValue = new Variable<Double>(name, id, requiresInput, description);
				Variable<Double> testVarWithValue = new Variable<Double>(name, id, requiresInput, description, value);
		
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
	 * Test re-setting the value of a Double Variable
	 * Expectation: Success
	 */
	@Test
	public void resetValueOfDoubleObjectVariable(){
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		Double value = 4.3;
		Double newValue = 5.4;
		
		//Set up a valid test variable with a value 
		Variable<Double> testVarValueUpdate = new Variable<Double>(name, id, requiresInput, description, value);
		
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
		System.out.println(testVarValueUpdate.GetValue());
	}
	
	/**
	 * Test nullifying the value of a Double Variable
	 * Expectation: Success
	 */
	@Test
	public void nullValueOfDoubleObjectVariable() {
		
		//Set value of variable to null
		Double value = null;
		Variable<Double> testNullValue = new Variable<Double>("TEST", "TEST", false, "TEST", value);
		assertNull(testNullValue.GetValue());

	}
		
	/**
	 * Test creating a variable with all possible nullables as null
	 * Expectation: Success
	 */
	@Test
	public void nullDoubleObjectVariable() {
		
		//Set up initial conditions
		String name = null;
		String id = null;
		String description = null;
		boolean requiresInput = false;
		Double value = null;
		
		//Set up a valid test variable with a value 
		Variable<Double> nullIntegerObjectVariable = new Variable<Double>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoDoubleObjectType() {
		Variable<Double> testVarWithPrimitive = new Variable<Double>("TEST", "TEST", false, "TEST", 1e-15);
		assertEquals(1e-15, (double) testVarWithPrimitive.GetValue(), 0);
		
	}
	
	//***** LONG TESTING SECTION *****\\
	
	 /**
	  * Test creation of Long Variable
	  * Expectation: Success
	  */
	@Test
	public void createLongObjectVariable() {
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		Long value = 50000000L;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Variable<Long> testVarNoValue = new Variable<Long>(name, id, requiresInput, description);
				Variable<Long> testVarWithValue = new Variable<Long>(name, id, requiresInput, description, value);
		
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
	 * Test re-setting the value of a Long Variable
	 * Expectation: Success
	 */
	@Test
	public void resetValueOfLongObjectVariable(){
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		Long value = 53L;
		Long newValue = 68L;
		
		//Set up a valid test variable with a value 
		Variable<Long> testVarValueUpdate = new Variable<Long>(name, id, requiresInput, description, value);
		
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
		System.out.println(testVarValueUpdate.GetValue());
	}
	
	/**
	 * Test nullifying the value of a Long Variable
	 * Expectation: Success
	 */
	@Test
	public void nullValueOfLongObjectVariable() {
		
		//Set value of variable to null
		Long value = null;
		Variable<Long> testNullValue = new Variable<Long>("TEST", "TEST", false, "TEST", value);
		assertNull(testNullValue.GetValue());

	}
		
	/**
	 * Test creating a variable with all possible nullables as null
	 * Expectation: Success
	 */
	@Test
	public void nullLongObjectVariable() {
		
		//Set up initial conditions
		String name = null;
		String id = null;
		String description = null;
		boolean requiresInput = false;
		Long value = null;
		
		//Set up a valid test variable with a value 
		Variable<Long> nullIntegerObjectVariable = new Variable<Long>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoLongObjectType() {
		Variable<Long> testVarWithPrimitive = new Variable<Long>("TEST", "TEST", false, "TEST", 300L);
		assertEquals(300L, (long) testVarWithPrimitive.GetValue());
		
	}
	
	//***** FLOAT TESTING SECTION *****\\
	
	 /**
	  * Test creation of Float Variable
	  * Expectation: Success
	  */
	@Test
	public void createFloatObjectVariable() {
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		Float value = 2.50F;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Variable<Float> testVarNoValue = new Variable<Float>(name, id, requiresInput, description);
				Variable<Float> testVarWithValue = new Variable<Float>(name, id, requiresInput, description, value);
		
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
	 * Test re-setting the value of a Float Variable
	 * Expectation: Success
	 */
	@Test
	public void resetValueOfFloatObjectVariable(){
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		Float value = 5.3F;
		Float newValue = 6.8F;
		
		//Set up a valid test variable with a value 
		Variable<Float> testVarValueUpdate = new Variable<Float>(name, id, requiresInput, description, value);
		
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
		System.out.println(testVarValueUpdate.GetValue());
	}
	
	/**
	 * Test nullifying the value of a Float Variable
	 * Expectation: Success
	 */
	@Test
	public void nullValueOfFloatObjectVariable() {
		
		//Set value of variable to null
		Float value = null;
		Variable<Float> testNullValue = new Variable<Float>("TEST", "TEST", false, "TEST", value);
		assertNull(testNullValue.GetValue());

	}
		
	/**
	 * Test creating a variable with all possible nullables as null
	 * Expectation: Success
	 */
	@Test
	public void nullFloatObjectVariable() {
		
		//Set up initial conditions
		String name = null;
		String id = null;
		String description = null;
		boolean requiresInput = false;
		Float value = null;
		
		//Set up a valid test variable with a value 
		Variable<Float> nullIntegerObjectVariable = new Variable<Float>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	
	@Test
	public void setPrimitiveIntoFloatObjectType() {
		Variable<Float> testVarWithPrimitive = new Variable<Float>("TEST", "TEST", false, "TEST", 3.28F);
		assertEquals(3.28F, (float) testVarWithPrimitive.GetValue(), 0);
		
	}
	
	//***** BOOLEAN TESTING SECTION *****\\
	
	 /**
	  * Test creation of Boolean Variable
	  * Expectation: Success
	  */
	@Test
	public void createBooleanObjectVariable() {
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		Boolean value = true;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Variable<Boolean> testVarNoValue = new Variable<Boolean>(name, id, requiresInput, description);
				Variable<Boolean> testVarWithValue = new Variable<Boolean>(name, id, requiresInput, description, value);
		
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
	 * Test re-setting the value of a Boolean Variable
	 * Expectation: Success
	 */
	@Test
	public void resetValueOfBooleanObjectVariable(){
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		Boolean value = true;
		Boolean newValue = false;
		
		//Set up a valid test variable with a value 
		Variable<Boolean> testVarValueUpdate = new Variable<Boolean>(name, id, requiresInput, description, value);
		
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
		System.out.println(testVarValueUpdate.GetValue());
	}
	
	/**
	 * Test nullifying the value of a Boolean Variable
	 * Expectation: Success
	 */
	@Test
	public void nullValueOfBooleanObjectVariable() {
		
		//Set value of variable to null
		Boolean value = false;
		Variable<Boolean> testNullValue = new Variable<Boolean>("TEST", "TEST", false, "TEST", value);
		assertEquals(value, testNullValue.GetValue());

	}
		
	/**
	 * Test creating a variable with all possible nullables as null
	 * Expectation: Success
	 */
	@Test
	public void nullBooleanObjectVariable() {
		
		//Set up initial conditions
		String name = null;
		String id = null;
		String description = null;
		boolean requiresInput = false;
		Boolean value = null;
		
		//Set up a valid test variable with a value 
		Variable<Boolean> nullIntegerObjectVariable = new Variable<Boolean>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoBooleanObjectType() {
		Variable<Boolean> testVarWithPrimitive = new Variable<Boolean>("TEST", "TEST", false, "TEST", false);
		assertEquals(false, (boolean) testVarWithPrimitive.GetValue());
		
	}
	
}