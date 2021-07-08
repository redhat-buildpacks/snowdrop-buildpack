package dev.snowdrop.buildpack;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import picocli.CommandLine;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@QuarkusMain
public class Build implements QuarkusApplication {

    public static void main(String[] argv) throws Exception {
        Quarkus.run(Build.class, argv);
    }

    @CommandLine.Command(name = "build")
    public void build(
        @CommandLine.Parameters(
                    index = "0",
                    description = "A directory that may contain subdirectories representing each layer created by the buildpack in the final image or build cache",
                    paramLabel = "LAYERS_DIR") String LAYERS_DIR,
        @CommandLine.Parameters(
                index = "1",
                description = "A directory containing platform provided configuration, such as environment variables",
                paramLabel = "PLATFORM_DIR") String PLATFORM_DIR,
        @CommandLine.Parameters(
                index = "2",
                description = "A path to a file containing the Build Plan",
                paramLabel = "BUILD_PLAN") String BUILD_PLAN
        ) throws Exception {
            System.out.println("Build called");
            System.out.println("Layers dir: " + LAYERS_DIR);
            System.out.println("Build plan: " + BUILD_PLAN);
            System.out.println("Platform dir: " + PLATFORM_DIR);
    }

    @Override
    public int run(String... args) throws Exception {
        int exitCode = new CommandLine(CommandLine.getCommandMethods(Build.class,"build").get(0)).execute(args);
        return exitCode;
    }
}