package com.biosimilarity.GraphL.model.GraphL;
import com.biosimilarity.GraphL.model.GraphL.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class GraphExprVisitor<R,A> implements GraphExpr.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Isolated p, A arg)
    {
      /* Code For Isolated Goes Here */

      p.graphexpr_1.accept(new GraphExprVisitor<R,A>(), arg);
      p.graphexpr_2.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Selected p, A arg)
    {
      /* Code For Selected Goes Here */

      p.selectionexpr_.accept(new SelectionExprVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Connected p, A arg)
    {
      /* Code For Connected Goes Here */

      p.edgeplus_.accept(new EdgePlusVisitor<R,A>(), arg);
      p.vertexselectionexpr_1.accept(new VertexSelectionExprVisitor<R,A>(), arg);
      p.vertexselectionexpr_2.accept(new VertexSelectionExprVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Recursed p, A arg)
    {
      /* Code For Recursed Goes Here */

      //p.uident_;
      p.formals_.accept(new FormalsVisitor<R,A>(), arg);
      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);
      p.actuals_.accept(new ActualsVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Pointed p, A arg)
    {
      /* Code For Pointed Goes Here */

      p.vertex_.accept(new VertexVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Variable p, A arg)
    {
      /* Code For Variable Goes Here */

      //p.uident_;

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Applied p, A arg)
    {
      /* Code For Applied Goes Here */

      //p.uident_;
      p.actuals_.accept(new ActualsVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Empty p, A arg)
    {
      /* Code For Empty Goes Here */


      return null;
    }

  }
  public class FormalsVisitor<R,A> implements Formals.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsFullForm p, A arg)
    {
      /* Code For FormalsFullForm Goes Here */

      for (String x : p.listlident_1) {
      }
      for (String x : p.listlident_2) {
      }

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsVertexForm p, A arg)
    {
      /* Code For FormalsVertexForm Goes Here */

      for (String x : p.listlident_) {
      }

      return null;
    }

  }
  public class ActualsVisitor<R,A> implements Actuals.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsFullForm p, A arg)
    {
      /* Code For ActualsFullForm Goes Here */

      for (VertexActual x : p.listvertexactual_) {
      }
      for (EdgeActual x : p.listedgeactual_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsVertexForm p, A arg)
    {
      /* Code For ActualsVertexForm Goes Here */

      for (VertexActual x : p.listvertexactual_) {
      }

      return null;
    }

  }
  public class SelectionExprVisitor<R,A> implements SelectionExpr.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Selection p, A arg)
    {
      /* Code For Selection Goes Here */

      for (Binding x : p.listbinding_) {
      }
      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionExpr p, A arg)
    {
      /* Code For ComprehensionExpr Goes Here */

      p.comprehension_.accept(new ComprehensionVisitor<R,A>(), arg);

      return null;
    }

  }
  public class VertexSelectionExprVisitor<R,A> implements VertexSelectionExpr.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection p, A arg)
    {
      /* Code For VertexSelection Goes Here */

      for (VertexBinding x : p.listvertexbinding_) {
      }
      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntensionSelection p, A arg)
    {
      /* Code For VertexIntensionSelection Goes Here */

      p.vertexcomprehension_.accept(new VertexComprehensionVisitor<R,A>(), arg);

      return null;
    }

  }
  public class ComprehensionVisitor<R,A> implements Comprehension.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionForm p, A arg)
    {
      /* Code For ComprehensionForm Goes Here */

      p.generator_.accept(new GeneratorVisitor<R,A>(), arg);
      for (ConditionOrDecl x : p.listconditionordecl_) {
      }

      return null;
    }

  }
  public class VertexComprehensionVisitor<R,A> implements VertexComprehension.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehensionForm p, A arg)
    {
      /* Code For VertexComprehensionForm Goes Here */

      p.vertexgenerator_.accept(new VertexGeneratorVisitor<R,A>(), arg);
      for (ConditionOrDecl x : p.listconditionordecl_) {
      }

      return null;
    }

  }
  public class EdgeComprehensionVisitor<R,A> implements EdgeComprehension.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehensionForm p, A arg)
    {
      /* Code For EdgeComprehensionForm Goes Here */

      p.edgegenerator_.accept(new EdgeGeneratorVisitor<R,A>(), arg);
      for (ConditionOrDecl x : p.listconditionordecl_) {
      }

      return null;
    }

  }
  public class GraphComprehensionVisitor<R,A> implements GraphComprehension.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehensionForm p, A arg)
    {
      /* Code For GraphComprehensionForm Goes Here */

      p.graphgenerator_.accept(new GraphGeneratorVisitor<R,A>(), arg);
      for (ConditionOrDecl x : p.listconditionordecl_) {
      }

      return null;
    }

  }
  public class VertexBindingVisitor<R,A> implements VertexBinding.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundVertex p, A arg)
    {
      /* Code For LRBoundVertex Goes Here */

      p.vertexdeconstructor_.accept(new VertexDeconstructorVisitor<R,A>(), arg);
      p.vertex_.accept(new VertexVisitor<R,A>(), arg);

      return null;
    }

  }
  public class EdgeBindingVisitor<R,A> implements EdgeBinding.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundEdge p, A arg)
    {
      /* Code For LRBoundEdge Goes Here */

      p.edgedeconstructor_.accept(new EdgeDeconstructorVisitor<R,A>(), arg);
      p.edgeexpr_.accept(new EdgeExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class GraphBindingVisitor<R,A> implements GraphBinding.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundGraph p, A arg)
    {
      /* Code For LRBoundGraph Goes Here */

      p.graphdeconstructor_.accept(new GraphDeconstructorVisitor<R,A>(), arg);
      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class BindingVisitor<R,A> implements Binding.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundVertex p, A arg)
    {
      /* Code For BoundVertex Goes Here */

      p.vertexbinding_.accept(new VertexBindingVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundEdge p, A arg)
    {
      /* Code For BoundEdge Goes Here */

      p.edgebinding_.accept(new EdgeBindingVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BoundGraph p, A arg)
    {
      /* Code For BoundGraph Goes Here */

      p.graphbinding_.accept(new GraphBindingVisitor<R,A>(), arg);

      return null;
    }

  }
  public class VertexGeneratorVisitor<R,A> implements VertexGenerator.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenVertex p, A arg)
    {
      /* Code For LRGenVertex Goes Here */

      p.vertexdeconstructor_.accept(new VertexDeconstructorVisitor<R,A>(), arg);
      p.vertexcollection_.accept(new VertexCollectionVisitor<R,A>(), arg);

      return null;
    }

  }
  public class EdgeGeneratorVisitor<R,A> implements EdgeGenerator.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenEdge p, A arg)
    {
      /* Code For LRGenEdge Goes Here */

      p.edgedeconstructor_.accept(new EdgeDeconstructorVisitor<R,A>(), arg);
      p.edgecollection_.accept(new EdgeCollectionVisitor<R,A>(), arg);

      return null;
    }

  }
  public class GraphGeneratorVisitor<R,A> implements GraphGenerator.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenGraph p, A arg)
    {
      /* Code For LRGenGraph Goes Here */

      p.graphdeconstructor_.accept(new GraphDeconstructorVisitor<R,A>(), arg);
      p.graphcollection_.accept(new GraphCollectionVisitor<R,A>(), arg);

      return null;
    }

  }
  public class GeneratorVisitor<R,A> implements Generator.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GenVertex p, A arg)
    {
      /* Code For GenVertex Goes Here */

      p.vertexgenerator_.accept(new VertexGeneratorVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GenEdge p, A arg)
    {
      /* Code For GenEdge Goes Here */

      p.edgegenerator_.accept(new EdgeGeneratorVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph p, A arg)
    {
      /* Code For GenGraph Goes Here */

      p.graphgenerator_.accept(new GraphGeneratorVisitor<R,A>(), arg);

      return null;
    }

  }
  public class VertexExprVisitor<R,A> implements VertexExpr.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSum p, A arg)
    {
      /* Code For VertexSum Goes Here */

      p.vertexexpr_1.accept(new VertexExprVisitor<R,A>(), arg);
      p.vertexexpr_2.accept(new VertexExprVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexMult p, A arg)
    {
      /* Code For VertexMult Goes Here */

      p.vertexexpr_1.accept(new VertexExprVisitor<R,A>(), arg);
      p.vertexexpr_2.accept(new VertexExprVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexLiteral p, A arg)
    {
      /* Code For VertexLiteral Goes Here */

      p.vertex_.accept(new VertexVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexVariable p, A arg)
    {
      /* Code For VertexVariable Goes Here */

      //p.lident_;

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexNegated p, A arg)
    {
      /* Code For VertexNegated Goes Here */

      p.vertexexpr_.accept(new VertexExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class VertexDeconstructorVisitor<R,A> implements VertexDeconstructor.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExprLabel p, A arg)
    {
      /* Code For VertexExprLabel Goes Here */

      p.vertexexpr_.accept(new VertexExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class VertexActualVisitor<R,A> implements VertexActual.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActualized p, A arg)
    {
      /* Code For VertexActualized Goes Here */

      p.vertexexpr_.accept(new VertexExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class EdgeExprVisitor<R,A> implements EdgeExpr.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprNominal p, A arg)
    {
      /* Code For EdgeExprNominal Goes Here */

      p.edge_.accept(new EdgeVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprStruct p, A arg)
    {
      /* Code For EdgeExprStruct Goes Here */

      p.edge_.accept(new EdgeVisitor<R,A>(), arg);
      p.vertexexpr_1.accept(new VertexExprVisitor<R,A>(), arg);
      p.vertexexpr_2.accept(new VertexExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class EdgePlusVisitor<R,A> implements EdgePlus.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeName p, A arg)
    {
      /* Code For EdgeName Goes Here */

      p.edge_.accept(new EdgeVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeWildcard p, A arg)
    {
      /* Code For EdgeWildcard Goes Here */

      //p.wild_;

      return null;
    }

  }
  public class EdgeLabelVisitor<R,A> implements EdgeLabel.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLiteral p, A arg)
    {
      /* Code For EdgeLiteral Goes Here */

      p.edge_.accept(new EdgeVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeVariable p, A arg)
    {
      /* Code For EdgeVariable Goes Here */

      //p.lident_;

      return null;
    }

  }
  public class EdgeExprPatternVisitor<R,A> implements EdgeExprPattern.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprLabel p, A arg)
    {
      /* Code For EdgeExprLabel Goes Here */

      p.edgelabel_.accept(new EdgeLabelVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternStruct p, A arg)
    {
      /* Code For EdgePatternStruct Goes Here */

      p.edgedeconstructor_.accept(new EdgeDeconstructorVisitor<R,A>(), arg);

      return null;
    }

  }
  public class EdgeActualVisitor<R,A> implements EdgeActual.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActualized p, A arg)
    {
      /* Code For EdgeActualized Goes Here */

      p.edgelabel_.accept(new EdgeLabelVisitor<R,A>(), arg);

      return null;
    }

  }
  public class EdgeDeconstructorVisitor<R,A> implements EdgeDeconstructor.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternDecon p, A arg)
    {
      /* Code For EdgePatternDecon Goes Here */

      p.edgelabel_.accept(new EdgeLabelVisitor<R,A>(), arg);
      p.vertexdeconstructor_1.accept(new VertexDeconstructorVisitor<R,A>(), arg);
      p.vertexdeconstructor_2.accept(new VertexDeconstructorVisitor<R,A>(), arg);

      return null;
    }

  }
  public class GraphDeconstructorVisitor<R,A> implements GraphDeconstructor.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedPattern p, A arg)
    {
      /* Code For GraphIsolatedPattern Goes Here */

      p.graphdeconstructor_1.accept(new GraphDeconstructorVisitor<R,A>(), arg);
      p.graphdeconstructor_2.accept(new GraphDeconstructorVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedPattern p, A arg)
    {
      /* Code For GraphPointedPattern Goes Here */

      p.vertexdeconstructor_.accept(new VertexDeconstructorVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedPattern p, A arg)
    {
      /* Code For GraphConnectedPattern Goes Here */

      p.edgelabel_.accept(new EdgeLabelVisitor<R,A>(), arg);
      p.graphdeconstructor_1.accept(new GraphDeconstructorVisitor<R,A>(), arg);
      p.graphdeconstructor_2.accept(new GraphDeconstructorVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphLiteral p, A arg)
    {
      /* Code For GraphLiteral Goes Here */

      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class ConditionOrDeclVisitor<R,A> implements ConditionOrDecl.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionIn p, A arg)
    {
      /* Code For ConditionIn Goes Here */

      p.condition_.accept(new ConditionVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.DeclIn p, A arg)
    {
      /* Code For DeclIn Goes Here */

      p.decl_.accept(new DeclVisitor<R,A>(), arg);

      return null;
    }

  }
  public class DeclVisitor<R,A> implements Decl.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl p, A arg)
    {
      /* Code For GeneratorDecl Goes Here */

      p.generator_.accept(new GeneratorVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.LocalDecl p, A arg)
    {
      /* Code For LocalDecl Goes Here */

      p.binding_.accept(new BindingVisitor<R,A>(), arg);

      return null;
    }

  }
  public class VertexCollectionVisitor<R,A> implements VertexCollection.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntension p, A arg)
    {
      /* Code For VertexIntension Goes Here */

      p.vertexcomprehension_.accept(new VertexComprehensionVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtenionExpr p, A arg)
    {
      /* Code For VertexExtenionExpr Goes Here */

      p.vertexextension_.accept(new VertexExtensionVisitor<R,A>(), arg);

      return null;
    }

  }
  public class EdgeCollectionVisitor<R,A> implements EdgeCollection.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntension p, A arg)
    {
      /* Code For EdgeIntension Goes Here */

      p.edgecomprehension_.accept(new EdgeComprehensionVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtenionExpr p, A arg)
    {
      /* Code For EdgeExtenionExpr Goes Here */

      p.edgeextension_.accept(new EdgeExtensionVisitor<R,A>(), arg);

      return null;
    }

  }
  public class GraphCollectionVisitor<R,A> implements GraphCollection.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIntension p, A arg)
    {
      /* Code For GraphIntension Goes Here */

      p.graphcomprehension_.accept(new GraphComprehensionVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtenionExpr p, A arg)
    {
      /* Code For GraphExtenionExpr Goes Here */

      p.graphextension_.accept(new GraphExtensionVisitor<R,A>(), arg);

      return null;
    }

  }
  public class VertexExtensionVisitor<R,A> implements VertexExtension.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionForm p, A arg)
    {
      /* Code For VertexExtensionForm Goes Here */

      for (Vertex x : p.listvertex_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltinExpr p, A arg)
    {
      /* Code For VertexExtensionBuiltinExpr Goes Here */

      p.vertexextensionbuiltin_.accept(new VertexExtensionBuiltinVisitor<R,A>(), arg);

      return null;
    }

  }
  public class EdgeExtensionVisitor<R,A> implements EdgeExtension.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionForm p, A arg)
    {
      /* Code For EdgeExtensionForm Goes Here */

      for (Edge x : p.listedge_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltinExpr p, A arg)
    {
      /* Code For EdgeExtensionBuiltinExpr Goes Here */

      p.edgeextensionbuiltin_.accept(new EdgeExtensionBuiltinVisitor<R,A>(), arg);

      return null;
    }

  }
  public class GraphExtensionVisitor<R,A> implements GraphExtension.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionForm p, A arg)
    {
      /* Code For GraphExtensionForm Goes Here */

      for (GraphExpr x : p.listgraphexpr_) {
      }

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltinExpr p, A arg)
    {
      /* Code For GraphExtensionBuiltinExpr Goes Here */

      p.graphextensionbuiltin_.accept(new GraphExtensionBuiltinVisitor<R,A>(), arg);

      return null;
    }

  }
  public class VertexExtensionBuiltinVisitor<R,A> implements VertexExtensionBuiltin.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSet p, A arg)
    {
      /* Code For VertexSet Goes Here */

      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SourceSet p, A arg)
    {
      /* Code For SourceSet Goes Here */

      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SinkSet p, A arg)
    {
      /* Code For SinkSet Goes Here */

      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class EdgeExtensionBuiltinVisitor<R,A> implements EdgeExtensionBuiltin.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeSet p, A arg)
    {
      /* Code For EdgeSet Goes Here */

      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class GraphExtensionBuiltinVisitor<R,A> implements GraphExtensionBuiltin.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComponents p, A arg)
    {
      /* Code For GraphComponents Goes Here */

      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class ConditionVisitor<R,A> implements Condition.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.ConjunctionCondition p, A arg)
    {
      /* Code For ConjunctionCondition Goes Here */

      p.condition_1.accept(new ConditionVisitor<R,A>(), arg);
      p.condition_2.accept(new ConditionVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.DisjunctionCondition p, A arg)
    {
      /* Code For DisjunctionCondition Goes Here */

      p.condition_1.accept(new ConditionVisitor<R,A>(), arg);
      p.condition_2.accept(new ConditionVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.StructuralCondition p, A arg)
    {
      /* Code For StructuralCondition Goes Here */

      p.structurecondition_.accept(new StructureConditionVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.BaseCondition p, A arg)
    {
      /* Code For BaseCondition Goes Here */

      p.groundcondition_.accept(new GroundConditionVisitor<R,A>(), arg);

      return null;
    }

  }
  public class StructureConditionVisitor<R,A> implements StructureCondition.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedCond p, A arg)
    {
      /* Code For GraphIsolatedCond Goes Here */

      p.structurecondition_1.accept(new StructureConditionVisitor<R,A>(), arg);
      p.structurecondition_2.accept(new StructureConditionVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedCond p, A arg)
    {
      /* Code For GraphPointedCond Goes Here */

      p.vertexstructurecondition_.accept(new VertexStructureConditionVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedCond p, A arg)
    {
      /* Code For GraphConnectedCond Goes Here */

      p.edgelabelcondition_.accept(new EdgeLabelConditionVisitor<R,A>(), arg);
      p.structurecondition_1.accept(new StructureConditionVisitor<R,A>(), arg);
      p.structurecondition_2.accept(new StructureConditionVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphStructureLiteral p, A arg)
    {
      /* Code For GraphStructureLiteral Goes Here */

      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class VertexStructureConditionVisitor<R,A> implements VertexStructureCondition.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureSum p, A arg)
    {
      /* Code For VertexStructureSum Goes Here */

      p.vertexstructurecondition_1.accept(new VertexStructureConditionVisitor<R,A>(), arg);
      p.vertexstructurecondition_2.accept(new VertexStructureConditionVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult p, A arg)
    {
      /* Code For VertexStructureMult Goes Here */

      p.vertexstructurecondition_1.accept(new VertexStructureConditionVisitor<R,A>(), arg);
      p.vertexstructurecondition_2.accept(new VertexStructureConditionVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureLiteral p, A arg)
    {
      /* Code For VertexStructureLiteral Goes Here */

      p.vertex_.accept(new VertexVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureVariable p, A arg)
    {
      /* Code For VertexStructureVariable Goes Here */

      p.atomicformula_.accept(new AtomicFormulaVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureNegated p, A arg)
    {
      /* Code For VertexStructureNegated Goes Here */

      p.vertexstructurecondition_.accept(new VertexStructureConditionVisitor<R,A>(), arg);

      return null;
    }

  }
  public class EdgeLabelConditionVisitor<R,A> implements EdgeLabelCondition.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelLiteralCondition p, A arg)
    {
      /* Code For EdgeLabelLiteralCondition Goes Here */

      p.edge_.accept(new EdgeVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelAtomicCondition p, A arg)
    {
      /* Code For EdgeLabelAtomicCondition Goes Here */

      p.atomicformula_.accept(new AtomicFormulaVisitor<R,A>(), arg);

      return null;
    }

  }
  public class GroundConditionVisitor<R,A> implements GroundCondition.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltinExpr p, A arg)
    {
      /* Code For VertexBuiltinExpr Goes Here */

      p.vertexbuiltin_.accept(new VertexBuiltinVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltinExpr p, A arg)
    {
      /* Code For GraphBuiltinExpr Goes Here */

      p.graphbuiltin_.accept(new GraphBuiltinVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicCondition p, A arg)
    {
      /* Code For AtomicCondition Goes Here */

      p.atomicformula_.accept(new AtomicFormulaVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.NegatedCondition p, A arg)
    {
      /* Code For NegatedCondition Goes Here */

      p.groundcondition_.accept(new GroundConditionVisitor<R,A>(), arg);

      return null;
    }

  }
  public class VertexBuiltinVisitor<R,A> implements VertexBuiltin.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SinkBuiltin p, A arg)
    {
      /* Code For SinkBuiltin Goes Here */

      p.vertexexpr_.accept(new VertexExprVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.SourceBuiltin p, A arg)
    {
      /* Code For SourceBuiltin Goes Here */

      p.vertexexpr_.accept(new VertexExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class GraphBuiltinVisitor<R,A> implements GraphBuiltin.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EmptyGraphBuiltin p, A arg)
    {
      /* Code For EmptyGraphBuiltin Goes Here */

      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }

  }
  public class AtomicFormulaVisitor<R,A> implements AtomicFormula.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Verity p, A arg)
    {
      /* Code For Verity Goes Here */


      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Absurdity p, A arg)
    {
      /* Code For Absurdity Goes Here */


      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.Nullity p, A arg)
    {
      /* Code For Nullity Goes Here */


      return null;
    }

  }
  public class EdgeVisitor<R,A> implements Edge.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeQuotation p, A arg)
    {
      /* Code For EdgeQuotation Goes Here */

      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntegral p, A arg)
    {
      /* Code For EdgeIntegral Goes Here */

      //p.integer_;

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeString p, A arg)
    {
      /* Code For EdgeString Goes Here */

      //p.string_;

      return null;
    }

  }
  public class VertexVisitor<R,A> implements Vertex.Visitor<R,A>
  {
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexQuotation p, A arg)
    {
      /* Code For VertexQuotation Goes Here */

      p.graphexpr_.accept(new GraphExprVisitor<R,A>(), arg);

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntegral p, A arg)
    {
      /* Code For VertexIntegral Goes Here */

      //p.integer_;

      return null;
    }
    public R visit(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexString p, A arg)
    {
      /* Code For VertexString Goes Here */

      //p.string_;

      return null;
    }

  }
}