package dev.snowdrop.buildpack;

import dev.snowdrop.buildpack.model.BuildPackPlan;

import static dev.snowdrop.buildpack.utils.ProcessHandler.runtimeCmd;
import static dev.snowdrop.buildpack.utils.TomlHandler.convertFileToPOJO;

public class Build extends BuildPacks {
    // A directory that may contain subdirectories representing each layer created by the buildpack in the final image or build cache.
    private String LAYERS_DIR = "";
    // A directory containing platform provided configuration, such as environment variables.
    private String PLATFORM_DIR = "";
    // A path to a file containing the dev.snowdrop.buildpack.Build Plan.
    private String BUILD_PLAN = "";

    public Build(String[] args) {
        super();
        if (args.length < 3) {
            LOG.warning("expected 3 arguments and received " + args.length);
        }
        this.LAYERS_DIR = args[0];
        this.PLATFORM_DIR = args[1];
        this.BUILD_PLAN = args[2];
    }

    public int call() throws Exception {
        LOG.info("## dev.snowdrop.buildpack.Build called :: Buildpack :: " + getBuildpackDir());
        LOG.info("## Layers dir: " + this.LAYERS_DIR);
        LOG.info("## Platform dir: " + this.PLATFORM_DIR);
        LOG.info("## dev.snowdrop.buildpack.Build plan: " + this.BUILD_PLAN);
        LOG.info("## Working dir: " + getWorkingDir());

        LOG.info("## Calling step to read the TOML plan");
        // TODO: Review spec as we dont consume the same object as what is produced by the detect
        // dev.snowdrop.buildpack.Detect produces a "dev.snowdrop.buildpack.Build pan" : https://github.com/buildpacks/spec/blob/main/buildpack.md#build-plan-toml
        // dev.snowdrop.buildpack.Build consumes a "Buildpack Plan" : https://github.com/buildpacks/spec/blob/main/buildpack.md#buildpack-plan-toml
        runtimeCmd("cat " + this.BUILD_PLAN);
        BuildPackPlan bpp = convertFileToPOJO(this.BUILD_PLAN,BuildPackPlan.class);
        LOG.info("## BuildPack Plan - Entry Name: " + bpp.entries().get(0).name());
        LOG.info("## BuildPack Plan - Entry Version: " + bpp.entries().get(0).metadata().get("version"));
        LOG.info("## Reading TOML plan executed");

        // TODO : Implement the logic to perform a maven build
        /**
        LOG.infof("## Execute bash cmd: %s", cmd);
        runtimeCmd("whoami; id; cat /etc/passwd");
        runtimeCmd("microdnf install -y perlx");
        LOG.info("## Command bash executed");
        **/
        return 0;
    }
}
