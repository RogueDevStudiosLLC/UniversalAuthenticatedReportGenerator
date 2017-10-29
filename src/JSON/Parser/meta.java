/********************************
 * 	MetaData Class              *
 * 	File Name: meta.java        *
 * 						        *
 * 	The class file for          *
 *	MetaData                    *
 *								*
 * 	©2014 Rouge Dev Studios, LLC *
 ********************************/
/***
 * <p>
 *This class is for parsing information from
 *the JSON file to use for Meta Data configuration
 *<p>
 *
 *
 *
 *@author Isaiah Rodriguez
 *@since 1.0
 */

package JSON.Parser;

public class meta 
{
	public meta (String Name, String FormId, String Version, String Description, String Author, String DateCrt, String DateEd) 
	{
		this.set_Name(Name);
		this.set_FormId(FormId);
		this.set_Version(Version);
		this.set_Description(Description);
		this.set_Author(Author);
		this.set_DateCrt(DateCrt);
		this.set_DateEd(DateEd);
	}
	/***
	 * @parm _Name - the name of the person who is working on the file
	 * 
	 */
	private String _Name;
	/***
	 * @parm _FormId - the Number the Form
	 * 
	 */
	private String _FormId;
	/***
	 * @parm _Version - the Number of the Version the program is
	 * 
	 */
	private String _Version;
	/***
	 *  @parm _Description - the description of what the form is about
	 *  
	 */
	private String _Description;
	/***
	 *  @parm _Author - the name of the individuals name who originally worked on the form
	 *  
	 */
	private String _Author;
	/***
	 * @parm _DateCrt - the date the form was originally was created on
	 *  
	 */
	private String _DateCrt;
	/***
	 * @parm _DateEd - the date the form is edited on
	 * 	
	 */
	private String _DateEd;

	/*
	 * {@code} Getters and Setters For each parameter
	 * 
	 */
	
		public String get_Name() 
		{
			return _Name;
		}
		public void set_Name(String _Name) 
		{
			this._Name = _Name;
		}
		public String get_FormId() 
		{
			return _FormId;
		}
		public void set_FormId(String _FormId) 
		{
			this._FormId = _FormId;
		}
		public String get_Version() 
		{
			return _Version;
		}
		public void set_Version(String _Version) 
		{
			this._Version = _Version;
		}
		public String get_Description() 
		{
			return _Description;
		}
		public void set_Description(String _Description) 
		{
			this._Description = _Description;
		}
		public String get_Author() 
		{
			return _Author;
		}
		public void set_Author(String _Author) 
		{
			this._Author = _Author;
		}
		public String get_DateCrt() 
		{
			return _DateCrt;
		}
		public void set_DateCrt(String _DateCrt) 
		{
			this._DateCrt = _DateCrt;
		}
		public String get_DateEd() 
		{
			return _DateEd;
		}
		public void set_DateEd(String _DateEd) 
		{
			this._DateEd = _DateEd;
		}
}