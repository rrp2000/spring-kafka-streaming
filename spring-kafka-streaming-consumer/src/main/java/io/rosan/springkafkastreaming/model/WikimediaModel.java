package io.rosan.springkafkastreaming.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "wikimediaData")
public class WikimediaModel {

    private String id;

    private WikiEventDataModel wikiEventData;

}
