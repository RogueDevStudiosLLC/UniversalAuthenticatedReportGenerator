package com.roguedevstudios.uarg.System.Core.Tests;
import static org.junit.Assert.*;
import org.junit.Test;
import com.roguedevstudios.uarg.System.Core.Elements.Page;


/**
 * <P>
 * this will test the page.java file
 * <P>
 * 
 * @author Gabriel Rosales
 * @since 1.0
 */
public class PageTest 
{
	/**
	 * Test creation of Integer Variable
	 * Expectation: Success
	 */
	@Test
	
	public void createIntegerObjectPage() 
	{
		/**
		 * setting up initial conditions
		 */
		String Name  ="TestPage";
		String Description = "A Test Description";	
		String Variableid = "TestVAR";
		String Icon = "Whatever";
		String Template = "TestTemplate";	
		int Colors = 1;
		String TabId = "TestTabId";
		String Logo = "TestLogo";
	/**
	 * wrap in try/catch 
	 */
	try 
		{
		/**
			 * Setup a valid test variable both with and without values
			 */
		Page testVarNoValue = new Page (Name, Description, Variableid, Icon , Template, Colors, TabId, Logo);
		Page testVarWithValue = new Page (Name, Description, Variableid, Icon , Template, Colors, TabId, Logo);
		
			/**
			 * Test the name 
			 */
		assertEquals(Name, testVarNoValue.GetPageName());
		assertEquals(Name, testVarWithValue.GetPageName());
		
			/**
			 *  Test the ID is correct
			 */
		assertEquals(TabId, testVarWithValue.GetTabId());
		assertEquals(TabId, testVarNoValue.GetTabId());
					
			/**
			 *  Test the Description is correct
			 */
		assertEquals(Description, testVarNoValue.GetDescription());
		assertEquals(Description, testVarWithValue.GetDescription());
					
			/**
			 *  Test the value set properly or is properly null
			 */
		assertEquals(Template, testVarWithValue.GetTemplate());
		assertEquals(Template, testVarNoValue.GetTemplate());
		
			/**
			 * Test the value set properly or is properly null
			 */
		
		
		System.out.println(testVarWithValue.GetTemplate());
		}
	catch (Exception e)
		{
		/**
		 * queue rocky Russian fighter scene "If it fails, it fails"
		 */
			assertFalse(true);
		}
	}
	
}
