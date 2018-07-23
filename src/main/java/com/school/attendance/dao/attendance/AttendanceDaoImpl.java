package com.school.attendance.dao.attendance;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.school.attendance.constant.StatusCode;
import com.school.attendance.domine.attendance.Attendance;
import com.school.attendance.domine.detail.Detail;
import com.school.attendance.domine.student.Student;
import com.school.attendance.response.Response;
import com.school.attendance.utils.CommonUtils;


@Transactional
@Repository
public class AttendanceDaoImpl implements AttendanceDao{
	private static final Logger logger = LoggerFactory.getLogger(AttendanceDaoImpl.class);
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Response addAttendance(Attendance att) throws Exception {
		Response response = CommonUtils.getResponseObject("Add addAttendance data");
		try {
			entityManager.persist(att);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" Attendance Added Successfully");
		} catch (Exception e) {
			logger.error("Exception in add Attendance", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to add Attendance ");
		}
		return response;
	}

	@Override
	public Response updateAttendance(Attendance att) throws Exception {
		Response response = CommonUtils.getResponseObject("Update Attendance");
		try {
			
			entityManager.persist(att);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" att updated Successfully");
		} catch (Exception e) {
			logger.error("Exception in updateatt", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to add  att ");
		}
		return response;
	}

	@Override
	public Attendance getAttendance(String studentId) throws Exception {
		try {
			String hql = "FROM Attendance where StudentId=?";
			return (Attendance) entityManager.createQuery(hql).setParameter(1, studentId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getAttendance", e);
			return null;
		}
	}
	@Override
	public Response deleteAttendance(String studentId) throws Exception {
		Response response = CommonUtils.getResponseObject("Delete att data");
		try {
			Attendance att = getAttendance(studentId);
			att.setActive(false);
		
			entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" deleteAttendance deleted Successfully");
		} catch (Exception e) {
			logger.error("Exception in deleteAttendance", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to deleteAttendance   ");
		}
		return response;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Attendance> getAttendanceByStandard(String standard, String section, String syllabus, String medium ) throws Exception
	{
		Response response = CommonUtils.getResponseObject("get attendance ByStandard");
		try{
			System.out.println();
			String hql = "FROM Attendance where standard=?1 and section=?2 and syllabus=?3 and medium=?4 ";
			return (List<Attendance>) entityManager.createQuery(hql).setParameter(1, standard).setParameter(2, section).setParameter(3, syllabus).setParameter(4, medium).getResultList();
		}catch(Exception e){
			response.setStatus(StatusCode.SUCCESS.name());
			logger.info("Exception in getAttendanceByStandard");
			response.setStatus(e.getMessage());
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Attendance> getattendancebysubject(String standard, String section, String syllabus, String medium,
			String SubjectName,String SubjectName1) throws Exception {
		Response response = CommonUtils.getResponseObject("get attendance ByStandard");
		try{
			System.out.println();
			String hql = "FROM Attendance where standard=?1 and section=?2 and syllabus=?3 and medium=?4 and SubjectName=?5 and SubjectName=?6";
			return (List<Attendance>) entityManager.createQuery(hql).setParameter(1, standard).setParameter(2, section).setParameter(3, syllabus).setParameter(4, medium).setParameter(5, SubjectName).setParameter(6, SubjectName).getResultList();
		}catch(Exception e){
			response.setStatus(StatusCode.SUCCESS.name());
			logger.info("Exception in getAttendanceByStandard");
			response.setStatus(e.getMessage());
		}
		return null;
	}
}
