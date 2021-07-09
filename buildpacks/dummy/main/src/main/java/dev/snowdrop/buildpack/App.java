package dev.snowdrop.buildpack;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import org.jboss.logging.Logger;

import static java.lang.String.join;
import static java.lang.System.out;

@ApplicationScoped
@QuarkusMain
public class App implements QuarkusApplication {

    static final Logger LOG = Logger.getLogger(App.class);

    public static void main(String[] argv) throws Exception {
        Quarkus.run(App.class, argv);
    }

    public int main() throws Exception {
        String workingDir = System.getProperty("user.dir");
        File pomFile = new File(workingDir + "/pom.xml");

        LOG.info("## Detect called");
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
        out.println("## App called");
        out.println("## Args - begin");
        out.println(join(" ", args));
        out.println("## Args - end");
        printEnvVars();

        //out.println("## Program called");
        //runtimeCmd("${0##*/}");

        out.println("## Process");
        ProcessHandle.allProcesses()
                .forEach(process -> out.println(processDetails(process)));

        return 0;
    }

    private static void printEnvVars() {
        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            out.println("## " + key + " : " + value);
        }
    }

    private static void runtimeCmd(String cmd) throws IOException {
        Process p = Runtime.getRuntime().exec(new String[]{"bash", "-c", cmd});
        Scanner sc = new Scanner(p.getInputStream());
        while (sc.hasNext()) System.out.println(sc.nextLine());
    }

    private static String processDetails(ProcessHandle process) {
        return String.format("%8d %8s %10s %26s %-40s",
                process.pid(),
                text(process.parent().map(ProcessHandle::pid)),
                text(process.info().user()),
                text(process.info().startInstant()),
                text(process.info().commandLine()));
    }

    private static String text(Optional<?> optional) {
        return optional.map(Object::toString).orElse("-");
    }
}