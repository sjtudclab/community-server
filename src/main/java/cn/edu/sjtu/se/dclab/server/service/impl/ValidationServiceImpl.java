package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.mapper.ValidationMapper;
import cn.edu.sjtu.se.dclab.server.service.UserGroupService;
import cn.edu.sjtu.se.dclab.server.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Huiyi on 2015/5/30.
 */
@Service
public class ValidationServiceImpl implements ValidationService {

    private static final String TRUE = "true";
    private static final String FALSE = "false";

    private final ValidationMapper validationMapper;

    @Autowired
    public ValidationServiceImpl(final ValidationMapper validationMapper) {
        this.validationMapper = validationMapper;
    }

    @Override
    public String validateRelation(Map<String, Integer> params) {
        int from = params.get("from");
        int to = params.get("to");

        String result;
        switch (params.get("type")) {
            case 1: // friend chat
                result = validateFriendRelation(from, to);
                break;
            case 2: // group chat
                result = validateGroupRelation(from, to);
                break;
            default:
                result = FALSE;
        }

        return result;
    }

    private String validateFriendRelation(int fromUserId, int toUserId) {
        return validationMapper.checkIsFriends(fromUserId, toUserId) > 0 ? TRUE : FALSE;
    }

    private String validateGroupRelation(int userId, int groupId) {
        return validationMapper.checkBelongsToGroup(userId, groupId) == 1 ? TRUE : FALSE;
    }
}
