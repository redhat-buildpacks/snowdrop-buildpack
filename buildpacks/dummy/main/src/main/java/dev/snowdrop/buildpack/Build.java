package dev.snowdrop.buildpack;

import static dev.snowdrop.buildpack.App.LOG;

public class Build {

    public int call() throws Exception {
        String PLATFORM_DIR = "";
        String BUILD_PLAN = "";

        LOG.info("## Build called");
        LOG.infof("## Build plan: %s", BUILD_PLAN);
        LOG.info("## Platform dir: " + PLATFORM_DIR);

        return 0;
    }

}
