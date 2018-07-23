package com.school.attendance.service.attendance_view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.school.attendance.dao.attendance_view.AttendanceViewDao;
import com.school.attendance.domine.attendance.Attendance;
import com.school.attendance.domine.attendance_view.AttendanceView;
import com.school.attendance.mapper.attendance_viewmapper.AttendanceViewMapper;
import com.school.attendance.model.attendance.AttendanceModel;
import com.school.attendance.model.attendance_view.AttendanceViewModel;
import com.school.attendance.response.Response;
import com.school.attendance.service.attendance.AttendanceServiceImpl;
import com.school.attendance.utils.CommonUtils;
import com.school.attendance.utils.DateUtility;

@EnableJpaRepositories
@Service("attendanceViewService")
public class AttendanceViewServiceImpl implements AttendanceViewService{
	
		@Autowired
		AttendanceViewDao attendanceviewDao;
		@Autowired
		AttendanceViewMapper attendanceviewMapper;
		private String fromDate;
		private String toDate;
		
		private static final Logger logger = LoggerFactory.getLogger(AttendanceViewServiceImpl.class);
		
	@Override
	public Response addAttendanceview(List<AttendanceViewModel> attendanceview) throws Exception {
		try {

            for(AttendanceViewModel a: attendanceview)
	
	{
		AttendanceView att=new AttendanceView();
		BeanUtils.copyProperties(attendanceview, att);
		att.setAvid(CommonUtils.generateRandomId());
		att.setMedium(a.getMedium());
		att.setSection(a.getSection());
		att.setSyllabus(a.getSyllabus());
		att.setStaffName(a.getStaffName());
		att.setStudentId(a.getStudentId());
		att.setMobileNumber(a.getMobileNumber());
		att.setStandard(a.getStandard());
		att.setFromDate(DateUtility.getDateByString(fromDate, DateUtility.DATE_FORMAT_DDMMYYYY));
		att.setToDate( DateUtility.getDateByString(toDate, DateUtility.DATE_FORMAT_DDMMYYYY));
		att.setStudentName(a.getStudentName());
		att.setSub1(a.getSub1());
		att.setSub2(a.getSub2());
		att.setSub3(a.getSub3());
		att.setSub4(a.getSub4());
		att.setSub5(a.getSub5());
		att.setSub6(a.getSub6());
		att.setSub7(a.getSub7());
		att.setSub8(a.getSub8());
		att.setSub1_days(a.getSub1_days());
		att.setSub2_days(a.getSub2_days());
		att.setSub3_days(a.getSub3_days());
		att.setSub4_days(a.getSub4_days());
		att.setSub5_days(a.getSub5_days());
		att.setSub6_days(a.getSub6_days());
		att.setSub7_days(a.getSub7_days());
		att.setSub8_days(a.getSub8_days());
		att.setSub1_pdays(a.getSub1_pdays());
		att.setSub2_pdays(a.getSub2_pdays());
		att.setSub3_pdays(a.getSub3_pdays());
		att.setSub4_pdays(a.getSub4_pdays());
		att.setSub5_pdays(a.getSub5_pdays());
		att.setSub6_pdays(a.getSub6_pdays());
		att.setSub7_pdays(a.getSub7_pdays());
		att.setSub8_pdays(a.getSub8_pdays());
		att.setSub1_percent(a.getSub1_percent());
		att.setSub2_percent(a.getSub2_percent());
		att.setSub3_percent(a.getSub3_percent());
		att.setSub4_percent(a.getSub4_percent());
		att.setSub5_percent(a.getSub5_percent());
		att.setSub6_percent(a.getSub6_percent());
		att.setSub7_percent(a.getSub7_percent());
		att.setSub8_percent(a.getSub8_percent());
		
	      String apiKey = "apikey=" + "kMzgPyj7cYU-7U5dE76LsSSeL1qede5xijuU4EZLPz";
				String message = "&message=" +"Hi Sir/Madem,\nProgress report of your son/daughter:"+
	            "\nFrom:"+a.getFromDate()+"   "+"TO:"+a.getToDate()
				+"\nName:"+a.getStudentName()
				+"\n"+a.getSub1()+": " +"Num_Days: "  +a.getSub1_days() +"  "+"present_days: "   +a.getSub1_pdays()+"  "+"Percent%:"+a.getSub1_percent()
				+"\n"+a.getSub2()+": " +"Num_Days: "  +a.getSub2_days() +"  "+"present_days: "   +a.getSub2_pdays()+"  "+"Percent%:"+a.getSub2_percent()
				+"\n"+a.getSub3()+": " +"Num_Days: "  +a.getSub3_days() +"  "+"present_days: "   +a.getSub3_pdays()+"  "+"Percent%:"+a.getSub3_percent()
				+"\n"+a.getSub4()+": " +"Num_Days: "  +a.getSub4_days() +"  "+"present_days: "   +a.getSub4_pdays()+"  "+"Percent%:"+a.getSub4_percent()
				+"\n"+a.getSub5()+": " +"Num_Days: "  +a.getSub5_days() +"  "+"present_days: "   +a.getSub5_pdays()+"  "+"Percent%:"+a.getSub5_percent()
				+"\nThank You";
					
				String sender = "&sender=" + "TXTLCL";
					String numbers = "&numbers=" +a.getMobileNumber() ;
					
////					// Send data
					HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
	  			String data = apiKey + numbers + message + sender;
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
					conn.getOutputStream().write(data.getBytes("UTF-8"));
					final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					final StringBuffer stringBuffer = new StringBuffer();
					String line;
					while ((line = rd.readLine()) != null) {
					stringBuffer.append(line);
					}
					rd.close();
	      
	      
		  Response response = attendanceviewDao.addAttendanceview(att);
			return response;
			
			}
				
		}
		catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
			
		}
		
		
		
		
		
	

