package cn.edu.sjtu.se.dclab.server.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.entity.CommunityActivity;
import cn.edu.sjtu.se.dclab.server.entity.Item;
import cn.edu.sjtu.se.dclab.server.service.CommunityActivityService;
import cn.edu.sjtu.se.dclab.server.service.ItemService;


/**
 * 
 *
 * @author chenhui
 */
@Controller
@RequestMapping("/activity/")
public class CommunityActivityController {

	@Autowired
	private CommunityActivityService service;

	@RequestMapping(value="all",method = RequestMethod.GET)
	@ResponseBody
	public String getAll() {
		JSONArray array = service.getAllCommunityActivity();
		return array.toString();
	}

	@RequestMapping(value="create",method = RequestMethod.GET)
	@ResponseBody
	public String createActivity(HttpServletRequest request,
			HttpServletResponse response) {
		int publisher_id = Integer.parseInt(request.getParameter("publisher_id"));
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String place = request.getParameter("place");
		String content = request.getParameter("content");
		
		CommunityActivity activity = new CommunityActivity();
		activity.setPublisher_id(publisher_id);
		activity.setTitle(title);
		activity.setPublish_date(date);
		activity.setPlace(place);
		activity.setContent(content);
		
		service.createCommunityActivity(activity);
		
		return "success";
	}

}
