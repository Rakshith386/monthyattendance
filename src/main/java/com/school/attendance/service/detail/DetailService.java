package com.school.attendance.service.detail;

import java.util.List;

import com.school.attendance.model.detail.DetailModel;
import com.school.attendance.response.Response;

public interface DetailService {

	public Response addDetail(List<DetailModel> detail)throws Exception;

	public Response updateDetail(DetailModel detail)throws Exception;

	public DetailModel getDetail(String detailId)throws Exception;

	public Response deleteDetail(String detailId)throws Exception;

	public List<DetailModel> getDetails()throws Exception;

}
