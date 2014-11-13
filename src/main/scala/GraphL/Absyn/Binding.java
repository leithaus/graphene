package com.biosimilarity.GraphL.model.GraphL.Absyn; // Java Package generated by the BNF Converter.

public abstract class Binding implements java.io.Serializable {
  public abstract <R,A> R accept(Binding.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundVertex p, A arg);
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundEdge p, A arg);
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundGraph p, A arg);

  }

}