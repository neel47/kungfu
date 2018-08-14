package com.project.kungfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.kungfu.dao.CourseDAO;
import com.project.kungfu.model.Course;
import com.project.kungfu.model.Instructor;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;

	@Override
	public void addCourse(Course course) {
		courseDAO.addCourse(course);
		
	}

	@Override
	public List<Course> getAllCourses(String specs, String orderBy) {
		// TODO Auto-generated method stub
		return courseDAO.getAllCourses(specs, orderBy);
	}

	@Override
	public void deleteCourse(Integer CourseId) {
		courseDAO.deleteCourse(CourseId);
		
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDAO.updateCourse(course);
	}

	@Override
	public Course getCourse(int courseid) {
		// TODO Auto-generated method stub
		return courseDAO.getCourse(courseid);
	}



}
