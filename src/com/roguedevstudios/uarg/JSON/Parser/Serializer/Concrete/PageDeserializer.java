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

package com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete;

import java.lang.reflect.Type;
import com.google.gson.*;
import com.roguedevstudios.uarg.System.Core.Elements.Page;

/**
* 
* Adapter class to Deserialize Page objects
* 
* @author Gabriel Rosales
* @author Terry Roberson
* @author Christopher E. Howard
* @since 1.0
*/
public class PageDeserializer 
	   implements JsonDeserializer<Page>
{
	/**
	 * Deserializes into a Page object type
	 * from a given JsonElement, Type, and context
	 * @param JsonElement
	 * @param Type
	 * @param JsonDeserializationContext
	 * @return Page
	 */

	public Page deserialize(
							  JsonElement json, 
							  Type typeofT, 
							  JsonDeserializationContext context
						   ) 
						   throws JsonParseException
	{
		
		/*Temporary slot for page name*/
		String _name = null;
		
		/*Temporary slot for pageid*/
		String _pageId = null;
		
		/*Temporary slot for description*/
		String _description = null;
		
		/*Temporary slot for icon*/
		String _icon = null;
		
		/*Temporary slot for template*/
		String _template = null;
		
		/*Temporary slot for colors*/
		Integer _colors = null;
		
		/*Temporary slot for logo*/
		String  _logo = null;
		
		/*Temporary slot for variable id*/
		String _variableid = null;
		
		/*Temporary output object holder*/
		Page p;
		
		// Convert JsonElement into JsonObject
		JsonObject a = json.getAsJsonObject();
		
		// If page has a ID we grab it
		if( a.has("_pageId") )
			_pageId = a.get("_pageId").getAsString();
		
		// If the object has a page name, then we grab it
		if( a.has("name") )
			_name = a.get("name").getAsString();
		
		// If the page object has a description, then we grab it
		if( a.has("description") )
			_description = a.get("description").getAsString();
			
		// If the page has a tab id, then we grab it
		/* Commented out as it is not used at this time
		if( a.has("tabid") )
		{
		}
		*/
		
		// If the page has a icon, then we grab it
		if( a.has("icon") )
			_icon = a.get("icon").getAsString();
		
		// If the page has a template, then we grab it
		if( a.has("template") )
			_template = a.get("template").getAsString();
		
		// If the page has colors, then we grab it
		if( a.has("colors") )
			_colors = a.get("colors").getAsInt();
		
		// If the page has a logo, then we grab it
		if( a.has("logo") )
			_logo = a.get("logo").getAsString();
		
		// If the page has a variable id, then we grab it
		if( a.has("variableid") )
			_variableid = a.get("logo").getAsString();
		
		// Build the new page objects to return
		p = new Page(
					  _name, 
					  _description, 
					  _variableid, 
					  _icon , 
					  _template, 
					  _colors, 
					  _logo
					);
		
		// Return the built object
		return p;
		}
	}