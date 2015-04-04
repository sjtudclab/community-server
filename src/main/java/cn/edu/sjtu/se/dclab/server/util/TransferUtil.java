package cn.edu.sjtu.se.dclab.server.util;

import java.util.ArrayList;
import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.Information;
import cn.edu.sjtu.se.dclab.server.entity.ManagementCitizen;
import cn.edu.sjtu.se.dclab.server.entity.ResidentCitizen;
import cn.edu.sjtu.se.dclab.server.entity.ServiceCitizen;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.transfer.CitizenTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.FriendTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.MessageTransfer;

/**
 * 2015年4月2日 下午4:46:53
 *
 * @author changyi yuan
 */
public class TransferUtil {
	public static MessageTransfer convertInformationAndUserToMessageTransfer(
			Information information, User user) {
		if (information == null)
			return new MessageTransfer();
		return new MessageTransfer(information.getId(),
				information.getContent(), information.getSubmitTime(),
				user.getId(), user.getName(), user.getImage());
	}

	public static FriendTransfer convertUserToFriendTransfer(User user) {
		if (user == null)
			return new FriendTransfer();
		FriendTransfer transfer = new FriendTransfer(user.getId(),
				user.getName(), user.getImage());
		return transfer;
	}

	public static Collection<FriendTransfer> convertUserToFriendTransfer(
			Collection<User> users) {
		Collection<FriendTransfer> transfers = new ArrayList<FriendTransfer>();
		for (User user : users)
			transfers.add(convertUserToFriendTransfer(user));
		return transfers;
	}

	public static CitizenTransfer convertUserAndCitizenToCitizenTransfer(
			User user, ManagementCitizen citizen) {
		return new CitizenTransfer(user.getId(), citizen.getId(),
				user.getUsername(), user.getImage(), user.getName(),
				citizen.getName(), citizen.getGender(), citizen.getAge(),
				citizen.getPhone(), user.getEmail(),
				(user.getIdentityNumber() != null)&&(user.getIdentityNumber().length()!=0));
	}

	public static CitizenTransfer convertUserAndCitizenToCitizenTransfer(
			User user, ResidentCitizen citizen) {
		return new CitizenTransfer(user.getId(), citizen.getId(),
				user.getUsername(), user.getImage(), user.getName(),
				citizen.getName(), citizen.getGender(), citizen.getAge(),
				citizen.getPhone(), user.getEmail(),
				(user.getIdentityNumber() != null)&&(user.getIdentityNumber().length()!=0));
	}

	public static CitizenTransfer convertUserAndCitizenToCitizenTransfer(
			User user, ServiceCitizen citizen) {
		if(user == null || citizen == null)
			return new CitizenTransfer();
		return new CitizenTransfer(user.getId(), citizen.getId(),
				user.getUsername(), user.getImage(), user.getName(),
				citizen.getName(), citizen.getGender(), citizen.getAge(),
				citizen.getPhone(), user.getEmail(),
				(user.getIdentityNumber() != null)&&(user.getIdentityNumber().length()!=0));
	}
}
