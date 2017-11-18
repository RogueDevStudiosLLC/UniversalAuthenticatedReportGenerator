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
 * @author Terry Roberson
 * @author Christopher E. Howard
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

	//***** INTEGER SECTION ******\\
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
	

	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return 
	 *  
	 * @Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, Variable<Integer>> ParseIntegerVariableSection(JsonElement json){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String,Variable<Integer>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseIntegerVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}	
	
	//***** STRING SECTION *****\\
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
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return 
	 *  
	 * @Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, Variable<String>> ParseStringVariableSection(JsonElement json, String ID){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String,Variable<String>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseStringVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}	
	
	//***** DOUBLE SECTION *****\\
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
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return 
	 *  
	 * @Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, Variable<Double>> ParseDoubleVariableSection(JsonElement json, String ID){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String,Variable<Double>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseDoubleVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}	
	
	//***** LONG SECTION *****\\
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
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return 
	 *  
	 * @Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, Variable<Long>> ParseLongVariableSection(JsonElement json, String ID){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String,Variable<Long>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseLongVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}	
	
	//***** FLOAT SECTION *****\\
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
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return 
	 *  
	 * @Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, Variable<Float>> ParseFloatVariableSection(JsonElement json, String ID){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String,Variable<Float>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseFloatVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
}	

	
	//***** BOOLEAN SECTION *****\\
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

	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return 
	 *  
	 * @Terry Roberson 
	 * @since 1.0
	 */
	public static TreeMap<String, Variable<Boolean>> ParseBooleanVariableSection(JsonElement json, String ID){
		//take jsonElement and convert to jsonObject
		JsonObject o = json.getAsJsonObject();
		// Get the entry set of variables to parse
		Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();
		// Start up the tree map for these variables
		TreeMap<String,Variable<Boolean>> map = new TreeMap<>();
		// Loop through the variables
		for(Map.Entry<String,JsonElement> entry: o.entrySet()){
		// Construct the variable and put it in the tree map
		map.put(entry.getKey(), ParserHelpers.ParseBooleanVariable(entry.getValue(), entry.getKey()));
		
	}
		return map;
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
	
	*/
	/**
	 * Parses a variable into a Variable<> object
	 * @param JsonElement JsonElement Representation of this Variable
	 * @param ID String ID of this Variable
	 * @param Type VariableType of this Variable
	 * @return Variable<> The non-type specific Variable object of this variable
	 * @author Grant Richards
	 * @since 1.0
	 */
	public static Variables ParseVariables(JsonElement json,VariableType Type){

	// Convert JsonElement into JsonObject to get at the entry sets
	JsonObject o = json.getAsObject();
	
	
	// Declare the 12 TreeMaps needed
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
	

	
	// Loop through the Entry Set and call the correct parser
	// assigning the parsers output to the correct TreeMap
	
	for(i = 0; i<sections; i++) {
		
		switch(element.getKey()) {
		
		
		
		case "Integer":
			IntMap = ParserIntegerSection(element.getKey());
			
		/**		
		 * Parses a Variable<> Object into a Variable TreeMap
		 * @return 
		 * 
		 * @Grant Richards 
		 * @since 1.0
		 */


		public static TreeMap<String, Variable<String>> ParseIntegerVariablesSection(JsonElement json, String ID){


			//take jsonElement and convert to jsonObject


			JsonObject o = json.getAsJsonObject();


			// Get the entry set of variables to parse


			Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();


			// Start up the tree map for these variables


			TreeMap<String,Variables> map = new TreeMap<>();


			// Loop through the variables


			for(Map.Entry<String,JsonElement> entry: o.entrySet()){


			// Construct the variable and put it in the tree map


			map.put(entry.getKey(), ParserHelpers.ParseIntegerVariables(entry.getValue(), entry.getKey()));


			


		}


			return map;


	}	
			break;
		
		case "IntegerArray":
			IntegerArrayMap = ParserIntegerArraySection(element.getKey());
			
		 /**		
		 * Parses a Variable<> Object into a Variable TreeMap
		 * @return 
		 * 
		 * @Grant Richards 
		 * @since 1.0
		 */


		public static TreeMap<String, Variable<String>> ParseIntegerArrayVariablesSection(JsonElement json, String ID){


			//take jsonElement and convert to jsonObject


			JsonObject o = json.getAsJsonObject();


			// Get the entry set of variables to parse


			Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();


			// Start up the tree map for these variables


			TreeMap<String,Variables> map = new TreeMap<>();


			// Loop through the variables


			for(Map.Entry<String,JsonElement> entry: o.entrySet()){


			// Construct the variable and put it in the tree map


			map.put(entry.getKey(), ParserHelpers.ParseIntegerArrayVariables(entry.getValue(), entry.getKey()));


			


		}


			return map;


	}	
			
			
			
			
			break;
		
		case "String":
			StringMap = ParserStringSection(element.getKey());
			
			
			
		/**		
		 * Parses a Variable<> Object into a Variable TreeMap
		 * @return 
		 * 
		 * @Grant Richards 
		 * @since 1.0
		 */


		public static TreeMap<String, Variable<String>> ParseStringVariablesSection(JsonElement json, String ID){


			//take jsonElement and convert to jsonObject


			JsonObject o = json.getAsJsonObject();


			// Get the entry set of variables to parse


			Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();


			// Start up the tree map for these variables


			TreeMap<String,Variables> map = new TreeMap<>();


			// Loop through the variables


			for(Map.Entry<String,JsonElement> entry: o.entrySet()){


			// Construct the variable and put it in the tree map


			map.put(entry.getKey(), ParserHelpers.ParseStringVariables(entry.getValue(), entry.getKey()));


			


		}


			return map;


	}	
			
			
			break;
	    
		case "StringArray":
			StringArrayMap = ParserStringArraySection(element.getKey());
			
			
		 /**		
		 * Parses a Variable<> Object into a Variable TreeMap
		 * @return 
		 * 
		 * @Grant Richards 
		 * @since 1.0
		 */


		public static TreeMap<String, Variable<String>> ParseStringArrayVariablesSection(JsonElement json, String ID){


			//take jsonElement and convert to jsonObject


			JsonObject o = json.getAsJsonObject();


			// Get the entry set of variables to parse


			Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();


			// Start up the tree map for these variables


			TreeMap<String,Variables> map = new TreeMap<>();


			// Loop through the variables


			for(Map.Entry<String,JsonElement> entry: o.entrySet()){


			// Construct the variable and put it in the tree map


			map.put(entry.getKey(), ParserHelpers.ParseStringArrayVariables(entry.getValue(), entry.getKey()));


			


		}


			return map;


	}	
			
			
			break;
		
		case "Float":
			FloatMap = ParserFloatSection(element.getKey());
			
			
		 /**		
		 * Parses a Variable<> Object into a Variable TreeMap
		 * @return 
		 * 
		 * @Grant Richards 
		 * @since 1.0
		 */


		public static TreeMap<String, Variable<String>> ParseFloatVariablesSection(JsonElement json, String ID){


			//take jsonElement and convert to jsonObject


			JsonObject o = json.getAsJsonObject();


			// Get the entry set of variables to parse


			Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();


			// Start up the tree map for these variables


			TreeMap<String,Variables> map = new TreeMap<>();


			// Loop through the variables


			for(Map.Entry<String,JsonElement> entry: o.entrySet()){


			// Construct the variable and put it in the tree map


			map.put(entry.getKey(), ParserHelpers.ParseFloatVariables(entry.getValue(), entry.getKey()));


			


		}


			return map;


	}		
			break;
		
		case "FloatArray":
			FloatArrayMap = ParserFloatArraySection(element.getKey());
			
		 /**		
		 * Parses a Variable<> Object into a Variable TreeMap
		 * @return 
		 * 
		 * @Grant Richards 
		 * @since 1.0
		 */


		public static TreeMap<String, Variable<String>> ParseFloatArrayVariablesSection(JsonElement json, String ID){


			//take jsonElement and convert to jsonObject


			JsonObject o = json.getAsJsonObject();


			// Get the entry set of variables to parse


			Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();


			// Start up the tree map for these variables


			TreeMap<String,Variables> map = new TreeMap<>();


			// Loop through the variables


			for(Map.Entry<String,JsonElement> entry: o.entrySet()){


			// Construct the variable and put it in the tree map


			map.put(entry.getKey(), ParserHelpers.ParseFloatArrayVariables(entry.getValue(), entry.getKey()));


			


		}


			return map;


	}	
			
			break;
		
		case "Long":
			LongMap = ParserLongSection(element.getKey());
			
		 /**		
		 * Parses a Variable<> Object into a Variable TreeMap
		 * @return 
		 * 
		 * @Grant Richards 
		 * @since 1.0
		 */


		public static TreeMap<String, Variable<String>> ParseLongVariablesSection(JsonElement json, String ID){


			//take jsonElement and convert to jsonObject


			JsonObject o = json.getAsJsonObject();


			// Get the entry set of variables to parse


			Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();


			// Start up the tree map for these variables


			TreeMap<String,Variables> map = new TreeMap<>();


			// Loop through the variables


			for(Map.Entry<String,JsonElement> entry: o.entrySet()){


			// Construct the variable and put it in the tree map


			map.put(entry.getKey(), ParserHelpers.ParseLongVariables(entry.getValue(), entry.getKey()));


			


		}


			return map;


	}	
			
			break;
		
		case "LongArray":
			LongArrayMap = ParserLongArraySection(element.getKey());
			
		/**		
		 * Parses a Variable<> Object into a Variable TreeMap
		 * @return 
		 * 
		 * @Grant Richards 
		 * @since 1.0
		 */


		public static TreeMap<String, Variable<String>> ParseLongArrayVariablesSection(JsonElement json, String ID){


			//take jsonElement and convert to jsonObject


			JsonObject o = json.getAsJsonObject();


			// Get the entry set of variables to parse


			Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();


			// Start up the tree map for these variables


			TreeMap<String,Variables> map = new TreeMap<>();


			// Loop through the variables


			for(Map.Entry<String,JsonElement> entry: o.entrySet()){


			// Construct the variable and put it in the tree map


			map.put(entry.getKey(), ParserHelpers.ParseLongArrayVariables(entry.getValue(), entry.getKey()));


			


		}


			return map;


	}	
			
			break;
		
		case "Double":
			DoubleMap = ParserDoubleSection(element.getKey());
			
					/**		
		 * Parses a Variable<> Object into a Variable TreeMap
		 * @return 
		 * 
		 * @Grant Richards 
		 * @since 1.0
		 */


		public static TreeMap<String, Variable<String>> ParseDoubleVariablesSection(JsonElement json, String ID){


			//take jsonElement and convert to jsonObject


			JsonObject o = json.getAsJsonObject();


			// Get the entry set of variables to parse


			Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();


			// Start up the tree map for these variables


			TreeMap<String,Variables> map = new TreeMap<>();


			// Loop through the variables


			for(Map.Entry<String,JsonElement> entry: o.entrySet()){


			// Construct the variable and put it in the tree map


			map.put(entry.getKey(), ParserHelpers.ParseDoubleVariables(entry.getValue(), entry.getKey()));


			


		}


			return map;


	}	
			
			break;
		
		case "DoubleArray":
			DoubleArrayMap = ParserDoubleArraySection(element.getKey());
			
		 /**		
		 * Parses a Variable<> Object into a Variable TreeMap
		 * @return 
		 * 
		 * @Grant Richards 
		 * @since 1.0
		 */


		public static TreeMap<String, Variable<String>> ParseDoubleArrayVariablesSection(JsonElement json, String ID){


			//take jsonElement and convert to jsonObject


			JsonObject o = json.getAsJsonObject();


			// Get the entry set of variables to parse


			Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();


			// Start up the tree map for these variables


			TreeMap<String,Variables> map = new TreeMap<>();


			// Loop through the variables


			for(Map.Entry<String,JsonElement> entry: o.entrySet()){


			// Construct the variable and put it in the tree map


			map.put(entry.getKey(), ParserHelpers.ParseDoubleArrayVariables(entry.getValue(), entry.getKey()));


			


		}


			return map;


	}	
			
			break;
		
		case "Boolean":
			BooleanMap = ParserBooleanSection(element.getKey());
			
			
		 /**		
		 * Parses a Variable<> Object into a Variable TreeMap
		 * @return 
		 * 
		 * @Grant Richards 
		 * @since 1.0
		 */


		public static TreeMap<String, Variable<String>> ParseBooleanVariablesSection(JsonElement json, String ID){


			//take jsonElement and convert to jsonObject


			JsonObject o = json.getAsJsonObject();


			// Get the entry set of variables to parse


			Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();


			// Start up the tree map for these variables


			TreeMap<String,Variables> map = new TreeMap<>();


			// Loop through the variables


			for(Map.Entry<String,JsonElement> entry: o.entrySet()){


			// Construct the variable and put it in the tree map


			map.put(entry.getKey(), ParserHelpers.ParseBooleanVariables(entry.getValue(), entry.getKey()));


			


		}


			return map;


	}	
			
			break;
		
		case "BooleanArray":
			BooleanArrayMap = ParserBooleanArraySection(element.getKey());
			
		 /**		
		 * Parses a Variable<> Object into a Variable TreeMap
		 * @return 
		 * 
		 * @Grant Richards 
		 * @since 1.0
		 */


		public static TreeMap<String, Variable<String>> ParseBooleanArrayVariablesSection(JsonElement json, String ID){


			//take jsonElement and convert to jsonObject


			JsonObject o = json.getAsJsonObject();


			// Get the entry set of variables to parse


			Set<Map.Entry<String,JsonElement>> JsonVars = o.entrySet();


			// Start up the tree map for these variables


			TreeMap<String,Variables> map = new TreeMap<>();


			// Loop through the variables


			for(Map.Entry<String,JsonElement> entry: o.entrySet()){


			// Construct the variable and put it in the tree map


			map.put(entry.getKey(), ParserHelpers.ParseBooleanArrayVariables(entry.getValue(), entry.getKey()));


			


		}


			return map;


	}	
	
			break;
		
		}
	}
	
	for(j = 0; j<=entries; j++){
		
	// copy to corresponding map	
		
		
		
		
	}
	
	/*** Null Check ***/
	if(IntMap == null)
		IntMap = new TreeMap<String,Variable<Integer>>();
	
	if(IntegerArrayMap == null)
		IntegerArrayMap = new TreeMap<String,Variable<Integer[]>>();
	
	if(StringMap == null)
		StringMap = new TreeMap<String,Variable<String>>();
	
	if(StringArrayMap == null)
		StringArrayMap = new TreeMap<String,Variable<String[]>>();
	
	if(FloatMap == null)
		FloatMap = new TreeMap<String,Variable<Float>>();
	
	if(FloatArrayMap == null)
		FloatArrayMap = new TreeMap<String,Variable<Float[]>>();
	
	if(LongMap == null)
		LongMap = new TreeMap<String,Variable<Long>>();
	
	if(LongArrayMap == null)
		LongArrayMap = new TreeMap<String,Variable<Long[]>>();
	
	if(DoubleMap == null)
		DoubleMap = new TreeMap<String,Variable<Double>>();
	
	if(DoubleArrayMap == null)
		DoubleArrayMap = new TreeMap<String,Variable<Double[]>>();
	
	if(BooleanMap == null)
		BooleanMap = new TreeMap<String,Variable<Boolean>>();
	
	if(BooleanArrayMap == null)
		BooleanArrayMap = new TreeMap<String,Variable<Boolean[]>>();
	
	// Create a Variables Object using the 12 TreeMaps we got
	// wrong fix this area. Correct now?
	Variables container = new Variables(IntMap,IntegerArrayMap, StringMap,
			                    StringArrayMap, FloatMap, FloatArrayMap, LongMap, 
			                    LongArrayMap, DoubleMap, DoubleArrayMap, BooleanMap, BooleanArrayMap );
	
	// Return the Variables object
	
	return container;	
	}

	
}