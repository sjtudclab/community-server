/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.CommunityActivity;
import cn.edu.sjtu.se.dclab.server.mapper.CommunityActivityMapper;
import cn.edu.sjtu.se.dclab.server.service.CommunityActivityService;

/**
 * @author chenhui
 *
 */

@Service
public class CommunityActivityServiceImpl implements CommunityActivityService {
	
	@Autowired
	private CommunityActivityMapper mapper;
	
	@Override
	public JSONArray getAllCommunityActivity() {
		JSONArray array = new JSONArray();
		List<CommunityActivity> list = mapper.getAllCommunityActivity();
		
		for (int i=0; i<list.size(); i++) {
			CommunityActivity tmp = list.get(i);
			JSONObject json = new JSONObject();
			
			try {
				json.put("id", tmp.getId());
				json.put("publisher_id", tmp.getPublisher_id());
				json.put("date", tmp.getPublish_date());
				json.put("title", tmp.getTitle());
				json.put("content", tmp.getContent());
				json.put("place", tmp.getPlace());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			array.put(json);
		}
		
		return array;
	}
	
	@Override
	public void createCommunityActivity(CommunityActivity tmp) {
		mapper.createCommunityActivity(tmp);
		return;
	}

}
