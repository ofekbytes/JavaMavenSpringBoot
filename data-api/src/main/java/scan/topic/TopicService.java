package  scan.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * business service (singletons - one instance)
 *
 */

@Service
public class TopicService 
{
	
	@Autowired
	private TopicRepository topicRepository;
//	
//// "Arrays.asList" cannot add values to list
//
////	 private List<Topic> topics = Arrays.asList (
////				new Topic("java","java dev","Java programming 001"),
////				new Topic("Web","Web dev", "Web Programming 002"),
////				new Topic("spring","web design", "web design programming 003")
////				);
	 
	
	
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
		 List <Topic> topics = new ArrayList<Topic>();
		 topicRepository.findAll() //CrudRepository
		 .forEach(topics::add); //method reference
		 
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
		 
		 /***
		  * old code:
		  * return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		  */

		 /****
		  * Pointer
		  * topicRepository.findOne(id) 
		  * CrudRepository  findOne(id) changed to --> findById(id).orElse(null);
		  */
		 return topicRepository.findById(id).orElse(null); //CrudRepository
	 }


	/***
	 * addTopic
	 * @param topic
	 */
	public void addTopic(Topic topic) 
	{
		//topics.add(topic);
		topicRepository.save(topic); //CrudRepository
	}


	/****
	 * updateTopic
	 * @param id
	 * @param topic
	 */
	public void updateTopic(String id, Topic topic) 
	{
//		for (int i = 0; i < topics.size(); i++)
//		{
//			Topic temp = topics.get(i);
//			
//			if(temp.getId().equals(id))
//			{
//				topics.set(i,topic);
//				
//				return;
//			}			
//		}
		//check instance if "row" exist the "update", else do "insert"
		topicRepository.save(topic);  //CrudRepository
	
	}


	/****
	 * deleteTopic
	 * @param id
	 */
	public void deleteTopic(String id) 
	{
		//topics.removeIf(t -> t.getId().equals(id) );
		//delete --> deleteById
		topicRepository.deleteById(id);  //CrudRepository
		
		return;
	}
	 
	
}


//// *** CrudRepository *** changes
////* findOne(…) -> findById(…)
////* save(Iterable) -> saveAll(Iterable)
////* findAll(Iterable<ID>) -> findAllById(…)
////* delete(ID) -> deleteById(ID)
////* delete(Iterable<T>) -> deleteAll(Iterable<T>)
////* exists() -> existsById(…)
