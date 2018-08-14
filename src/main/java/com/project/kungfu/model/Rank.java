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
@Table(name = "RANK")
public class Rank implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RANK")
	@SequenceGenerator(name = "SQ_RANK", sequenceName = "SQ_RANK", allocationSize = 1)
	private int RANK_ID;

	@Column
	private String RANK_NAME;

	@Column
	private String RANK_DESCRIPTION;

	@Column
	private int RANK_LEVEL=1;

	

	@Column
	@Type(type = "yes_no")
	private boolean RANK_ACTIVE = true;
	
	@Column
	@Version
	private int version;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rank")
	private List<Performance> performance = new ArrayList<>();

	public int getRANK_ID() {
		return RANK_ID;
	}

	public void setRANK_ID(int rANK_ID) {
		RANK_ID = rANK_ID;
	}

	public String getRANK_NAME() {
		return RANK_NAME;
	}

	public void setRANK_NAME(String rANK_NAME) {
		RANK_NAME = rANK_NAME;
	}

	public String getRANK_DESCRIPTION() {
		return RANK_DESCRIPTION;
	}

	public void setRANK_DESCRIPTION(String rANK_DESCRIPTION) {
		RANK_DESCRIPTION = rANK_DESCRIPTION;
	}

	public int getRANK_LEVEL() {
		return RANK_LEVEL;
	}

	public void setRANK_LEVEL(int rANK_LEVEL) {
		RANK_LEVEL = rANK_LEVEL;
	}

	public boolean isRANK_ACTIVE() {
		return RANK_ACTIVE;
	}

	public void setRANK_ACTIVE(boolean rANK_ACTIVE) {
		RANK_ACTIVE = rANK_ACTIVE;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Performance> getPerformance() {
		return performance;
	}

	public void setPerformance(List<Performance> performance) {
		this.performance = performance;
	}
	
	

	
	
	
}
