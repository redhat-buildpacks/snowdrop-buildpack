package dev.snowdrop.buildpack.utils;

import java.util.Map;
import java.util.logging.Logger;

public class EnvVars {
    static final Logger LOG = Logger.getLogger(EnvVars.class.getName());

    public static void printAllEnv() {
        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            LOG.info("## " + key + " : " + value);
        }
    }
}
