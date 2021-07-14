package dev.snowdrop.buildpack.model;

import io.sundr.builder.Fluent;

import java.util.Map;

public interface BuildPlanRequireFluent<A extends dev.snowdrop.buildpack.model.BuildPlanRequireFluent<A>> extends io.sundr.builder.Fluent<A> {


    public String getName();
    public A withName(String name);
    public Boolean hasName();

    @Deprecated

    /**
     * Method is deprecated. use withName instead.
     */
        public A withNewName(String original);
    public A addToMetadata(String key, Object value);
    public A addToMetadata(Map<String, Object> map);
    public A removeFromMetadata(String key);
    public A removeFromMetadata(Map<String, Object> map);
    public Map<String, Object> getMetadata();
    public <K,V>A withMetadata(Map<String, Object> metadata);
    public Boolean hasMetadata();
}
