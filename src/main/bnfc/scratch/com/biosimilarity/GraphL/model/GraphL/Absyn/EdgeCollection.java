package com.biosimilarity.GraphL.model.GraphL.Absyn; // Java Package generated by the BNF Converter.

public abstract class EdgeCollection implements java.io.Serializable {
  public abstract <R,A> R accept(EdgeCollection.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntension p, A arg);
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtenionExpr p, A arg);

  }

}