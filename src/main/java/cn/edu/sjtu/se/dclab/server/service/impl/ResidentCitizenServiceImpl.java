package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.ResidentCitizen;
import cn.edu.sjtu.se.dclab.server.mapper.ResidentCitizenMapper;
import cn.edu.sjtu.se.dclab.server.service.ResidentCitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/30.
 */
@Service
public class ResidentCitizenServiceImpl implements ResidentCitizenService {

    private final ResidentCitizenMapper rcMapper;

    @Autowired
    public ResidentCitizenServiceImpl(ResidentCitizenMapper rcMapper) {
        this.rcMapper = rcMapper;
    }

    @Override
    public Collection<ResidentCitizen> findAll() {
        return rcMapper.findAll();
    }
}
