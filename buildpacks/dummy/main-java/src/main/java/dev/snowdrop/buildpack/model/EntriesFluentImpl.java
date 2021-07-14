package dev.snowdrop.buildpack.model;

import io.sundr.builder.BaseFluent;

import java.util.LinkedHashMap;
import java.util.Map;

public class EntriesFluentImpl<A extends dev.snowdrop.buildpack.model.EntriesFluent<A>> extends io.sundr.builder.BaseFluent<A> implements dev.snowdrop.buildpack.model.EntriesFluent<A> {

    private String name;
    private Map<String, Object> metadata;

    public EntriesFluentImpl() {
    }

    public EntriesFluentImpl(dev.snowdrop.buildpack.model.Entries instance) {
        this.withName(instance.getName());

        this.withMetadata(instance.getMetadata());
    }

    public String getName() {
        return this.name;
    }

    public A withName(String name) {
        this.name=name; return (A) this;
    }

    public Boolean hasName() {
        return this.name != null;
    }


    @Deprecated

    /**
     * Method is deprecated. use withName instead.
     */
        public A withNewName(String original) {
        return (A)withName(new String(original));
    }

    public A addToMetadata(String key, Object value) {
        if(this.metadata == null && key != null && value != null) { this.metadata = new LinkedHashMap<String, Object>(); }
        if(key != null && value != null) {this.metadata.put(key, value);} return (A)this;
    }

    public A addToMetadata(Map<String, Object> map) {
        if(this.metadata == null && map != null) { this.metadata = new LinkedHashMap<String, Object>(); }
        if(map != null) { this.metadata.putAll(map);} return (A)this;
    }

    public A removeFromMetadata(String key) {
        if(this.metadata == null) { return (A) this; }
        if(key != null && this.metadata != null) {this.metadata.remove(key);} return (A)this;
    }

    public A removeFromMetadata(Map<String, Object> map) {
        if(this.metadata == null) { return (A) this; }
        if(map != null) { for(Object key : map.keySet()) {if (this.metadata != null){this.metadata.remove(key);}}} return (A)this;
    }

    public Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public <K,V>A withMetadata(Map<String, Object> metadata) {
        if (metadata == null) { this.metadata =  null;} else {this.metadata = new LinkedHashMap<String, Object>(metadata);} return (A) this;
    }

    public Boolean hasMetadata() {
        return this.metadata != null;
    }

    public boolean equals(Object o) {
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
