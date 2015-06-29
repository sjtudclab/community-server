package cn.edu.sjtu.se.dclab.server.entity.deserializer;

import cn.edu.sjtu.se.dclab.server.entity.Payment;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Huiyi on 2015/6/29.
 */
public class PaymentDeserializer extends JsonDeserializer<Payment> {

    @Override
    public Payment deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);

        return deserialize(root);
    }

    public static Payment deserialize(JsonNode root) {
        Payment payment = new Payment();

        JsonNode body = root.get("payment");
        payment.setCardId(body.get("card_id").asText());
        payment.setDeviceId(body.get("device_id").asText());
        payment.setSum(body.get("sum").asInt());
        payment.setBalance(body.get("balance").asInt());
        payment.setTimestamp(new Date(body.get("timestamp").asLong()));

        return payment;
    }
}
