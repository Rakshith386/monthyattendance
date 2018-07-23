package com.school.attendance.controller.detail;

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
import com.school.attendance.model.detail.DetailModel;
import com.school.attendance.response.ErrorObject;
import com.school.attendance.response.Response;
import com.school.attendance.service.detail.DetailService;
import com.school.attendance.utils.CommonUtils;

@RestController
@RequestMapping("/v1")
public class DetailController {
	private static final Logger logger = LoggerFactory.getLogger(DetailController.class);
	@Autowired
	DetailService detailService;	
	
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST, produces = "application/json")
	public Response addDetail(@Valid @RequestBody List<DetailModel> detail, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult)
			throws Exception {
				return detailService.addDetail(detail);
	
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.PUT, produces = "application/json")
	public Response updateDetail(@RequestBody DetailModel detail, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("updateDetail: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateDetail: Received request: " + CommonUtils.getJson(detail));
		return detailService.updateDetail(detail);
	}
	
	@RequestMapping(value = "/detail/{DetailId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getDetail(@PathVariable("DetailId") String DetailId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getUser: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		DetailModel detailmodel = detailService.getDetail(DetailId);
		Response res = CommonUtils.getResponseObject("Staff Details");
		if (detailmodel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("detail Not Found", "detailnot Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("Detail Not Found");
		} else {
			res.setData(detailmodel);
		}
		logger.info("getDetail: Sent response");
		return CommonUtils.getJson(res);
	}
	
	@RequestMapping(value = "/detail/{DetailId}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deleteUser(@PathVariable("DetailId") String DetailId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("getDetail: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		return detailService.deleteDetail(DetailId);
	}
	@RequestMapping(value = "/details", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("getDetails: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<DetailModel> details= detailService.getDetails();
		Response res = CommonUtils.getResponseObject("List of details");
		if (details == null) {
			ErrorObject err = CommonUtils.getErrorResponse("details Not Found", "details Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("details Not Found");
		} else {
			res.setData(details);
		}
		logger.info("getstaffs: Sent response");
		return CommonUtils.getJson(res);
	}

}
