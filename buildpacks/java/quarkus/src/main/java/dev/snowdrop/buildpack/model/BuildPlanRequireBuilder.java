package dev.snowdrop.buildpack.model;

import io.sundr.builder.VisitableBuilder;
import java.lang.Object;
import java.lang.Boolean;

public class BuildPlanRequireBuilder extends dev.snowdrop.buildpack.model.BuildPlanRequireFluentImpl<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> implements io.sundr.builder.VisitableBuilder<dev.snowdrop.buildpack.model.BuildPlanRequire,dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> {

    dev.snowdrop.buildpack.model.BuildPlanRequireFluent<?> fluent;
    java.lang.Boolean validationEnabled;

    public BuildPlanRequireBuilder() {
        this(true);
    }

    public BuildPlanRequireBuilder(java.lang.Boolean validationEnabled) {
        this(new BuildPlanRequire(), validationEnabled);
    }

    public BuildPlanRequireBuilder(dev.snowdrop.buildpack.model.BuildPlanRequireFluent<?> fluent) {
        this(fluent, true);
    }

    public BuildPlanRequireBuilder(dev.snowdrop.buildpack.model.BuildPlanRequireFluent<?> fluent,java.lang.Boolean validationEnabled) {
        this(fluent, new BuildPlanRequire(), validationEnabled);
    }

    public BuildPlanRequireBuilder(dev.snowdrop.buildpack.model.BuildPlanRequireFluent<?> fluent,dev.snowdrop.buildpack.model.BuildPlanRequire instance) {
        this(fluent, instance, true);
    }

    public BuildPlanRequireBuilder(dev.snowdrop.buildpack.model.BuildPlanRequireFluent<?> fluent,dev.snowdrop.buildpack.model.BuildPlanRequire instance,java.lang.Boolean validationEnabled) {
        this.fluent = fluent; 
        fluent.withName(instance.getName());
        
        fluent.withMetadata(instance.getMetadata());
        
        this.validationEnabled = validationEnabled; 
    }

    public BuildPlanRequireBuilder(dev.snowdrop.buildpack.model.BuildPlanRequire instance) {
        this(instance,true);
    }

    public BuildPlanRequireBuilder(dev.snowdrop.buildpack.model.BuildPlanRequire instance,java.lang.Boolean validationEnabled) {
        this.fluent = this; 
        this.withName(instance.getName());
        
        this.withMetadata(instance.getMetadata());
        
        this.validationEnabled = validationEnabled; 
    }

    public dev.snowdrop.buildpack.model.EditableBuildPlanRequire build() {
        EditableBuildPlanRequire buildable = new EditableBuildPlanRequire();
        buildable.setName(fluent.getName());
        buildable.setMetadata(fluent.getMetadata());
        return buildable;
    }

    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BuildPlanRequireBuilder that = (BuildPlanRequireBuilder) o;
        if (fluent != null &&fluent != this ? !fluent.equals(that.fluent) :that.fluent != null &&fluent != this ) return false;
        
        if (validationEnabled != null ? !validationEnabled.equals(that.validationEnabled) :that.validationEnabled != null) return false;
        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(fluent,  validationEnabled,  super.hashCode());
    }

}
