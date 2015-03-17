package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Fsrelation;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.mapper.FsrelationMapper;
import cn.edu.sjtu.se.dclab.server.mapper.UserMapper;
import cn.edu.sjtu.se.dclab.server.service.FsrelationService;
import cn.edu.sjtu.se.dclab.server.transfer.FsrelationTransfer;

@Service
public class FsrelationServiceImpl implements FsrelationService{
	
	@Autowired
	private FsrelationMapper fsrelationMapper;
	@Autowired
	private UserMapper userMapper;

	public FsrelationMapper getFsrelationMapper() {
		return fsrelationMapper;
	}

	public void setFsrelationMapper(FsrelationMapper fsrelationMapper) {
		this.fsrelationMapper = fsrelationMapper;
	}
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public FsrelationTransfer getRelationByActp(Long actp){		
		return getRelations(actp,true);
	}
	
	public FsrelationTransfer getRelationByPassp(Long passp){
		return getRelations(passp,false);
	}
	
	private FsrelationTransfer getRelations(long id,boolean isActp){
		List<Fsrelation> temp = null;
		if(isActp)
			temp = fsrelationMapper.getFsrelationByActp(id);
		else
			temp = fsrelationMapper.getFsrelationByPassp(id);
		
		Fsrelation actp = temp.get(0);
		User user = null;
		FsrelationTransfer fsrelationTransfer = new FsrelationTransfer();
		if(actp != null){
			if(isActp)
				user = userMapper.findByUserId(actp.getActp());
			else
				user = userMapper.findByUserId(actp.getPassp());
			if(user != null){
				fsrelationTransfer.setName(user.getUsername()); 
				List<String> fNames = new ArrayList<String>();
				fsrelationTransfer.setfNames(fNames);
				for(Fsrelation fsrelation : temp){
					user = null;
					if(!isActp)
						user = userMapper.findByUserId(fsrelation.getActp());
					else
						user = userMapper.findByUserId(fsrelation.getPassp());
					if(user != null)
						fNames.add(user.getUsername());
				}
			}
		}
		return fsrelationTransfer;
	}
	
	public void createFsrelation(Fsrelation fsrelation){
		fsrelationMapper.createFsrelation(fsrelation);  //add relation
	}
	
	public void deleteFsrelationById(Integer id){
		;  //delete relation
	}
	
	public void updateFsrelationById(Integer id){
		;  //update relation
	}

}