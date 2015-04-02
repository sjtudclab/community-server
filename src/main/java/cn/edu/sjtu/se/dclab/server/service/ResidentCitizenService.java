package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.ResidentCitizen;
import cn.edu.sjtu.se.dclab.server.transfer.ResidentCitizenTransfer;

/**
 * Created by Huiyi on 2015/3/30.
 */
public interface ResidentCitizenService {

    public Collection<ResidentCitizen> findAll();

	public ResidentCitizenTransfer findById(long id);

	public ResidentCitizenService findByUserId(long userId);
    
}
