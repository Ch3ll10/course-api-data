package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	//Inject the instancies from the TopicRepository
	@Autowired
	private CourseRepository courseRepository;
	
/*	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring Framework","Spring Framework Description"),
			new Topic("java"," Java Core","Java Description"),
			new Topic("php"," PHP Framework","PHP Description"),
			new Topic("javascript","JavaScript","JavaScript Description")
		));*/

	public List<Course> getAllCourses(String topicId){
		//return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		//courseRepository.findAll() //Connect to DB
		.forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		//return topicRepository.findOne(id);
		return courseRepository.findById(id);	
	}
	
	public void addCourse(Course course) {
		//topics.add(topic);
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		/*
		for(int i = 0; i < topics.size(); i++) {
			//each topic
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
}

