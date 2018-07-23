package com.school.attendance.model.subject;

import java.io.Serializable;

public class SubjectModel  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3683354366551399750L;

	
	private String SubjectId;
	private String StaffId;
	private String SubjectName;
	public String getSubjectId() {
		return SubjectId;
	}
	public void setSubjectId(String subjectId) {
		SubjectId = subjectId;
	}
	public String getStaffId() {
		return StaffId;
	}
	public void setStaffId(String staffId) {
		StaffId = staffId;
	}
	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
}
