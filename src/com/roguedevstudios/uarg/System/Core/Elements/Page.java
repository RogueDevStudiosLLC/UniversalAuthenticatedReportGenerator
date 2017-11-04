/********************************
*   Page Class                     *
*   File Name: Page.java           *
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
private int Colors;
	/**
	 *   
	 * @param Description - the description of the called workspace
	 * 
	 */
	private String Description;
	/**
	 *   
	 * @param Icon - the icon called for the workspace
	 * 
	 */
	private String Icon;
	/**
	 *   
	 * @param Logo - Logo from the client organization
	 * 
	 */
	private String Logo;
	/**
	 *   
	 * @param PageName - name of the workspace that is called 
	 * 
	 */
	private String PageName;
	/**
	 *   
	 * @param TabId - Tab Identifier
	 * 
	 */
	private int TabId;
	/**
	 *   
	 * @param Template - the template used for the workspace
	 * 
	 */
	private String Template;
	/**
	 *   
	 * @param VariableId - the ID of the called workspace
	 * 
	 */
	private String VariableId;
	public Page (String _name, String _description, String _variableid ,String _icon ,String _template, 
			 int _colors, int _tabid, String _logo) 
		{
			this.setPageName(_name);
			this.setDescription(_description);
			this.setVariableId(_variableid);
			this.setIcon(_icon);
			this.setTemplate(_template);
			this.setColors(_colors);
			this.setTabId(_tabid);
			this.setLogo(_logo);
		}
	
	public String Description() 
	{
		return Description;
	}
	public int getColors() 
	{
		return Colors;
	}
	public String getIcon() 
	{
		return Icon;
	}
	public String getLogo()
	{
		return Logo;
	}
	/**
	 *  
	 * {@code} Getters and setters for each parameter
	 * 
	 */

	public String getPageName() 
	{
		return PageName;
	}
	public int getTabId() {
		return TabId;
	}
	public String getTemplate() 
	{
		return Template;
	}
	public String getVariableId() 
	{
		return VariableId;
	}
	public void setColors(int colors)
	{
		Colors = colors;
	}
	public void setDescription(String description) 
	{
		Description = description;
	}
	public void setIcon(String icon) 
	{
		Icon = icon;
	}
	public void setLogo(String logo)
	{
		Logo = logo;
	}
	public void setPageName(String pageName) 
	{
		PageName = pageName;
	}
	public void setTabId(int tabId) {
		TabId = tabId;
	}
	public void setTemplate(String template) 
	{
		Template = template;
	}
	public void setVariableId(String variableId) 
	{
		VariableId = variableId;
	}

}