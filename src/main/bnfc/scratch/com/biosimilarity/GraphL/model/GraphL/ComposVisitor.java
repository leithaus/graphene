package com.biosimilarity.GraphL.model.GraphL;
import com.biosimilarity.GraphL.model.GraphL.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExpr.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExpr,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.Formals.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.Formals,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.Actuals.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.Actuals,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.SelectionExpr.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.SelectionExpr,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelectionExpr.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelectionExpr,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.Comprehension.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.Comprehension,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehension.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehension,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehension.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehension,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehension.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehension,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBinding.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBinding,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeBinding.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeBinding,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBinding.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBinding,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.Binding.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.Binding,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.VertexGenerator.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.VertexGenerator,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeGenerator.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeGenerator,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.GraphGenerator.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.GraphGenerator,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.Generator.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.Generator,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExpr.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExpr,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.VertexDeconstructor.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.VertexDeconstructor,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActual.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActual,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExpr.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExpr,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePlus.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePlus,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabel.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabel,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprPattern.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprPattern,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActual.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActual,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeDeconstructor.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeDeconstructor,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.GraphDeconstructor.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.GraphDeconstructor,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.LogicalOrDecl.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.LogicalOrDecl,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.Satisfaction.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.Satisfaction,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.Decl.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.Decl,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.VertexCollection.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.VertexCollection,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeCollection.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeCollection,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.GraphCollection.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.GraphCollection,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtension.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtension,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtension.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtension,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtension.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtension,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltin.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltin,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltin.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltin,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltin.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltin,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.Condition.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.Condition,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.StructureCondition.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.StructureCondition,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureCondition.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureCondition,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelCondition.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelCondition,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.GroundCondition.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.GroundCondition,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltin.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltin,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltin.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltin,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicFormula.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicFormula,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.Edge.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.Edge,A>,
  com.biosimilarity.GraphL.model.GraphL.Absyn.Vertex.Visitor<com.biosimilarity.GraphL.model.GraphL.Absyn.Vertex,A>
{
/* GraphExpr */
    public GraphExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Isolated p, A arg)
    {
      GraphExpr graphexpr_1 = p.graphexpr_1.accept(this, arg);
      GraphExpr graphexpr_2 = p.graphexpr_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.Isolated(graphexpr_1, graphexpr_2);
    }
    public GraphExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Selected p, A arg)
    {
      SelectionExpr selectionexpr_ = p.selectionexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.Selected(selectionexpr_);
    }
    public GraphExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Connected p, A arg)
    {
      EdgePlus edgeplus_ = p.edgeplus_.accept(this, arg);
      VertexSelectionExpr vertexselectionexpr_1 = p.vertexselectionexpr_1.accept(this, arg);
      VertexSelectionExpr vertexselectionexpr_2 = p.vertexselectionexpr_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.Connected(edgeplus_, vertexselectionexpr_1, vertexselectionexpr_2);
    }
    public GraphExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Recursed p, A arg)
    {
      String uident_ = p.uident_;
      Formals formals_ = p.formals_.accept(this, arg);
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);
      Actuals actuals_ = p.actuals_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.Recursed(uident_, formals_, graphexpr_, actuals_);
    }
    public GraphExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Pointed p, A arg)
    {
      Vertex vertex_ = p.vertex_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.Pointed(vertex_);
    }
    public GraphExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Variable p, A arg)
    {
      String uident_ = p.uident_;

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.Variable(uident_);
    }
    public GraphExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Applied p, A arg)
    {
      String uident_ = p.uident_;
      Actuals actuals_ = p.actuals_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.Applied(uident_, actuals_);
    }
    public GraphExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Empty p, A arg)
    {

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.Empty();
    }

/* Formals */
    public Formals visit(com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsFullForm p, A arg)
    {
      ListLIdent listlident_1 = p.listlident_1;
      ListLIdent listlident_2 = p.listlident_2;

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsFullForm(listlident_1, listlident_2);
    }
    public Formals visit(com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsVertexForm p, A arg)
    {
      ListLIdent listlident_ = p.listlident_;

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsVertexForm(listlident_);
    }

