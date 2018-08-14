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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "COURSELEVEL")
public class CourseLevel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_COURSELEVEL")
	@SequenceGenerator(name = "SQ_COURSELEVEL", sequenceName = "SQ_COURSELEVEL", allocationSize = 1)
	private int COURSELVL_ID;

	@Column
	private String COURSELVL_NAME;

	@Column
	private String COURSELVL_DESCRIPTION;

	
	@Column
	@Type(type = "yes_no")
	private boolean COURSELVL_ACTIVE = true;

	@Column
	@Version
	private int VERSION;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "courseLevel")
	private List<Course> course = new ArrayList<>();

	public int getCOURSELVL_ID() {
		return COURSELVL_ID;
	}

	public void setCOURSELVL_ID(int cOURSELVL_ID) {
		COURSELVL_ID = cOURSELVL_ID;
	}

	public String getCOURSELVL_NAME() {
		return COURSELVL_NAME;
	}

	public void setCOURSELVL_NAME(String cOURSELVL_NAME) {
		COURSELVL_NAME = cOURSELVL_NAME;
	}

	public String getCOURSELVL_DESCRIPTION() {
		return COURSELVL_DESCRIPTION;
	}

	public void setCOURSELVL_DESCRIPTION(String cOURSELVL_DESCRIPTION) {
		COURSELVL_DESCRIPTION = cOURSELVL_DESCRIPTION;
	}

	public boolean isCOURSELVL_ACTIVE() {
		return COURSELVL_ACTIVE;
	}

	public void setCOURSELVL_ACTIVE(boolean cOURSELVL_ACTIVE) {
		COURSELVL_ACTIVE = cOURSELVL_ACTIVE;
	}

	public int getVERSION() {
		return VERSION;
	}

	public void setVERSION(int vERSION) {
		VERSION = vERSION;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}



	
	
}
