package com.school.attendance.dao.attendance_view;

import java.util.List;

import com.school.attendance.domine.attendance_view.AttendanceView;
import com.school.attendance.response.Response;

public interface AttendanceViewDao {

	public Response addAttendanceview(AttendanceView att)throws Exception;

	public Response updateAttendanceview(AttendanceView att)throws Exception;

	public List<AttendanceView> getAttendanceViewByStandard(String standard, String section, String syllabus,
			String medium, String fromdate, String todate)throws Exception;

	public Response deleteAttendanceView(String studentId)throws Exception;

	public AttendanceView getAttendanceView(String subjectName)throws Exception;

}
