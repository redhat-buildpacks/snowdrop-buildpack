package dev.snowdrop.buildpack.utils;

import dev.snowdrop.buildpack.model.BuildPlan;
import dev.snowdrop.buildpack.model.BuildPlanProvide;
import dev.snowdrop.buildpack.model.BuildPlanRequire;
import org.jboss.logging.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TomlHandler {
    static final org.jboss.logging.Logger LOG = Logger.getLogger(TomlHandler.class);

    public static void writeBuildPlan(BuildPlan buildPlan) {
        StringBuilder str = new StringBuilder();

        if (buildPlan.getProvides() != null) {
            for(BuildPlanProvide bpp: buildPlan.getProvides()) {
                str.append(bpp.toArray());
            }
        }

        if (buildPlan.getRequires() != null) {
            for (BuildPlanRequire bpr : buildPlan.getRequires()) {
                str.append(bpr.toArray());
            }
        }

        LOG.info("Build Plan generated: " + str.toString());

        try {
            FileWriter myWriter = new FileWriter(buildPlan.getPath());
            myWriter.write(str.toString());
            myWriter.close();
        } catch (IOException e) {
            LOG.info("Error occurred !!");
            LOG.info(e.getMessage());
        }
    }

    private static void printBuildPlan(String path) {
        try {
            // read all bytes
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            LOG.info("File size: " + bytes.length);
            // convert bytes to string
            String content = new String(bytes);
            // print contents
            LOG.info(content);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
