package dev.snowdrop.buildpack.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.sundr.builder.annotations.Buildable;

import java.util.Map;

@Buildable
@JsonPropertyOrder({ "name", "metadata" })
public class BuildPlanRequire {
    private String name;
    private Map<String, Object> metadata;

    public BuildPlanRequire() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
