package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.Building;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/16.
 */
public interface BuildingMapper {
    public Collection<Building> findAll();
}
