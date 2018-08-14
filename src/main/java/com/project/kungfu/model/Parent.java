package com.project.kungfu.model;

import java.io.Serializable;

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
import javax.persistence.Version;

@Entity
@Table(name = "PARENTDETAILS")
public class Parent implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PARENTDETAILS")
	@SequenceGenerator(name = "SQ_PARENTDETAILS", sequenceName = "SQ_PARENTDETAILS", allocationSize = 1)
	private int PAR_ID;

	@Column
	private int STUD_ID;

	@Column
	private String PAR_NAME;
	
	@Column
	private String PAR_RELATION;

	
	@Column
	private String PAR_EMAIL;

	@Column
	private String PAR_MOBILE;

	

	@Column
	@Version
	private int version;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="STUD_ID" , insertable=false , updatable=false )
	private Student student;


	public int getPAR_ID() {
		return PAR_ID;
	}


	public void setPAR_ID(int pAR_ID) {
		PAR_ID = pAR_ID;
	}


	public int getSTUD_ID() {
		return STUD_ID;
	}


	public void setSTUD_ID(int sTUD_ID) {
		STUD_ID = sTUD_ID;
	}


	public String getPAR_NAME() {
		return PAR_NAME;
	}


	public void setPAR_NAME(String pAR_NAME) {
		PAR_NAME = pAR_NAME;
	}


	public String getPAR_RELATION() {
		return PAR_RELATION;
	}


	public void setPAR_RELATION(String pAR_RELATION) {
		PAR_RELATION = pAR_RELATION;
	}


	public String getPAR_EMAIL() {
		return PAR_EMAIL;
	}


	public void setPAR_EMAIL(String pAR_EMAIL) {
		PAR_EMAIL = pAR_EMAIL;
	}


	public String getPAR_MOBILE() {
		return PAR_MOBILE;
	}


	public void setPAR_MOBILE(String pAR_MOBILE) {
		PAR_MOBILE = pAR_MOBILE;
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
	
	
   


}
