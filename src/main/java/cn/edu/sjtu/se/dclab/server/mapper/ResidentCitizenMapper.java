package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.ResidentCitizen;
import cn.edu.sjtu.se.dclab.server.service.ResidentCitizenService;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Huiyi on 2015/3/29.
 */
public interface ResidentCitizenMapper {

    public Collection<ResidentCitizen> findAll();

	public ResidentCitizen findById(long id);

	public ResidentCitizen findByUserId(@Param("userId") long userId);
}
