package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.Building;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by Huiyi on 20
 */
public interface BuildingService {
    public Collection<Building> findAll();
}
