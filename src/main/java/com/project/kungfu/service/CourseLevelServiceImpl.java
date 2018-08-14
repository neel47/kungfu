package com.project.kungfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.kungfu.dao.CourseLevelDAO;
import com.project.kungfu.model.CourseLevel;

@Service("courseLevelService")
@Transactional
public class CourseLevelServiceImpl implements CourseLevelService {

	@Autowired
	private CourseLevelDAO courseLevelDAO;

	@Override
	public void addCourseLevel(CourseLevel courseLevel) {
		courseLevelDAO.addCourseLevel(courseLevel);
		
	}

	@Override
	public List<CourseLevel> getAllCourseLevels(String specs, String orderBy) {
		
		return courseLevelDAO.getAllCourseLevels(specs, orderBy);
	}

	@Override
	public void deleteCourseLevel(Integer courseLevelId) {
		courseLevelDAO.deleteCourseLevel(courseLevelId);
		
	}

	@Override
	public CourseLevel updateCourseLevel(CourseLevel courseLevel) {
		// TODO Auto-generated method stub
		return courseLevelDAO.updateCourseLevel(courseLevel);
	}

	@Override
	public CourseLevel getCourseLevel(int courseLevelid) {
		// TODO Auto-generated method stub
		return courseLevelDAO.getCourseLevel(courseLevelid);
	}

	
	

}
