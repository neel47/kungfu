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

import com.project.kungfu.model.Performance;
import com.project.kungfu.model.Rank;
import com.project.kungfu.model.Student;
import com.project.kungfu.service.PerformanceService;
import com.project.kungfu.service.RankService;
import com.project.kungfu.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RankService rankService;
	
	@Autowired
	private PerformanceService performanceService;

	@RequestMapping(value = "/StudentCreation")
	public ModelAndView studentCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		Student student = new Student();
		String sid = request.getSession().getId();
		model.addObject("student", student);
		model.setViewName("studentForm");
		return model;
	}

	@RequestMapping(value = "/StudentCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("student") Student student, BindingResult result,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in Student Controller");
		}
		
		studentService.addStudent(student);
		Student studentA = studentService.getAllStudents("", " STUD_ID desc ").get(0);
		Rank rank = rankService.getAllRanks("", " RANK_LEVEL asc ").get(0);
		Performance performance = new Performance();
		performance.setRANK_ID(rank.getRANK_ID());
		performance.setSTUD_ID(studentA.getSTUD_ID());
		performance.setPERF_DATERECEIVED(studentA.getSTUD_JOININGDATE());
		
		performanceService.addPerformance(performance);
		
		model.setViewName("redirect:/StudentList");
		return model;
	}

	@RequestMapping(value = "/StudentList")
	public ModelAndView studentList(ModelAndView model, HttpServletRequest request) throws IOException {

		
		List<Student> studentList = studentService.getAllStudents("", " STUD_ID desc ");
		String sid = request.getSession().getId();
		model.addObject("studentList", studentList);
		model.setViewName("studentList");
		return model;
	}

	@RequestMapping(value = "/StudentEdit")
	public ModelAndView editStudent(ModelAndView model, HttpServletRequest request) throws IOException {

		int studentId = Integer.parseInt(request.getParameter("id"));
		Student student =studentService.getStudent(studentId);
		String sid = request.getSession().getId();
		model.addObject("student", student);
		model.setViewName("studentForm");
		return model;
	}

	@RequestMapping(value = "/StudentDelete")
	public ModelAndView deleteStudent(ModelAndView model, HttpServletRequest request) throws IOException {

		int studentId = Integer.parseInt(request.getParameter("id"));
		studentService.deleteStudent(studentId);
		model.setViewName("redirect:/StudentList");
		return model;
	}

}
