/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.UserLovedGoods;

/**
 * @author chenhui
 *
 */
public interface UserLovedGoodsMapper {
	public List<UserLovedGoods> getLovedInfoById(Integer id);
	
	public void createLovedGoods(UserLovedGoods tmp);
}
