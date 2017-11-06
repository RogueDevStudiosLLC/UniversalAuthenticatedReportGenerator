/********************************
*   MetaData Deserializer Class *
*   File Name:                  *
*   MetaDataDeserializer.java   *
*                               *
*   The class file for          *
*   deserializing the           *
*   Meta Data objects           *
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/
/**
 * <p>
 * This class is deserializing the JSON objects from the page class
 * <p>
 * 
 * @author Isaiah
 * @author Gabriel Rosales 
 * @since 1.0
 */
package com.roguedevstudios.uarg.JSON.Parser.Serializer;
import java.lang.reflect.Type;
import com.google.gson.*;
import com.roguedevstudios.uarg.System.Core.Elements.Meta;


public class MetaDataDeserializer implements JsonDeserializer<Meta>
{
	@Override
	public Meta deserialize(JsonElement json, Type typeofT, JsonDeserializationContext context) 
			throws JsonParseException 
	{
		String _name = null;
		String _formId = null;
		String _version = null;
		String _description = null;
		String _author = null;
		String _dateCrt = null;
		String _dateEd = null;
		
		Meta m;
		
		JsonObject b = json.getAsJsonObject();
		
		if(b.has(_name))
		{
			_name = b.get("name").getAsString();
		}
		
		if (b.has(_formId)) 
		{
			_formId = b.get("formId").getAsString();
		}
		
		if(b.has(_version))
		{
			_version = b.get("version").getAsString();
		}
		
		if (b.has(_description))
		{
			_description = b.get("description").getAsString();
		}
		
		if (b.has(_author))
		{
			_author = b.get("author").getAsString();
		}
		
		if (b.has(_dateCrt))
		{
			_dateCrt = b.get("date created").getAsString();
		}
		
		if(b.has(_dateEd))
		{
			_dateEd = b.get("date edited").getAsString();
		}
		
		m = new Meta(_name, _formId, _version, _description, _author, _dateCrt, _dateEd);
		
		return null;
	}

}
