/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.controller.rest;

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
@RequestMapping("/publish/")
public class GoodsPublishController {
	
	@Autowired
	private SecondGoodsService secondGoodsService;
	@Autowired
	private UserPublishedGoodsService publishService;
	@Autowired
	private UserLovedGoodsService loveService;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	@ResponseBody
	public String test(@PathVariable("id") int id) {

		String info = publishService.getPublishedInfoByUserId(id);
		
		System.out.println("test:"+info);
		return info;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String createSecondGoods(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		// get form
		MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
		
		MultipartFile file = req.getFile("file");
		
		// req.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("dealType");
		String title = request.getParameter("goodsTitle");
		String desc = request.getParameter("goodsDescribe");
		String category = request.getParameter("type1");
		String location = request.getParameter("address");
		String phone = request.getParameter("contactTel");
		String owner = request.getParameter("contactName");
		String imagePath = "";
		int id = 0;
		if(!file.isEmpty()){
			ServletContext sc = request.getSession().getServletContext();
			String dir = sc.getRealPath("/uploadimage");    //设定文件保存的目录
			//sc.getRealPath(arg0)
			
			
			String filename = file.getOriginalFilename();    //得到上传时的文件名
			
			id = secondGoodsService.getMaxGoodsId()+1;
			
			String newFilename = id + "." + getFileType(filename);
			imagePath = "uploadimage/" + newFilename;

			FileUtils.writeByteArrayToFile(new File(dir,newFilename), file.getBytes());
						

		}
			
		
		System.out.println(type+" "+title+" "+desc+" "+category+" "+location+" "+
		phone + " "+owner);

		// insert into db
		SecondGoods secondGoods = new SecondGoods();
		secondGoods.setId(secondGoodsService.getMaxGoodsId() + 1);
		secondGoods.setCategory(category);
		secondGoods.setType(type);
		secondGoods.setTitle(title);
		secondGoods.setImagePath(imagePath);
		secondGoods.setDesc(desc);
		secondGoods.setOwner(owner);
		secondGoods.setPhone(phone);
		
		
		secondGoodsService.createSecondGoods(secondGoods);
		publishService.createPublishedGoods(1, secondGoods.getId(), "1");
		
		return "redirect:/market_thing_info.html?id="+secondGoods.getId();
	}
	
	public String getFileType(String filename){
		String[] arr = filename.split("\\.");
		return arr[1];
	}
	
	

}
