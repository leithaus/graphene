package com.biosimilarity.GraphL.model.GraphL.Absyn; // Java Package generated by the BNF Converter.

public class VertexSelection extends VertexSelectionExpr {
  public final ListVertexBinding listvertexbinding_;
  public final GraphExpr graphexpr_;

  public VertexSelection(ListVertexBinding p1, GraphExpr p2) { listvertexbinding_ = p1; graphexpr_ = p2; }

  public <R,A> R accept(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelectionExpr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection) {
      com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection x = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection)o;
      return this.listvertexbinding_.equals(x.listvertexbinding_) && this.graphexpr_.equals(x.graphexpr_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.listvertexbinding_.hashCode())+this.graphexpr_.hashCode();
  }


}
