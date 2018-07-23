package com.school.attendance.dao.detail;

import java.util.List;

import com.school.attendance.domine.detail.Detail;
import com.school.attendance.model.detail.DetailModel;
import com.school.attendance.response.Response;

public interface DetailDao {

	public Response addDetail(Detail det)throws Exception;

	public Detail getDetail(String detailId)throws Exception;

	public Response deleteDetail(String detailId)throws Exception;

	public Response updateDetail(Detail detail)throws Exception;

	public List<Detail> getDetails()throws Exception;

}
