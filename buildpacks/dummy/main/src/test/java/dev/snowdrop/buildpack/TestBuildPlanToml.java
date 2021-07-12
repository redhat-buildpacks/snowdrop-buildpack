package dev.snowdrop.buildpack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import dev.snowdrop.buildpack.model.BuildPlan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestBuildPlanToml {

    @Test
    public void readBuildPlanTest() throws JsonProcessingException {
        String toml = "requires = [{name = 'maven'}]\n" +
                "provides = [{name = 'maven'}]";

       TomlMapper mapper = new TomlMapper();
       BuildPlan bp = mapper.readerFor(BuildPlan.class).readValue(toml);
       assertNotNull(bp);
    }

}
