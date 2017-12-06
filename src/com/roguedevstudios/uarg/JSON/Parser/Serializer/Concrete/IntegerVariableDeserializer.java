package com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete;
/****************************************
*  Integer Variable Deserializer		*
*   File Name: 							*
*   IntegerVariableDeserializer.java 	*
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
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;

/**
 * 
 * Adapter class to Deserialize Variable objects of subtype Integer
 * 
 * @author Christopher Howard
 * @author Terry Roberson
 * @since 1.0
 */
public class IntegerVariableDeserializer 
	   implements JsonDeserializer<IVariable<Integer>> 
{

	/**
	 * Deserializes into a Variable<Integer> type
	 * from a given JsonElement, Type, and context
	 * @param JsonElement
	 * @param Type
	 * @param JsonDeserializationContext
	 * @return Variable<Integer>
	 */
	public IVariable<Integer> deserialize(
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
		Integer _value = null;
		
		/*Temp slot for variable description*/
		String _description = null;
		
		/*Temp slot for variable requiresInput*/
		boolean _requiresInput = false;
		
		/*Temp output object holder*/
		IVariable<Integer> v;
		
		// Convert JsonElement into JsonObject 
		JsonObject o = json.getAsJsonObject();
		
		//If the object has a name, then we grab it
		if(o.has("Name")) {
			_name = o.get("Name").getAsString();
		}
		
		// If the object has an ID, then we grab it
		if( o.has("ID") ) 
			_id = o.get("ID").getAsString();
		
		//If the object has a value, then we grab it
		if(o.has("Value")) {
			_value = o.get("Value").getAsInt();
		}
		
		//If the object has a description, then we grab it
		if(o.has("Description")) {
			_description = o.get("Description").getAsString();
		}
		
		v = new Variable<Integer>(  _name,
				  					_id, 
				  					_requiresInput, 
				  					_description,
				  					_value 
								 );

		// Return the constructed variable object	
		return v;
	}
}
