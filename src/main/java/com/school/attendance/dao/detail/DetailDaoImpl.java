package com.school.attendance.dao.detail;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.school.attendance.constant.StatusCode;
import com.school.attendance.domine.detail.Detail;
import com.school.attendance.model.detail.DetailModel;
import com.school.attendance.response.Response;
import com.school.attendance.utils.CommonUtils;

@Transactional
@Repository
public class DetailDaoImpl implements DetailDao{
	private static final Logger logger = LoggerFactory.getLogger(DetailDaoImpl.class);
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Response addDetail(Detail det) throws Exception {
		Response response = CommonUtils.getResponseObject("Add detail data");
		try {
			entityManager.persist(det);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" deatil Added Successfully");
		} catch (Exception e) {
			logger.error("Exception in adddetail", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to adddetail ");
		}
		return response;
	}
	@Override
	public Detail getDetail(String detailId) throws Exception {
		try {
			String hql = "FROM Detail where DetailID=?";
			return (Detail) entityManager.createQuery(hql).setParameter(1, detailId).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			logger.error("Exception in getDetail", e);
			return null;
		}
	}
	@Override
	public Response deleteDetail(String detailId) throws Exception {
		Response response = CommonUtils.getResponseObject("Delete detail data");
		try {
			Detail detail = getDetail(detailId);
			detail.setActive(false);
		
			entityManager.flush();
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" detail deleted Successfully");
		} catch (Exception e) {
			logger.error("Exception in deletedetail", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to Delete  detail ");
		}
		return response;
	}
	@Override
	public Response updateDetail(Detail detail) throws Exception {
		Response response = CommonUtils.getResponseObject("Update detail");
		try {
			
			entityManager.persist(detail);
			response.setStatus(StatusCode.SUCCESS.name());
			response.setMessage(" detail updated Successfully");
		} catch (Exception e) {
			logger.error("Exception in updatedetail", e);
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(e.getMessage());
			response.setMessage("Failed to add  detail ");
		}
		return response;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Detail> getDetails() throws Exception {
		try {
			String hql = "FROM Detail";
			return (List<Detail>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getDetails", e);
		}
		return null;
	}

}
