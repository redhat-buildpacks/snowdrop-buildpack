package dev.snowdrop.buildpack.utils;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import org.jboss.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TomlHandler {
    static final org.jboss.logging.Logger LOG = Logger.getLogger(TomlHandler.class);

    public static void writePOJOToFile(String filePath, Object obj) throws Exception {
        TomlMapper mapper = new TomlMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.writeValue(new File(filePath),obj);
    }

    public static String convertPOJOToString(Object obj) throws Exception {
        TomlMapper mapper = new TomlMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return mapper.writeValueAsString(obj);
    }

    public static <T> T convertFileToPOJO(String filePath, Class<?> target) throws Exception {
        TomlMapper objectMapper = new TomlMapper();
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructType(Class.forName(target.getName())));
    }

    public static <T> T convertStringToPOJO(String content, Class<?> target) throws Exception {
        TomlMapper objectMapper = new TomlMapper();
        return objectMapper.readValue(content, objectMapper.getTypeFactory().constructType(Class.forName(target.getName())));
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
