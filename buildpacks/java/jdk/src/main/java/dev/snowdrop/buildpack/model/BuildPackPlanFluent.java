package dev.snowdrop.buildpack.model;

import io.sundr.builder.Fluent;
import io.sundr.builder.Nested;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public interface BuildPackPlanFluent<A extends dev.snowdrop.buildpack.model.BuildPackPlanFluent<A>> extends io.sundr.builder.Fluent<A> {


    public A addToEntries(int index,dev.snowdrop.buildpack.model.Entries item);
    public A setToEntries(int index,dev.snowdrop.buildpack.model.Entries item);
    public A addToEntries(dev.snowdrop.buildpack.model.Entries... items);
    public A addAllToEntries(Collection<dev.snowdrop.buildpack.model.Entries> items);
    public A removeFromEntries(dev.snowdrop.buildpack.model.Entries... items);
    public A removeAllFromEntries(Collection<dev.snowdrop.buildpack.model.Entries> items);
    public A removeMatchingFromEntries(Predicate<dev.snowdrop.buildpack.model.EntriesBuilder> predicate);

    @Deprecated

    /**
     * This method has been deprecated, please use method buildEntries instead.
     * @return The buildable object.
     */
        public List<dev.snowdrop.buildpack.model.Entries> getEntries();
    public List<dev.snowdrop.buildpack.model.Entries> buildEntries();
    public dev.snowdrop.buildpack.model.Entries buildEntry(int index);
    public dev.snowdrop.buildpack.model.Entries buildFirstEntry();
    public dev.snowdrop.buildpack.model.Entries buildLastEntry();
    public dev.snowdrop.buildpack.model.Entries buildMatchingEntry(Predicate<dev.snowdrop.buildpack.model.EntriesBuilder> predicate);
    public Boolean hasMatchingEntry(Predicate<dev.snowdrop.buildpack.model.EntriesBuilder> predicate);
    public A withEntries(List<dev.snowdrop.buildpack.model.Entries> entries);
    public A withEntries(dev.snowdrop.buildpack.model.Entries... entries);
    public Boolean hasEntries();
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> addNewEntry();
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> addNewEntryLike(dev.snowdrop.buildpack.model.Entries item);
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> setNewEntryLike(int index,dev.snowdrop.buildpack.model.Entries item);
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> editEntry(int index);
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> editFirstEntry();
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> editLastEntry();
    public dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<A> editMatchingEntry(Predicate<dev.snowdrop.buildpack.model.EntriesBuilder> predicate);
    public interface EntriesNested<N> extends io.sundr.builder.Nested<N>,dev.snowdrop.buildpack.model.EntriesFluent<dev.snowdrop.buildpack.model.BuildPackPlanFluent.EntriesNested<N>> {

            public N and();
            public N endEntry();    }


}
