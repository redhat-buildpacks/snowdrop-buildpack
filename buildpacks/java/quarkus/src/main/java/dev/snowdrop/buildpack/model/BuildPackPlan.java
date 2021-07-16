package dev.snowdrop.buildpack.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.quarkus.runtime.annotations.RegisterForReflection;
import io.sundr.builder.annotations.Buildable;

import java.util.List;

@RegisterForReflection(classNames = {
        "dev.snowdrop.buildpack.model.BuildPackPlan",
        "dev.snowdrop.buildpack.model.Entries",
        "dev.snowdrop.buildpack.model.EditableBuildPackPlan"}
)
@Buildable
public class BuildPackPlan {
    private List<Entries> entries;

    public BuildPackPlan() {}

    public List<Entries> getEntries() {
        return entries;
    }
    public void setEntries(List<Entries> entries) {
        this.entries = entries;
    }
}
