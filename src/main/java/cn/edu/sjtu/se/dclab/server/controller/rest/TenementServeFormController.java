package cn.edu.sjtu.se.dclab.server.controller.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.service.TenementOrderService;
import cn.edu.sjtu.se.dclab.server.service.TenementServeFormService;
import cn.edu.sjtu.se.dclab.server.util.TenementOrderStatus;

@Controller
@RequestMapping(Constants.REST + "/tenement/")
public class TenementServeFormController {
	
	@Autowired
	private TenementServeFormService formService;
	
	@Autowired
	private TenementOrderService orderService;
	
	@RequestMapping(value="user/order/comment", method=RequestMethod.POST, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String saveUserComment(HttpServletRequest request,
			HttpServletResponse response){
		
		String order_id = request.getParameter("order_id");
		int user_socre = Integer.parseInt(request.getParameter("user_score"));
		String user_comment = request.getParameter("user_comment");
		
		formService.updateUserComment(order_id, user_socre, user_comment);
		//更新报修单状态 
		orderService.updateTenementOrderStatus(order_id, TenementOrderStatus.COMMENTED);
		
		return "tenement comment success";
	}
	
	@RequestMapping(value="serving/order/record", method=RequestMethod.POST, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String saveServeRecord(HttpServletRequest request,
			HttpServletResponse response){
		String order_id = request.getParameter("order_id");
		String record = request.getParameter("record");
		
		//保存服务记录
		formService.updateServingRecord(order_id, record);
		
		//更新报修单状态
		orderService.updateTenementOrderStatus(order_id, TenementOrderStatus.FINISHED);
		
		return "tenement serving record success";
	}
	
	@RequestMapping(value="order/comment/{order_id}", method=RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String getUserCommentByOrderId(@PathVariable("order_id") String order_id){
		return formService.getUserCommentByOrderId(order_id).toString();
	}

}
