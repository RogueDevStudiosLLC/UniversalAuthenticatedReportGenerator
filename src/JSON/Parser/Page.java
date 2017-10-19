/********************************
*   UI Class                    *
*   File Name: Uiclass.java     *
*                               *
*   The class file for          *
*   the variables.              *
*                               *
*   ©3000 SomeCompany, Inc.     *
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
	
	/**
	 * constructor
	 *   
	 * @param PageName - name of the workspace that is called 
	 * 
	 * @param VariableId - the ID of the called workspace
	 * 
	 * @param Description  the description of the called workspace
	 * 
	 * @param Icon - the icon called for the workspace
	 * 
	 * @param Template - the template used for the workspace
	 * 
	 * @param Colors - any color called for styling
	 * 
	 * @param Logo - Logo from the client organization
	 * 
	 * @since 1.0
	 */
	public Page (String PageName, String Description, String VariableId ,String Icon ,String Template, int Colors, String Logo) 
	{
		
	}
	public static String Logo;
	public static String Icon;
	public static int Colors;
	public static String Template;
	public static String VariableId;
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