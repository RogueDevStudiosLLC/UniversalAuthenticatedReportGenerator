package JSON.Parser;

public class meta 
{
	public meta (String Name, String FormID, String version, String description, String auhtor, String dataCrt, String dateED) 
	{
		this.setName(Name);
		this.setFormID(FormID);
		this.setVersion(version);
		this.setDescription(description);
		this.setAuthor(auhtor);
		this.setDateCrt(dataCrt);
		this.setDateEd(dateED);
	}
	
	private String Name;
	private String FormID;
	private String version;
	private String description;
	private String author;
	private String dateCrt;
	private String dateEd;
	
	public String getName() 
	{
		return Name;
	}
	
	public void setName(String name) 
	{
		Name = name;
	}
	
	public String getFormID() 
	{
		return FormID;
	}
	
	public void setFormID(String formID) 
	{
		FormID = formID;
	}
	
	public String getVersion() 
	{
		return version;
	}
	
	public void setVersion(String version)
	{
		this.version = version;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public String getAuthor() 
	{
		return author;
	}
	
	public void setAuthor(String author) 
	{
		this.author = author;
	}
	
	public String getDateCrt() 
	{
		return dateCrt;
	}
	
	public void setDateCrt(String dateCrt) 
	{
		this.dateCrt = dateCrt;
	}
	
	public String getDateEd() 
	{
		return dateEd;
	}
	
	public void setDateEd(String dateEd) 
	{
		this.dateEd = dateEd;
	}
}
