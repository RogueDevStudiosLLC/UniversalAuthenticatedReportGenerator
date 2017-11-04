package com.roguedevstudios.uarg.JSON.Parser.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.ParserHelpers;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
/**
 * <p>
 * This will test the ParserHelper.java file
 * <p>
 * @author Christopher E. Howard
 * @author Terry Roberson
 * @since 1.0
 */
public class ParserHelpersTests {
	
	//***** INTEGER TESTING SECTION ******\\
	@Test
	public void ParseIntegerVariableTest() {
		// Set up initial conditions
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description"; 
		String descriptionValue = "TestDescription";
		String value = "value";
		int valueValue = 500;
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign  elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variable<Integer> testVar = ParserHelpers.ParseIntegerVariable(testElement, "TestID");
		
		// Fetch Information about Integer Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue,(int)testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	//***** STRING TESTING SECTION *****\\
	@Test
	public void ParseStringVariableTest() {
		
		// Set up initial conditions
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description";
		String descriptionValue = "TestDescription";
		String value = "value";
		String valueValue = "A";
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variable<String> testVar = ParserHelpers.ParseStringVariable(testElement, "TestID");
		
		// Fetch Information about String Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	//***** DOUBLE TESTING SECTION *****\\
	@Test
	public void ParseDoubleVariableTest() {
		
		//Set up initial conditions
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description"; 
		String descriptionValue = "TestDescription";
		String value = "value";
		Double valueValue = 5.4;
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variable<Double> testVar = ParserHelpers.ParseDoubleVariable(testElement, "TestID");
		
		// Fetch Information about Double Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		//Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void ParseLongVariableTest() {
		
		// Set up initial conditions 
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description"; 
		String descriptionValue = "TestDescription";
		String value = "value";
		Long valueValue = 54L;
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variable<Long> testVar = ParserHelpers.ParseLongVariable(testElement, "TestID");
		
		// Fetch Information about Double Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void ParseFloatVariableTest() {
		
		// Set up initial conditions
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description"; 
		String descriptionValue = "TestDescription";
		String value = "value";
		Float valueValue = 67F;
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variable<Float> testVar = ParserHelpers.ParseFloatVariable(testElement, "TestID");
		
		// Fetch Information about Float Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void ParseBooleanVariableTest() {
		
		// Set up initial conditions
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description"; 
		String descriptionValue = "TestDescription";
		String value = "value";
		Boolean valueValue = true;
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variable<Boolean> testVar = ParserHelpers.ParseBooleanVariable(testElement, "TestID");
		
		// Fetch Information about Boolean Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
}
