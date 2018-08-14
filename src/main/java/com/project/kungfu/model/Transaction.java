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
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TRANSACTION")
	@SequenceGenerator(name = "SQ_TRANSACTION", sequenceName = "SQ_TRANSACTION", allocationSize = 1)
	private int TRN_ID;


	@Column
	private int STUD_ID;
	
	@Column
	private int PROD_ID;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date TRN_PURCHASEDATE;

	@Column
	@Version
	private int version;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="STUD_ID" , insertable=false , updatable=false )
	private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PROD_ID" , insertable=false , updatable=false )
	private Product product;

	public int getTRN_ID() {
		return TRN_ID;
	}

	public void setTRN_ID(int tRN_ID) {
		TRN_ID = tRN_ID;
	}

	public int getSTUD_ID() {
		return STUD_ID;
	}

	public void setSTUD_ID(int sTUD_ID) {
		STUD_ID = sTUD_ID;
	}

	public int getPROD_ID() {
		return PROD_ID;
	}

	public void setPROD_ID(int pROD_ID) {
		PROD_ID = pROD_ID;
	}

	public Date getTRN_PURCHASEDATE() {
		return TRN_PURCHASEDATE;
	}

	public void setTRN_PURCHASEDATE(Date tRN_PURCHASEDATE) {
		TRN_PURCHASEDATE = tRN_PURCHASEDATE;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	


}
