
package com.project.kungfu.service;

import java.util.List;

import com.project.kungfu.model.CourseLevel;

public interface CourseLevelService {

	public void addCourseLevel(CourseLevel courseLevel);

	public List<CourseLevel> getAllCourseLevels(String specs, String orderBy);

	public void deleteCourseLevel(Integer courseLevelId);

	public CourseLevel updateCourseLevel(CourseLevel courseLevel);

	public CourseLevel getCourseLevel(int courseLevelid);
}
