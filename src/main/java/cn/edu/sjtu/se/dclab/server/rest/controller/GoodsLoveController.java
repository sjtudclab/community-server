/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.rest.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.edu.sjtu.se.dclab.server.entity.SecondGoods;
import cn.edu.sjtu.se.dclab.server.entity.UserPublishedGoods;
import cn.edu.sjtu.se.dclab.server.service.SecondGoodsService;
import cn.edu.sjtu.se.dclab.server.service.UserLovedGoodsService;
import cn.edu.sjtu.se.dclab.server.service.UserPublishedGoodsService;


/**
 * @author chenhui
 *
 */

@Controller
@RequestMapping("/love/")
public class GoodsLoveController {
	
	@Autowired
	private SecondGoodsService secondGoodsService;

	@Autowired
	private UserLovedGoodsService loveService;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	@ResponseBody
	public String getLovedInfoByUserId(@PathVariable("id") int id) {

		String info = loveService.getLovedInfoByUserId(id);
		
		System.out.println("test:"+info);
		return info;
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	@ResponseBody
	public String addLovedGoods(HttpServletRequest request,
			HttpServletResponse response) {

		int userID = Integer.parseInt(request.getParameter("userID"));
		int goodsID = Integer.parseInt(request.getParameter("goodsID"));
		
		String stage = "1";
		
		loveService.createLovedGoods(userID, goodsID, stage);
		
		System.out.println(userID+" add love goods:"+goodsID+" success");
		
		return userID+" add love goods:"+goodsID+" success";
	}
		
	

}
