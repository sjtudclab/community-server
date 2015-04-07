package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.TenementManage;
import cn.edu.sjtu.se.dclab.server.entity.TenementServiceman;
import cn.edu.sjtu.se.dclab.server.mapper.TenementManageMapper;
import cn.edu.sjtu.se.dclab.server.service.TenementManageService;

@Service
public class TenementManageServiceImpl implements TenementManageService{
	@Autowired
	private TenementManageMapper mapper;

	public TenementManageMapper getMapper() {
		return mapper;
	}

	public void setMapper(TenementManageMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public void createServicemanManage(TenementManage tmp) {
		mapper.createServiceManage(tmp);
		return;
	}
	
	@Override
	public JSONArray getServicemanInfo(String stage) {
		JSONArray array = new JSONArray();
		List<TenementServiceman> list = mapper.getServicemanInfo(stage);
		
		for (int i=0; i<list.size(); i++) {
			TenementServiceman tmp = list.get(i);
			JSONObject json = new JSONObject();
			
			try {
				json.put("serve_id", tmp.getServe_id());
				json.put("times", tmp.getTimes());
				json.put("score", tmp.getScore());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			array.put(json);
		}
		return array;
	}

}
