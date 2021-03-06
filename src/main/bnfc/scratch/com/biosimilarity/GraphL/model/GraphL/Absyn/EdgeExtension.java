package com.biosimilarity.GraphL.model.GraphL.Absyn; // Java Package generated by the BNF Converter.

public abstract class EdgeExtension implements java.io.Serializable {
  public abstract <R,A> R accept(EdgeExtension.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionForm p, A arg);
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltinExpr p, A arg);

  }

}
