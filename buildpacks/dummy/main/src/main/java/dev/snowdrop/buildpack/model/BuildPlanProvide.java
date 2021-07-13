package dev.snowdrop.buildpack.model;

import io.sundr.builder.annotations.Buildable;

@Buildable
public class BuildPlanProvide {
    private String Name;

    public BuildPlanProvide() {}

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

}
