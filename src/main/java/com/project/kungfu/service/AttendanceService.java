
package com.project.kungfu.service;

import java.util.List;

import com.project.kungfu.model.Attendance;

public interface AttendanceService {

	public void addAttendance(Attendance attendance);

	public List<Attendance> getAllAttendances(String specs, String orderBy);

	public void deleteAttendance(Integer attendanceId);

	public Attendance updateAttendance(Attendance attendance);

	public Attendance getAttendance(int attendanceid);
}
