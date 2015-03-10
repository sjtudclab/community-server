package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.UserPublishedGoods;
import cn.edu.sjtu.se.dclab.server.mapper.UserPublishedGoodsMapper;
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
	
	@Override
	public List<UserPublishedGoods> getPublishedInfoById(Integer id) {
		return mapper.getPublishedInfoById(id);
	}

}
