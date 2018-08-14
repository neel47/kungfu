
package com.project.kungfu.dao;

import java.util.List;

import com.project.kungfu.model.Course;

public interface CourseDAO {

	public void addCourse(Course course);

	public List<Course> getAllCourses(String specs, String orderBy);

	public void deleteCourse(Integer CourseId);

	public Course updateCourse(Course course);

	public Course getCourse(int courseid);
}
