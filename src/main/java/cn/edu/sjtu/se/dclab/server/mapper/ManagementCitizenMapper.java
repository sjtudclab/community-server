package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import cn.edu.sjtu.se.dclab.server.entity.ManagementCitizen;

/**
 * Created by Huiyi on 2015/3/29.
 */
public interface ManagementCitizenMapper {

	public Collection<ManagementCitizen> findAll();

	public ManagementCitizen findById(long id);

	public ManagementCitizen findByUserId(@Param("userId") long userId);
	
}
