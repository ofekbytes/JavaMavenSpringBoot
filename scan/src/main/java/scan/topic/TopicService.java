package scan.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

/****
 * business service (singletons - one instance)
 *
 */

@Service
public class TopicService 
{
// "Arrays.asList" cannot add values to list
//	 private List<Topic> topics = Arrays.asList (
//				new Topic("java","java dev","Java programming 001"),
//				new Topic("Web","Web dev", "Web Programming 002"),
//				new Topic("spring","web design", "web design programming 003")
//				);
	 
	
	
	//change to array list so we can use "Arrays.asList" and add values.
	 private List<Topic> topics = new ArrayList<> 
	 (
			 	Arrays.asList (
				new Topic("java","java dev","java programming 001"),
				new Topic("web","web dev", "web Programming 002"),
				new Topic("spring","web design", "web design programming 003")
				) 
	 );
	 
	 
	 
	 public List<Topic> getAllTopics()
	 {
		 return topics;
	 }
	 
	
	 
	 public Topic getTopic(String id)
	 {
		 /****
		  * stream == filter
		  * .filter - by lambda expression
		  * equal(id) from argument
		  * 
		  */
		 return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	 }


	/***
	 * addTopic
	 * @param topic
	 */
	public void addTopic(Topic topic) 
	{
		topics.add(topic);
		
	}


	/****
	 * updateTopic
	 * @param id
	 * @param topic
	 */
	public void updateTopic(String id, Topic topic) 
	{
		for (int i = 0; i < topics.size(); i++)
		{
			Topic temp = topics.get(i);
			
			if(temp.getId().equals(id))
			{
				topics.set(i,topic);
				
				return;
			}			
		}
	}


	/****
	 * deleteTopic
	 * @param id
	 */
	public void deleteTopic(String id) 
	{
		topics.removeIf(t -> t.getId().equals(id) );
		
		return;
	}
	 
	
}
