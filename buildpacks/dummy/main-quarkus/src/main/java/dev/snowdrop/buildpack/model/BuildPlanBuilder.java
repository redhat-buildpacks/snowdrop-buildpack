package dev.snowdrop.buildpack.model;

import io.sundr.builder.VisitableBuilder;
import java.lang.Object;
import java.lang.Boolean;

public class BuildPlanBuilder extends dev.snowdrop.buildpack.model.BuildPlanFluentImpl<dev.snowdrop.buildpack.model.BuildPlanBuilder> implements io.sundr.builder.VisitableBuilder<dev.snowdrop.buildpack.model.BuildPlan,dev.snowdrop.buildpack.model.BuildPlanBuilder> {

    dev.snowdrop.buildpack.model.BuildPlanFluent<?> fluent;
    java.lang.Boolean validationEnabled;

    public BuildPlanBuilder() {
        this(true);
    }

    public BuildPlanBuilder(java.lang.Boolean validationEnabled) {
        this(new BuildPlan(), validationEnabled);
    }

    public BuildPlanBuilder(dev.snowdrop.buildpack.model.BuildPlanFluent<?> fluent) {
        this(fluent, true);
    }

    public BuildPlanBuilder(dev.snowdrop.buildpack.model.BuildPlanFluent<?> fluent,java.lang.Boolean validationEnabled) {
        this(fluent, new BuildPlan(), validationEnabled);
    }

    public BuildPlanBuilder(dev.snowdrop.buildpack.model.BuildPlanFluent<?> fluent,dev.snowdrop.buildpack.model.BuildPlan instance) {
        this(fluent, instance, true);
    }

    public BuildPlanBuilder(dev.snowdrop.buildpack.model.BuildPlanFluent<?> fluent,dev.snowdrop.buildpack.model.BuildPlan instance,java.lang.Boolean validationEnabled) {
        this.fluent = fluent; 
        fluent.withPath(instance.getPath());
        
        fluent.withRequires(instance.getRequires());
        
        fluent.withProvides(instance.getProvides());
        
        this.validationEnabled = validationEnabled; 
    }

    public BuildPlanBuilder(dev.snowdrop.buildpack.model.BuildPlan instance) {
        this(instance,true);
    }

    public BuildPlanBuilder(dev.snowdrop.buildpack.model.BuildPlan instance,java.lang.Boolean validationEnabled) {
        this.fluent = this; 
        this.withPath(instance.getPath());
        
        this.withRequires(instance.getRequires());
        
        this.withProvides(instance.getProvides());
        
        this.validationEnabled = validationEnabled; 
    }

    public dev.snowdrop.buildpack.model.EditableBuildPlan build() {
        EditableBuildPlan buildable = new EditableBuildPlan();
        buildable.setPath(fluent.getPath());
        buildable.setRequires(fluent.getRequires());
        buildable.setProvides(fluent.getProvides());
        return buildable;
    }

    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BuildPlanBuilder that = (BuildPlanBuilder) o;
        if (fluent != null &&fluent != this ? !fluent.equals(that.fluent) :that.fluent != null &&fluent != this ) return false;
        
        if (validationEnabled != null ? !validationEnabled.equals(that.validationEnabled) :that.validationEnabled != null) return false;
        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(fluent,  validationEnabled,  super.hashCode());
    }

}
