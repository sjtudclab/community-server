package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.LivingCard;

/**
 * Created by kevin on 15-8-14.
 */
public interface LivingCardMapper {

        public LivingCard getLivingCardByUserId(long userId);

}
