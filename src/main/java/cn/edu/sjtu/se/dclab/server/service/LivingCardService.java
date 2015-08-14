package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.LivingCard;

/**
 * Created by kevin on 15-8-14.
 */
public interface LivingCardService {
    public LivingCard getLivingCardByUserId(long userId);
}
