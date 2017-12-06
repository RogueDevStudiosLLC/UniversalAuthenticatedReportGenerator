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
import java.util.List;

public class CascadeEntryDeserializer implements JsonDeserializer<ICascadeEntry> {
	
	public CascadeEntry deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException() {
		List<String> _inputIDList = null;
		String _outputID = null;
		String _formulaID = null;
		String _description = null;
		
		JsonObject o = json.getAsJsonObject();
		
		if(o.has("InputIDList")) {
			if (o.get("InputIDList").isJsonObject()) {
				JsonObject t = o.get("InputIDList").getAsJsonObject();
				_inputIDList = new List<String>();
				for (String s : t.keyset()) {
					_inputIDList.add(t.get(s));
				}
			}
		}
		if(o.has("OutputID")) {
			_outputId = o.get("OutputID").getAsString();
		}
		if(o.has("FormulaID")) {
			_formulaID = o.get("FormulaID").getAsString();
		}
		if(o.has("Description")) {
			_description = o.get("Description").getAsString();
		}
		c = new CascadeEntry(_inputIDList, _outputID, _formulaID, _description);
		
		return c;
	}
}
