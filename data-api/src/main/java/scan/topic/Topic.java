package  scan.topic;

import javax.persistence.Entity;
import javax.persistence.Id;


//@entity class - make it a

@Entity
public class Topic {

    //each instance is a row
	// @Id // is the primary key column
	@Id
	private String id; 	//coulmns 
	private String Name; 	//coulmns
	private String description; 	//coulmns
	
	
	
	public Topic() 
	{
	}
	
	
	public Topic(String id, String name, String description) 
	{
		super();
		this.id = id;
		Name = name;
		this.description = description;
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
	
}
