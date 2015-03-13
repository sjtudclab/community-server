package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.Citizen;
import cn.edu.sjtu.se.dclab.server.mapper.CitizenMapper;
import cn.edu.sjtu.se.dclab.server.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    private CitizenMapper citizenMapper;

    public CitizenMapper getCitizenMapper() {
        return citizenMapper;
    }

    public void setCitizenMapper(CitizenMapper citizenMapper) {
        this.citizenMapper = citizenMapper;
    }

    @Override
    public Collection<Citizen> findAll() {
        return citizenMapper.findAll();
    }
}
