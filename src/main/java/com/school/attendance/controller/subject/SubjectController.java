package com.school.attendance.controller.subject;

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
import com.school.attendance.dao.subject.SubjectDao;
import com.school.attendance.model.subject.SubjectModel;
import com.school.attendance.response.ErrorObject;
import com.school.attendance.response.Response;
import com.school.attendance.service.subject.SubjectService;
import com.school.attendance.utils.CommonUtils;

@RestController
@RequestMapping("/v1")
public class SubjectController {
	private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);
	@Autowired
	SubjectService subjectService;	
	@Autowired
	SubjectDao subjectDao;	
	
	@RequestMapping(value = "/subject", method = RequestMethod.POST, produces = "application/json")
	public Response addSubject(@Valid @RequestBody SubjectModel subject, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult)
			throws Exception {
				return subjectService.addSubject(subject);
	
	}
	@RequestMapping(value = "/subject", method = RequestMethod.PUT, produces = "application/json")
	public Response updateSubject(@RequestBody SubjectModel subject, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("updateSubject: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateSubject: Received request: " + CommonUtils.getJson(subject));
		return subjectService.updateSubject(subject);
	}
	
	@RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getSubject(@PathVariable("subjectId") String subjectId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getSubject: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		SubjectModel subjectModel = subjectService.getSubject(subjectId);
		Response res = CommonUtils.getResponseObject("Subject Details");
		if (subjectModel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("getSubject Not Found", "getSubject Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("getSubject Not Found");
		} else {
			res.setData(subjectModel);
		}
		logger.info("getSubject: Sent response");
		return CommonUtils.getJson(res);
	}
	
	@RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deleteSubject(@PathVariable("subjectId") String subjectId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("deleteStandard: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		return subjectService.deleteSubject(subjectId);
	}
}
