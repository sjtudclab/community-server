package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import cn.edu.sjtu.se.dclab.server.entity.Information;

public interface InformationMapper {

	public Collection<Information> findAllByType(int type);
	
	public Collection<Information> findById(long id, int type);
	
	public Collection<Information> findByKeyword(@Param(value = "keyword") String keyword);
	
	public void save(Information information);

}
