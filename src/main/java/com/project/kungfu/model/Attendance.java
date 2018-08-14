package com.project.kungfu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ATTENDANCE")
public class Attendance implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ATTENDANCE")
	@SequenceGenerator(name = "SQ_ATTENDANCE", sequenceName = "SQ_ATTENDANCE", allocationSize = 1)
	private int ATD_ID;


	@Column
	private int STUD_ID;
	
	@Column
	private int COURSEDAY_ID;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ATD_DATEPRESENT;

	@Column
	@Version
	private int version;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="STUD_ID" , insertable=false , updatable=false )
	private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COURSEDAY_ID" , insertable=false , updatable=false )
	private CourseDay courseDay;

	public int getATD_ID() {
		return ATD_ID;
	}

	public void setATD_ID(int aTD_ID) {
		ATD_ID = aTD_ID;
	}

	public int getSTUD_ID() {
		return STUD_ID;
	}

	public void setSTUD_ID(int sTUD_ID) {
		STUD_ID = sTUD_ID;
	}

	public int getCOURSEDAY_ID() {
		return COURSEDAY_ID;
	}

	public void setCOURSEDAY_ID(int cOURSEDAY_ID) {
		COURSEDAY_ID = cOURSEDAY_ID;
	}

	public Date getATD_DATEPRESENT() {
		return ATD_DATEPRESENT;
	}

	public void setATD_DATEPRESENT(Date aTD_DATEPRESENT) {
		ATD_DATEPRESENT = aTD_DATEPRESENT;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public CourseDay getCourseDay() {
		return courseDay;
	}

	public void setCourseDay(CourseDay courseDay) {
		this.courseDay = courseDay;
	}


	


}
