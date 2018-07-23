package com.school.attendance.controller.standard;

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
import com.school.attendance.dao.standard.StandardDao;
import com.school.attendance.model.standard.StandardModel;
import com.school.attendance.response.ErrorObject;
import com.school.attendance.response.Response;
import com.school.attendance.service.standard.StandardService;
import com.school.attendance.utils.CommonUtils;

@RestController
@RequestMapping("/v1")
public class StandardController {
	private static final Logger logger = LoggerFactory.getLogger(StandardController.class);
	@Autowired
	StandardService standardService;	
	@Autowired
	StandardDao standardDao;

	@RequestMapping(value = "/standard", method = RequestMethod.POST, produces = "application/json")
	public Response addStandard(@Valid @RequestBody StandardModel standard, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult)
			throws Exception {
				return standardService.addStandard(standard);
	
	}
	@RequestMapping(value = "/standard", method = RequestMethod.PUT, produces = "application/json")
	public Response updateStandard(@RequestBody StandardModel standard, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("updateStandard: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateStandard: Received request: " + CommonUtils.getJson(standard));
		return standardService.updateStandard(standard);
	}
	

	@RequestMapping(value = "/standard/{Stdid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getStandard(@PathVariable("Stdid") String Stdid, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getStandard: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		StandardModel standardModel = standardService.getStandard(Stdid);
		Response res = CommonUtils.getResponseObject("Standard Details");
		if (standardModel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("Standard Not Found", "Standard Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("Standard Not Found");
		} else {
			res.setData(standardModel);
		}
		logger.info("getStandard: Sent response");
		return CommonUtils.getJson(res);
	}
	
	@RequestMapping(value = "/standard/{StdId}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deleteStandard(@PathVariable("StdId") String StdId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("deleteStandard: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		return standardService.deleteStandard(StdId);
	}
	@RequestMapping(value = "/standards", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getStandards(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("getUsers: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<StandardModel> users = standardService.getStandards();
		Response res = CommonUtils.getResponseObject("List of Users");
		if (users == null) {
			ErrorObject err = CommonUtils.getErrorResponse("Standards Not Found", "Standards Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("Standards Not Found");
		} else {
			res.setData(users);
		}
		logger.info("getStandards: Sent response");
		return CommonUtils.getJson(res);
	}
}
