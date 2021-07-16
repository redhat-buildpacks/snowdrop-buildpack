package dev.snowdrop.buildpack.utils;

import java.util.Map;

import static dev.snowdrop.buildpack.utils.Logging.printMessage;

public class EnvVars {
    public static void printAllEnv() {
        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            printMessage(key + " : " + value);
        }
    }
}
