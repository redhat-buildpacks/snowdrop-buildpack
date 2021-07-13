package dev.snowdrop.buildpack.model;

import io.sundr.builder.VisitableBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.sundr.builder.Fluent;
import io.sundr.builder.Nested;
import java.util.ArrayList;
import java.lang.String;
import java.util.function.Predicate;
import java.lang.Deprecated;
import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import java.lang.Boolean;

public interface BuildPlanFluent<A extends dev.snowdrop.buildpack.model.BuildPlanFluent<A>> extends io.sundr.builder.Fluent<A> {


    public java.lang.String getPath();
    public A withPath(java.lang.String path);
    public java.lang.Boolean hasPath();
    
    @java.lang.Deprecated
        
    /**
     * Method is deprecated. use withPath instead.
     */
        public A withNewPath(java.lang.String original);
    public A addToRequires(int index,dev.snowdrop.buildpack.model.BuildPlanRequire item);
    public A setToRequires(int index,dev.snowdrop.buildpack.model.BuildPlanRequire item);
    public A addToRequires(dev.snowdrop.buildpack.model.BuildPlanRequire... items);
    public A addAllToRequires(java.util.Collection<dev.snowdrop.buildpack.model.BuildPlanRequire> items);
    public A removeFromRequires(dev.snowdrop.buildpack.model.BuildPlanRequire... items);
    public A removeAllFromRequires(java.util.Collection<dev.snowdrop.buildpack.model.BuildPlanRequire> items);
    public A removeMatchingFromRequires(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> predicate);
    
    @java.lang.Deprecated
        
    /**
     * This method has been deprecated, please use method buildRequires instead.
     * @return The buildable object.
     */
        public java.util.List<dev.snowdrop.buildpack.model.BuildPlanRequire> getRequires();
    public java.util.List<dev.snowdrop.buildpack.model.BuildPlanRequire> buildRequires();
    public dev.snowdrop.buildpack.model.BuildPlanRequire buildRequire(int index);
    public dev.snowdrop.buildpack.model.BuildPlanRequire buildFirstRequire();
    public dev.snowdrop.buildpack.model.BuildPlanRequire buildLastRequire();
    public dev.snowdrop.buildpack.model.BuildPlanRequire buildMatchingRequire(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> predicate);
    public java.lang.Boolean hasMatchingRequire(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> predicate);
    public A withRequires(java.util.List<dev.snowdrop.buildpack.model.BuildPlanRequire> requires);
    public A withRequires(dev.snowdrop.buildpack.model.BuildPlanRequire... requires);
    public java.lang.Boolean hasRequires();
    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> addNewRequire();
    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> addNewRequireLike(dev.snowdrop.buildpack.model.BuildPlanRequire item);
    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> setNewRequireLike(int index,dev.snowdrop.buildpack.model.BuildPlanRequire item);
    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> editRequire(int index);
    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> editFirstRequire();
    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> editLastRequire();
    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> editMatchingRequire(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> predicate);
    public A addToProvides(int index,dev.snowdrop.buildpack.model.BuildPlanProvide item);
    public A setToProvides(int index,dev.snowdrop.buildpack.model.BuildPlanProvide item);
    public A addToProvides(dev.snowdrop.buildpack.model.BuildPlanProvide... items);
    public A addAllToProvides(java.util.Collection<dev.snowdrop.buildpack.model.BuildPlanProvide> items);
    public A removeFromProvides(dev.snowdrop.buildpack.model.BuildPlanProvide... items);
    public A removeAllFromProvides(java.util.Collection<dev.snowdrop.buildpack.model.BuildPlanProvide> items);
    public A removeMatchingFromProvides(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> predicate);
    
    @java.lang.Deprecated
        
    /**
     * This method has been deprecated, please use method buildProvides instead.
     * @return The buildable object.
     */
        public java.util.List<dev.snowdrop.buildpack.model.BuildPlanProvide> getProvides();
    public java.util.List<dev.snowdrop.buildpack.model.BuildPlanProvide> buildProvides();
    public dev.snowdrop.buildpack.model.BuildPlanProvide buildProvide(int index);
    public dev.snowdrop.buildpack.model.BuildPlanProvide buildFirstProvide();
    public dev.snowdrop.buildpack.model.BuildPlanProvide buildLastProvide();
    public dev.snowdrop.buildpack.model.BuildPlanProvide buildMatchingProvide(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> predicate);
    public java.lang.Boolean hasMatchingProvide(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> predicate);
    public A withProvides(java.util.List<dev.snowdrop.buildpack.model.BuildPlanProvide> provides);
    public A withProvides(dev.snowdrop.buildpack.model.BuildPlanProvide... provides);
    public java.lang.Boolean hasProvides();
    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> addNewProvide();
    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> addNewProvideLike(dev.snowdrop.buildpack.model.BuildPlanProvide item);
    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> setNewProvideLike(int index,dev.snowdrop.buildpack.model.BuildPlanProvide item);
    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> editProvide(int index);
    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> editFirstProvide();
    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> editLastProvide();
    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> editMatchingProvide(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> predicate);
    public interface RequiresNested<N> extends io.sundr.builder.Nested<N>,dev.snowdrop.buildpack.model.BuildPlanRequireFluent<dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<N>> {

            public N and();
            public N endRequire();    }


    public interface ProvidesNested<N> extends io.sundr.builder.Nested<N>,dev.snowdrop.buildpack.model.BuildPlanProvideFluent<dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<N>> {

            public N and();
            public N endProvide();    }


}
