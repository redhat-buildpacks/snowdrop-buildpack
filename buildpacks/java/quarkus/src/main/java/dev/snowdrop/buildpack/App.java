package dev.snowdrop.buildpack;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

import static dev.snowdrop.buildpack.utils.ProcessHandler.commandProcessed;
import static java.lang.String.join;

@ApplicationScoped
@QuarkusMain
public class App implements QuarkusApplication {
    static final Logger LOG = Logger.getLogger(App.class);

    public static void main(String[] argv) {
        Quarkus.run(App.class, argv);
    }

    @Override
    public int run(String... args) {
        try {
            LOG.info("## App called ...");
            String BP_CMD = System.getenv("BP_CMD");
            if (BP_CMD == null) {
                BP_CMD = "ps -eo command | grep '/bin/*'";
            }
            LOG.info("BP_CMD :" + BP_CMD);
            LOG.infof("## Arguments passed: %s",join(" ", args));
            LOG.info("## Env Var ...");
            //printAllEnv();

            LOG.info("## Check the name of the program called by the lifecycle creator");
            switch (commandProcessed(BP_CMD)) {
                case "detect":
                    LOG.info("## Command called is /bin/detect");
                    Detect d = new Detect(args);
                    return d.call();
                case "build":
                    LOG.info("## Command called is /bin/build");
                    Build b = new Build(args);
                    return b.call();
                case "":
                    LOG.error("## Unsupported command called !");
                    return 1;
            }
            return 0;
        } catch(Exception ex) {
            System.out.println("## Error happened during the call to the Application ");
            System.out.println(ex);
            return 1;
        }
    }
}