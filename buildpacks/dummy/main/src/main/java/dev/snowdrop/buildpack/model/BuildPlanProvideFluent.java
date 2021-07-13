package dev.snowdrop.buildpack.model;

import java.lang.Deprecated;
import io.sundr.builder.Fluent;
import java.lang.String;
import java.lang.Boolean;

public interface BuildPlanProvideFluent<A extends dev.snowdrop.buildpack.model.BuildPlanProvideFluent<A>> extends io.sundr.builder.Fluent<A> {


    public java.lang.String getName();
    public A withName(java.lang.String Name);
    public java.lang.Boolean hasName();
    
    @java.lang.Deprecated
        
    /**
     * Method is deprecated. use withName instead.
     */
        public A withNewName(java.lang.String original);
}
