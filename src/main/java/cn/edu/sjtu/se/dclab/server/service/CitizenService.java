package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.Citizen;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
public interface CitizenService {
    public Collection<Citizen> findAll();
}
