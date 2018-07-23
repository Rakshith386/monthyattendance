package com.school.attendance.model.standard;

import java.io.Serializable;

public class StandardModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8360069056492550965L;
	
	private String Stdid;
	private String standard;
	private String medium;
	private String section;
	private String syllabus;
	private String subject;
	private String StaffId;
	private String StaffName;
	private String staff_subject;
	
	
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getStdid() {
		return Stdid;
	}
	public void setStdid(String stdid) {
		Stdid = stdid;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public String getStaff_subject() {
		return staff_subject;
	}
	public void setStaff_subject(String staff_subject) {
		this.staff_subject = staff_subject;
	}
	
	
	

}
