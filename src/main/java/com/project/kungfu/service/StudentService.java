
package com.project.kungfu.service;

import java.util.List;

import com.project.kungfu.model.Student;

public interface StudentService {

	public void addStudent(Student student);

	public List<Student> getAllStudents(String specs, String orderBy);

	public void deleteStudent(Integer studentId);

	public Student updateStudent(Student student);

	public Student getStudent(int studentid);
}
