/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.controller;

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
import cn.edu.sjtu.se.dclab.server.service.UserPublishedGoodsService;


/**
 * @author chenhui
 *
 */

@Controller
@RequestMapping("/SecondGoods/")
public class SecondGoodsController {
	
	@Autowired
	private SecondGoodsService secondGoodsService;
	
	@RequestMapping(value="latest", method=RequestMethod.GET)
	@ResponseBody
	public String getLatest(HttpServletRequest request,
			HttpServletResponse response) throws JSONException, Exception {
		//JSONObject allJson = new JSONObject();
		JSONArray array = new JSONArray();
		List<SecondGoods> list = secondGoodsService.getAllSecondGoods(1);
		
		for (int i=0; i<list.size(); i++){
			SecondGoods secondGoods = list.get(i);
			
			JSONObject json = new JSONObject();
			json.put("id", secondGoods.getId());
						
			json.put("category", URLEncoder.encode(secondGoods.getCategory() ,"UTF-8"));
			json.put("type", URLEncoder.encode(secondGoods.getType() ,"UTF-8"));
			json.put("title",URLEncoder.encode(secondGoods.getTitle() ,"UTF-8"));
			json.put("imagePath", secondGoods.getImagePath());
			json.put("desc", URLEncoder.encode(secondGoods.getDesc() ,"UTF-8"));
			//System.out.println(goods.getId()+" "+goods.getTitle());
			
			//allJson.put(i, json);
			array.put(json);
			
		}
		
		System.out.println(array.toString());
		System.out.println("length:"+array.length());
		return array.toString();
	}
	
	@RequestMapping(value="dealGoods", method=RequestMethod.GET)
	@ResponseBody
	public String getDealGoods(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("dealGoods haha");
		return "dealGoods success";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getItem(@PathVariable("id") int id) throws JSONException, Exception {
		JSONObject json = new JSONObject();
		SecondGoods secondGoods = secondGoodsService.getSecondGoodsById(id);
		json.put("id", secondGoods.getId());
				
		json.put("category", URLEncoder.encode(secondGoods.getCategory(),"UTF-8"));			
		json.put("type", URLEncoder.encode(secondGoods.getType(),"UTF-8"));
		json.put("title", URLEncoder.encode(secondGoods.getTitle(),"UTF-8"));
		json.put("imagePath", secondGoods.getImagePath());
		json.put("desc", URLEncoder.encode(secondGoods.getDesc(),"UTF-8"));
		json.put("owner", URLEncoder.encode(secondGoods.getOwner(),"UTF-8"));
		json.put("phone", URLEncoder.encode(secondGoods.getPhone(),"UTF-8"));
		
		System.out.println("second goods:"+json.toString());
		

		return json.toString();
	}
	
	
	// form post to receive goods info.
	@RequestMapping(value="create", method=RequestMethod.POST)  
	@ResponseBody
	public String createSecondGoods(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		
		MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
		MultipartFile file1 = req.getFile("file");
		String type = request.getParameter("dealType");
		String title = request.getParameter("goodsTitle");
		String desc = request.getParameter("goodsDescribe");
		String category = request.getParameter("type1");
		String location = request.getParameter("address");
		String phone = request.getParameter("contactTel");
		String owner = request.getParameter("contactName");
		
		if(!file1.isEmpty()){
			ServletContext sc = request.getSession().getServletContext();
			String dir = sc.getRealPath("/uploadimage");    //设定文件保存的目录
			//sc.getRealPath(arg0)
			
			
			String filename = file1.getOriginalFilename();    //得到上传时的文件名
			FileUtils.writeByteArrayToFile(new File(dir,filename), file1.getBytes());
			
			System.out.println("file path:"+dir+"/"+filename);
			
			System.out.println("file:"+filename);

		}
		
		System.out.println("create goods haha");
		
		
		System.out.println(type+" "+title+" "+desc+" "+category+" "+location+" "+
		phone + " "+owner);
		return "create Goods success";
	}
	
	
	@Autowired
	private UserPublishedGoodsService service;
	
	@RequestMapping(value="test", method=RequestMethod.GET)
	@ResponseBody
	public String test(HttpServletRequest request,
			HttpServletResponse response) {
		List<UserPublishedGoods> list = service.getPublishedInfoById(1);
		
		for (int i=0; i<list.size(); i++){
			UserPublishedGoods data = list.get(i);
			System.out.println(data.getUserID()+" "+data.getGoodsID()+" "+data.getStage());
		}
		
		System.out.println("test user goods haha");
		return "test Goods success";
	}

}
