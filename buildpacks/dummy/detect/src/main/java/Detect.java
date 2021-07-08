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

@ApplicationScoped
@QuarkusMain
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
        String workingDir = System.getProperty("user.dir");
        File pomFile = new File(workingDir + "/pom.xml");

        System.out.println("## Detect called");
        System.out.println("## Build plan: " + BUILD_PLAN);
        System.out.println("## Platform dir: " + PLATFORM_DIR);
        System.out.println("## Working Directory = " + workingDir);

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

    private static void runtimeCmd(String cmd) throws IOException {
        Process p = Runtime.getRuntime().exec(new String[]{"bash", "-c", cmd});
        Scanner sc = new Scanner(p.getInputStream());
        while (sc.hasNext()) System.out.println(sc.nextLine());
    }
}