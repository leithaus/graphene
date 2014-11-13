package com.biosimilarity.GraphL.model.GraphL.Absyn; // Java Package generated by the BNF Converter.

public class VertexStructureMult extends VertexStructureCondition {
  public final VertexStructureCondition vertexstructurecondition_1, vertexstructurecondition_2;

  public VertexStructureMult(VertexStructureCondition p1, VertexStructureCondition p2) { vertexstructurecondition_1 = p1; vertexstructurecondition_2 = p2; }

  public <R,A> R accept(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureCondition.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult) {
      com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult x = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult)o;
      return this.vertexstructurecondition_1.equals(x.vertexstructurecondition_1) && this.vertexstructurecondition_2.equals(x.vertexstructurecondition_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.vertexstructurecondition_1.hashCode())+this.vertexstructurecondition_2.hashCode();
  }


}