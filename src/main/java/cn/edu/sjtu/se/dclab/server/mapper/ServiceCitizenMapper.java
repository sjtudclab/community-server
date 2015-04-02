package cn.edu.sjtu.se.dclab.server.mapper;

import org.apache.ibatis.annotations.Param;

import cn.edu.sjtu.se.dclab.server.entity.ServiceCitizen;

/**
 * Created by Huiyi on 2015/3/29.
 */
public interface ServiceCitizenMapper {

	public ServiceCitizen findById(long id);

	public ServiceCitizen findByUserId(@Param("userId") long userId);
}
