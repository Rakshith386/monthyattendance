package com.school.attendance.controller.student;

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

import com.school.attendance.model.student.StudentModel;

import com.school.attendance.response.Response;

import com.school.attendance.utils.CommonUtils;

import com.school.attendance.constant.StatusCode;

import com.school.attendance.response.ErrorObject;
import com.school.attendance.controller.student.StudentController;
import com.school.attendance.dao.student.StudentDao;
import com.school.attendance.service.student.StudentService;



@RestController
@RequestMapping("/v1")
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	StudentService studentService;	
	@Autowired
	StudentDao studentDao;
	
	
	
	@RequestMapping(value = "/student", method = RequestMethod.POST, produces = "application/json")
	public Response addUser(@Valid @RequestBody StudentModel student, HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult)
			throws Exception {
				return studentService.addStudent(student);
	
	}
	
	
	
	@RequestMapping(value = "/student", method = RequestMethod.PUT, produces = "application/json")
	public Response updateUser(@RequestBody StudentModel student, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("updateStudent: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("updateStudent: Received request: " + CommonUtils.getJson(student));
		return studentService.updateStudent(student);
	}

	
	
	@RequestMapping(value = "/student/{StudentId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getUser(@PathVariable("StudentId") String StudentId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getUser: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		StudentModel studentModel = studentService.getStudent(StudentId);
		Response res = CommonUtils.getResponseObject("standard details");
		if (studentModel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("Users Not Found", "Users Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("Users Not Found");
		} else {
			res.setData(studentModel);
		}
		logger.info("getUser: Sent response");
		return CommonUtils.getJson(res);
	}
	
	@RequestMapping(value = "/student/{standard}/{section}/{syllabus}/{medium}/{year}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getStudentByStandard(@PathVariable("standard") String standard,@PathVariable("section") String section,@PathVariable("syllabus") String syllabus,@PathVariable("medium") String medium,@PathVariable("year") String year, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("getStudentByStandard: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<StudentModel> studentmodel = studentService.getStudentByStandard( standard,  section,  syllabus,  medium, year  );
		Response res = CommonUtils.getResponseObject("List of student standard");
		if (studentmodel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("standard Not Found", "standard Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("standard not found");
		} else {
			res.setData(studentmodel);
		}
		logger.info("getStudentByStandard: Sent response");
		return CommonUtils.getJson(res);
	}
	
	
	
	@RequestMapping(value = "/student/{StudentId}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deleteUser(@PathVariable("StudentId") String StudentId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("getUser: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		return studentService.deleteStudent(StudentId);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("getStudents: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		List<StudentModel> students = studentService.getStudents();
		Response res = CommonUtils.getResponseObject("List of Students");
		if (students == null) {
			ErrorObject err = CommonUtils.getErrorResponse("students Not Found", "students Not Found");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
			res.setMessage("students Not Found");
		} else {
			res.setData(students);
		}
		logger.info("getStudents: Sent response");
		return CommonUtils.getJson(res);
	}

}
