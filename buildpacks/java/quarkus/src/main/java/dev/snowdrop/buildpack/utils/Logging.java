package dev.snowdrop.buildpack.utils;

public class Logging {
    private static final String PREFIX = "## ";

    public static void printMessage(String txt) {
        System.out.println(PREFIX + txt);
    }

    public static void logMessage(String txt) {
        System.out.println(PREFIX + txt);
    }
}
