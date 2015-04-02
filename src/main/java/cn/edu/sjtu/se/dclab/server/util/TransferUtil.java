package cn.edu.sjtu.se.dclab.server.util;

import cn.edu.sjtu.se.dclab.server.entity.Information;
import cn.edu.sjtu.se.dclab.server.transfer.MessageTransfer;

/**
 *2015年4月2日 下午4:46:53
 *@author changyi yuan
 */
public class TransferUtil {
	public static MessageTransfer convertInformationToMessageTransfer(
			Information information) {
		if (information == null)
			return new MessageTransfer();
		return new MessageTransfer(information.getInformationId(),
				information.getContent(), information.getSubmitTime());
	}
}
