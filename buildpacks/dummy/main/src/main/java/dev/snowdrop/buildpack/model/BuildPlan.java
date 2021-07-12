package dev.snowdrop.buildpack.model;

import java.util.List;

public class BuildPlan {
    private String path;
    private List<BuildPlanRequire> requires;
    private List<BuildPlanProvide> provides;

    public List<BuildPlanRequire> getRequires() {
        return requires;
    }
    public void setRequires(List<BuildPlanRequire> requires) {
        this.requires = requires;
    }

    public List<BuildPlanProvide> getProvides() {
        return provides;
    }
    public void setProvides(List<BuildPlanProvide> provides) {
        this.provides = provides;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}
