package com.school.attendance.dao.subject;

import com.school.attendance.domine.subject.Subject;
import com.school.attendance.response.Response;

public interface SubjectDao {

	public Response addSubject(Subject us)throws Exception;

	public Subject getSubject(String subjectId)throws Exception;

	public Response deleteSubject(String subjectId)throws Exception;

	public Response updateSubject(Subject us)throws Exception;
	

}