/* Actuals */
    public Actuals visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsFullForm p, A arg)
    {
      ListVertexActual listvertexactual_ = new ListVertexActual();
      for (VertexActual x : p.listvertexactual_) {
        listvertexactual_.add(x.accept(this,arg));
      }
      ListEdgeActual listedgeactual_ = new ListEdgeActual();
      for (EdgeActual x : p.listedgeactual_) {
        listedgeactual_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsFullForm(listvertexactual_, listedgeactual_);
    }
    public Actuals visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsVertexForm p, A arg)
    {
      ListVertexActual listvertexactual_ = new ListVertexActual();
      for (VertexActual x : p.listvertexactual_) {
        listvertexactual_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsVertexForm(listvertexactual_);
    }

/* SelectionExpr */
    public SelectionExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Selection p, A arg)
    {
      ListBinding listbinding_ = new ListBinding();
      for (Binding x : p.listbinding_) {
        listbinding_.add(x.accept(this,arg));
      }
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.Selection(listbinding_, graphexpr_);
    }
    public SelectionExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionExpr p, A arg)
    {
      Comprehension comprehension_ = p.comprehension_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionExpr(comprehension_);
    }

/* VertexSelectionExpr */
    public VertexSelectionExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection p, A arg)
    {
      ListVertexBinding listvertexbinding_ = new ListVertexBinding();
      for (VertexBinding x : p.listvertexbinding_) {
        listvertexbinding_.add(x.accept(this,arg));
      }
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection(listvertexbinding_, graphexpr_);
    }
    public VertexSelectionExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntensionSelection p, A arg)
    {
      VertexComprehension vertexcomprehension_ = p.vertexcomprehension_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntensionSelection(vertexcomprehension_);
    }

/* Comprehension */
    public Comprehension visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionForm p, A arg)
    {
      Generator generator_ = p.generator_.accept(this, arg);
      ListLogicalOrDecl listlogicalordecl_ = new ListLogicalOrDecl();
      for (LogicalOrDecl x : p.listlogicalordecl_) {
        listlogicalordecl_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionForm(generator_, listlogicalordecl_);
    }

/* VertexComprehension */
    public VertexComprehension visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehensionForm p, A arg)
    {
      VertexGenerator vertexgenerator_ = p.vertexgenerator_.accept(this, arg);
      ListLogicalOrDecl listlogicalordecl_ = new ListLogicalOrDecl();
      for (LogicalOrDecl x : p.listlogicalordecl_) {
        listlogicalordecl_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehensionForm(vertexgenerator_, listlogicalordecl_);
    }

/* EdgeComprehension */
    public EdgeComprehension visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehensionForm p, A arg)
    {
      EdgeGenerator edgegenerator_ = p.edgegenerator_.accept(this, arg);
      ListLogicalOrDecl listlogicalordecl_ = new ListLogicalOrDecl();
      for (LogicalOrDecl x : p.listlogicalordecl_) {
        listlogicalordecl_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehensionForm(edgegenerator_, listlogicalordecl_);
    }

/* GraphComprehension */
    public GraphComprehension visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehensionForm p, A arg)
    {
      GraphGenerator graphgenerator_ = p.graphgenerator_.accept(this, arg);
      ListLogicalOrDecl listlogicalordecl_ = new ListLogicalOrDecl();
      for (LogicalOrDecl x : p.listlogicalordecl_) {
        listlogicalordecl_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehensionForm(graphgenerator_, listlogicalordecl_);
    }

/* VertexBinding */
    public VertexBinding visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundVertex p, A arg)
    {
      VertexDeconstructor vertexdeconstructor_ = p.vertexdeconstructor_.accept(this, arg);
      Vertex vertex_ = p.vertex_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundVertex(vertexdeconstructor_, vertex_);
    }

/* EdgeBinding */
    public EdgeBinding visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundEdge p, A arg)
    {
      EdgeDeconstructor edgedeconstructor_ = p.edgedeconstructor_.accept(this, arg);
      EdgeExpr edgeexpr_ = p.edgeexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundEdge(edgedeconstructor_, edgeexpr_);
    }

/* GraphBinding */
    public GraphBinding visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundGraph p, A arg)
    {
      GraphDeconstructor graphdeconstructor_ = p.graphdeconstructor_.accept(this, arg);
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundGraph(graphdeconstructor_, graphexpr_);
    }

