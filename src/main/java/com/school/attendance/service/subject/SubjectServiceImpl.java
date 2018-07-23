package com.school.attendance.service.subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.school.attendance.dao.subject.SubjectDao;
import com.school.attendance.domine.subject.Subject;
import com.school.attendance.mapper.subjectmapper.SubjectMapper;
import com.school.attendance.model.subject.SubjectModel;
import com.school.attendance.response.Response;
import com.school.attendance.service.student.StudentServiceImpl;
import com.school.attendance.utils.CommonUtils;



import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;


@EnableJpaRepositories
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectDao subjectDao;
	@Autowired
	SubjectMapper subjectMapper;
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Override
	public SubjectModel getSubject(String subjectId) throws Exception {
		try {
			SubjectModel subjectModel = new SubjectModel();
			Subject subject = subjectDao.getSubject(subjectId);
			BeanUtils.copyProperties(subject, subjectModel);
			return subjectModel;
		} catch (Exception e) {
			logger.info("Exception getsubject:", e);
			return null;
		}
	}
	@Override
	public Response addSubject(SubjectModel subject) throws Exception {
		try{
			Subject us=new Subject();
			us.setSubjectId(CommonUtils.generateRandomId());
		    us.setStaffId(subject.getStaffId());
		    us.setSubjectName(subject.getSubjectName());
			
		Response response = subjectDao.addSubject(us);
		return response;
		}
	catch (Exception ex) {
		logger.info("Exception Service:" + ex.getMessage());
	}
	return null;
		
	}
	@Override
	public Response updateSubject(SubjectModel subject) throws Exception {
		try{
			Subject us=new Subject();
			us.setSubjectId(CommonUtils.generateRandomId());
		    us.setStaffId(subject.getStaffId());
		    us.setSubjectName(subject.getSubjectName());
			
		Response response = subjectDao.updateSubject(us);
		return response;
		}
	catch (Exception ex) {
		logger.info("Exception Service:" + ex.getMessage());
	}
	return null;
		
	}

	@Override
	public Response deleteSubject(String subjectId) throws Exception {
     try {
			
			return subjectDao.deleteSubject(subjectId);
		} catch (Exception e) {
			logger.info("Exception deleteSubject:", e);
			return null;
		}
	}
}
