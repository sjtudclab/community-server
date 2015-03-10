package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.Block_info;

public interface BlockInfoMapper {
	
	public List<Block_info> getInfoByManager(String manager);
	
}
