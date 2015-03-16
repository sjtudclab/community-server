package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.Building;
import cn.edu.sjtu.se.dclab.server.mapper.BuildingMapper;
import cn.edu.sjtu.se.dclab.server.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/16.
 */
@Component
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public Collection<Building> findAll() {
        return buildingMapper.findAll();
    }

    public BuildingMapper getBuildingMapper() {
        return buildingMapper;
    }

    public void setBuildingMapper(BuildingMapper buildingMapper) {
        this.buildingMapper = buildingMapper;
    }
}
