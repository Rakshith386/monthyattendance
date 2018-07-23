package com.school.attendance.domine.attendance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Attendance1")
public class Attendance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     @Id
     @Column(name="AttendanceId")
	private String AttendanceId;
     @Column(name="StaffId")
	private String StaffId;
     @Column(name="SubjectId")
	private String SubjectId;
     @Column(name="StudentId")
	private String StudentId;
     @Column(name="SubjectName")
     private String SubjectName;
     @Column(name="StaffName")
     private String StaffName;
     @Column(name="StudentName")
 	private String StudentName;
     @Column(name="standard")
     private String standard;
     @Column(name="medium")
 	private String medium;
     @Column(name="section")
 	private String section;
     @Column(name="syllabus")
 	private String syllabus;
     @Column(name="Stdid")
 	private String Stdid;
     @Column(name="status")
	private boolean status;
     @Column(name="no_days")
     private Integer no_days;
     @Column(name="Present_days")
 	private Integer Present_days;
     @Column(name="percent")
 	private float percent;
     @Column(name="Date")
	private String Date;
     @Column(name="phone_num")
  	private String phone_num;
     @Column(name="isActive")
     private boolean isActive;
     
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
	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
	public String getStaffName() {
		return StaffName;
	}
	public void setStaffName(String staffName) {
		StaffName = staffName;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
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
	public String getStdid() {
		return Stdid;
	}
	public void setStdid(String stdid) {
		Stdid = stdid;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	

     
}
