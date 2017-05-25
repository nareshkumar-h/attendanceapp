package com.training.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.training.converter.CustomJsonDateDeserializer;
import com.training.converter.JsonDateSerializer;
import com.training.converter.LocalDateAttributeConverter;

@Entity
@Table(name = "attendance")
public class StudentAttandance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "training_id")
	private Long trainingId;

	@OneToOne
	@JoinColumn(name = "student_id")
	private Student studentId;

	@Column(name = "reason")
	private String reason;

	@Column(name = "attended")
	private boolean attended;

	@Column(name = "present_by_student")
	private boolean present;

	@JsonSerialize(using = JsonDateSerializer.class)
	@Convert(converter = LocalDateAttributeConverter.class)
	@Column(name = "created_date")
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private LocalDateTime createdDate;

	@JsonSerialize(using = JsonDateSerializer.class)
	@Convert(converter = LocalDateAttributeConverter.class)
	@Column(name = "modified_date")
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private LocalDateTime modifiedDate;

	@Transient
	private boolean modified;

	@Transient
	private boolean freeze;

	@Transient
	private String updatedBy;

	@Column(name = "modifiedBy")
	private Long modifiedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(Long trainingId) {
		this.trainingId = trainingId;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isAttended() {
		return attended;
	}

	public void setAttended(boolean attended) {
		this.attended = attended;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public boolean isFreeze() {
		return freeze;
	}

	public void setFreeze(boolean freeze) {
		this.freeze = freeze;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}