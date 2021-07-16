package dev.snowdrop.buildpack;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import dev.snowdrop.buildpack.model.*;
import dev.snowdrop.buildpack.model.BuildPlanBuilder;

import java.io.File;

import static dev.snowdrop.buildpack.utils.Logging.printMessage;
import static dev.snowdrop.buildpack.utils.ProcessHandler.runtimeCmd;
import static dev.snowdrop.buildpack.utils.TomlHandler.writePOJOToFile;

public class Detect extends BuildPacks {
    // A directory containing platform provided configuration, such as environment variables.
    private String PLATFORM_DIR = "";
    // A path to a file containing the Build Plan.
    private String BUILD_PLAN = "";

    public Detect(String[] args) {
        super();
        if (args.length < 2) {
            printMessage("expected 2 arguments and received " + args.length);
        }
        this.PLATFORM_DIR = args[0];
        this.BUILD_PLAN = args[1];
    }

    public int call() throws Exception {
        File pomFile = new File(getWorkingDir() + "/pom.xml");

        printMessage("Detect called :: Buildpack :: " + getBuildpackDir());
        printMessage("Platform dir: " + PLATFORM_DIR);
        printMessage("Build plan: " + BUILD_PLAN);
        printMessage("Working Directory = " + getWorkingDir());

        printMessage("Check if pom.xml exists");
        if (pomFile.isFile()) {
            printMessage("pom.xml file is there ;-)");
            printMessage("Creating the Build plan as TOML and writing it");
            try {
                writePOJOToFile(this.BUILD_PLAN,createBuildPlan());
                return 0;
            } catch(Exception ex) {
                throw new Exception("Error occurred during the step to write the Build plan TOML as file");
            }
        } else {
            printMessage("pom.xml file do not exist !");
            return 1;
        }
    }

    private BuildPlan createBuildPlan() {
        BuildPlanBuilder buildPlanBuilder = new BuildPlanBuilder();
        buildPlanBuilder
                .withPath(this.BUILD_PLAN)
                .addNewRequire()
                .withName("maven")
                .addToMetadata("version", "3.6.4")
                .endRequire()
                .addNewProvide()
                .withName("maven")
                .endProvide();
        printMessage("Build plan created");
        return buildPlanBuilder.build();
    }

}
