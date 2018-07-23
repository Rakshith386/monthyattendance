package com.school.attendance.mapper.studentmapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.school.attendance.domine.student.Student;
import com.school.attendance.mapper.AbstractModelMapper;
import com.school.attendance.model.student.StudentModel;


	@Component
	public class StudentMapper extends AbstractModelMapper<StudentModel, Student> {

		@Override
		public Class<StudentModel> entityType() {
			return StudentModel.class;
		}

		@Override
		public Class<Student> modelType() {
			return Student.class;
		}

		

	}



