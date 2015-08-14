package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.LivingCard;
import cn.edu.sjtu.se.dclab.server.mapper.LivingCardMapper;
import cn.edu.sjtu.se.dclab.server.service.LivingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kevin on 15-8-14.
 */
@Service
public class LivingCardServiceImpl implements LivingCardService{
    @Autowired
    private LivingCardMapper livingCardMapper;
    @Override
    public LivingCard getLivingCardByUserId(long userId) {
        return livingCardMapper.getLivingCardByUserId(userId);
    }

}
