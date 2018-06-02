package scan.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController 
{
	/*** 
	 * http://localhost:8080/hello
	 *
	 * //default method is http "get" request
	 */
	
	@RequestMapping("/hello")
	public String sayHi()
	{
		return "<div> <h1>Welecome </h1> <h2>" + 	System.getProperty( "user.name" ) + " , Welcome Back</h2> </div>";
	}
}
