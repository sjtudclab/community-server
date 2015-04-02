package cn.edu.sjtu.se.dclab.server.controller.rest;

import java.util.ArrayList;
import java.util.Collection;
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
import cn.edu.sjtu.se.dclab.server.entity.UserGroup;
import cn.edu.sjtu.se.dclab.server.service.GroupService;
import cn.edu.sjtu.se.dclab.server.service.UserGroupService;
import cn.edu.sjtu.se.dclab.server.transfer.GroupTransfer;
import cn.edu.sjtu.se.dclab.server.util.DataUtil;

/**
 *2015年4月2日 下午3:06:01
 *@author changyi yuan
 */
@Controller
@RequestMapping(value = Constants.REST + "/groups")
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	@Autowired
	private UserGroupService userGroupService;
	
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
	public Collection<GroupTransfer> getGroups(@PathVariable long userId){
		Collection<Group> groups = groupService.findByUserId(userId);
		Collection<GroupTransfer> transfers = new ArrayList<GroupTransfer>();
		for(Group group : groups)
			transfers.add(convertGroupToGroupTransfer(group));
		return transfers;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String createGroup(@RequestBody String groupInfo){
		Map<String,String> map = DataUtil.getFromJson(groupInfo);
		long userId = Long.valueOf(map.get("userId"));
		String name = map.get("name");
		Group group = new Group();
		group.setName(name);
		group.setOwner(userId);
		group.setCount(1);
		
		groupService.create(group);
		return Result.SUCCESS;
	}
	
	@RequestMapping(value = "/{groupId}/users/{userId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addIntoGroup(@PathVariable long groupId, @PathVariable long userId){
		UserGroup userGroup = new UserGroup();
		userGroup.setGourId(groupId);
		userGroup.setUserId(userId);
		
		userGroupService.create(userGroup);
		return Result.SUCCESS;
	}
	private GroupTransfer convertGroupToGroupTransfer(Group group) {
		if(group == null)
			return new GroupTransfer();		
		return new GroupTransfer(group.getId(),group.getName(),group.getCount(),group.getOwner());
	}

}
