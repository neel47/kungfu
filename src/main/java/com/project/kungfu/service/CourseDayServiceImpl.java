package com.project.kungfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.kungfu.dao.CourseDayDAO;
import com.project.kungfu.model.CourseDay;
import com.project.kungfu.model.CourseLevel;

@Service("courseDayService")
@Transactional
public class CourseDayServiceImpl implements CourseDayService {

	@Autowired
	private CourseDayDAO courseDayDAO;

	@Override
	public void addCourseDay(CourseDay courseDay) {
		courseDayDAO.addCourseDay(courseDay);
		
	}

	@Override
	public List<CourseDay> getAllCourseDays(String specs, String orderBy) {
		// TODO Auto-generated method stub
		return courseDayDAO.getAllCourseDays(specs, orderBy);
	}

	@Override
	public void deleteCourseDay(Integer courseDayId) {
		courseDayDAO.deleteCourseDay(courseDayId);
		
	}

	@Override
	public CourseDay updateCourseDay(CourseDay courseDay) {
		// TODO Auto-generated method stub
		return courseDayDAO.updateCourseDay(courseDay);
	}

	@Override
	public CourseDay getCourse(int courseDayid) {
		// TODO Auto-generated method stub
		return courseDayDAO.getCourse(courseDayid);
	}

	
	
	

}
