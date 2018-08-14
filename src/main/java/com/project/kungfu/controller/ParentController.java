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

import com.project.kungfu.model.Parent;
import com.project.kungfu.model.Student;
import com.project.kungfu.service.ParentService;

@Controller
public class ParentController {

	@Autowired
	private ParentService parentService;

	@RequestMapping(value = "/ParentCreation")
	public ModelAndView parentCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		int studentId = Integer.parseInt(request.getParameter("id"));
		Parent parent = new Parent();
		parent.setSTUD_ID(studentId);
		String sid = request.getSession().getId();
		model.addObject("parent", parent);
		model.setViewName("parentForm");
		return model;
	}

	@RequestMapping(value = "/ParentCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("parent") Parent parent, BindingResult result,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in Student Controller");
		}
		
		parentService.addParent(parent);
		model.setViewName("redirect:/ParentList?id="+parent.getSTUD_ID());
		return model;
	}

	@RequestMapping(value = "/ParentList")
	public ModelAndView parentList(ModelAndView model, HttpServletRequest request) throws IOException {

		int studentId = Integer.parseInt(request.getParameter("id"));
		List<Parent> parentList = parentService.getAllParents(studentId+":STUD_ID", " PAR_ID desc ");
		String sid = request.getSession().getId();
		model.addObject("parentList", parentList);
		model.setViewName("parentList");
		return model;
	}

	@RequestMapping(value = "/ParentEdit")
	public ModelAndView editParent(ModelAndView model, HttpServletRequest request) throws IOException {

		int parentid = Integer.parseInt(request.getParameter("id"));
		Parent parent =parentService.getParent(parentid);
		String sid = request.getSession().getId();
		model.addObject("parent", parent);
		model.setViewName("parentForm");
		return model;
	}

	@RequestMapping(value = "/ParentDelete")
	public ModelAndView deleteParent(ModelAndView model, HttpServletRequest request) throws IOException {

		int parentId = Integer.parseInt(request.getParameter("id"));
		Parent parent =parentService.getParent(parentId);
		parentService.deleteParent(parentId);
		model.setViewName("redirect:/ParentList?id="+parent.getSTUD_ID());
		return model;
	}

}
