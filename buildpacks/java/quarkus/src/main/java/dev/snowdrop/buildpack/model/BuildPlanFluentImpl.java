package dev.snowdrop.buildpack.model;

import io.sundr.builder.VisitableBuilder;
import io.sundr.builder.Nested;
import java.util.ArrayList;
import java.lang.String;
import java.util.function.Predicate;
import java.lang.Deprecated;
import io.sundr.builder.BaseFluent;
import java.util.Iterator;
import java.util.List;
import java.lang.Boolean;
import java.util.Collection;
import java.lang.Object;

public class BuildPlanFluentImpl<A extends dev.snowdrop.buildpack.model.BuildPlanFluent<A>> extends io.sundr.builder.BaseFluent<A> implements dev.snowdrop.buildpack.model.BuildPlanFluent<A> {

    private java.lang.String path;
    private java.util.List<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> requires;
    private java.util.List<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> provides;

    public BuildPlanFluentImpl() {
    }

    public BuildPlanFluentImpl(dev.snowdrop.buildpack.model.BuildPlan instance) {
        this.withPath(instance.getPath());
        
        this.withRequires(instance.getRequires());
        
        this.withProvides(instance.getProvides());
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public A withPath(java.lang.String path) {
        this.path=path; return (A) this;
    }

    public java.lang.Boolean hasPath() {
        return this.path != null;
    }

    
    @java.lang.Deprecated
        
    /**
     * Method is deprecated. use withPath instead.
     */
        public A withNewPath(java.lang.String original) {
        return (A)withPath(new String(original));
    }

    public A addToRequires(int index,dev.snowdrop.buildpack.model.BuildPlanRequire item) {
        if (this.requires == null) {this.requires = new java.util.ArrayList<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder>();}
        dev.snowdrop.buildpack.model.BuildPlanRequireBuilder builder = new dev.snowdrop.buildpack.model.BuildPlanRequireBuilder(item);_visitables.get("requires").add(index >= 0 ? index : _visitables.get("requires").size(), builder);this.requires.add(index >= 0 ? index : requires.size(), builder); return (A)this;
    }

    public A setToRequires(int index,dev.snowdrop.buildpack.model.BuildPlanRequire item) {
        if (this.requires == null) {this.requires = new java.util.ArrayList<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder>();}
        dev.snowdrop.buildpack.model.BuildPlanRequireBuilder builder = new dev.snowdrop.buildpack.model.BuildPlanRequireBuilder(item);
        if (index < 0 || index >= _visitables.get("requires").size()) { _visitables.get("requires").add(builder); } else { _visitables.get("requires").set(index, builder);}
        if (index < 0 || index >= requires.size()) { requires.add(builder); } else { requires.set(index, builder);}
         return (A)this;
    }

    public A addToRequires(dev.snowdrop.buildpack.model.BuildPlanRequire... items) {
        if (this.requires == null) {this.requires = new java.util.ArrayList<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder>();}
        for (dev.snowdrop.buildpack.model.BuildPlanRequire item : items) {dev.snowdrop.buildpack.model.BuildPlanRequireBuilder builder = new dev.snowdrop.buildpack.model.BuildPlanRequireBuilder(item);_visitables.get("requires").add(builder);this.requires.add(builder);} return (A)this;
    }

    public A addAllToRequires(java.util.Collection<dev.snowdrop.buildpack.model.BuildPlanRequire> items) {
        if (this.requires == null) {this.requires = new java.util.ArrayList<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder>();}
        for (dev.snowdrop.buildpack.model.BuildPlanRequire item : items) {dev.snowdrop.buildpack.model.BuildPlanRequireBuilder builder = new dev.snowdrop.buildpack.model.BuildPlanRequireBuilder(item);_visitables.get("requires").add(builder);this.requires.add(builder);} return (A)this;
    }

    public A removeFromRequires(dev.snowdrop.buildpack.model.BuildPlanRequire... items) {
        for (dev.snowdrop.buildpack.model.BuildPlanRequire item : items) {dev.snowdrop.buildpack.model.BuildPlanRequireBuilder builder = new dev.snowdrop.buildpack.model.BuildPlanRequireBuilder(item);_visitables.get("requires").remove(builder);if (this.requires != null) {this.requires.remove(builder);}} return (A)this;
    }

    public A removeAllFromRequires(java.util.Collection<dev.snowdrop.buildpack.model.BuildPlanRequire> items) {
        for (dev.snowdrop.buildpack.model.BuildPlanRequire item : items) {dev.snowdrop.buildpack.model.BuildPlanRequireBuilder builder = new dev.snowdrop.buildpack.model.BuildPlanRequireBuilder(item);_visitables.get("requires").remove(builder);if (this.requires != null) {this.requires.remove(builder);}} return (A)this;
    }

    public A removeMatchingFromRequires(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> predicate) {
        if (requires == null) return (A) this;
        final Iterator<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> each = requires.iterator();
        final List visitables = _visitables.get("requires");
        while (each.hasNext()) {
          dev.snowdrop.buildpack.model.BuildPlanRequireBuilder builder = each.next();
          if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
          }
        }
        return (A)this;
    }

    
    @java.lang.Deprecated
        
