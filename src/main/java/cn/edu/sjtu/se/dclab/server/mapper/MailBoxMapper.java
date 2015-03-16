package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.MailBox;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Huiyi on 2015/3/11.
 */
public interface MailBoxMapper {

    public Collection<MailBox> findAllByUser(long userId);

    public Collection<MailBox> findAllByUserIdAndMailStatus(Map<String, Object> params);

    public void save(MailBox mailBox);
}
