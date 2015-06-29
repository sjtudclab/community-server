package cn.edu.sjtu.se.dclab.server.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Huiyi on 2015/6/29.
 */
public interface CardMapper {
    public void updateBalance(@Param(value = "cardId") String cardId,
                              @Param(value = "balance") int balance);
}
