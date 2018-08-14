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
public class PerformanceController {

	@Autowired
	private PerformanceService performanceService;
	
	@Autowired
	private RankService rankService;
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/PerformanceCreation")
	public ModelAndView performanceCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		Performance performance = new Performance();
		List<Rank> rankList = rankService.getAllRanks("", " RANK_LEVEL asc ");
		List<Student> studentList = studentService.getAllStudents("", " STUD_ID desc ");
		String sid = request.getSession().getId();
		model.addObject("performance", performance);
		model.addObject("rankList", rankList);
		model.addObject("studentList", studentList);
		model.setViewName("performanceForm");
		return model;
	}

	@RequestMapping(value = "/PerformanceCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("performance") Performance performance, BindingResult result,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in Student Controller");
		}
		
		performanceService.addPerformance(performance);
		model.setViewName("redirect:/PerformanceList");
		return model;
	}

	@RequestMapping(value = "/PerformanceList")
	public ModelAndView performanceList(ModelAndView model, HttpServletRequest request) throws IOException {

		
		List<Performance> performanceList = performanceService.getAllPerformances("", " PERF_ID desc ");
		for(Performance performance: performanceList)
		{
			performance.setStudent(studentService.getStudent(performance.getSTUD_ID()));
			performance.setRank(rankService.getRank(performance.getRANK_ID()));;
		}
		String sid = request.getSession().getId();
		model.addObject("performanceList", performanceList);
		model.setViewName("performanceList");
		return model;
	}

	@RequestMapping(value = "/PerformanceEdit")
	public ModelAndView editPerformance(ModelAndView model, HttpServletRequest request) throws IOException {

		int performanceid = Integer.parseInt(request.getParameter("id"));
		Performance performance =performanceService.getPerformance(performanceid);
		List<Rank> rankList = rankService.getAllRanks("", " RANK_LEVEL asc ");
		List<Student> studentList = studentService.getAllStudents("", " STUD_ID desc ");
		String sid = request.getSession().getId();
		model.addObject("performance", performance);
		model.addObject("rankList", rankList);
		model.addObject("studentList", studentList);
		model.setViewName("performanceForm");
		return model;
	}

	@RequestMapping(value = "/PerformanceDelete")
	public ModelAndView deletePerformance(ModelAndView model, HttpServletRequest request) throws IOException {

		int performanceId = Integer.parseInt(request.getParameter("id"));
		performanceService.deletePerformance(performanceId);
		model.setViewName("redirect:/PerformanceList");
		return model;
	}

}
