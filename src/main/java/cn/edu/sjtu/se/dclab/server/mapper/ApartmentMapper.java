package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.Apartment;
import cn.edu.sjtu.se.dclab.server.entity.Citizen;
import cn.edu.sjtu.se.dclab.server.entity.ResidentCitizen;
import cn.edu.sjtu.se.dclab.server.entity.User;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/13.
 */
public interface ApartmentMapper {
    public Collection<Apartment> findAll();

    public Collection<Apartment> findAllByBuildingId(long buildingId);

    public Collection<ResidentCitizen> findAllCitizenByApartmentId(long id);
}
