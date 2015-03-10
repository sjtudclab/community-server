package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Block_room;
import cn.edu.sjtu.se.dclab.server.mapper.BlockRoomMapper;
import cn.edu.sjtu.se.dclab.server.service.BlockRoomService;

@Service
public class BlockRoomServiceImpl implements BlockRoomService {
	@Autowired
	private BlockRoomMapper blockroomMapper;

	public BlockRoomMapper getBlockManagerMapper() {
		return blockroomMapper;
	}

	public void setBlockRoomMapper(BlockRoomMapper blockroomMapper) {
		this.blockroomMapper = blockroomMapper;
	}
	
	@Override
	public String getRoomByBlock(String block) {
		List<Block_room> temp = blockroomMapper.getRoomByBlock(block);
		String Json_string = "{\"room\" : [";
		for(int i = 0; i < temp.size(); i++) 
		{
			if (i>0)
				Json_string+=",";
			String[] arr = temp.get(i).getName().split("-");
			Json_string = Json_string + "{\"name\":";
			Json_string = Json_string + "\""+arr[1]+"\"}";
		}
		Json_string+="]}";
		if (temp.size() < 1)
			return null;
		return Json_string;

	}

	@Override
	public String getRoomByName(String name) {
		Block_room temp = blockroomMapper.getRoomByName(name);
		String Json_string = "{\"room\" : \"" + temp.getName() + 
							 "\",\"info\" : \"" + temp.getInfo() + 
							 "\",\"number\" : \"" + temp.getNumber().toString() +
							 "\",\"block\" : \"" + temp.getBlock() + "\"}";
		if (temp.getBlock() == null)
			return null;
		return Json_string;
	}
	

}
