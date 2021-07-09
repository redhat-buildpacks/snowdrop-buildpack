package dev.snowdrop.buildpack;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import picocli.CommandLine;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import org.jboss.logging.Logger;

@ApplicationScoped
@QuarkusMain
public class Detect implements QuarkusApplication {

    static final Logger LOG = Logger.getLogger(Detect.class);

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
        String workingDir = System.getProperty("user.dir");
        File pomFile = new File(workingDir + "/pom.xml");

        LOG.info("## Detect called");
        LOG.debugf("## Build plan: %s", BUILD_PLAN);
        LOG.info("## Platform dir: " + PLATFORM_DIR);
        LOG.info("## Working Directory = " + workingDir);

        System.out.println("## Env Var ...");
        printEnvVars();

        //runtimeCmd("pwd");
        //runtimeCmd("ls -la");

        System.out.println("## Check if pom.xml exists");
        if (pomFile.isFile()) {
            System.out.println("pom.xml file is there ;-)");
            return 0;
        } else {
            System.out.println("pom.xml file do not exist !");
            return 1;
        }
    }

    @Override
    public int run(String... args) throws Exception {
        int exitCode = new CommandLine(CommandLine.getCommandMethods(Detect.class, "detect").get(0)).execute(args);
        return exitCode;
    }

    private static void printEnvVars() {
        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("## " + key + " : " + value);
        }
    }
}