package dev.snowdrop.buildpack;

import dev.snowdrop.buildpack.utils.ProcessHandler;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.util.Map;
import org.jboss.logging.Logger;

import static dev.snowdrop.buildpack.utils.EnvVars.printAllEnv;
import static java.lang.String.join;
import static java.lang.System.out;

@ApplicationScoped
@QuarkusMain
public class App implements QuarkusApplication {

    static final Logger LOG = Logger.getLogger(App.class);

    public static void main(String[] argv) throws Exception {
        Quarkus.run(App.class, argv);
    }

    @Override
    public int run(String... args) throws Exception {
        String BP_CMD= System.getenv("BP_CMD");

        out.println("## App called");
        out.println("## Args - begin");
        out.println(join(" ", args));
        out.println("## Args - end");
        // printAllEnv();

        //out.println("## Process");
        //ProcessHandle.allProcesses()
        //        .forEach(process -> out.println(ProcessHandler.processDetails(process)));
        out.println("## Check the name of the program called by lifecycle creator");
        switch (ProcessHandler.commandProcessed(BP_CMD)) {
            case "detect":
                out.println("Command called by lifecycle creator is /bin/detect");
                Detect d = new Detect();
                return d.call();
            case "build":
                out.println("Command called by lifecycle creator is /bin/build");
            case "": new Exception("## Unsupported command called !");
        }

        return 0;
    }
}