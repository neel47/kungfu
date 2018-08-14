package com.project.kungfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.kungfu.dao.InstructorDAO;
import com.project.kungfu.model.Instructor;
import com.project.kungfu.model.Login;

@Service("instructorService")
@Transactional
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDAO instructorDAO;

	@Override
	public void addInstructor(Instructor instructor) {
		instructorDAO.addInstructor(instructor);
		
	}

	@Override
	public List<Instructor> getAllInstructors(String specs, String orderBy) {
		// TODO Auto-generated method stub
		return instructorDAO.getAllInstructors(specs, orderBy);
	}

	@Override
	public void deleteInstructor(Integer instructorId) {
		instructorDAO.deleteInstructor(instructorId);
		
	}

	@Override
	public Instructor updateInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return instructorDAO.updateInstructor(instructor);
	}

	@Override
	public Instructor getInstructor(int instructorid) {
		// TODO Auto-generated method stub
		return instructorDAO.getInstructor(instructorid);
	}

	@Override
	public Instructor getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return instructorDAO.getUserByUserName(userName);
	}

	@Override
	public Instructor authenticateUser(Login login) {
		Instructor instructor = getUserByUserName(login.getUsername());

		if (null == instructor || (null != instructor.getU_PASSWORD()&& !login.getPassword().equals(instructor.getU_PASSWORD()))) {
			return null;
		}
		// TODO Auto-generated method stub
		return instructor;
	}

	

	
	
	

}
