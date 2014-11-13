package com.biosimilarity.GraphL.model.GraphL.Absyn; // Java Package generated by the BNF Converter.

public class GenGraph extends Generator {
  public final GraphGenerator graphgenerator_;

  public GenGraph(GraphGenerator p1) { graphgenerator_ = p1; }

  public <R,A> R accept(com.biosimilarity.GraphL.model.GraphL.Absyn.Generator.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph) {
      com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph x = (com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph)o;
      return this.graphgenerator_.equals(x.graphgenerator_);
    }
    return false;
  }

  public int hashCode() {
    return this.graphgenerator_.hashCode();
  }


}