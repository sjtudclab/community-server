/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.UserPublishedGoods;

/**
 * @author chenhui
 *
 */
public interface UserPublishedGoodsMapper {
	public List<UserPublishedGoods> getPublishedInfoById(Integer id);
	
	public void createPublishedGoods(UserPublishedGoods tmp);
	
	public List<UserPublishedGoods> getGoodsByStage(String stage);
	
	public void updateGoodsStage(UserPublishedGoods tmp);
}
