package com.school.attendance.service.standard;

import java.util.List;

import com.school.attendance.model.standard.StandardModel;
import com.school.attendance.response.Response;

public interface StandardService {

	public Response addStandard(StandardModel standard)throws Exception;

	public Response updateStandard(StandardModel standard)throws Exception;



	public Response deleteStandard(String stdId)throws Exception;

	public StandardModel getStandard(String stdId);

	public List<StandardModel> getStandards()throws Exception;
	

}
