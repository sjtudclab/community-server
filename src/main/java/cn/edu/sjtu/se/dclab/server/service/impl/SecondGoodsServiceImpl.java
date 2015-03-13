/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.SecondGoods;
import cn.edu.sjtu.se.dclab.server.mapper.SecondGoodsMapper;
import cn.edu.sjtu.se.dclab.server.service.SecondGoodsService;

/**
 * @author chenhui
 *
 */
@Service
public class SecondGoodsServiceImpl implements SecondGoodsService{
	@Autowired
	private SecondGoodsMapper secondGoodsMapper;

	public SecondGoodsMapper getSecondGoodsMapper() {
		return secondGoodsMapper;
	}

	public void setSecondGoodsMapper(SecondGoodsMapper secondGoodsMapper) {
		this.secondGoodsMapper = secondGoodsMapper;
	}
	
	@Override
	public SecondGoods getSecondGoodsById(Integer id) {
		return secondGoodsMapper.getSecondGoodsById(id);
	}
	
	@Override
	public List<SecondGoods> getAllSecondGoods(Integer id) {
		return secondGoodsMapper.getAllSecondGoods(id);
	}
	
	@Override
	public int getMaxGoodsId() {
		return secondGoodsMapper.getMaxGoodsId();
	}
	
	@Override
	public JSONObject getSecondGoodsInfoById(Integer id) {
		JSONObject json = new JSONObject();
		SecondGoods secondGoods = secondGoodsMapper.getSecondGoodsById(id);
		
		try {
			json.put("id", secondGoods.getId());
			
			json.put("category", URLEncoder.encode(secondGoods.getCategory(),"UTF-8"));		
			json.put("type", URLEncoder.encode(secondGoods.getType(),"UTF-8"));
			json.put("title", URLEncoder.encode(secondGoods.getTitle(),"UTF-8"));
			json.put("imagePath", secondGoods.getImagePath());
			json.put("desc", URLEncoder.encode(secondGoods.getDesc(),"UTF-8"));
			json.put("owner", URLEncoder.encode(secondGoods.getOwner(),"UTF-8"));
			json.put("phone", URLEncoder.encode(secondGoods.getPhone(),"UTF-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
		
	}
	
	@Override
	public void createSecondGoods(SecondGoods secondGoods) {
		secondGoodsMapper.createSecondGoods(secondGoods);
	}
	
	@Override
	public JSONArray searchGoodsByCategory(String s) {
		JSONArray array = new JSONArray();
		List<SecondGoods> list = secondGoodsMapper.searchGoodsByCategory(s);
		
		for (int i=0; i<list.size(); i++) {
			SecondGoods secondGoods = list.get(i);
			
			JSONObject json = new JSONObject();
			try {
				json.put("id", secondGoods.getId());
				
				json.put("category", URLEncoder.encode(secondGoods.getCategory() ,"UTF-8"));
				json.put("type", URLEncoder.encode(secondGoods.getType() ,"UTF-8"));
				json.put("title",URLEncoder.encode(secondGoods.getTitle() ,"UTF-8"));
				json.put("imagePath", secondGoods.getImagePath());
				json.put("desc", URLEncoder.encode(secondGoods.getDesc() ,"UTF-8"));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			array.put(json);
		}
		
		return array;
	}

}
