package com.school.attendance.service.subject;

import com.school.attendance.model.subject.SubjectModel;
import com.school.attendance.response.Response;

public interface SubjectService {

	public SubjectModel getSubject(String subjectId)throws Exception;

	public Response addSubject(SubjectModel subject)throws Exception;

	public Response updateSubject(SubjectModel subject)throws Exception;

	public Response deleteSubject(String subjectId)throws Exception;
	

}