/* Binding */
    public Binding visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundVertex p, A arg)
    {
      VertexBinding vertexbinding_ = p.vertexbinding_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.BoundVertex(vertexbinding_);
    }
    public Binding visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundEdge p, A arg)
    {
      EdgeBinding edgebinding_ = p.edgebinding_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.BoundEdge(edgebinding_);
    }
    public Binding visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundGraph p, A arg)
    {
      GraphBinding graphbinding_ = p.graphbinding_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.BoundGraph(graphbinding_);
    }

/* VertexGenerator */
    public VertexGenerator visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenVertex p, A arg)
    {
      VertexDeconstructor vertexdeconstructor_ = p.vertexdeconstructor_.accept(this, arg);
      VertexCollection vertexcollection_ = p.vertexcollection_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenVertex(vertexdeconstructor_, vertexcollection_);
    }

/* EdgeGenerator */
    public EdgeGenerator visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenEdge p, A arg)
    {
      EdgeDeconstructor edgedeconstructor_ = p.edgedeconstructor_.accept(this, arg);
      EdgeCollection edgecollection_ = p.edgecollection_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenEdge(edgedeconstructor_, edgecollection_);
    }

/* GraphGenerator */
    public GraphGenerator visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenGraph p, A arg)
    {
      GraphDeconstructor graphdeconstructor_ = p.graphdeconstructor_.accept(this, arg);
      GraphCollection graphcollection_ = p.graphcollection_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenGraph(graphdeconstructor_, graphcollection_);
    }

/* Generator */
    public Generator visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GenVertex p, A arg)
    {
      VertexGenerator vertexgenerator_ = p.vertexgenerator_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GenVertex(vertexgenerator_);
    }
    public Generator visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GenEdge p, A arg)
    {
      EdgeGenerator edgegenerator_ = p.edgegenerator_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GenEdge(edgegenerator_);
    }
    public Generator visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph p, A arg)
    {
      GraphGenerator graphgenerator_ = p.graphgenerator_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph(graphgenerator_);
    }

/* VertexExpr */
    public VertexExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSum p, A arg)
    {
      VertexExpr vertexexpr_1 = p.vertexexpr_1.accept(this, arg);
      VertexExpr vertexexpr_2 = p.vertexexpr_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSum(vertexexpr_1, vertexexpr_2);
    }
    public VertexExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexMult p, A arg)
    {
      VertexExpr vertexexpr_1 = p.vertexexpr_1.accept(this, arg);
      VertexExpr vertexexpr_2 = p.vertexexpr_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexMult(vertexexpr_1, vertexexpr_2);
    }
    public VertexExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexLiteral p, A arg)
    {
      Vertex vertex_ = p.vertex_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexLiteral(vertex_);
    }
    public VertexExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexVariable p, A arg)
    {
      String lident_ = p.lident_;

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexVariable(lident_);
    }
    public VertexExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexNegated p, A arg)
    {
      VertexExpr vertexexpr_ = p.vertexexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexNegated(vertexexpr_);
    }

/* VertexDeconstructor */
    public VertexDeconstructor visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExprLabel p, A arg)
    {
      VertexExpr vertexexpr_ = p.vertexexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExprLabel(vertexexpr_);
    }

/* VertexActual */
    public VertexActual visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActualized p, A arg)
    {
      VertexExpr vertexexpr_ = p.vertexexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActualized(vertexexpr_);
    }

/* EdgeExpr */
    public EdgeExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprNominal p, A arg)
    {
      Edge edge_ = p.edge_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprNominal(edge_);
    }
    public EdgeExpr visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprStruct p, A arg)
    {
      Edge edge_ = p.edge_.accept(this, arg);
      VertexExpr vertexexpr_1 = p.vertexexpr_1.accept(this, arg);
      VertexExpr vertexexpr_2 = p.vertexexpr_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprStruct(edge_, vertexexpr_1, vertexexpr_2);
    }

/* EdgePlus */
    public EdgePlus visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeName p, A arg)
    {
      Edge edge_ = p.edge_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeName(edge_);
    }
    public EdgePlus visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeWildcard p, A arg)
    {
      String wild_ = p.wild_;

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeWildcard(wild_);
    }

/* EdgeLabel */
    public EdgeLabel visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLiteral p, A arg)
    {
      Edge edge_ = p.edge_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLiteral(edge_);
    }
    public EdgeLabel visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeVariable p, A arg)
    {
      String lident_ = p.lident_;

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeVariable(lident_);
    }

