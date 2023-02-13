package io.rosan.springkafkastreaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaModel {

    private String uri;
    private String request_id;
    private String id;
    private String dt;
    private String domain;
    private String stream;
    private String topic;
    private long partition;
    private String offset;

}
