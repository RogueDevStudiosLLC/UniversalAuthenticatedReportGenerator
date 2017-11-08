/********************************
 *   Page Class                  *
*   File Name: Page.java        *
*                               *
*   The class file for          *
*   the variables.              *
*                               *
*  ©2014 Rogue Dev Studios, LLC *
********************************/
/**
* <p>
* This class is for parsing information from the
* JSON file to java to use for UI configuration
* </p>
* 
* @author Gabriel Rosales
* @since 1.0
*/
package com.roguedevstudios.uarg.System.Core.Elements;

public class Page
{
	/**
	 *   
	 * @param Colors - any color called for styling
	 * 
	 */
	private int _colors;
	/**
	 *   
	 * @param Description - the description of the called workspace
	 * 
	 */
	private String _description;
	/**
	 *   
	 * @param Icon - the icon called for the workspace
	 * 
	 */
	private String _icon;
	/**
	 *   
	 * @param Logo - Logo from the client organization
	 * 
	 */
	private String _logo;
	/**
	 *   
	 * @param PageName - name of the workspace that is called 
	 * 
	 */
	private String _pageName;
	/**
	 *   
	 * @param TabId - Tab Identifier
	 * 
	 */
	private String _tabId;
	/**
	 *   
	 * @param Template - the template used for the workspace
	 * 
	 */
	private String _template;
	/**
	 *   
	 * @param VariableId - the ID of the called workspace
	 * 
	 */
	private String _variableId;
	
	public Page (String Name, String Description, String Variableid ,String Icon ,String Template, 
			 int Colors, String TabId, String Logo) 
		{
			this.SetPageName(Name);
			this.SetDescription(Description);
			this.SetVariableId(Variableid);
			this.SetIcon(Icon);
			this.SetTemplate(Template);
			this.SetColors(Colors);
			this.SetTabId(TabId);
			this.SetLogo(Logo);
		}

	public int GetColors() 
	{
		return _colors;
	}

	public void SetColors(int Colors) 
	{
		this._colors = Colors;
	}

	public String GetDescription() 
	{
		return _description;
	}

	public void SetDescription(String Description) 
	{
		this._description = Description;
	}

	public String GetIcon() 
	{
		return _icon;
	}

	public void SetIcon(String Icon) 
	{
		this._icon = Icon;
	}

	public String getLogo() 
	{
		return _logo;
	}

	public void SetLogo(String Logo) 
	{
		this._logo = Logo;
	}

	public String GetPageName() 
	{
		return _pageName;
	}

	public void SetPageName(String PageName) 
	{
		this._pageName = PageName;
	}

	public String GetTabId() 
	{
		return _tabId;
	}

	public void SetTabId(String TabId) 
	{
		this._tabId = TabId;
	}

	public String GetTemplate() 
	{
		return _template;
	}

	public void SetTemplate(String Template) 
	{
		this._template = Template;
	}

	public String GetVariableId() 
	{
		return _variableId;
	}

	public void SetVariableId(String VariableId) 
	{
		this._variableId = VariableId;
	}
}