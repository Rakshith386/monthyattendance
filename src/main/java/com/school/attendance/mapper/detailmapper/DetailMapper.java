package com.school.attendance.mapper.detailmapper;

import org.springframework.stereotype.Component;

import com.school.attendance.domine.detail.Detail;
import com.school.attendance.mapper.AbstractModelMapper;
import com.school.attendance.model.detail.DetailModel;
@Component
public class DetailMapper extends AbstractModelMapper<DetailModel, Detail> {

	@Override
	public Class<DetailModel> entityType() {
		return DetailModel.class;
	}

	@Override
	public Class<Detail> modelType() {
		return Detail.class;
	}

}
