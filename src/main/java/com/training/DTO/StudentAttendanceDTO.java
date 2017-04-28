package com.training.DTO;

import java.time.LocalDateTime;

import javax.persistence.Convert;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.training.converter.CustomJsonDateDeserializer;
import com.training.converter.JsonDateSerializer;
import com.training.converter.LocalDateAttributeConverter;

public class StudentAttendanceDTO {
    private Long id;
	private String sName;
	private String email;
	private String dept;
	private Long attandancePercentage;
	private Long totalSession;
	private Long totalAttended;

	private String mobileNo;
	private boolean attended;
	private String reason;

	@JsonSerialize(using = JsonDateSerializer.class)
	@Convert(converter = LocalDateAttributeConverter.class)
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private LocalDateTime createdDate;

	@JsonSerialize(using = JsonDateSerializer.class)
	@Convert(converter = LocalDateAttributeConverter.class)
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private LocalDateTime modifiedDate;
	private String batchName;
	private String collegeName;
	private Long batchId;
	private String trDate;
	private Long studentAttendanceId;
	private Long modifiedBy;
	private boolean modified;
	private Long reviewdBy;
	private Long reviewStatus;

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Long getAttandancePercentage() {
		return attandancePercentage;
	}

	public void setAttandancePercentage(Long attandancePercentage) {
		this.attandancePercentage = attandancePercentage;
	}

	public Long getTotalSession() {
		return totalSession;
	}

	public void setTotalSession(Long totalSession) {
		this.totalSession = totalSession;
	}

	public Long getTotalAttended() {
		return totalAttended;
	}

	public void setTotalAttended(Long totalAttended) {
		this.totalAttended = totalAttended;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public boolean isAttended() {
		return attended;
	}

	public void setAttended(boolean attended) {
		this.attended = attended;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public String getTrDate() {
		return trDate;
	}

	public void setTrDate(String trDate) {
		this.trDate = trDate;
	}

	public Long getStudentAttendanceId() {
		return studentAttendanceId;
	}

	public void setStudentAttendanceId(Long studentAttendanceId) {
		this.studentAttendanceId = studentAttendanceId;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReviewdBy() {
		return reviewdBy;
	}

	public void setReviewdBy(Long reviewdBy) {
		this.reviewdBy = reviewdBy;
	}

	public Long getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(Long reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	

	

}
