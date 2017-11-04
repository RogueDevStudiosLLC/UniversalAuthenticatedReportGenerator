package com.roguedevstudios.uarg.JSON.Parser.Serializer;

import com.google.gson.JsonElement;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

public class IntegerParser {
	
	public static Variable<Integer> ParseVariable(JsonElement json, String ID, VariableType Type){
		Variable<Integer> var;
		IntegerVariableDeserializer IntegerVariable = new IntegerVariableDeserializer();
		IntegerVariable.getClass();
		JsonObject var = json.getAsJsonObject();
		
		 var = (Variable<Integer>) v;
		return v;
	}
}
