package com.biosimilarity.GraphL.model.GraphL;

import com.biosimilarity.GraphL.model.GraphL.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* GraphExpr */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Isolated p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphexpr_1.accept(this, arg), r, arg);
      r = combine(p.graphexpr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Selected p, A arg) {
      R r = leaf(arg);
      r = combine(p.selectionexpr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Connected p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgeplus_.accept(this, arg), r, arg);
      r = combine(p.vertexselectionexpr_1.accept(this, arg), r, arg);
      r = combine(p.vertexselectionexpr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Recursed p, A arg) {
      R r = leaf(arg);
      r = combine(p.formals_.accept(this, arg), r, arg);
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      r = combine(p.actuals_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Pointed p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertex_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Variable p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Applied p, A arg) {
      R r = leaf(arg);
      r = combine(p.actuals_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Empty p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Formals */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsFullForm p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsVertexForm p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Actuals */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsFullForm p, A arg) {
      R r = leaf(arg);
      for (VertexActual x : p.listvertexactual_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      for (EdgeActual x : p.listedgeactual_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsVertexForm p, A arg) {
      R r = leaf(arg);
      for (VertexActual x : p.listvertexactual_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }

/* SelectionExpr */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Selection p, A arg) {
      R r = leaf(arg);
      for (Binding x : p.listbinding_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.comprehension_.accept(this, arg), r, arg);
      return r;
    }

/* VertexSelectionExpr */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection p, A arg) {
      R r = leaf(arg);
      for (VertexBinding x : p.listvertexbinding_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntensionSelection p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexcomprehension_.accept(this, arg), r, arg);
      return r;
    }

/* Comprehension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionForm p, A arg) {
      R r = leaf(arg);
      r = combine(p.generator_.accept(this, arg), r, arg);
      for (LogicalOrDecl x : p.listlogicalordecl_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }

/* VertexComprehension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehensionForm p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexgenerator_.accept(this, arg), r, arg);
      for (LogicalOrDecl x : p.listlogicalordecl_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }

/* EdgeComprehension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehensionForm p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgegenerator_.accept(this, arg), r, arg);
      for (LogicalOrDecl x : p.listlogicalordecl_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }

/* GraphComprehension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehensionForm p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphgenerator_.accept(this, arg), r, arg);
      for (LogicalOrDecl x : p.listlogicalordecl_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }

/* VertexBinding */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundVertex p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexdeconstructor_.accept(this, arg), r, arg);
      r = combine(p.vertex_.accept(this, arg), r, arg);
      return r;
    }

/* EdgeBinding */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundEdge p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgedeconstructor_.accept(this, arg), r, arg);
      r = combine(p.edgeexpr_.accept(this, arg), r, arg);
      return r;
    }

/* GraphBinding */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundGraph p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphdeconstructor_.accept(this, arg), r, arg);
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }

/* Binding */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundVertex p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexbinding_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundEdge p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgebinding_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundGraph p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphbinding_.accept(this, arg), r, arg);
      return r;
    }

/* VertexGenerator */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenVertex p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexdeconstructor_.accept(this, arg), r, arg);
      r = combine(p.vertexcollection_.accept(this, arg), r, arg);
      return r;
    }

/* EdgeGenerator */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenEdge p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgedeconstructor_.accept(this, arg), r, arg);
      r = combine(p.edgecollection_.accept(this, arg), r, arg);
      return r;
    }

/* GraphGenerator */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenGraph p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphdeconstructor_.accept(this, arg), r, arg);
      r = combine(p.graphcollection_.accept(this, arg), r, arg);
      return r;
    }

/* Generator */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GenVertex p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexgenerator_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GenEdge p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgegenerator_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphgenerator_.accept(this, arg), r, arg);
      return r;
    }

/* VertexExpr */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSum p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexexpr_1.accept(this, arg), r, arg);
      r = combine(p.vertexexpr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexMult p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexexpr_1.accept(this, arg), r, arg);
      r = combine(p.vertexexpr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexLiteral p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertex_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexVariable p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexNegated p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexexpr_.accept(this, arg), r, arg);
      return r;
    }

/* VertexDeconstructor */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExprLabel p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexexpr_.accept(this, arg), r, arg);
      return r;
    }

/* VertexActual */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActualized p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexexpr_.accept(this, arg), r, arg);
      return r;
    }

/* EdgeExpr */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprNominal p, A arg) {
      R r = leaf(arg);
      r = combine(p.edge_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprStruct p, A arg) {
      R r = leaf(arg);
      r = combine(p.edge_.accept(this, arg), r, arg);
      r = combine(p.vertexexpr_1.accept(this, arg), r, arg);
      r = combine(p.vertexexpr_2.accept(this, arg), r, arg);
      return r;
    }

/* EdgePlus */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeName p, A arg) {
      R r = leaf(arg);
      r = combine(p.edge_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeWildcard p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* EdgeLabel */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLiteral p, A arg) {
      R r = leaf(arg);
      r = combine(p.edge_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeVariable p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* EdgeExprPattern */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprLabel p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgelabel_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternStruct p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgedeconstructor_.accept(this, arg), r, arg);
      return r;
    }

/* EdgeActual */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActualized p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgelabel_.accept(this, arg), r, arg);
      return r;
    }

/* EdgeDeconstructor */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternDecon p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgelabel_.accept(this, arg), r, arg);
      r = combine(p.vertexdeconstructor_1.accept(this, arg), r, arg);
      r = combine(p.vertexdeconstructor_2.accept(this, arg), r, arg);
      return r;
    }

