/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.sjtu.se.dclab.server.entity.TenementOrder;




public interface TenementOrderService {
	
	public void createOrder(TenementOrder tmp);
	
	public JSONArray getTenementOrderByUserId(Integer user_id);
	
	public JSONArray getUserOrderByType(Integer user_id, String stage);
	
	public void updateTenementOrderStatus(String order_id, String stage);
	
	public JSONArray getServicemanOrderByType(int serve_id, String stage);
	
	public JSONArray getAllOrderByType(String stage);
	
	public JSONArray getAllOrder();
	
	public JSONObject getOneOrderByOrderId(String order_id);
	
	

}
