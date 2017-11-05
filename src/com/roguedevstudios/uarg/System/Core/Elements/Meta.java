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
	public Meta (String name, String formId, String version, String description, String author, String dateCrt, String dateEd) 
	{
		this.set_name(name);
		this.set_formId(formId);
		this.set_version(version);
		this.set_description(description);
		this.set_author(author);
		this.set_dateCrt(dateCrt);
		this.set_dateEd(dateEd);
	}
	/**
	 * 
	 * @parm _name - the name of the person who is working on the file
	 * 
	 */
	private String _name;
	/***
	 * @parm _formId - the Number the Form
	 * 
	 */
	private String _formId;
	/***
	 * @parm _version - the Number of the Version the program is
	 * 
	 */
	private String _version;
	/***
	 *  @parm _description - the description of what the form is about
	 *  
	 */
	private String _description;
	/***
	 *  @parm _author - the name of the individuals name who originally worked on the form
	 *  
	 */
	private String _author;
	/***
	 * @parm _dateCrt - the date the form was originally was created on
	 *  
	 */
	private String _dateCrt;
	/***
	 * @parm _dateEd - the date the form is edited on
	 * 	
	 */
	private String _dateEd;

	/*
	 * {@code} Getters and Setters For each parameter
	 * 
	 */
	
		public String get_name() 
		{
			return _name;
		}
		public void set_name(String _name) 
		{
			this._name = _name;
		}
		public String get_formId() 
		{
			return _formId;
		}
		public void set_formId(String _formId) 
		{
			this._formId = _formId;
		}
		public String get_version() 
		{
			return _version;
		}
		public void set_version(String _version) 
		{
			this._version = _version;
		}
		public String get_description() 
		{
			return _description;
		}
		public void set_description(String _description) 
		{
			this._description = _description;
		}
		public String get_author() 
		{
			return _author;
		}
		public void set_author(String _author) 
		{
			this._author = _author;
		}
		public String get_dateCrt() 
		{
			return _dateCrt;
		}
		public void set_dateCrt(String _dateCrt) 
		{
			this._dateCrt = _dateCrt;
		}
		public String get_dateEd() 
		{
			return _dateEd;
		}
		public void set_dateEd(String _dateEd) 
		{
			this._dateEd = _dateEd;
		}
}