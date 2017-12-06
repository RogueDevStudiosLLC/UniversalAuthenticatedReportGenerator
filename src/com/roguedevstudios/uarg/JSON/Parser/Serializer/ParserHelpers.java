//TODO: Cleanup #2 - after primary parsers completed
package com.roguedevstudios.uarg.JSON.Parser.Serializer;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.BooleanArrayVariableDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.BooleanVariableDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.DoubleArrayVariableDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.DoubleVariableDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.FloatArrayVariableDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.FloatVariableDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.IntegerArrayVariableDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.LongArrayVariableDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.LongVariableDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.StringArrayVariableDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.StringVariableDeserializer;
import com.roguedevstudios.uarg.System.Core.Elements.Formula;
import com.roguedevstudios.uarg.System.Core.Elements.FormulaSet;
import com.roguedevstudios.uarg.System.Core.Elements.Formuli;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import com.roguedevstudios.uarg.System.Core.Elements.Variables;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormula;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormuli;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariables;
import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

/**
 * Helper class for static parsing methods
 * @author Terry Roberson
 * @author Christopher E. Howard
 *
 */
public class ParserHelpers {
	
	/**
	 * Parses an Formula JSON representation into an IFormula compliant object
	 * 
	 * @param <T> The specific concrete IFormula return type requested.
	 * @param json The JSON for the IFormula Object to be created
	 * @param IFormulaDeserializer The custom deserializer for the IFormula compatible Concrete Class parsing to
	 * @param IFormulaConcrete The concrete IFormula compliant class to turn this JSON into
	 * 
	 * @return T The specific IFormula object of this formula
	 * 
	 * @throws NullPointerException Exception thrown if any passed parameters are null.
	 * @throws IllegalArgumentException Exception thrown if the arguments do not follow the bounded constraints.
	 * @throws ClassCastException Exception thrown if casting the IFormula to T fails for any reason.
	 * 
	 * @author Terry Roberson
	 * @author Christopher Howard
	 * 
	 * @since 1.0
	 */
	public static 	IFormula
					ParseFormula(
									JsonElement json, 
									JsonDeserializer<? extends IFormula> IFormulaDeserializer, 
									Class<? extends IFormula> IFormulaConcrete, 
									GsonBuilder gsonBuilder
								) 
					throws	NullPointerException,
							IllegalArgumentException,
							ClassCastException
	{
		
		// Check if any arguments were passed as null and throw exception if necessary
		if( json == null || IFormulaDeserializer == null || IFormulaConcrete == null || gsonBuilder == null)
			throw new NullPointerException("Parameters must be instantiated for ParseFormula.");
		
		// Check if IFormulaConcrete is a legal form of IFormula
		if( !IFormulaConcrete.isAssignableFrom(IFormula.class) )
			throw new IllegalArgumentException("IFormulaConcrete must implement IFormula interface.");
		
		// Register the deserializer
		gsonBuilder.registerTypeAdapter(IFormulaConcrete, IFormulaDeserializer);
		
		// Initialize out custom Gson object
		Gson customGson = gsonBuilder.create();
		
		// Deserialize the object to a Formula object
		try {
			IFormula retForm = customGson.fromJson(json, IFormulaConcrete);
			return retForm;
		}
		catch ( ClassCastException eCCE ) {
			throw eCCE;
		}finally {
			customGson = null;
		}
		
	}
	
	/**
	 * Parses a Formula object into a Formula TreeMap
	 * 
	 * @param <T> IFormula compliant class desired as a return
	 * @param json The JSON for the IFormula Object to be created
	 * @param IFormulaDeserializer The custom deserializer for the IFormula compatible Concrete Class parsing to
	 * @param IFormulaConcrete The concrete IFormula compliant class to turn this JSON into
	 * 
	 * @return Map<String,T>	The Formula Set Mapping of IFormula compliant objects
	 * @throws NullPointerException Exception thrown if any passed parameters are null.
	 * @throws IllegalArgumentException Exception thrown if the arguments do not follow the bounded constraints.
	 * @throws ClassCastException Exception thrown if casting the IFormula to T fails for any reason.
	 * @throws UnknownError Unknown Exception has been thrown
	 * @author Terry Roberson
	 * @since 1.0
	 */
	public static 	TreeMap<String, ? extends IFormula> 
					ParseFormulaSet(
									JsonElement json, 
									JsonDeserializer<? extends IFormula> IFormulaDeserializer, 
									Class<? extends IFormula> IFormulaConcrete, 
									GsonBuilder gsonBuilder
								   )
					throws IllegalStateException,
						   NullPointerException,
						   IllegalArgumentException,
						   ClassCastException,
						   UnknownError
			
