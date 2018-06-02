package scan.os;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import org.springframework.stereotype.Service;

@Service
public class OsService 
{

	
	private String domainName = "";
	
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName() 
	{
		String domainName = "";
		
		try{
            String fqdn = java.net.InetAddress.getLocalHost().getCanonicalHostName();
            if (fqdn.split("\\.").length>1) 
            {
            	domainName = fqdn.substring(fqdn.indexOf(".")+1);
            	this.domainName = domainName;
            }
        }
        catch(java.net.UnknownHostException e)
		{
        	this.domainName = "Domain Controller Not Exist";
        }		
		
		this.domainName = domainName;
	}

	
	private String ipAddress = "";
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress() 
	{
		String ipAddress = "";
		
		try 
		{
			ipAddress = InetAddress.getLocalHost().toString();
		} 
			catch (UnknownHostException e) 
		{
			ipAddress = ". . .";
		} 
		
		this.ipAddress = ipAddress;
	}

	
	
	/***
	 * lading data
	 */
	public void fnLoad()
	{
		setDomainName();
		setIpAddress();
	}
	
	
	public String ShowUserInformation() 
	{	
		fnLoad();
		
	    HashMap<String, String> stOslist = new HashMap<String, String>();
		ArrayList <String> stHtmlPage = new ArrayList<String>();
		String stReturnValue = "";


	    stOslist.clear();
	    stOslist.put("titleMain", "Os Information");
	    stOslist.put("titileUserId","Current user: ");
	    stOslist.put("userId", System.getProperty( "user.name" ) );
	    stOslist.put("titleDomain","Domain: ");
	    stOslist.put("Domain", getDomainName());
	    stOslist.put("titleIp", "IpAddress: ");
	    stOslist.put("Ip",getIpAddress());

		
		stHtmlPage.clear();
		stHtmlPage.add("<h1>" + stOslist.get("titleMain") + "</h1><hr/>");
		stHtmlPage.add("<h3>" + stOslist.get("titileUserId") + "  <i>" + stOslist.get("userId") + "</i></h3>");
		stHtmlPage.add("<h3>" + stOslist.get("titleDomain") + "  <i>" + stOslist.get("Domain") + "</i></h3>");
		stHtmlPage.add("<h3>" + stOslist.get("titleIp") + "  <i>" + stOslist.get("Ip") + "</i></h3>");
		
		
	    
	    for (int i=0; i<stHtmlPage.size();i++)
	    {
	    	stReturnValue = stReturnValue + stHtmlPage.get(i);
	    }
	    
	    System.out.println("stReturnValue === " + stReturnValue);
	    
		
		return stReturnValue;
		
	}
	
	

	
}
