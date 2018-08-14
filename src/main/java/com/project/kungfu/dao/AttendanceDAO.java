
package com.project.kungfu.dao;

import java.util.List;

import com.project.kungfu.model.Attendance;

public interface AttendanceDAO {

	public void addAttendance(Attendance attendance);

	public List<Attendance> getAllAttendances(String specs, String orderBy);

	public void deleteAttendance(Integer attendanceId);

	public Attendance updateAttendance(Attendance attendance);

	public Attendance getAttendance(int attendanceid);
}
