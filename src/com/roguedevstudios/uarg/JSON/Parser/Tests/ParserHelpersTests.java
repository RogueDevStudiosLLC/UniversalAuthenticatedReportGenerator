package com.roguedevstudios.uarg.JSON.Parser.Tests;

import static org.junit.Assert.*;

import org.eclipse.jdt.internal.compiler.parser.Parser;
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
	
	
	public String  IntVar =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":5"+
			"}";
	public String IntArrayVar =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":[5,10,15,20]"+
			"}";
	public Integer ifVal = 5;
	public Integer isVal = 10;
	public Integer itVal = 15;
	public Integer ifoVal = 20;
	
	
	public String IntArrayVar2 =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID2\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":[15,0,15]"+
			"}";
	
	public String StringArrayVar =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":[A,B,C,D]"+
			"}";
	public String sfVal = "A";
	public String ssVal = "B";
	public String stVal = "C";
	public String sfoVal = "D";
	public String StringArrayVar2 =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID2\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":[A,B,C]"+
			"}";
	public String DoubleArrayVar =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":[5.21, 6.35, 7.8, 8.2]"+
			"}";
	public Double dfVal = 5.21;
	public Double dsVal = 6.35;
	public Double dtVal = 7.8;
	public Double dfoVal = 8.2;
	public String DoubleArrayVar2 =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID2\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":[15.2,0.1,15.14]"+
			"}";
	public String LongArrayVar =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":[5,10,15,20]"+
			"}";
	public String LongArrayVar2 =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID2\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":[15,0,15]"+
			"}";
	public Long lfVal = 5L;
	public Long lsVal = 60L;
	public Long ltVal = 78L;
	public Long lfoVal = 800L;
	public String FloatArrayVar =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":[5,10,15,20]"+
			"}";
	public String FloatArrayVar2 =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID2\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":[15,0,15]"+
			"}";
	public Float ffVal = 5.33F;
	public Float fsVal = 60.51F;
	public Float ftVal = 78.27F;
	public Float ffoVal = 800.848F;
	public String BoolArrayVar =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":[true,false,true,true]"+
			"}";			
	public String BoolArrayVar2 =
			"{"+
					"\"name\":\"TestName\","+
					"\"ID\":\"TestID2\","+
					"\"description\":\"DescriptionValue\","+
					"\"value\":[false,false,false]"+
			"}";
	public Boolean bfVal = true;
	public Boolean bsVal = false;
	
	@Before
	public JsonElement getSectionCondition(String key){
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(IntVar).getAsJsonObject();
		return o.get(key);
		}
	
	//***** INTEGER TESTING SECTION ******\\
	@Test
	public void TestParseIntegerVariable() {
		// Set up initial conditions
		JsonElement IntVar = getSectionCondition("Integer");
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign  elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(IntVar);
		
		// Assign Variable<> to testVar and Parse
		IVariable<Integer> testVar = ParserHelpers.ParseIntegerVariable(IntVar, "TestID");
		
		// Fetch Information about Integer Variable
		assertEquals("TestName" ,testVar.GetName());
		assertEquals("TestID" ,testVar.GetId());
		assertEquals("TestDescription" ,testVar.GetDescription());
		assertEquals(ifVal, testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}
	

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
	
	@Test
	public void TestStringArraySectionMap() {
		
		// Set up initial conditions
		String StringArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[A,B,C,D]"+
				"}";
		String ID = "TestID";	
		String StringArrayVar2 =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID2\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[E,F,G]"+
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
	public void TestParseLongArrayVariable() {
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
	
	@Test
	public void TestLongArraySectionMap() {
		
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
	public void TestParseFloatVariable() {
		
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
	public void TestParseFloatArrayVariable() {
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
	public void TestParseBooleanArrayVariable() {
		// Set up initial conditions
		String BoolArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[true, false, false, true]"+
				"}";
		Boolean fVal = true;
		Boolean sVal = false;
		Boolean tVal = false;
		Boolean foVal = true;
		// Create a test variable object
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(BoolArrayVar).getAsJsonObject();
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		JsonReader reader = new JsonReader(new StringReader(BoolArrayVar));
		// Assign variable to JsonElement tree
		JsonElement testElement = g.toJsonTree(o);
		// Assign Variable<> to testVar and Parse
		IVariable<Boolean[]> testVar = ParserHelpers.ParseBooleanArrayVariable(testElement, "TestID");
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
	
	@Test
	public void TestBooleanArraySectionMap() {			
		// Set up initial conditions
		String BoolArrayVar =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[true,false,true,true]"+
				"}";
		String ID = "TestID";			
		String BoolArrayVar2 =
				"{"+
						"\"name\":\"TestName\","+
						"\"ID\":\"TestID2\","+
						"\"description\":\"DescriptionValue\","+
						"\"value\":[false,false,false]"+
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
