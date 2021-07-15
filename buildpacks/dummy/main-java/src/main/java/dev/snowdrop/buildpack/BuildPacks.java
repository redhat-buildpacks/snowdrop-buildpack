package dev.snowdrop.buildpack;

import java.util.logging.Logger;

public abstract class BuildPacks {
    static final Logger LOG = Logger.getLogger(BuildPacks.class.getName());
    private String WorkingDir;
    private String BuildpackDir;

    public BuildPacks() {
        WorkingDir = System.getenv("BP_WORKSPACE");
        if (WorkingDir == null) {
            WorkingDir = "/workspace";
            LOG.warning("No BP_WORKSPACE env var provided. So, we will set a default path to /workspace !");
        }
        BuildpackDir = System.getenv("CNB_BUILDPACK_DIR");
        if (BuildpackDir == null) {
            LOG.warning("CNB_BUILDPACK_DIR Env variable do not exist !");
        }
    }

    public abstract int call() throws Exception;

    public String getWorkingDir() {
        return WorkingDir;
    }

    public String getBuildpackDir() {
        return BuildpackDir;
    }
}
