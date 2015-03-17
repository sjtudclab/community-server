package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Apartment;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.transfer.ApartmentTransfer;

/**
 * Created by Huiyi on 2015/3/13.
 */
public interface ApartmentService {
    public Collection<ApartmentTransfer> findAll();

    public Collection<Apartment> findAllByBuildingId(long id);

    public Collection<User> findAllUserByApartmentId(long id);
}
