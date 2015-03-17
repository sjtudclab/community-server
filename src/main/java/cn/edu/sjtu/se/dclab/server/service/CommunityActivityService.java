/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.service;

import org.json.JSONArray;

import cn.edu.sjtu.se.dclab.server.entity.CommunityActivity;

/**
 * @author chenhui
 *
 */
public interface CommunityActivityService {
	
	public JSONArray getAllCommunityActivity();
	
	public void createCommunityActivity(CommunityActivity tmp);

}
