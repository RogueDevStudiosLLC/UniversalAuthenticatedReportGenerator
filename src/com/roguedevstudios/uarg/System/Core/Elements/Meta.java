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
	 * @param _name - the name of the person who is working on the file
	 * 
	 */
	private String _name;
	/***
	 * @param _formId - the Number the Form
	 * 
	 */
	private String _formId;
	/***
	 * @param _version - the Number of the Version the program is
	 * 
	 */
	private String _version;
	/***
	 *  @param _description - the description of what the form is about
	 *  
	 */
	private String _description;
	/***
	 *  @param _author - the name of the individuals name who originally worked on the form
	 *  
	 */
	private String _author;
	/***
	 * @param _dateCrt - the date the form was originally was created on
	 *  
	 */
	private String _dateCrt;
	/***
	 * @param _dateEd - the date the form is edited on
	 * 	
	 */
	private String _dateEd;

	/*
	 * {@code} Getters and Setters For each parameter
	 * 
	 */
	
	
		/**
		 * Getter for Name 
		 * return @Name
		 */
		public String GetName() 
		{
			return _name;
		}
		
		/**
		 * Setter for Name
		 * _name set to @Name
		 * @param Name
		 */
		public void SetName(String Name) 
		{
			this._name = Name;
		}
		
		/**
		 * Getter for Form ID 
		 * return @FormId
		 */
		public String GetFormId() 
		{
			return _formId;
		}
		
		/**
		 * Setter for FormId
		 * _formId set to FormId
		 * @param FormId
		 */
		public void SetFormId(String FormId) 
		{
			this._formId = FormId;
		}
		
		/**
		 * Getter for Version
		 * return @Version
		 * @return
		 */
		public String GetVersion() 
		{
			return _version;
		}
		
		/**
		 * Setter for Version
		 * _version set to Version 
		 * @param Version
		 */
		public void SetVersion(String Version) 
		{
			this._version = Version;
		}
		
		/**
		 * Getter for Descriptions
		 * return @Description
		 * @return
		 */
		public String GetDescription() 
		{
			return _description;
		}
		
		/**
		 * Setter for Description
		 * _description set to Description
		 * @param Description
		 */
		public void SetDescription(String Description) 
		{
			this._description = Description;
		}
		
		/**
		 * Getter for Author
		 * return @Author
		 * @return
		 */
		public String GetAuthor() 
		{
			return _author;
		}
		
		/**
		 * Setter for Author 
		 * _author set to Author
		 * @param Author
		 */
		public void SetAuthor(String Author) 
		{
			this._author = Author;
		}
		
		/**
		 * Getter for Date Created 
		 * return @DateCrt
		 * @return
		 */
		public String GetDateCrt() 
		{
			return _dateCrt;
		}
		
		/**
		 * Setter for Date Created 
		 * _dateCrt set to DateCrt
		 * @param DateCrt
		 */
		public void SetDateCrt(String DateCrt) 
		{
			this._dateCrt = DateCrt;
		}
		
		/**
		 * Getter for Date Edited 
		 * return @DateEd
		 * @return
		 */
		public String GetDateEd() 
		{
			return _dateEd;
		}
		
		/**
		 * Setter for DateEd 
		 * _dateEd set to DateEd
		 * @param DateEd
		 */
		public void SetDateEd(String DateEd) 
		{
			this._dateEd = DateEd;
		}
}