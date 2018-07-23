package com.school.attendance.domine.attendance_view;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="AttendanceView1")
public class AttendanceView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6507628814016438382L;

	@Id
	@Column(name="avid")
	private String avid;
	@Column(name="standard")
	private String standard;
	@Column(name="medium")
	private String medium;
	@Column(name="section")
	private String section;
	@Column(name="syllabus")
	private String syllabus;
	@Column(name="StaffName")
	private String StaffName;
	@Column(name="StudentId")
	private String StudentId;
	@Column(name="MobileNumber")
	private String MobileNumber;
	@Column(name="fromDate")
	private Date fromDate;
	@Column(name="toDate")
	private Date toDate;
	@Column(name="StudentName")
	private String  StudentName;
	@Column(name="sub1")
	private String sub1;
	@Column(name="sub1_days")
	private String sub1_days;
	@Column(name="sub1_pdays")
	private String sub1_pdays;
	@Column(name="sub1_percent")
	private String sub1_percent;
	@Column(name="sub2")
	private String sub2;
	@Column(name="sub2_days")
	private String sub2_days;
	@Column(name="sub2_pdays")
	private String sub2_pdays;
	@Column(name="sub2_percent")
	private String sub2_percent;
	@Column(name="sub3")
	private String sub3;
	@Column(name="sub3_days")
	private String sub3_days;
	@Column(name="sub3_pdays")
	private String sub3_pdays;
	@Column(name="sub3_percent")
	private String sub3_percent;
	@Column(name="sub4")
	private String sub4;
	@Column(name="sub4_days")
	private String sub4_days;
	@Column(name="sub4_pdays")
	private String sub4_pdays;
	@Column(name="sub4_percent")
	private String sub4_percent;
	@Column(name="sub5")
	private String sub5;
	@Column(name="sub5_days")
	private String sub5_days;
	@Column(name="sub5_pdays")
	private String sub5_pdays;
	@Column(name="sub5_percent")
	private String sub5_percent;
	@Column(name="sub6")
	private String sub6;
	@Column(name="sub6_days")
	private String sub6_days;
	@Column(name="sub6_pdays")
	private String sub6_pdays;
	@Column(name="sub6_percent")
	private String sub6_percent;
	@Column(name="sub7")
	private String sub7;
	@Column(name="sub7_days")
	private String sub7_days;
	@Column(name="sub7_pdays")
	private String sub7_pdays;
	@Column(name="sub7_percent")
	private String sub7_percent;
	@Column(name="sub8")
	private String sub8;
	@Column(name="sub8_days")
	private String sub8_days;
	@Column(name="sub8_pdays")
	private String sub8_pdays;
	@Column(name="sub8_percent")
	private String sub8_percent;
	  @Column(name="isActive")
	     private boolean isActive;
	  
	  
	public String getAvid() {
		return avid;
	}
	public void setAvid(String avid) {
		this.avid = avid;
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
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	

	
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getSub1() {
		return sub1;
	}
	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}
	public String getSub1_days() {
		return sub1_days;
	}
	public void setSub1_days(String sub1_days) {
		this.sub1_days = sub1_days;
	}
	public String getSub1_pdays() {
		return sub1_pdays;
	}
	public void setSub1_pdays(String sub1_pdays) {
		this.sub1_pdays = sub1_pdays;
	}
	public String getSub1_percent() {
		return sub1_percent;
	}
	public void setSub1_percent(String sub1_percent) {
		this.sub1_percent = sub1_percent;
	}
	public String getSub2() {
		return sub2;
	}
	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}
	public String getSub2_days() {
		return sub2_days;
	}
	public void setSub2_days(String sub2_days) {
		this.sub2_days = sub2_days;
	}
	public String getSub2_pdays() {
		return sub2_pdays;
	}
	public void setSub2_pdays(String sub2_pdays) {
		this.sub2_pdays = sub2_pdays;
	}
	public String getSub2_percent() {
		return sub2_percent;
	}
	public void setSub2_percent(String sub2_percent) {
		this.sub2_percent = sub2_percent;
	}
	public String getSub3() {
		return sub3;
	}
	public void setSub3(String sub3) {
		this.sub3 = sub3;
	}
	public String getSub3_days() {
		return sub3_days;
	}
	public void setSub3_days(String sub3_days) {
		this.sub3_days = sub3_days;
	}
	public String getSub3_pdays() {
		return sub3_pdays;
	}
	public void setSub3_pdays(String sub3_pdays) {
		this.sub3_pdays = sub3_pdays;
	}
	public String getSub3_percent() {
		return sub3_percent;
	}
	public void setSub3_percent(String sub3_percent) {
		this.sub3_percent = sub3_percent;
	}
	public String getSub4() {
		return sub4;
	}
	public void setSub4(String sub4) {
		this.sub4 = sub4;
	}
	public String getSub4_days() {
		return sub4_days;
	}
	public void setSub4_days(String sub4_days) {
		this.sub4_days = sub4_days;
	}
	public String getSub4_pdays() {
		return sub4_pdays;
	}
	public void setSub4_pdays(String sub4_pdays) {
		this.sub4_pdays = sub4_pdays;
	}
	public String getSub4_percent() {
		return sub4_percent;
	}
	public void setSub4_percent(String sub4_percent) {
		this.sub4_percent = sub4_percent;
	}
	public String getSub5() {
		return sub5;
	}
	public void setSub5(String sub5) {
		this.sub5 = sub5;
	}
	public String getSub5_days() {
		return sub5_days;
	}
	public void setSub5_days(String sub5_days) {
		this.sub5_days = sub5_days;
	}
	public String getSub5_pdays() {
		return sub5_pdays;
	}
	public void setSub5_pdays(String sub5_pdays) {
		this.sub5_pdays = sub5_pdays;
	}
	public String getSub5_percent() {
		return sub5_percent;
	}
	public void setSub5_percent(String sub5_percent) {
		this.sub5_percent = sub5_percent;
	}
	public String getSub6() {
		return sub6;
	}
	public void setSub6(String sub6) {
		this.sub6 = sub6;
	}
	public String getSub6_days() {
		return sub6_days;
	}
	public void setSub6_days(String sub6_days) {
		this.sub6_days = sub6_days;
	}
	public String getSub6_pdays() {
		return sub6_pdays;
	}
	public void setSub6_pdays(String sub6_pdays) {
		this.sub6_pdays = sub6_pdays;
	}
	public String getSub6_percent() {
		return sub6_percent;
	}
	public void setSub6_percent(String sub6_percent) {
		this.sub6_percent = sub6_percent;
	}
	public String getSub7() {
		return sub7;
	}
	public void setSub7(String sub7) {
		this.sub7 = sub7;
	}
	public String getSub7_days() {
		return sub7_days;
	}
	public void setSub7_days(String sub7_days) {
		this.sub7_days = sub7_days;
	}
	public String getSub7_pdays() {
		return sub7_pdays;
	}
	public void setSub7_pdays(String sub7_pdays) {
		this.sub7_pdays = sub7_pdays;
	}
	public String getSub7_percent() {
		return sub7_percent;
	}
	public void setSub7_percent(String sub7_percent) {
		this.sub7_percent = sub7_percent;
	}
	public String getSub8() {
		return sub8;
	}
	public void setSub8(String sub8) {
		this.sub8 = sub8;
	}
	public String getSub8_days() {
		return sub8_days;
	}
	public void setSub8_days(String sub8_days) {
		this.sub8_days = sub8_days;
	}
	public String getSub8_pdays() {
		return sub8_pdays;
	}
	public void setSub8_pdays(String sub8_pdays) {
		this.sub8_pdays = sub8_pdays;
	}
	public String getSub8_percent() {
		return sub8_percent;
	}
	public void setSub8_percent(String sub8_percent) {
		this.sub8_percent = sub8_percent;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
