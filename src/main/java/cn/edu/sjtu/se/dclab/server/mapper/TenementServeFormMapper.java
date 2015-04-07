/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.TenementServeForm;




public interface TenementServeFormMapper {
	
	public void createServeForm(TenementServeForm tmp);
	
	public void updateUserComment(TenementServeForm tmp);
	
	public void updateServingRecord(TenementServeForm tmp);
	
	public TenementServeForm getUserCommentByOrderId(String order_id);

}
