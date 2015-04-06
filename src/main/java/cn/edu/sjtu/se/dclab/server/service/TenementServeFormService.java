/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service;

import org.json.JSONObject;

import cn.edu.sjtu.se.dclab.server.entity.TenementServeForm;





public interface TenementServeFormService {
	
	public void createServeForm(TenementServeForm tmp);
	
	public void updateUserComment(String order_id, int score, String comment);
	
	public void updateServingRecord(String order_id, String record);
	
	public JSONObject getUserCommentByOrderId(String order_id);

}
