package cn.edu.sjtu.se.dclab.server.util;

import java.util.ArrayList;
import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Information;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.transfer.FriendTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.MessageTransfer;

/**
 * 2015年4月2日 下午4:46:53
 *
 * @author changyi yuan
 */
public class TransferUtil {
	public static MessageTransfer convertInformationToMessageTransfer(
			Information information) {
		if (information == null)
			return new MessageTransfer();
		return new MessageTransfer(information.getInformationId(),
				information.getContent(), information.getSubmitTime());
	}

	public static FriendTransfer convertUserToFriendTransfer(User user) {
		if (user == null)
			return new FriendTransfer();
		FriendTransfer transfer = new FriendTransfer(user.getId(),
				user.getName(), user.getImage());
		return transfer;
	}
	public static Collection<FriendTransfer> convertUserToFriendTransfer(Collection<User> users){
		Collection<FriendTransfer> transfers = new ArrayList<FriendTransfer>();
		for (User user : users)
			transfers.add(convertUserToFriendTransfer(user));
		return transfers;
	}
} 
