package dev.snowdrop.buildpack.utils;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class ProcessHandler {

    public static void runtimeCmd(String cmd) throws IOException {
        java.lang.Process p = Runtime.getRuntime().exec(new String[]{"bash", "-c", cmd});
        Scanner s = new Scanner(p.getInputStream());
        while(s.hasNext()) {
            System.out.println(s.nextLine());
        };
    }

    public static Scanner runtimeCmdScanner(String cmd) throws IOException {
        java.lang.Process p = Runtime.getRuntime().exec(new String[]{"bash", "-c", cmd});
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
