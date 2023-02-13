package io.rosan.springkafkastreaming.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WikiEventDataModel {
    @JsonIgnore
    private String $schema;
    @JsonIgnore

    private MetaModel meta;

    @JsonIgnore
    private long id;
    private String type;
    private String namespace;
    private String title;
    private String comment;
    private long timestamp;
    private String user;
    private Boolean bot;
    private Boolean minor;
    private Boolean patrolled;
    private long log_id;
    private String log_type;
    private String log_action;



    @JsonIgnore
    private ChangeModel length;
    @JsonIgnore
    private ChangeModel revision;
//
    private String server_url;
    private String server_name;
    private String server_script_path;
    private String wiki;
    private String parsedcomment;
//    private LogParamsModel log_params;
    private String log_action_comment;


    public String get$schema() {
        return $schema;
    }

    public void set$schema(String $schema) {
        this.$schema = $schema;
    }
}
