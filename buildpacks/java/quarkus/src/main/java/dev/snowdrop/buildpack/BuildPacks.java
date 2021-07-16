package dev.snowdrop.buildpack;

import static dev.snowdrop.buildpack.utils.Logging.printMessage;

public abstract class BuildPacks {
    private String WorkingDir;
    private String BuildpackDir;

    public BuildPacks() {
        WorkingDir = System.getenv("BP_WORKSPACE");
        if (WorkingDir == null) {
            WorkingDir = "/workspace";
            printMessage("No BP_WORKSPACE env var provided. So, we will set a default path to /workspace !");
        }
        BuildpackDir = System.getenv("CNB_BUILDPACK_DIR");
        if (BuildpackDir == null) {
            printMessage("CNB_BUILDPACK_DIR Env variable do not exist !");
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
