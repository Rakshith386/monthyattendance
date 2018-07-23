package com.school.attendance.controller.staff;

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
import com.school.attendance.dao.staff.StaffDao;
import com.school.attendance.model.staff.StaffModel;
import com.school.attendance.response.ErrorObject;
import com.school.attendance.response.Response;
import com.school.attendance.service.staff.StaffService;
import com.school.attendance.utils.CommonUtils;

@RestController
@RequestMapping("/v1")
public class StaffController {
	private static final Logger logger = LoggerFactory.getLogger(StaffController.class);
	@Autowired
	StaffService staffService;	
	@Autowired
	StaffDao staffDao;
	
	
	@RequestMapping(value = "/staff", method = RequestMethod.POST, produces = "application/json")
	public Response addUser(@Valid @RequestBody StaffModel staff, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult)
			throws Exception {
				return staffService.addStaff(staff);
	
						}
				@RequestMapping(value = "/staff", method = RequestMethod.PUT, produces = "application/json")
				public Response updateStaff(@RequestBody StaffModel staff, HttpServletRequest request, HttpServletResponse response)
						throws Exception {
					logger.info("updateStaff: Received request URL: " + request.getRequestURL().toString()
							+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
					logger.info("updateStaff: Received request: " + CommonUtils.getJson(staff));
					return staffService.updateStaff(staff);
				}
	
	
	
	
	@RequestMapping(value = "/staff/{StaffId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getStaff(@PathVariable("StaffId") String StaffId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getUser: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		StaffModel staffmodel = staffService.getStaff(StaffId);
		Response res = CommonUtils.getResponseObject("Staff Details");
		if (staffmodel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("staff Not Found", "staffNot Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("Users Not Found");
		} else {
			res.setData(staffmodel);
		}
		logger.info("getstaff: Sent response");
		return CommonUtils.getJson(res);
	}
	
	@RequestMapping(value = "/staffbysubject/{Subject}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getStaffsub(@PathVariable("Subject") String Subject, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getStaffsub: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<StaffModel> staffmodel = staffService.getStaffsub(Subject);
		Response res = CommonUtils.getResponseObject("Staff subject Details");
		if (staffmodel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("subject Not Found", "subject Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("subject Not Found");
		} else {
			res.setData(staffmodel);
		}
		logger.info("getStaffsub: Sent response");
		return CommonUtils.getJson(res);
	}
	
	@RequestMapping(value = "/staffbypassword/{StaffName}/{Password}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getStaffByPassword(@PathVariable("StaffName") String StaffName,@PathVariable("Password") String Password, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getStaffByPassword: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		StaffModel staffmodel = staffService.getStaffByPassword(StaffName,Password);
		Response res = CommonUtils.getResponseObject("Staff Detail");
		if (staffmodel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("staff Not Found", "staff Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("staff Not Found");
		} else {
			res.setData(staffmodel);
		}
		logger.info("getStaffByPassword: Sent response");
		return CommonUtils.getJson(res);
	}
	
	
	
	
	@RequestMapping(value = "/staff/{StaffId}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deleteUser(@PathVariable("StaffId") String StaffId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("getUser: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		return staffService.deleteStaff(StaffId);
	}
	
	@RequestMapping(value = "/staffs", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getStaffs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("getUsers: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<StaffModel> staffs = staffService.getStaffs();
		Response res = CommonUtils.getResponseObject("List of staffs");
		if (staffs == null) {
			ErrorObject err = CommonUtils.getErrorResponse("staffs Not Found", "staffs Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("staffs Not Found");
		} else {
			res.setData(staffs);
		}
		logger.info("getstaffs: Sent response");
		return CommonUtils.getJson(res);
	}
}
