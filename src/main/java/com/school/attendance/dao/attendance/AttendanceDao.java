package com.school.attendance.dao.attendance;

import java.util.List;

import com.school.attendance.domine.attendance.Attendance;
import com.school.attendance.response.Response;

public interface AttendanceDao {

	public Response addAttendance(Attendance att)throws Exception;

	public Response updateAttendance(Attendance att)throws Exception;

	public Attendance getAttendance(String studentId)throws Exception;

	public Response deleteAttendance(String studentId)throws Exception;

	public List<Attendance> getAttendanceByStandard(String standard, String section, String syllabus, String medium
			)throws Exception;

	public List<Attendance> getattendancebysubject(String standard, String section, String syllabus, String medium,
			String SubjectName,String SubjectName1)throws Exception;
	
	

}
