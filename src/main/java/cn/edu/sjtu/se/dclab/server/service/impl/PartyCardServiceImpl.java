package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.PartyCard;
import cn.edu.sjtu.se.dclab.server.mapper.PartyCardMapper;
import cn.edu.sjtu.se.dclab.server.service.PartyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kevin on 15-8-14.
 */
@Service
public class PartyCardServiceImpl implements PartyCardService{
    @Autowired
    private PartyCardMapper partyCardMapper;


    @Override
    public PartyCard getPartyCardByUserId(long userId) {
        return partyCardMapper.getPartyCardByUserId(userId);
    }
}
