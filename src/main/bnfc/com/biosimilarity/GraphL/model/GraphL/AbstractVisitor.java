package com.biosimilarity.GraphL.model.GraphL;
import com.biosimilarity.GraphL.model.GraphL.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* GraphExpr */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Isolated p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Selected p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Connected p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Recursed p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Pointed p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Variable p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Applied p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Empty p, A arg) { return visitDefault(p, arg); }

    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExpr p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Formals */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsFullForm p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsVertexForm p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.Formals p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Actuals */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsFullForm p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsVertexForm p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.Actuals p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* SelectionExpr */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Selection p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionExpr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.SelectionExpr p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VertexSelectionExpr */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntensionSelection p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelectionExpr p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Comprehension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionForm p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.Comprehension p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VertexComprehension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehensionForm p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehension p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgeComprehension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehensionForm p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehension p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* GraphComprehension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehensionForm p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehension p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VertexBinding */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundVertex p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBinding p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgeBinding */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundEdge p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeBinding p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* GraphBinding */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundGraph p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBinding p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Binding */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundVertex p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundEdge p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundGraph p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.Binding p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VertexGenerator */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenVertex p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexGenerator p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgeGenerator */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenEdge p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeGenerator p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* GraphGenerator */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenGraph p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphGenerator p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Generator */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GenVertex p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GenEdge p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.Generator p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VertexExpr */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSum p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexMult p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexVariable p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexNegated p, A arg) { return visitDefault(p, arg); }

    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExpr p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VertexDeconstructor */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExprLabel p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexDeconstructor p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VertexActual */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActualized p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActual p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgeExpr */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprNominal p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprStruct p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExpr p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgePlus */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeName p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeWildcard p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePlus p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgeLabel */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeVariable p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabel p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgeExprPattern */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprLabel p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternStruct p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprPattern p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgeActual */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActualized p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActual p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgeDeconstructor */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternDecon p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeDeconstructor p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* GraphDeconstructor */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedPattern p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedPattern p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedPattern p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphLiteral p, A arg) { return visitDefault(p, arg); }

    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphDeconstructor p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* ConditionOrDecl */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionIn p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.DeclIn p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionOrDecl p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Decl */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LocalDecl p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.Decl p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VertexCollection */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntension p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtenionExpr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexCollection p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgeCollection */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntension p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtenionExpr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeCollection p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* GraphCollection */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIntension p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtenionExpr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphCollection p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VertexExtension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionForm p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltinExpr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtension p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgeExtension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionForm p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltinExpr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtension p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* GraphExtension */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionForm p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltinExpr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtension p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VertexExtensionBuiltin */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSet p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SourceSet p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SinkSet p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltin p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgeExtensionBuiltin */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeSet p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltin p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* GraphExtensionBuiltin */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComponents p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltin p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Condition */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ConjunctionCondition p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.DisjunctionCondition p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.StructuralCondition p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BaseCondition p, A arg) { return visitDefault(p, arg); }

    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.Condition p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* StructureCondition */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedCond p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedCond p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedCond p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphStructureLiteral p, A arg) { return visitDefault(p, arg); }

    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.StructureCondition p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VertexStructureCondition */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureSum p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult p, A arg) { return visitDefault(p, arg); }

    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureVariable p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureNegated p, A arg) { return visitDefault(p, arg); }

    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureCondition p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* EdgeLabelCondition */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelLiteralCondition p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelAtomicCondition p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelCondition p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* GroundCondition */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltinExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltinExpr p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicCondition p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.NegatedCondition p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.GroundCondition p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VertexBuiltin */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SinkBuiltin p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SourceBuiltin p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltin p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* GraphBuiltin */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EmptyGraphBuiltin p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltin p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* AtomicFormula */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Verity p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Absurdity p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Nullity p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicFormula p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Edge */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeQuotation p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntegral p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeString p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.Edge p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Vertex */
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexQuotation p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntegral p, A arg) { return visitDefault(p, arg); }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexString p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(com.biosimilarity.GraphL.model.GraphL.Absyn.Vertex p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
