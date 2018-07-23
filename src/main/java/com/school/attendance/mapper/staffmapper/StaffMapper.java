package com.school.attendance.mapper.staffmapper;

import org.springframework.stereotype.Component;

import com.school.attendance.domine.staff.Staff;
import com.school.attendance.mapper.AbstractModelMapper;
import com.school.attendance.model.staff.StaffModel;


@Component
public class StaffMapper extends AbstractModelMapper<StaffModel, Staff> {

	@Override
	public Class<StaffModel> entityType() {
		return StaffModel.class;
	}

	@Override
	public Class<Staff> modelType() {
		return Staff.class;
	}

	
	

}

