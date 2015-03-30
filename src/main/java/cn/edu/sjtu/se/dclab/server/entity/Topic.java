package cn.edu.sjtu.se.dclab.server.entity;

import cn.edu.sjtu.se.dclab.server.entity.deserializer.TopicDeserializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Collection;
import java.util.Date;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "topic_id")
@JsonDeserialize(using = TopicDeserializer.class)
public class Topic {

	@JsonProperty(value = "topic_id")
	private long topicId;

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "content")
	private String content;

	@JsonProperty(value = "desc")
	private String desc;

	@JsonProperty(value = "vote_count")
	private long voteCount;

	@JsonProperty(value = "start_time")
	private Date startTime;

	@JsonProperty(value = "end_time")
	private Date endTime;

	@JsonProperty(value = "topic_type_id")
	private long topicTypeId;

	@JsonProperty(value = "parent_topic_id")
	private long parentTopicId;

	@JsonProperty(value = "attachment")
	private String attachment;

	@JsonProperty(value = "options")
	private Collection<TopicOption> options;
	
	public void setTopicId(long id) {
		this.topicId = id;
	}
	public long getTopicId() {
		return this.topicId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return this.content;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return this.desc;
	}
	
	public void setVoteCount(long voteCount) {
		this.voteCount = voteCount;
	}
	public long getVoteCount() {
		return this.voteCount;
	}
	
	public void setStartTime(Date time) {
		this.startTime = time;
	}
	public Date getStartTime(Date time) {
		return this.getStartTime();
	}
	
	public void setEndTime(Date time) {
		this.endTime = time;
	}
	public Date getEndTime() {
		return this.endTime;
	}
	
	public void setTopicTypeId(long id) {
		this.topicTypeId = id;
	}
	public long getTopicTypeId() {
		return this.topicTypeId;
	}
	
	public void setParentTopicId(long id) {
		this.parentTopicId = id;
	}
	public long getParentTopicId() {
		return this.parentTopicId;
	}
	
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getAttachment() {
		return this.attachment;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Collection<TopicOption> getOptions() {
		return options;
	}

	public void setOptions(Collection<TopicOption> options) {
		this.options = options;
	}
}
