package io.rosan.springkafkastreamingwikimedia.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WikimediaModel {

    private String id;

    private WikiEventDataModel wikiEventData;

}
