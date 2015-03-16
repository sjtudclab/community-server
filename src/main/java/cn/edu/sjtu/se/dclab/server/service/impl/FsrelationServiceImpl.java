package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.Fsrelation;
import cn.edu.sjtu.se.dclab.server.mapper.FsrelationMapper;
import cn.edu.sjtu.se.dclab.server.service.FsrelationService;

@Service
public class FsrelationServiceImpl implements FsrelationService{
	
	@Autowired
	private FsrelationMapper fsrelationMapper;

	public FsrelationMapper getFsrelationMapper() {
		return fsrelationMapper;
	}

	public void setFsrelationMapper(FsrelationMapper fsrelationMapper) {
		this.fsrelationMapper = fsrelationMapper;
	}
	
	@Override
	public String getRelationByActp(String actp){		
		System.out.println("+impl28++++++++++++++++++");
		// search by Active
		List<Fsrelation> temp = fsrelationMapper.getFsrelationByActp(actp);
		String t = "";
		for(int i = 0; i < temp.size(); i++)
		{
			t = t + temp.get(i).getPassp() + ",";
			System.out.println("+++"+temp.get(i).getActp()+"+++");
		}
		return t;
//		String Json_string = "[";
//		for(int i = 0; i < temp.size(); i++) 
//		{
//			if (actp.equals(temp.get(i).getActp())){
//				if (!Json_string.equals("["))
//					Json_string+=",";
//				Json_string = Json_string + "{\"passp\":";
//				Json_string = Json_string + "\""+temp.get(i).getPassp()+"\"}";
//			}
//		}
//		Json_string+="]";
//		if (temp.size() < 1)
//			return null;
//		return Json_string;
	}
	
	public List<Fsrelation> getFsrelationByPassp(String passp){
		return fsrelationMapper.getFsrelationByPassp(passp);  //search by Passive
	}
	
	public Fsrelation createFsrelation(Fsrelation fsrelation){
		return fsrelationMapper.createFsrelation(fsrelation);  //add relation
	}
	
	public void deleteFsrelationById(Integer id){
		;  //delete relation
	}
	
	public void updateFsrelationById(Integer id){
		;  //update relation
	}

}