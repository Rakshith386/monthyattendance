package com.school.attendance.model.detail;

import java.io.Serializable;

public class DetailModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9071874182071790884L;
	private String StudentId;
	private String StaffId;
	private String StaffName;
	private String SubjectName;
	private String SubjectId;
	private String StudentName;
	private String DetailID;
	private String standard;
	private String medium;
	private String section;
	private String syllabus;
	private String Exam_Type;
	private Integer marks;

    private String date;
	private Integer Year;
	private Integer total_marks;

	
	
	
	
	public String getSubjectId() {
		return SubjectId;
	}
	public void setSubjectId(String subjectId) {
		SubjectId = subjectId;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public String getStaffId() {
		return StaffId;
	}
	public void setStaffId(String staffId) {
		StaffId = staffId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String StudentName) {
		this.StudentName = StudentName;
	}
	
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getDetailID() {
		return DetailID;
	}
	public void setDetailID(String detailID) {
		DetailID = detailID;
	}
	public String getExam_Type() {
		return Exam_Type;
	}
	public void setExam_Type(String exam_Type) {
		Exam_Type = exam_Type;
	}
	
	public Integer getYear() {
		return Year;
	}
	public void setYear(Integer year) {
		Year = year;
	}
	public Integer getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(Integer total_marks) {
		this.total_marks = total_marks;
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
	
	
}