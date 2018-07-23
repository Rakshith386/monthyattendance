package com.school.attendance.mapper.standardmapper;


import java.util.List;

import org.springframework.stereotype.Component;

import com.school.attendance.domine.standard.Standard;
import com.school.attendance.mapper.AbstractModelMapper;
import com.school.attendance.model.standard.StandardModel;

@Component
public class StandardMapper extends AbstractModelMapper<StandardModel, Standard> {

	@Override
	public Class<StandardModel> entityType() {
		return StandardModel.class;
	}

	@Override
	public Class<Standard> modelType() {
		return Standard.class;
	}

	

}
