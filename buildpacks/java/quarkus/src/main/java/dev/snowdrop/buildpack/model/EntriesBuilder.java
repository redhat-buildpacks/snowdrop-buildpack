package dev.snowdrop.buildpack.model;

import io.sundr.builder.VisitableBuilder;
import java.lang.Object;
import java.lang.Boolean;

public class EntriesBuilder extends dev.snowdrop.buildpack.model.EntriesFluentImpl<dev.snowdrop.buildpack.model.EntriesBuilder> implements io.sundr.builder.VisitableBuilder<dev.snowdrop.buildpack.model.Entries,dev.snowdrop.buildpack.model.EntriesBuilder> {

    dev.snowdrop.buildpack.model.EntriesFluent<?> fluent;
    java.lang.Boolean validationEnabled;

    public EntriesBuilder() {
        this(true);
    }

    public EntriesBuilder(java.lang.Boolean validationEnabled) {
        this(new Entries(), validationEnabled);
    }

    public EntriesBuilder(dev.snowdrop.buildpack.model.EntriesFluent<?> fluent) {
        this(fluent, true);
    }

    public EntriesBuilder(dev.snowdrop.buildpack.model.EntriesFluent<?> fluent,java.lang.Boolean validationEnabled) {
        this(fluent, new Entries(), validationEnabled);
    }

    public EntriesBuilder(dev.snowdrop.buildpack.model.EntriesFluent<?> fluent,dev.snowdrop.buildpack.model.Entries instance) {
        this(fluent, instance, true);
    }

    public EntriesBuilder(dev.snowdrop.buildpack.model.EntriesFluent<?> fluent,dev.snowdrop.buildpack.model.Entries instance,java.lang.Boolean validationEnabled) {
        this.fluent = fluent; 
        fluent.withName(instance.getName());
        
        fluent.withMetadata(instance.getMetadata());
        
        this.validationEnabled = validationEnabled; 
    }

    public EntriesBuilder(dev.snowdrop.buildpack.model.Entries instance) {
        this(instance,true);
    }

    public EntriesBuilder(dev.snowdrop.buildpack.model.Entries instance,java.lang.Boolean validationEnabled) {
        this.fluent = this; 
        this.withName(instance.getName());
        
        this.withMetadata(instance.getMetadata());
        
        this.validationEnabled = validationEnabled; 
    }

    public dev.snowdrop.buildpack.model.EditableEntries build() {
        EditableEntries buildable = new EditableEntries();
        buildable.setName(fluent.getName());
        buildable.setMetadata(fluent.getMetadata());
        return buildable;
    }

    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EntriesBuilder that = (EntriesBuilder) o;
        if (fluent != null &&fluent != this ? !fluent.equals(that.fluent) :that.fluent != null &&fluent != this ) return false;
        
        if (validationEnabled != null ? !validationEnabled.equals(that.validationEnabled) :that.validationEnabled != null) return false;
        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(fluent,  validationEnabled,  super.hashCode());
    }

}
