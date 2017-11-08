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
		String Description = "A Test Description";	
		String Variableid = "TestVAR";
		String Icon = "Whatever";
		String Template = "TestTemplate";	
		Integer Colors = 1;
		String Pageid = "TestPageid";
		String Logo = "TestLogo";
	/**
	 * wrap in try/catch 
	 */
	try 
		{
		/**
			 * Setup a valid test variable both with and without values
			 */
		Page testVarNoValue = new Page (Pageid, Description, Variableid, Icon , Template, Colors, Logo);
		Page testVarWithValue = new Page (Pageid, Description, Variableid, Icon , Template, Colors, Logo);
		
			/**
			 * Test the name 
			 */
		assertEquals(Pageid, testVarNoValue.GetPageid());
		assertEquals(Pageid, testVarWithValue.GetPageid());
		
			/**
			 *  Test the ID is correct
			 */
		assertEquals(Logo, testVarWithValue.GetLogo());
		assertEquals(Logo, testVarNoValue.GetLogo());
					
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
		assertEquals(Icon, testVarWithValue.GetIcon());
		assertEquals(Icon, testVarNoValue.GetIcon());
		
			/**
			 * Test the value set properly or is properly null
		 	*/
		assertEquals(Variableid, testVarWithValue.GetVariableId());
		assertEquals(Variableid, testVarNoValue.GetVariableId());
		
		System.out.println(testVarNoValue.GetColors());
		}
	catch (Exception e)
		{
		/**
		 * queue Rocky Russian fighter scene "If it fails, it fails"
		 */
			assertFalse(true);
		}
	}
	
}
