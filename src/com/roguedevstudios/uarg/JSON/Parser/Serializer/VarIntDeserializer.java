package com.roguedevstudios.uarg.JSON.Parser.Serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import com.roguedevstudios.uarg.System.Core.Elements.Variable;

public class VarIntDeserializer implements JsonDeserializer<Variable<Integer>> {

	/**
	 * Deserializes into a Variable<Integer> type
	 * from a given JsonElement, Type, and context
	 * @param JsonElement
	 * @param Type
	 * @param JsonDeserializationContext
	 * @return Variable<Integer>
	 */
	public Variable<Integer> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		// Temp slots for variable parts
		String name = null;
		String id = null;
		Integer val = null;
		String desc = null;
		boolean InpReq = false;
		// Temp output object holder
		Variable<Integer> v;
		
		// Convert JsonElement into JsonObject as we know that's what we are making is an object
		JsonObject o = json.getAsJsonObject();
	
		// If the object has the field, then we grab it.
		if(o.has("name")){
			name = o.get("name").getAsString();
		}
		if(o.has("id")){
			id = o.get("id").getAsString();
		}
		if(o.has("value")){
			// Integer is not an int, so we convert it
			val = new Integer(o.get("value").getAsInt());
		}
		if(o.has("description")){
			desc = o.get("description").getAsString();
		}
		// Build the Variable object to return
		v = new Variable<Integer>(name, id, InpReq, desc, val);
		
		
		return v;
	}

}
