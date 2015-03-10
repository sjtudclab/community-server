/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.List;

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

}
