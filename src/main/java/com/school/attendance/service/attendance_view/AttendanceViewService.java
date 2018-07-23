package com.school.attendance.service.attendance_view;

import java.util.List;

import com.school.attendance.model.attendance_view.AttendanceViewModel;
import com.school.attendance.response.Response;

public interface AttendanceViewService {

	public Response addAttendanceview(List<AttendanceViewModel> attendanceview)throws Exception;

	public Response updateAttendanceview(AttendanceViewModel attendanceview)throws Exception;

	public List<AttendanceViewModel> getAttendanceViewByStandard(String standard, String section, String syllabus,
			String medium, String fromdate, String todate)throws Exception;

	public Response deleteAttendanceView(String studentId)throws Exception;

	public AttendanceViewModel getAttendanceView(String subjectName)throws Exception;
	

}
