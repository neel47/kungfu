
package com.project.kungfu.service;

import java.util.List;


import com.project.kungfu.model.CourseDay;

public interface CourseDayService {

	public void addCourseDay(CourseDay courseDay);

	public List<CourseDay> getAllCourseDays(String specs, String orderBy);

	public void deleteCourseDay(Integer courseDayId);

	public CourseDay updateCourseDay(CourseDay courseDay);

	public CourseDay getCourse(int courseDayid);
}
