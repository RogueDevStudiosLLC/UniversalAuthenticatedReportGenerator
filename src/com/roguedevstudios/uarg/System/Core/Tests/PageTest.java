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
		String name  ="TestPage";
		String ID = "TestTabID";
		String Description = "A Test Description";
		Integer value = 101;
			
	
	
	/**
	 * wrap in try/catch 
	 */
	try 
		{
			/**
			 * Setup a valid test variable both with and without values
			 */
		Page testVarNoValue = new Page (name,ID,Description, Description, Description, value, value, Description);
		Page testVarWithValue = new Page (name,ID,Description,Description, Description, value, value, Description);
		
			/**
			 * Test the name 
			 */
		assertEquals(name, testVarNoValue.getPageName());
		assertEquals(name, testVarWithValue.getPageName());
		
			/**
			 *  Test the ID is correct
			 */
		assertEquals(ID, testVarNoValue.getTabId());
		assertEquals(ID, testVarWithValue.getTabId());
					
			/**
			 *  Test the Description is correct
			 */
		assertEquals(Description, testVarNoValue.Description());
		assertEquals(Description, testVarWithValue.Description());
					
			/**
			 *  Test the value set properly or is properly null
			 */
		assertEquals(value, testVarWithValue.getVariableId());
		assertNull(testVarNoValue.getVariableId());
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
