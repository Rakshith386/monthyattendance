package com.school.attendance.domine.standard;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="standard1")
public class Standard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6569459740046723403L;
    @Id
    @Column(name="stdid")
	private String stdid;
  
	@Column(name="standard")
	private String standard;
    @Column(name="medium")
	private String medium;
    @Column(name="section")
	private String section;
    @Column(name="syllabus")
	private String syllabus;
    @Column(name="StaffId")
    private String StaffId;
    @Column(name="StaffName")
	private String StaffName;
    @Column(name="staff_subject")
	private String staff_subject;
	
    @Column(name="isActive")
	private boolean isActive;
    

    
    public String getStdid() {
		return stdid;
	}
	public void setStdid(String stdid) {
		this.stdid = stdid;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
    
    
}
