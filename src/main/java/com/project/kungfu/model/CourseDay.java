package com.project.kungfu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "COURSEDAY")
public class CourseDay implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_COURSEDAY")
	@SequenceGenerator(name = "SQ_COURSEDAY", sequenceName = "SQ_COURSEDAY", allocationSize = 1)
	private int COURSEDAY_ID;

	
	@Column
	private int COURSE_ID;

	@Column
	private String COURSEDAY_DAY;
	
	@Column
	private String COURSEDAY_STARTTIME;
	
	@Column
	private String COURSEDAY_ENDTIME;

	
	@Column
	@Type(type = "yes_no")
	private boolean COURSEDAY_ACTIVE = true;


	@Column
	@Version
	private int version;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COURSE_ID" , insertable=false , updatable=false )
	private Course course;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseDay")
	private List<Attendance> attendance = new ArrayList<>();


	public int getCOURSEDAY_ID() {
		return COURSEDAY_ID;
	}


	public void setCOURSEDAY_ID(int cOURSEDAY_ID) {
		COURSEDAY_ID = cOURSEDAY_ID;
	}


	public int getCOURSE_ID() {
		return COURSE_ID;
	}


	public void setCOURSE_ID(int cOURSE_ID) {
		COURSE_ID = cOURSE_ID;
	}


	public String getCOURSEDAY_DAY() {
		return COURSEDAY_DAY;
	}


	public void setCOURSEDAY_DAY(String cOURSEDAY_DAY) {
		COURSEDAY_DAY = cOURSEDAY_DAY;
	}


	

	public String getCOURSEDAY_STARTTIME() {
		return COURSEDAY_STARTTIME;
	}


	public void setCOURSEDAY_STARTTIME(String cOURSEDAY_STARTTIME) {
		COURSEDAY_STARTTIME = cOURSEDAY_STARTTIME;
	}


	public String getCOURSEDAY_ENDTIME() {
		return COURSEDAY_ENDTIME;
	}


	public void setCOURSEDAY_ENDTIME(String cOURSEDAY_ENDTIME) {
		COURSEDAY_ENDTIME = cOURSEDAY_ENDTIME;
	}


	public boolean isCOURSEDAY_ACTIVE() {
		return COURSEDAY_ACTIVE;
	}


	public void setCOURSEDAY_ACTIVE(boolean cOURSEDAY_ACTIVE) {
		COURSEDAY_ACTIVE = cOURSEDAY_ACTIVE;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public List<Attendance> getAttendance() {
		return attendance;
	}


	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}


	


}
