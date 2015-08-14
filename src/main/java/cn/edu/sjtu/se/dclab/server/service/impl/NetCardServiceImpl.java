package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.NetCard;
import cn.edu.sjtu.se.dclab.server.mapper.NetCardMapper;
import cn.edu.sjtu.se.dclab.server.mapper.RoleMapper;
import cn.edu.sjtu.se.dclab.server.service.NetCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kevin on 15-8-13.
 */
@Service
public class NetCardServiceImpl implements NetCardService  {
    @Autowired
    private NetCardMapper cardMapper;

    public NetCardMapper getCardMapper() {
        return cardMapper;
    }

    public void setCardMapper(NetCardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

    @Override
    public NetCard getNetCardByUserId(long userId) {
        return cardMapper.findByUserId(userId);
    }
}
