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
	
	//***** Variables Initial Condition Properties *****\\
	private JsonElement _initialVariableCond;
	private ArrayList<Integer> _initialVariableCondIntVals;
	private ArrayList<Float> _initialVariableCondFloatVals;
	private ArrayList<String> _initialVariableCondStringVals;
	private ArrayList<Double> _initialVariableCondDoubleVals;
	private ArrayList<Long> _initialVariableCondLongVals;
	private ArrayList<Boolean> _initialVariableCondBoolVals;
	private ArrayList<Integer[]> _initialVariableCondIntArrVals;
	private ArrayList<Float[]> _initialVariableCondFloatArrVals;
	private ArrayList<Double[]> _initialVariableCondDoubleArrVals;
	private ArrayList<String[]> _initialVariableCondStringArrVals;
	private ArrayList<Long[]> _initialVariableCondLongArrVals;
	private ArrayList<Boolean[]> _initialVariableCondBoolArrVals;
	
	//***** INITIAL BUILDERS *****\\
	@Before 
	public void VariablesStart() {
		//Populate initial int values
		this._initialVariableCondIntVals = new ArrayList<Integer>();
		// 0 slot = 99
		this._initialVariableCondIntVals.add(99);
		// 1 slot = 10
		this._initialVariableCondIntVals.add(10);
		// 2 slot = 15
		this._initialVariableCondIntVals.add(15);
		//Populate initial String values
		this._initialVariableCondStringVals = new ArrayList<String>();
		// 0 slot = A
		this._initialVariableCondStringVals.add("A");
		// 1 slot = B
		this._initialVariableCondStringVals.add("B");
		// 2 slot = C
		this._initialVariableCondStringVals.add("C");
		//Populate initial Float values
		this._initialVariableCondDoubleVals = new ArrayList<Double>();
		// 0 slot = 990.2
		this._initialVariableCondDoubleVals.add(990.2);
		// 1 slot = 10.1
		this._initialVariableCondDoubleVals.add(10.1);
		// 2 slot = 15.36
		this._initialVariableCondDoubleVals.add(15.36);
		//Populate initial Long values
		this._initialVariableCondLongVals = new ArrayList<Long>();
		// 0 slot = 99
		this._initialVariableCondLongVals.add(99L);
		// 1 slot = 10
		this._initialVariableCondLongVals.add(10L);
		// 2 slot = 15
		this._initialVariableCondLongVals.add(15L);
		//Populate initial Float values
		this._initialVariableCondFloatVals = new ArrayList<Float>();
		// 0 slot = 99
		this._initialVariableCondFloatVals.add(99F);
		// 1 slot = 10
		this._initialVariableCondFloatVals.add(10F);
		// 2 slot = 15
		this._initialVariableCondFloatVals.add(15F);
		//Populate initial Float values
		this._initialVariableCondBoolVals = new ArrayList<Boolean>();
		// 0 slot = true
		this._initialVariableCondBoolVals.add(true);
		// 1 slot = false
		this._initialVariableCondBoolVals.add(false);
		// 2 slot = false
		this._initialVariableCondBoolVals.add(false);
		//Populate initial int values
		this._initialVariableCondIntArrVals = new ArrayList<Integer[]>();
		// 0 slot = [99,12,3]
		this._initialVariableCondIntArrVals.add(new Integer[] {99,12,3});
		// 1 slot = [10,11,12]
		this._initialVariableCondIntArrVals.add(new Integer[] {10,11,12});
		// 2 slot = [15,20,25]
		this._initialVariableCondIntArrVals.add(new Integer[] {15,20,25});
		//Populate initial String values
		this._initialVariableCondStringArrVals = new ArrayList<String[]>();
		// 0 slot = [A,B,C]
		this._initialVariableCondStringArrVals.add(new String[] {"A","B","C"});
		// 1 slot = [B,C,D]
		this._initialVariableCondStringArrVals.add(new String[] {"B","C","D"});
		// 2 slot = [C,D,E]
		this._initialVariableCondStringArrVals.add(new String[] {"C","D","E"});
		//Populate initial Float values
		this._initialVariableCondDoubleArrVals = new ArrayList<Double[]>();
		// 0 slot = [990.2,30.5,.04]
		this._initialVariableCondDoubleArrVals.add(new Double[] {990.2,30.5,.04});
		// 1 slot = [10.1,35.5,401.5]
		this._initialVariableCondDoubleArrVals.add(new Double[] {10.1,35.5,401.5});
		// 2 slot = [15.36,5.2,4.8]
		this._initialVariableCondDoubleArrVals.add(new Double[] {15.36,5.2,4.8});
		//Populate initial Long values
		this._initialVariableCondLongArrVals = new ArrayList<Long[]>();
		// 0 slot = [99,50,8]
		this._initialVariableCondLongArrVals.add(new Long[] {99L,50L,8L});
		// 1 slot = [10,5,8000]
		this._initialVariableCondLongArrVals.add(new Long[] {10L,5L,8000L});
		// 2 slot = [15,8,9023456]
		this._initialVariableCondLongArrVals.add(new Long[] {15L,8L,9023456L});
		//Populate initial Float values
		this._initialVariableCondFloatArrVals = new ArrayList<Float[]>();
		// 0 slot = [99, 12,5.2]
		this._initialVariableCondFloatArrVals.add(new Float[] {99F, 12F,5.2F});
		// 1 slot = [10, 58.2,500.1]
		this._initialVariableCondFloatArrVals.add(new Float[] {10F, 58.2F,500.1F});
		// 2 slot = [15, 64.2,69.1]
		this._initialVariableCondFloatArrVals.add(new Float[] {15F, 64.2F,69.1F});
		//Populate initial Boolean values
		this._initialVariableCondBoolArrVals = new ArrayList<Boolean[]>();
		// 0 slot = [true, false, true]
		this._initialVariableCondBoolArrVals.add(new Boolean[] {true, false, true});
		// 1 slot = [false, true, false]
		this._initialVariableCondBoolArrVals.add(new Boolean[] {false, true, false});
		// 2 slot = [false, true, true]
		this._initialVariableCondBoolArrVals.add(new Boolean[] {false, true, true});
		// Let us create 1 large JsonElement using the format that
		// we would actually see in a config file.
		String initVars =
				"{"+
						"\"Integers\":"+
						"{"+
							"\"IntX\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondIntVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"IntY\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondIntVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"IntZ\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondIntVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"Strings\":"+
						"{"+
							"\"StringX\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondStringVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"StringY\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondStringVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"StringZ\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondStringVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"Doubles\":"+
						"{"+
							"\"DoubleX\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondDoubleVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"DoubleY\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondDoubleVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"DoubleZ\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondDoubleVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"Longs\":"+
						"{"+
							"\"LongX\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondLongVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"LongY\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondLongVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"LongZ\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondLongVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"Floats\":"+
						"{"+
							"\"FloatX\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondFloatVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"FloatY\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondFloatVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"FloatZ\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondFloatVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"Booleans\":"+
						"{"+
							"\"BoolX\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondBoolVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":true"+
								"},"+
							"\"BoolY\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondBoolVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"BoolZ\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondBoolVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"IntegerArrays\":"+
						"{"+
							"\"Int[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondIntArrVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Int[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondIntArrVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Int[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondIntArrVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"StringArrays\":"+
						"{"+
							"\"String[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondStringArrVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"String[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondStringArrVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"String[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondStringArrVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"DoubleArrays\":"+
						"{"+
							"\"Double[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondDoubleArrVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Double[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondDoubleArrVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Double[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondDoubleArrVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"LongArrays\":"+
						"{"+
							"\"Long[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondLongArrVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Long[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondLongArrVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Long[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondLongArrVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"FloatArrays\":"+
						"{"+
							"\"Float[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondFloatArrVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Float[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondFloatArrVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Float[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondFloatArrVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"BooleanArrays\":"+
						"{"+
							"\"Bool[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondBoolArrVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":true"+
								"},"+
							"\"Bool[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondBoolArrVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Bool[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialVariableCondBoolArrVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"}"+
				"}";
		//System.out.println(initVars);
		// Convert the text to a JsonElement just as we will get
		// in the programs loading stages. This emulates actual
		// initial condition states.
		JsonParser p = new JsonParser();
		this._initialVariableCond = p.parse(initVars);
	}
	
	//***** HELPERS *****\\
	/**
	 * Grabs a section from the Variable conditions for use in tests
	 * @param key
	 * @return JsonElement
	 */
	public JsonElement getSectionCondition(String key){
			return this._initialVariableCond.getAsJsonObject().get(key);
		}
	/**
	 * Gets a specific variable from a section in the Variable conditions for use in teset
	 * @param sectionKey
	 * @param variableKey
	 * @return JsonElement
	 */
	public JsonElement getVariableCondition(String sectionKey, String variableKey) {
		return this.getSectionCondition(sectionKey).getAsJsonObject().get(variableKey);
	}
	
	//***** INTEGER TESTING SECTION ******\\
	@Test
	public void TestParseIntegerVariable() {

		Gson g = new Gson();
		
		
		// Parse IntX from the Integers section into an IVariable<Integer> compliant container
		IVariable<Integer> testVar = ParserHelpers.
										ParseIntegerVariable(
												this.getVariableCondition(
														"Integers", "IntX"), 
														"IntX");
		
		// Fetch Information about Integer Variable
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"IntX",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialVariableCondIntVals.get(0), 
						testVar.GetValue()
					);
		
		// Display results
		System.out.println(g.toJson(testVar));
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
		
