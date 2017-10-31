/********************************
*  Variable Deserializer	    *
*   File Name: 					*
*   VariableDeserializer.java   *
*                               *
*   Variable Representation     *
*   with meta data.		        *
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/
package VariablePackage;

import java.lang.reflect.Type;
import java.text.ParseException;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

/**/
public final class VariableDeserializer implements JsonDeserializer<Variable<?>>{
	
	
	public Variable<?> deserialize(final JsonElement json, final Type typeOf, final JsonDeserializationContext context)
		throws JsonParseException{
		
		//deserialization code <3//
		final JsonObject jsonObject = json.getAsJsonObject();
		
		final JsonElement jsonName = jsonObject.get("name");
		final String _name = jsonName.getAsString();
		
		final String _id = jsonObject.get("ID").getAsString();
		
		final Type _valueType = new TypeToken<Variable<?>>() {}.getType();
		
		final String _description = jsonObject.get("description").getAsString();
		
		final boolean _requiresInput = jsonObject.get("requiresInput").getAsString() != null;
		
		final Variable<?> variable = new Variable();
		
		variable.SetName(_name);
		variable.SetId(_id);
		variable.SetValue(_value);
		variable.SetDescription(_description);
		variable.SetRequiresInput(_requiresInput);
		return variable;
		
	}

	
}
	
	
			


