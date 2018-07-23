package com.school.attendance.service.attendance;

import java.util.List;

import com.school.attendance.model.attendance.AttendanceModel;
import com.school.attendance.response.Response;

public interface AttendanceService {

	public Response addAttendance(List<AttendanceModel> attendance)throws Exception;

	public Response updateAttendance(AttendanceModel attendance)throws Exception;

	public AttendanceModel getAttendance(String studentId)throws Exception;

	public Response deleteAttendance(String studentId)throws Exception;

	public List<AttendanceModel> getAttendanceByStandard(String standard, String section, String syllabus,
			String medium)throws Exception;

	public List<AttendanceModel> getattendancebysubject(String standard, String section, String syllabus, String medium,
			String SubjectName,String SubjectName1)throws Exception;
	

}
