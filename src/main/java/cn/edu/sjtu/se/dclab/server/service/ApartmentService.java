package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.Apartment;
import cn.edu.sjtu.se.dclab.server.entity.User;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
public interface ApartmentService {
    public Collection<Apartment> findAll();

    public Collection<Apartment> findAllByBuildingId(long id);

    public Collection<User> findAllUserByApartmentId(long id);
}
