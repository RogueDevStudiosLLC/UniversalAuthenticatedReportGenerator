package com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete;
/****************************************
*  Boolean Variable Deserializer		*
*   File Name: 							*
*   BooleanVariableDeserializer.java 	*
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
 * Adapter class to Deserialize Variable objects of subtype Boolean
 * 
 * @author Terry Roberson
 * @author Christopher E. Howard
 * @since 1.0
 */
public class BooleanVariableDeserializer 
	   implements JsonDeserializer<IVariable<Boolean>> 
{
	
	/**
	 * Deserializes into a Variable<Boolean> type
	 * from a given JsonElement, Type, and context
	 * @param JsonElement
	 * @param Type
	 * @param JsonDeserializationContext
	 * @return Variable<Boolean>
	 */
	public IVariable<Boolean> deserialize( 
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
		Boolean _value = null;
		
		/*Temp slot for variable description*/
		String _description = null;
		
		/*Temp slot for variable requiresInput*/
		boolean _requiresInput = false;
		
		/*Temp output object holder*/
		IVariable<Boolean> v;
		
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
			_value = o.get("Value").getAsBoolean();
		}
		
		//If the object has a description, then we grab it
		if(o.has("Description")) {
			_description = o.get("Description").getAsString();
		}
		
		// Build the Variable object to return
		v = new Variable<Boolean>(  _name,
									_id, 
									_requiresInput, 
									_description,
									_value 
								);
		// Return the constructed variable object
		return v;
	}
}
