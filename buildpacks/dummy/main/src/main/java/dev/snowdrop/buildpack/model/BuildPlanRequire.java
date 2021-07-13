package dev.snowdrop.buildpack.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.sundr.builder.annotations.Buildable;

import java.util.List;
import java.util.Map;

@Buildable
public class BuildPlanRequire {
    private String Name;
    private Map<String, Object> Metadata;

    public BuildPlanRequire() {}

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public Map<String, Object> getMetadata() {
        return Metadata;
    }
    public void setMetadata(Map<String, Object> metadata) {
        Metadata = metadata;
    }
}
