package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.UserPublishedGoods;
import cn.edu.sjtu.se.dclab.server.mapper.UserPublishedGoodsMapper;
import cn.edu.sjtu.se.dclab.server.service.SecondGoodsService;
import cn.edu.sjtu.se.dclab.server.service.UserPublishedGoodsService;

/**
 * @author chenhui
 *
 */

@Service
public class UserPublishedGoodsServiceImpl implements UserPublishedGoodsService{
	@Autowired
	private UserPublishedGoodsMapper mapper;
	

	public UserPublishedGoodsMapper getMapper() {
		return mapper;
	}

	public void setMapper(UserPublishedGoodsMapper mapper) {
		this.mapper = mapper;
	}
	
	@Autowired
	private SecondGoodsService goodsService;
	
	@Override
	public List<UserPublishedGoods> getPublishedInfoById(Integer id) {
		return mapper.getPublishedInfoById(id);
	}
	
	@Override
	public String getPublishedInfoByUserId(Integer id){
		JSONArray array = new JSONArray();
		List<UserPublishedGoods> list = mapper.getPublishedInfoById(id);
		
		for (int i=0; i<list.size(); i++) {
			UserPublishedGoods tmp = list.get(i);
			JSONObject json = new JSONObject();
			json = goodsService.getSecondGoodsInfoById(tmp.getGoodsID());
			
			
			// put second goods info
			array.put(json);
		}
		
		return array.toString();
	}
	
	@Override
	public void createPublishedGoods(int userID, int goodsID, String stage) {
		UserPublishedGoods tmp = new UserPublishedGoods();
		tmp.setUserID(userID);
		tmp.setGoodsID(goodsID);
		tmp.setStage(stage);
		
		mapper.createPublishedGoods(tmp);
	}
	
	@Override
	public JSONArray getGoodsByStage(String stage) {
		JSONArray array = new JSONArray();
		List<UserPublishedGoods> list = mapper.getGoodsByStage(stage);
		
		for (int i=0; i<list.size(); i++) {
			UserPublishedGoods tmp = list.get(i);
			JSONObject json = new JSONObject();
			json = goodsService.getSecondGoodsInfoById(tmp.getGoodsID());
			
			array.put(json);
		}
		
		return array;
	}
	
	@Override
	public void updateGoodsStage(int goodsID, String stage) {
		UserPublishedGoods tmp = new UserPublishedGoods();
		
		tmp.setGoodsID(goodsID);
		tmp.setStage(stage);
		
		mapper.updateGoodsStage(tmp);
	}

}
