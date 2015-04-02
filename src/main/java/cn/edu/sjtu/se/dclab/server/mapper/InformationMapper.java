package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import cn.edu.sjtu.se.dclab.server.entity.Information;

public interface InformationMapper {

	public Collection<Information> findAllByType(int type);

	public Collection<Information> findById(long id, int type);

	public Collection<Information> findByKeyword(
			@Param(value = "keyword") String keyword);

	public void save(Information information);

	public void blockById(long id);

	public Collection<Information> findByFromIdAndType(
			@Param("fromId") long fromId, @Param("type") String type);
	public Collection<Information> findByToIdAndType(
			@Param("toId") long toId, @Param("type") String type);

	public Information findByIdAndType(
			@Param("informationId") long informationId,
			@Param("type") String type);
}
