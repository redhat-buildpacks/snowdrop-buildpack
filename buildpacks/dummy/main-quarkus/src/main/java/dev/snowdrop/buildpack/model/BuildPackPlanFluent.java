package dev.snowdrop.buildpack.model;

import io.sundr.builder.VisitableBuilder;
import io.sundr.builder.Fluent;
import io.sundr.builder.Nested;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.lang.Deprecated;
import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import java.lang.Boolean;

public interface BuildPackPlanFluent<A extends dev.snowdrop.buildpack.model.BuildPackPlanFluent<A>> extends io.sundr.builder.Fluent<A> {


    public A addToEntries(int index,dev.snowdrop.buildpack.model.Entries item);
    public A setToEntries(int index,dev.snowdrop.buildpack.model.Entries item);
    public A addToEntries(dev.snowdrop.buildpack.model.Entries... items);
    public A addAllToEntries(java.util.Collection<dev.snowdrop.buildpack.model.Entries> items);
    public A removeFromEntries(dev.snowdrop.buildpack.model.Entries... items);
    public A removeAllFromEntries(java.util.Collection<dev.snowdrop.buildpack.model.Entries> items);
    public A removeMatchingFromEntries(java.util.function.Predicate<dev.snowdrop.buildpack.model.EntriesBuilder> predicate);
    
    @java.lang.Deprecated
        
    /**
     * This method has been deprecated, please use method buildEntries instead.
     * @return The buildable object.
     */
        public java.util.List<dev.snowdrop.buildpack.model.Entries> getEntries();
    public java.util.List<dev.snowdrop.buildpack.model.Entries> buildEntries();
    public dev.snowdrop.buildpack.model.Entries buildEntry(int index);
    public dev.snowdrop.buildpack.model.Entries buildFirstEntry();
    public dev.snowdrop.buildpack.model.Entries buildLastEntry();
    public dev.snowdrop.buildpack.model.Entries buildMatchingEntry(java.util.function.Predicate<dev.snowdrop.buildpack.model.EntriesBuilder> predicate);
    public java.lang.Boolean hasMatchingEntry(java.util.function.Predicate<dev.snowdrop.buildpack.model.EntriesBuilder> predicate);
    public A withEntries(java.util.List<dev.snowdrop.buildpack.model.Entries> entries);
    public A withEntries(dev.snowdrop.buildpack.model.Entries... entries);
    public java.lang.Boolean hasEntries();
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> addNewEntry();
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> addNewEntryLike(dev.snowdrop.buildpack.model.Entries item);
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> setNewEntryLike(int index,dev.snowdrop.buildpack.model.Entries item);
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> editEntry(int index);
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> editFirstEntry();
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> editLastEntry();
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> editMatchingEntry(java.util.function.Predicate<dev.snowdrop.buildpack.model.EntriesBuilder> predicate);
    public interface EntriesNested<N> extends io.sundr.builder.Nested<N>,dev.snowdrop.buildpack.model.EntriesFluent<dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<N>> {

            public N and();
            public N endEntry();    }


}
