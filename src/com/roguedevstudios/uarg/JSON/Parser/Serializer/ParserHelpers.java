//TODO: Cleanup #2 - after primary parsers completed
package com.roguedevstudios.uarg.JSON.Parser.Serializer;

import java.security.KeyStore.Entry;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.roguedevstudios.uarg.System.Core.Elements.Formula;
import com.roguedevstudios.uarg.System.Core.Elements.FormulaSet;
import com.roguedevstudios.uarg.System.Core.Elements.Formuli;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import com.roguedevstudios.uarg.System.Core.Elements.Variables;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormula;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariables;
import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

/**
 * Helper class for static methods
 * @author Terry Roberson
 * @author Christopher E. Howard
 *
 */
public class ParserHelpers {
	
	/**
	 * Parses a Formula into a Formula object
	 * @param JsonElement JsonElement Representation of this Formula
	 * @param ID String ID of this Formula
	 * @param Type FormulaType of this Formula
	 * @return Formula The specific Formula object of this formula
	 * @author Terry Roberson
	 * @since 1.0
	 */
	public static Formula ParseFormula(JsonElement json) {
		// Start the GsonBuilder
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab custom deserializer and create an instance of it for use
		JsonDeserializer<IFormula> cDeserializer = new FormulaDeserializer();
		// Register the deserializer
		gsonBuild.registerTypeAdapter(Formula.class, cDeserializer);
		// Initialize out custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Formula object
		Formula retForm = customGson.fromJson(json, Formula.class);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retForm;
	}
	
	/**
	 * Parses a Formula object into a Formula TreeMap
	 * @return map
	 * @author Terry Roberson
	 * @since 1.0
	 */
	public static TreeMap<String, IFormula> ParseFormulaSet(JsonElement json, String ID){
		// Take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of Formulas to parse
		Set<Map.Entry<String, JsonElement>> JsonForm = o.entrySet();
		// Start up the tree map of the formulas
		TreeMap<String, IFormula> map = new TreeMap<>();
		// Loop through the formulas
		for(Map.Entry<String, JsonElement> entry: o.entrySet()) {
		// Construct the formula and put it in the tree map
			map.put(entry.getKey(), ParserHelpers.ParseFormula(entry.getValue()));
		}
		
		return map;
	}
	
	/**
	 * 
	 */
	public static Formuli ParseFormuli(JsonElement json) {
		// Convert passed jsonelement into json object
		JsonObject o = json.getAsJsonObject();
		// Initialize treemap for formula objects
		TreeMap<String, IFormula> FormMap = new TreeMap<>();
		
	}


	
	public static <V> Variable<V> ParseVariable(JsonElement json, String ID, VariableType Type){
		// Get the inner portion of this json
		// Deserialize this into the variable
		// Set the ID of this variable
		// Return the constructed variable
		
		return null;
	}
	
	//***** INTEGER SECTION ******\\

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
	public static Variable<Integer> ParseIntegerVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with out custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of
		JsonDeserializer<IVariable<Integer>> cDeserializer = new IntegerVariableDeserializer();
		// Register the deserializer
		gsonBuild.registerTypeAdapter(Variable.class, cDeserializer);
		//Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<String> object
		Variable<Integer> retVar = customGson.fromJson(json, Variable.class);
		// Manually set the ID as deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, IVariable<Integer>> ParseIntegerVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String, IVariable<Integer>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseIntegerVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}
	
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
	public static IVariable<Integer[]> ParseIntegerArrayVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with our custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of it for use
		JsonDeserializer<IVariable<Integer[]>> cDeserializer = new IntegerArrayVariableDeserializer();
		// Register the deserializer, notice we do not type cast the class we are pushing to
		// This can be DANGEROUS if not properly tested!
		gsonBuild.registerTypeAdapter(IVariable.class, cDeserializer);
		// Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Integer> object
		IVariable<Integer[]> retVar = customGson.fromJson(json, IVariable.class);
		// Manually set the ID as the deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, IVariable<Integer[]>> ParseIntegerArrayVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String, IVariable<Integer[]>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseIntegerArrayVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}
	
