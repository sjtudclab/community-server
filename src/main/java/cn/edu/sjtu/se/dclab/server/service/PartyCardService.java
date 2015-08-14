package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.PartyCard;

/**
 * Created by kevin on 15-8-14.
 */
public interface PartyCardService {
    public PartyCard getPartyCardByUserId(long userId);
}
