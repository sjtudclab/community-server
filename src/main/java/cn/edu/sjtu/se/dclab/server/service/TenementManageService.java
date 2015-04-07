package cn.edu.sjtu.se.dclab.server.service;

import org.json.JSONArray;

import cn.edu.sjtu.se.dclab.server.entity.TenementManage;

public interface TenementManageService {
	
	public void createServicemanManage(TenementManage tmp);
	
	public JSONArray getServicemanInfo(String stage);

}
