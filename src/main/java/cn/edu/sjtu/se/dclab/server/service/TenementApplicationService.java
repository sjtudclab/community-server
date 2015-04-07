/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.sjtu.se.dclab.server.entity.TenementServiceApplication;





public interface TenementApplicationService {
	
	public void createTenementApplication(TenementServiceApplication tmp);
	
	public JSONObject getApplicationById(Integer serve_id);
	
	public JSONArray getAllApplicationByStage(String stage);
	
	public void updateApplicationStatus(Integer serve_id, String stage);
	

}