Gson g = new Gson();
		
		
		// Parse StringX from the Integers section into an IVariable<Integer> compliant container
		IVariable<String> testVar = ParserHelpers.
										ParseStringVariable(
												this.getVariableCondition(
														"Strings", "StringX"), 
														"StringX");
		
		// Fetch Information about Integer Variable
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"StringX",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialVariableCondStringVals.get(0), 
						testVar.GetValue()
					);
		
		// Display results
		System.out.println(g.toJson(testVar));
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
		
Gson g = new Gson();
		
		
		// Parse IntX from the Integers section into an IVariable<Long> compliant container
		IVariable<Long> testVar = ParserHelpers.
										ParseLongVariable(
												this.getVariableCondition(
														"Longs", "LongX"), 
														"LongX");
		
		// Fetch Information about Long Variable
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"LongX",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialVariableCondLongVals.get(0), 
						testVar.GetValue()
					);
		
		// Display results
		System.out.println(g.toJson(testVar));
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
			
			Gson g = new Gson();
			
			
			// Parse FloatX from the Integers section into an IVariable<Float> compliant container
			IVariable<Float> testVar = ParserHelpers.
											ParseFloatVariable(
													this.getVariableCondition(
															"Floats", "FloatX"), 
															"FloatX");
			
			// Fetch Information about Integer Variable
			assertEquals(
							"TestName",
							testVar.GetName()
						);
			
			assertEquals(
							"FloatX",
							testVar.GetId()
						);
			
			assertEquals(
							"TestDescription",
							testVar.GetDescription()
						);
			
			assertEquals(
							this._initialVariableCondFloatVals.get(0), 
							testVar.GetValue()
						);
			
			// Display results
			System.out.println(g.toJson(testVar));
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
		
Gson g = new Gson();
		
		
		// Parse IntX from the Boolean section into an IVariable<Integer> compliant container
		IVariable<Boolean> testVar = ParserHelpers.
										ParseBooleanVariable(
												this.getVariableCondition(
														"Booleans", "BoolX"), 
														"BoolX");
		
		// Fetch Information about Integer Variable
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"BoolX",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialVariableCondBoolVals.get(0), 
						testVar.GetValue()
					);
		
		// Display results
		System.out.println(g.toJson(testVar));
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
