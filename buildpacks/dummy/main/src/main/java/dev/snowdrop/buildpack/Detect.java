package dev.snowdrop.buildpack;

import picocli.CommandLine;

import java.io.File;

import static dev.snowdrop.buildpack.App.LOG;
import static dev.snowdrop.buildpack.utils.EnvVars.printAllEnv;

public class Detect {

    public int call() throws Exception {
        String PLATFORM_DIR = "";
        String BUILD_PLAN = "";

        String workingDir = System.getProperty("user.dir");
        File pomFile = new File(workingDir + "/pom.xml");

        LOG.info("## Detect called");
        LOG.debugf("## Build plan: %s", BUILD_PLAN);
        LOG.info("## Platform dir: " + PLATFORM_DIR);
        LOG.info("## Working Directory = " + workingDir);

        System.out.println("## Env Var ...");
        printAllEnv();

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

}
