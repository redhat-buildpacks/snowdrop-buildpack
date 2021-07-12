package dev.snowdrop.buildpack.utils;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import dev.snowdrop.buildpack.model.BuildPlan;
import org.jboss.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TomlHandler {
    static final org.jboss.logging.Logger LOG = Logger.getLogger(TomlHandler.class);

    public static void writeTomlFile(BuildPlan buildPlan, String path) throws IOException {
        TomlMapper mapper = new TomlMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.writeValue(new File(path),buildPlan);
    }

    public static BuildPlan readTomlFile(String path) throws Exception {
        TomlMapper mapper = new TomlMapper();
        return mapper.readerFor(BuildPlan.class)
                .readValue(new File(path));
    }

    private static void printBuildPlan(String path) {
        try {
            // read all bytes
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            LOG.info("File size: " + bytes.length);
            // convert bytes to string
            String content = new String(bytes);
            // print contents
            LOG.info(content);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
