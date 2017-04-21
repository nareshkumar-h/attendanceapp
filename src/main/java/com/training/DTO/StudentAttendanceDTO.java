package com.training.DTO;

public class StudentAttendanceDTO {

	private String sName;
	private String email;
	private String dept;
	private Long attandancePercentage;
	private Long totalSession;
	private Long totalAttended;

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

}
