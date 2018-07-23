package com.school.attendance.domine.student;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student1")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2489590448764721387L;

	@Id
	@Column(name="StudentId")
	private String StudentId;
	
	@Column(name="StudentName")
	private String StudentName;
	
	@Column(name="FatherName")
	private String FatherName;
	
	@Column(name="Standard")
	private String Standard;
	
	@Column(name="medium")
	private String medium;
	
	@Column(name="section")
	private String section;
	
	@Column(name="syllabus")
	private String syllabus;
	
	@Column(name="Year")
	private String Year;
	
	@Column(name="MobileNumber")
	private String MobileNumber;
	
	@Column(name="isActive")
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
