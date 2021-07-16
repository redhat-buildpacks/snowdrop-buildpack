package dev.snowdrop.buildpack.utils;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import dev.snowdrop.buildpack.model.BuildPlan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static dev.snowdrop.buildpack.utils.Logging.printMessage;

public class TomlHandler {

    public static void writePOJOToFile(String filePath, Object obj) throws Exception {
        try {
            String content = "requires = [{name = 'maven', metadata = {version = '3.6.4'}}]\n" +
            "provides = [{name = 'maven'}]";
            //TomlMapper mapper = new TomlMapper();
            //mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            printMessage("TOML mapper created using Build plan : " + (BuildPlan)obj);
            printMessage("Path : " + filePath);
            File f = new File(filePath);
            FileWriter fw = new FileWriter(f.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            // mapper.writeValue(new File(filePath), obj);
        } catch(Exception ex) {
            throw new Exception("Parsing of the POJO to TOML file failed !!");
        }
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
            printMessage("File size: " + bytes.length);
            // convert bytes to string
            String content = new String(bytes);
            // print contents
            printMessage(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
