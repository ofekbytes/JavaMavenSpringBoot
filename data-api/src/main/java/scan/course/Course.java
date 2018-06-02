package  scan.course;

import javax.persistence.Entity;
import javax.persistence.Id;

import scan.topic.Topic;


//@entity class - make it a

@Entity
public class Course {

    //each instance is a row
	// @Id // is the primary key column
	@Id
	private String id; 	//coulmns 
	private String Name; 	//coulmns
	private String description; 	//coulmns
	
	
	private Topic topic;
	
	public Course() 
	{
	}
	
	
	public Course(String id, String name, String description, String topicId) 
	{
		super();
		this.id = id;
		Name = name;
		this.description = description;
		this.topic = new Topic(topicId,"",""); //(instance) topicId, name, description 
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
