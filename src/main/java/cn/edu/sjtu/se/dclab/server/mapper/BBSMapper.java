package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.BBSPost;
import cn.edu.sjtu.se.dclab.server.entity.BBSReply;
import cn.edu.sjtu.se.dclab.server.entity.Block_manager;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

public interface BBSMapper {
	
	public Collection<BBSPost> findAll();
	public void save(BBSPost bbsPost);
	public void saveReply(BBSReply bbsReply);
	public void saveReplyReply(BBSReply bbsReply);
	public Collection<BBSPost> findBbsPostById(long id);
	public Collection<BBSReply> findBbsRepliesByPostId(long post_id);
	public Collection<BBSReply> findBbsReplyReplies(@Param("post_id") long post_id,@Param("reply_id")  long reply_id);
}
