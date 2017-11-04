package com.roguedevstudios.uarg.JSON.Parser.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.ParserHelpers;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;

public class ParserHelpersTests {

	@Test
	public void ParseIntegerVariableTest() {
		String name = "name";
		String nameValue = "TestName";
		String ID = "ID";
		String idValue = "TestID";
		String description = "description"; // <== your JSON deserializer is expecting lower case, I would fix this IMO as it's unprofessional in a config file
		String descriptionValue = "TestDescription";
		String value = "value";
		int valueValue = 500;
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.addProperty(name, nameValue);
		j.addProperty(ID, idValue);
		j.addProperty(description, descriptionValue);
		j.addProperty(value, valueValue);
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		JsonElement testElement = g.toJsonTree(j);
		
		Variable<Integer> testVar = ParserHelpers.ParseIntegerVariable(testElement, "TestID");
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue,(int)testVar.GetValue());
		System.out.println(g.toJson(testElement));
	}

}