    /**
     * This method has been deprecated, please use method buildRequires instead.
     * @return The buildable object.
     */
        public java.util.List<dev.snowdrop.buildpack.model.BuildPlanRequire> getRequires() {
        return build(requires);
    }

    public java.util.List<dev.snowdrop.buildpack.model.BuildPlanRequire> buildRequires() {
        return build(requires);
    }

    public dev.snowdrop.buildpack.model.BuildPlanRequire buildRequire(int index) {
        return this.requires.get(index).build();
    }

    public dev.snowdrop.buildpack.model.BuildPlanRequire buildFirstRequire() {
        return this.requires.get(0).build();
    }

    public dev.snowdrop.buildpack.model.BuildPlanRequire buildLastRequire() {
        return this.requires.get(requires.size() - 1).build();
    }

    public dev.snowdrop.buildpack.model.BuildPlanRequire buildMatchingRequire(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> predicate) {
        for (dev.snowdrop.buildpack.model.BuildPlanRequireBuilder item: requires) { if(predicate.test(item)){ return item.build();} } return null;
    }

    public java.lang.Boolean hasMatchingRequire(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> predicate) {
        for (dev.snowdrop.buildpack.model.BuildPlanRequireBuilder item: requires) { if(predicate.test(item)){ return true;} } return false;
    }

    public A withRequires(java.util.List<dev.snowdrop.buildpack.model.BuildPlanRequire> requires) {
        if (this.requires != null) { _visitables.get("requires").removeAll(this.requires);}
        if (requires != null) {this.requires = new java.util.ArrayList<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder>(); for (dev.snowdrop.buildpack.model.BuildPlanRequire item : requires){this.addToRequires(item);}} else { this.requires = null;} return (A) this;
    }

    public A withRequires(dev.snowdrop.buildpack.model.BuildPlanRequire... requires) {
        if (this.requires != null) {this.requires.clear();}
        if (requires != null) {for (dev.snowdrop.buildpack.model.BuildPlanRequire item :requires){ this.addToRequires(item);}} return (A) this;
    }

