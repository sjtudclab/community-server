package cn.edu.sjtu.se.dclab.server.service;

import java.util.Collection;

import cn.edu.sjtu.se.dclab.server.entity.Information;

public interface InformationService {
	public Collection<Information> findAllByType(int type);
	
	public Collection<Information> findById(long id, int type);
	public Collection<Information> findByKeyword(String keyword);
	
	public void save(Information information);
	public void blockById(long id);

	public Collection<Information> findByFromIdAndType(long fromId,String type,long startId,long count);
	public Collection<Information> findByFromIdAndType(long fromId, String type);

	public void updateFriendApplicationById(long informationId);

	public void create(Information information, String type);

	public Collection<Information> findByToIdAndType(long toId,
			String type);
	public Collection<Information> findByToIdAndType(long toId,String type,long startId,long count);

	public Collection<Information> findChats(long userId, long friendId,
			long startId, long count);
	
}
