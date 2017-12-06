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

package com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete;
import java.lang.reflect.Type;
import com.google.gson.*;
import com.roguedevstudios.uarg.System.Core.Elements.Meta;
/**
 * <p>
 * This class is deserializing the JSON objects from the page class
 * <p>
 * 
 * @author Isaiah
 * @author Gabriel Rosales 
 * @since 1.0
 */
public class MetaDataDeserializer implements JsonDeserializer<Meta>
{
	/**
	 * Deserilizes into MetaData object type
	 * from give JSONElement type and context
	 * @param JsonElement
	 * @param Type
	 * @param JsonDeserializationContext
	 * @return Meta
	 */
	@Override
	public Meta deserialize(JsonElement json, Type typeofT, JsonDeserializationContext context) 
			throws JsonParseException 
	{
		/*Temporary slot for name*/
		String _name = null;
		
		/*Temporary slot for Form ID */
		String _formId = null;
		
		/*Temporary slot for Version of the program */
		String _version = null;
		
		/*Temporary slot for Description*/
		String _description = null;
		
		/*Temporary slot for Original author of the file*/
		String _author = null;
		
		/*Temporary slot for Date Create of the file */
		String _dateCrt = null;
		
		/*Temporary slot for Date Edited*/
		String _dateEd = null;
		
		Meta m;
		
		JsonObject b = json.getAsJsonObject();
		
		/**
		 * If the 
		 */
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
