package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.PartyCard;

/**
 * Created by kevin on 15-8-14.
 */
public interface PartyCardMapper {
    public PartyCard getPartyCardByUserId(long userId);
}
