
package com.project.kungfu.service;

import java.util.List;

import com.project.kungfu.model.Instructor;
import com.project.kungfu.model.Login;

public interface InstructorService {

	public void addInstructor(Instructor instructor);

	public List<Instructor> getAllInstructors(String specs, String orderBy);

	public void deleteInstructor(Integer instructorId);

	public Instructor updateInstructor(Instructor instructor);

	public Instructor getInstructor(int instructorid);
	
	public Instructor getUserByUserName(String userName) ;
	
	public Instructor authenticateUser(Login login);
}
