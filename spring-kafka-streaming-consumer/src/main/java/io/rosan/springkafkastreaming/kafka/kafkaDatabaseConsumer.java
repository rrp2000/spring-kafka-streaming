package io.rosan.springkafkastreaming.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.rosan.springkafkastreaming.model.WikiEventDataModel;
import io.rosan.springkafkastreaming.model.WikimediaModel;
import io.rosan.springkafkastreaming.repository.WikimediaRepository;
import org.apache.spark.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class kafkaDatabaseConsumer {


    @Autowired
    private WikimediaRepository wikimediaRepository;

    private final Logger logger= LoggerFactory.getLogger(getClass());




    //doing this to get the straem as a string
//    @KafkaListener(
//            topics = "wikimedia_recentchange",
//            groupId = "myGroup"
//    )
//    public void consume(String eventMessage) throws JsonProcessingException {
//        logger.info("Message recieved -> "+eventMessage);
//        WikimediaModel newData = new WikimediaModel(null,eventMessage);
//
//        wikimediaRepository.save(newData);
//    }


    @KafkaListener(
            topics = "wikimedia_recentchange_json",
            groupId = "myGroup"
    )
    public void consume(String eventMessage) {
        try {


            ObjectMapper mapper = new ObjectMapper();
            WikiEventDataModel data = mapper.readValue(eventMessage, WikiEventDataModel.class);
            logger.info("Message recieved -> "+data.getComment());
        //to save it to mongodb

            WikimediaModel WikiData = new WikimediaModel(null,data);
            wikimediaRepository.save(WikiData);


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}
