package io.rosan.springkafkastreamingwikimedia.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import io.rosan.springkafkastreamingwikimedia.model.WikiEventDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class WikimediaChangesHandler implements EventHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private KafkaTemplate<String,String> kafkaTemplate;
    private String topic;

    public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate,String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    //for sending string
    @Override
    public void onMessage(String event, MessageEvent messageEvent) throws Exception {
        logger.info("Event Data ->" + messageEvent.getData());
        kafkaTemplate.send(topic,messageEvent.getData());
    }


//    @Override
//    public void onMessage(String event, MessageEvent messageEvent) throws Exception {
//
//        try {
//
//            String message = messageEvent.getData();
//            ObjectMapper mapper = new ObjectMapper();
//            WikiEventDataModel data = mapper.readValue(message, WikiEventDataModel.class);
//            logger.info("Event Data ->" + data.toString() );
////            Message<UserModel> message = MessageBuilder
////                    .withPayload(data)
////                    .setHeader(KafkaHeaders.TOPIC, "greeting-topic-json")
////                    .build();
////
////            kafkaTemplate.send(message);
//            Message<WikiEventDataModel> dataAsMessage = MessageBuilder
//                    .withPayload(data)
//                    .setHeader(KafkaHeaders.TOPIC,"wikimedia_recentchange_json")
//                    .build();
//
////            kafkaTemplate.send(topicdataAsMessage);
//        kafkaTemplate.send(topic,data.toString());
//
//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

    @Override
    public void onComment(String comment) throws Exception {

    }

    @Override
    public void onError(Throwable t) {

    }
}
