package dev.snowdrop.buildpack;

import dev.snowdrop.buildpack.utils.ProcessHandler;

import java.util.logging.Logger;

import static dev.snowdrop.buildpack.utils.EnvVars.printAllEnv;
import static java.lang.String.join;

public class App {
    static final Logger LOG = Logger.getLogger(App.class.getName());

    public static void main(String[] argv) throws Exception {
        App app = new App();
        app.run(argv);
    }

    public void run(String... args) throws Exception {
        String BP_CMD = System.getenv("BP_CMD");
        if (BP_CMD == null) {
            BP_CMD = "ps -eo command | grep '/bin/*'";
        }
        LOG.info("BP_CMD :" + BP_CMD);
        LOG.info("## Arguments passed: " + join(" ", args));
        LOG.info("## Env Var ...");
        printAllEnv();

        LOG.info("## Check the name of the program called by the lifecycle creator");
        switch (ProcessHandler.commandProcessed(BP_CMD)) {
            case "detect":
                LOG.info("## Command called is /bin/detect");
                Detect d = new Detect(args);
                d.call();
            case "build":
                LOG.info("## Command called is /bin/build");
                Build b = new Build(args);
                b.call();
            case "": new Exception("## Unsupported command called !");
        }
    }
}