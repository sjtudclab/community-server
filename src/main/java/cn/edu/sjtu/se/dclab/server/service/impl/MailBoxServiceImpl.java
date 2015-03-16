package cn.edu.sjtu.se.dclab.server.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import cn.edu.sjtu.se.dclab.server.mapper.UserMapper;
import cn.edu.sjtu.se.dclab.server.transfer.MailBoxTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.MailBoxUserTransfer;
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

	@Autowired
	private UserMapper userMapper;
	
	public MailBoxMapper getMailBoxMapper() {
		return mailBoxMapper;
	}

	public void setMailBoxMapper(MailBoxMapper mailBoxMapper) {
		this.mailBoxMapper = mailBoxMapper;
	}

	/*
	@Override
	public Collection<MailBoxTransfer> getMailBoxByUserId(long id) {
		return mailBoxMapper.findAllByUser(id);
	}
	*/

	@Override
	public Collection<MailBoxTransfer> getMailBoxByUserIdAndMailStatus(long id, String status) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", id);
		params.put("status", status);
		Collection<MailBox> mailBoxes = mailBoxMapper.findAllByUserIdAndMailStatus(params);

		Collection<MailBoxTransfer> mailBoxTransfers = new ArrayList<MailBoxTransfer>();
		for (MailBox mailBox : mailBoxes) {
			MailBoxTransfer mailBoxTransfer = new MailBoxTransfer();
			mailBoxTransfer.setId(mailBox.getId());
			mailBoxTransfer.setContent(mailBox.getContent());
			mailBoxTransfer.setStatus(mailBox.getStatus());
			mailBoxTransfer.setSubmitedDate(mailBox.getSubmitedDate());

			MailBoxUserTransfer fromTransfer = new MailBoxUserTransfer(userMapper.findByUserId(mailBox.getFrom().getId()));
			MailBoxUserTransfer toTransfer = new MailBoxUserTransfer(userMapper.findByUserId(mailBox.getTo().getId()));
			mailBoxTransfer.setFrom(fromTransfer);
			mailBoxTransfer.setTo(toTransfer);

			mailBoxTransfers.add(mailBoxTransfer);
		}

		return mailBoxTransfers;
	}

	@Override
	public void createMailBox(MailBox mailBox) {
		mailBox.setStatus("待办");
		mailBoxMapper.save(mailBox);
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
}
