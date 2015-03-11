package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.MailBox;

/**
 *2015年3月11日 下午7:31:01
 *@author changyi yuan
 */
public interface MailBoxService {
	public Collection<MailBox> getMailBoxByUserId(long id);
}
