package com.school.attendance.mapper.attendancemapper;

import org.springframework.stereotype.Component;

import com.school.attendance.domine.attendance.Attendance;
import com.school.attendance.mapper.AbstractModelMapper;
import com.school.attendance.model.attendance.AttendanceModel;
@Component
public class AttendanceMapper extends AbstractModelMapper<AttendanceModel, Attendance> {

	@Override
	public Class<AttendanceModel> entityType() {
		return AttendanceModel.class;
	}

	@Override
	public Class<Attendance> modelType() {
		return Attendance.class;
	}

}
