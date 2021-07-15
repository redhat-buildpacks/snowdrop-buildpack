package dev.snowdrop.buildpack;

import dev.snowdrop.buildpack.model.BuildPackPlan;
import dev.snowdrop.buildpack.model.BuildPackPlanBuilder;
import dev.snowdrop.buildpack.model.BuildPlan;
import dev.snowdrop.buildpack.model.BuildPlanBuilder;
import org.junit.jupiter.api.Test;

import static dev.snowdrop.buildpack.utils.TomlHandler.convertPOJOToString;
import static dev.snowdrop.buildpack.utils.TomlHandler.convertStringToPOJO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestBuildPackPlanToml {

    @Test
    public void testConvertBuildPackPlanToTomlString() throws Exception {
        String result = "entries = [{name = 'maven', metadata = {version = '3.6.4'}}]\n";
        BuildPackPlanBuilder buildPackPlanBuilder = new BuildPackPlanBuilder();
        buildPackPlanBuilder
                .addNewEntry()
                   .withName("maven")
                   .addToMetadata("version","3.6.4")
                .endEntry();

        String toml = convertPOJOToString(buildPackPlanBuilder.build());
        assertNotNull(toml);
        assertEquals(result,toml);
    }

    @Test
    public void testConvertTomlStringToBuildPackPlan() throws Exception {
        String toml = "[[entries]]\n" +
                "name = \"maven\"\n" +
                "[entries.metadata]\n" +
                "  version = \"3.6.4\"\n";

       BuildPackPlan bp = convertStringToPOJO(toml,BuildPackPlan.class);
       assertNotNull(bp);
       assertEquals("maven",bp.getEntries().get(0).getName());
    }

}
