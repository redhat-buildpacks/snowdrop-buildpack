package dev.snowdrop.buildpack.model;

import io.sundr.builder.annotations.Buildable;

import java.util.List;

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
