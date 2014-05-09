package MediaBrowser.Model.Dlna;

public class HttpHeaderInfo
{
//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [XmlAttribute("name")] public string Name {get;set;}
	private String privateName;
	public final String getName()
	{
		return privateName;
	}
	public final void setName(String value)
	{
		privateName = value;
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [XmlAttribute("value")] public string Value {get;set;}
	private String privateValue;
	public final String getValue()
	{
		return privateValue;
	}
	public final void setValue(String value)
	{
		privateValue = value;
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [XmlAttribute("match")] public HeaderMatchType Match {get;set;}
	private HeaderMatchType privateMatch = HeaderMatchType.values()[0];
	public final HeaderMatchType getMatch()
	{
		return privateMatch;
	}
	public final void setMatch(HeaderMatchType value)
	{
		privateMatch = value;
	}
}