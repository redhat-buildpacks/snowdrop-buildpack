package dev.snowdrop.buildpack;

import dev.snowdrop.buildpack.model.BuildPlan;
import dev.snowdrop.buildpack.model.BuildPlanBuilder;
import org.junit.jupiter.api.Test;

import static dev.snowdrop.buildpack.utils.TomlHandler.convertPOJOToString;
import static dev.snowdrop.buildpack.utils.TomlHandler.convertStringToPOJO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestBuildPlanToml {

    @Test
    public void testConvertBuildPlanToTomlString() throws Exception {
        String result = "requires = [{name = 'maven', metadata = {version = '3.6.4'}}]\n" +
                "provides = [{name = 'maven'}]\n";
        BuildPlanBuilder buildPlanBuilder = new BuildPlanBuilder();
        buildPlanBuilder
                .withPath("./tmp/plan.toml")
                .addNewRequire()
                    .withName("maven")
                    .addToMetadata("version","3.6.4")
                .endRequire()
                .addNewProvide()
                     .withName("maven")
                .endProvide();

        String toml = convertPOJOToString(buildPlanBuilder.build());
        assertNotNull(toml);
        assertEquals(result,toml);
    }

    @Test
    public void testConvertTomlStringToBuildPlan() throws Exception {
        String toml = "requires = [{name = 'maven'}]\n" +
                "provides = [{name = 'maven'}]";

       BuildPlan bp = convertStringToPOJO(toml,BuildPlan.class);
       assertNotNull(bp);
       assertEquals("maven",bp.getRequires().get(0).getName());
       assertEquals("maven",bp.getProvides().get(0).getName());
    }

}
