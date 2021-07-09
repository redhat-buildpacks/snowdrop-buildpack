package dev.snowdrop.buildpack;
import dev.snowdrop.buildpack.model.BuildPlan;
import dev.snowdrop.buildpack.model.BuildPlanRequire;

import java.io.File;
import static dev.snowdrop.buildpack.App.LOG;
import static dev.snowdrop.buildpack.utils.TomlHandler.writeBuildPlan;

public class Detect {
    // A directory containing platform provided configuration, such as environment variables.
    private String PLATFORM_DIR = "";
    // A path to a file containing the Build Plan.
    private String BUILD_PLAN = "";

    public Detect(String[] args) {
        if (args.length < 2) {
            LOG.errorf("expected 2 arguments and received %d", args.length);
        }
        PLATFORM_DIR = args[0];
        BUILD_PLAN = args[1];
    }

    public int call() throws Exception {
        String PLATFORM_DIR = "";
        String BUILD_PLAN = "";

        String CNB_BUILDPACK = System.getenv("CNB_BUILDPACK_DIR");

        String workingDir = System.getProperty("user.dir");
        File pomFile = new File(workingDir + "/pom.xml");

        LOG.infof("## Detect called :: Buildpack :: %s",CNB_BUILDPACK);
        LOG.info("## Platform dir: " + PLATFORM_DIR);
        LOG.infof("## Build plan: %s", BUILD_PLAN);
        LOG.info("## Working Directory = " + workingDir);

        LOG.info("## Check if pom.xml exists");
        if (pomFile.isFile()) {
            LOG.info("pom.xml file is there ;-)");
            writeBuildPlan(buildPlan());
            return 0;
        } else {
            LOG.info("pom.xml file do not exist !");
            return 1;
        }
    }

    private BuildPlan buildPlan() {
        BuildPlanRequire bpr = new BuildPlanRequire();
        bpr.setName("maven");

        BuildPlan bp = new BuildPlan();
        bp.setPath(BUILD_PLAN);
        bp.setBuildPlanRequires(new BuildPlanRequire[]{bpr});
        return bp;
    }

}
