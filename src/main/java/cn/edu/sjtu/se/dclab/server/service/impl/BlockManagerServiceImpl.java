package cn.edu.sjtu.se.dclab.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Block_manager;
import cn.edu.sjtu.se.dclab.server.mapper.BlockManagerMapper;
import cn.edu.sjtu.se.dclab.server.service.BlockManagerService;

@Service
public class BlockManagerServiceImpl implements BlockManagerService {
	@Autowired
	private BlockManagerMapper blockmanagerMapper;

	public BlockManagerMapper getBlockManagerMapper() {
		return blockmanagerMapper;
	}

	public void setBlockManagerMapper(BlockManagerMapper blockmanagerMapper) {
		this.blockmanagerMapper = blockmanagerMapper;
	}
	
	@Override
	public String getManagerByName(String name) {
		Block_manager bm = blockmanagerMapper.getManagerByName(name);
		String Json_string = "{\"name\" : \"" + bm.getName() + "\"," +
							 "\"password\" : \"" + bm.getPassword() + "\"," +
							 "\"description\" : \"" + bm.getDescription() + "\"";

		Json_string+="}";
		//if (bm.getName() != name)
		//	return null;
		return Json_string;
	}

}
