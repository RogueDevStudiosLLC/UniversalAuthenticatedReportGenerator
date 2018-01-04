/********************************
 *   Page Class                  *
*   File Name: Page.java        *
*                               *
*   The class file for          *
*   the variables.              *
*                               *
*  ©2014 Rogue Dev Studios, LLC *
********************************/
package com.roguedevstudios.uarg.System.Core.Elements;

/**
* 
* This class is for representing information from the
* JSON file to java to use for UI configuration
* 
* 
* @author Gabriel Rosales
* @author Christopher E. Howard
* @since 1.0
*/


public class Page
{
  
	 /* Colors - any color called for styling */ 
	private Integer _colors;
	
	/* Description - the description of the called workspace */
	private String _description;
	
	/* Icon - the icon called for the workspace */
	private String _icon;
	
	/* Logo - Logo from the client organization */
	private String _logo;
	
	/* PageName - name of the workspace that is called */
	private String _pageId;
	
	/* Template - the template used for the workspace */
	private String _template;
	
	/* VariableId - the ID of the called workspace */
	private String _variableId;
	
	/**
	 * 
	 * Primary Constructor for Page
	 * 
	 * @param Pageid
	 * @param Description
	 * @param Variableid
	 * @param Icon
	 * @param Template
	 * @param Colors
	 * @param Logo
	 */
	public Page (   String Pageid, 
					String Description, 
					String Variableid,
					String Icon,
					String Template, 
					Integer Colors, 
					String Logo
				) 
		{
			this.SetPageid( Pageid );
			this.SetDescription( Description );
			this.SetVariableId( Variableid );
			this.SetIcon( Icon );
			this.SetTemplate( Template );
			this.SetColors( Colors );
			this.SetLogo( Logo );
		}

	/**
	 * 
	 * Gets the Colors Integer Code
	 * 
	 * @return Integer
	 */
	public Integer GetColors() 
	{
		return _colors;
	}

	/**
	 * 
	 * Sets the Colors Integer Code
	 * 
	 * @param Colors
	 */
	public void SetColors( Integer Colors ) 
	{
		this._colors = Colors;
	}

	/**
	 * 
	 * Gets the Description
	 * 
	 * @return String
	 */
	public String GetDescription() 
	{
		return _description;
	}

	/**
	 * 
	 * Sets the Description
	 * 
	 * @param Description
	 */
	public void SetDescription( String Description ) 
	{
		this._description = Description;
	}

	/**
	 * 
	 * Returns the Icon String
	 * 
	 * @return String
	 */
	public String GetIcon() 
	{
		return _icon;
	}

	/**
	 * 
	 * Sets the Icon String
	 * 
	 * @param Icon
	 */
	public void SetIcon( String Icon ) 
	{
		this._icon = Icon;
	}

	/**
	 * 
	 * Gets the Logo String
	 * 
	 * @return String
	 */
	public String GetLogo() 
	{
		return _logo;
	}

	/**
	 * 
	 * Sets the Logo String
	 * 
	 * @param Logo
	 */
	public void SetLogo( String Logo ) 
	{
		this._logo = Logo;
	}

	/**
	 * 
	 * Gets the Page ID String
	 * 
	 * @return String
	 */
	public String GetPageid() 
	{
		return _pageId;
	}

	/**
	 * 
	 * Sets the Page ID String
	 * 
	 * @param Pageid
	 */
	public void SetPageid( String Pageid ) 
	{
		this._pageId = Pageid;
	}

	/**
	 * 
	 * Gets the Template String
	 * 
	 * @return String
	 */
	public String GetTemplate() 
	{
		return _template;
	}

	/**
	 * 
	 * Sets the Template String
	 * 
	 * @param Template
	 */
	public void SetTemplate( String Template ) 
	{
		this._template = Template;
	}

	//TODO: Determine the purpose of VariableId and clarify documentation
	
	/**
	 * 
	 * Gets the Variable ID String
	 * 
	 * @return String
	 */
	public String GetVariableId() 
	{
		return _variableId;
	}

	/**
	 * 
	 * Sets the Variable ID String
	 * 
	 * @param VariableId
	 */
	public void SetVariableId( String VariableId ) 
	{
		this._variableId = VariableId;
	}
	
	/**
	 * 
	 * Indicates if a color Integer code is present in the object
	 * 
	 */
	public boolean HasColorCode() {
		
		return (this._colors != null);
		
	}
}