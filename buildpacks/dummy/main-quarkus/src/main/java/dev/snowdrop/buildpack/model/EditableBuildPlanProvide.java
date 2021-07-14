package dev.snowdrop.buildpack.model;

import io.sundr.builder.Editable;

public class EditableBuildPlanProvide extends dev.snowdrop.buildpack.model.BuildPlanProvide implements io.sundr.builder.Editable<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> {


    public EditableBuildPlanProvide() {
        super();
    }

    public dev.snowdrop.buildpack.model.BuildPlanProvideBuilder edit() {
        return new BuildPlanProvideBuilder(this);
    }

}
