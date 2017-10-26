/************************************************
 * Formula Parser Class File                    *
 * File name: FormulaParser.java                *
 * The class file for the formula parser.       *
 ***********************************************/
package JSON.Parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
/**
 * This class is the class for the formula parser.
 * @author Chel
 * @since 1.0
 */
public class FormulaParser implements JsonDeserializer<Formula> {
	
	/**
	 * Reads incoming JSON file
	 * @param FormulaJson	The formula JSON file.
	 * @return readFormulaJsonObjects(formulaJsonReader)	
	 * @throws IOException
	 */
	public FormulaParserReader readJsonStream(InputStream FormulaJson) throws IOException {
		JsonReader reader = new JsonReader(new InputStreamReader(FormulaJson, "UTF-8"));
		try {
			return readFormulaJsonObjects(reader);
		} finally {
			reader.close();
		}
	}
	
	public FormulaParser readFormulaJsonObjects(JsonReader formulaJsonReader) throws IOException {
		String name = null;
		String desc = null;
		String id = null;
		String equation = null;
		
		formulaJsonReader.beginObject();
		String nextName = formulaJsonReader.nextName();
		while (formulaJsonReader.hasNext()) {
			if (nextName.equals("_formulaName")) {
				name = reader.nextString();
			} else if (nextName.equals("_formulaDesc")) {
				desc = reader.nextString();
			} else if (nextName.equals("_formulaId")) {
				id = reader.nextString();
			} else if (nextName.equals("_formulaEquation")) {
				equation = reader.nextString();
			} else {
				formulaJsonReader.skipValue();
			}
		}
		return new Formula(name, desc, id, equation);
	}
	
	
}
