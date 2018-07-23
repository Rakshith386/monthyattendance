package com.school.attendance.model.staff;

import java.io.Serializable;

public class StaffModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5714785134748596467L;

	
	private String StaffId;
	private String StaffName;
	private String PhoneNumber;
	private String Subject;
	private String Password;
	private String Stdid;
	private String SubjectId;
	private boolean isActive;
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getStaffId() {
		return StaffId;
	}
	public void setStaffId(String staffId) {
		StaffId = staffId;
	}
	public String getStaffName() {
		return StaffName;
	}
	public void setStaffName(String staffName) {
		StaffName = staffName;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getStdid() {
		return Stdid;
	}
	public void setStdid(String stdid) {
		Stdid = stdid;
	}
	public String getSubjectId() {
		return SubjectId;
	}
	public void setSubjectId(String subjectId) {
		SubjectId = subjectId;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	 
	
}
