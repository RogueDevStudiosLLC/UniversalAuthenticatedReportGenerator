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
	
	/**
	 * 
	 * Gets the Name of person 
	 * @return _name
	 * @since 1.0
	 * 
	 */
	private String _name;
	/***
	 * Gets the ID of the Form 
	 * @return _formID
	 * @since 1.0
	 * 
	 */
	private String _formId;
	/***
	 * Gets the Version of program 
	 * @return _version
	 * @since 1.0
	 * 
	 */
	private String _version;
	/***
	 *  Gets the Description of the form 
	 *  @return _description
	 *  @since 1.0
	 *  
	 */
	private String _description;
	/***
	 * Gets the Name of the Form
	 *  @return _author
	 *  @since 1.0
	 */
	private String _author;
	/***
	 * Gets the Date when the form was originally created from the computer 
	 *  @return _dateCrt
	 *  @since 1.0
	 */
	private String _dateCrt;
	/***
	 * Gets the Date when the form was edited from the computer 
	 * @return _dateEd
	 * @since 1.0
	 */
	private String _dateEd;

	/*
	 * {@code} Getters and Setters For each parameter
	 * 
	 */
	
	
		/**
		 * Getter for Name 
		 * @return Name
		 * @since 1.0
		 */
		public String GetName() 
		{
			return _name;
		}
		
		/**
		 * Setter for Name
		 * @param Name 
		 * @since 1.0
		 */
		public void SetName(String Name) 
		{
			this._name = Name;
		}
		
		/**
		 * Getter for Form ID 
		 * @return FormId
		 * @since 1.0
		 */
		public String GetFormId() 
		{
			return _formId;
		}
		
		/**
		 * Setter for FormId
		 * @param FormId
		 * @since 1.0
		 */
		public void SetFormId(String FormId) 
		{
			this._formId = FormId;
		}
		
		/**
		 * Getter for Version
		 * @return Version
		 * @since 1.0
		 */
		public String GetVersion() 
		{
			return _version;
		}
		
		/**
		 * Setter for Version
		 * @param Version
		 * @since 1.0
		 */
		public void SetVersion(String Version) 
		{
			this._version = Version;
		}
		
		/**
		 * Getter for Descriptions
		 * @return Description
		 * @since 1.0
		 */
		public String GetDescription() 
		{
			return _description;
		}
		
		/**
		 * Setter for Description
		 * @param Description
		 * @since 1.0
		 */
		public void SetDescription(String Description) 
		{
			this._description = Description;
		}
		
		/**
		 * Getter for Author
		 * @return Author
		 * @since 1.0
		 */
		public String GetAuthor() 
		{
			return _author;
		}
		
		/**
		 * Setter for Author 
		 * @param Author
		 * @since 1.0
		 */
		public void SetAuthor(String Author) 
		{
			this._author = Author;
		}
		
		/**
		 * Getter for Date Created 
		 * @return DateCrt
		 * @since 1.0
		 */
		public String GetDateCrt() 
		{
			return _dateCrt;
		}
		
		/**
		 * Setter for Date Created 
		 * @param DateCrt
		 * @since 1.0
		 */
		public void SetDateCrt(String DateCrt) 
		{
			this._dateCrt = DateCrt;
		}
		
		/**
		 * Getter for Date Edited 
		 * @return DateEd
		 * @since 1.0
		 */
		public String GetDateEd() 
		{
			return _dateEd;
		}
		
		/**
		 * Setter for DateEd 
		 * @param DateEd
		 * @since 1.0
		 */
		public void SetDateEd(String DateEd) 
		{
			this._dateEd = DateEd;
		}
}