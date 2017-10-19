/********************************
*   UI Class                    *
*   File Name: Uiclass.java     *
*                               *
*   The class file for          *
*   the variables.              *
*                               *
*  ©2017 Rouge Dev. Studios,LLC *
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
package JSON.Parser;

public class Page 
{
	public Page (String PageName, String Description, String VariableId ,String Icon ,String Template, int Colors, String Logo) 
	{
		
	}
	/**
	 *   
	 * @param Logo - Logo from the client organization
	 * 
	 */
	public static String Logo;
	/**
	 *   
	 * @param Icon - the icon called for the workspace
	 * 
	 */
	public static String Icon;
	/**
	 *   
	 * @param Colors - any color called for styling
	 * 
	 */
	public static int Colors;
	/**
	 *   
	 * @param Template - the template used for the workspace
	 * 
	 */
	public static String Template;
	/**
	 *   
	 * @param VariableId - the ID of the called workspace
	 * 
	 */
	public static String VariableId;
	/**
	 *   
	 * @param PageName - name of the workspace that is called 
	 * 
	 */
	public static String PageName;
	
	public String getPageName() 
	{
		return PageName;
	}
	public void setPageName(String pageName) 
	{
		PageName = pageName;
	}
	public String getVariableId() 
	{
		return VariableId;
	}
	public void setVariableId(String variableId) 
	{
		VariableId = variableId;
	}
	public String getTemplate() 
	{
		return Template;
	}
	public void setTemplate(String template) 
	{
		Template = template;
	}
	public int getColors() 
	{
		return Colors;
	}
	public void setColors(int colors)
	{
		Colors = colors;
	}
	public String getIcon() 
	{
		return Icon;
	}
	public void setIcon(String icon) 
	{
		Icon = icon;
	}
	public String getLogo()
	{
		return Logo;
	}
	public void setLogo(String logo)
	{
		Logo = logo;
	}
}