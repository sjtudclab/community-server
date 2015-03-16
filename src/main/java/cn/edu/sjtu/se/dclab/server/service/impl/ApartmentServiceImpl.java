package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.Apartment;
import cn.edu.sjtu.se.dclab.server.mapper.ApartmentMapper;
import cn.edu.sjtu.se.dclab.server.service.ApartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentMapper apartmentMapper;

    public ApartmentMapper getApartmentMapper() {
        return apartmentMapper;
    }

    public void setApartmentMapper(ApartmentMapper apartmentMapper) {
        this.apartmentMapper = apartmentMapper;
    }

    @Override
    public Collection<Apartment> findAll() {
        return apartmentMapper.findAll();
    }

    @Override
    public Collection<Apartment> findAllByBuildingId(long id) {
        return apartmentMapper.findAllByBuildingId(id);
    }
}
