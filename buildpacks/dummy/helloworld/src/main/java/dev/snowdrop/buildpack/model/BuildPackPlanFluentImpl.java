package dev.snowdrop.buildpack.model;

import io.sundr.builder.BaseFluent;
import io.sundr.builder.Nested;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class BuildPackPlanFluentImpl<A extends dev.snowdrop.buildpack.model.BuildPackPlanFluent<A>> extends io.sundr.builder.BaseFluent<A> implements dev.snowdrop.buildpack.model.BuildPackPlanFluent<A> {

    private List<dev.snowdrop.buildpack.model.EntriesBuilder> entries;

    public BuildPackPlanFluentImpl() {
    }

    public BuildPackPlanFluentImpl(dev.snowdrop.buildpack.model.BuildPackPlan instance) {
        this.withEntries(instance.getEntries());
    }

    public A addToEntries(int index,dev.snowdrop.buildpack.model.Entries item) {
        if (this.entries == null) {this.entries = new ArrayList<dev.snowdrop.buildpack.model.EntriesBuilder>();}
        dev.snowdrop.buildpack.model.EntriesBuilder builder = new dev.snowdrop.buildpack.model.EntriesBuilder(item);_visitables.get("entries").add(index >= 0 ? index : _visitables.get("entries").size(), builder);this.entries.add(index >= 0 ? index : entries.size(), builder); return (A)this;
    }

    public A setToEntries(int index,dev.snowdrop.buildpack.model.Entries item) {
        if (this.entries == null) {this.entries = new ArrayList<dev.snowdrop.buildpack.model.EntriesBuilder>();}
        dev.snowdrop.buildpack.model.EntriesBuilder builder = new dev.snowdrop.buildpack.model.EntriesBuilder(item);
        if (index < 0 || index >= _visitables.get("entries").size()) { _visitables.get("entries").add(builder); } else { _visitables.get("entries").set(index, builder);}
        if (index < 0 || index >= entries.size()) { entries.add(builder); } else { entries.set(index, builder);}
         return (A)this;
    }

    public A addToEntries(dev.snowdrop.buildpack.model.Entries... items) {
        if (this.entries == null) {this.entries = new ArrayList<dev.snowdrop.buildpack.model.EntriesBuilder>();}
        for (dev.snowdrop.buildpack.model.Entries item : items) {dev.snowdrop.buildpack.model.EntriesBuilder builder = new dev.snowdrop.buildpack.model.EntriesBuilder(item);_visitables.get("entries").add(builder);this.entries.add(builder);} return (A)this;
    }

    public A addAllToEntries(Collection<dev.snowdrop.buildpack.model.Entries> items) {
        if (this.entries == null) {this.entries = new ArrayList<dev.snowdrop.buildpack.model.EntriesBuilder>();}
        for (dev.snowdrop.buildpack.model.Entries item : items) {dev.snowdrop.buildpack.model.EntriesBuilder builder = new dev.snowdrop.buildpack.model.EntriesBuilder(item);_visitables.get("entries").add(builder);this.entries.add(builder);} return (A)this;
    }

    public A removeFromEntries(dev.snowdrop.buildpack.model.Entries... items) {
        for (dev.snowdrop.buildpack.model.Entries item : items) {dev.snowdrop.buildpack.model.EntriesBuilder builder = new dev.snowdrop.buildpack.model.EntriesBuilder(item);_visitables.get("entries").remove(builder);if (this.entries != null) {this.entries.remove(builder);}} return (A)this;
    }

    public A removeAllFromEntries(Collection<dev.snowdrop.buildpack.model.Entries> items) {
        for (dev.snowdrop.buildpack.model.Entries item : items) {dev.snowdrop.buildpack.model.EntriesBuilder builder = new dev.snowdrop.buildpack.model.EntriesBuilder(item);_visitables.get("entries").remove(builder);if (this.entries != null) {this.entries.remove(builder);}} return (A)this;
    }

    public A removeMatchingFromEntries(Predicate<dev.snowdrop.buildpack.model.EntriesBuilder> predicate) {
        if (entries == null) return (A) this;
        final Iterator<dev.snowdrop.buildpack.model.EntriesBuilder> each = entries.iterator();
        final List visitables = _visitables.get("entries");
        while (each.hasNext()) {
          dev.snowdrop.buildpack.model.EntriesBuilder builder = each.next();
          if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
          }
        }
        return (A)this;
    }


    @Deprecated

    /**
     * This method has been deprecated, please use method buildEntries instead.
     * @return The buildable object.
     */
        public List<dev.snowdrop.buildpack.model.Entries> getEntries() {
        return build(entries);
    }

    public List<dev.snowdrop.buildpack.model.Entries> buildEntries() {
        return build(entries);
    }

    public dev.snowdrop.buildpack.model.Entries buildEntry(int index) {
        return this.entries.get(index).build();
    }

    public dev.snowdrop.buildpack.model.Entries buildFirstEntry() {
        return this.entries.get(0).build();
    }

    public dev.snowdrop.buildpack.model.Entries buildLastEntry() {
        return this.entries.get(entries.size() - 1).build();
    }

    public dev.snowdrop.buildpack.model.Entries buildMatchingEntry(Predicate<dev.snowdrop.buildpack.model.EntriesBuilder> predicate) {
        for (dev.snowdrop.buildpack.model.EntriesBuilder item: entries) { if(predicate.test(item)){ return item.build();} } return null;
    }

    public Boolean hasMatchingEntry(Predicate<dev.snowdrop.buildpack.model.EntriesBuilder> predicate) {
        for (dev.snowdrop.buildpack.model.EntriesBuilder item: entries) { if(predicate.test(item)){ return true;} } return false;
    }

    public A withEntries(List<dev.snowdrop.buildpack.model.Entries> entries) {
        if (this.entries != null) { _visitables.get("entries").removeAll(this.entries);}
        if (entries != null) {this.entries = new ArrayList<dev.snowdrop.buildpack.model.EntriesBuilder>(); for (dev.snowdrop.buildpack.model.Entries item : entries){this.addToEntries(item);}} else { this.entries = null;} return (A) this;
    }

    public A withEntries(dev.snowdrop.buildpack.model.Entries... entries) {
        if (this.entries != null) {this.entries.clear();}
        if (entries != null) {for (dev.snowdrop.buildpack.model.Entries item :entries){ this.addToEntries(item);}} return (A) this;
    }

    public Boolean hasEntries() {
        return entries != null && !entries.isEmpty();
    }

    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> addNewEntry() {
        return new dev.snowdrop.buildpack.model.BuildPackPlanFluentImpl.EntriesNestedImpl();
    }

    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> addNewEntryLike(dev.snowdrop.buildpack.model.Entries item) {
        return new dev.snowdrop.buildpack.model.BuildPackPlanFluentImpl.EntriesNestedImpl(-1, item);
    }

    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> setNewEntryLike(int index,dev.snowdrop.buildpack.model.Entries item) {
        return new dev.snowdrop.buildpack.model.BuildPackPlanFluentImpl.EntriesNestedImpl(index, item);
    }

    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> editEntry(int index) {
        if (entries.size() <= index) throw new RuntimeException("Can't edit entries. Index exceeds size.");
        return setNewEntryLike(index, buildEntry(index));
    }

    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> editFirstEntry() {
        if (entries.size() == 0) throw new RuntimeException("Can't edit first entries. The list is empty.");
        return setNewEntryLike(0, buildEntry(0));
    }

    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> editLastEntry() {
        int index = entries.size() - 1;
        if (index < 0) throw new RuntimeException("Can't edit last entries. The list is empty.");
        return setNewEntryLike(index, buildEntry(index));
    }

    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> editMatchingEntry(Predicate<dev.snowdrop.buildpack.model.EntriesBuilder> predicate) {
        int index = -1;
        for (int i=0;i<entries.size();i++) {
        if (predicate.test(entries.get(i))) {index = i; break;}
        }
        if (index < 0) throw new RuntimeException("Can't edit matching entries. No match found.");
        return setNewEntryLike(index, buildEntry(index));
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildPackPlanFluentImpl that = (BuildPackPlanFluentImpl) o;
        if (entries != null ? !entries.equals(that.entries) :that.entries != null) return false;
        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(entries,  super.hashCode());
    }

    public class EntriesNestedImpl<N> extends dev.snowdrop.buildpack.model.EntriesFluentImpl<dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<N>> implements dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<N>,io.sundr.builder.Nested<N> {
        private final dev.snowdrop.buildpack.model.EntriesBuilder builder;
        private final int index;

            EntriesNestedImpl(int index,dev.snowdrop.buildpack.model.Entries item) {
                this.index = index;
                this.builder = new dev.snowdrop.buildpack.model.EntriesBuilder(this, item);
                        
            }

            EntriesNestedImpl() {
                this.index = -1;
                this.builder = new dev.snowdrop.buildpack.model.EntriesBuilder(this);
                        
            }

            public N and() {
                return (N) BuildPackPlanFluentImpl.this.setToEntries(index,builder.build());
            }

            public N endEntry() {
                return and();
            }
    }


}
