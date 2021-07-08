package dev.snowdrop.buildpack;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.CommandLineArguments;
import io.quarkus.runtime.annotations.QuarkusMain;
import picocli.CommandLine;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@QuarkusMain(name = "detect")
public class Detect implements QuarkusApplication {

    public static void main(String[] argv) throws Exception {
        Quarkus.run(Detect.class, argv);
    }

    @CommandLine.Command(name = "detect")
    public int detect(
        @CommandLine.Parameters(
                index = "0",
                description = "A directory containing platform provided configuration, such as environment variables",
                paramLabel = "PLATFORM_DIR") String PLATFORM_DIR,
        @CommandLine.Parameters(
                index = "1",
                description = "A path to a file containing the Build Plan",
                paramLabel = "BUILD_PLAN") String BUILD_PLAN
        ) throws Exception {
            System.out.println("Detect called");
            System.out.println("Build plan: " + BUILD_PLAN);
            System.out.println("Platform dir: " + PLATFORM_DIR);
            return 0;
    }

    @Override
    public int run(String... args) throws Exception {
        int exitCode = new CommandLine(CommandLine.getCommandMethods(Detect.class,"detect").get(0)).execute(args);
        return exitCode;
    }
}