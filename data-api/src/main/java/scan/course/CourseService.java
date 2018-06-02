package  scan.course;

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
public class CourseService 
{
	
	@Autowired
	private CourseRepository courseRepository;
	
	//change to array list so we can use "Arrays.asList" and add values.
//	 private List<Course> courses = new ArrayList<> 
//	 (
//			 	Arrays.asList (
//				new Course("java","java dev","java programming 001"),
//				new Course("web","web dev", "web Programming 002"),
//				new Course("spring","web design", "web design programming 003")
//				) 
//	 );
	 
	 
	 
	 public List<Course> getAllCourses(String id)
	 {
		 List <Course> courses = new ArrayList<Course>();
		 courseRepository.findAll() //CrudRepository
		 .forEach(courses::add); //method reference
		 
		 return courses;
	 }
	 
	
	 
	 public Course getCourse(String id)
	 {
		 return courseRepository.findById(id).orElse(null); //CrudRepository
	 }


	/***
	 * addCourse
	 */
	public void addCourse(Course course) 
	{
		courseRepository.save(course); //CrudRepository
	}


	/****
	 * updateCourse
	 */
	public void updateCourse(Course course) 
	{
		//check instance if "row" exist the "update", else do "insert"
		courseRepository.save(course);  //CrudRepository
	
	}


	/****
	 * deleteCourse
	 */
	public void deleteCourse(String id) 
	{
		//delete --> deleteById
		courseRepository.deleteById(id);  //CrudRepository
		
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
