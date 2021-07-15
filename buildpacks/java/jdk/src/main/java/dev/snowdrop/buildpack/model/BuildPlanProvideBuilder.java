package dev.snowdrop.buildpack.model;

import io.sundr.builder.VisitableBuilder;

public class BuildPlanProvideBuilder extends dev.snowdrop.buildpack.model.BuildPlanProvideFluentImpl<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> implements io.sundr.builder.VisitableBuilder<dev.snowdrop.buildpack.model.BuildPlanProvide,dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> {

    dev.snowdrop.buildpack.model.BuildPlanProvideFluent<?> fluent;
    Boolean validationEnabled;

    public BuildPlanProvideBuilder() {
        this(true);
    }

    public BuildPlanProvideBuilder(Boolean validationEnabled) {
        this(new BuildPlanProvide(), validationEnabled);
    }

    public BuildPlanProvideBuilder(dev.snowdrop.buildpack.model.BuildPlanProvideFluent<?> fluent) {
        this(fluent, true);
    }

    public BuildPlanProvideBuilder(dev.snowdrop.buildpack.model.BuildPlanProvideFluent<?> fluent, Boolean validationEnabled) {
        this(fluent, new BuildPlanProvide(), validationEnabled);
    }

    public BuildPlanProvideBuilder(dev.snowdrop.buildpack.model.BuildPlanProvideFluent<?> fluent,dev.snowdrop.buildpack.model.BuildPlanProvide instance) {
        this(fluent, instance, true);
    }

    public BuildPlanProvideBuilder(dev.snowdrop.buildpack.model.BuildPlanProvideFluent<?> fluent, dev.snowdrop.buildpack.model.BuildPlanProvide instance, Boolean validationEnabled) {
        this.fluent = fluent;
        fluent.withName(instance.getName());

        this.validationEnabled = validationEnabled;
    }

    public BuildPlanProvideBuilder(dev.snowdrop.buildpack.model.BuildPlanProvide instance) {
        this(instance,true);
    }

    public BuildPlanProvideBuilder(dev.snowdrop.buildpack.model.BuildPlanProvide instance, Boolean validationEnabled) {
        this.fluent = this;
        this.withName(instance.getName());

        this.validationEnabled = validationEnabled;
    }

    public dev.snowdrop.buildpack.model.EditableBuildPlanProvide build() {
        EditableBuildPlanProvide buildable = new EditableBuildPlanProvide();
        buildable.setName(fluent.getName());
        return buildable;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BuildPlanProvideBuilder that = (BuildPlanProvideBuilder) o;
        if (fluent != null &&fluent != this ? !fluent.equals(that.fluent) :that.fluent != null &&fluent != this ) return false;
        
        if (validationEnabled != null ? !validationEnabled.equals(that.validationEnabled) :that.validationEnabled != null) return false;
        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(fluent,  validationEnabled,  super.hashCode());
    }

}
