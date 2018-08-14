package com.project.kungfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.kungfu.dao.AttendanceDAO;
import com.project.kungfu.model.Attendance;

@Service("attendanceService")
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceDAO attendanceDAO;

	@Override
	public void addAttendance(Attendance attendance) {
		attendanceDAO.addAttendance(attendance);
		
	}

	@Override
	public List<Attendance> getAllAttendances(String specs, String orderBy) {
		// TODO Auto-generated method stub
		return attendanceDAO.getAllAttendances(specs, orderBy);
	}

	@Override
	public void deleteAttendance(Integer attendanceId) {
		attendanceDAO.deleteAttendance(attendanceId);
		
	}

	@Override
	public Attendance updateAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceDAO.updateAttendance(attendance);
	}

	@Override
	public Attendance getAttendance(int attendanceid) {
		// TODO Auto-generated method stub
		return attendanceDAO.getAttendance(attendanceid);
	}

	

	
	
	

}
