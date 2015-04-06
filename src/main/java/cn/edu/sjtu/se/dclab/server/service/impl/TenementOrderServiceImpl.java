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

import cn.edu.sjtu.se.dclab.server.entity.TenementOrder;
import cn.edu.sjtu.se.dclab.server.mapper.TenementOrderMapper;
import cn.edu.sjtu.se.dclab.server.service.TenementOrderService;


@Service
public class TenementOrderServiceImpl implements TenementOrderService{
	@Autowired
	private TenementOrderMapper mapper;
	
	public TenementOrderMapper getMapper() {
		return mapper;
	}

	public void setMapper(TenementOrderMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void createOrder(TenementOrder tmp){
		mapper.createOrder(tmp);
		return;
	}
	
	@Override
	public JSONArray getTenementOrderByUserId(Integer user_id){
		JSONArray array = new JSONArray();
		List<TenementOrder> list = mapper.getTenementOrderByUserId(user_id);
		
		for (int i=0; i<list.size(); i++) {
			TenementOrder order = list.get(i);
			
			JSONObject json = new JSONObject();		
			try {
				json.put("order_id", order.getOrder_id());
				
				json.put("order_name", order.getOrder_name());
				json.put("order_address", order.getOrder_address());
				json.put("contact_name", order.getContact_name());
				json.put("contact_phone", order.getContact_phone());
				json.put("stage", order.getStage());
				json.put("serve_id", order.getServe_id());
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			array.put(json);
		}
		
		return array;
	}
	
	@Override
	public JSONArray getUserOrderByType(Integer user_id, String stage) {
		JSONArray array = new JSONArray();
		TenementOrder order = new TenementOrder();
		order.setUser_id(user_id);
		order.setStage(stage);
		
		List<TenementOrder> list = mapper.getUserOrderByType(order);
		
		for (int i=0; i<list.size(); i++) {
			order = list.get(i);
			JSONObject json = new JSONObject();
			
			try {
				json.put("order_id", order.getOrder_id());
				
				json.put("order_name", order.getOrder_name());
				json.put("order_address", order.getOrder_address());
				json.put("contact_name", order.getContact_name());
				json.put("contact_phone", order.getContact_phone());
				json.put("stage", order.getStage());
				json.put("serve_id", order.getServe_id());
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			array.put(json);
		}
		
		return array;
	}
	
	@Override
	public void updateTenementOrderStatus(String order_id, String stage){
		TenementOrder order = new TenementOrder();
		order.setOrder_id(order_id);
		order.setStage(stage);
		mapper.updateTenementOrderStatus(order);
		return;
	}
	
	@Override
	public JSONArray getServicemanOrderByType(int serve_id, String stage) {
		JSONArray array = new JSONArray();
		TenementOrder order = new TenementOrder();
		order.setServe_id(serve_id);
		order.setStage(stage);
		
		List<TenementOrder> list = mapper.getServicemanOrderByType(order);
		
		for (int i=0; i<list.size(); i++) {
			
			order = list.get(i);
			JSONObject json = new JSONObject();
			
			try {
				json.put("order_id", order.getOrder_id());
				
				json.put("order_name", order.getOrder_name());
				json.put("order_address", order.getOrder_address());
				json.put("contact_name", order.getContact_name());
				json.put("contact_phone", order.getContact_phone());
				json.put("stage", order.getStage());
				json.put("serve_id", order.getServe_id());
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			array.put(json);
		}
		
		
		return array;
		
	}
	
	@Override
	public JSONArray getAllOrderByType(String stage) {
		JSONArray array = new JSONArray();
		TenementOrder order = new TenementOrder();
		List<TenementOrder> list = mapper.getAllOrderByType(stage);
		
		for (int i=0; i<list.size(); i++){
			order = list.get(i);
			JSONObject json = new JSONObject();
			
			try {
				json.put("order_id", order.getOrder_id());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			array.put(json);
		}
		return array;
	}
	
	@Override
	public JSONArray getAllOrder() {
		JSONArray array = new JSONArray();
		TenementOrder order = new TenementOrder();
		List<TenementOrder> list = mapper.getAllOrder();
		
		for (int i=0; i<list.size(); i++){
			order = list.get(i);
			JSONObject json = new JSONObject();
			
			try {
				json.put("order_id", order.getOrder_id());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			array.put(json);
		}
		
		return array;
	}
	
	@Override
	public JSONObject getOneOrderByOrderId(String order_id) {
		JSONObject json = new JSONObject();
		TenementOrder order = mapper.getOneOrderByOrderId(order_id);		
		try {
			json.put("serve_id", order.getServe_id());
			json.put("order_name", order.getOrder_name());
			json.put("contact_name", order.getContact_name());
			json.put("contact_phone", order.getContact_phone());
			json.put("order_address", order.getOrder_address());
			json.put("stage", order.getStage());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return json;
	}
	


}
