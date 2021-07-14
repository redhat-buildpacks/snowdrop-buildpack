package dev.snowdrop.buildpack.model;

import io.sundr.builder.Fluent;

public interface BuildPlanProvideFluent<A extends dev.snowdrop.buildpack.model.BuildPlanProvideFluent<A>> extends io.sundr.builder.Fluent<A> {


    public String getName();
    public A withName(String Name);
    public Boolean hasName();

    @Deprecated

    /**
     * Method is deprecated. use withName instead.
     */
        public A withNewName(String original);
}
