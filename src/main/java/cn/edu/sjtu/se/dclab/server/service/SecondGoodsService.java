/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.edu.sjtu.se.dclab.server.entity.SecondGoods;

/**
 * @author chenhui
 *
 */
public interface SecondGoodsService {
	
	public SecondGoods getSecondGoodsById(Integer id);
	
	public List<SecondGoods> getAllSecondGoods(Integer id);
	
	public int getMaxGoodsId();
	
	public JSONObject getSecondGoodsInfoById(Integer id);
	
	public void createSecondGoods(SecondGoods secondGoods);
	
	public JSONArray searchGoodsByCategory(String s);
	

}
