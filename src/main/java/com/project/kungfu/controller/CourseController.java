package com.project.kungfu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.simple.JSONValue;
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
public class CourseController {

	@Autowired
	private CourseService courseService;
	

	@Autowired
	private CourseLevelService courseLevelService;
	
	@Autowired
	private CourseDayService courseDayService;

	@RequestMapping(value = "/CourseCreation")
	public ModelAndView courseCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		Course course = new Course();
		String sid = request.getSession().getId();
		List<CourseLevel> courseLevelList = courseLevelService.getAllCourseLevels("", " COURSELVL_ID desc ");
		model.addObject("course", course);
		model.addObject("courseLevelList", courseLevelList);
		model.setViewName("courseForm");
		return model;
	}

	@RequestMapping(value = "/CourseCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("course") Course course, BindingResult result,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in rank Controller");
		}
		
		courseService.addCourse(course);
		model.setViewName("redirect:/CourseList");
		return model;
	}

	@RequestMapping(value = "/CourseList")
	public ModelAndView courseList(ModelAndView model, HttpServletRequest request) throws IOException {

		List<Course> courseList = courseService.getAllCourses("", " COURSE_ID desc ");
		for(Course course: courseList)
		{
			course.setCourseLevel(courseLevelService.getCourseLevel(course.getCOURSELVL_ID()));
		}
		String sid = request.getSession().getId();
		model.addObject("courseList", courseList);
		model.setViewName("courseList");
		return model;
	}

	@RequestMapping(value = "/CourseEdit")
	public ModelAndView editCourse(ModelAndView model, HttpServletRequest request) throws IOException {

		int courseid = Integer.parseInt(request.getParameter("id"));
		Course course =courseService.getCourse(courseid);
		List<CourseLevel> courseLevelList = courseLevelService.getAllCourseLevels("", " COURSELVL_ID desc ");
		model.addObject("courseLevelList", courseLevelList);
		String sid = request.getSession().getId();
		model.addObject("course", course);
		model.setViewName("courseForm");
		return model;
	}
	@RequestMapping(value = "/CourseView")
	public ModelAndView CourseView(ModelAndView model, HttpServletRequest request) throws IOException {

		Course course = null;
		List<CourseDay> courseDayList = null;
		Boolean toShowAll=false;
		int courseid=0;
		
		if(null!=request.getParameter("id"))
		 courseid = Integer.parseInt(request.getParameter("id"));
		
		if(0!= courseid)
		{
		 course =courseService.getCourse(courseid);
		 courseDayList = courseDayService.getAllCourseDays(courseid+":COURSE_ID", " COURSEDAY_ID desc ");
		}
		else
		{
			 courseDayList = courseDayService.getAllCourseDays("", " COURSEDAY_ID desc ");
			 toShowAll=true;
		}
		ArrayList<String> data = new ArrayList<String>();
		for(CourseDay courseDay : courseDayList)
		{
			String start=courseDay.getCOURSEDAY_STARTTIME();
			String end=courseDay.getCOURSEDAY_ENDTIME();
			if(null== course || toShowAll)
			{
				course =courseService.getCourse(courseDay.getCOURSE_ID());
			}
			String dataToAdd =""+course.getCOURSE_CODE()+": "+course.getCOURSE_NAME()+"\n # "+start+" : "+end+", "+courseDay.getCOURSEDAY_DAY()+", "+start.substring(0, 2)+", "+start.substring(3,5)
					+ ", "+end.substring(0, 2)+", "+end.substring(3,5);
			
			data.add(dataToAdd);
			
		}
		
		String jCountry = JSONValue.toJSONString(data);
		
		
		String sid = request.getSession().getId();
		model.addObject("data", jCountry);
		model.setViewName("courseView");
		return model;
	}

	@RequestMapping(value = "/CourseViewE")
	public ModelAndView CourseViewE(ModelAndView model, HttpServletRequest request) throws IOException {

		Course course = null;
		List<CourseDay> courseDayList = null;
		
			 courseDayList = courseDayService.getAllCourseDays("", " COURSEDAY_ID desc ");
		ArrayList<String> data = new ArrayList<String>();
		for(CourseDay courseDay : courseDayList)
		{
			String start=courseDay.getCOURSEDAY_STARTTIME();
			String end=courseDay.getCOURSEDAY_ENDTIME();
			if(true)
			{
				course =courseService.getCourse(courseDay.getCOURSE_ID());
			}
			String dataToAdd =""+course.getCOURSE_CODE()+": "+course.getCOURSE_NAME()+"\n # "+start+" : "+end+", "+courseDay.getCOURSEDAY_DAY()+", "+start.substring(0, 2)+", "+start.substring(3,5)
					+ ", "+end.substring(0, 2)+", "+end.substring(3,5);
			
			data.add(dataToAdd);
			
		}
		
		String jCountry = JSONValue.toJSONString(data);
		
		
		String sid = request.getSession().getId();
		model.addObject("data", jCountry);
		model.setViewName("courseViewE");
		return model;
	}

	@RequestMapping(value = "/CourseDelete")
	public ModelAndView deleteUser(ModelAndView model, HttpServletRequest request) throws IOException {

		int CourseId = Integer.parseInt(request.getParameter("id"));
		courseService.deleteCourse(CourseId);
		model.setViewName("redirect:/CourseList");
		return model;
	}

}
