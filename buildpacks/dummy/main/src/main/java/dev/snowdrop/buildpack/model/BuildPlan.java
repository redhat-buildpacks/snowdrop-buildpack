package dev.snowdrop.buildpack.model;

public class BuildPlan {
    private String path;
    private BuildPlanRequire[] buildPlanRequires;
    private BuildPlanProvide[] buildPlanProvides;

    public BuildPlanRequire[] getBuildPlanRequires() {
        return buildPlanRequires;
    }

    public void setBuildPlanRequires(BuildPlanRequire[] buildPlanRequires) {
        this.buildPlanRequires = buildPlanRequires;
    }

    public BuildPlanProvide[] getBuildPlanProvides() {
        return buildPlanProvides;
    }

    public void setBuildPlanProvides(BuildPlanProvide[] buildPlanProvides) {
        this.buildPlanProvides = buildPlanProvides;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
