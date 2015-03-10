/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.SecondGoods;

/**
 * @author chenhui
 *
 */
public interface SecondGoodsService {
	
	public SecondGoods getSecondGoodsById(Integer id);
	
	public List<SecondGoods> getAllSecondGoods(Integer id);
	

}
