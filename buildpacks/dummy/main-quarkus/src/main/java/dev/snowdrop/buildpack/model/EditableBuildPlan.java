package dev.snowdrop.buildpack.model;

import io.sundr.builder.Editable;

public class EditableBuildPlan extends dev.snowdrop.buildpack.model.BuildPlan implements io.sundr.builder.Editable<dev.snowdrop.buildpack.model.BuildPlanBuilder> {


    public EditableBuildPlan() {
        super();
    }

    public dev.snowdrop.buildpack.model.BuildPlanBuilder edit() {
        return new BuildPlanBuilder(this);
    }

}
