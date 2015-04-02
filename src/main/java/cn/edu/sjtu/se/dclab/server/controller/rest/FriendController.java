package cn.edu.sjtu.se.dclab.server.controller.rest;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.common.Result;
import cn.edu.sjtu.se.dclab.server.entity.Information;
import cn.edu.sjtu.se.dclab.server.entity.InformationType;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.service.InformationService;
import cn.edu.sjtu.se.dclab.server.service.UserRelationService;
import cn.edu.sjtu.se.dclab.server.service.UserService;
import cn.edu.sjtu.se.dclab.server.transfer.ApplicationTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.FriendTransfer;

/**
 * 2015年4月2日 上午9:52:05
 *
 * @author changyi yuan
 */
@Controller
@RequestMapping(value = Constants.REST + "/friends")
public class FriendController {

	@Autowired
	private UserRelationService userRelationService;
	@Autowired
	private InformationService informationService;
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public InformationService getInformationService() {
		return informationService;
	}

	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}

	public UserRelationService getUserRelationService() {
		return userRelationService;
	}

	public void setUserRelationService(UserRelationService userRelationService) {
		this.userRelationService = userRelationService;
	}

	@RequestMapping(value = "{fromId}/relations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<FriendTransfer> getAllFriends(@PathVariable long fromId) {
		Collection<User> friends = userRelationService.findByFollowerIdAndType(
				fromId, Constants.RELATOIN_FRIEND);
		Collection<FriendTransfer> transfers = new ArrayList<FriendTransfer>();
		for (User user : friends)
			transfers.add(convertUserToFriendTransfer(user));
		return transfers;
	}

	@RequestMapping(value = "{fromId}/relations/{toId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public FriendTransfer getFriend(@PathVariable long fromId, @PathVariable long toId) {
		User user = userRelationService.findByFollowerIdAndType(fromId,toId,Constants.RELATOIN_FRIEND);
		return convertUserToFriendTransfer(user);
	}

	@RequestMapping(value = "{toId}/applications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<ApplicationTransfer> getFriendApplications(@PathVariable long toId){
		Collection<Information> informations = informationService.findByToIdAndType(toId,Constants.INFORMATION_ADD_FRIEND);
		User user = userService.getUserByUserId(toId);
		Collection<ApplicationTransfer> transfers = new ArrayList<ApplicationTransfer>();
		for(Information information : informations)
			transfers.add(convertUserAndInformationToApplicationTransfer(user, information));
		return transfers;
	}
	
	@RequestMapping(value = "{fromId}/applications/toId", method = RequestMethod.POST)
	@ResponseBody
	public String createFriendApplications(@PathVariable long fromId, @PathVariable long toId, @RequestBody String message){
		Information information = new Information();
		information.setFrom(fromId);
		information.setTo(toId);
		information.setContent(message);
		
		informationService.create(information,Constants.INFORMATION_ADD_FRIEND);
		
		return Result.SUCCESS;
	}
	
	@RequestMapping(value = "{fromId}/applications/{applicationId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String updateFriendApplications(@PathVariable long fromId, @PathVariable long applicationId){
		informationService.updateFriendApplicationById(applicationId);
		return "success";
	}
	
	private FriendTransfer convertUserToFriendTransfer(User user) {
		if(user == null)
			return new FriendTransfer();
		FriendTransfer transfer = new FriendTransfer(user.getId(),
				user.getName(), user.getImage());
		return transfer;
	}

	private ApplicationTransfer convertUserAndInformationToApplicationTransfer(User user, Information info){
		return new ApplicationTransfer(info.getInformationId(),user.getId(), user.getName(), user.getImage(), info.getContent());
	}
}
