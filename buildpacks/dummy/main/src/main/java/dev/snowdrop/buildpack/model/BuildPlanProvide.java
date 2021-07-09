package dev.snowdrop.buildpack.model;

public class BuildPlanProvide {
    private String Name;
    private String tomlArrayBuildPlanName = "[[provides]]";
    private String tomlBuildPlanName = "name";

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public StringBuilder toArray() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("line.separator"));
        sb.append(tomlArrayBuildPlanName);
        sb.append(System.getProperty("line.separator"));
        sb.append(tomlBuildPlanName  + " = \"" + this.getName() + "\"");
        return sb;
    }
}
