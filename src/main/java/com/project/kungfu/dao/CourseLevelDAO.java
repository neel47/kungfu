
package com.project.kungfu.dao;

import java.util.List;

import com.project.kungfu.model.CourseLevel;

public interface CourseLevelDAO {

	public void addCourseLevel(CourseLevel courseLevel);

	public List<CourseLevel> getAllCourseLevels(String specs, String orderBy);

	public void deleteCourseLevel(Integer courseLevelId);

	public CourseLevel updateCourseLevel(CourseLevel courseLevel);

	public CourseLevel getCourseLevel(int courseLevelid);
}