	{
		try {
			// Take jsonElement and convert to jsonObject
			JsonObject o = json.getAsJsonObject();
			
			// Get the entry set of Formulas to parse
			Set<Map.Entry<String, JsonElement>> JsonForm = o.entrySet();
			
			// Start up the tree map of the formulas
			TreeMap<String, IFormula> map = new TreeMap<>();
			
			// Loop through the formulas
			for(Map.Entry<String, JsonElement> entry: o.entrySet()) {
				
			// Construct the formula and put it in the tree map
				map.put(entry.getKey(), ParserHelpers.<IFormula>ParseFormula( entry.getValue(), IFormulaDeserializer, (Class<? extends IFormula>)IFormulaConcrete, gsonBuilder));
			}
			return map;
		}
		catch (IllegalStateException eISE)		{throw eISE;}
		catch (NullPointerException eNPE)		{throw eNPE;}
		catch (IllegalArgumentException eIAE)	{throw eIAE;}
		catch (ClassCastException eCCE)			{throw eCCE;}
		catch (UnknownError eUE)				{throw eUE;	}
		catch (Exception e)						
			{throw new UnknownError(e.getMessage());}
	}
	
	/**
	 * 
	 */
	public static <E extends IFormuli>
				  void
				  ParseFormuli(
				  JsonElement json, 
				  JsonDeserializer<? extends IFormula> IFormulaDeserializer, 
				  Class<? extends IFormula> IFormulaConcrete,
				  E IFormuliContainer,
				  GsonBuilder gsonBuilder
			) 
			throws IllegalStateException,
			   	   NullPointerException,
			       IllegalArgumentException,
			       ClassCastException,
			       UnknownError
	{

		try {
			
			// Temp maps to use in loading the Formuli parsed
			TreeMap<String, List<String>> SetLinks = new TreeMap<>();
			TreeMap<String,IFormula> FormulaObjects = new TreeMap<>();
			
			// For every section we need the formulas parsed, and the set they link to
			for(Map.Entry<String, JsonElement> section: 
											   json.getAsJsonObject().entrySet()
				) 
			{
				// Container for this sets tracked formula ID's
				List<String> FormulasProcessed = new ArrayList<>();
				
				// Pass the parsing job to our section parser
				TreeMap<String,? extends IFormula> FormulasFromSection =
										ParserHelpers.ParseFormulaSet(
																	section.getValue(),
																	IFormulaDeserializer,
																	IFormulaConcrete,
																	gsonBuilder
																	);
				
				// Add all the formulas created to the master list
				FormulaObjects.putAll(FormulasFromSection);
				
				// Add all the formula ID's to the section link list
				FormulasProcessed.addAll(FormulasFromSection.keySet());
				
				// Enter the formula set record to the set links
				SetLinks.put(section.getKey(), FormulasProcessed);
			}
			
			// Load the formulas into the IFormuli compliant passed object
			IFormuliContainer.LoadFormulas(FormulaObjects);
			
			// Load the set links into the passed IFormuli compliant passed object
			IFormuliContainer.LoadFormulaSets(SetLinks);
			
		}
		catch (IllegalStateException eISE)		{throw eISE;}
		catch (NullPointerException eNPE)		{throw eNPE;}
		catch (IllegalArgumentException eIAE)	{throw eIAE;}
		catch (ClassCastException eCCE)			{throw eCCE;}
		catch (UnknownError eUE)				{throw eUE;	}
		catch (Exception e)						
			{throw new UnknownError(e.getMessage());}
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
	public static IVariable<Integer>
				  ParseIntegerVariable(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends IVariable<Integer> > IVariableDeserializer,
						  				Class<? extends IVariable<Integer>> IVariableConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			IVariableDeserializer == null || 
			IVariableConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( IVariableConcrete, IVariableDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Variable<String> object
			IVariable<Integer> retVar = customGson.fromJson( json, IVariableConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Variable<> Object into a Variable TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
				  TreeMap<String, ? extends IVariable<Integer> > 
			      ParseIntegerVariableSection(
			    		  JsonElement json,
			    		  JsonDeserializer<? extends IVariable<Integer> > IVariableDeserializer,
			    		  Class<? extends IVariable<Integer>> IVariableConcrete,
			    		  GsonBuilder gsonBuilder			    		  
			    		  )
			      throws NullPointerException,
			      		 IllegalArgumentException,
			      		 ClassCastException,
			      		 UnknownError
	{
		try {
			
			// Start up the tree map for these variables
			TreeMap<String, IVariable<Integer> > map = new TreeMap<>();
			
			// Loop through the variables
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the variable and put it in the tree map
			map.put( entry.getKey(), 
					ParserHelpers.
						ParseIntegerVariable( entry.getValue(),
												 entry.getKey(),
												 IVariableDeserializer,
												 IVariableConcrete,
												 gsonBuilder
												 )
					);
			
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
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
	public static <T extends IVariables>
				   T
				   ParseVariables(
											JsonElement JSON,
											Map<VariableType, JsonDeserializer<? extends IVariable<?>>> IVariableDeserializersConcretes,
											Map<VariableType, Class<? extends IVariable<?>>> IVariableConcretes,
											T IVariablesConcrete,
											GsonBuilder gsonBuilder
										  )
	{
		
		// Initialize 12 temp treemaps to match req treemaps for variables.java constructor
		TreeMap<String, ? extends IVariable< Integer   > > 	intMap 			= new TreeMap<>();
		TreeMap<String, ? extends IVariable< Integer[] > > 	intArrayMap 	= new TreeMap<>();
		TreeMap<String, ? extends IVariable< String    > >	stringMap 		= new TreeMap<>();
		TreeMap<String, ? extends IVariable< String[]  > > 	stringArrayMap 	= new TreeMap<>();
		TreeMap<String, ? extends IVariable< Float     > >	floatMap 		= new TreeMap<>();
		TreeMap<String, ? extends IVariable< Float[]   > > 	floatArrayMap 	= new TreeMap<>();
		TreeMap<String, ? extends IVariable< Long      > >	longMap 		= new TreeMap<>();
		TreeMap<String, ? extends IVariable< Long[]    > >	longArrayMap 	= new TreeMap<>();
		TreeMap<String, ? extends IVariable< Double    > >	doubleMap 		= new TreeMap<>();
		TreeMap<String, ? extends IVariable< Double[]  > > 	doubleArrayMap 	= new TreeMap<>();
		TreeMap<String, ? extends IVariable< Boolean   > > 	boolMap 		= new TreeMap<>();
		TreeMap<String, ? extends IVariable< Boolean[] > > 	boolArrayMap 	= new TreeMap<>();
		
		// Loop over entries in the jsonobjects entry sets 
		for(Map.Entry<String, JsonElement> sectionEntry: 
										   JSON.getAsJsonObject().entrySet()) 
		{
			
		// switch based on key of this entry
			switch(sectionEntry.
								getKey().
								toUpperCase()
				  ) 
			{
			// Case Integer for all possible variations of input
			case "INTEGER":
			case "INTEGERS":
				
				Class<? extends IVariable<Integer>> IV = 
					(Class<? extends IVariable<Integer>>) 
					IVariableConcretes.
						get(
								VariableType.INTEGER
							);
				
				JsonDeserializer<? extends IVariable<Integer>> IVD = 
					(JsonDeserializer<? extends IVariable<Integer>>)
					IVariableDeserializersConcretes.
						get(
								VariableType.INTEGER
							);
				
				// Take the previous temp map created from previous section parser and loop over its entries
				for(Map.Entry<String, ? extends IVariable<?>> variableEntry: 
														  ParserHelpers.
														  ParseIntegerVariableSection(
																  					  sectionEntry.getValue(),
																  					  IVD,
																  					  IV,
																  					  gsonBuilder
																  					 ).entrySet()
					) 
				{
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

