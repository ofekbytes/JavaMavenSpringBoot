package scan.course;

import org.springframework.data.repository.CrudRepository;

//public class TopicRepository 
//{
//	/***
//	 * TODO
//	 * getAllTopics()
//	 * getTopic(String id)
//	 * updateTopic(String t)
//	 * deleteTopic(String id)
//   *
//	 * *** Note: 
//   * no need for that we will get it all by using "interface" with extends "CrudRepository"
//	 */
//
//
//	 /***
//   * links - erase when done
//	 * https://www.youtube.com/watch?v=z3HnFBzn7DI&index=28&list=PLmbC-xnvykcghOSOJ1ZF6ja3aOgZAgaMO
//   * https://www.youtube.com/watch?v=lpcOSXWPXTk&index=29&list=PLmbC-xnvykcghOSOJ1ZF6ja3aOgZAgaMO
//	 */	
//}


public interface CourseRepository extends CrudRepository <Course, String>
{
	
}