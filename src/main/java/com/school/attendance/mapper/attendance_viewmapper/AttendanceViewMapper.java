package com.school.attendance.mapper.attendance_viewmapper;

import org.springframework.stereotype.Component;

import com.school.attendance.domine.attendance_view.AttendanceView;
import com.school.attendance.mapper.AbstractModelMapper;
import com.school.attendance.model.attendance_view.AttendanceViewModel;
@Component
public class AttendanceViewMapper extends AbstractModelMapper<AttendanceViewModel, AttendanceView> {

	@Override
	public Class<AttendanceViewModel> entityType() {
		return AttendanceViewModel.class;
	}

	@Override
	public Class<AttendanceView> modelType() {
		return AttendanceView.class;
	}

}

