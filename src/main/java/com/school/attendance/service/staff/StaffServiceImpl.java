package com.school.attendance.service.staff;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.school.attendance.dao.staff.StaffDao;
import com.school.attendance.domine.staff.Staff;
import com.school.attendance.mapper.staffmapper.StaffMapper;
import com.school.attendance.model.staff.StaffModel;
import com.school.attendance.response.Response;
import com.school.attendance.utils.CommonUtils;


@Service("staffService")
public class StaffServiceImpl implements StaffService {
	@Autowired
	StaffDao staffDao;
	@Autowired
	StaffMapper staffMapper;

	private static final Logger logger = LoggerFactory.getLogger(StaffServiceImpl.class);
	
	@Override
	public Response addStaff(StaffModel staff) throws Exception {
		try {
			Staff st=new Staff();
			st.setStaffId(CommonUtils.generateRandomId());
			st.setStaffName(staff.getStaffName());
			st.setSubject(staff.getSubject());
			st.setPhoneNumber(staff.getPhoneNumber());
			st.setPassword(staff.getPassword());
			st.setStdid(staff.getStaffId());
			st.setSubjectId(CommonUtils.generateRandomId());
			st.setActive(staff.getIsActive());
			Response response = staffDao.addStaff(st);
			return response;
			}
		catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
			
		}

	
	@Override
	public StaffModel getStaff(String staffId) throws Exception {
		try {
			StaffModel staffModel = new StaffModel();
			Staff staff = staffDao.getStaff(staffId);
			BeanUtils.copyProperties(staff, staffModel);
			return staffModel;
		} catch (Exception e) {
			logger.info("Exception getstaff:", e);
			return null;
		}
	}
	
	@Override
	public Response deleteStaff(String staffId) throws Exception {
try {
			
			return staffDao.deleteStaff(staffId);
		} catch (Exception e) {
			logger.info("Exception deleteUser:", e);
			return null;
		}
	}
	
	@Override
	public Response updateStaff(StaffModel staff) throws Exception {
		try {

			Staff st = staffDao.getStaff(staff.getStaffId());
			st.setStaffName(staff.getStaffName());
			st.setSubject(staff.getSubject());
			st.setPhoneNumber(staff.getPhoneNumber());
			st.setPassword(staff.getPassword());
			st.setStdid(staff.getStaffId());
			st.setSubjectId(staff.getSubjectId());
			st.setActive(staff.getIsActive());
			Response response = staffDao.updateStaff(st);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}


	@Override
	public List<StaffModel> getStaffs() throws Exception {
		try {
			List<Staff> staffs = staffDao.getStaffs();
			return staffMapper.entityList(staffs);
		} catch (Exception ex) {
			logger.info("Exception getStaffs:", ex);
		}
		return null;
	}


	@Override
	public List<StaffModel> getStaffsub(String subject) throws Exception {
		try {
			List<Staff> staff =  staffDao.getStaffsub(subject);
			
			return staffMapper.entityList(staff);
		} catch (Exception e) {
			logger.info("Exception getstaff:", e);
			return null;
		}
	}


	@Override
	public StaffModel getStaffByPassword(String staffName, String password) throws Exception {
		try {
			StaffModel staffModel = new StaffModel();
			Staff staff = staffDao.getStaffByPassword(staffName,password);
			BeanUtils.copyProperties(staff, staffModel);
			return staffModel;
		} catch (Exception e) {
			logger.info("Exception getstaff:", e);
			return null;
		}
	}
}
