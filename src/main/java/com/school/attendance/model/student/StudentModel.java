package com.school.attendance.model.student;

import java.io.Serializable;

public class StudentModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3247877589581955993L;

	private String StudentId;
	private String StudentName;
	private String FatherName;
	private String Standard;
	private String medium;
	private String section;
	private String syllabus;
	private String Year;
	private String MobileNumber;
	private boolean isActive;
	
	
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getFatherName() {
		return FatherName;
	}
	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}
	public String getStandard() {
		return Standard;
	}
	public void setStandard(String standard) {
		Standard = standard;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	
}
