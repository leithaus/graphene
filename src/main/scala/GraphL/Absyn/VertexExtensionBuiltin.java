package com.biosimilarity.GraphL.model.GraphL.Absyn; // Java Package generated by the BNF Converter.

public abstract class VertexExtensionBuiltin implements java.io.Serializable {
  public abstract <R,A> R accept(VertexExtensionBuiltin.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSet p, A arg);
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SourceSet p, A arg);
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SinkSet p, A arg);

  }

}
