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
import cn.edu.sjtu.se.dclab.server.entity.Group;
import cn.edu.sjtu.se.dclab.server.entity.Information;
import cn.edu.sjtu.se.dclab.server.entity.User;
import cn.edu.sjtu.se.dclab.server.entity.UserGroup;
import cn.edu.sjtu.se.dclab.server.service.GroupService;
import cn.edu.sjtu.se.dclab.server.service.InformationService;
import cn.edu.sjtu.se.dclab.server.service.UserGroupService;
import cn.edu.sjtu.se.dclab.server.service.UserService;
import cn.edu.sjtu.se.dclab.server.transfer.GroupTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.MessageTransfer;
import cn.edu.sjtu.se.dclab.server.util.DataUtil;
import cn.edu.sjtu.se.dclab.server.util.TransferUtil;

/**
 * 2015年4月2日 下午3:06:01
 *
 * @author changyi yuan
 */
@Controller
@RequestMapping(value = Constants.REST + "/groups")
public class GroupController {

	@Autowired
	private GroupService groupService;
	@Autowired
	private UserGroupService userGroupService;
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

	public UserGroupService getUserGroupService() {
		return userGroupService;
	}

	public void setUserGroupService(UserGroupService userGroupService) {
		this.userGroupService = userGroupService;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	@RequestMapping(value = "0/users/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<GroupTransfer> getGroups(@PathVariable long userId) {
		Collection<Group> groups = groupService.findByUserId(userId);
		Collection<GroupTransfer> transfers = new ArrayList<GroupTransfer>();
		for (Group group : groups)
			transfers.add(convertGroupToGroupTransfer(group));
		return transfers;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String createGroup(@RequestBody String groupInfo) {
		Map<String, Object> map = DataUtil.getFromJson(groupInfo);
		long userId = Integer.parseInt(map.get("userId").toString());
		String name = (String) map.get("name");
		Group group = new Group();
		group.setName(name);
		group.setOwner(userId);
		group.setCount(1);
		group.setCreateTime(new Date());

		groupService.create(group);
		return Result.SUCCESS;
	}

	@RequestMapping(value = "/{groupId}/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addIntoGroup(@PathVariable long groupId, @RequestBody String str) {
		Map<String,Object> map = DataUtil.getFromJson(str);
		Collection<Integer> userIds = (Collection<Integer>)map.get("userIds");
		Collection<UserGroup> groups = new ArrayList<UserGroup>();
		for(int userId : userIds){
			UserGroup userGroup = new UserGroup();
			userGroup.setGroupId(groupId);
			userGroup.setUserId(userId);
			groups.add(userGroup);
		}

		userGroupService.createGroups(groups);
		return Result.SUCCESS;
	}

	@RequestMapping(value = "{groupId}/users/{userId}/messages/{startId}/forward/counts/{count}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<MessageTransfer> getForwardMessages(
			@PathVariable long groupId, @PathVariable long userId,
			@PathVariable long startId, @PathVariable long count) {
		Collection<Information> infos = informationService.findByToIdAndType(
				groupId, Constants.INFROMATION_GROUP_MESSAGE, startId, count,
				Constants.MESSAGE_FORWARD);
		Collection<MessageTransfer> transfers = new ArrayList<MessageTransfer>();
		for (Information info : infos) {
			User user = userService.getUserByUserId(info.getFrom());
			transfers.add(TransferUtil
					.convertInformationAndUserToMessageTransfer(info, user));
		}
		return transfers;
	}
	
	@RequestMapping(value = "{groupId}/users/{userId}/messages/{startId}/back/counts/{count}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<MessageTransfer> getBackMessages(
			@PathVariable long groupId, @PathVariable long userId,
			@PathVariable long startId, @PathVariable long count) {
		Collection<Information> infos = informationService.findByToIdAndType(
				groupId, Constants.INFROMATION_GROUP_MESSAGE, startId, count,
				Constants.MESSAGE_BACK);
		Collection<MessageTransfer> transfers = new ArrayList<MessageTransfer>();
		for (Information info : infos) {
			User user = userService.getUserByUserId(info.getFrom());
			transfers.add(TransferUtil
					.convertInformationAndUserToMessageTransfer(info, user));
		}
		return transfers;
	}

	@RequestMapping(value = "{groupId}/users/{userId}/messages", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MessageTransfer sendMessage(@PathVariable long groupId,
			@PathVariable long userId, @RequestBody String message) {
		Map<String, Object> map = DataUtil.getFromJson(message);
		Information information = new Information();
		information.setFrom(userId);
		information.setTo(groupId);
		information.setContent((String) map.get("message"));
		information.setStatus(Constants.INFORMATION_DONE_STATUS);
		information.setSubmitTime(new Date());
		informationService.create(information,
				Constants.INFROMATION_GROUP_MESSAGE);
		
		MessageTransfer transfer = new MessageTransfer();
		transfer.setMessageId(information.getId());
		
		return transfer;
	}
	
	@RequestMapping(value = "/{groupId}/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<Long> getUsers(@PathVariable long groupId){
		return groupService.findUsersById(groupId);
	}

	private GroupTransfer convertGroupToGroupTransfer(Group group) {
		if (group == null)
			return new GroupTransfer();
		return new GroupTransfer(group.getId(), group.getName(),
				group.getCount(), group.getOwner());
	}

	@RequestMapping(value = "/{groupId}/memberlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<User> getMemberlist(@PathVariable long groupId){
		return groupService.findMemberlistById(groupId);
	}
}
