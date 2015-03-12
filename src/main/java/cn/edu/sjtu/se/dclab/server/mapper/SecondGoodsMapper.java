/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.SecondGoods;

/**
 * @author chenhui
 *
 */
public interface SecondGoodsMapper {
	public SecondGoods getSecondGoodsById(Integer id);
	
	public List<SecondGoods> getAllSecondGoods(Integer id);
	
	public void createSecondGoods(SecondGoods secondGoods);
	
	public int getMaxGoodsId();
}
