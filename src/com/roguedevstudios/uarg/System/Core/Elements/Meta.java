package com.roguedevstudios.uarg.System.Core.Elements;

/*********************************
 * 	MetaData Class               *
 * 	File Name: Meta.java         *
 * 						         *
 * 	The class file for           *
 *	MetaData                     *
 *								 *
 * 	©2017 Rouge Dev Studios, LLC *
 ********************************/
/**
 *<p>
 *This class is for parsing information from
 *the JSON file to use for Meta Data configuration
 *<p>
 *
 *@author Isaiah Rodriguez
 *@since 1.0
 */


public class Meta 
{
	/**
	 * Builds the Meta Object with initial values
	 * @param Name String name of this variable 
	 * @param FormId String FormId of this variable 
	 * @param Version String Version of this variable 
	 * @param Description String Description of this variable 
	 * @param Author String Author of this variable 
	 * @param DateCrt String DateCrt of this variable
	 * @param DateEd String DateEd of this variable
	 * @since 1.0
	 */
	public Meta (String Name, String FormId, String Version, String Description, 
				 String Author, String DateCrt, String DateEd) 
	{
		this.SetName(Name);
		this.SetFormId(FormId);
		this.SetVersion(Version);
		this.SetDescription(Description);
		this.SetAuthor(Author);
		this.SetDateCrt(DateCrt);
		this.SetDateEd(DateEd);
	}
	
	
	/* The Name of the configuration being used */
	private String _name;

	
	/* The Form ID of the Form */
	private String _formId;
	/* The Version for program */
	private String _version;
	/* The description of the form */
	private String _description;
	/* The original name of User who created the form */
	private String _author;
	/* The date when the form was created */
	private String _dateCrt;
	/*  The date when the form was edited */
	private String _dateEd;

	/*
	 * {@code} Getters and Setters For each parameter
	 * 
	 */
	
	
		/**
		 * 
		 * Gets the Name of the configuration being used
		 * @return _name
		 * @since 1.0
		 * 
		 */
		public String GetName() 
		{
			return _name;
		}
		
		/**
		 * Sets the Name of the configuration being used 
		 * @param Name 
		 * @since 1.0
		 */
		public void SetName(String Name) 
		{
			this._name = Name;
		}
		
		/***
		 * Gets the ID of the Form 
		 * @return _formID
		 * @since 1.0
		 * 
		 */
		public String GetFormId() 
		{
			return _formId;
		}
		
		/**
		 * Sets the ID for the Form
		 * @param FormId
		 * @since 1.0
		 */
		public void SetFormId(String FormId) 
		{
			this._formId = FormId;
		}
		
		/***
		 * Gets the Version of the program 
		 * @return _version
		 * @since 1.0
		 * 
		 */
		public String GetVersion() 
		{
			return _version;
		}
		
		/**
		 * Sets the Version of the program
		 * @param Version
		 * @since 1.0
		 */
		public void SetVersion(String Version) 
		{
			this._version = Version;
		}
		
		/***
		 *  Gets the Description of the form 
		 *  @return _description
		 *  @since 1.0
		 *  
		 */
		public String GetDescription() 
		{
			return _description;
		}
		
		/**
		 * Sets the Description of the form
		 * @param Description
		 * @since 1.0
		 */
		public void SetDescription(String Description) 
		{
			this._description = Description;
		}
		
		/***
		 * Gets the Name of the Author
		 *  @return _author
		 *  @since 1.0
		 */
		public String GetAuthor() 
		{
			return _author;
		}
		
		/**
		 * Sets the Name of the Author 
		 * @param Author
		 * @since 1.0
		 */
		public void SetAuthor(String Author) 
		{
			this._author = Author;
		}
		
		/***
		 * Gets the Date when the form was originally created from the computer 
		 *  @return _dateCrt
		 *  @since 1.0
		 */
		public String GetDateCrt() 
		{
			return _dateCrt;
		}
		
		/**
		 * Sets the Date when the form was originally created from the computer 
		 * @param DateCrt
		 * @since 1.0
		 */
		public void SetDateCrt(String DateCrt) 
		{
			this._dateCrt = DateCrt;
		}
		
		/***
		 * Gets the Date when the form was edited  
		 * @return _dateEd
		 * @since 1.0
		 */
		public String GetDateEd() 
		{
			return _dateEd;
		}
		
		/**
		 * Sets the Date when the form was edited  
		 * @param DateEd
		 * @since 1.0
		 */
		public void SetDateEd(String DateEd) 
		{
			this._dateEd = DateEd;
		}
}