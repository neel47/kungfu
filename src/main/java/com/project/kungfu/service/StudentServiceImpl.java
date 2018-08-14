package com.project.kungfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.kungfu.dao.StudentDAO;
import com.project.kungfu.model.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public void addStudent(Student student) {
		studentDAO.addStudent(student);
		
	}

	@Override
	public List<Student> getAllStudents(String specs, String orderBy) {
		return studentDAO.getAllStudents(specs, orderBy);
	}

	@Override
	public void deleteStudent(Integer studentId) {
		studentDAO.deleteStudent(studentId);
		
	}

	@Override
	public Student updateStudent(Student student) {
		return studentDAO.updateStudent(student);
	}

	@Override
	public Student getStudent(int studentid) {
		return studentDAO.getStudent(studentid);
	}

	
	

}
