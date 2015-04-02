package cn.edu.sjtu.se.dclab.server.service;

import cn.edu.sjtu.se.dclab.server.entity.ServiceCitizen;
import cn.edu.sjtu.se.dclab.server.transfer.ServiceCitizenTransfer;

/**
 * Created by Huiyi on 2015/3/30.
 */
public interface ServiceCitizenService {

	public ServiceCitizenTransfer findById(long id);

	public ServiceCitizen findByUserId(long userId);
    
}
