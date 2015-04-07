/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.TenementOrder;



public interface TenementOrderMapper {
	
	public void createOrder(TenementOrder tmp);
	
	public List<TenementOrder> getTenementOrderByUserId(Integer user_id);
	
	public List<TenementOrder> getUserOrderByType(TenementOrder tmp);
	
	public void updateTenementOrderStatus(TenementOrder tmp);
	
	public List<TenementOrder> getServicemanOrderByType(TenementOrder tmp);
	
	public List<TenementOrder> getAllOrderByType(String stage);
	
	public List<TenementOrder> getAllOrder();
	
	public TenementOrder getOneOrderByOrderId(String order_id);
	
		

}
