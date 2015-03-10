package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.Block_room;

public interface BlockRoomMapper {
	
	public List<Block_room> getRoomByBlock(String block);
	
	public Block_room getRoomByName(String name);
	
}
