package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.UserLovedGoods;
import cn.edu.sjtu.se.dclab.server.mapper.UserLovedGoodsMapper;
import cn.edu.sjtu.se.dclab.server.service.SecondGoodsService;
import cn.edu.sjtu.se.dclab.server.service.UserLovedGoodsService;

/**
 * @author chenhui
 *
 */

@Service
public class UserLovedGoodsServiceImpl implements UserLovedGoodsService{
	@Autowired
	private UserLovedGoodsMapper mapper;

	public UserLovedGoodsMapper getMapper() {
		return mapper;
	}

	public void setMapper(UserLovedGoodsMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public List<UserLovedGoods> getLovedInfoById(Integer id) {
		return mapper.getLovedInfoById(id);
		
	}
	
	@Autowired
	private SecondGoodsService goodsService;
	
	@Override
	public String getLovedInfoByUserId(Integer id) {
		JSONArray array = new JSONArray();
		List<UserLovedGoods> list = mapper.getLovedInfoById(id);
		
		for (int i=0; i<list.size(); i++) {
			UserLovedGoods tmp = list.get(i);
			JSONObject json = new JSONObject();
			json = goodsService.getSecondGoodsInfoById(tmp.getGoodsID());
			
			array.put(json);
		}
		
		return array.toString();
	}
	
	@Override
	public void createLovedGoods(int userID, int goodsID, String stage) {
		UserLovedGoods tmp = new UserLovedGoods();
		tmp.setUserID(userID);
		tmp.setGoodsID(goodsID);
		tmp.setStage(stage);
		
		mapper.createLovedGoods(tmp);
		
	}

}
