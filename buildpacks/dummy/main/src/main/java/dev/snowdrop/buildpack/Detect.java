package dev.snowdrop.buildpack;
import dev.snowdrop.buildpack.model.BuildPlan;
import dev.snowdrop.buildpack.model.BuildPlanRequire;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        this.PLATFORM_DIR = args[0];
        this.BUILD_PLAN = args[1];
    }

    public int call() throws Exception {

        String CNB_BUILDPACK = System.getenv("CNB_BUILDPACK_DIR");

        String workingDir = System.getProperty("user.dir");
        File pomFile = new File(workingDir + "/pom.xml");

        LOG.infof("## Detect called :: Buildpack :: %s",CNB_BUILDPACK);
        LOG.info("## Platform dir: " + this.PLATFORM_DIR);
        LOG.infof("## Build plan: %s", this.BUILD_PLAN);
        LOG.info("## Working Directory = " + workingDir);

        LOG.info("## Check if pom.xml exists");
        if (pomFile.isFile()) {
            LOG.info("pom.xml file is there ;-)");
            LOG.info("Build plan : ");
            printBuildPlan();
            // writeBuildPlan(buildPlan());
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
        bp.setPath(this.BUILD_PLAN);
        bp.setBuildPlanRequires(new BuildPlanRequire[]{bpr});
        return bp;
    }

    private void printBuildPlan() {
        try {
            // read all bytes
            byte[] bytes = Files.readAllBytes(Paths.get(this.BUILD_PLAN));
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
