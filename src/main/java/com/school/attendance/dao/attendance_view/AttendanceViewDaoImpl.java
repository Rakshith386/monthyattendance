package com.school.attendance.dao.attendance_view;

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
import com.school.attendance.domine.attendance_view.AttendanceView;
import com.school.attendance.response.Response;
import com.school.attendance.utils.CommonUtils;

@Transactional
@Repository
public class AttendanceViewDaoImpl implements AttendanceViewDao{
	private static final Logger logger = LoggerFactory.getLogger(AttendanceViewDaoImpl.class);
	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public Response addAttendanceview(AttendanceView att) throws Exception {
		Response response = CommonUtils.getResponseObject("Add addAttendance data");
		try {
			entityManager.persist(att);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" Attendance viewed Successfully");
		} catch (Exception e) {
			logger.error("Exception in view Attendance", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to view Attendance ");
		}
		return response;
	}

	@Override
	public Response updateAttendanceview(AttendanceView att) throws Exception {
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
	@SuppressWarnings("unchecked")
	@Override
	public List<AttendanceView> getAttendanceViewByStandard(String standard, String section, String syllabus,
			String medium, String fromdate, String todate) throws Exception {
		{
			Response response = CommonUtils.getResponseObject("get attendance ByStandard");
			try{
				System.out.println();
				String hql = "FROM AttendanceView where standard=?1 and section=?2 and syllabus=?3 and medium=?4 and fromDate=?5 and toDate=?6 ";
				return (List<AttendanceView>) entityManager.createQuery(hql).setParameter(1, standard).setParameter(2, section).setParameter(3, syllabus).setParameter(4, medium).setParameter(5, fromdate).setParameter(6, todate).getResultList();
			}catch(Exception e){
				response.setStatus(StatusCode.SUCCESS.name());
				logger.info("Exception in getAttendanceByStandard");
				response.setStatus(e.getMessage());
			}
			return null;
		}
		}

	@Override
	public Response deleteAttendanceView(String studentId) throws Exception {
		Response response = CommonUtils.getResponseObject("Delete att data");
		try {
			AttendanceView att = getAttendanceView(studentId);
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

	@Override
	public AttendanceView getAttendanceView(String subjectName) throws Exception {
		try {
			String hql = "FROM AttendanceView where SubjectName=?";
			return (AttendanceView) entityManager.createQuery(hql).setParameter(1, subjectName).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getAttendance", e);
			return null;
		}
	}
}
