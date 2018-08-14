package com.project.kungfu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_STUDENT")
	@SequenceGenerator(name = "SQ_STUDENT", sequenceName = "SQ_STUDENT", allocationSize = 1)
	private int STUD_ID;

	@Column
	private String STUD_FIRSTNAME;

	@Column
	private String STUD_LASTNAME;

	@Column
	private String STUD_GENDER;

	@Column
	private String STUD_ADDRESS;
	
	@Column
	private String STUD_MOBILE;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date STUD_DOB;
	
	@Column
	private String STUD_EMAIL;
	
	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date STUD_JOININGDATE;


	@Column
	@Type(type = "yes_no")
	private boolean STUD_ACTIVE = true;

	@Column
	@Version
	private int VERSION;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	private List<Parent> parent = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	private List<Attendance> attendance = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	private List<Transaction> transaction = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	private List<Performance> performance = new ArrayList<>();
	
	public int getSTUD_ID() {
		return STUD_ID;
	}

	public void setSTUD_ID(int sTUD_ID) {
		STUD_ID = sTUD_ID;
	}

	public String getSTUD_FIRSTNAME() {
		return STUD_FIRSTNAME;
	}

	public void setSTUD_FIRSTNAME(String sTUD_FIRSTNAME) {
		STUD_FIRSTNAME = sTUD_FIRSTNAME;
	}

	public String getSTUD_LASTNAME() {
		return STUD_LASTNAME;
	}

	public void setSTUD_LASTNAME(String sTUD_LASTNAME) {
		STUD_LASTNAME = sTUD_LASTNAME;
	}

	public String getSTUD_GENDER() {
		return STUD_GENDER;
	}

	public void setSTUD_GENDER(String sTUD_GENDER) {
		STUD_GENDER = sTUD_GENDER;
	}

	public String getSTUD_ADDRESS() {
		return STUD_ADDRESS;
	}

	public void setSTUD_ADDRESS(String sTUD_ADDRESS) {
		STUD_ADDRESS = sTUD_ADDRESS;
	}

	public String getSTUD_MOBILE() {
		return STUD_MOBILE;
	}

	public void setSTUD_MOBILE(String sTUD_MOBILE) {
		STUD_MOBILE = sTUD_MOBILE;
	}

	public Date getSTUD_DOB() {
		return STUD_DOB;
	}

	public void setSTUD_DOB(Date sTUD_DOB) {
		STUD_DOB = sTUD_DOB;
	}

	public String getSTUD_EMAIL() {
		return STUD_EMAIL;
	}

	public void setSTUD_EMAIL(String sTUD_EMAIL) {
		STUD_EMAIL = sTUD_EMAIL;
	}

	public Date getSTUD_JOININGDATE() {
		return STUD_JOININGDATE;
	}

	public void setSTUD_JOININGDATE(Date sTUD_JOININGDATE) {
		STUD_JOININGDATE = sTUD_JOININGDATE;
	}

	public boolean isSTUD_ACTIVE() {
		return STUD_ACTIVE;
	}

	public void setSTUD_ACTIVE(boolean sTUD_ACTIVE) {
		STUD_ACTIVE = sTUD_ACTIVE;
	}

	public int getVERSION() {
		return VERSION;
	}

	public void setVERSION(int vERSION) {
		VERSION = vERSION;
	}

	public List<Parent> getParent() {
		return parent;
	}

	public void setParent(List<Parent> parent) {
		this.parent = parent;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public List<Performance> getPerformance() {
		return performance;
	}

	public void setPerformance(List<Performance> performance) {
		this.performance = performance;
	}


	
	
}
