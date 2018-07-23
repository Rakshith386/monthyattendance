package com.school.attendance.service.detail;

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

import com.school.attendance.utils.DateUtility;
import com.school.attendance.dao.detail.DetailDao;
import com.school.attendance.domine.detail.Detail;
import com.school.attendance.mapper.detailmapper.DetailMapper;
import com.school.attendance.model.detail.DetailModel;
import com.school.attendance.response.Response;
import com.school.attendance.utils.CommonUtils;
@EnableJpaRepositories
@Service("detailService")
public class DetailServiceImpl implements DetailService{
	
	
	@Autowired
	DetailDao detailDao;
	@Autowired
	DetailMapper detailMapper;

	private static final Logger logger = LoggerFactory.getLogger(DetailServiceImpl.class);
	
	@Override
	public Response addDetail(List<DetailModel> detail) throws Exception {
		try {
			
			//List<Detail> detaile= new ArrayList<Detail>();
			
			for(DetailModel det: detail)
			{
				Detail detai=new Detail();
			BeanUtils.copyProperties(det, detai);
		    detai.setStudentName(det.getStudentName());
			detai.setStudentId(det.getStudentId());
			detai.setStaffId(det.getStaffId());
			detai.setStudentName(det.getStudentName());
			detai.setStaffName(det.getStaffName());
			detai.setSection(det.getSection());
			detai.setMedium(det.getMedium());
			detai.setStandard(det.getStandard());
			detai.setSyllabus(det.getSyllabus());
			detai.setSubjectName(det.getSubjectName());
			detai.setDetailID(CommonUtils.generateRandomId());
			detai.setExam_Type(det.getExam_Type());
			detai.setMarks(det.getMarks());
			detai.setSubjectId(det.getSubjectId());
		     
			detai.setDate(DateUtility.getDateByStringFormat(new Date(), DateUtility.DATE_FORMAT_DD_MMM_YYYY));
			
			
			detai.setYear(det.getYear());
			
			detai.setTotal_marks(det.getTotal_marks());
			
			
//			// Construct data
//			String apiKey = "apikey=" + "kMzgPyj7cYU-7U5dE76LsSSeL1qede5xijuU4EZLPz";
//			String message = "&message=" +"Hi Sir/Madem,\nProgress report of your son/daughter:"+ "\nName:"+det.getStudentName()+"\nExam_Type:"+det.getExam_Type()+"\nSubject1: "+det.getMarks_subject1()+"\nSubject2:"+det.getMarks_subject2()+"\nSubject3:"+det.getMarks_subject3()+"\nSubject4:"+det.getMarks_subject4()+"\nSubject5:"+det.getMarks_subject5()+"\nSubject6:"+det.getMarks_subject6()+"\nTotal_Marks:"+detai.getTotal_marks()+"\nTotal_Days:"+det.getNo_days()+"\nPresent_Days:"+det.getPresent_days()+"\nAttendance_percentage:"+detai.getPresentpercent();
//			
//			String sender = "&sender=" + "TXTLCL";
//			String numbers = "&numbers=" +det.getMobilenumber() ;
//			
//			// Send data
//			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
//			String data = apiKey + numbers + message + sender;
//			conn.setDoOutput(true);
//			conn.setRequestMethod("POST");
//			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
//			conn.getOutputStream().write(data.getBytes("UTF-8"));
//			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			final StringBuffer stringBuffer = new StringBuffer();
//			String line;
//			while ((line = rd.readLine()) != null) {
//				stringBuffer.append(line);
//			}
//			rd.close();
			
			Response response = detailDao.addDetail(detai);
			return response;
			
			}
				
		}
			
			
			
		catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
			
		}
		
	@Override
	public Response updateDetail(DetailModel detail) throws Exception {
		try {

			Detail det = detailDao.getDetail(detail.getDetailID());
		    det.setStudentName(detail.getStudentName());
			det.setStudentId(detail.getStudentId());
			det.setStaffId(detail.getStaffId());
			det.setExam_Type(detail.getExam_Type());
			det.setSection(detail.getSection());
			det.setMedium(detail.getMedium());
			det.setStandard(detail.getStandard());
			det.setSyllabus(detail.getSyllabus());
			det.setMarks(detail.getMarks());
			det.setSubjectId(detail.getSubjectId());
		    det.setStaffName(detail.getStaffName());
		    det.setSubjectName(detail.getSubjectName());
			det.setDate(DateUtility.getDateByStringFormat(new Date(), DateUtility.DATE_FORMAT_DD_MMM_YYYY));
		
			
			det.setYear(detail.getYear());
			
			det.setTotal_marks(detail.getTotal_marks());
			Response response = detailDao.updateDetail(det);
			return response;
		} catch (Exception ex) {
			logger.info("Exception Service:" + ex.getMessage());
		}
		return null;
	}
			
	@Override
	public DetailModel getDetail(String detailId) throws Exception {
		try {
			DetailModel detailModel = new DetailModel();
			Detail det = detailDao.getDetail(detailId);
			BeanUtils.copyProperties(det, detailModel);
			return detailModel;
		} catch (Exception e) {
			logger.info("Exception getDetail:", e);
			return null;
		}
	}
	@Override
	public Response deleteDetail(String detailId) throws Exception {
    try {
			
			return detailDao.deleteDetail(detailId);
		} catch (Exception e) {
			logger.info("Exception deleteDetail:", e);
			return null;
		}
	}
	@Override
	public List<DetailModel> getDetails() throws Exception {
		try {
			List<Detail> details = detailDao.getDetails();
			
			
			return detailMapper.entityList(details);
		} catch (Exception ex) {
			logger.info("Exception getDetails:", ex);
		}
		return null;
	}

}
