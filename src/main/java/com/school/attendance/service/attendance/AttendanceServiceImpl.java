package com.school.attendance.service.attendance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.school.attendance.dao.attendance.AttendanceDao;
import com.school.attendance.domine.attendance.Attendance;
import com.school.attendance.domine.student.Student;
import com.school.attendance.mapper.attendancemapper.AttendanceMapper;
import com.school.attendance.model.attendance.AttendanceModel;
import com.school.attendance.response.Response;
import com.school.attendance.utils.CommonUtils;
import com.school.attendance.utils.DateUtility;

@EnableJpaRepositories
@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService{
	@Autowired
	AttendanceDao attendanceDao;
	@Autowired
	AttendanceMapper attendanceMapper;

	private static final Logger logger = LoggerFactory.getLogger(AttendanceServiceImpl.class);
	
	@Override
	public Response addAttendance(List<AttendanceModel> attendance) throws Exception {
try {

	                 for(AttendanceModel a: attendance)
			
			{
				Attendance att=new Attendance();
				BeanUtils.copyProperties(attendance, att);
			    att.setAttendanceId(CommonUtils.generateRandomId());
		        att.setStaffId(a.getStaffId());
		        att.setDate(DateUtility.getDateByStringFormat(new Date(), DateUtility.DATE_FORMAT_DD_MMM_YYYY));
		        att.setStatus(a.getStatus());
		        att.setStaffName(a.getStaffName());
		        att.setSubjectName(a.getSubjectName());
		        att.setSection(a.getSection());
		        att.setSyllabus(a.getSyllabus());
		        att.setStandard(a.getStandard());
		        att.setMedium(a.getMedium());
		        att.setNo_days(a.getNo_days());
		        att.setPresent_days(a.getPresent_days());
		        att.setPercent((a.getPresent_days()*100)/ a.getNo_days());
		        att.setStudentId(a.getStudentId());
		        att.setStdid(a.getStdid());
		        att.setStudentName(a.getStudentName());
		        att.setPhone_num(a.getPhone_num());
		        att.setSubjectId(a.getSubjectId());
		        
//   	       String apiKey = "apikey=" + "kMzgPyj7cYU-7U5dE76LsSSeL1qede5xijuU4EZLPz";
//			String message = "&message=" +"Hi Sir/Madem,\nProgress report of your son/daughter:"+ "\nName:"+a.getStudentName()+"\nSubject1:"+a.getSubjectName()+a.getNo_days()+a.getPresent_days()+a.getPercent();
//				
//			String sender = "&sender=" + "TXTLCL";
//				String numbers = "&numbers=" +a.getPhone_num() ;
////				
////				// Send data
//				HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
//  			String data = apiKey + numbers + message + sender;
//				conn.setDoOutput(true);
//				conn.setRequestMethod("POST");
//				conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
//				conn.getOutputStream().write(data.getBytes("UTF-8"));
//				final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				final StringBuffer stringBuffer = new StringBuffer();
//				String line;
//				while ((line = rd.readLine()) != null) {
//					stringBuffer.append(line);
//				}
//				rd.close();
				
		        Response response = attendanceDao.addAttendance(att);
				return response;
				
				}
					
			}
			catch (Exception ex) {
				logger.info("Exception Service:" + ex.getMessage());
			}
			return null;
				
			}

	@Override
	public Response updateAttendance(AttendanceModel a) throws Exception {
		try {

          
	
	{
		Attendance att=new Attendance();
		BeanUtils.copyProperties(a, att);
	    att.setAttendanceId(CommonUtils.generateRandomId());
       att.setStaffId(a.getStaffId());
       att.setDate(DateUtility.getDateByStringFormat(new Date(), DateUtility.DATE_FORMAT_DD_MMM_YYYY));
       att.setStatus(a.getStatus());
       att.setStdid(a.getStdid());
       att.setStaffName(a.getStaffName());
       att.setSection(a.getSection());
       att.setSyllabus(a.getSyllabus());
       att.setStandard(a.getStandard());
       att.setMedium(a.getMedium());
       att.setSubjectName(a.getSubjectName());
       att.setStudentId(a.getStudentId());
       att.setStudentName(a.getStudentName());
       att.setPhone_num(a.getPhone_num());
       att.setSubjectId(a.getSubjectId());
       att.setNo_days(a.getNo_days());
       att.setPresent_days(a.getPresent_days());
       att.setPercent((a.getPresent_days()*100)/ a.getNo_days());

       Response response = attendanceDao.updateAttendance(att);
		return response;
		
		}
			
	}
	catch (Exception ex) {
		logger.info("Exception Service:" + ex.getMessage());
	}
	return null;
		
	}

	@Override
	public AttendanceModel getAttendance(String studentId) throws Exception {
		try {
			AttendanceModel attendanceModel = new AttendanceModel();
			Attendance att = attendanceDao.getAttendance(studentId);
			BeanUtils.copyProperties(att, attendanceModel);
			return attendanceModel;
		} catch (Exception e) {
			logger.info("Exception getAttendance:", e);
			return null;
		}
	}

	@Override
	public Response deleteAttendance(String studentId) throws Exception {
try {
			
			return attendanceDao.deleteAttendance(studentId);
		} catch (Exception e) {
			logger.info("Exception deleteAttendance:", e);
			return null;
		}
	}

	@Override
	public List<AttendanceModel> getAttendanceByStandard(String standard, String section, String syllabus,
			String medium ) throws Exception {
		try {
			List<Attendance> atendance = attendanceDao.getAttendanceByStandard(standard ,section ,syllabus ,medium );
			return attendanceMapper.entityList(atendance);
		} catch (Exception ex) {
			logger.info("Exception geteAttendancByStandard:", ex);
		}
		return null;
	}

	@Override
	public List<AttendanceModel> getattendancebysubject(String standard, String section, String syllabus, String medium,
			String SubjectName,String SubjectName1) throws Exception {
		try {
			List<Attendance> atendance = attendanceDao.getattendancebysubject(standard ,section ,syllabus ,medium ,SubjectName ,SubjectName1 );
			return attendanceMapper.entityList(atendance);
		} catch (Exception ex) {
			logger.info("Exception attendancebysubject:", ex);
		}
		return null;
	}

}
