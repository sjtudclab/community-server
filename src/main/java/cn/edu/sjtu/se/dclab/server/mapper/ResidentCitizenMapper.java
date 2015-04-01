package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.ResidentCitizen;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/3/29.
 */
public interface ResidentCitizenMapper {

    public Collection<ResidentCitizen> findAll();

	public ResidentCitizen findById(long id);
}
