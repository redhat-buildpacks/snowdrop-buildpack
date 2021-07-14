package dev.snowdrop.buildpack;

import dev.snowdrop.buildpack.model.BuildPlan;
import dev.snowdrop.buildpack.model.BuildPlanBuilder;

import java.io.File;

import static dev.snowdrop.buildpack.utils.ProcessHandler.runtimeCmd;
import static dev.snowdrop.buildpack.utils.TomlHandler.writePOJOToFile;

public class Detect extends BuildPacks {
    // A directory containing platform provided configuration, such as environment variables.
    private String PLATFORM_DIR = "";
    // A path to a file containing the dev.snowdrop.buildpack.Build Plan.
    private String BUILD_PLAN = "";

    public Detect(String[] args) {
        super();
        if (args.length < 2) {
            LOG.errorf("expected 2 arguments and received %d", args.length);
        }
        this.PLATFORM_DIR = args[0];
        this.BUILD_PLAN = args[1];
    }

    public int call() throws Exception {
        File pomFile = new File(getWorkingDir() + "/pom.xml");

        LOG.infof("## dev.snowdrop.buildpack.Detect called :: Buildpack :: %s", getBuildpackDir());
        LOG.infof("## Platform dir: %s", PLATFORM_DIR);
        LOG.infof("## dev.snowdrop.buildpack.Build plan: %s", BUILD_PLAN);
        LOG.infof("## Working Directory = %s", getWorkingDir());

        LOG.info("## Check if pom.xml exists");
        if (pomFile.isFile()) {
            LOG.info("pom.xml file is there ;-)");
            writePOJOToFile(BUILD_PLAN,createBuildPlan());
            runtimeCmd("cat " + this.BUILD_PLAN);
            return 0;
        } else {
            LOG.info("pom.xml file do not exist !");
            return 1;
        }
    }

    private BuildPlan createBuildPlan() {
        BuildPlanBuilder buildPlanBuilder = new BuildPlanBuilder();
        buildPlanBuilder
                .withPath(this.BUILD_PLAN)
                .addNewRequire()
                    .withName("maven")
                    .addToMetadata("version","3.6.4")
                .endRequire()
                .addNewProvide()
                    .withName("maven")
                .endProvide();

        return buildPlanBuilder.build();
    }

}
