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

import com.project.kungfu.model.CourseLevel;
import com.project.kungfu.model.Rank;
import com.project.kungfu.service.CourseLevelService;

@Controller
public class CourseLevelController {

	@Autowired
	private CourseLevelService courseLevelService;

	@RequestMapping(value = "/CourseLevelCreation")
	public ModelAndView courseLevelCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		CourseLevel courseLevel = new CourseLevel();
		String sid = request.getSession().getId();
		model.addObject("courseLevel", courseLevel);
		model.setViewName("courseLevelForm");
		return model;
	}

	@RequestMapping(value = "/CourseLevelCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("courseLevel") CourseLevel courseLevel, BindingResult result,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in rank Controller");
		}
		
		courseLevelService.addCourseLevel(courseLevel);
		model.setViewName("redirect:/CourseLevelList");
		return model;
	}

	@RequestMapping(value = "/CourseLevelList")
	public ModelAndView courseLevelList(ModelAndView model, HttpServletRequest request) throws IOException {

		List<CourseLevel> courseLevelList = courseLevelService.getAllCourseLevels("", " COURSELVL_ID desc ");
		String sid = request.getSession().getId();
		model.addObject("courseLevelList", courseLevelList);
		model.setViewName("courseLevelList");
		return model;
	}

	@RequestMapping(value = "/CourseLevelEdit")
	public ModelAndView editCourseLevel(ModelAndView model, HttpServletRequest request) throws IOException {

		int courseLevelid = Integer.parseInt(request.getParameter("id"));
		CourseLevel courseLevel =courseLevelService.getCourseLevel(courseLevelid);
		String sid = request.getSession().getId();
		model.addObject("courseLevel", courseLevel);
		model.setViewName("courseLevelForm");
		return model;
	}

	@RequestMapping(value = "/CourseLevelDelete")
	public ModelAndView deleteCourseLevel(ModelAndView model, HttpServletRequest request) throws IOException {

		int courseLevelId = Integer.parseInt(request.getParameter("id"));
		courseLevelService.deleteCourseLevel(courseLevelId);
		model.setViewName("redirect:/CourseLevelList");
		return model;
	}

}
