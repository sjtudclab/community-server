package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.BBSPost;
import cn.edu.sjtu.se.dclab.server.entity.BBSReply;

import java.util.Collection;

public interface BBSService {
	
	public Collection<BBSPost> findAll();	//JSON
	public void save(BBSPost bbsPost);
	public void saveReply(BBSReply bbsReply);
	public void saveReplyReply(BBSReply bbsReply);
	public Collection<BBSPost> findBbsPostById(long id);
	public Collection<BBSReply> findBbsRepliesByPostId(long post_id);

}