/* EdgeExprPattern */
    public EdgeExprPattern visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprLabel p, A arg)
    {
      EdgeLabel edgelabel_ = p.edgelabel_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprLabel(edgelabel_);
    }
    public EdgeExprPattern visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternStruct p, A arg)
    {
      EdgeDeconstructor edgedeconstructor_ = p.edgedeconstructor_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternStruct(edgedeconstructor_);
    }

/* EdgeActual */
    public EdgeActual visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActualized p, A arg)
    {
      EdgeLabel edgelabel_ = p.edgelabel_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActualized(edgelabel_);
    }

/* EdgeDeconstructor */
    public EdgeDeconstructor visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternDecon p, A arg)
    {
      EdgeLabel edgelabel_ = p.edgelabel_.accept(this, arg);
      VertexDeconstructor vertexdeconstructor_1 = p.vertexdeconstructor_1.accept(this, arg);
      VertexDeconstructor vertexdeconstructor_2 = p.vertexdeconstructor_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternDecon(edgelabel_, vertexdeconstructor_1, vertexdeconstructor_2);
    }

/* GraphDeconstructor */
    public GraphDeconstructor visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedPattern p, A arg)
    {
      GraphDeconstructor graphdeconstructor_1 = p.graphdeconstructor_1.accept(this, arg);
      GraphDeconstructor graphdeconstructor_2 = p.graphdeconstructor_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedPattern(graphdeconstructor_1, graphdeconstructor_2);
    }
    public GraphDeconstructor visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedPattern p, A arg)
    {
      VertexDeconstructor vertexdeconstructor_ = p.vertexdeconstructor_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedPattern(vertexdeconstructor_);
    }
    public GraphDeconstructor visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedPattern p, A arg)
    {
      EdgeLabel edgelabel_ = p.edgelabel_.accept(this, arg);
      GraphDeconstructor graphdeconstructor_1 = p.graphdeconstructor_1.accept(this, arg);
      GraphDeconstructor graphdeconstructor_2 = p.graphdeconstructor_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedPattern(edgelabel_, graphdeconstructor_1, graphdeconstructor_2);
    }
    public GraphDeconstructor visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphLiteral p, A arg)
    {
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphLiteral(graphexpr_);
    }

/* LogicalOrDecl */
    public LogicalOrDecl visit(com.biosimilarity.GraphL.model.GraphL.Absyn.JudgmentExpr p, A arg)
    {
      Satisfaction satisfaction_ = p.satisfaction_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.JudgmentExpr(satisfaction_);
    }
    public LogicalOrDecl visit(com.biosimilarity.GraphL.model.GraphL.Absyn.DeclIn p, A arg)
    {
      Decl decl_ = p.decl_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.DeclIn(decl_);
    }

/* Satisfaction */
    public Satisfaction visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexJudgement p, A arg)
    {
      VertexDeconstructor vertexdeconstructor_ = p.vertexdeconstructor_.accept(this, arg);
      VertexStructureCondition vertexstructurecondition_ = p.vertexstructurecondition_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexJudgement(vertexdeconstructor_, vertexstructurecondition_);
    }
    public Satisfaction visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeJudgement p, A arg)
    {
      EdgeDeconstructor edgedeconstructor_ = p.edgedeconstructor_.accept(this, arg);
      EdgeLabelCondition edgelabelcondition_ = p.edgelabelcondition_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeJudgement(edgedeconstructor_, edgelabelcondition_);
    }
    public Satisfaction visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphJudgement p, A arg)
    {
      GraphDeconstructor graphdeconstructor_ = p.graphdeconstructor_.accept(this, arg);
      Condition condition_ = p.condition_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphJudgement(graphdeconstructor_, condition_);
    }

/* Decl */
    public Decl visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl p, A arg)
    {
      Generator generator_ = p.generator_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl(generator_);
    }
    public Decl visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LocalDecl p, A arg)
    {
      Binding binding_ = p.binding_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.LocalDecl(binding_);
    }

/* VertexCollection */
    public VertexCollection visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntension p, A arg)
    {
      VertexComprehension vertexcomprehension_ = p.vertexcomprehension_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntension(vertexcomprehension_);
    }
    public VertexCollection visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtenionExpr p, A arg)
    {
      VertexExtension vertexextension_ = p.vertexextension_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtenionExpr(vertexextension_);
    }

