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
@Table(name = "PRODUCT")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUCT")
	@SequenceGenerator(name = "SQ_PRODUCT", sequenceName = "SQ_PRODUCT", allocationSize = 1)
	private int PROD_ID;

	@Column
	private String PROD_NAME;

	@Column
	private String PROD_INFO;

	@Column
	private int PROD_PRICE;
	
	
	@Column
	@Type(type = "yes_no")
	private boolean PROD_ISDATEM = true;
	
	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date PROD_STARTDATE;
	
	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date PROD_ENDDATE;
	
	

	@Column
	@Type(type = "yes_no")
	private boolean PROD_ACTIVE = true;

	@Column
	@Version
	private int VERSION;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<Transaction> transaction = new ArrayList<>();

	public int getPROD_ID() {
		return PROD_ID;
	}

	public void setPROD_ID(int pROD_ID) {
		PROD_ID = pROD_ID;
	}

	public String getPROD_NAME() {
		return PROD_NAME;
	}

	public void setPROD_NAME(String pROD_NAME) {
		PROD_NAME = pROD_NAME;
	}

	public String getPROD_INFO() {
		return PROD_INFO;
	}

	public void setPROD_INFO(String pROD_INFO) {
		PROD_INFO = pROD_INFO;
	}

	public int getPROD_PRICE() {
		return PROD_PRICE;
	}

	public void setPROD_PRICE(int pROD_PRICE) {
		PROD_PRICE = pROD_PRICE;
	}

	public boolean isPROD_ISDATEM() {
		return PROD_ISDATEM;
	}

	public void setPROD_ISDATEM(boolean pROD_ISDATEM) {
		PROD_ISDATEM = pROD_ISDATEM;
	}

	public Date getPROD_STARTDATE() {
		return PROD_STARTDATE;
	}

	public void setPROD_STARTDATE(Date pROD_STARTDATE) {
		PROD_STARTDATE = pROD_STARTDATE;
	}

	public Date getPROD_ENDDATE() {
		return PROD_ENDDATE;
	}

	public void setPROD_ENDDATE(Date pROD_ENDDATE) {
		PROD_ENDDATE = pROD_ENDDATE;
	}

	public boolean isPROD_ACTIVE() {
		return PROD_ACTIVE;
	}

	public void setPROD_ACTIVE(boolean pROD_ACTIVE) {
		PROD_ACTIVE = pROD_ACTIVE;
	}

	public int getVERSION() {
		return VERSION;
	}

	public void setVERSION(int vERSION) {
		VERSION = vERSION;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}


	
	
}
