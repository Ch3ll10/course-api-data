package io.javabrains.springbootstarter.course;

import org.springframework.data.repository.CrudRepository;
//import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	//CRUD operations contains all the logic and methods that we need for topics.
	//public List<Course> getCoursesByTopicId(String topicId);
	//public List<Course> getCoursesByName(String name);
	//public List<Course> findByName(String name);
	//public List<Course> findByDescription(String foo);

	public Iterable<Course> findByTopicId(String topicId);
		
	
}
