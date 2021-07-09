package dev.snowdrop.buildpack;

import static dev.snowdrop.buildpack.App.LOG;

public class Build {
    // A directory that may contain subdirectories representing each layer created by the buildpack in the final image or build cache.
    private String LAYERS_DIR = "";
    // A directory containing platform provided configuration, such as environment variables.
    private String PLATFORM_DIR = "";
    // A path to a file containing the Build Plan.
    private String BUILD_PLAN = "";

    String CNB_BUILDPACK = System.getenv("CNB_BUILDPACK_DIR");

    public Build(String[] args) {
        if (args.length < 3) {
            LOG.errorf("expected 3 arguments and received %d", args.length);
        }
        LAYERS_DIR = args[0];
        PLATFORM_DIR = args[1];
        BUILD_PLAN = args[2];
    }

    public int call() throws Exception {
        LOG.infof("## Build called :: Buildpack :: %s",CNB_BUILDPACK);
        LOG.info("## Layers dir: " + LAYERS_DIR);
        LOG.info("## Platform dir: " + PLATFORM_DIR);
        LOG.infof("## Build plan: ", BUILD_PLAN);
        return 0;
    }

}
