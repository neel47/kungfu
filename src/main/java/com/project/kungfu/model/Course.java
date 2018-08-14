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
@Table(name = "COURSE")
public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_COURSE")
	@SequenceGenerator(name = "SQ_COURSE", sequenceName = "SQ_COURSE", allocationSize = 1)
	private int COURSE_ID;

	
	@Column
	private String COURSE_CODE;
	
	@Column
	private int COURSELVL_ID;

	@Column
	private String COURSE_NAME;
	
	@Column
	private String COURSE_DESCRIPTION;

	
	@Column
	@Type(type = "yes_no")
	private boolean COURSE_ACTIVE = true;


	@Column
	@Version
	private int version;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COURSELVL_ID" , insertable=false , updatable=false )
	private CourseLevel courseLevel;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	private List<CourseDay> courseDay = new ArrayList<>();
	
	


	public int getCOURSE_ID() {
		return COURSE_ID;
	}


	public void setCOURSE_ID(int cOURSE_ID) {
		COURSE_ID = cOURSE_ID;
	}


	public String getCOURSE_CODE() {
		return COURSE_CODE;
	}


	public void setCOURSE_CODE(String cOURSE_CODE) {
		COURSE_CODE = cOURSE_CODE;
	}


	public int getCOURSELVL_ID() {
		return COURSELVL_ID;
	}


	public void setCOURSELVL_ID(int cOURSELVL_ID) {
		COURSELVL_ID = cOURSELVL_ID;
	}


	public String getCOURSE_NAME() {
		return COURSE_NAME;
	}


	public void setCOURSE_NAME(String cOURSE_NAME) {
		COURSE_NAME = cOURSE_NAME;
	}


	public String getCOURSE_DESCRIPTION() {
		return COURSE_DESCRIPTION;
	}


	public void setCOURSE_DESCRIPTION(String cOURSE_DESCRIPTION) {
		COURSE_DESCRIPTION = cOURSE_DESCRIPTION;
	}


	public boolean isCOURSE_ACTIVE() {
		return COURSE_ACTIVE;
	}


	public void setCOURSE_ACTIVE(boolean cOURSE_ACTIVE) {
		COURSE_ACTIVE = cOURSE_ACTIVE;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public CourseLevel getCourseLevel() {
		return courseLevel;
	}


	public void setCourseLevel(CourseLevel courseLevel) {
		this.courseLevel = courseLevel;
	}


	public List<CourseDay> getCourseDay() {
		return courseDay;
	}


	public void setCourseDay(List<CourseDay> courseDay) {
		this.courseDay = courseDay;
	}





}
