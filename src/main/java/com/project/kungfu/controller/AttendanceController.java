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

import com.project.kungfu.model.Attendance;
import com.project.kungfu.model.CourseDay;
import com.project.kungfu.model.Student;
import com.project.kungfu.service.AttendanceService;
import com.project.kungfu.service.CourseDayService;
import com.project.kungfu.service.CourseService;
import com.project.kungfu.service.StudentService;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private CourseDayService courseDayService;
	
	@Autowired
	private CourseService courseService;
	
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/AttendanceCreation")
	public ModelAndView attendanceCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		Attendance attendance = new Attendance();
		List<CourseDay> courseDayList = courseDayService.getAllCourseDays("", " COURSEDAY_ID desc ");
		for(CourseDay courseDay : courseDayList)
		{
			courseDay.setCourse(courseService.getCourse(courseDay.getCOURSE_ID()));
		}
		
		
		List<Student> studentList = studentService.getAllStudents("", " STUD_ID desc ");
		String sid = request.getSession().getId();
		model.addObject("attendance", attendance);
		model.addObject("courseDayList", courseDayList);
		model.addObject("studentList", studentList);
		model.setViewName("attendanceForm");
		return model;
	}

	@RequestMapping(value = "/AttendanceCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("attendance") Attendance attendance, BindingResult result,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in Student Controller");
		}
		
		attendanceService.addAttendance(attendance);
		model.setViewName("redirect:/AttendanceList");
		return model;
	}

	@RequestMapping(value = "/AttendanceList")
	public ModelAndView attendanceList(ModelAndView model, HttpServletRequest request) throws IOException {

		
		List<Attendance> attendanceList = attendanceService.getAllAttendances("", " ATD_ID desc ");
		for(Attendance attendance: attendanceList)
		{
			attendance.setStudent(studentService.getStudent(attendance.getSTUD_ID()));
			attendance.setCourseDay(courseDayService.getCourse(attendance.getCOURSEDAY_ID()));
		}
		String sid = request.getSession().getId();
		model.addObject("attendanceList", attendanceList);
		model.setViewName("attendanceList");
		return model;
	}

	@RequestMapping(value = "/AttendanceEdit")
	public ModelAndView editAttendance(ModelAndView model, HttpServletRequest request) throws IOException {

		int attendanceid = Integer.parseInt(request.getParameter("id"));
		Attendance attendance =attendanceService.getAttendance(attendanceid);
		List<CourseDay> courseDayList = courseDayService.getAllCourseDays("", " COURSEDAY_ID desc ");
		for(CourseDay courseDay : courseDayList)
		{
			courseDay.setCourse(courseService.getCourse(courseDay.getCOURSE_ID()));
		}
		List<Student> studentList = studentService.getAllStudents("", " STUD_ID desc ");
		String sid = request.getSession().getId();
		model.addObject("attendance", attendance);
		model.addObject("courseDayList", courseDayList);
		model.addObject("studentList", studentList);
		model.setViewName("attendanceForm");
		return model;
	}

	@RequestMapping(value = "/AttendanceDelete")
	public ModelAndView deleteAttendance(ModelAndView model, HttpServletRequest request) throws IOException {

		int attendanceId = Integer.parseInt(request.getParameter("id"));
		attendanceService.deleteAttendance(attendanceId);
		model.setViewName("redirect:/AttendanceList");
		return model;
	}

}
