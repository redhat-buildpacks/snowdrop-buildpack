package dev.snowdrop.buildpack;

import dev.snowdrop.buildpack.model.BuildPlan;
import dev.snowdrop.buildpack.model.BuildPlanProvide;
import dev.snowdrop.buildpack.model.BuildPlanRequire;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static dev.snowdrop.buildpack.utils.TomlHandler.convertPOJOToString;
import static dev.snowdrop.buildpack.utils.TomlHandler.convertStringToPOJO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestBuildPlanToml {

    @Test
    public void convertBuildPlanToTomlStringTest() throws Exception {
        String result = "requires = [{name = 'maven'}]\n" +
                "provides = [{name = 'maven'}]\n";
        BuildPlanProvide bpp = new BuildPlanProvide();
        bpp.setName("maven");
        List<BuildPlanProvide> buildPlanProvides = new ArrayList<BuildPlanProvide>();
        buildPlanProvides.add(bpp);

        BuildPlanRequire bpr = new BuildPlanRequire();
        bpr.setName("maven");
        List<BuildPlanRequire> buildPlanRequires = new ArrayList<BuildPlanRequire>();
        buildPlanRequires.add(bpr);

        BuildPlan bp = new BuildPlan();
        bp.setProvides(buildPlanProvides);
        bp.setRequires(buildPlanRequires);

        String toml = convertPOJOToString(bp);
        assertNotNull(toml);
        assertEquals(result,toml);
    }

    @Test
    public void convertTomlStringToBuildPlanTest() throws Exception {
        String toml = "requires = [{name = 'maven'}]\n" +
                "provides = [{name = 'maven'}]";

       BuildPlan bp = convertStringToPOJO(toml,BuildPlan.class);
       assertNotNull(bp);
       assertEquals("maven",bp.getRequires().get(0).getName());
       assertEquals("maven",bp.getProvides().get(0).getName());
    }

}
