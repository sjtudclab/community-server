package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Block_info;
import cn.edu.sjtu.se.dclab.server.mapper.BlockInfoMapper;
import cn.edu.sjtu.se.dclab.server.service.BlockInfoService;

@Service
public class BlockInfoServiceImpl implements BlockInfoService {
	
	@Autowired
	public BlockInfoMapper blockinfoMapper;

	public BlockInfoMapper getBlockManagerMapper() {
		return blockinfoMapper;
	}

	public void setBlockInfoMapper(BlockInfoMapper blockinfoMapper) {
		this.blockinfoMapper = blockinfoMapper;
	}

	@Override
	public String getInfoByManager(String manager) {
		List<Block_info> temp = blockinfoMapper.getInfoByManager(manager);
		String Json_string = "{\"block\" : [";
		for(int i = 0; i < temp.size(); i++) 
		{
			if (i>0)
				Json_string+=",";
			Json_string = Json_string + "{\"name\":";
			Json_string = Json_string + "\""+temp.get(i).getName()+"\"}";
		}
		Json_string+="]}";
		if (temp.size() < 1)
			return null;
		// TODO Auto-generated method stub
		return Json_string;
	}
	
	
}
