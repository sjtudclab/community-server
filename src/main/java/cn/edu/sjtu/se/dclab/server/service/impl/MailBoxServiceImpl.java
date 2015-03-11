package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.se.dclab.server.entity.MailBox;
import cn.edu.sjtu.se.dclab.server.mapper.MailBoxMapper;
import cn.edu.sjtu.se.dclab.server.service.MailBoxService;

/**
 *2015年3月11日 下午7:32:03
 *@author changyi yuan
 */
@Service
public class MailBoxServiceImpl implements MailBoxService {
	@Autowired
	private MailBoxMapper mailBoxMapper;
	
	public MailBoxMapper getMailBoxMapper() {
		return mailBoxMapper;
	}

	public void setMailBoxMapper(MailBoxMapper mailBoxMapper) {
		this.mailBoxMapper = mailBoxMapper;
	}

	@Override
	public Collection<MailBox> getMailBoxByUserId(long id) {
		return mailBoxMapper.findAllByUser(id);
	}

}
