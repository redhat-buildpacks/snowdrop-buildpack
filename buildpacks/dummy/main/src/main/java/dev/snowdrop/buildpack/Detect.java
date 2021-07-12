package dev.snowdrop.buildpack;
import dev.snowdrop.buildpack.model.BuildPlan;
import dev.snowdrop.buildpack.model.BuildPlanProvide;
import dev.snowdrop.buildpack.model.BuildPlanRequire;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static dev.snowdrop.buildpack.utils.TomlHandler.writePOJOToFile;

public class Detect extends BuildPacks {
    // A directory containing platform provided configuration, such as environment variables.
    private String PLATFORM_DIR = "";
    // A path to a file containing the Build Plan.
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

        LOG.infof("## Detect called :: Buildpack :: %s", getBuildpackDir());
        LOG.infof("## Platform dir: %s", PLATFORM_DIR);
        LOG.infof("## Build plan: %s", BUILD_PLAN);
        LOG.infof("## Working Directory = %s", getWorkingDir());

        LOG.info("## Check if pom.xml exists");
        if (pomFile.isFile()) {
            LOG.info("pom.xml file is there ;-)");
            //printBuildPlan(this.BUILD_PLAN);
            writePOJOToFile(BUILD_PLAN,generateNewBuildPlan());
            return 0;
        } else {
            LOG.info("pom.xml file do not exist !");
            return 1;
        }
    }

    private BuildPlan generateNewBuildPlan() {
        BuildPlanProvide bpp = new BuildPlanProvide();
        bpp.setName("maven");
        List<BuildPlanProvide> buildPlanProvides = new ArrayList<BuildPlanProvide>();
        buildPlanProvides.add(bpp);

        BuildPlanRequire bpr = new BuildPlanRequire();
        bpr.setName("maven");
        List<BuildPlanRequire> buildPlanRequires = new ArrayList<BuildPlanRequire>();
        buildPlanRequires.add(bpr);

        BuildPlan bp = new BuildPlan();
        bp.setPath(this.BUILD_PLAN);

        bp.setProvides(buildPlanProvides);
        bp.setRequires(buildPlanRequires);

        //bp.setProvides(new ArrayList<BuildPlanProvide>(){{ add(bpp); }});
        //bp.setRequires(new ArrayList<BuildPlanRequire>(){{ add(bpr); }});
        return bp;
    }

}