	@Override
	public Response updateAttendanceview(AttendanceViewModel a) throws Exception {
		try {

         
	
	{
		AttendanceView att=new AttendanceView();
		BeanUtils.copyProperties(a, att);
		att.setAvid(CommonUtils.generateRandomId());
		att.setMedium(a.getMedium());
		att.setSection(a.getSection());
		att.setSyllabus(a.getSyllabus());
		att.setStaffName(a.getStaffName());
		att.setStudentId(a.getStudentId());
		att.setMobileNumber(a.getMobileNumber());
		att.setStandard(a.getStandard());
		att.setFromDate(DateUtility.getDateByString(fromDate, DateUtility.DATE_FORMAT_DDMMYYYY));
		att.setToDate( DateUtility.getDateByString(toDate, DateUtility.DATE_FORMAT_DDMMYYYY));
		att.setStudentName(a.getStudentName());
		att.setSub1(a.getSub1());
		att.setSub2(a.getSub2());
		att.setSub3(a.getSub3());
		att.setSub4(a.getSub4());
		att.setSub5(a.getSub5());
		att.setSub6(a.getSub6());
		att.setSub7(a.getSub7());
		att.setSub8(a.getSub8());
		att.setSub1_days(a.getSub1_days());
		att.setSub2_days(a.getSub2_days());
		att.setSub3_days(a.getSub3_days());
		att.setSub4_days(a.getSub4_days());
		att.setSub5_days(a.getSub5_days());
		att.setSub6_days(a.getSub6_days());
		att.setSub7_days(a.getSub7_days());
		att.setSub8_days(a.getSub8_days());
		att.setSub1_pdays(a.getSub1_pdays());
		att.setSub2_pdays(a.getSub2_pdays());
		att.setSub3_pdays(a.getSub3_pdays());
		att.setSub4_pdays(a.getSub4_pdays());
		att.setSub5_pdays(a.getSub5_pdays());
		att.setSub6_pdays(a.getSub6_pdays());
		att.setSub7_pdays(a.getSub7_pdays());
		att.setSub8_pdays(a.getSub8_pdays());
		att.setSub1_percent(a.getSub1_percent());
		att.setSub2_percent(a.getSub2_percent());
		att.setSub3_percent(a.getSub3_percent());
		att.setSub4_percent(a.getSub4_percent());
		att.setSub5_percent(a.getSub5_percent());
		att.setSub6_percent(a.getSub6_percent());
		att.setSub7_percent(a.getSub7_percent());
		att.setSub8_percent(a.getSub8_percent());
		  Response response = attendanceviewDao.updateAttendanceview(att);
			return response;
			
			}
				
		}
		catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
			
		}
	@Override
	public List<AttendanceViewModel> getAttendanceViewByStandard(String standard, String section, String syllabus,
			String medium, String fromdate, String todate) throws Exception {
		try {
			List<AttendanceView> attendanceview = attendanceviewDao.getAttendanceViewByStandard(standard ,section ,syllabus ,medium ,fromdate ,todate);
			return attendanceviewMapper.entityList(attendanceview);
		} catch (Exception ex) {
			logger.info("Exception getAttendanceViewByStandard:", ex);
		}
		return null;
	}
	@Override
	public Response deleteAttendanceView(String studentId) throws Exception {
try {
			
			return attendanceviewDao.deleteAttendanceView(studentId);
		} catch (Exception e) {
			logger.info("Exception deleteAttendance:", e);
			return null;
		}
	}

	@Override
	public AttendanceViewModel getAttendanceView(String subjectName) throws Exception {
		try {
			AttendanceViewModel attendanceViewModel = new AttendanceViewModel();
			AttendanceView att = attendanceviewDao.getAttendanceView(subjectName);
			BeanUtils.copyProperties(att, attendanceViewModel);
			return attendanceViewModel;
		} catch (Exception e) {
			logger.info("Exception getAttendance:", e);
			return null;
		}
	}

}
