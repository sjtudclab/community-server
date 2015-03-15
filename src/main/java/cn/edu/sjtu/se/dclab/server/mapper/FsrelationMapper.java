package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.Fsrelation;

public interface FsrelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fsrelation record);

    int insertSelective(Fsrelation record);

    Fsrelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fsrelation record);

    int updateByPrimaryKey(Fsrelation record);
}