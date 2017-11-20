package com.roguedevstudios.uarg.JSON.Parser.Serializer;
/****************************************
*  Long Variable Deserializer			*
*   File Name: 							*
*   LongVariableDeserializer.java 	*
*                            	   	    *
*   Deserializes JSON					*
*   information and converts			*
*   into Java objects	        		*
*                               		*
*  �2017 Rogue Dev Studios, LLC 		*
*****************************************/

import java.lang.reflect.Type;

import com.google.gson.*;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;

/**
 * 
 * Adapter class to Deserialize Variable objects of subtype Long
 * 
 * @author Terry Roberson
 * @author Christopher E. Howard
 * @since 1.0
 */
public class LongVariableDeserializer 
	   implements JsonDeserializer<Variable<Long>> 
{
	/**
	 * Deserializes into a Variable<Long> type
	 * from a given JsonElement, Type, and context
	 * @param JsonElement
	 * @param Type
	 * @param JsonDeserializationContext
	 * @return Variable<Long>
	 */
	
	public Variable<Long> deserialize(
										JsonElement json, 
										Type typeOfT, 
										JsonDeserializationContext context
									 )
									throws JsonParseException 
	{
		
		/*Temp slot for variable name*/
		String _name = null;
		
		/*Temp slot for variable ID*/
		String _id = null;
		
		/*Temp slot for variable value*/
		Long _value = null;
		
		/*Temp slot for variable description*/
		String _description = null;
		
		/*Temp slot for variable requiresInput*/
		boolean _requiresInput = false;
		
		/*Temp output object holder*/
		Variable<Long> v;
		
		// Convert JsonElement into JsonObject
		JsonObject o = json.getAsJsonObject();
		
		// If the object has a name, then we grab it
		if( o.has("name") ) 
			_name = o.get("name").getAsString();
		
		// If the object has an ID, then we grab it
		if( o.has("ID") )
			_id = o.get("ID").getAsString();
		
		// If the object has a value, then we grab it
		if( o.has("value") ) 
			_value = o.get("value").getAsLong();
		
		// If the object has a description, then we grab it
		if( o.has("description") ) 
			_description = o.get("description").getAsString();
		
		// Build the Variable object to return
		v = new Variable<Long>(	_name, 
								_id, 
								_requiresInput, 
								_description, 
								_value
							  );
		// Return the constructed variable object	
		return v;
	}
}