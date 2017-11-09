package com.roguedevstudios.uarg.JSON.Parser.Serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.roguedevstudios.uarg.System.Core.Elements.Formula;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
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
	
	public static Formula ParseFormula(JsonElement json, String ID) {
		// Start the GsonBuilder
		GsonBuilder gsonBuild = new GsonBuilder();
		// Grab custom deserializer and create an instance of it for use
		JsonDeserializer<Formula> cDeserializer = new FormulaDeserializer();
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
	
	
}