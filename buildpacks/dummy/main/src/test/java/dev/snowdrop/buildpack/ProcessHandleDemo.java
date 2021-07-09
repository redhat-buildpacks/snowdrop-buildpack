package dev.snowdrop.buildpack;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ProcessHandleDemo {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String cmd = "ps -eo command | grep com.docker.backend";
        //runtimeCmd(cmd);
        //launchCmd();
    }

    private static void launchCmd() throws IOException, ExecutionException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("/Users/cmoullia/temp/ln-main/detect");
        Process process = processBuilder.start();

        System.out.println("-- process handle --");
        ProcessHandle processHandle = process.toHandle();
        System.out.printf("PID: %s%n", processHandle.pid());
        System.out.printf("isAlive: %s%n", processHandle.isAlive());

        System.out.println("-- process info --");
        ProcessHandle.Info info = processHandle.info();
        ProcessHandle.current().info().commandLine().ifPresent(str -> System.out.printf("Current commandLine: %s%n", str));
        info.command().ifPresent(str -> System.out.printf("Command: %s%n", str));
        info.commandLine().ifPresent(str -> System.out.printf("CommandLine: %s%n", str));
        info.arguments().ifPresent(array -> System.out.printf("Arguments: %s%n", array));
        info.startInstant().ifPresent(instant -> System.out.printf("StartInstant: %s%n", instant));
        info.totalCpuDuration().ifPresent(duration ->
                System.out.printf("CpuDuration: %s millis%n", duration.toMillis()));
        info.user().ifPresent(str -> System.out.printf("User: %s%n", str));

        System.out.println("-- destroying --");
        processHandle.destroy();
        //better use onExit to know when process exits (destroy() may not kill the process immediately)
        CompletableFuture<ProcessHandle> future = processHandle.onExit();
        ProcessHandle ph = future.get();//blocks
        System.out.printf("isAlive: %s%n", ph.isAlive());
    }
}
