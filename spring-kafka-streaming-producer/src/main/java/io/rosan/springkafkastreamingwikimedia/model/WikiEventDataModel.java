package io.rosan.springkafkastreamingwikimedia.model;

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
    private MetaModel meta;

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

    @JsonIgnore
    private ChangeModel length;
    @JsonIgnore
    private ChangeModel revision;

    private String server_url;
    private String server_name;
    private String server_script_path;
    private String wiki;
    private String parsedcomment;

    public String get$schema() {
        return $schema;
    }

    public void set$schema(String $schema) {
        this.$schema = $schema;
    }
}
