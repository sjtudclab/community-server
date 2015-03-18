/**
 * 
 */
package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.CommunityActivity;

/**
 * @author chenhui
 *
 */
public interface CommunityActivityMapper {
	public List<CommunityActivity> getAllCommunityActivity();
	
	public void createCommunityActivity(CommunityActivity tmp);
}