/* GraphDeconstructor */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedPattern p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphdeconstructor_1.accept(this, arg), r, arg);
      r = combine(p.graphdeconstructor_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedPattern p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexdeconstructor_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedPattern p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgelabel_.accept(this, arg), r, arg);
      r = combine(p.graphdeconstructor_1.accept(this, arg), r, arg);
      r = combine(p.graphdeconstructor_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphLiteral p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }

/* LogicalOrDecl */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.JudgmentExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.satisfaction_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.DeclIn p, A arg) {
      R r = leaf(arg);
      r = combine(p.decl_.accept(this, arg), r, arg);
      return r;
    }

/* Satisfaction */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexJudgement p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexdeconstructor_.accept(this, arg), r, arg);
      r = combine(p.vertexstructurecondition_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeJudgement p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgedeconstructor_.accept(this, arg), r, arg);
      r = combine(p.edgelabelcondition_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphJudgement p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphdeconstructor_.accept(this, arg), r, arg);
      r = combine(p.condition_.accept(this, arg), r, arg);
      return r;
    }

/* Decl */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.generator_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LocalDecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.binding_.accept(this, arg), r, arg);
      return r;
    }

/* VertexCollection */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntension p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexcomprehension_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtenionExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexextension_.accept(this, arg), r, arg);
      return r;
    }

/* EdgeCollection */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntension p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgecomprehension_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtenionExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgeextension_.accept(this, arg), r, arg);
      return r;
    }

/* GraphCollection */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIntension p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphcomprehension_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtenionExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphextension_.accept(this, arg), r, arg);
      return r;
    }

/* VertexExtension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionForm p, A arg) {
      R r = leaf(arg);
      for (Vertex x : p.listvertex_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltinExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexextensionbuiltin_.accept(this, arg), r, arg);
      return r;
    }

/* EdgeExtension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionForm p, A arg) {
      R r = leaf(arg);
      for (Edge x : p.listedge_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltinExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgeextensionbuiltin_.accept(this, arg), r, arg);
      return r;
    }

/* GraphExtension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionForm p, A arg) {
      R r = leaf(arg);
      for (GraphExpr x : p.listgraphexpr_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltinExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphextensionbuiltin_.accept(this, arg), r, arg);
      return r;
    }

/* VertexExtensionBuiltin */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSet p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SourceSet p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SinkSet p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }

/* EdgeExtensionBuiltin */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeSet p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }

/* GraphExtensionBuiltin */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComponents p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }

/* Condition */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ConjunctionCondition p, A arg) {
      R r = leaf(arg);
      r = combine(p.condition_1.accept(this, arg), r, arg);
      r = combine(p.condition_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.DisjunctionCondition p, A arg) {
      R r = leaf(arg);
      r = combine(p.condition_1.accept(this, arg), r, arg);
      r = combine(p.condition_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.StructuralCondition p, A arg) {
      R r = leaf(arg);
      r = combine(p.structurecondition_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BaseCondition p, A arg) {
      R r = leaf(arg);
      r = combine(p.groundcondition_.accept(this, arg), r, arg);
      return r;
    }

/* StructureCondition */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedCond p, A arg) {
      R r = leaf(arg);
      r = combine(p.structurecondition_1.accept(this, arg), r, arg);
      r = combine(p.structurecondition_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedCond p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexstructurecondition_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedCond p, A arg) {
      R r = leaf(arg);
      r = combine(p.edgelabelcondition_.accept(this, arg), r, arg);
      r = combine(p.structurecondition_1.accept(this, arg), r, arg);
      r = combine(p.structurecondition_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphStructureLiteral p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }

/* VertexStructureCondition */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureSum p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexstructurecondition_1.accept(this, arg), r, arg);
      r = combine(p.vertexstructurecondition_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexstructurecondition_1.accept(this, arg), r, arg);
      r = combine(p.vertexstructurecondition_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureLiteral p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertex_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureVariable p, A arg) {
      R r = leaf(arg);
      r = combine(p.atomicformula_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureNegated p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexstructurecondition_.accept(this, arg), r, arg);
      return r;
    }

/* EdgeLabelCondition */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelLiteralCondition p, A arg) {
      R r = leaf(arg);
      r = combine(p.edge_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelAtomicCondition p, A arg) {
      R r = leaf(arg);
      r = combine(p.atomicformula_.accept(this, arg), r, arg);
      return r;
    }

/* GroundCondition */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltinExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexbuiltin_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltinExpr p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphbuiltin_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicCondition p, A arg) {
      R r = leaf(arg);
      r = combine(p.atomicformula_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.NegatedCondition p, A arg) {
      R r = leaf(arg);
      r = combine(p.groundcondition_.accept(this, arg), r, arg);
      return r;
    }

/* VertexBuiltin */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SinkBuiltin p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexexpr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SourceBuiltin p, A arg) {
      R r = leaf(arg);
      r = combine(p.vertexexpr_.accept(this, arg), r, arg);
      return r;
    }

/* GraphBuiltin */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EmptyGraphBuiltin p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }

/* AtomicFormula */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Verity p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Absurdity p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Nullity p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Edge */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeQuotation p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntegral p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeString p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* Vertex */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexQuotation p, A arg) {
      R r = leaf(arg);
      r = combine(p.graphexpr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntegral p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexString p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
