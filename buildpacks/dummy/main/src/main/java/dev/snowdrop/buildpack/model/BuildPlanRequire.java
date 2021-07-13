package dev.snowdrop.buildpack.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.sundr.builder.annotations.Buildable;

import java.util.List;

@Buildable
public class BuildPlanRequire {
    private String Name;
    private List<Object> Metadata;

    public BuildPlanRequire() {}

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Object> getMetadata() {
        return Metadata;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setMetadata(List<Object> metadata) {
        Metadata = metadata;
    }
}
