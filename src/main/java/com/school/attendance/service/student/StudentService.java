package com.school.attendance.service.student;

import java.util.List;

import com.school.attendance.model.student.StudentModel;
import com.school.attendance.response.Response;

public interface StudentService {

	public Response addStudent(StudentModel student) throws Exception;

	public StudentModel getStudent(String studentId)throws Exception;



	public Response deleteStudent(String studentId)throws Exception;

	public Response updateStudent(StudentModel student)throws Exception;

	public List<StudentModel> getStudents()throws Exception;

	public List<StudentModel> getStudentByStandard(String standard, String section, String syllabus, String medium,
			String year)throws Exception;

	
}
