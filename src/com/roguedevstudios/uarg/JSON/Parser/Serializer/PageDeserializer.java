/********************************
*   Page Deserializer Class     *
*   File Name:                  *
*   PageDeserializer.java       *
*                               *
*   The class file for          *
*   deserializing the           *
*   Page objects                *
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/
/**
* <p>
* This class is for parsing information from the
* JSON file to java to use for UI configuration
* </p>
* 
* @author Gabriel Rosales
* @since 1.0
*/
package com.roguedevstudios.uarg.JSON.Parser.Serializer;
import java.lang.reflect.Type;
import com.google.gson.*;

import JSON.Parser.Page;

public class PageDeserializer implements JsonDeserializer<Page>
{

	public Page deserialize(JsonElement json, Type typeofT, JsonDeserializationContext context) 
			throws JsonParseException
	{
		String _name = null;
		
		String _description = null;
		
		Integer _tabid = null;
		
		String _icon = null;
		
		String _template = null;
		
		Integer _colors = null;
		
		String  _logo = null;
		
		String _variableid = null;
		
		Page p;
	
		JsonObject a = json.getAsJsonObject();
		
		if(a.has("name"))
		{
			_name = a.get("name").getAsString();
		}
		if(a.has("description"))
		{
			_description = a.get("description").getAsString();
		}
		if(a.has("tabid"))
		{
			_tabid = a.get("tabid").getAsInt();
		}
		if(a.has("icon"))
		{
			_icon = a.get("icon").getAsString();
		}
		if(a.has("template"))
		{
			_template = a.get("template").getAsString();
		}
		if(a.has("colors"))
		{
			_colors = a.get("colors").getAsInt();
		}
		if(a.has("logo"))
		{
			_logo = a.get("logo").getAsString();
		}
		if(a.has("variableid"))
		{
			_variableid = a.get("logo").getAsString();
		}
		
		p = new Page(_name, _description, _logo, _icon, _template, _colors, _tabid,_variableid);
		
		return p;
		}
	}