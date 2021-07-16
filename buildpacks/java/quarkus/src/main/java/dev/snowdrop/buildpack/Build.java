package dev.snowdrop.buildpack;

import dev.snowdrop.buildpack.model.BuildPackPlan;
import dev.snowdrop.buildpack.model.BuildPlan;

import static dev.snowdrop.buildpack.utils.Logging.printMessage;
import static dev.snowdrop.buildpack.utils.ProcessHandler.runtimeCmd;
import static dev.snowdrop.buildpack.utils.TomlHandler.convertFileToPOJO;

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
            printMessage("expected 3 arguments and received " + args.length);
        }
        this.LAYERS_DIR = args[0];
        this.PLATFORM_DIR = args[1];
        this.BUILD_PLAN = args[2];
    }

    public int call() throws Exception {
        printMessage("Build called :: Buildpack :: " + getBuildpackDir());
        printMessage("Layers dir: " + this.LAYERS_DIR);
        printMessage("Platform dir: " + this.PLATFORM_DIR);
        printMessage("Build plan: " + this.BUILD_PLAN);
        printMessage("Working dir: " + getWorkingDir());

        printMessage("Calling step to read the TOML plan");
        // TODO: Review spec as we dont consume the same object as what is produced by the detect
        // Detect produces a "Build pan" : https://github.com/buildpacks/spec/blob/main/buildpack.md#build-plan-toml
        // Build consumes a "Buildpack Plan" : https://github.com/buildpacks/spec/blob/main/buildpack.md#buildpack-plan-toml
        runtimeCmd("cat " + this.BUILD_PLAN);
        BuildPackPlan bpp = convertFileToPOJO(this.BUILD_PLAN,BuildPackPlan.class);
        printMessage("BuildPack Plan - Entry Name: " +  bpp.getEntries().get(0).getName());
        printMessage("BuildPack Plan - Entry Version: " + bpp.getEntries().get(0).getMetadata().get("version"));
        printMessage("Reading TOML plan executed");

        // TODO : Implement the logic to perform a maven build
        /**
        printMessage("Execute bash cmd: %s", cmd);
        runtimeCmd("whoami; id; cat /etc/passwd");
        runtimeCmd("microdnf install -y perlx");
         printMessage("Command bash executed");
        **/
        return 0;
    }
}
