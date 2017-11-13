package com.roguedevstudios.uarg.JSON.Parser.Serializer;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import com.roguedevstudios.uarg.System.Core.Elements.Variables;
import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

/**
 * Helper class for static methods
 * @author rober
 *
 */
public class ParserHelpers {

	/**
	 * Parses a variable into a Variable<> object
	 * @param JsonElement JsonElement Representation of this Variable
	 * @param ID String ID of this Variable
	 * @param Type VariableType of this Variable
	 * @return Variable<> The non-type specific Variable object of this variable
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static <V> Variable<V> ParseVariable(JsonElement json, String ID, VariableType Type){
		// Get the inner portion of this json
		// Deserialize this into the variable
		// Set the ID of this variable
		// Return the constructed variable
		
		return null;
	}
	
	public static Variable<Integer> ParseIntegerVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with our custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of it for use
		JsonDeserializer<Variable<Integer>> cDeserializer = new IntegerVariableDeserializer();
		// Register the deserializer, notice we do not type cast the class we are pushing to
		// This can be DANGEROUS if not properly tested!
		gsonBuild.registerTypeAdapter(Variable.class, cDeserializer);
		// Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Integer> object
		Variable<Integer> retVar = customGson.fromJson(json, Variable.class);
		// Manually set the ID as the deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	
	
	
	public static Variable<String> ParseStringVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with out custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of
		JsonDeserializer<Variable<String>> cDeserializer = new StringVariableDeserializer();
		// Register the deserializer
		gsonBuild.registerTypeAdapter(Variable.class, cDeserializer);
		//Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<String> object
		Variable<String> retVar = customGson.fromJson(json, Variable.class);
		// Manually set the ID as deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	public static Variable<Double> ParseDoubleVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with out custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of
		JsonDeserializer<Variable<Double>> cDeserializer = new DoubleVariableDeserializer();
		// Register the deserializer
		gsonBuild.registerTypeAdapter(Variable.class, cDeserializer);
		//Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Double> object
		Variable<Double> retVar = customGson.fromJson(json, Variable.class);
		// Manually set the ID as deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	public static Variable<Long> ParseLongVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with out custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of
		JsonDeserializer<Variable<Long>> cDeserializer = new LongVariableDeserializer();
		// Register the deserializer
		gsonBuild.registerTypeAdapter(Variable.class, cDeserializer);
		//Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Long> object
		Variable<Long> retVar = customGson.fromJson(json, Variable.class);
		// Manually set the ID as deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	public static Variable<Float> ParseFloatVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with out custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of
		JsonDeserializer<Variable<Float>> cDeserializer = new FloatVariableDeserializer();
		// Register the deserializer
		gsonBuild.registerTypeAdapter(Variable.class, cDeserializer);
		//Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Float> object
		Variable<Float> retVar = customGson.fromJson(json, Variable.class);
		// Manually set the ID as deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	public static Variable<Boolean> ParseBooleanVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with out custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of
		JsonDeserializer<Variable<Boolean>> cDeserializer = new BooleanVariableDeserializer();
		// Register the deserializer
		gsonBuild.registerTypeAdapter(Variable.class, cDeserializer);
		//Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Boolean> object
		Variable<Boolean> retVar = customGson.fromJson(json, Variable.class);
		// Manually set the ID as deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	// trying to write VariablesParser here 
	
	/*
Break the JSON Element into it's entry set, 
send each entry into VariableSection Parser of the type it needs to go into, 
take the returned 12 maps and construct a Variables object, return the new object.



Variable Section Parser has to use the EntrySet commands already so there will be an example for that in there,
 the use of a child parser is done by that parser as well so again you will have a direct example to work from,
 and you just need to make a new Variables object with the returned maps which will be puked back out to the caller. 
 The most time consuming will be modding the Variables class to have a new constructor for such a format, 
  which will be nearly the same as your _build command
	
	
1. Turn JsonElement into JsonObject
2. Get Entry Set from JsonObject
3. Loop through Entry Set selecting the child parser and output temp var based on the key value
4. Take the maps and make variables object
5. Return the created object
	
// Convert JsonElement into JsonObject to get at the entry sets

// Declare the 12 TreeMaps needed

// Loop through the Entry Set and call the correct parser
// assigning the parsers output to the correct TreeMap

// Check if any tree maps are left null and initialize
// them as empty instead so we have a valid state

// Create a Variables Object using the 12 TreeMaps we got

// Return the Variables object
 * 
 */
	
	
	
	
	
	
	
	JsonObject o = ElementgetAsObject();
	
	TreeMap<String, Variable<Integer>> IntMap;
	TreeMap<String, Variable<Integer[]>> IntegerArrayMap;
	TreeMap<String, Variable<String>> StringMap;
	TreeMap<String, Variable<String[]>> StringArrayMap;
	TreeMap<String, Variable<Float>> FloatMap;
	TreeMap<String, Variable<Float[]>> FloatArrayMap;
	TreeMap<String, Variable<Long>> LongMap;
	TreeMap<String, Variable<Long[]>> LongArrayMap;
	TreeMap<String, Variable<Double>> DoubleMap;
	TreeMap<String, Variable<Double[]>> DoubleArrayMap;
	TreeMap<String, Variable<Boolean>> BooleanMap;
	TreeMap<String, Variable<Boolean[]>> BooleanArrayMap;
	
	for(Map<String, JsonElement> element: o.getEntrySet()) {
		
		switch(element.getKey()) {
		
		case "Integer":
		IntMap = ParserIntegerSection(element.getValue());
		
		case "IntegerArray":
		IntegerArrayMap = ParserIntegerArraySection(element.getValue());
		
		case "String":
	    StringMap = ParserStringSection(element.getValue());
			
		case "StringArray":
		StringArrayMap = ParserStringArraySection(element.getValue());
		
		case "Float":
		FloatMap = ParserFloatSection(element.getValue());
			
		case "FloatArray":
		FloatArrayMap = ParserFloatArraySection(element.getValue());
		
		case "Long":
		LongMap = ParserLongSection(element.getValue());
			
		case "LongArray":
		LongArrayMap = ParserLongArraySection(element.getValue());
		
		case "Double":
		DoubleMap = ParserDoubleSection(element.getValue());
			
		case "DoubleArray":
		DoubleArrayMap = ParserDoubleArraySection(element.getValue());
		
		case "Boolean":
		BooleanMap = ParserBooleanSection(element.getValue());
			
		case "BooleanArray":
		BooleanArrayMap = ParserBooleanArraySection(element.getValue());
		}
	}
	
	Variables v = new Variables(IntMap, IntegerArrayMap, StringMap, StringArrayMap, FloatMap, FloatArrayMap, LongMap, LongArrayMap, DoubleMap, DoubleArrayMap, BooleanMap, BooleanArrayMap);
	
	
	return v;	
	}