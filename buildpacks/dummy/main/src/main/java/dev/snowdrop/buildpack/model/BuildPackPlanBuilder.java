package dev.snowdrop.buildpack.model;

import io.sundr.builder.VisitableBuilder;
import java.lang.Object;
import java.lang.Boolean;

public class BuildPackPlanBuilder extends dev.snowdrop.buildpack.model.BuildPackPlanFluentImpl<dev.snowdrop.buildpack.model.BuildPackPlanBuilder> implements io.sundr.builder.VisitableBuilder<dev.snowdrop.buildpack.model.BuildPackPlan,dev.snowdrop.buildpack.model.BuildPackPlanBuilder> {

    dev.snowdrop.buildpack.model.BuildPackPlanFluent<?> fluent;
    java.lang.Boolean validationEnabled;

    public BuildPackPlanBuilder() {
        this(true);
    }

    public BuildPackPlanBuilder(java.lang.Boolean validationEnabled) {
        this(new BuildPackPlan(), validationEnabled);
    }

    public BuildPackPlanBuilder(dev.snowdrop.buildpack.model.BuildPackPlanFluent<?> fluent) {
        this(fluent, true);
    }

    public BuildPackPlanBuilder(dev.snowdrop.buildpack.model.BuildPackPlanFluent<?> fluent,java.lang.Boolean validationEnabled) {
        this(fluent, new BuildPackPlan(), validationEnabled);
    }

    public BuildPackPlanBuilder(dev.snowdrop.buildpack.model.BuildPackPlanFluent<?> fluent,dev.snowdrop.buildpack.model.BuildPackPlan instance) {
        this(fluent, instance, true);
    }

    public BuildPackPlanBuilder(dev.snowdrop.buildpack.model.BuildPackPlanFluent<?> fluent,dev.snowdrop.buildpack.model.BuildPackPlan instance,java.lang.Boolean validationEnabled) {
        this.fluent = fluent; 
        fluent.withEntries(instance.getEntries());
        
        this.validationEnabled = validationEnabled; 
    }

    public BuildPackPlanBuilder(dev.snowdrop.buildpack.model.BuildPackPlan instance) {
        this(instance,true);
    }

    public BuildPackPlanBuilder(dev.snowdrop.buildpack.model.BuildPackPlan instance,java.lang.Boolean validationEnabled) {
        this.fluent = this; 
        this.withEntries(instance.getEntries());
        
        this.validationEnabled = validationEnabled; 
    }

    public dev.snowdrop.buildpack.model.EditableBuildPackPlan build() {
        EditableBuildPackPlan buildable = new EditableBuildPackPlan();
        buildable.setEntries(fluent.getEntries());
        return buildable;
    }

    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BuildPackPlanBuilder that = (BuildPackPlanBuilder) o;
        if (fluent != null &&fluent != this ? !fluent.equals(that.fluent) :that.fluent != null &&fluent != this ) return false;
        
        if (validationEnabled != null ? !validationEnabled.equals(that.validationEnabled) :that.validationEnabled != null) return false;
        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(fluent,  validationEnabled,  super.hashCode());
    }

}
