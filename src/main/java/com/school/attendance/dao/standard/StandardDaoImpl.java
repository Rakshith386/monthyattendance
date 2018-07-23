package com.school.attendance.dao.standard;

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
import com.school.attendance.domine.standard.Standard;
import com.school.attendance.response.Response;
import com.school.attendance.utils.CommonUtils;

@Transactional
@Repository
public class StandardDaoImpl implements StandardDao{
	private static final Logger logger = LoggerFactory.getLogger(StandardDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public Response addStudent(Standard std) throws Exception {
		Response response = CommonUtils.getResponseObject("Add standard data");
		try {
			entityManager.persist(std);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" standard Added Successfully");
		} catch (Exception e) {
			logger.error("Exception in addstandard", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to add  standard ");
		}
		return response;
	}
	@Override
	public Response deleteStandard(String stdid) throws Exception {
		Response response = CommonUtils.getResponseObject("Delete standard data");
		try {
			Standard standard1 = getStandard(stdid);
			standard1.setIsActive(false);
			
			Standard standard = getStandard(stdid);
			standard.setIsActive(false);
		
			entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" standard deleted Successfully");
		} catch (Exception e) {
			logger.error("Exception in deletestandard", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to Delete  standard ");
		}
		return response;
	}
	
//	@Override
//	public Response updateStandard(StandardModel standard) throws Exception {
//		Response response = CommonUtils.getResponseObject("Update standard data");
//		try {
//			
//			entityManager.persist(standard);
//			response.setStatus(StatusCode.SUCCESS.name());
//			response.setMessage(" standard updated Successfully");
//		} catch (Exception e) {
//			logger.error("Exception in pdateustandard", e);
//			response.setStatus(StatusCode.ERROR.name());
//			response.setErrors(e.getMessage());
//			response.setMessage("Failed to add  standard ");
//		}
//		return response;
//	}
	
	@Override
	public Standard getStandard(String stdid)throws Exception {
		
			try {
				String hql = "FROM Standard where stdid=?";
				return (Standard) entityManager.createQuery(hql).setParameter(1, stdid).getSingleResult();
			} catch (EmptyResultDataAccessException e) {
				return null;
			} catch (Exception e) {
				logger.error("Exception in getStaff", e);
				return null;
			}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Standard> getStandards() throws Exception {
		try {
			String hql = "FROM Standard";
			return (List<Standard>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getStandards", e);
		}
		return null;
	}
	@Override
	public Response updateStandard(Standard std) throws Exception {
		Response response = CommonUtils.getResponseObject("Update standard data");
		try {
			
			entityManager.persist(std);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" standard updated Successfully");
		} catch (Exception e) {
			logger.error("Exception in updateustandard", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to add  standard ");
		}
		return response;
	}
}
