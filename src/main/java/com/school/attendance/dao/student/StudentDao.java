package com.school.attendance.dao.student;

import java.util.List;

import com.school.attendance.domine.student.Student;
import com.school.attendance.response.Response;

public interface StudentDao {

	

	public Response addStudent(Student us)throws Exception;



	public Student getStudent(String studentId)throws Exception;





	public Response deleteStudent(String studentId)throws Exception;



	public List<Student> getStudents()throws Exception;



	public Response updateStudent(Student student2)throws Exception;



	public List<Student> getStudentByStandard(String standard, String section, String syllabus, String medium,
			String year)throws Exception;





;

}
