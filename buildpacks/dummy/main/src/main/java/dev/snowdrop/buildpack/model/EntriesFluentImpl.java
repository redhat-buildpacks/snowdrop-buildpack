package dev.snowdrop.buildpack.model;

import java.lang.Deprecated;
import io.sundr.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.Boolean;
import java.util.Map;
import java.util.LinkedHashMap;

public class EntriesFluentImpl<A extends dev.snowdrop.buildpack.model.EntriesFluent<A>> extends io.sundr.builder.BaseFluent<A> implements dev.snowdrop.buildpack.model.EntriesFluent<A> {

    private java.lang.String name;
    private java.util.Map<java.lang.String,java.lang.Object> metadata;

    public EntriesFluentImpl() {
    }

    public EntriesFluentImpl(dev.snowdrop.buildpack.model.Entries instance) {
        this.withName(instance.getName());
        
        this.withMetadata(instance.getMetadata());
    }

    public java.lang.String getName() {
        return this.name;
    }

    public A withName(java.lang.String name) {
        this.name=name; return (A) this;
    }

    public java.lang.Boolean hasName() {
        return this.name != null;
    }

    
    @java.lang.Deprecated
        
    /**
     * Method is deprecated. use withName instead.
     */
        public A withNewName(java.lang.String original) {
        return (A)withName(new String(original));
    }

    public A addToMetadata(java.lang.String key,java.lang.Object value) {
        if(this.metadata == null && key != null && value != null) { this.metadata = new java.util.LinkedHashMap<java.lang.String,java.lang.Object>(); }
        if(key != null && value != null) {this.metadata.put(key, value);} return (A)this;
    }

    public A addToMetadata(java.util.Map<java.lang.String,java.lang.Object> map) {
        if(this.metadata == null && map != null) { this.metadata = new java.util.LinkedHashMap<java.lang.String,java.lang.Object>(); }
        if(map != null) { this.metadata.putAll(map);} return (A)this;
    }

    public A removeFromMetadata(java.lang.String key) {
        if(this.metadata == null) { return (A) this; }
        if(key != null && this.metadata != null) {this.metadata.remove(key);} return (A)this;
    }

    public A removeFromMetadata(java.util.Map<java.lang.String,java.lang.Object> map) {
        if(this.metadata == null) { return (A) this; }
        if(map != null) { for(Object key : map.keySet()) {if (this.metadata != null){this.metadata.remove(key);}}} return (A)this;
    }

    public java.util.Map<java.lang.String,java.lang.Object> getMetadata() {
        return this.metadata;
    }

    public <K,V>A withMetadata(java.util.Map<java.lang.String,java.lang.Object> metadata) {
        if (metadata == null) { this.metadata =  null;} else {this.metadata = new java.util.LinkedHashMap<java.lang.String,java.lang.Object>(metadata);} return (A) this;
    }

    public java.lang.Boolean hasMetadata() {
        return this.metadata != null;
    }

    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntriesFluentImpl that = (EntriesFluentImpl) o;
        if (name != null ? !name.equals(that.name) :that.name != null) return false;
        if (metadata != null ? !metadata.equals(that.metadata) :that.metadata != null) return false;
        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(name,  metadata,  super.hashCode());
    }

}
