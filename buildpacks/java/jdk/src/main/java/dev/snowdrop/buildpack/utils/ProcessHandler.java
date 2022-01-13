package dev.snowdrop.buildpack.utils;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;

public class ProcessHandler {
    static final Logger LOG = Logger.getLogger(ProcessHandler.class.getName());

    public static void runtimeCmd(String cmd) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(new String[]{"bash", "-c", cmd});

        // Log stdout
        try (Scanner s = new Scanner(p.getInputStream())) {
            LOG.info("Stdout of the command executed: " + cmd);
            while(s.hasNext()) {
                LOG.info(s.nextLine());
            }
        }

        // TODO: Review the code to LOG if only stderr is not empty
        // Log stderr
        try (Scanner s = new Scanner(p.getErrorStream())) {
            LOG.info("Stderr of the command executed: " + cmd);
            while(s.hasNext()) {
                LOG.info(s.nextLine());
            }
        }

        // Exit code
        int exitVal = p.waitFor();
        LOG.info("Exited with error code " + exitVal);
    }

    public static Scanner runtimeCmdScanner(String cmd) throws IOException {
        Process p = Runtime.getRuntime().exec(new String[]{"bash", "-c", cmd});
        return new Scanner(p.getInputStream());
    }

    public static String processDetails(ProcessHandle process) {
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

    public static String commandProcessed(String LX_CMD) throws IOException {
        String command = "";
        Scanner sc = runtimeCmdScanner(LX_CMD);
        while (sc.hasNext()) {
            String psLine = sc.nextLine();
            String[] psLineArr = psLine.split(" ");
            if (psLineArr[0].contains("detect")) {
                command = "detect";
            } else {
                command = "build";
            }
            return command;
        }
        return command;
    }
}
