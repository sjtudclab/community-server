package cn.edu.sjtu.se.dclab.server.controller.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

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
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.entity.UserRelation;
import cn.edu.sjtu.se.dclab.server.service.InformationService;
import cn.edu.sjtu.se.dclab.server.service.UserRelationService;
import cn.edu.sjtu.se.dclab.server.service.UserService;
import cn.edu.sjtu.se.dclab.server.transfer.FriendTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.MessageTransfer;
import cn.edu.sjtu.se.dclab.server.util.DataUtil;
import cn.edu.sjtu.se.dclab.server.util.TransferUtil;

/**
 * 2015年4月2日 下午7:41:19
 *
 * @author changyi yuan
 */
@Controller
@RequestMapping(value = Constants.REST + "/circles")
public class CircleController {
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

	@RequestMapping(value = "{userId}/users/{attentionId}", method = RequestMethod.POST)
	@ResponseBody
	public String addAttention(@PathVariable long userId,
			@PathVariable long attentionId) {
		UserRelation relation = new UserRelation();
		relation.setFollowerId(userId);
		relation.setFollowedId(attentionId);
		userRelationService.createAttention(relation);
		return Result.SUCCESS;
	}

	@RequestMapping(value = "{userId}/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<FriendTransfer> getFollowings(@PathVariable long userId) {
		Collection<User> relations = userRelationService
				.findByFollowerIdAndType(userId, Constants.RELATION_CIRCLE);
		return TransferUtil.convertUserToFriendTransfer(relations);
	}

	@RequestMapping(value = "{userId}/users/0", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<FriendTransfer> getFolloweds(@PathVariable long userId) {
		Collection<User> relations = userRelationService.findFollowedIdAndType(
				userId, Constants.RELATION_CIRCLE);
		return TransferUtil.convertUserToFriendTransfer(relations);
	}

	@RequestMapping(value = "{userId}/messages/{startId}/forward/counts/{count}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<MessageTransfer> getFowardMessages(@PathVariable long userId,
			@PathVariable long startId, @PathVariable long count) {
		Collection<Information> infos = informationService.findByFromIdAndType(
				userId, Constants.INFORMATION_CIRCLE_MESSAGE, startId, count, Constants.MESSAGE_FORWARD);
		Collection<MessageTransfer> transfers = new ArrayList<MessageTransfer>();
		for (Information info : infos){
			User user = userService.getUserByUserId(info.getFrom());
			transfers.add(TransferUtil
					.convertInformationAndUserToMessageTransfer(info,user));
		}
		return transfers;
	}
	
	@RequestMapping(value = "{userId}/messages/{startId}/back/counts/{count}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<MessageTransfer> getBackMessages(@PathVariable long userId,
			@PathVariable long startId, @PathVariable long count) {
		Collection<Information> infos = informationService.findByFromIdAndType(
				userId, Constants.INFORMATION_CIRCLE_MESSAGE, startId, count, Constants.MESSAGE_BACK);
		Collection<MessageTransfer> transfers = new ArrayList<MessageTransfer>();
		for (Information info : infos){
			User user = userService.getUserByUserId(info.getFrom());
			transfers.add(TransferUtil
					.convertInformationAndUserToMessageTransfer(info,user));
		}
		return transfers;
	}
	
	@RequestMapping(value = "{userId}/messages", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MessageTransfer sendMessage(@PathVariable long userId, @RequestBody String message){
		Map<String,Object> map = DataUtil.getFromJson(message);
		Information information = new Information();
		information.setFrom(userId);
		information.setContent((String)map.get("message"));
		information.setStatus(Constants.INFORMATION_DONE_STATUS);
		information.setSubmitTime(new Date());
		informationService.create(information, Constants.INFORMATION_CIRCLE_MESSAGE);
		
		MessageTransfer transfer = new MessageTransfer();
		transfer.setMessageId(information.getId());
		
		return transfer;
	}
}
