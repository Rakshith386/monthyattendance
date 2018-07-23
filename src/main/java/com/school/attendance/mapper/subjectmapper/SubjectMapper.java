package com.school.attendance.mapper.subjectmapper;

import org.springframework.stereotype.Component;

import com.school.attendance.domine.subject.Subject;
import com.school.attendance.mapper.AbstractModelMapper;
import com.school.attendance.model.subject.SubjectModel;
@Component
public class SubjectMapper extends AbstractModelMapper<SubjectModel, Subject> {

	@Override
	public Class<SubjectModel> entityType() {
		return SubjectModel.class;
	}

	@Override
	public Class<Subject> modelType() {
		return Subject.class;
	}

	

}