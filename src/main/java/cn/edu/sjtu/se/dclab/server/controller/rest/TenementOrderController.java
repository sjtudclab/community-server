package cn.edu.sjtu.se.dclab.server.controller.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.TenementOrder;
import cn.edu.sjtu.se.dclab.server.entity.TenementServeForm;
import cn.edu.sjtu.se.dclab.server.service.TenementOrderService;
import cn.edu.sjtu.se.dclab.server.service.TenementServeFormService;
import cn.edu.sjtu.se.dclab.server.util.TenementOrderStatus;


@Controller
@RequestMapping(Constants.REST + "/tenement/")
public class TenementOrderController {
	
	@Autowired
	private TenementOrderService orderService;
	
	@Autowired
	private TenementServeFormService formService;
	
	@RequestMapping(value="user/order/create", method=RequestMethod.POST)
	@ResponseBody
	public String createTenementOrder(HttpServletRequest request,
			HttpServletResponse response){
		
		UUID uuid = UUID.randomUUID();
		String order_id = String.valueOf(uuid);
		int user_id = Integer.parseInt(request.getParameter("user_id"));		
		String order_name = request.getParameter("type");
		String order_address = request.getParameter("address");
		String contact_name = request.getParameter("contact_name");
		String contact_phone = request.getParameter("contact_phone");
		String stage = TenementOrderStatus.INITIAL;
		int serve_id = Integer.parseInt(request.getParameter("serve_id"));
		
		System.out.println("Tenement Order:"+order_id+"|"+user_id+"|"+
		order_name+"|"+order_address+"|"+contact_name+"|"+contact_phone+"|"+stage+"|"+serve_id+"%%");
		
		TenementOrder order = new TenementOrder();
		order.setOrder_id(order_id);
		order.setUser_id(user_id);
		order.setOrder_name(order_name);
		order.setOrder_address(order_address);
		order.setContact_name(contact_name);
		order.setContact_phone(contact_phone);
		order.setStage(stage);
		order.setServe_id(serve_id);
		
		orderService.createOrder(order);
		
		TenementServeForm serve_form = new TenementServeForm();
		serve_form.setOrder_id(order_id);
		serve_form.setServe_id(serve_id);
		
		formService.createServeForm(serve_form);
		
		return "tenement order success";
	}
	
	@RequestMapping(value="{id}/order/check", method=RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String checkTenementOrderByUserId(@PathVariable("id") int id) {
		return orderService.getTenementOrderByUserId(id).toString();
	}
	
	@RequestMapping(value="{id}/order/finished", method=RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String getUserFinishedOrder(@PathVariable("id") int id) {
		return orderService.getUserOrderByType(id, TenementOrderStatus.FINISHED).toString();
	}
	
	@RequestMapping(value="serving/{id}/order/initial", method=RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String getServicemanAllOrder(@PathVariable("id") int id) {
		return orderService.getServicemanOrderByType(id, TenementOrderStatus.INITIAL).toString();
	}
	
	@RequestMapping(value="order/{order_id}/accepted", method=RequestMethod.POST)
	@ResponseBody
	public String updateOrderAccepted(@PathVariable("order_id") String order_id) {
		orderService.updateTenementOrderStatus(order_id, TenementOrderStatus.ACCEPTED);
		return "accepted success";
	}
	
	@RequestMapping(value="serving/{id}/order/accepted", method=RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String getServicemanAcceptedOrder(@PathVariable("id") int id) {
		return orderService.getServicemanOrderByType(id, TenementOrderStatus.ACCEPTED).toString();
	}
	
	/*
	@RequestMapping(value="order/{order_id}/finished", method=RequestMethod.POST)
	@ResponseBody
	public String updateOrderFinished(@PathVariable("order_id") String order_id) {
		orderService.updateTenementOrderStatus(order_id, TenementOrderStatus.FINISHED);
		return "serving record success";
	}*/
	
	@RequestMapping(value="all/order/commented", method=RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String getAllCommentedOrder(){
		return orderService.getAllOrderByType(TenementOrderStatus.COMMENTED).toString();
	}
	
	@RequestMapping(value="all/order", method=RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String getAllOrder(){
		return orderService.getAllOrder().toString();
	}
	
	@RequestMapping(value="one/order/{order_id}", method=RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String getOneOrderByOrderId(@PathVariable("order_id") String order_id){
		return orderService.getOneOrderByOrderId(order_id).toString();
	}
	

}
