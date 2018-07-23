package com.school.attendance.controller.attendance_view;

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
import com.school.attendance.contoller.attendance.AttendanceController;
import com.school.attendance.model.attendance.AttendanceModel;
import com.school.attendance.model.attendance_view.AttendanceViewModel;
import com.school.attendance.response.ErrorObject;
import com.school.attendance.response.Response;
import com.school.attendance.service.attendance.AttendanceService;
import com.school.attendance.service.attendance_view.AttendanceViewService;
import com.school.attendance.utils.CommonUtils;

@RestController
@RequestMapping("/v1")
public class AttendanceViewController {
	private static final Logger logger = LoggerFactory.getLogger(AttendanceViewController.class);
	@Autowired
	AttendanceViewService attendanceViewService;	

	
	@RequestMapping(value = "/attendanceview", method = RequestMethod.POST, produces = "application/json")
	public Response addAttendanceview(@Valid @RequestBody List<AttendanceViewModel> attendanceview, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult)
			throws Exception {
				return attendanceViewService.addAttendanceview(attendanceview);
	
	}
	
	@RequestMapping(value = "/attendanceview", method = RequestMethod.PUT, produces = "application/json")
	public Response updateAttendanceview(@RequestBody AttendanceViewModel attendanceview, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("updateAttendanceview: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateAttendanceview: Received request: " + CommonUtils.getJson(attendanceview));
		return attendanceViewService.updateAttendanceview(attendanceview);
	}
	
	@RequestMapping(value = "/attendanceviewbystandard/{standard}/{section}/{syllabus}/{medium}/{fromdate}/{todate}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getAttendanceViewByStandard(@PathVariable("standard") String standard,@PathVariable("section") String section,@PathVariable("syllabus") String syllabus,
			@PathVariable("medium") String medium,@PathVariable("fromdate") String fromdate,@PathVariable("todate") String todate, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getAttendanceViewByStandard: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<AttendanceViewModel> attendanceviewmodel = attendanceViewService.getAttendanceViewByStandard( standard,  section,  syllabus,  medium ,fromdate, todate );
		Response res = CommonUtils.getResponseObject("List of student attendance");
		if (attendanceviewmodel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("attendance Not Found", "attendance Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("attendance not found");
		} else {
			res.setData(attendanceviewmodel);
		}
		logger.info("getAttendanceByStandard: Sent response");
		return CommonUtils.getJson(res);
	}
	
	@RequestMapping(value = "/attendanceviewbystandard/{StudentId}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deleteAttendanceView(@PathVariable("StudentId") String StudentId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("deleteAttendance: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		return attendanceViewService.deleteAttendanceView(StudentId);
	}
	
	@RequestMapping(value = "/attendanceview/{SubjectName}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getAttendanceView(@PathVariable("SubjectName") String SubjectName, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getAttendance: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		AttendanceViewModel attendanceViewModel = attendanceViewService.getAttendanceView(SubjectName);
		Response res = CommonUtils.getResponseObject("Standard Details");
		if (attendanceViewModel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("attendance Not Found", "attendance Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("attendance Not Found");
		} else {
			res.setData(attendanceViewModel);
		}
		logger.info("getAttendance: Sent response");
		return CommonUtils.getJson(res);
	}
	
}
