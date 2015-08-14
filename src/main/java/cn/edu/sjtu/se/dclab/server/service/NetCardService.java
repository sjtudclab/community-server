package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.NetCard;

import java.util.Collection;

/**
 * Created by kevin on 15-8-13.
 */
public interface NetCardService {
    public NetCard getNetCardByUserId(long userId);
}
