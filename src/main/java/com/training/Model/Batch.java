package com.training.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "batches")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "batch_no")
	private Long batchId;

	@Column(name = "batch_name")
	private String batchName;

	@ManyToOne
	@JoinColumn(name = "college_id")
	private College college;

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	
}
