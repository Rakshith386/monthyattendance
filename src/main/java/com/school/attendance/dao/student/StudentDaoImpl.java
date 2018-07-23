package com.school.attendance.dao.student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.school.attendance.constant.StatusCode;

import com.school.attendance.utils.CommonUtils;
import com.school.attendance.domine.student.Student;
import com.school.attendance.response.Response;


@Transactional
@Repository
public class StudentDaoImpl implements StudentDao{
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;
   @Override
	public Response addStudent(Student us) throws Exception {
		Response response = CommonUtils.getResponseObject("Add student data");
		try {
			entityManager.persist(us);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" student Added Successfully");
		} catch (Exception e) {
			logger.error("Exception in addstudent", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to add  student ");
		}
		return response;
	}
   @Override
	public Student getStudent(String studentId) throws Exception {
		try {
			String hql = "FROM Student where StudentId=?";
			return (Student) entityManager.createQuery(hql).setParameter(1, studentId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getStudent", e);
			return null;
		}
	}

   @Override
	public Response deleteStudent(String studentId) throws Exception {
		Response response = CommonUtils.getResponseObject("Delete user data");
		try {
			Student student = getStudent(studentId);
			student.setActive(false);
		
			entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" Student deleted Successfully");
		} catch (Exception e) {
			logger.error("Exception in deleteUser", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to Delete  Student ");
		}
		return response;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents() throws Exception {
		try {
			String hql = "FROM Student";
			return (List<Student>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getStudents", e);
		}
		return null;
	}

	@Override
	public Response updateStudent(Student student2) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Student data");
		try {
			
			entityManager.persist(student2);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" student updated Successfully");
		} catch (Exception e) {
			logger.error("Exception in updatestudent", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to add  user ");
		}
		return response;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentByStandard(String standard, String section, String syllabus, String medium,
			String year) throws Exception {
		Response response = CommonUtils.getResponseObject("get student ByStandard");
		try{
			System.out.println(year);
			String hql = "FROM Student where Standard=?1 and section=?2 and syllabus=?3 and medium=?4 and Year=?5 and isActive=true ";
			return (List<Student>) entityManager.createQuery(hql).setParameter(1, standard).setParameter(2, section).setParameter(3, syllabus).setParameter(4, medium).setParameter(5, year).getResultList();
		}catch(Exception e){
			response.setStatus(StatusCode.SUCCESS.name());
			logger.info("Exception in getStudentByStandard");
			response.setStatus(e.getMessage());
		}
		return null;
	}

}