/* EdgeCollection */
    public EdgeCollection visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntension p, A arg)
    {
      EdgeComprehension edgecomprehension_ = p.edgecomprehension_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntension(edgecomprehension_);
    }
    public EdgeCollection visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtenionExpr p, A arg)
    {
      EdgeExtension edgeextension_ = p.edgeextension_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtenionExpr(edgeextension_);
    }

/* GraphCollection */
    public GraphCollection visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIntension p, A arg)
    {
      GraphComprehension graphcomprehension_ = p.graphcomprehension_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIntension(graphcomprehension_);
    }
    public GraphCollection visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtenionExpr p, A arg)
    {
      GraphExtension graphextension_ = p.graphextension_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtenionExpr(graphextension_);
    }

/* VertexExtension */
    public VertexExtension visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionForm p, A arg)
    {
      ListVertex listvertex_ = new ListVertex();
      for (Vertex x : p.listvertex_) {
        listvertex_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionForm(listvertex_);
    }
    public VertexExtension visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltinExpr p, A arg)
    {
      VertexExtensionBuiltin vertexextensionbuiltin_ = p.vertexextensionbuiltin_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltinExpr(vertexextensionbuiltin_);
    }

/* EdgeExtension */
    public EdgeExtension visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionForm p, A arg)
    {
      ListEdge listedge_ = new ListEdge();
      for (Edge x : p.listedge_) {
        listedge_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionForm(listedge_);
    }
    public EdgeExtension visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltinExpr p, A arg)
    {
      EdgeExtensionBuiltin edgeextensionbuiltin_ = p.edgeextensionbuiltin_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltinExpr(edgeextensionbuiltin_);
    }

/* GraphExtension */
    public GraphExtension visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionForm p, A arg)
    {
      ListGraphExpr listgraphexpr_ = new ListGraphExpr();
      for (GraphExpr x : p.listgraphexpr_) {
        listgraphexpr_.add(x.accept(this,arg));
      }

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionForm(listgraphexpr_);
    }
    public GraphExtension visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltinExpr p, A arg)
    {
      GraphExtensionBuiltin graphextensionbuiltin_ = p.graphextensionbuiltin_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltinExpr(graphextensionbuiltin_);
    }

/* VertexExtensionBuiltin */
    public VertexExtensionBuiltin visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSet p, A arg)
    {
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSet(graphexpr_);
    }
    public VertexExtensionBuiltin visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SourceSet p, A arg)
    {
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.SourceSet(graphexpr_);
    }
    public VertexExtensionBuiltin visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SinkSet p, A arg)
    {
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.SinkSet(graphexpr_);
    }

/* EdgeExtensionBuiltin */
    public EdgeExtensionBuiltin visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeSet p, A arg)
    {
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeSet(graphexpr_);
    }

/* GraphExtensionBuiltin */
    public GraphExtensionBuiltin visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComponents p, A arg)
    {
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComponents(graphexpr_);
    }

/* Condition */
    public Condition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ConjunctionCondition p, A arg)
    {
      Condition condition_1 = p.condition_1.accept(this, arg);
      Condition condition_2 = p.condition_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.ConjunctionCondition(condition_1, condition_2);
    }
    public Condition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.DisjunctionCondition p, A arg)
    {
      Condition condition_1 = p.condition_1.accept(this, arg);
      Condition condition_2 = p.condition_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.DisjunctionCondition(condition_1, condition_2);
    }
    public Condition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.StructuralCondition p, A arg)
    {
      StructureCondition structurecondition_ = p.structurecondition_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.StructuralCondition(structurecondition_);
    }
    public Condition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BaseCondition p, A arg)
    {
      GroundCondition groundcondition_ = p.groundcondition_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.BaseCondition(groundcondition_);
    }

/* StructureCondition */
    public StructureCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedCond p, A arg)
    {
      StructureCondition structurecondition_1 = p.structurecondition_1.accept(this, arg);
      StructureCondition structurecondition_2 = p.structurecondition_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedCond(structurecondition_1, structurecondition_2);
    }
    public StructureCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedCond p, A arg)
    {
      VertexStructureCondition vertexstructurecondition_ = p.vertexstructurecondition_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedCond(vertexstructurecondition_);
    }
    public StructureCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedCond p, A arg)
    {
      EdgeLabelCondition edgelabelcondition_ = p.edgelabelcondition_.accept(this, arg);
      StructureCondition structurecondition_1 = p.structurecondition_1.accept(this, arg);
      StructureCondition structurecondition_2 = p.structurecondition_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedCond(edgelabelcondition_, structurecondition_1, structurecondition_2);
    }
    public StructureCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphStructureLiteral p, A arg)
    {
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphStructureLiteral(graphexpr_);
    }

