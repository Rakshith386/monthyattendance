package com.school.attendance.contoller.attendance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.attendance.constant.StatusCode;
import com.school.attendance.dao.attendance.AttendanceDao;
import com.school.attendance.model.attendance.AttendanceModel;
import com.school.attendance.model.detail.DetailModel;
import com.school.attendance.model.student.StudentModel;
import com.school.attendance.response.ErrorObject;
import com.school.attendance.response.Response;
import com.school.attendance.service.attendance.AttendanceService;
import com.school.attendance.utils.CommonUtils;


@RestController
@RequestMapping("/v1")
public class AttendanceController {
	private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);
	@Autowired
	AttendanceService attendanceService;	

	
	@RequestMapping(value = "/attendance", method = RequestMethod.POST, produces = "application/json")
	public Response addAttendance(@Valid @RequestBody List<AttendanceModel> attendance, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult)
			throws Exception {
				return attendanceService.addAttendance(attendance);
	
	}
	
	@RequestMapping(value = "/attendance", method = RequestMethod.PUT, produces = "application/json")
	public Response updateAttendance(@RequestBody AttendanceModel attendance, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("updateAttendance: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateAttendance: Received request: " + CommonUtils.getJson(attendance));
		return attendanceService.updateAttendance(attendance);
	}
	
	@RequestMapping(value = "/attendance/{StudentId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getAttendance(@PathVariable("StudentId") String StudentId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getAttendance: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		AttendanceModel attendanceModel = attendanceService.getAttendance(StudentId);
		Response res = CommonUtils.getResponseObject("Standard Details");
		if (attendanceModel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("attendance Not Found", "attendance Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("attendance Not Found");
		} else {
			res.setData(attendanceModel);
		}
		logger.info("getAttendance: Sent response");
		return CommonUtils.getJson(res);
	}
	
	
	
	
	@RequestMapping(value = "/attendancebystandard/{standard}/{section}/{syllabus}/{medium}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getAttendanceByStandard(@PathVariable("standard") String standard,@PathVariable("section") String section,@PathVariable("syllabus") String syllabus,@PathVariable("medium") String medium, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getStudentByStandard: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<AttendanceModel> attendancemodel = attendanceService.getAttendanceByStandard( standard,  section,  syllabus,  medium  );
		Response res = CommonUtils.getResponseObject("List of student attendance");
		if (attendancemodel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("attendance Not Found", "attendance Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("attendance not found");
		} else {
			res.setData(attendancemodel);
		}
		logger.info("getAttendanceByStandard: Sent response");
		return CommonUtils.getJson(res);
	}
	@RequestMapping(value = "/attendance/{StudentId}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deleteAttendance(@PathVariable("StudentId") String StudentId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("deleteAttendance: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		return attendanceService.deleteAttendance(StudentId);
	}
	
	@RequestMapping(value = "/attendancebysubject/{standard}/{section}/{syllabus}/{medium}/{SubjectName}/{SubjectName1}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getattendancebysubject(@PathVariable("standard") String standard,@PathVariable("section") String section,@PathVariable("syllabus") String syllabus,@PathVariable("medium") String medium,
			@PathVariable("SubjectName") String SubjectName,@PathVariable("SubjectName1") String SubjectName1, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getAttendanceByStandard: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<AttendanceModel> attendancemodel = attendanceService.getattendancebysubject( standard,  section,  syllabus,  medium ,SubjectName,SubjectName1 );
		Response res = CommonUtils.getResponseObject("List of student attendance");
		if (attendancemodel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("subject Not Found", "subject Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("subject not found");
		} else {
			res.setData(attendancemodel);
		}
		logger.info("getAttendanceByStandard: Sent response");
		return CommonUtils.getJson(res);
	}
	
}
