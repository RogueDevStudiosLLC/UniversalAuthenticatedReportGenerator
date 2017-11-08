package com.roguedevstudios.uarg.System.Core.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.roguedevstudios.uarg.System.Core.Elements.Meta;

import java.lang.reflect.*;

import java.util.*;

/**
*<p>
*this will test the Meta.java file
*<p>
*
*@author Isaiah Rodriguez
*@since 1.0
*/

public class MetaTest 
{
	/**
	 * Test creation of Strings of Meta Information
	 * Expectation: Success
	 */
	
	@Test
	public void createMetaDataObject()
	{
		//Set up initial conditions
		String Name = "TestNam";
		String FormId = "TestForId";
		String Version = "TestVer";
		String Description = "TestDes";
		String Author = "TestAuth";
		String DateCrt = "TestDatCr";
		String DateEd = "TestDatEd";
		
		try 
		{
			Meta testMetaAllInfo = new Meta (Name, FormId, Version, Description, Author, DateCrt, DateEd);
			
			//Test the name is correct
			assertEquals(Name, testMetaAllInfo.GetName());
			
			//Test the FormID is correct
			assertEquals(FormId, testMetaAllInfo.GetFormId());
			
			//Test the Version Number is correct
			assertEquals(Version, testMetaAllInfo.GetVersion());
			
			//Test the Description is correct
			assertEquals(Description, testMetaAllInfo.GetDescription());
			
			//Test the Author is correct
			assertEquals(Author, testMetaAllInfo.GetAuthor());
			
			//Test the Date Created is correct
			assertEquals(DateCrt, testMetaAllInfo.GetDateCrt());
			
			//Test the Date Edited is correct
			assertEquals(DateEd, testMetaAllInfo.GetDateEd());
			
			//For Human Checking
			System.out.println(testMetaAllInfo.GetName());
			System.out.println(testMetaAllInfo.GetFormId());
			System.out.println(testMetaAllInfo.GetVersion());
			System.out.println(testMetaAllInfo.GetDescription());
			System.out.println(testMetaAllInfo.GetAuthor());
			System.out.println(testMetaAllInfo.GetDateCrt());
			System.out.println(testMetaAllInfo.GetDateEd());
			
		}
		catch (Exception e) 
		{
			// If this tosses an Exception we failed
			assertFalse(true);
		}
		
	}

}
