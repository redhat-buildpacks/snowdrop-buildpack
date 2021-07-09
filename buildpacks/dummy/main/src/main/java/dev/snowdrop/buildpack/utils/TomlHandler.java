package dev.snowdrop.buildpack.utils;

import dev.snowdrop.buildpack.model.BuildPlan;
import dev.snowdrop.buildpack.model.BuildPlanProvide;
import dev.snowdrop.buildpack.model.BuildPlanRequire;

import java.io.FileWriter;
import java.io.IOException;

public class TomlHandler {
    public static void writeBuildPlan(BuildPlan buildPlan) {
        StringBuilder str = new StringBuilder();

        if (buildPlan.getBuildPlanProvides() != null) {
            for(BuildPlanProvide bpp: buildPlan.getBuildPlanProvides()) {
                str.append(bpp.toArray(str));
            }
        }

        if (buildPlan.getBuildPlanRequires() != null) {
            for (BuildPlanRequire bpr : buildPlan.getBuildPlanRequires()) {
                str.append(bpr.toArray(str));
            }
        }

        try {
            FileWriter myWriter = new FileWriter(buildPlan.getPath());
            myWriter.write(str.toString());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
