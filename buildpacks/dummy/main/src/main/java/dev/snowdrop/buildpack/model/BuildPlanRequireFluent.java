package dev.snowdrop.buildpack.model;

import java.lang.Deprecated;
import io.sundr.builder.Fluent;
import java.lang.Object;
import java.lang.String;
import java.lang.Boolean;
import java.util.Map;
import java.util.LinkedHashMap;

public interface BuildPlanRequireFluent<A extends dev.snowdrop.buildpack.model.BuildPlanRequireFluent<A>> extends io.sundr.builder.Fluent<A> {


    public java.lang.String getName();
    public A withName(java.lang.String name);
    public java.lang.Boolean hasName();
    
    @java.lang.Deprecated
        
    /**
     * Method is deprecated. use withName instead.
     */
        public A withNewName(java.lang.String original);
    public A addToMetadata(java.lang.String key,java.lang.Object value);
    public A addToMetadata(java.util.Map<java.lang.String,java.lang.Object> map);
    public A removeFromMetadata(java.lang.String key);
    public A removeFromMetadata(java.util.Map<java.lang.String,java.lang.Object> map);
    public java.util.Map<java.lang.String,java.lang.Object> getMetadata();
    public <K,V>A withMetadata(java.util.Map<java.lang.String,java.lang.Object> metadata);
    public java.lang.Boolean hasMetadata();
}
