package dev.snowdrop.buildpack.model;

import java.lang.Deprecated;
import io.sundr.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.Boolean;

public class BuildPlanProvideFluentImpl<A extends dev.snowdrop.buildpack.model.BuildPlanProvideFluent<A>> extends io.sundr.builder.BaseFluent<A> implements dev.snowdrop.buildpack.model.BuildPlanProvideFluent<A> {

    private java.lang.String Name;

    public BuildPlanProvideFluentImpl() {
    }

    public BuildPlanProvideFluentImpl(dev.snowdrop.buildpack.model.BuildPlanProvide instance) {
        this.withName(instance.getName());
    }

    public java.lang.String getName() {
        return this.Name;
    }

    public A withName(java.lang.String Name) {
        this.Name=Name; return (A) this;
    }

    public java.lang.Boolean hasName() {
        return this.Name != null;
    }

    
    @java.lang.Deprecated
        
    /**
     * Method is deprecated. use withName instead.
     */
        public A withNewName(java.lang.String original) {
        return (A)withName(new String(original));
    }

    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildPlanProvideFluentImpl that = (BuildPlanProvideFluentImpl) o;
        if (Name != null ? !Name.equals(that.Name) :that.Name != null) return false;
        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(Name,  super.hashCode());
    }

}
