package com.project.kungfu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.kungfu.model.Instructor;
import com.project.kungfu.model.Login;
import com.project.kungfu.service.InstructorService;

@Controller
@SessionAttributes({ "loginUserInfo"})
public class LoginController {

	
	
	@Autowired
	private InstructorService instructorService;

	@RequestMapping(value = "/")
	public ModelAndView firstPage(ModelAndView model, HttpServletRequest request) throws IOException {
		Login login = new Login();
		String sid = request.getSession().getId();
		model.addObject("login", login);
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView model, @Valid @ModelAttribute("login") Login login, BindingResult result,
			HttpServletRequest request) throws IOException {
		if (result.hasErrors()) {
			failureLogin(model, request, "Validation Error.");
		}
		Instructor instructor = instructorService.authenticateUser(login);
		if (null == instructor) {
			model = failureLogin(model, request, "Invalid Username or Password.");
		} else {
			String sid = request.getSession().getId();

			model.addObject("loginUserInfo", instructor);
			model.setViewName("startPage");
		}
		return model;
	}

	@RequestMapping(value = "/startPage")
	public ModelAndView startPage(ModelAndView model, HttpServletRequest request) throws IOException {
		model.setViewName("startPage");
		return model;
	}

	@RequestMapping(value = "/dashboard")
	public ModelAndView dashBoardPage(ModelAndView model, HttpServletRequest request) throws IOException {
		model.setViewName("dashBoard");
		return model;
	}

	public ModelAndView failureLogin(ModelAndView model, HttpServletRequest request, String error) {
		Login login = new Login();
		String sid = request.getSession().getId();
		model.addObject("login", login);
		model.addObject("error", error);
		model.setViewName("login");
		return model;

	}

}
