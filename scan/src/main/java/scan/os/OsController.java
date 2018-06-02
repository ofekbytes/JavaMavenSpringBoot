package scan.os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OsController 
{
	
	@Autowired
	private OsService osService; 
	
	
	@RequestMapping("/whoami")
	public String whoAmI()
	{
		//return "<h1> " + 	System.getProperty( "user.name" ) +" , is now logged to this computer </h1>";
		return osService.ShowUserInformation();
	}
	
	
	@RequestMapping("/")
	public String main()
	{
		//return "<h1> " + 	System.getProperty( "user.name" ) +" , is now logged to this computer </h1>";
		return "<h1> Main Menu </h1> <hr> <h3>under construction</h3><hr> <a href=\"whoami\">Os Information</a> <br/> <a href=\"topics\">return json from array</a>";
		
	}
	 

}
