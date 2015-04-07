package cn.edu.sjtu.se.dclab.server.mapper;

import java.util.List;

import cn.edu.sjtu.se.dclab.server.entity.TenementManage;
import cn.edu.sjtu.se.dclab.server.entity.TenementServiceman;

public interface TenementManageMapper {
	
	public void createServiceManage(TenementManage tmp);
	
	public List<TenementServiceman> getServicemanInfo(String stage);

}
