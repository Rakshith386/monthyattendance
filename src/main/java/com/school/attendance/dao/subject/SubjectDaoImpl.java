package com.school.attendance.dao.subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.school.attendance.constant.StatusCode;
import com.school.attendance.dao.student.StudentDaoImpl;
import com.school.attendance.domine.student.Student;
import com.school.attendance.domine.subject.Subject;
import com.school.attendance.response.Response;
import com.school.attendance.utils.CommonUtils;

@Transactional
@Repository
public class SubjectDaoImpl implements SubjectDao{
	private static final Logger logger = LoggerFactory.getLogger(SubjectDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public Response addSubject(Subject us) throws Exception {
		Response response = CommonUtils.getResponseObject("Add subject data");
		try {
			entityManager.persist(us);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" student Added Successfully");
		} catch (Exception e) {
			logger.error("Exception in addsubject", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to add  subject ");
		}
		return response;
	}

	@Override
	public Subject getSubject(String subjectId) throws Exception {
		try {
			String hql = "FROM Subject where SubjectId=?";
			return (Subject) entityManager.createQuery(hql).setParameter(1, subjectId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getSubject", e);
			return null;
		}
	}

	@Override
	public Response deleteSubject(String subjectId) throws Exception {
		Response response = CommonUtils.getResponseObject("Delete Subject data");
		try {
			Subject subject = getSubject(subjectId);
			subject.setActive(false);
		
			entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" Subject deleted Successfully");
		} catch (Exception e) {
			logger.error("Exception in deleteSubject", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to Delete  deleteSubject ");
		}
		return response;
	}

	@Override
	public Response updateSubject(Subject us) throws Exception {
		Response response = CommonUtils.getResponseObject("Update subject data");
		try {
			
			entityManager.persist(us);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" subject updated Successfully");
		} catch (Exception e) {
			logger.error("Exception in updatestudent", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to add  subject ");
		}
		return response;
	}

}
