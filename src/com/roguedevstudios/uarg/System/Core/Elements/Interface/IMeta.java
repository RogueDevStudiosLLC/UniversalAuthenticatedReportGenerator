package com.roguedevstudios.uarg.System.Core.Elements.Interface;
/********************************
*   IMeta Interface		    	*
*   File Name: IMeta.java   	*
*                               *
*   Inversion of Control		*
*   for Meta Data		 		*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

/**
 * Interface representing Meta Data requirements
 * 
 * @author Isaiah Rodriguez
 * @since 1.0
 */

public interface IMeta 
{
	/**
	 * Gets the Name of the configuration being used
	 * @return _name
	 * @since 1.0
	 */
	String GetName();
	
	/***
	 * Gets the ID of the Form 
	 * @return _formID
	 * @since 1.0
	 * 
	 */
	String GetFormId();
	
	/***
	 * Gets the Version of the program 
	 * @return _version
	 * @since 1.0
	 * 
	 */
	String GetVersion();
	
	/***
	 *  Gets the Description of the form 
	 *  @return _description
	 *  @since 1.0
	 *  
	 */
	String GetDescription();
	
	/***
	 * Gets the Name of the Author
	 *  @return _author
	 *  @since 1.0
	 */
	String GetAuthor();
	
	/***
	 * Gets the Date when the form was originally created from the computer 
	 *  @return _dateCrt
	 *  @since 1.0
	 */
	String GetDateCrt();
	
	/***
	 * Gets the Date when the form was edited  
	 * @return _dateEd
	 * @since 1.0
	 */
	String GetDateEd();
	
	/**
	 * Sets the Name of the configuration being used 
	 * @param Name 
	 * @since 1.0
	 */
	void SetName(String Name);
	
	/**
	 * Sets the ID for the Form
	 * @param FormId
	 * @since 1.0
	 */
	void SetFormId(String FormId);
	
	/**
	 * Sets the Version of the program
	 * @param Version
	 * @since 1.0
	 */
	void SetVersion(String Version);
	
	/**
	 * Sets the Description of the form
	 * @param Description
	 * @since 1.0
	 */
	void SetDescription(String Description);
	
	/**
	 * Sets the Name of the Author 
	 * @param Author
	 * @since 1.0
	 */
	void SetAuthor(String Author);
	
	/**
	 * Sets the Date when the form was originally created from the computer 
	 * @param DateCrt
	 * @since 1.0
	 */
	void SetDateCrt(String DateCrt);
	
	/**
	 * Sets the Date when the form was edited  
	 * @param DateEd
	 * @since 1.0
	 */
	void SetDateEd(String DateEd);
	
}
