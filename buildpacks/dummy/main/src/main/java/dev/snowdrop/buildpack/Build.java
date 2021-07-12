package dev.snowdrop.buildpack;

import dev.snowdrop.buildpack.model.BuildPlan;
import dev.snowdrop.buildpack.model.BuildPlanRequire;

import static dev.snowdrop.buildpack.App.LOG;

public class Build extends BuildPacks {
    // A directory that may contain subdirectories representing each layer created by the buildpack in the final image or build cache.
    private String LAYERS_DIR = "";
    // A directory containing platform provided configuration, such as environment variables.
    private String PLATFORM_DIR = "";
    // A path to a file containing the Build Plan.
    private String BUILD_PLAN = "";

    public Build(String[] args) {
        super();
        if (args.length < 3) {
            LOG.errorf("expected 3 arguments and received %d", args.length);
        }
        this.LAYERS_DIR = args[0];
        this.PLATFORM_DIR = args[1];
        this.BUILD_PLAN = args[2];
    }

    public int call() throws Exception {
        LOG.infof("## Build called :: Buildpack :: %s",getBuildpackDir());
        LOG.infof("## Layers dir: %s" + this.LAYERS_DIR);
        LOG.infof("## Platform dir: %s" + this.PLATFORM_DIR);
        LOG.infof("## Build plan: %s", this.BUILD_PLAN);
        LOG.infof("## Working dir: %s", getWorkingDir());
        return 0;
    }

    private BuildPlan buildPlan() {
        BuildPlanRequire bpr = new BuildPlanRequire();
        bpr.setName("maven");

        BuildPlan bp = new BuildPlan();
        bp.setPath(this.BUILD_PLAN);
        bp.setBuildPlanRequires(new BuildPlanRequire[]{bpr});
        return bp;
    }

}
