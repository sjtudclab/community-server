/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service.impl;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.TenementServeForm;
import cn.edu.sjtu.se.dclab.server.mapper.TenementServeFormMapper;
import cn.edu.sjtu.se.dclab.server.service.TenementServeFormService;



@Service
public class TenementServeFormServiceImpl implements TenementServeFormService{
	@Autowired
	private TenementServeFormMapper mapper;
	


	public TenementServeFormMapper getMapper() {
		return mapper;
	}



	public void setMapper(TenementServeFormMapper mapper) {
		this.mapper = mapper;
	}



	@Override
	public void createServeForm(TenementServeForm tmp){
		mapper.createServeForm(tmp);
		return;
	}
	
	@Override
	public void updateUserComment(String order_id, int score, String comment){
		TenementServeForm tmp = new TenementServeForm();
		tmp.setOrder_id(order_id);
		tmp.setUser_score(score);
		tmp.setComment(comment);
		mapper.updateUserComment(tmp);
		return;
	}
	
	@Override
	public void updateServingRecord(String order_id, String record) {
		TenementServeForm tmp = new TenementServeForm();
		tmp.setOrder_id(order_id);
		tmp.setServe_record(record);
		mapper.updateServingRecord(tmp);
		return;
	}
	
	@Override
	public JSONObject getUserCommentByOrderId(String order_id) {
		JSONObject json = new JSONObject();
		TenementServeForm tmp = mapper.getUserCommentByOrderId(order_id);
		
		try {
			json.put("serve_id", tmp.getServe_id());
			json.put("user_score", tmp.getUser_score());
			json.put("user_comment", tmp.getComment());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}


}
