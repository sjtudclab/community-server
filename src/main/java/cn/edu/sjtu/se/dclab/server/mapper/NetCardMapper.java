package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.NetCard;

/**
 * Created by kevin on 15-8-13.
 */
public interface NetCardMapper {
    public NetCard findByUserId(long userId);
}
