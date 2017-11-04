package com.roguedevstudios.uarg.JSON.Parser.Serializer;

import com.google.gson.*;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

public static Variable<Integer> ParseVariable(JsonElement json, String ID){
		JsonObject jsonObject = json.getAsJsonObject();
		Variable<Integer> var;
		
		
		var = (Variable<Integer>) DeserializedItem;
		return new Variable<Integer>(
				jsonObject.get("name").getAsString(),
				jsonObject.get("ID").getAsString(),
				jsonObject.get("requiresInput").getAsBoolean(),
				jsonObject.get("description").getAsString(),
				jsonObject.get("value").getAsInt());



	
}
