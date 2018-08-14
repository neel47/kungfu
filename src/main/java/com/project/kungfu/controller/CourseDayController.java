package com.project.kungfu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.kungfu.model.Course;
import com.project.kungfu.model.CourseDay;
import com.project.kungfu.model.CourseLevel;
import com.project.kungfu.service.CourseDayService;
import com.project.kungfu.service.CourseLevelService;
import com.project.kungfu.service.CourseService;

@Controller
public class CourseDayController {

	@Autowired
	private CourseService courseService;
	

	@Autowired
	private CourseLevelService courseLevelService;
	
	@Autowired
	private CourseDayService courseDayService;

	@RequestMapping(value = "/CourseDayCreation")
	public ModelAndView courseDayCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		CourseDay courseDay = new CourseDay();
		String sid = request.getSession().getId();
		List<Course> courseList = courseService.getAllCourses("", " COURSE_ID desc  ");
		model.addObject("courseDay", courseDay);
		model.addObject("courseList", courseList);
		model.setViewName("courseDayForm");
		return model;
	}

	@RequestMapping(value = "/CourseDayCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("courseDay") CourseDay courseDay, BindingResult result,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in rank Controller");
		}
		
		courseDayService.addCourseDay(courseDay);
		model.setViewName("redirect:/CourseDayList");
		return model;
	}

	@RequestMapping(value = "/CourseDayList")
	public ModelAndView courseDayList(ModelAndView model, HttpServletRequest request) throws IOException {

		List<CourseDay> courseDayList = courseDayService.getAllCourseDays("", " COURSEDAY_ID desc ");
		for(CourseDay courseDay: courseDayList)
		{
			courseDay.setCourse(courseService.getCourse(courseDay.getCOURSE_ID()));
		}
		String sid = request.getSession().getId();
		model.addObject("courseDayList", courseDayList);
		model.setViewName("courseDayList");
		return model;
	}

	@RequestMapping(value = "/CourseDayEdit")
	public ModelAndView editCourseDay(ModelAndView model, HttpServletRequest request) throws IOException {

		int courseDayid = Integer.parseInt(request.getParameter("id"));
		CourseDay courseday =courseDayService.getCourse(courseDayid);
		List<Course> courseList = courseService.getAllCourses("", " COURSE_ID desc  ");
		String sid = request.getSession().getId();
		model.addObject("courseDay", courseday);
		model.addObject("courseList", courseList);
		model.setViewName("courseDayForm");
		return model;
	}

	@RequestMapping(value = "/CourseDayDelete")
	public ModelAndView deleteCourseDay(ModelAndView model, HttpServletRequest request) throws IOException {

		int courseDayId = Integer.parseInt(request.getParameter("id"));
		courseDayService.deleteCourseDay(courseDayId);
		model.setViewName("redirect:/CourseDayList");
		return model;
	}

}