    public java.lang.Boolean hasRequires() {
        return requires != null && !requires.isEmpty();
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> addNewRequire() {
        return new dev.snowdrop.buildpack.model.BuildPlanFluentImpl.RequiresNestedImpl();
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> addNewRequireLike(dev.snowdrop.buildpack.model.BuildPlanRequire item) {
        return new dev.snowdrop.buildpack.model.BuildPlanFluentImpl.RequiresNestedImpl(-1, item);
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> setNewRequireLike(int index,dev.snowdrop.buildpack.model.BuildPlanRequire item) {
        return new dev.snowdrop.buildpack.model.BuildPlanFluentImpl.RequiresNestedImpl(index, item);
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> editRequire(int index) {
        if (requires.size() <= index) throw new RuntimeException("Can't edit requires. Index exceeds size.");
        return setNewRequireLike(index, buildRequire(index));
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> editFirstRequire() {
        if (requires.size() == 0) throw new RuntimeException("Can't edit first requires. The list is empty.");
        return setNewRequireLike(0, buildRequire(0));
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> editLastRequire() {
        int index = requires.size() - 1;
        if (index < 0) throw new RuntimeException("Can't edit last requires. The list is empty.");
        return setNewRequireLike(index, buildRequire(index));
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<A> editMatchingRequire(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanRequireBuilder> predicate) {
        int index = -1;
        for (int i=0;i<requires.size();i++) { 
        if (predicate.test(requires.get(i))) {index = i; break;}
        } 
        if (index < 0) throw new RuntimeException("Can't edit matching requires. No match found.");
        return setNewRequireLike(index, buildRequire(index));
    }

    public A addToProvides(int index,dev.snowdrop.buildpack.model.BuildPlanProvide item) {
        if (this.provides == null) {this.provides = new java.util.ArrayList<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder>();}
        dev.snowdrop.buildpack.model.BuildPlanProvideBuilder builder = new dev.snowdrop.buildpack.model.BuildPlanProvideBuilder(item);_visitables.get("provides").add(index >= 0 ? index : _visitables.get("provides").size(), builder);this.provides.add(index >= 0 ? index : provides.size(), builder); return (A)this;
    }

    public A setToProvides(int index,dev.snowdrop.buildpack.model.BuildPlanProvide item) {
        if (this.provides == null) {this.provides = new java.util.ArrayList<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder>();}
        dev.snowdrop.buildpack.model.BuildPlanProvideBuilder builder = new dev.snowdrop.buildpack.model.BuildPlanProvideBuilder(item);
        if (index < 0 || index >= _visitables.get("provides").size()) { _visitables.get("provides").add(builder); } else { _visitables.get("provides").set(index, builder);}
        if (index < 0 || index >= provides.size()) { provides.add(builder); } else { provides.set(index, builder);}
         return (A)this;
    }

    public A addToProvides(dev.snowdrop.buildpack.model.BuildPlanProvide... items) {
        if (this.provides == null) {this.provides = new java.util.ArrayList<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder>();}
        for (dev.snowdrop.buildpack.model.BuildPlanProvide item : items) {dev.snowdrop.buildpack.model.BuildPlanProvideBuilder builder = new dev.snowdrop.buildpack.model.BuildPlanProvideBuilder(item);_visitables.get("provides").add(builder);this.provides.add(builder);} return (A)this;
    }

    public A addAllToProvides(java.util.Collection<dev.snowdrop.buildpack.model.BuildPlanProvide> items) {
        if (this.provides == null) {this.provides = new java.util.ArrayList<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder>();}
        for (dev.snowdrop.buildpack.model.BuildPlanProvide item : items) {dev.snowdrop.buildpack.model.BuildPlanProvideBuilder builder = new dev.snowdrop.buildpack.model.BuildPlanProvideBuilder(item);_visitables.get("provides").add(builder);this.provides.add(builder);} return (A)this;
    }

    public A removeFromProvides(dev.snowdrop.buildpack.model.BuildPlanProvide... items) {
        for (dev.snowdrop.buildpack.model.BuildPlanProvide item : items) {dev.snowdrop.buildpack.model.BuildPlanProvideBuilder builder = new dev.snowdrop.buildpack.model.BuildPlanProvideBuilder(item);_visitables.get("provides").remove(builder);if (this.provides != null) {this.provides.remove(builder);}} return (A)this;
    }

    public A removeAllFromProvides(java.util.Collection<dev.snowdrop.buildpack.model.BuildPlanProvide> items) {
        for (dev.snowdrop.buildpack.model.BuildPlanProvide item : items) {dev.snowdrop.buildpack.model.BuildPlanProvideBuilder builder = new dev.snowdrop.buildpack.model.BuildPlanProvideBuilder(item);_visitables.get("provides").remove(builder);if (this.provides != null) {this.provides.remove(builder);}} return (A)this;
    }

    public A removeMatchingFromProvides(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> predicate) {
        if (provides == null) return (A) this;
        final Iterator<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> each = provides.iterator();
        final List visitables = _visitables.get("provides");
        while (each.hasNext()) {
          dev.snowdrop.buildpack.model.BuildPlanProvideBuilder builder = each.next();
          if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
          }
        }
        return (A)this;
    }

    
    @java.lang.Deprecated
        
    /**
     * This method has been deprecated, please use method buildProvides instead.
     * @return The buildable object.
     */
        public java.util.List<dev.snowdrop.buildpack.model.BuildPlanProvide> getProvides() {
        return build(provides);
    }

    public java.util.List<dev.snowdrop.buildpack.model.BuildPlanProvide> buildProvides() {
        return build(provides);
    }

    public dev.snowdrop.buildpack.model.BuildPlanProvide buildProvide(int index) {
        return this.provides.get(index).build();
    }

    public dev.snowdrop.buildpack.model.BuildPlanProvide buildFirstProvide() {
        return this.provides.get(0).build();
    }

    public dev.snowdrop.buildpack.model.BuildPlanProvide buildLastProvide() {
        return this.provides.get(provides.size() - 1).build();
    }

    public dev.snowdrop.buildpack.model.BuildPlanProvide buildMatchingProvide(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> predicate) {
        for (dev.snowdrop.buildpack.model.BuildPlanProvideBuilder item: provides) { if(predicate.test(item)){ return item.build();} } return null;
    }

    public java.lang.Boolean hasMatchingProvide(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> predicate) {
        for (dev.snowdrop.buildpack.model.BuildPlanProvideBuilder item: provides) { if(predicate.test(item)){ return true;} } return false;
    }

    public A withProvides(java.util.List<dev.snowdrop.buildpack.model.BuildPlanProvide> provides) {
        if (this.provides != null) { _visitables.get("provides").removeAll(this.provides);}
        if (provides != null) {this.provides = new java.util.ArrayList<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder>(); for (dev.snowdrop.buildpack.model.BuildPlanProvide item : provides){this.addToProvides(item);}} else { this.provides = null;} return (A) this;
    }

    public A withProvides(dev.snowdrop.buildpack.model.BuildPlanProvide... provides) {
        if (this.provides != null) {this.provides.clear();}
        if (provides != null) {for (dev.snowdrop.buildpack.model.BuildPlanProvide item :provides){ this.addToProvides(item);}} return (A) this;
    }

    public java.lang.Boolean hasProvides() {
        return provides != null && !provides.isEmpty();
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> addNewProvide() {
        return new dev.snowdrop.buildpack.model.BuildPlanFluentImpl.ProvidesNestedImpl();
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> addNewProvideLike(dev.snowdrop.buildpack.model.BuildPlanProvide item) {
        return new dev.snowdrop.buildpack.model.BuildPlanFluentImpl.ProvidesNestedImpl(-1, item);
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> setNewProvideLike(int index,dev.snowdrop.buildpack.model.BuildPlanProvide item) {
        return new dev.snowdrop.buildpack.model.BuildPlanFluentImpl.ProvidesNestedImpl(index, item);
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> editProvide(int index) {
        if (provides.size() <= index) throw new RuntimeException("Can't edit provides. Index exceeds size.");
        return setNewProvideLike(index, buildProvide(index));
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> editFirstProvide() {
        if (provides.size() == 0) throw new RuntimeException("Can't edit first provides. The list is empty.");
        return setNewProvideLike(0, buildProvide(0));
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> editLastProvide() {
        int index = provides.size() - 1;
        if (index < 0) throw new RuntimeException("Can't edit last provides. The list is empty.");
        return setNewProvideLike(index, buildProvide(index));
    }

    public dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<A> editMatchingProvide(java.util.function.Predicate<dev.snowdrop.buildpack.model.BuildPlanProvideBuilder> predicate) {
        int index = -1;
        for (int i=0;i<provides.size();i++) { 
        if (predicate.test(provides.get(i))) {index = i; break;}
        } 
        if (index < 0) throw new RuntimeException("Can't edit matching provides. No match found.");
        return setNewProvideLike(index, buildProvide(index));
    }

    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildPlanFluentImpl that = (BuildPlanFluentImpl) o;
        if (path != null ? !path.equals(that.path) :that.path != null) return false;
        if (requires != null ? !requires.equals(that.requires) :that.requires != null) return false;
        if (provides != null ? !provides.equals(that.provides) :that.provides != null) return false;
        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(path,  requires,  provides,  super.hashCode());
    }

    public class RequiresNestedImpl<N> extends dev.snowdrop.buildpack.model.BuildPlanRequireFluentImpl<dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<N>> implements dev.snowdrop.buildpack.model.BuildPlanFluent.RequiresNested<N>,io.sundr.builder.Nested<N> {
        private final dev.snowdrop.buildpack.model.BuildPlanRequireBuilder builder;
        private final int index;

            RequiresNestedImpl(int index,dev.snowdrop.buildpack.model.BuildPlanRequire item) {
                this.index = index;
                this.builder = new dev.snowdrop.buildpack.model.BuildPlanRequireBuilder(this, item);
                        
            }

            RequiresNestedImpl() {
                this.index = -1;
                this.builder = new dev.snowdrop.buildpack.model.BuildPlanRequireBuilder(this);
                        
            }

            public N and() {
                return (N) BuildPlanFluentImpl.this.setToRequires(index,builder.build());
            }

            public N endRequire() {
                return and();
            }
    }


    public class ProvidesNestedImpl<N> extends dev.snowdrop.buildpack.model.BuildPlanProvideFluentImpl<dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<N>> implements dev.snowdrop.buildpack.model.BuildPlanFluent.ProvidesNested<N>,io.sundr.builder.Nested<N> {
        private final dev.snowdrop.buildpack.model.BuildPlanProvideBuilder builder;
        private final int index;

            ProvidesNestedImpl(int index,dev.snowdrop.buildpack.model.BuildPlanProvide item) {
                this.index = index;
                this.builder = new dev.snowdrop.buildpack.model.BuildPlanProvideBuilder(this, item);
                        
            }

            ProvidesNestedImpl() {
                this.index = -1;
                this.builder = new dev.snowdrop.buildpack.model.BuildPlanProvideBuilder(this);
                        
            }

            public N and() {
                return (N) BuildPlanFluentImpl.this.setToProvides(index,builder.build());
            }

            public N endProvide() {
                return and();
            }
    }


}
