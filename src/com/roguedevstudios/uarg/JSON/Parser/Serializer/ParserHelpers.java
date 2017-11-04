package com.roguedevstudios.uarg.JSON.Parser.Serializer;

import com.google.gson.JsonElement;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

/**
 * Helper class for static methods
 * @author rober
 *
 */
public class ParserHelpers {

	/**
	 * Parses a variable into a Variable<> object
	 * @param JsonElement JsonElement Representation of this Variable
	 * @param ID String ID of this Variable
	 * @param Type VariableType of this Variable
	 * @return Variable<> The non-type specific Variable object of this variable
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static <V> Variable<V> ParseVariable(JsonElement json, String ID, VariableType Type){
		// Get the inner portion of this json
		// Deserialize this into the variable
		Variable<V> var;
		switch(Type) {
		case INTEGER:
			//things
			//drop into which deserializer needed
			//call it
			//do task 
			
			
			// var = (Variable<V>) DeserializedItem; (Force casting back to V will be required here)
			//take variable v and spit it back out 
			
			
		}
		// Set the ID of this variable
		// Return the constructed variable
		
		return null;
	}
	
}