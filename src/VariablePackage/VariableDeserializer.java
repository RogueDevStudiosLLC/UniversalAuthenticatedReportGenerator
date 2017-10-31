/********************************
*  Variable Deserializer	    *
*   File Name: 					*
*   VariableDeserializer.java   *
*                               *
*   Deserializes JSON			*
*   information and converts	*
*   into Java objects	        *
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/
package VariablePackage;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.text.ParseException;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * converts JSON information into Java Objects
 * <p>
 * 
 * @author Terry Roberson
 * @since 1.0
 */
public final class VariableDeserializer implements JsonDeserializer<Variable<?>>{
	
	/**
	 * created instance of the JsonDeserializer
	 * 
	 * @since 1.0
	 */
	public Variable<?> deserialize(final JsonElement json, final Type typeOf, final JsonDeserializationContext context)
		throws JsonParseException{
		
		final JsonObject jsonObject = json.getAsJsonObject();
		
		final String _name = jsonObject.get("name").getAsString();
		
		final String _id = jsonObject.get("ID").getAsString();
		
		final Type _value = new TypeToken<Variable<?>>() {}.getType();
		
		final String _description = jsonObject.get("description").getAsString();
		
		final boolean _requiresInput = jsonObject.get("requiresInput").getAsString() != null;
		
		final Variable<?> variable = new Variable(_name, _id, _requiresInput, _description, _value);
		
		variable.SetName(_name);
		variable.SetId(_id);
		variable.SetRequiresInput(_requiresInput);
		variable.SetDescription(_description);
		variable.SetValue(_value);
		return variable;
		
	}
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Variable.class, new VariableDeserializer());
			Gson gson = gsonBuilder.create();
			
			/*JSON data*/
			try(Reader reader = new InputStreamReader(Variable.class.getResourceAsStream("/src/JSON.Parser/Variable.json"), "UTF-8") {
				
				Variable<?> variable = gson.fromJson(reader, Variable.class);
			
			}
					
					
	}

	
}
	
	
			


