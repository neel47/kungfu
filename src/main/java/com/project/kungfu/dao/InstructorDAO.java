
package com.project.kungfu.dao;

import java.util.List;

import com.project.kungfu.model.Instructor;

public interface InstructorDAO {

	public void addInstructor(Instructor instructor);

	public List<Instructor> getAllInstructors(String specs, String orderBy);

	public void deleteInstructor(Integer instructorId);

	public Instructor updateInstructor(Instructor instructor);

	public Instructor getInstructor(int instructorid);
	
	public Instructor getUserByUserName(String userName) ;
}
