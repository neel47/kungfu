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
@Table(name = "PERFORMANCE")
public class Performance implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERFORMANCE")
	@SequenceGenerator(name = "SQ_PERFORMANCE", sequenceName = "SQ_PERFORMANCE", allocationSize = 1)
	private int PERF_ID;

	@Column
	private int STUD_ID;

	@Column
	private int RANK_ID;
	
	
	
	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date PERF_DATERECEIVED;

	
	
	@Column
	@Version
	private int version;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="STUD_ID" , insertable=false , updatable=false )
	private Student student;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="RANK_ID" , insertable=false , updatable=false )
	private Rank rank;


	public int getPERF_ID() {
		return PERF_ID;
	}


	public void setPERF_ID(int pERF_ID) {
		PERF_ID = pERF_ID;
	}


	public int getSTUD_ID() {
		return STUD_ID;
	}


	public void setSTUD_ID(int sTUD_ID) {
		STUD_ID = sTUD_ID;
	}


	public int getRANK_ID() {
		return RANK_ID;
	}


	public void setRANK_ID(int rANK_ID) {
		RANK_ID = rANK_ID;
	}


	public Date getPERF_DATERECEIVED() {
		return PERF_DATERECEIVED;
	}


	public void setPERF_DATERECEIVED(Date pERF_DATERECEIVED) {
		PERF_DATERECEIVED = pERF_DATERECEIVED;
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


	public Rank getRank() {
		return rank;
	}


	public void setRank(Rank rank) {
		this.rank = rank;
	}




}
