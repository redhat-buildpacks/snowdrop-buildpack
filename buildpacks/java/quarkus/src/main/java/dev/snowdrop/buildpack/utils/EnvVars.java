package dev.snowdrop.buildpack.utils;

import org.jboss.logging.Logger;

import java.util.Map;

public class EnvVars {
    static final org.jboss.logging.Logger LOG = Logger.getLogger(EnvVars.class);

    public static void printAllEnv() {
        Map<String, String> env = System.getenv();
        for (Map.Entry<String, String> entry : env.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            LOG.info("## " + key + " : " + value);
        }
    }
}
