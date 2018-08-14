package com.project.kungfu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "INSTRUCTOR")
public class Instructor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INSTRUCTOR")
	@SequenceGenerator(name = "SQ_INSTRUCTOR", sequenceName = "SQ_INSTRUCTOR", allocationSize = 1)
	private int U_ID;

	@Column
	private String LOGINID;

	@Column
	private String U_PASSWORD;

	@Column
	private String U_NAME;

	@Column
	private String U_EMAIL;
	
	@Column
	private String U_MOBILE;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date U_DATECREATED;


	@Column
	@Type(type = "yes_no")
	private boolean U_ACTIVE = true;

	@Column
	@Version
	private int VERSION;

	public int getU_ID() {
		return U_ID;
	}

	public void setU_ID(int u_ID) {
		U_ID = u_ID;
	}

	public String getLOGINID() {
		return LOGINID;
	}

	public void setLOGINID(String lOGINID) {
		LOGINID = lOGINID;
	}

	public String getU_PASSWORD() {
		return U_PASSWORD;
	}

	public void setU_PASSWORD(String u_PASSWORD) {
		U_PASSWORD = u_PASSWORD;
	}

	public String getU_NAME() {
		return U_NAME;
	}

	public void setU_NAME(String u_NAME) {
		U_NAME = u_NAME;
	}

	public String getU_EMAIL() {
		return U_EMAIL;
	}

	public void setU_EMAIL(String u_EMAIL) {
		U_EMAIL = u_EMAIL;
	}

	public String getU_MOBILE() {
		return U_MOBILE;
	}

	public void setU_MOBILE(String u_MOBILE) {
		U_MOBILE = u_MOBILE;
	}

	public Date getU_DATECREATED() {
		return U_DATECREATED;
	}

	public void setU_DATECREATED(Date u_DATECREATED) {
		U_DATECREATED = u_DATECREATED;
	}

	public boolean isU_ACTIVE() {
		return U_ACTIVE;
	}

	public void setU_ACTIVE(boolean u_ACTIVE) {
		U_ACTIVE = u_ACTIVE;
	}

	public int getVERSION() {
		return VERSION;
	}

	public void setVERSION(int vERSION) {
		VERSION = vERSION;
	}

	
	
}
