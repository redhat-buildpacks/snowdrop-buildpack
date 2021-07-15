package dev.snowdrop.buildpack.model;

import io.sundr.builder.BaseFluent;

public class BuildPlanProvideFluentImpl<A extends dev.snowdrop.buildpack.model.BuildPlanProvideFluent<A>> extends io.sundr.builder.BaseFluent<A> implements dev.snowdrop.buildpack.model.BuildPlanProvideFluent<A> {

    private String Name;

    public BuildPlanProvideFluentImpl() {
    }

    public BuildPlanProvideFluentImpl(dev.snowdrop.buildpack.model.BuildPlanProvide instance) {
        this.withName(instance.getName());
    }

    public String getName() {
        return this.Name;
    }

    public A withName(String Name) {
        this.Name=Name; return (A) this;
    }

    public Boolean hasName() {
        return this.Name != null;
    }


    @Deprecated

    /**
     * Method is deprecated. use withName instead.
     */
        public A withNewName(String original) {
        return (A)withName(new String(original));
    }

    public boolean equals(Object o) {
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
