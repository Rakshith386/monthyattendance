package com.school.attendance.model.attendance;

import java.io.Serializable;

public class AttendanceModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -646607714111099233L;

	
	private String AttendanceId;
	private String StaffId;
	private String StaffName;
	private String SubjectId;
	private String SubjectName;
	private String StudentId;
	private String StudentName;
	private String standard;
	private String medium;
	private String section;
	private String syllabus;
	private String Stdid;
	private boolean status;
	private Integer no_days;
	private Integer Present_days;
	private float percent;
	private String phone_num;
	private String Date;
	public String getAttendanceId() {
		return AttendanceId;
	}
	public void setAttendanceId(String attendanceId) {
		AttendanceId = attendanceId;
	}
	public String getStaffId() {
		return StaffId;
	}
	public void setStaffId(String staffId) {
		StaffId = staffId;
	}
	public String getSubjectId() {
		return SubjectId;
	}
	public void setSubjectId(String subjectId) {
		SubjectId = subjectId;
	}
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
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
	public String getStaffName() {
		return StaffName;
	}
	public void setStaffName(String staffName) {
		StaffName = staffName;
	}
	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	
	
	
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getStdid() {
		return Stdid;
	}
	public void setStdid(String stdid) {
		Stdid = stdid;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Integer getNo_days() {
		return no_days;
	}
	public void setNo_days(Integer no_days) {
		this.no_days = no_days;
	}
	public Integer getPresent_days() {
		return Present_days;
	}
	public void setPresent_days(Integer present_days) {
		Present_days = present_days;
	}
	public float getPercent() {
		return percent;
	}
	public void setPercent(float percent) {
		this.percent = percent;
	}
	
	
	
}
