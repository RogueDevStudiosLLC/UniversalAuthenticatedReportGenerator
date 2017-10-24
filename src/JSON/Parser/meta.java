package JSON.Parser;

public class meta 
{
	public meta (String name, String formId, String version, String description, String auhtor, String dataCrt, String dateEd) 
	{
		this.set_name(name);
		this.set_formId(formId);
		this.set_version(version);
		this.set_description(description);
		this.set_author(auhtor);
		this.set_dateCrt(dataCrt);
		this.set_dateEd(dateEd);
	}
	
	private String _name;
	private String _formId;
	private String _version;
	private String _description;
	private String _author;
	private String _dateCrt;
	private String _dateEd;
	
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
		public String get_version() {
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