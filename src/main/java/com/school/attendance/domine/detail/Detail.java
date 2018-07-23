package com.school.attendance.domine.detail;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Detail1")
public class Detail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -39082786967525314L;

	
	@Column(name="StudentName")
	private String StudentName;
	@Column(name="StudentId")
	private String StudentId;
	@Column(name="StaffId")
	private String StaffId;
	@Column(name="SubjectId")
	private String SubjectId;
	@Column(name="StaffName")
	private String StaffName;
	@Column(name="SubjectName")
	private String SubjectName;
	@Column(name="standard")
	private String standard;
	@Column(name="medium")
	private String medium;
	@Column(name="section")
	private String section;
	@Column(name="syllabus")
	private String syllabus;
	@Id
	@Column(name="DetailID")
	private String DetailID;
	@Column(name="Exam_Type")
	private String Exam_Type;
	@Column(name="marks")
	private Integer marks;
	
	    @Column(name="date")
		private String date;
	
	@Column(name="Year")
	private Integer Year;
	@Column(name="total_marks")
	private Integer total_marks;

	@Column(name="isActive")
	private boolean isActive;
	
	
	

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
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
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
	public void setStudentName(String studentName) {
		StudentName = studentName;
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
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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