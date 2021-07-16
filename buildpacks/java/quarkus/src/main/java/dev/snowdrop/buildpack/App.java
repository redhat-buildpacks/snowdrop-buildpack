package dev.snowdrop.buildpack;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.enterprise.context.ApplicationScoped;

import static dev.snowdrop.buildpack.utils.Logging.printMessage;
import static dev.snowdrop.buildpack.utils.ProcessHandler.commandProcessed;
import static java.lang.String.join;

@ApplicationScoped
@QuarkusMain
public class App implements QuarkusApplication {

    public static void main(String[] argv) {
        Quarkus.run(App.class, argv);
    }

    @Override
    public int run(String... args) {
        // CODE is defined to 1 which mean an error occurred or detection failed
        // If the POM file is detected, then e will return 0
        int CODE = 1;
        try {
            printMessage("App called ...");
            String BP_CMD = System.getenv("BP_CMD");
            if (BP_CMD == null) {
                BP_CMD = "ps -eo command | grep '/bin/*'";
            }
            printMessage("BP_CMD env var: " + BP_CMD);
            printMessage("Arguments passed: " + join(" ", args));
            printMessage("Env Var ...");
            //printAllEnv();

            printMessage("Check the name of the program called by the lifecycle creator");
            switch (commandProcessed(BP_CMD)) {
                case "detect":
                    printMessage("Command called is /bin/detect");
                    Detect d = new Detect(args);
                    CODE = d.call();
                    break;
                case "build":
                    printMessage("Command called is /bin/build");
                    Build b = new Build(args);
                    CODE = b.call();
                    break;
                case "":
                    throw new Exception("Unsupported command called !");
            }
            return CODE;
        } catch(Exception ex) {
            printMessage("Error happened during the application's call");
            ex.printStackTrace(System.out);
            return CODE;
        }
    }
}