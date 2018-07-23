package com.school.attendance.dao.standard;

import java.util.List;

import com.school.attendance.domine.standard.Standard;
import com.school.attendance.response.Response;

public interface StandardDao {

	public Response addStudent(Standard std)throws Exception;

	

	public Response deleteStandard(String stdId)throws Exception;

	
	//public Response updateStandard(StandardModel standard)throws Exception;





	public Standard getStandard(String stdId)throws Exception;



	public List<Standard> getStandards()throws Exception;



	public Response updateStandard(Standard std)throws Exception;

}
