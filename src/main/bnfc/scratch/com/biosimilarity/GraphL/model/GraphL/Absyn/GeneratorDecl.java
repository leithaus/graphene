package com.biosimilarity.GraphL.model.GraphL.Absyn; // Java Package generated by the BNF Converter.

public class GeneratorDecl extends Decl {
  public final Generator generator_;

  public GeneratorDecl(Generator p1) { generator_ = p1; }

  public <R,A> R accept(com.biosimilarity.GraphL.model.GraphL.Absyn.Decl.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl) {
      com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl x = (com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl)o;
      return this.generator_.equals(x.generator_);
    }
    return false;
  }

  public int hashCode() {
    return this.generator_.hashCode();
  }


}
