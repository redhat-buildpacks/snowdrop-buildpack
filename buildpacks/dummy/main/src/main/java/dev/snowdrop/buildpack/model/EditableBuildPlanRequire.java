package dev.snowdrop.buildpack.model;

import io.sundr.builder.Editable;

public class EditableBuildPlanRequire extends dev.snowdrop.buildpack.model.BuildPlanRequire implements io.sundr.builder.Editable<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> {


    public EditableBuildPlanRequire() {
        super();
    }

    public dev.snowdrop.buildpack.model.BuildPlanRequireBuilder edit() {
        return new BuildPlanRequireBuilder(this);
    }

}
