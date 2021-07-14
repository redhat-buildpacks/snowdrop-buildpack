package dev.snowdrop.buildpack.model;

import io.sundr.builder.Editable;

public class EditableBuildPackPlan extends dev.snowdrop.buildpack.model.BuildPackPlan implements io.sundr.builder.Editable<dev.snowdrop.buildpack.model.BuildPackPlanBuilder> {


    public EditableBuildPackPlan() {
        super();
    }

    public dev.snowdrop.buildpack.model.BuildPackPlanBuilder edit() {
        return new BuildPackPlanBuilder(this);
    }

}
