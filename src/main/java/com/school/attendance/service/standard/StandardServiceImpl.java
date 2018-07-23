package com.school.attendance.service.standard;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.attendance.dao.standard.StandardDao;

import com.school.attendance.domine.standard.Standard;
import com.school.attendance.mapper.standardmapper.StandardMapper;
import com.school.attendance.model.standard.StandardModel;
import com.school.attendance.response.Response;
import com.school.attendance.utils.CommonUtils;
@Service("standardService")
public class StandardServiceImpl implements StandardService{
	@Autowired
	StandardDao standardDao;
     @Autowired
     StandardMapper standardMapper;


	private static final Logger logger = LoggerFactory.getLogger(StandardServiceImpl.class);
	
	@Override
	public Response addStandard(StandardModel standard) throws Exception {
	try {
		Standard std=new Standard();
		std.setStdid(CommonUtils.generateRandomId());
		std.setStandard(standard.getStandard());
		std.setMedium(standard.getMedium());
		std.setSection(standard.getSection());
		std.setSyllabus(standard.getSyllabus());
		std.setStaffId(standard.getStaffId());
		std.setStaffName(standard.getStaffName());
		std.setStaff_subject(standard.getStaff_subject());
	
		Response response = standardDao.addStudent(std);
		return response;
		}
	catch (Exception ex) {
		logger.info("Exception Service:" + ex.getMessage());
	}
		return null;
	}
	@Override
	public Response updateStandard(StandardModel standard) throws Exception {
		try {

			Standard std = standardDao.getStandard(standard.getStdid());
			std.setStandard(standard.getStandard());
			std.setMedium(standard.getMedium());
			std.setSection(standard.getSection());
			std.setSyllabus(standard.getSyllabus());
			std.setStaffId(standard.getStaffId());
			std.setStaffName(standard.getStaffName());
			std.setStaff_subject(standard.getStaff_subject());
			Response response = standardDao.updateStandard(std);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}

	@Override
	public Response deleteStandard(String stdid) throws Exception {
try {
			
			return standardDao.deleteStandard(stdid);
		} catch (Exception e) {
			logger.info("Exception deleteStandard:", e);
			return null;
		}
		}
	@Override
	public StandardModel getStandard(String stdid) {
		try {
			StandardModel standardModel = new StandardModel();
			Standard standard = standardDao.getStandard(stdid);
			BeanUtils.copyProperties(standard, standardModel);
			return standardModel;
		} catch (Exception e) {
			logger.info("Exception getstaff:", e);
			return null;
		}
	}
	@Override
	public List<StandardModel> getStandards() throws Exception {
		try {
			List<Standard> standards = standardDao.getStandards();
			return standardMapper.entityList(standards);
		} catch (Exception ex) {
			logger.info("Exception getStandards:", ex);
		}
		return null;
	}
	
}
