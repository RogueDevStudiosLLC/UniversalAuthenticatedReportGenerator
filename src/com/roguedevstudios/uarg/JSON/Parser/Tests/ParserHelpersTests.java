package com.roguedevstudios.uarg.JSON.Parser.Tests;

import static org.junit.Assert.*;

import org.junit.*;

import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.ParserHelpers;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;
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
	public void TestParseIntegerVariable() {
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
		IVariable<Integer> testVar = ParserHelpers.ParseIntegerVariable(testElement, "TestID");
		
		// Fetch Information about Integer Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue,(int)testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestIntegerSectionMap() {
		
		// Set up initial conditions
		String Name = "name";
		String NameValue = "TestName";
		String NameValue1 = "TestName1";
		String ID = "ID";
		String idValue = "TestID";
		String idValue1 = "TestID2";
		String Description = "Description";
		String DescriptionValue = "TestDescription";
		String DescriptionValue1 = "TestDescription1";
		String Value = "Value";
		int ValueValue = 50;
		int ValueValue1 = 500;
		
		// Create test variable Objects
		JsonObject var1 = new JsonObject();
		JsonObject var2 = new JsonObject();
		JsonObject section1 = new JsonObject();
		
		// Add variable properties
		var1.addProperty(Name, NameValue);
		var1.addProperty(ID, idValue);
		var1.addProperty(Description, DescriptionValue);
		var1.addProperty(Value, ValueValue);
		var2.addProperty(Name, NameValue1);
		var2.addProperty(ID, idValue1);
		var2.addProperty(Description, DescriptionValue1);
		var2.addProperty(Value, ValueValue1);
		// Convert to JsonElement tree
		Gson g = new Gson();
		
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(var1);
		JsonElement testElement2 = g.toJsonTree(var2);
		
		// Add variable elements to section1 object
		section1.add(idValue, testElement1);
		section1.add(idValue1, testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s1 = g.toJsonTree(section1);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String, IVariable<Integer>> testMap = ParserHelpers.ParseIntegerVariableSection(s1);

		// Fetch key information for variables
		assertEquals(idValue, testMap.firstKey());
		assertEquals(idValue1, testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section1));
		
		
	}
	
	//***** INTEGER ARRAY TESTING SECTION *****\\
	@Test
	public void TestParseIntegerArrayVariable() {
		// Set up initial conditions
		String IntArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[5,10,15,20]"+
				"}";
		Integer fVal = 5;
		Integer sVal = 10;
		Integer tVal = 15;
		Integer foVal = 20;
		// Create a test variable object
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(IntArrayVar).getAsJsonObject();
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(IntArrayVar));
		// Assign variable to JsonElement tree
		JsonElement testElement = g.toJsonTree(o);
		// Assign Variable<> to testVar and Parse
		IVariable<Integer[]> testVar = ParserHelpers.ParseIntegerArrayVariable(testElement, "TestID");
		// Fetch Information about Integer Variable
		assertEquals("TestName", testVar.GetName());
		assertEquals("TestID", testVar.GetId());
		assertEquals("DescriptionValue", testVar.GetDescription());
		assertEquals(fVal, testVar.GetValue()[0]);
		assertEquals(sVal, testVar.GetValue()[1]);
		assertEquals(tVal, testVar.GetValue()[2]);
		assertEquals(foVal, testVar.GetValue()[3]);
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestIntegerArraySectionMap() {
		
		// Set up initial conditions
		String IntArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[5,10,15,20]"+
				"}";
		String ID = "TestID";
		
		String IntArrayVar2 =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID2\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[15,0,15]"+
				"}";
		ID = "TestID2";
		
		// Create test variable Objects
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(IntArrayVar).getAsJsonObject();
		JsonObject q = parser.parse(IntArrayVar2).getAsJsonObject();	
		JsonObject section = new JsonObject();
		// Convert to JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(IntArrayVar));
		reader = new JsonReader(new StringReader(IntArrayVar2));
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(o);
		JsonElement testElement2 = g.toJsonTree(q);
		
		// Add variable elements to section1 object
		section.add("TestID", testElement1);
		section.add("TestID2", testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s = g.toJsonTree(section);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String, IVariable<Integer[]>> testMap = ParserHelpers.ParseIntegerArrayVariableSection(s);
		
		
		// Fetch key information for variables
		assertEquals("TestID", testMap.firstKey());
		assertEquals("TestID2", testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
		
		
	}

	//***** STRING TESTING SECTION *****\\
	@Test
	public void TestParseStringVariable() {
		
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
	
	@Test
	public void TestStringSectionMap() {
		
		// Set up initial conditions
		String Name = "name";
		String NameValue = "TestName";
		String NameValue1 = "TestName1";
		String ID = "ID";
		String idValue = "TestID";
		String idValue1 = "TestID2";
		String Description = "Description";
		String DescriptionValue = "TestDescription";
		String DescriptionValue1 = "TestDescription1";
		String Value = "Value";
		String ValueValue = "A";
		String ValueValue1 = "B";
		
		// Create test variable Objects
		JsonObject var1 = new JsonObject();
		JsonObject var2 = new JsonObject();
		JsonObject section1 = new JsonObject();
		
		// Add variable properties
		var1.addProperty(Name, NameValue);
		var1.addProperty(ID, idValue);
		var1.addProperty(Description, DescriptionValue);
		var1.addProperty(Value, ValueValue);
		var2.addProperty(Name, NameValue1);
		var2.addProperty(ID, idValue1);
		var2.addProperty(Description, DescriptionValue1);
		var2.addProperty(Value, ValueValue1);
		// Convert to JsonElement tree
		Gson g = new Gson();
		
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(var1);
		JsonElement testElement2 = g.toJsonTree(var2);
		
		// Add variable elements to section1 object
		section1.add(idValue, testElement1);
		section1.add(idValue1, testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s1 = g.toJsonTree(section1);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String, IVariable<String>> testMap = ParserHelpers.ParseStringVariableSection(s1);
		
		
		// Fetch key information for variables
		assertEquals(idValue, testMap.firstKey());
		assertEquals(idValue1, testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section1));
	}
	
	//***** STRING ARRAY TESTING SECTION *****\\
	@Test
	public void TestParseStringArrayVariable() {
		// Set up initial conditions
		String StringArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[A,B,C,D]"+
				"}";
		String fVal = "A";
		String sVal = "B";
		String tVal = "C";
		String foVal = "D";
		// Create a test variable object
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(StringArrayVar).getAsJsonObject();
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(StringArrayVar));
		// Assign variable to JsonElement tree
		JsonElement testElement = g.toJsonTree(o);
		// Assign Variable<> to testVar and Parse
		IVariable<String[]> testVar = ParserHelpers.ParseStringArrayVariable(testElement, "TestID");
		// Fetch Information about Integer Variable
		assertEquals("TestName", testVar.GetName());
		assertEquals("TestID", testVar.GetId());
		assertEquals("DescriptionValue", testVar.GetDescription());
		assertEquals(fVal, testVar.GetValue()[0]);
		assertEquals(sVal, testVar.GetValue()[1]);
		assertEquals(tVal, testVar.GetValue()[2]);
		assertEquals(foVal, testVar.GetValue()[3]);
		// Display results
		System.out.println(g.toJson(testElement));
	}
		
	@Test
	public void TestStringArraySectionMap() {
		
		// Set up initial conditions
		String StringArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[5,10,15,20]"+
				"}";
		String ID = "TestID";	
		String StringArrayVar2 =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID2\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[15,0,15]"+
				"}";
		ID = "TestID2";
			
		// Create test variable Objects
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(StringArrayVar).getAsJsonObject();
		JsonObject q = parser.parse(StringArrayVar2).getAsJsonObject();	
		JsonObject section = new JsonObject();
		// Convert to JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(StringArrayVar));
		reader = new JsonReader(new StringReader(StringArrayVar2));
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(o);
		JsonElement testElement2 = g.toJsonTree(q);
			
		// Add variable elements to section1 object
		section.add("TestID", testElement1);
		section.add("TestID2", testElement2);
			
		// Convert section1 to JsonElement
		JsonElement s = g.toJsonTree(section);
			
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String, IVariable<String[]>> testMap = ParserHelpers.ParseStringArrayVariableSection(s);
			
			
		// Fetch key information for variables
		assertEquals("TestID", testMap.firstKey());
		assertEquals("TestID2", testMap.lastKey());
			
		// Display results
		System.out.println(g.toJson(section));
			
			
	}
	
	//***** DOUBLE TESTING SECTION *****\\
	@Test
	public void TestParseDoubleVariable() {
		
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
		IVariable<Double> testVar = ParserHelpers.ParseDoubleVariable(testElement, "TestID");
		
		// Fetch Information about Double Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		//Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestDoubleSectionMap() {
		
		// Set up initial conditions
		String Name = "name";
		String NameValue = "TestName";
		String NameValue1 = "TestName1";
		String ID = "ID";
		String idValue = "TestID";
		String idValue1 = "TestID2";
		String Description = "Description";
		String DescriptionValue = "TestDescription";
		String DescriptionValue1 = "TestDescription1";
		String Value = "Value";
		Double ValueValue = 575.2;
		Double ValueValue1 = 52.6;
		
		// Create test variable Objects
		JsonObject var1 = new JsonObject();
		JsonObject var2 = new JsonObject();
		JsonObject section1 = new JsonObject();
		
		// Add variable properties
		var1.addProperty(Name, NameValue);
		var1.addProperty(ID, idValue);
		var1.addProperty(Description, DescriptionValue);
		var1.addProperty(Value, ValueValue);
		var2.addProperty(Name, NameValue1);
		var2.addProperty(ID, idValue1);
		var2.addProperty(Description, DescriptionValue1);
		var2.addProperty(Value, ValueValue1);
		// Convert to JsonElement tree
		Gson g = new Gson();
		
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(var1);
		JsonElement testElement2 = g.toJsonTree(var2);
		
		// Add variable elements to section1 object
		section1.add(idValue, testElement1);
		section1.add(idValue1, testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s1 = g.toJsonTree(section1);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String, IVariable<Double>> testMap = ParserHelpers.ParseDoubleVariableSection(s1);
		
		
		// Fetch key information for variables
		assertEquals(idValue, testMap.firstKey());
		assertEquals(idValue1, testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section1));
		
	}
	
	//***** DOUBLE ARRAY TESTING SECTION *****\\
	@Test
	public void TestParseDoubleArrayVariable() {
		// Set up initial conditions
		String DoubleArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[5.21, 6.35, 7.8, 8.2]"+
				"}";
		Double fVal = 5.21;
		Double sVal = 6.35;
		Double tVal = 7.8;
		Double foVal = 8.2;
		// Create a test variable object
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(DoubleArrayVar).getAsJsonObject();
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(DoubleArrayVar));
		// Assign variable to JsonElement tree
		JsonElement testElement = g.toJsonTree(o);
		// Assign Variable<> to testVar and Parse
		IVariable<Double[]> testVar = ParserHelpers.ParseDoubleArrayVariable(testElement, "TestID");
		// Fetch Information about Integer Variable
		assertEquals("TestName", testVar.GetName());
		assertEquals("TestID", testVar.GetId());
		assertEquals("DescriptionValue", testVar.GetDescription());
		assertEquals(fVal, testVar.GetValue()[0]);
		assertEquals(sVal, testVar.GetValue()[1]);
		assertEquals(tVal, testVar.GetValue()[2]);
		assertEquals(foVal, testVar.GetValue()[3]);
		// Display results
		System.out.println(g.toJson(testElement));
	}	
			
	@Test
	public void TestDoubleArraySectionMap() {
			
		// Set up initial conditions
		String DoubleArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[5.1,10.34,15.8,20.6]"+
				"}";
		String ID = "TestID";
				
		String DoubleArrayVar2 =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID2\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[15.2,0.1,15.14]"+
				"}";
		ID = "TestID2";
				
		// Create test variable Objects
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(DoubleArrayVar).getAsJsonObject();
		JsonObject q = parser.parse(DoubleArrayVar2).getAsJsonObject();	
		JsonObject section = new JsonObject();
		// Convert to JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(DoubleArrayVar));
		reader = new JsonReader(new StringReader(DoubleArrayVar2));
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(o);
		JsonElement testElement2 = g.toJsonTree(q);
				
		// Add variable elements to section1 object
		section.add("TestID", testElement1);
		section.add("TestID2", testElement2);
				
		// Convert section1 to JsonElement
		JsonElement s = g.toJsonTree(section);
				
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String, IVariable<Double[]>> testMap = ParserHelpers.ParseDoubleArrayVariableSection(s);
				
				
		// Fetch key information for variables
		assertEquals("TestID", testMap.firstKey());
		assertEquals("TestID2", testMap.lastKey());
				
		// Display results
		System.out.println(g.toJson(section));
				
				
	}
	
	//***** LONG TESTING SECTION *****\\
	@Test
	public void TestParseLongVariable() {
		
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
		IVariable<Long> testVar = ParserHelpers.ParseLongVariable(testElement, "TestID");
		
		// Fetch Information about Double Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestLongSectionMap() {
		
		// Set up initial conditions
		String Name = "name";
		String NameValue = "TestName";
		String NameValue1 = "TestName1";
		String ID = "ID";
		String idValue = "TestID";
		String idValue1 = "TestID2";
		String Description = "Description";
		String DescriptionValue = "TestDescription";
		String DescriptionValue1 = "TestDescription1";
		String Value = "Value";
		Long ValueValue = 50L;
		Long ValueValue1 = 500L;
		
		// Create test variable Objects
		JsonObject var1 = new JsonObject();
		JsonObject var2 = new JsonObject();
		JsonObject section1 = new JsonObject();
		
		// Add variable properties
		var1.addProperty(Name, NameValue);
		var1.addProperty(ID, idValue);
		var1.addProperty(Description, DescriptionValue);
		var1.addProperty(Value, ValueValue);
		var2.addProperty(Name, NameValue1);
		var2.addProperty(ID, idValue1);
		var2.addProperty(Description, DescriptionValue1);
		var2.addProperty(Value, ValueValue1);
		// Convert to JsonElement tree
		Gson g = new Gson();
		
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(var1);
		JsonElement testElement2 = g.toJsonTree(var2);
		
		// Add variable elements to section1 object
		section1.add(idValue, testElement1);
		section1.add(idValue1, testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s1 = g.toJsonTree(section1);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String, IVariable<Long>> testMap = ParserHelpers.ParseLongVariableSection(s1);
		
		
		// Fetch key information for variables
		assertEquals(idValue, testMap.firstKey());
		assertEquals(idValue1, testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section1));
		
	}
	
	//***** LONG ARRAY TESTING SECTION *****\\
	@Test
	public void ParseLongArrayVariableTest() {
		// Set up initial conditions
		String LongArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[5, 60, 78, 800]"+
				"}";
		Long fVal = 5L;
		Long sVal = 60L;
		Long tVal = 78L;
		Long foVal = 800L;
		// Create a test variable object
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(LongArrayVar).getAsJsonObject();
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(LongArrayVar));
		// Assign variable to JsonElement tree
		JsonElement testElement = g.toJsonTree(o);
		// Assign Variable<> to testVar and Parse
		IVariable<Long[]> testVar = ParserHelpers.ParseLongArrayVariable(testElement, "TestID");
		// Fetch Information about Integer Variable
		assertEquals("TestName", testVar.GetName());
		assertEquals("TestID", testVar.GetId());
		assertEquals("DescriptionValue", testVar.GetDescription());
		assertEquals(fVal, testVar.GetValue()[0]);
		assertEquals(sVal, testVar.GetValue()[1]);
		assertEquals(tVal, testVar.GetValue()[2]);
		assertEquals(foVal, testVar.GetValue()[3]);
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestLongArrayVariableSectionMap() {
		
	// Set up initial conditions
		String LongArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[5,10,15,20]"+
				"}";
		String ID = "TestID";
		
		String LongArrayVar2 =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID2\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[15,0,15]"+
				"}";
		ID = "TestID2";
		
		// Create test variable Objects
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(LongArrayVar).getAsJsonObject();
		JsonObject q = parser.parse(LongArrayVar2).getAsJsonObject();	
		JsonObject section = new JsonObject();
		// Convert to JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(LongArrayVar));
		reader = new JsonReader(new StringReader(LongArrayVar2));
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(o);
		JsonElement testElement2 = g.toJsonTree(q);
		
		// Add variable elements to section1 object
		section.add("TestID", testElement1);
		section.add("TestID2", testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s = g.toJsonTree(section);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String, IVariable<Long[]>> testMap = ParserHelpers.ParseLongArrayVariableSection(s);
		
		
		// Fetch key information for variables
		assertEquals("TestID", testMap.firstKey());
		assertEquals("TestID2", testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
		
		
	}
	
	//***** FLOAT TESTING SECTION *****\\
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
		IVariable<Float> testVar = ParserHelpers.ParseFloatVariable(testElement, "TestID");
		
		// Fetch Information about Float Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestFloatSectionMap() {
		
		// Set up initial conditions
		String Name = "name";
		String NameValue = "TestName";
		String NameValue1 = "TestName1";
		String ID = "ID";
		String idValue = "TestID";
		String idValue1 = "TestID2";
		String Description = "Description";
		String DescriptionValue = "TestDescription";
		String DescriptionValue1 = "TestDescription1";
		String Value = "Value";
		Float ValueValue = 50F;
		Float ValueValue1 = 500F;
		
		// Create test variable Objects
		JsonObject var1 = new JsonObject();
		JsonObject var2 = new JsonObject();
		JsonObject section1 = new JsonObject();
		
		// Add variable properties
		var1.addProperty(Name, NameValue);
		var1.addProperty(ID, idValue);
		var1.addProperty(Description, DescriptionValue);
		var1.addProperty(Value, ValueValue);
		var2.addProperty(Name, NameValue1);
		var2.addProperty(ID, idValue1);
		var2.addProperty(Description, DescriptionValue1);
		var2.addProperty(Value, ValueValue1);
		// Convert to JsonElement tree
		Gson g = new Gson();
		
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(var1);
		JsonElement testElement2 = g.toJsonTree(var2);
		
		// Add variable elements to section1 object
		section1.add(idValue, testElement1);
		section1.add(idValue1, testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s1 = g.toJsonTree(section1);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String, IVariable<Float>> testMap = ParserHelpers.ParseFloatVariableSection(s1);
		
		
		// Fetch key information for variables
		assertEquals(idValue, testMap.firstKey());
		assertEquals(idValue1, testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section1));
		
	}
	
	//***** FLOAT ARRAY TESTING SECTION *****\\
	@Test
	public void ParseFloatArrayVariableTest() {
		// Set up initial conditions
		String FloatArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[5.33, 60.51, 78.27, 800.848]"+
				"}";
		Float fVal = 5.33F;
		Float sVal = 60.51F;
		Float tVal = 78.27F;
		Float foVal = 800.848F;
		// Create a test variable object
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(FloatArrayVar).getAsJsonObject();
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(FloatArrayVar));
		// Assign variable to JsonElement tree
		JsonElement testElement = g.toJsonTree(o);
		// Assign Variable<> to testVar and Parse
		IVariable<Float[]> testVar = ParserHelpers.ParseFloatArrayVariable(testElement, "TestID");
		// Fetch Information about Integer Variable
		assertEquals("TestName", testVar.GetName());
		assertEquals("TestID", testVar.GetId());
		assertEquals("DescriptionValue", testVar.GetDescription());
		assertEquals(fVal, testVar.GetValue()[0]);
		assertEquals(sVal, testVar.GetValue()[1]);
		assertEquals(tVal, testVar.GetValue()[2]);
		assertEquals(foVal, testVar.GetValue()[3]);
		// Display results
		System.out.println(g.toJson(testElement));
	}
			
	@Test
	public void TestFloatArraySectionMap() {
				
		// Set up initial conditions
		String FloatArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[5,10,15,20]"+
				"}";
		String ID = "TestID";
				
		String FloatArrayVar2 =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID2\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[15,0,15]"+
				"}";
		ID = "TestID2";
				
		// Create test variable Objects
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(FloatArrayVar).getAsJsonObject();
		JsonObject q = parser.parse(FloatArrayVar2).getAsJsonObject();	
		JsonObject section = new JsonObject();
		// Convert to JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(FloatArrayVar));
		reader = new JsonReader(new StringReader(FloatArrayVar2));
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(o);
		JsonElement testElement2 = g.toJsonTree(q);
				
		// Add variable elements to section1 object
		section.add("TestID", testElement1);
		section.add("TestID2", testElement2);
				
		// Convert section1 to JsonElement
		JsonElement s = g.toJsonTree(section);
				
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String, IVariable<Float[]>> testMap = ParserHelpers.ParseFloatArrayVariableSection(s);
				
				
		// Fetch key information for variables
		assertEquals("TestID", testMap.firstKey());
		assertEquals("TestID2", testMap.lastKey());
				
		// Display results
		System.out.println(g.toJson(section));
				
				
	}
	
	//***** BOOLEAN TESTING SECTION *****\\
	@Test
	public void TestParseBooleanVariable() {
		
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
		IVariable<Boolean> testVar = ParserHelpers.ParseBooleanVariable(testElement, "TestID");
		
		// Fetch Information about Boolean Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue, testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	
	@Test
	public void TestBooleanSectionMap() {
		
		// Set up initial conditions
		String Name = "name";
		String NameValue = "TestName";
		String NameValue1 = "TestName1";
		String ID = "ID";
		String idValue = "TestID";
		String idValue1 = "TestID2";
		String Description = "Description";
		String DescriptionValue = "TestDescription";
		String DescriptionValue1 = "TestDescription1";
		String Value = "Value";
		Boolean ValueValue = false;
		Boolean ValueValue1 = true;
		
		// Create test variable Objects
		JsonObject var1 = new JsonObject();
		JsonObject var2 = new JsonObject();
		JsonObject section1 = new JsonObject();
		
		// Add variable properties
		var1.addProperty(Name, NameValue);
		var1.addProperty(ID, idValue);
		var1.addProperty(Description, DescriptionValue);
		var1.addProperty(Value, ValueValue);
		var2.addProperty(Name, NameValue1);
		var2.addProperty(ID, idValue1);
		var2.addProperty(Description, DescriptionValue1);
		var2.addProperty(Value, ValueValue1);
		// Convert to JsonElement tree
		Gson g = new Gson();
		
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(var1);
		JsonElement testElement2 = g.toJsonTree(var2);
		
		// Add variable elements to section1 object
		section1.add(idValue, testElement1);
		section1.add(idValue1, testElement2);
		
		// Convert section1 to JsonElement
		JsonElement s1 = g.toJsonTree(section1);
		
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String, IVariable<Boolean>> testMap = ParserHelpers.ParseBooleanVariableSection(s1);
		
		
		// Fetch key information for variables
		assertEquals(idValue, testMap.firstKey());
		assertEquals(idValue1, testMap.lastKey());
		
		// Display results
		System.out.println(g.toJson(section1));
		
	}
	
	//***** BOOLEAN ARRAY TESTING SECTION *****\\
	@Test
	public void ParseBooleanArrayVariableTest() {
		// Set up initial conditions
		String LongArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[5, 60, 78, 800]"+
				"}";
		Long fVal = 5L;
		Long sVal = 60L;
		Long tVal = 78L;
		Long foVal = 800L;
		// Create a test variable object
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(LongArrayVar).getAsJsonObject();
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(LongArrayVar));
		// Assign variable to JsonElement tree
		JsonElement testElement = g.toJsonTree(o);
		// Assign Variable<> to testVar and Parse
		IVariable<Long[]> testVar = ParserHelpers.ParseLongArrayVariable(testElement, "TestID");
		// Fetch Information about Integer Variable
		assertEquals("TestName", testVar.GetName());
		assertEquals("TestID", testVar.GetId());
		assertEquals("DescriptionValue", testVar.GetDescription());
		assertEquals(fVal, testVar.GetValue()[0]);
		assertEquals(sVal, testVar.GetValue()[1]);
		assertEquals(tVal, testVar.GetValue()[2]);
		assertEquals(foVal, testVar.GetValue()[3]);
		// Display results
		System.out.println(g.toJson(testElement));
	}
			
	//***** BOOLEAN ARRAY TESTING SECTION *****\\
	@Test
	public void TestBooleanArraySectionMap() {			
		// Set up initial conditions
		String BoolArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[5,10,15,20]"+
				"}";
		String ID = "TestID";			
		String BoolArrayVar2 =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID2\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[15,0,15]"+
				"}";
		ID = "TestID2";			
		// Create test variable Objects
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(BoolArrayVar).getAsJsonObject();
		JsonObject q = parser.parse(BoolArrayVar2).getAsJsonObject();	
		JsonObject section = new JsonObject();
		// Convert to JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(BoolArrayVar));
		reader = new JsonReader(new StringReader(BoolArrayVar2));
		// Assign variable objects to JsonElement tree
		JsonElement testElement1 = g.toJsonTree(o);
		JsonElement testElement2 = g.toJsonTree(q);
				
		// Add variable elements to section1 object
		section.add("TestID", testElement1);
		section.add("TestID2", testElement2);
				
		// Convert section1 to JsonElement
		JsonElement s = g.toJsonTree(section);
			
		// Assign TreeMap<> to testMap and Parse
		TreeMap<String, IVariable<Boolean[]>> testMap = ParserHelpers.ParseBooleanArrayVariableSection(s);
				
				
		// Fetch key information for variables
		assertEquals("TestID", testMap.firstKey());
		assertEquals("TestID2", testMap.lastKey());
				
		// Display results
		System.out.println(g.toJson(section));
		
	}
	
	//***** VARIABLES TESTING SECTION *****\\
	@Test
	public void TestVariables() {
		
	}
}
