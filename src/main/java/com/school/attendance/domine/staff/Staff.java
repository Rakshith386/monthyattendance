package com.school.attendance.domine.staff;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Staff1")
public class Staff implements Serializable{

	private static final long serialVersionUID = 1L;
@Id
@Column(name="StaffId")
private String StaffId;

@Column(name="StaffName")
private String StaffName;

@Column(name="PhoneNumber")
private String PhoneNumber;

@Column(name="Subject")
private String Subject;

@Column(name="Password")
private String Password;

@Column(name="Stdid")
private String Stdid;

@Column(name="SubjectId")
private String SubjectId;

@Column(name="isActive")
private boolean isActive;

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

public boolean isActive() {
	return isActive;
}

public void setActive(boolean isActive) {
	this.isActive = isActive;
}

}
