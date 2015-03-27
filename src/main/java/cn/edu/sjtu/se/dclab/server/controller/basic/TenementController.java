package cn.edu.sjtu.se.dclab.server.controller.basic;
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
 * @author Applex
 */
@Controller
@RequestMapping("/tenement")
public class TenementController {
	
	@RequestMapping("")
	public String test() {
		//model.addAttribute("test", "测试");
		return "tenement";
	}

}