/* VertexStructureCondition */
    public VertexStructureCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureSum p, A arg)
    {
      VertexStructureCondition vertexstructurecondition_1 = p.vertexstructurecondition_1.accept(this, arg);
      VertexStructureCondition vertexstructurecondition_2 = p.vertexstructurecondition_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureSum(vertexstructurecondition_1, vertexstructurecondition_2);
    }
    public VertexStructureCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult p, A arg)
    {
      VertexStructureCondition vertexstructurecondition_1 = p.vertexstructurecondition_1.accept(this, arg);
      VertexStructureCondition vertexstructurecondition_2 = p.vertexstructurecondition_2.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult(vertexstructurecondition_1, vertexstructurecondition_2);
    }
    public VertexStructureCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureLiteral p, A arg)
    {
      Vertex vertex_ = p.vertex_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureLiteral(vertex_);
    }
    public VertexStructureCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureVariable p, A arg)
    {
      AtomicFormula atomicformula_ = p.atomicformula_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureVariable(atomicformula_);
    }
    public VertexStructureCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureNegated p, A arg)
    {
      VertexStructureCondition vertexstructurecondition_ = p.vertexstructurecondition_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureNegated(vertexstructurecondition_);
    }

/* EdgeLabelCondition */
    public EdgeLabelCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelLiteralCondition p, A arg)
    {
      Edge edge_ = p.edge_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelLiteralCondition(edge_);
    }
    public EdgeLabelCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelAtomicCondition p, A arg)
    {
      AtomicFormula atomicformula_ = p.atomicformula_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelAtomicCondition(atomicformula_);
    }

/* GroundCondition */
    public GroundCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltinExpr p, A arg)
    {
      VertexBuiltin vertexbuiltin_ = p.vertexbuiltin_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltinExpr(vertexbuiltin_);
    }
    public GroundCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltinExpr p, A arg)
    {
      GraphBuiltin graphbuiltin_ = p.graphbuiltin_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltinExpr(graphbuiltin_);
    }
    public GroundCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicCondition p, A arg)
    {
      AtomicFormula atomicformula_ = p.atomicformula_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicCondition(atomicformula_);
    }
    public GroundCondition visit(com.biosimilarity.GraphL.model.GraphL.Absyn.NegatedCondition p, A arg)
    {
      GroundCondition groundcondition_ = p.groundcondition_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.NegatedCondition(groundcondition_);
    }

/* VertexBuiltin */
    public VertexBuiltin visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SinkBuiltin p, A arg)
    {
      VertexExpr vertexexpr_ = p.vertexexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.SinkBuiltin(vertexexpr_);
    }
    public VertexBuiltin visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SourceBuiltin p, A arg)
    {
      VertexExpr vertexexpr_ = p.vertexexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.SourceBuiltin(vertexexpr_);
    }

/* GraphBuiltin */
    public GraphBuiltin visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EmptyGraphBuiltin p, A arg)
    {
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EmptyGraphBuiltin(graphexpr_);
    }

/* AtomicFormula */
    public AtomicFormula visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Verity p, A arg)
    {

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.Verity();
    }
    public AtomicFormula visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Absurdity p, A arg)
    {

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.Absurdity();
    }
    public AtomicFormula visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Nullity p, A arg)
    {

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.Nullity();
    }

/* Edge */
    public Edge visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeQuotation p, A arg)
    {
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeQuotation(graphexpr_);
    }
    public Edge visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntegral p, A arg)
    {
      Integer integer_ = p.integer_;

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntegral(integer_);
    }
    public Edge visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeString p, A arg)
    {
      String string_ = p.string_;

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeString(string_);
    }

/* Vertex */
    public Vertex visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexQuotation p, A arg)
    {
      GraphExpr graphexpr_ = p.graphexpr_.accept(this, arg);

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexQuotation(graphexpr_);
    }
    public Vertex visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntegral p, A arg)
    {
      Integer integer_ = p.integer_;

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntegral(integer_);
    }
    public Vertex visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexString p, A arg)
    {
      String string_ = p.string_;

      return new com.biosimilarity.GraphL.model.GraphL.Absyn.VertexString(string_);
    }

}