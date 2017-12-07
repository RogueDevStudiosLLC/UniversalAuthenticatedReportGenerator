package com.roguedevstudios.uarg.JSON.Parser.Serializer;
/************************************
 * CascadeEntry Deserializer		*
 *  File Name:						*
 *  CascadeEntryDeserializer.java	*
 *  								*
 *  Deserializes JSON information	*
 *  and converts it into a Java 	*
 *  object.							*
 *  								*
 *  ©2017 Rogue Dev Studios, LLC	*
 ***********************************/
import com.google.gson.*;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.ICascadeEntry;
import com.roguedevstudios.uarg.System.Core.Elements.CascadeEntry;
import java.util.ArrayList;
import java.lang.reflect.Type;

/**
 * A class for deserializing CascadeEntry information from a JSON
 * into a Java object.
 * @author Chelsea Hunter
 */
public class CascadeEntryDeserializer implements JsonDeserializer<ICascadeEntry> {
	
	/**
	 * Deserializes into a CascadeEntry type object
	 * from a given JsonElement, Type, and
	 * JsonDeserializationContext.
	 * @param json	The JSON being parsed
	 * @param typeOfT	
	 * @param context
	 * @throws JsonParseException	If an error occurs during parsing.
	 * @return ICascadeEntry
	 * @author Chel
	 */
	public ICascadeEntry deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		ArrayList<String> _inputIDList = new ArrayList<String>();
		String _outputID = null;
		String _formulaID = null;
		String _description = null;
		
		JsonObject o = json.getAsJsonObject();
		
		if(o.has("Inputs")) {
			if (o.get("Inputs").isJsonObject()) {
				JsonObject t = o.get("Inputs").getAsJsonObject();
				for (String s : t.keySet()) {
					_inputIDList.add(t.get(s).getAsString());
				}
			}
			else {
				_inputIDList.add(o.get("Inputs").getAsString());
			}
		}
		if(o.has("Output")) {
			_outputID = o.get("Output").getAsString();
		}
		if(o.has("Formula")) {
			_formulaID = o.get("Formula").getAsString();
		}
		if(o.has("Description")) {
			_description = o.get("Description").getAsString();
		}
		ICascadeEntry c = new CascadeEntry(_inputIDList, _outputID, _formulaID, _description);
		
		return c;
	}
}