	//***** STRING SECTION *****\\
	public static Variable<String> ParseStringVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with out custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of
		JsonDeserializer<IVariable<String>> cDeserializer = new StringVariableDeserializer();
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
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, IVariable<String>> ParseStringVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String, IVariable<String>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseStringVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}	
	
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
	public static IVariable<String[]> ParseStringArrayVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with our custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of it for use
		JsonDeserializer<IVariable<String[]>> cDeserializer = new StringArrayVariableDeserializer();
		// Register the deserializer, notice we do not type cast the class we are pushing to
		// This can be DANGEROUS if not properly tested!
		gsonBuild.registerTypeAdapter(IVariable.class, cDeserializer);
		// Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Integer> object
		IVariable<String[]> retVar = customGson.fromJson(json, IVariable.class);
		// Manually set the ID as the deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, IVariable<String[]>> ParseStringArrayVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String, IVariable<String[]>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseStringArrayVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}
	
	//***** DOUBLE SECTION *****\\
	public static IVariable<Double> ParseDoubleVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with out custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of
		JsonDeserializer<IVariable<Double>> cDeserializer = new DoubleVariableDeserializer();
		// Register the deserializer
		gsonBuild.registerTypeAdapter(IVariable.class, cDeserializer);
		//Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Double> object
		IVariable<Double> retVar = customGson.fromJson(json, IVariable.class);
		// Manually set the ID as deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, IVariable<Double>> ParseDoubleVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String, IVariable<Double>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseDoubleVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}	
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
	public static IVariable<Double[]> ParseDoubleArrayVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with our custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of it for use
		JsonDeserializer<IVariable<Double[]>> cDeserializer = new DoubleArrayVariableDeserializer();
		// Register the deserializer, notice we do not type cast the class we are pushing to
		// This can be DANGEROUS if not properly tested!
		gsonBuild.registerTypeAdapter(IVariable.class, cDeserializer);
		// Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Integer> object
		IVariable<Double[]> retVar = customGson.fromJson(json, IVariable.class);
		// Manually set the ID as the deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, IVariable<Double[]>> ParseDoubleArrayVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String, IVariable<Double[]>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseDoubleArrayVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}
	
	//***** LONG SECTION *****\\
	public static IVariable<Long> ParseLongVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with out custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of
		JsonDeserializer<IVariable<Long>> cDeserializer = new LongVariableDeserializer();
		// Register the deserializer
		gsonBuild.registerTypeAdapter(IVariable.class, cDeserializer);
		//Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Long> object
		IVariable<Long> retVar = customGson.fromJson(json, IVariable.class);
		// Manually set the ID as deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return 
	 *  
	 * @Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, IVariable<Long>> ParseLongVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String, IVariable<Long>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseLongVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}	
	
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
	public static IVariable<Long[]> ParseLongArrayVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with our custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of it for use
		JsonDeserializer<IVariable<Long[]>> cDeserializer = new LongArrayVariableDeserializer();
		// Register the deserializer, notice we do not type cast the class we are pushing to
		// This can be DANGEROUS if not properly tested!
		gsonBuild.registerTypeAdapter(IVariable.class, cDeserializer);
		// Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Integer> object
		IVariable<Long[]> retVar = customGson.fromJson(json, IVariable.class);
		// Manually set the ID as the deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, IVariable<Long[]>> ParseLongArrayVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String, IVariable<Long[]>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseLongArrayVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}
	
	//***** FLOAT SECTION *****\\
	public static IVariable<Float> ParseFloatVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with out custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of
		JsonDeserializer<IVariable<Float>> cDeserializer = new FloatVariableDeserializer();
		// Register the deserializer
		gsonBuild.registerTypeAdapter(IVariable.class, cDeserializer);
		//Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Float> object
		IVariable<Float> retVar = customGson.fromJson(json, IVariable.class);
		// Manually set the ID as deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return 
	 *  
	 * @Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, IVariable<Float>> ParseFloatVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String, IVariable<Float>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseFloatVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}	

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
	public static IVariable<Float[]> ParseFloatArrayVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with our custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of it for use
		JsonDeserializer<IVariable<Float[]>> cDeserializer = new FloatArrayVariableDeserializer();
		// Register the deserializer, notice we do not type cast the class we are pushing to
		// This can be DANGEROUS if not properly tested!
		gsonBuild.registerTypeAdapter(IVariable.class, cDeserializer);
		// Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Integer> object
		IVariable<Float[]> retVar = customGson.fromJson(json, IVariable.class);
		// Manually set the ID as the deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, IVariable<Float[]>> ParseFloatArrayVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String, IVariable<Float[]>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseFloatArrayVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}
	
	//***** BOOLEAN SECTION *****\\
	public static IVariable<Boolean> ParseBooleanVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with out custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of
		JsonDeserializer<IVariable<Boolean>> cDeserializer = new BooleanVariableDeserializer();
		// Register the deserializer
		gsonBuild.registerTypeAdapter(IVariable.class, cDeserializer);
		//Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Boolean> object
		IVariable<Boolean> retVar = customGson.fromJson(json, IVariable.class);
		// Manually set the ID as deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return 
	 *  
	 * @Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, IVariable<Boolean>> ParseBooleanVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String, IVariable<Boolean>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseBooleanVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}	
	
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
	public static IVariable<Boolean[]> ParseBooleanArrayVariable(JsonElement json, String ID){
		// Start the GsonBuilder so we can customize it with our custom deserializer
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab our custom deserializer and create an instance of it for use
		JsonDeserializer<IVariable<Boolean[]>> cDeserializer = new BooleanArrayVariableDeserializer();
		// Register the deserializer, notice we do not type cast the class we are pushing to
		// This can be DANGEROUS if not properly tested!
		gsonBuild.registerTypeAdapter(IVariable.class, cDeserializer);
		// Initialize our custom Gson object
		Gson customGson = gsonBuild.create();
		// Deserialize the object to a Variable<Integer> object
		IVariable<Boolean[]> retVar = customGson.fromJson(json, IVariable.class);
		// Manually set the ID as the deserializer can not do so normally
		retVar.SetId(ID);
		// Clean up
		gsonBuild = null;
		customGson = null;
		// Return the constructed object to the caller
		return retVar;
	}
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, IVariable<Boolean[]>> ParseBooleanArrayVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String, IVariable<Boolean[]>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseBooleanArrayVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}

	/**		
	 * Parses a Variable sections into the Variables container
	 * @return map
	 * @author Terry Roberson 
	 * @author Christopher Howard
	 * @since 1.0
	 */
	public static Variables ParseVariables(JsonElement json) {
		// Convert passed jsonelement into json object
		JsonObject o = json.getAsJsonObject();
		// Initialize 12 temp treemaps to match req treemaps for variables.java constructor
		TreeMap<String, IVariable<Integer>> intMap = new TreeMap<>();
		TreeMap<String, IVariable<Integer[]>> intArrayMap = new TreeMap<>();
		TreeMap<String, IVariable<String>> stringMap = new TreeMap<>();
		TreeMap<String, IVariable<String[]>> stringArrayMap = new TreeMap<>();
		TreeMap<String, IVariable<Float>> floatMap = new TreeMap<>();
		TreeMap<String, IVariable<Float[]>> floatArrayMap = new TreeMap<>();
		TreeMap<String, IVariable<Long>> longMap = new TreeMap<>();
		TreeMap<String, IVariable<Long[]>> longArrayMap = new TreeMap<>();
		TreeMap<String, IVariable<Double>> doubleMap = new TreeMap<>();
		TreeMap<String, IVariable<Double[]>> doubleArrayMap = new TreeMap<>();
		TreeMap<String, IVariable<Boolean>> boolMap = new TreeMap<>();
		TreeMap<String, IVariable<Boolean[]>> boolArrayMap = new TreeMap<>();
		
		// Loop over entries in the jsonobjects entry sets 
		for(Map.Entry<String, JsonElement> sectionEntry: o.entrySet()) {
		// switch based on key of this entry
			
			switch(sectionEntry.getKey().toUpperCase()) {
		// Case Integer for all possible variations of input
			case "INTEGER":
			case "INTEGERS":
		// Take the previous temp map created from previous section parser and loop over its entries
				for(Map.Entry<String, IVariable<Integer>> variableEntry: ParseIntegerVariableSection(sectionEntry.getValue()).entrySet()) {
		// Call the first temp integer map from top and put key and value as this entries value
					intMap.put(variableEntry.getKey(), variableEntry.getValue());
				}
				break;
		// Case IntegerArray for all possible variations of input
			case "INTEGERARRAY":
			case "INTEGERSARRAY":
			case "INTEGERARRAYS":
			case "INTEGERSARRAYS":
			case "INTEGER ARRAY":
			case "INTEGERS ARRAY":
			case "INTEGER ARRAYS":
			case "INTEGERS ARRAYS":
		// Take the previous temp map created from previous section parser and loop over its entries 
				for(Map.Entry<String, IVariable<Integer[]>> variableEntry: ParseIntegerArrayVariableSection(sectionEntry.getValue()).entrySet()) {
		// Call the first temp Integer[] map from top and put key and value as this entries value
					intArrayMap.put(variableEntry.getKey(), variableEntry.getValue());
				}
				break;
		// Case String for all possible variations of input
			case "STRING":
			case "STRINGS":
		// Take the previous temp map created from previous section parser and loop over its entries
				for(Map.Entry<String, IVariable<String>> variableEntry: ParseStringVariableSection(sectionEntry.getValue()).entrySet()) {
		// Call the first temp String map from the top and put key and value as this entries value
					stringMap.put(variableEntry.getKey(), variableEntry.getValue());
				}
				break;
		// Case String[] for all possible variations of input
			case "STRINGARRAY":
			case "STRINGSARRAY":
			case "STRINGARRAYS":
			case "STRINGSARRAYS":
			case "STRING ARRAY":
			case "STRINGS ARRAY":
			case "STRING ARRAYS":
			case "STRINGS ARRAYS":
		// Take the previous temp map created from previous section parser and loop over its entries
				for(Map.Entry<String, IVariable<String[]>> variableEntry: ParseStringArrayVariableSection(sectionEntry.getValue()).entrySet()) {
		// Call the first temp String[] map from top and put key and value as this entries value
					stringArrayMap.put(variableEntry.getKey(), variableEntry.getValue());
				}
				break;
		// Case Double for all possible variations of input
			case "DOUBLE":
			case "DOUBLES":
		// Take the previous temp map created from previous section parser and loop over its entries
				for(Map.Entry<String, IVariable<Double>> variableEntry: ParseDoubleVariableSection(sectionEntry.getValue()).entrySet()) {
		// Call the first temp double map from the top and put key and value as this entries value
					doubleMap.put(variableEntry.getKey(), variableEntry.getValue());
				}
				break;
		// Case Float for all possible variations of input
			case "FLOAT":
			case "FLOATS":
		// Take the previous temp map created from previous section parser and loop over its entries
				for(Map.Entry<String, IVariable<Float>> variableEntry: ParseFloatVariableSection(sectionEntry.getValue()).entrySet()) {
		// Call the first temp Float map from the tope and put key and value as this entries value
					floatMap.put(variableEntry.getKey(), variableEntry.getValue());
				}
				break;
		// Case Long[] for all possible variations of input
			case "FLOATARRAY":
			case "FLOATSARRAY":
			case "FLOATARRAYS":
			case "FLOATSARRAYS":
			case "FLOAT ARRAY":
			case "FLOATS ARRAY":
			case "FLOAT ARRAYS":
			case "FLOATS ARRAYS":
		// Take the previous temp map created from previous section parser and loop over its entries 
			for(Map.Entry<String, IVariable<Float[]>> variableEntry: ParseFloatArrayVariableSection(sectionEntry.getValue()).entrySet()) {
		// Call the first temp Float[] map from top and put key and value as this entries value
				floatArrayMap.put(variableEntry.getKey(), variableEntry.getValue());
			}
			break;
		// Case Long for all possible variations of input
			case "LONG":
			case "LONGS":
		// Take the previous temp map created from previous section parser and loop over its entries
			for(Map.Entry<String, IVariable<Long>> variableEntry: ParseLongVariableSection(sectionEntry.getValue()).entrySet()) {
		// call the first temp long map from top and put key and value as this entries value
				longMap.put(variableEntry.getKey(), variableEntry.getValue());
			}
			break;
		// Case Long[] for all possible variations of input
			case "LONGARRAY":
			case "LONGSARRAY":
			case "LONGARRAYS":
			case "LONGSARRAYS":
			case "LONG ARRAY":
			case "LONGS ARRAY":
			case "LONG ARRAYS":
			case "LONGS ARRAYS":
		// Take the previous temp map created from previous section parser and loop over its entries 
			for(Map.Entry<String, IVariable<Long[]>> variableEntry: ParseLongArrayVariableSection(sectionEntry.getValue()).entrySet()) {
		// Call the first temp Integer[] map from top and put key and value as this entries value
					longArrayMap.put(variableEntry.getKey(), variableEntry.getValue());
			}
			break;			
		// Case Double[] for all possible variations of input
			case "DOUBLEARRAY":
			case "DOUBLESARRAY":
			case "DOUBLEARRAYS":
			case "DOUBLESARRAYS":
			case "DOUBLE ARRAY":
			case "DOUBLES ARRAY":
			case "DOUBLE ARRAYS":
			case "DOUBLES ARRAYS":
		// Take the previous temp map created from previous section parser and loop over its entries
				for(Map.Entry<String, IVariable<Double[]>> variableEntry: ParseDoubleArrayVariableSection(sectionEntry.getValue()).entrySet()) {
		// Call the first temp double[] map from top and put key and value as this entries value
					doubleArrayMap.put(variableEntry.getKey(), variableEntry.getValue());
				}
				break;
		// Case Boolean for all possible variations of input
			case "BOOLEAN":
			case "BOOLEANS":
		// Take the previous temp map created from previous section parser and loop over its entries
			for(Map.Entry<String, IVariable<Boolean>> variableEntry: ParseBooleanVariableSection(sectionEntry.getValue()).entrySet()) {
		// Call the first temp Boolean map from top and put key and value as this entries value		
				boolMap.put(variableEntry.getKey(), variableEntry.getValue());
			}
			break;
		// Case Long[] for all possible variations of input
			case "BOOLEANARRAY":
			case "BOOLEANSARRAY":
			case "BOOLEANARRAYS":
			case "BOOLEANSARRAYS":
			case "BOOLEAN ARRAY":
			case "BOOLEANS ARRAY":
			case "BOOLEAN ARRAYS":
			case "BOOLEANS ARRAYS":
		// Take the previous temp map created from previous section parser and loop over its entries
			for(Map.Entry<String, IVariable<Boolean[]>> variableEntry: ParseBooleanArrayVariableSection(sectionEntry.getValue()).entrySet()) {
		// Call the first temp Boolean[] map from top and put key and value as this entries value				
				boolArrayMap.put(variableEntry.getKey(), variableEntry.getValue());
			}
			break;
		// Break from the switch statement
			default:
			break;
			}
		
		}
		// Build the Variables Object 
				Variables v = new Variables(intMap, intArrayMap, 
											stringMap, stringArrayMap, 
											floatMap, floatArrayMap, 
											longMap, longArrayMap,
											doubleMap, doubleArrayMap, 
											boolMap, boolArrayMap);
				// Return Variables Object
				return v;
				
	}
}

