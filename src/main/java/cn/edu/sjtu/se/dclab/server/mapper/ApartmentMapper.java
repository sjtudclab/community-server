package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.Apartment;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
public interface ApartmentMapper {
    public Collection<Apartment> findAll();
}
