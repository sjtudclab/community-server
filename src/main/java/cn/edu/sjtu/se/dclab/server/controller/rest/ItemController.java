package cn.edu.sjtu.se.dclab.server.controller.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.entity.Item;
import cn.edu.sjtu.se.dclab.server.service.ItemService;


/**
 * 2015年1月19日 上午10:53:57
 *
 * @author changyi yuan
 */
@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value="{id}[",method = RequestMethod.GET)
	@ResponseBody
	public String getItem(@PathVariable("id") int id) {
		Item item = itemService.getItemById(id);
		return item.getName();
	}

	@RequestMapping(value="create",method = RequestMethod.GET)
	@ResponseBody
	public String createItem(HttpServletRequest request,
			HttpServletResponse response) {
		return "index";
	}
	
	@RequestMapping("test")
	public String test(Model model){
		model.addAttribute("test", "测试");
		return "test";
	}

}
