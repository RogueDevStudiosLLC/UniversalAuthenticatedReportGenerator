package com.roguedevstudios.uarg.JSON.Parser.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.ParserHelpers;
import com.roguedevstudios.uarg.System.Core.Elements.Variables;
import java.util.*;
import com.google.gson.*;


public class VariablesParserTest {
	
	//***** INTEGER TESTING SECTION ******\\
	@Test
	public void ParseIntegerVariablesTest() {
		// Set up initial conditions
		Map<String,String> map = new TreeMap<String, String>();
		
		// Create a test variable object
		JsonObject j = new JsonObject();
		j.put("1","3");
		
		// Convert it to a JsonElement tree
		Gson g = new Gson();
		
		// Assign  elements to JsonElement tree
		JsonElement testElement = g.toJsonTree(j);
		
		// Assign Variable<> to testVar and Parse
		Variables testVar = ParserHelpers.ParseIntegerVariable(testElement, "TestID");
		
		// Fetch Information about Integer Variable
		assertEquals(nameValue ,testVar.GetName());
		assertEquals(idValue ,testVar.GetId());
		assertEquals(descriptionValue ,testVar.GetDescription());
		assertEquals(valueValue,(int)testVar.GetValue());
		
		// Display results
		System.out.println(g.toJson(testElement));
	}

}
