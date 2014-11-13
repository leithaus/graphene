package com.biosimilarity.GraphL.model.GraphL.Absyn; // Java Package generated by the BNF Converter.

public abstract class EdgeLabelCondition implements java.io.Serializable {
  public abstract <R,A> R accept(EdgeLabelCondition.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelLiteralCondition p, A arg);
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelAtomicCondition p, A arg);

  }

}