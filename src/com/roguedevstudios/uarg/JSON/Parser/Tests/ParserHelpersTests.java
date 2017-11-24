package com.roguedevstudios.uarg.JSON.Parser.Tests;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import com.google.gson.*;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.ParserHelpers;
import com.roguedevstudios.uarg.System.Core.Elements.Variables;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariables;
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
		// 2 slot = [15,8,56]
		this._initialVariableCondLongArrVals.add(new Long[] {15L,8L,56L});
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
									"\"Value\":["+
									this._initialVariableCondIntArrVals.get(0)[0]+","+
									this._initialVariableCondIntArrVals.get(0)[1]+","+
									this._initialVariableCondIntArrVals.get(0)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Int[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondIntArrVals.get(1)[0]+","+
									this._initialVariableCondIntArrVals.get(1)[1]+","+
									this._initialVariableCondIntArrVals.get(1)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Int[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondIntArrVals.get(2)[0]+","+
									this._initialVariableCondIntArrVals.get(2)[1]+","+
									this._initialVariableCondIntArrVals.get(2)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"StringArrays\":"+
							"{"+
						"\"String[]X\":"+
							"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondStringArrVals.get(0)[0]+","+
									this._initialVariableCondStringArrVals.get(0)[1]+","+
									this._initialVariableCondStringArrVals.get(0)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
							"},"+
						"\"String[]Y\":"+
							"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondStringArrVals.get(1)[0]+","+
									this._initialVariableCondStringArrVals.get(1)[1]+","+
									this._initialVariableCondStringArrVals.get(1)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
							"},"+
						"\"String[]Z\":"+
							"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondStringArrVals.get(2)[0]+","+
									this._initialVariableCondStringArrVals.get(2)[1]+","+
									this._initialVariableCondStringArrVals.get(2)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"DoubleArrays\":"+
						"{"+
							"\"Double[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondDoubleArrVals.get(0)[0]+","+
									this._initialVariableCondDoubleArrVals.get(0)[1]+","+
									this._initialVariableCondDoubleArrVals.get(0)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Double[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondDoubleArrVals.get(1)[0]+","+
									this._initialVariableCondDoubleArrVals.get(1)[1]+","+
									this._initialVariableCondDoubleArrVals.get(1)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Double[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondDoubleArrVals.get(2)[0]+","+
									this._initialVariableCondDoubleArrVals.get(2)[1]+","+
									this._initialVariableCondDoubleArrVals.get(2)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"LongArrays\":"+
						"{"+
							"\"Long[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondLongArrVals.get(0)[0]+","+
									this._initialVariableCondLongArrVals.get(0)[1]+","+
									this._initialVariableCondLongArrVals.get(0)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Long[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondLongArrVals.get(1)[0]+","+
									this._initialVariableCondLongArrVals.get(1)[1]+","+
									this._initialVariableCondLongArrVals.get(1)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Long[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondLongArrVals.get(2)[0]+","+
									this._initialVariableCondLongArrVals.get(2)[1]+","+
									this._initialVariableCondLongArrVals.get(2)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"FloatArrays\":"+
						"{"+
							"\"Float[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondFloatArrVals.get(0)[0]+","+
									this._initialVariableCondFloatArrVals.get(0)[1]+","+
									this._initialVariableCondFloatArrVals.get(0)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Float[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondFloatArrVals.get(1)[0]+","+
									this._initialVariableCondFloatArrVals.get(1)[1]+","+
									this._initialVariableCondFloatArrVals.get(1)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Float[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondFloatArrVals.get(2)[0]+","+
									this._initialVariableCondFloatArrVals.get(2)[1]+","+
									this._initialVariableCondFloatArrVals.get(2)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"BooleanArrays\":"+
						"{"+
							"\"Bool[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondBoolArrVals.get(0)[0]+","+
									this._initialVariableCondBoolArrVals.get(0)[1]+","+
									this._initialVariableCondBoolArrVals.get(0)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":true"+
								"},"+
							"\"Bool[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondBoolArrVals.get(1)[0]+","+
									this._initialVariableCondBoolArrVals.get(1)[1]+","+
									this._initialVariableCondBoolArrVals.get(1)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Bool[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialVariableCondBoolArrVals.get(2)[0]+","+
									this._initialVariableCondBoolArrVals.get(1)[1]+","+
									this._initialVariableCondBoolArrVals.get(2)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"}"+
				"}";
		// System.out.println(initVars);
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
		// Convert elements to a JsonTree
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
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse IntX from the Integers section into an IVariable<Integer> compliant container
		IVariable<Integer[]> testVar = ParserHelpers.
										ParseIntegerArrayVariable(
												this.getVariableCondition(
														"IntegerArrays", "Int[]X"), 
														"Int[]X");
		
		// Fetch Information about Integer Variable
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"Int[]X",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialVariableCondIntArrVals.get(0)[0], 
						testVar.GetValue()[0]
					);
		assertEquals(
						this._initialVariableCondIntArrVals.get(0)[1], 
						testVar.GetValue()[1]
					);
		assertEquals(
						this._initialVariableCondIntArrVals.get(0)[2], 
						testVar.GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	
	@Test
	public void TestIntegerSectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse IntX, IntY, IntZ from the Integers section into an IVariable<Integer> compliant container
		IVariable<Integer> testVar = ParserHelpers.
										ParseIntegerVariable(
												this.getVariableCondition(
														"Integers", "IntX"), 
														"IntX");
		IVariable<Integer> testVar2 = ParserHelpers.
										ParseIntegerVariable(
												this.getVariableCondition(
														"Integers", "IntY"), 
														"IntY");
		IVariable<Integer> testVar3 = ParserHelpers.
										ParseIntegerVariable(
												this.getVariableCondition(
														"Integers", "IntZ"), 
														"IntZ");
		// Parse Integer Section into a TreeMap
		TreeMap<String, IVariable<Integer>> section = ParserHelpers.
														ParseIntegerVariableSection(
																this.getSectionCondition(
																		"Integers"));
		// Fetch key information for variables
		assertEquals("IntX", section.firstKey());
		assertEquals("IntZ", section.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
	}

	@Test
	public void TestIntegerArraySectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse IntX, IntY, IntZ from the Integers section into an IVariable<Integer> compliant container
		IVariable<Integer[]> testVar = ParserHelpers.
										ParseIntegerArrayVariable(
												this.getVariableCondition(
														"IntegerArrays", "Int[]X"), 
														"Int[]X");
		IVariable<Integer[]> testVar2 = ParserHelpers.
										ParseIntegerArrayVariable(
												this.getVariableCondition(
														"IntegerArrays", "Int[]Y"), 
														"Int[]Y");
		IVariable<Integer[]> testVar3 = ParserHelpers.
										ParseIntegerArrayVariable(
												this.getVariableCondition(
														"IntegerArrays", "Int[]Z"), 
														"Int[]Z");
		// Parse Integer Section into a TreeMap
		TreeMap<String, IVariable<Integer[]>> section = ParserHelpers.
														ParseIntegerArrayVariableSection(
																this.getSectionCondition(
																		"IntegerArrays"));
		// Fetch key information for variables
		assertEquals("Int[]X", section.firstKey());
		assertEquals("Int[]Z", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}

	//***** STRING TESTING SECTION *****\\
	@Test
	public void TestParseStringVariable() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse StringX, StringY, StringZ from the Strings section into an IVariable<String> compliant container
		IVariable<String> testVar = ParserHelpers.
										ParseStringVariable(
												this.getVariableCondition(
														"Strings", "StringX"), 
														"StringX");
		
		// Fetch key information for variables
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
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse StringX from the Strings section into an IVariable<String> compliant container
		IVariable<String[]> testVar = ParserHelpers.
										ParseStringArrayVariable(
												this.getVariableCondition(
														"StringArrays", "String[]X"), 
														"String[]X");
		
		// Fetch Information about String Variable
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"String[]X",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialVariableCondStringArrVals.get(0)[0], 
						testVar.GetValue()[0]
					);
		assertEquals(
						this._initialVariableCondStringArrVals.get(0)[1], 
						testVar.GetValue()[1]
					);
		assertEquals(
						this._initialVariableCondStringArrVals.get(0)[2], 
						testVar.GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}

	@Test
	public void TestStringSectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse StringX, StringY, StringZ from the Strings section into an IVariable<String> compliant container
		IVariable<String> testVar = ParserHelpers.
										ParseStringVariable(
												this.getVariableCondition(
														"Strings", "StringX"), 
														"StringX");
		IVariable<String> testVar2 = ParserHelpers.
										ParseStringVariable(
												this.getVariableCondition(
														"Strings", "StringY"), 
														"StringY");
		IVariable<String> testVar3 = ParserHelpers.
										ParseStringVariable(
												this.getVariableCondition(
														"Strings", "StringZ"), 
														"StringZ");
		// Parse String Section into a TreeMap
		TreeMap<String, IVariable<String>> section = ParserHelpers.
														ParseStringVariableSection(
																this.getSectionCondition(
																		"Strings"));
		// Fetch key information for variables
		assertEquals("StringX", section.firstKey());
		assertEquals("StringZ", section.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
	}
	
	@Test
	public void TestStringArraySectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse StringX, StringY, StringZ from the Strings section into an IVariable<String> compliant container
		IVariable<String[]> testVar = ParserHelpers.
										ParseStringArrayVariable(
												this.getVariableCondition(
														"StringArrays", "String[]X"), 
														"String[]X");
		IVariable<String[]> testVar2 = ParserHelpers.
										ParseStringArrayVariable(
												this.getVariableCondition(
														"StringArrays", "String[]Y"), 
														"String[]Y");
		IVariable<String[]> testVar3 = ParserHelpers.
										ParseStringArrayVariable(
												this.getVariableCondition(
														"StringArrays", "String[]Z"), 
														"String[]Z");
		// Parse String Section into a TreeMap
		TreeMap<String, IVariable<String[]>> section = ParserHelpers.
														ParseStringArrayVariableSection(
																this.getSectionCondition(
																		"StringArrays"));
		// Fetch key information for variables
		assertEquals("String[]X", section.firstKey());
		assertEquals("String[]Z", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}
	
	//***** DOUBLE TESTING SECTION *****\\
	@Test
	public void TestParseDoubleVariable() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse DoubleX from the Doubles section into an IVariable<Double> compliant container
		IVariable<Double> testVar = ParserHelpers.
										ParseDoubleVariable(
												this.getVariableCondition(
														"Doubles", "DoubleX"), 
														"DoubleX");
		// Fetch Information about Integer Variable
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"DoubleX",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialVariableCondDoubleVals.get(0), 
						testVar.GetValue()
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	
	@Test
	public void TestParseDoubleArrayVariable() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse IntX from the Doubles section into an IVariable<Double> compliant container
		IVariable<Double[]> testVar = ParserHelpers.
										ParseDoubleArrayVariable(
												this.getVariableCondition(
														"DoubleArrays", "Double[]X"), 
														"Double[]X");
		
		// Fetch Information about Double Variable
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"Double[]X",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialVariableCondDoubleArrVals.get(0)[0], 
						testVar.GetValue()[0]
					);
		assertEquals(
						this._initialVariableCondDoubleArrVals.get(0)[1], 
						testVar.GetValue()[1]
					);
		assertEquals(
						this._initialVariableCondDoubleArrVals.get(0)[2], 
						testVar.GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}

	@Test
	public void TestDoubleSectionMap() {
		
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse DoubleX, DoubleY, DoubleZ from the Doubles section into an IVariable<Double> compliant container
		IVariable<Double> testVar = ParserHelpers.
										ParseDoubleVariable(
												this.getVariableCondition(
														"Doubles", "DoubleX"), 
														"DoubleX");
		IVariable<Double> testVar2 = ParserHelpers.
										ParseDoubleVariable(
												this.getVariableCondition(
														"Doubles", "DoubleY"), 
														"DoubleY");
		IVariable<Double> testVar3 = ParserHelpers.
										ParseDoubleVariable(
												this.getVariableCondition(
														"Doubles", "DoubleZ"), 
														"DoubleZ");
		// Parse Double Section into a TreeMap
		TreeMap<String, IVariable<Double>> section = ParserHelpers.
														ParseDoubleVariableSection(
																this.getSectionCondition(
																		"Doubles"));
		// Fetch key information for variables
		assertEquals("DoubleX", section.firstKey());
		assertEquals("DoubleZ", section.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
	}
	
	@Test
	public void TestDoubleArraySectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse DoubleX, DoubleY, DoubleZ from the Doubles section into an IVariable<Double> compliant container
		IVariable<Double[]> testVar = ParserHelpers.
										ParseDoubleArrayVariable(
												this.getVariableCondition(
														"DoubleArrays", "Double[]X"), 
														"Double[]X");
		IVariable<Double[]> testVar2 = ParserHelpers.
										ParseDoubleArrayVariable(
												this.getVariableCondition(
														"DoubleArrays", "Double[]Y"), 
														"Double[]Y");
		IVariable<Double[]> testVar3 = ParserHelpers.
										ParseDoubleArrayVariable(
												this.getVariableCondition(
														"DoubleArrays", "Double[]Z"), 
														"Double[]Z");
		// Parse Double Section into a TreeMap
		TreeMap<String, IVariable<Double[]>> section = ParserHelpers.
														ParseDoubleArrayVariableSection(
																this.getSectionCondition(
																		"DoubleArrays"));
		// Fetch key information for variables
		assertEquals("Double[]X", section.firstKey());
		assertEquals("Double[]Z", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}
	
	//***** LONG TESTING SECTION *****\\
	@Test
	public void TestParseLongVariable() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse LongX from the Longs section into an IVariable<Long> compliant container
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
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse LongX from the Longs section into an IVariable<Long> compliant container
		IVariable<Long[]> testVar = ParserHelpers.
										ParseLongArrayVariable(
												this.getVariableCondition(
														"LongArrays", "Long[]X"), 
														"Long[]X");
		
		// Fetch Information about Long Variable
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"Long[]X",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialVariableCondLongArrVals.get(0)[0], 
						testVar.GetValue()[0]
					);
		assertEquals(
						this._initialVariableCondLongArrVals.get(0)[1], 
						testVar.GetValue()[1]
					);
		assertEquals(
						this._initialVariableCondLongArrVals.get(0)[2], 
						testVar.GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	
	@Test
	public void TestLongSectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse LongX, LongY, LongZ from the Longs section into an IVariable<Long> compliant container
		IVariable<Long> testVar = ParserHelpers.
										ParseLongVariable(
												this.getVariableCondition(
														"Longs", "LongX"), 
														"LongX");
		IVariable<Long> testVar2 = ParserHelpers.
										ParseLongVariable(
												this.getVariableCondition(
														"Longs", "LongY"), 
														"LongY");
		IVariable<Long> testVar3 = ParserHelpers.
										ParseLongVariable(
												this.getVariableCondition(
														"Longs", "LongZ"), 
														"LongZ");
		// Parse Long Section into a TreeMap
		TreeMap<String, IVariable<Long>> section = ParserHelpers.
														ParseLongVariableSection(
																this.getSectionCondition(
																		"Longs"));
		// Fetch key information for variables
		assertEquals("LongX", section.firstKey());
		assertEquals("LongZ", section.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
	}

	@Test
	public void TestLongArraySectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse LongX, LongY, LongZ from the Longs section into an IVariable<Long> compliant container
		IVariable<Long[]> testVar = ParserHelpers.
										ParseLongArrayVariable(
												this.getVariableCondition(
														"LongArrays", "Long[]X"), 
														"Long[]X");
		IVariable<Long[]> testVar2 = ParserHelpers.
										ParseLongArrayVariable(
												this.getVariableCondition(
														"LongArrays", "Long[]Y"), 
														"Long[]Y");
		IVariable<Long[]> testVar3 = ParserHelpers.
										ParseLongArrayVariable(
												this.getVariableCondition(
														"LongArrays", "Long[]Z"), 
														"Long[]Z");
		// Parse Long Section into a TreeMap
		TreeMap<String, IVariable<Long[]>> section = ParserHelpers.
														ParseLongArrayVariableSection(
																this.getSectionCondition(
																		"LongArrays"));
		// Fetch key information for variables
		assertEquals("Long[]X", section.firstKey());
		assertEquals("Long[]Z", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}
	
	//***** FLOAT TESTING SECTION *****\\
	@Test
	public void TestParseFloatVariable() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse FloatX from the Floats section into an IVariable<Float> compliant container
		IVariable<Float> testVar = ParserHelpers.
										ParseFloatVariable(
												this.getVariableCondition(
														"Floats", "FloatX"), 
														"FloatX");
		// Fetch Information about Float Variable
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
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse FloatX from the Floats section into an IVariable<Float> compliant container
		IVariable<Float[]> testVar = ParserHelpers.
										ParseFloatArrayVariable(
												this.getVariableCondition(
														"FloatArrays", "Float[]X"), 
														"Float[]X");
		
		// Fetch Information about Float Variable
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"Float[]X",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialVariableCondFloatArrVals.get(0)[0], 
						testVar.GetValue()[0]
					);
		assertEquals(
						this._initialVariableCondFloatArrVals.get(0)[1], 
						testVar.GetValue()[1]
					);
		assertEquals(
						this._initialVariableCondFloatArrVals.get(0)[2], 
						testVar.GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	
	@Test
	public void TestFloatSectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse FloatX, FloatY, FloatZ from the Floats section into an IVariable<Float> compliant container
		IVariable<Float> testVar = ParserHelpers.
										ParseFloatVariable(
												this.getVariableCondition(
														"Floats", "FloatX"), 
														"FloatX");
		IVariable<Float> testVar2 = ParserHelpers.
										ParseFloatVariable(
												this.getVariableCondition(
														"Floats", "FloatY"), 
														"FloatY");
		IVariable<Float> testVar3 = ParserHelpers.
										ParseFloatVariable(
												this.getVariableCondition(
														"Floats", "FloatZ"), 
														"FloatZ");
		// Parse Float Section into a TreeMap
		TreeMap<String, IVariable<Float>> section = ParserHelpers.
														ParseFloatVariableSection(
																this.getSectionCondition(
																		"Floats"));
		// Fetch key information for variables
		assertEquals("FloatX", section.firstKey());
		assertEquals("FloatZ", section.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
	}

	@Test
	public void TestFloatArraySectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse FloatX, FloatY, FloatZ from the Floats section into an IVariable<Float> compliant container
		IVariable<Float[]> testVar = ParserHelpers.
										ParseFloatArrayVariable(
												this.getVariableCondition(
														"FloatArrays", "Float[]X"), 
														"Float[]X");
		IVariable<Float[]> testVar2 = ParserHelpers.
										ParseFloatArrayVariable(
												this.getVariableCondition(
														"FloatArrays", "Float[]Y"), 
														"Float[]Y");
		IVariable<Float[]> testVar3 = ParserHelpers.
										ParseFloatArrayVariable(
												this.getVariableCondition(
														"FloatArrays", "Float[]Z"), 
														"Float[]Z");
		// Parse Float Section into a TreeMap
		TreeMap<String, IVariable<Float[]>> section = ParserHelpers.
														ParseFloatArrayVariableSection(
																this.getSectionCondition(
																		"FloatArrays"));
		// Fetch key information for variables
		assertEquals("Float[]X", section.firstKey());
		assertEquals("Float[]Z", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}
	
	//***** BOOLEAN TESTING SECTION *****\\
	@Test
	public void TestParseBooleanVariable() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse BoolX from the Booleans section into an IVariable<Boolean> compliant container
		IVariable<Boolean> testVar = ParserHelpers.
										ParseBooleanVariable(
												this.getVariableCondition(
														"Booleans", "BoolX"), 
														"BoolX");
		// Fetch Information about Boolean Variable
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
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse BoolX from the Booleans section into an IVariable<Boolean> compliant container
		IVariable<Boolean[]> testVar = ParserHelpers.
										ParseBooleanArrayVariable(
												this.getVariableCondition(
														"BooleanArrays", "Bool[]X"), 
														"Bool[]X");
		
		// Fetch Information about Boolean Variable
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"Bool[]X",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialVariableCondBoolArrVals.get(0)[0], 
						testVar.GetValue()[0]
					);
		assertEquals(
						this._initialVariableCondBoolArrVals.get(0)[1], 
						testVar.GetValue()[1]
					);
		assertEquals(
						this._initialVariableCondBoolArrVals.get(0)[2], 
						testVar.GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	
	@Test
	public void TestBooleanSectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse BoolX, BoolY, BoolZ from the Booleans section into an IVariable<Boolean> compliant container
		IVariable<Boolean> testVar = ParserHelpers.
										ParseBooleanVariable(
												this.getVariableCondition(
														"Booleans", "BoolX"), 
														"BoolX");
		IVariable<Boolean> testVar2 = ParserHelpers.
										ParseBooleanVariable(
												this.getVariableCondition(
														"Booleans", "BoolY"), 
														"BoolY");
		IVariable<Boolean> testVar3 = ParserHelpers.
										ParseBooleanVariable(
												this.getVariableCondition(
														"Booleans", "BoolZ"), 
														"BoolZ");
		// Parse Boolean Section into a TreeMap
		TreeMap<String, IVariable<Boolean>> section = ParserHelpers.
														ParseBooleanVariableSection(
																this.getSectionCondition(
																		"Booleans"));
		// Fetch key information for variables
		assertEquals("BoolX", section.firstKey());
		assertEquals("BoolZ", section.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
	}

	@Test
	public void TestBooleanArraySectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse BoolX, BoolY, BoolZ from the Booleans section into an IVariable<Boolean> compliant container
		IVariable<Boolean[]> testVar = ParserHelpers.
										ParseBooleanArrayVariable(
												this.getVariableCondition(
														"BooleanArrays", "Bool[]X"), 
														"Bool[]X");
		IVariable<Boolean[]> testVar2 = ParserHelpers.
										ParseBooleanArrayVariable(
												this.getVariableCondition(
														"BooleanArrays", "Bool[]Y"), 
														"Bool[]Y");
		IVariable<Boolean[]> testVar3 = ParserHelpers.
										ParseBooleanArrayVariable(
												this.getVariableCondition(
														"BooleanArrays", "Bool[]Z"), 
														"Bool[]Z");
		// Parse Boolean Section into a TreeMap
		TreeMap<String, IVariable<Boolean[]>> section = ParserHelpers.
														ParseBooleanArrayVariableSection(
																this.getSectionCondition(
																		"BooleanArrays"));
		// Fetch key information for variables
		assertEquals("Bool[]X", section.firstKey());
		assertEquals("Bool[]Z", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}
	
	//***** VARIABLES TESTING SECTION *****\\
	@Test
	public void TestVariables() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse each variable section into TreeMaps
		TreeMap<String, IVariable<Integer>> IntSection = ParserHelpers.
															ParseIntegerVariableSection(
																	this.getSectionCondition(
																			"Integers"
																			)
																	);
		TreeMap<String, IVariable<String>> StringSection = ParserHelpers.
															ParseStringVariableSection(
																	this.getSectionCondition(
																			"Strings"
																			)
																	);
		TreeMap<String, IVariable<Double>> DoubleSection = ParserHelpers.
															ParseDoubleVariableSection(
																	this.getSectionCondition(
																			"Doubles"
																			)
																	);
		TreeMap<String, IVariable<Long>> LongSection = ParserHelpers.
															ParseLongVariableSection(
																	this.getSectionCondition(
																			"Longs"
																			)
																	);
		TreeMap<String, IVariable<Float>> FloatSection = ParserHelpers.
															ParseFloatVariableSection(
																	this.getSectionCondition(
																			"Floats"
																			)
																	);
		TreeMap<String, IVariable<Boolean>> BooleanSection = ParserHelpers.
															ParseBooleanVariableSection(
																	this.getSectionCondition(
																			"Booleans"
																			)
																	);
		TreeMap<String, IVariable<Integer[]>> IntArrSection = ParserHelpers.
															ParseIntegerArrayVariableSection(
																	this.getSectionCondition(
																			"IntegerArrays"
																			)
																	);
		TreeMap<String, IVariable<String[]>> StringArrSection = ParserHelpers.
															ParseStringArrayVariableSection(
																	this.getSectionCondition(
																			"StringArrays"
																			)
																	);
		TreeMap<String, IVariable<Double[]>> DoubleArrSection = ParserHelpers.
															ParseDoubleArrayVariableSection(
																	this.getSectionCondition(
																			"DoubleArrays"
																			)
																	);
		TreeMap<String, IVariable<Long[]>> LongArrSection = ParserHelpers.
														ParseLongArrayVariableSection(
																this.getSectionCondition(
																		"LongArrays"
																		)
																);
		TreeMap<String, IVariable<Float[]>> FloatArrSection = ParserHelpers.
														ParseFloatArrayVariableSection(
																this.getSectionCondition(
																		"FloatArrays"
																		)
																);
		TreeMap<String, IVariable<Boolean[]>> BooleanArrSection = ParserHelpers.
														ParseBooleanArrayVariableSection(
																this.getSectionCondition(
																		"BooleanArrays"
																		)
																);
		// Parse all Sections into a Variables Container
		Variables TestContainer = ParserHelpers.ParseVariables(this.getSectionCondition(key));
													
		
	}
}
