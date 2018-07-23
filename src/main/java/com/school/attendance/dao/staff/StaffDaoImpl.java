package com.school.attendance.dao.staff;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.school.attendance.constant.StatusCode;
import com.school.attendance.domine.staff.Staff;
import com.school.attendance.model.staff.StaffModel;
import com.school.attendance.response.Response;
import com.school.attendance.utils.CommonUtils;


@Transactional
@Repository
public class StaffDaoImpl implements StaffDao{
	private static final Logger logger = LoggerFactory.getLogger(StaffDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Response addStaff(Staff st) throws Exception {
		Response response = CommonUtils.getResponseObject("Add user data");
		try {
			entityManager.persist(st);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" staff Added Successfully");
		} catch (Exception e) {
			logger.error("Exception in addstaff", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to add  staff ");
		}
		return response;
	}
	@Override
	public Staff getStaff(String staffId) throws Exception {
		try {
			String hql = "FROM Staff where StaffId=?";
			return (Staff) entityManager.createQuery(hql).setParameter(1, staffId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getStaff", e);
			return null;
		}
	}
	@Override
	public Response deleteStaff(String staffId) throws Exception {
		Response response = CommonUtils.getResponseObject("Delete Staff data");
		try {
			Staff staff = getStaff(staffId);
			staff.setActive(false);
		
			entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" Staff deleted Successfully");
		} catch (Exception e) {
			logger.error("Exception in deletestaff", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to Delete  staff ");
		}
		return response;
	}
	@Override
	public Response updateStaff(Staff staff) throws Exception {
		Response response = CommonUtils.getResponseObject("Update staff ");
		try {
			
			entityManager.persist(staff);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" User updated Successfully");
		} catch (Exception e) {
			logger.error("Exception in updatestaff", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to add  staff ");
		}
		return response;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> getStaffs() throws Exception {
		try {
			String hql = "FROM Staff";
			return (List<Staff>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getStaffs", e);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> getStaffsub(String subject) throws Exception {
		try {
			String hql = "FROM Staff where Subject=?";
			return (List<Staff>) entityManager.createQuery(hql).setParameter(1, subject).getResultList();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getStaff", e);
			return null;
		}
}
	@Override
	public Staff getStaffByPassword(String staffName, String password) throws Exception {
		try {
			String hql = "FROM Staff where StaffName=?1 and Password=?2";
			return (Staff) entityManager.createQuery(hql).setParameter(1, staffName).setParameter(2, password).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getStaff", e);
			return null;
		}
	}
}
