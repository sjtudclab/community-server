/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.UserPublishedGoods;

/**
 * @author chenhui
 *
 */
public interface UserPublishedGoodsService {
	
	public List<UserPublishedGoods> getPublishedInfoById(Integer id);

}
