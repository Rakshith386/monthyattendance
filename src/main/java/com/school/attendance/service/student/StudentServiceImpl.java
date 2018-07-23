package com.school.attendance.service.student;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.attendance.dao.student.StudentDao;
import com.school.attendance.domine.student.Student;
import com.school.attendance.mapper.studentmapper.StudentMapper;
import com.school.attendance.model.student.StudentModel;
import com.school.attendance.response.Response;
import com.school.attendance.utils.CommonUtils;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
@Autowired
StudentDao studentDao;
@Autowired
StudentMapper studentMapper;


private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);


	public Response addStudent(StudentModel student) throws Exception {
		try{
			Student us=new Student();
			us.setStudentId(CommonUtils.generateRandomId());
			us.setStudentName(student.getStudentName());
			us.setFatherName(student.getFatherName());
			us.setStandard(student.getStandard());
			us.setMedium(student.getMedium());
			us.setSection(student.getSection());
			us.setSyllabus(student.getSyllabus());
			us.setYear(student.getYear());
			us.setMobileNumber(student.getMobileNumber());
			us.setActive(student.isActive());
		Response response = studentDao.addStudent(us);
		return response;
		}
	catch (Exception ex) {
		logger.info("Exception Service:" + ex.getMessage());
	}
	return null;
		
	}

	public StudentModel getStudent(String studentId) throws Exception {
		try {
			StudentModel studentModel = new StudentModel();
			Student student = studentDao.getStudent(studentId);
			BeanUtils.copyProperties(student, studentModel);
			return studentModel;
		} catch (Exception e) {
			logger.info("Exception getUser:", e);
			return null;
		}
	}

	public Response deleteStudent(String studentId) throws Exception {
		try {
			
			return studentDao.deleteStudent(studentId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e);
			return null;
		}
	}


	public Response updateStudent(StudentModel student1) throws Exception {
		try {

			Student student2 = studentDao.getStudent(student1.getStudentId());
			student2.setStudentName(student1.getStudentName());
			student2.setFatherName(student1.getFatherName());
			student2.setStandard(student1.getStandard());
			student2.setMedium(student1.getMedium());
			student2.setSection(student1.getSection());
			student2.setSyllabus(student1.getSyllabus());
			student2.setYear(student1.getYear());
			student2.setMobileNumber(student1.getMobileNumber());
			student2.setActive(student1.isActive());
			Response response = studentDao.updateStudent(student2);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}


	public List<StudentModel> getStudents() throws Exception {
		try {
			List<Student> student = studentDao.getStudents();
			return studentMapper.entityList(student);
		} catch (Exception ex) {
			logger.info("Exception getStudents:", ex);
		}
		return null;
	}

	

	@Override
	public List<StudentModel> getStudentByStandard(String standard, String section, String syllabus, String medium,
			String year) throws Exception {
		try {
			List<Student> stud = studentDao.getStudentByStandard(standard,section,syllabus,medium,year  );
			return studentMapper.entityList(stud);
		} catch (Exception ex) {
			logger.info("Exception getStudentByStandard:", ex);
		}
		return null;
	}
}
