package  scan.topic;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController 
{
	/*** 
	 * @Autowired
	 * instance is marked as need a dependency injection. 
	 */
	@Autowired 
	private TopicService topicService;
// example 2:
	
	
	@RequestMapping("/")
	public String main()
	{
		//return "<h1> " + 	System.getProperty( "user.name" ) +" , is now logged to this computer </h1>";
		return "<h1> data-api >>>	 Main Menu </h1> <hr> <h3>under construction</h3><hr>";
		
	}
	
	/*** 
	 * http://localhost:8080/topics
	 * --get--
	 */
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics() ;
	}
	
	/***
	 *  
	 * - API  \topics\some-id\
	 *  
	 * -- api return only the topic that is requested
	 * -- url method access 
	 * -- mapping annotation on mathod
	 */
	
	/***
	 * --get--
	 *  /topics/java
	 *  
	 *  //token id/variable  {id}
	 *  /topics/{id} 
	 *  
	 *  @PathVariable take String id data from the variable {id} data "/topics/{id}"
	 *  
	 *  @RequestMapping("/topics/{id}")
	 */
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}


	 /***
	  * POST
	  */
	
	/****
	 * add
	 * @param topic
	 */
	 // @RequestBody pick the instance from the request body
	 @RequestMapping(method=RequestMethod.POST,value="/topics")
	 public void addTopic(@RequestBody Topic topic)
	 {
		 topicService.addTopic(topic);
	 }
	
	 /***
	  * POST
	  * posman --> post, "/topics", body --> "json example", header: key: "Content-Type" value: "application/json"
	  * 
	  * "json example" to put in postman body:
	  * {
	  *  "id": "java2ee",
	  *  "description": "Java programming 004",
	  *  "name": "java2ee dev"
	  * }
	  * 
	  * send with "post", show result with "get"
	  */
	 
	 
	 /***
	  * update
	  * @param topic
	  * @param id
	  */
	 // @RequestBody pick the instance from the request body
	 @RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	 public void updateTopic(@RequestBody Topic topic,@PathVariable String id)
	 {
		 topicService.updateTopic(id, topic);
	 }
	 

	 /***
	  * delete
	  * @param id
	  */
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		topicService.deleteTopic(id);
	}
	 
	 
//  another way to pass token from id/variable name1 to a variable name2
//	/****
//	/* --get--
//	 *  //token id/variable  {id} from  {foo}
//	 *  "/topics/{foo}"
//	 */
//	@RequestMapping("/topics/{foo}")
//	public Topic getTopic(@PathVariable("foo") String id)
//	{
//		return topicService.getTopic(id);
//	}

	
// example 1:	
//	/*** 
//	 * http://localhost:8080/topics
//   *  --get--
//	 */
//	@RequestMapping("/topics")
//	public String getAllTopics()
//	{
//		return "all Topics";
//	}
	 
	 
	 
	 
}
