/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service.impl;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.TenementServiceApplication;
import cn.edu.sjtu.se.dclab.server.mapper.TenementApplicationMapper;
import cn.edu.sjtu.se.dclab.server.service.TenementApplicationService;




@Service
public class TenementApplicationServiceImpl implements TenementApplicationService{
	@Autowired
	private TenementApplicationMapper mapper;

	public TenementApplicationMapper getMapper() {
		return mapper;
	}

	public void setMapper(TenementApplicationMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public void createTenementApplication(TenementServiceApplication tmp) {
		mapper.createServiceApplication(tmp);
		return;
	}
	
	@Override
	public JSONObject getApplicationById(Integer serve_id) {
		JSONObject json = new JSONObject();
		TenementServiceApplication tmp = mapper.getApplicationById(serve_id);
		
		try {
			json.put("serve_id", tmp.getServe_id());
			
			json.put("real_name", tmp.getReal_name());
			json.put("certification", tmp.getCertification());
			json.put("serve_time", tmp.getServe_time());
			json.put("contact_address", tmp.getContact_address());
			json.put("contact_phone", tmp.getContact_phone());
			json.put("description", tmp.getDescription());
			json.put("stage", tmp.getStage());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
		
	}
	
	@Override
	public JSONArray getAllApplicationByStage(String stage) {
		JSONArray array = new JSONArray();
		List<TenementServiceApplication> list = mapper.getAllApplicationByStage(stage);
		
		for (int i=0; i<list.size(); i++) {
			TenementServiceApplication tmp = list.get(i);
			
			JSONObject json = new JSONObject();			
			try {
				json.put("serve_id", tmp.getServe_id());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			array.put(json);
		}
		
		return array;
	}
	
	@Override
	public void updateApplicationStatus(Integer serve_id, String stage) {
		TenementServiceApplication tmp = new TenementServiceApplication();
		tmp.setServe_id(serve_id);
		tmp.setStage(stage);
		mapper.updateApplicationStatus(tmp);
		return;
	}





}
