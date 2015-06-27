package cn.edu.sjtu.se.dclab.server.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Huiyi on 2015/5/30.
 */
public interface ValidationMapper {

    public int checkIsFriends(@Param(value = "fromUserId") int fromUserId,
                                  @Param(value = "toUserId") int toUserId);

    public int checkBelongsToGroup(@Param(value = "userId") int userId,
                                       @Param(value = "groupId") int groupId);
}
