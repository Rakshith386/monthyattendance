package com.school.attendance.service.staff;

import java.util.List;

import com.school.attendance.model.staff.StaffModel;
import com.school.attendance.response.Response;

public interface StaffService {

   public	Response addStaff(StaffModel staff) throws Exception;

public StaffModel getStaff(String staffId)throws Exception;

public Response deleteStaff(String staffId)throws Exception;



public Response updateStaff(StaffModel staff)throws Exception;

public List<StaffModel> getStaffs()throws Exception;

public List<StaffModel> getStaffsub(String subject)throws Exception;

public StaffModel getStaffByPassword(String staffName, String password)throws Exception;

}
