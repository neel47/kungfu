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

import com.project.kungfu.model.Instructor;
import com.project.kungfu.service.InstructorService;

@Controller
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	@RequestMapping(value = "/InstructorCreation")
	public ModelAndView instructorCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		Instructor instructor = new Instructor();
		String sid = request.getSession().getId();
		model.addObject("instructor", instructor);
		model.setViewName("instructorForm");
		return model;
	}

	@RequestMapping(value = "/InstructorCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("instructor") Instructor instructor, BindingResult result,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in Instructor Controller");
		}
		
		instructorService.addInstructor(instructor);
		model.setViewName("redirect:/InstructorList");
		return model;
	}

	@RequestMapping(value = "/InstructorList")
	public ModelAndView instructorList(ModelAndView model, HttpServletRequest request) throws IOException {

		
		List<Instructor> instructorList = instructorService.getAllInstructors("", " U_ID desc ");
		String sid = request.getSession().getId();
		model.addObject("instructorList", instructorList);
		model.setViewName("instructorList");
		return model;
	}

	@RequestMapping(value = "/InstructorEdit")
	public ModelAndView editInstructor(ModelAndView model, HttpServletRequest request) throws IOException {

		int instructorId = Integer.parseInt(request.getParameter("id"));
		Instructor instructor =instructorService.getInstructor(instructorId);
		String sid = request.getSession().getId();
		model.addObject("instructor", instructor);
		model.setViewName("instructorForm");
		return model;
	}

	@RequestMapping(value = "/InstructorDelete")
	public ModelAndView deleteInstructor(ModelAndView model, HttpServletRequest request) throws IOException {

		int instructorId = Integer.parseInt(request.getParameter("id"));
		instructorService.deleteInstructor(instructorId);
		model.setViewName("redirect:/InstructorList");
		return model;
	}

}
