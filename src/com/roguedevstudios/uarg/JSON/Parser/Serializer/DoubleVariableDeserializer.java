package com.roguedevstudios.uarg.JSON.Parser.Serializer;
/****************************************
*  Double Variable Deserializer			*
*   File Name: 							*
*   DoubleVariableDeserializer.java 	*
*                            	   	    *
*   Deserializes JSON					*
*   information and converts			*
*   into Java objects	        		*
*                               		*
*  ©2017 Rogue Dev Studios, LLC 		*
*****************************************/

import java.lang.reflect.Type;

import com.google.gson.*;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;

/**
 * <p>
 * converts Variable.json information into Java Objects
 * <p>
 * 
 * @author Terry Roberson
 * @since 1.0
 */
public class DoubleVariableDeserializer implements JsonDeserializer<Variable<Double>> {
	/**
	 * Deserializes into a Variable<Double> type
	 * from a given JsonElement, Type, and context
	 * @param JsonElement
	 * @param Type
	 * @param JsonDeserializationContext
	 * @return Variable<Double>
	 */
	
	public Variable<Double> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		/*Temp slot for variable name*/
		String _name = null;
		/*Temp slot for variable ID*/
		String _id = null;
		/*Temp slot for variable value*/
		Double _value = null;
		/*Temp slot for variable description*/
		String _description = null;
		/*Temp slot for variable requiresInput*/
		boolean _requiresInput = false;
		/*Temp output object holder*/
		Variable<Double> v;
		
		/* Convert JsonElement into JsonObject */
		JsonObject o = json.getAsJsonObject();
		
		//If the object has a name, then we grab it
		if(o.has("name")) {
			_name = o.get("name").getAsString();
		}
		
		//If the object has an ID, then we grab it
		if(o.has("ID")) {
			_id = o.get("ID").getAsString();
		}
		
		//If the object has a value, then we grab it
		if(o.has("value")) {
			_value = o.get("value").getAsDouble();
		}
		
		//If the object has a description, then we grab it
		if(o.has("description")) {
			_description = o.get("description").getAsString();
		}
		
		//Build the Variable object to return
		v = new Variable<Double>(_name, _id, _requiresInput, _description, _value);
			
		return v;
	}
}