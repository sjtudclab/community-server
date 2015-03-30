package cn.edu.sjtu.se.dclab.server.entity.deserializer;

import cn.edu.sjtu.se.dclab.server.entity.Topic;
import cn.edu.sjtu.se.dclab.server.entity.TopicOption;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Huiyi on 2015/3/30.
 */
public class TopicDeserializer extends JsonDeserializer<Topic> {

    @Override
    public Topic deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Topic topic = new Topic();
        //topic.setName(node.get("name").asText());
        topic.setContent(node.get("content").asText());
        //topic.setDesc(node.get("desc").asText());
        topic.setAttachment(node.get("attachment").asText());
        //topic.setStartTime(new Date(node.get("start_time").asLong()));
        //topic.setEndTime(new Date(node.get("end_time").asLong()));
        //topic.setParentTopicId(node.get("parent_topic_id").asLong());
        topic.setTopicTypeId(node.get("topic_type_id").asLong());
        topic.setVoteCount(0);

        String[] options = node.get("options").asText().split(",");
        Collection<TopicOption> tos = new ArrayList<>();

        for (String option : options) {
            TopicOption to = new TopicOption();
            to.setName(option);

            tos.add(to);
        }
        topic.setOptions(tos);

        return topic;
    }
}
