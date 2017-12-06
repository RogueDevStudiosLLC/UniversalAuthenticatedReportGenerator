package com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete;
/****************************************
*  Formula Deserializer					*
*   File Name: 							*
*   FormulaDeserializer.java 			*
*                            	   	    *
*   Deserializes JSON					*
*   information and converts			*
*   into Java objects	        		*
*                               		*
*  ©2017 Rogue Dev Studios, LLC 		*
*****************************************/
import java.lang.reflect.Type;
import com.google.gson.*;
import com.roguedevstudios.uarg.System.Core.Elements.Formula;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormula;

/**
 * <p>
 * converts Formula.json information into Java Objects
 * <p>
 * 
 * @author Terry Roberson
 * @since 1.0
 */
public class FormulaDeserializer implements JsonDeserializer<IFormula>{

	/**
	 * Deserializes into a Formula type
	 * from a given JsonElement, Type, and context
	 * @param JsonElement
	 * @param Type
	 * @param JsonDeserializationContext
	 * @return Formula
	 */
	
	public Formula deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		/* Temp slot for Formula name */
		String _formulaName = null;
		/* Temp slot for formula description */
		String _formulaDesc = null;
		/* Temp slot for formula ID */
		String _formulaId = null;
		/* Temp slot for base equation used by formula */
		String _formulaEquation = null;
		/* Temp slot for input array of variables */
		Formula f;
		
		/* Convert JsonElement into JsonObject */
		JsonObject o = json.getAsJsonObject();
		
		// Grab formula name
		if(o.has("Name")) {
			_formulaName = o.get("Name").getAsString();
		}
		
		// Grab formula description
		if(o.has("Description")) {
			_formulaDesc = o.get("Description").getAsString();
		}
		
		// Grab formula ID
		if(o.has("ID")) {
			_formulaId = o.get("ID").getAsString();
		}
		
		// Grab formula equation
		if(o.has("Equation")) {
			_formulaEquation = o.get("Equation").getAsString();
		}
		

		
		// Build the Formula object to return
		f = new Formula(_formulaName,_formulaDesc, _formulaId, _formulaEquation);
		
		
		
	
		return f;
	}
	
}