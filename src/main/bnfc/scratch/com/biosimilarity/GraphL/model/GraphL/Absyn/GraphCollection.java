package com.biosimilarity.GraphL.model.GraphL.Absyn; // Java Package generated by the BNF Converter.

public abstract class GraphCollection implements java.io.Serializable {
  public abstract <R,A> R accept(GraphCollection.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIntension p, A arg);
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtenionExpr p, A arg);

  }

}