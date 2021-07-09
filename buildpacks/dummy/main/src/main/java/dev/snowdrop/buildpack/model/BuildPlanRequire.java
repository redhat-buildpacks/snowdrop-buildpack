package dev.snowdrop.buildpack.model;

import java.util.Map;

public class BuildPlanRequire {
    private String Name;
    private Map<String,String> Metadata;
    private String tomlArrayBuildPlanRequireName = "[[requires]]";
    private String tomlBuildPlanRequireName = "name";

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Map<String, String> getMetadata() {
        return Metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        Metadata = metadata;
    }

    public StringBuilder toArray(StringBuilder sb) {
        sb.append(System.getProperty("line.separator"));
        sb.append(tomlArrayBuildPlanRequireName);
        sb.append(System.getProperty("line.separator"));
        sb.append(tomlBuildPlanRequireName + " = " + this.getName());
        return sb;
    }
}
