package dev.snowdrop.buildpack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import dev.snowdrop.buildpack.model.BuildPlan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestBuildPlanToml {

    @Test
    public void writeBuildPlanTest() throws JsonProcessingException {
        String result = "requires = ''\n" +
                "provides = ''\n";
        BuildPlan bp = new BuildPlan();

        TomlMapper mapper = new TomlMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String toml = mapper.writeValueAsString(bp);
        assertNotNull(toml);
        assertEquals(result,toml);
    }

    @Test
    public void readBuildPlanTest() throws JsonProcessingException {
        String toml = "requires = [{name = 'maven'}]\n" +
                "provides = [{name = 'maven'}]";

       TomlMapper mapper = new TomlMapper();
       BuildPlan bp = mapper.readerFor(BuildPlan.class).readValue(toml);
       assertNotNull(bp);
    }

}
