// -*- mode: Scala;-*- 
// Filename:    MultifoldVisitor.scala 
// Authors:     lgm                                                    
// Creation:    Fri Jan  2 13:59:30 2009 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

package com.biosimilarity.GraphL.model.GraphL.Eval

import com.biosimilarity.GraphL.model.GraphL._
import com.biosimilarity.GraphL.model.GraphL.Absyn._
import scala.collection.JavaConverters._
import java.util.Collections
import java.util.List
import java.util.ArrayList

trait MultifoldVisitor[R,A] 
  extends AllVisitor[R,A] {

    def combine( left : R, right : R, arg : A ) : R
    def leaf( arg : A ) : R 

    def meaning( p : Isolated, arg : A ) : R = leaf( arg )
    def meaning( p : Selected, arg : A ) : R = leaf( arg )
    def meaning( p : Connected, arg : A ) : R = leaf( arg )
    def meaning( p : Recursed, arg : A ) : R = leaf( arg )
    def meaning( p : Pointed, arg : A ) : R = leaf( arg )
    def meaning( p : Variable, arg : A ) : R = leaf( arg )
    def meaning( p : Applied, arg : A) : R = leaf( arg )
    def meaning( p : Empty, arg : A ) : R = leaf( arg )
    def meaning( p : FormalsFullForm, arg : A ) : R = leaf( arg )
    def meaning( p : FormalsVertexForm, arg : A ) : R = leaf( arg )
    def meaning( p : ActualsFullForm, arg : A) : R = leaf( arg )
    def meaning( p : ActualsVertexForm, arg : A ) : R = leaf( arg )
    def meaning( p : Selection, arg : A ) : R = leaf( arg )
    def meaning( p : ComprehensionExpr, arg : A ) : R = leaf( arg )
    def meaning( p : VertexSelection, arg : A ) : R = leaf( arg )
    def meaning( p : VertexIntensionSelection, arg : A ) :  R = leaf( arg )
    def meaning( p : ComprehensionForm, arg : A ) : R = leaf( arg )
    def meaning( p : VertexComprehensionForm, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeComprehensionForm, arg : A ) : R = leaf( arg )
    def meaning( p : GraphComprehensionForm, arg : A ) : R  = leaf( arg )
    def meaning( p : LRBoundVertex, arg : A ) : R = leaf( arg )
    def meaning( p : LRBoundEdge, arg : A ) : R = leaf( arg )
    def meaning( p : LRBoundGraph, arg : A ) : R = leaf( arg )
    def meaning( p : BoundVertex, arg : A ) : R = leaf( arg )
    def meaning(p : BoundEdge, arg : A) : R = leaf( arg )
    def meaning( p : BoundGraph, arg : A ) : R = leaf( arg )
    def meaning( p : LRGenVertex, arg : A ) : R = leaf( arg )
    def meaning( p : LRGenEdge, arg : A) : R = leaf( arg )
    def meaning( p : LRGenGraph, arg : A ) : R = leaf( arg )
    def meaning( p : GenVertex, arg : A ) : R = leaf( arg )
    def meaning( p : GenEdge, arg : A ) : R = leaf( arg )
    def meaning( p : GenGraph, arg : A ) : R = leaf( arg )
    def meaning( p : VertexSum, arg : A ) : R = leaf( arg )
    def meaning( p : VertexMult, arg : A ) : R  = leaf( arg )
    def meaning( p : VertexLiteral, arg : A ) : R = leaf( arg )
    def meaning( p : VertexVariable, arg : A ) : R = leaf( arg )
    def meaning( p : VertexNegated, arg : A ) : R  = leaf( arg )
    def meaning( p : VertexExprLabel, arg : A ) : R = leaf( arg )
    def meaning( p : VertexActualized, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeExprNominal, arg : A ) : R  = leaf( arg )
    def meaning( p : EdgeExprStruct, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeName, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeWildcard, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeLiteral, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeVariable, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeExprLabel, arg : A ) : R = leaf( arg )
    def meaning( p : EdgePatternStruct, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeActualized, arg : A ) : R = leaf( arg )
    def meaning( p : EdgePatternDecon, arg : A ) : R = leaf( arg )
    def meaning( p : GraphIsolatedPattern, arg : A ) : R = leaf( arg )
    def meaning( p : GraphPointedPattern, arg : A ) : R = leaf( arg )
    def meaning( p : GraphConnectedPattern, arg : A ) : R = leaf( arg )
    def meaning( p : GraphLiteral, arg : A ) : R = leaf( arg )
    def meaning( p : ConditionIn, arg : A ) : R = leaf( arg )
    def meaning( p : DeclIn, arg : A ) : R = leaf( arg )
    def meaning( p : GeneratorDecl, arg : A ) : R = leaf( arg )
    def meaning( p : LocalDecl, arg : A ) : R = leaf( arg )
    def meaning( p : VertexIntension, arg : A ) : R = leaf( arg )
    def meaning( p : VertexExtenionExpr, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeIntension, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeExtenionExpr, arg : A ) : R = leaf( arg )
    def meaning( p : GraphIntension, arg : A ) : R = leaf( arg )
    def meaning( p : GraphExtenionExpr, arg : A ) : R = leaf( arg )
    def meaning( p : VertexExtensionForm, arg : A ) : R = leaf( arg )
    def meaning( p : VertexExtensionBuiltinExpr, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeExtensionForm, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeExtensionBuiltinExpr, arg : A ) : R = leaf( arg )
    def meaning( p : GraphExtensionForm, arg : A ) : R = leaf( arg )
    def meaning( p : GraphExtensionBuiltinExpr, arg : A ) : R = leaf( arg )
    def meaning( p : VertexSet, arg : A ) : R = leaf( arg )
    def meaning( p : SourceSet, arg : A ) : R = leaf( arg )
    def meaning( p : SinkSet, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeSet, arg : A ) : R = leaf( arg )
    def meaning( p : GraphComponents, arg : A ) : R = leaf( arg )
    def meaning( p : ConjunctionCondition, arg : A ) : R = leaf( arg )
    def meaning( p : DisjunctionCondition, arg : A ) : R = leaf( arg )
    def meaning( p : GraphIsolatedCond, arg : A ) : R = leaf( arg )
    def meaning( p : GraphPointedCond, arg : A ) : R  = leaf( arg )
    def meaning( p : GraphConnectedCond, arg : A ) : R = leaf( arg )
    def meaning( p : GraphStructureLiteral, arg : A ) : R = leaf( arg )
    def meaning( p : VertexStructureSum, arg : A ) : R = leaf( arg )
    def meaning( p : VertexStructureMult, arg : A ) : R = leaf( arg )
    def meaning( p : VertexStructureLiteral, arg : A ) : R  = leaf( arg )
    def meaning( p : VertexStructureNegated, arg : A ) : R = leaf( arg )
    def meaning( p : BaseCondition, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeLabelLiteralCondition, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeLabelAtomicCondition, arg : A ) : R = leaf( arg )
    def meaning( p : VertexBuiltinExpr, arg : A ) : R = leaf( arg )
    def meaning( p : GraphBuiltinExpr, arg : A ) : R = leaf( arg )
    def meaning( p : AtomicCondition, arg : A ) : R = leaf( arg )
    def meaning( p : NegatedCondition, arg : A ) : R = leaf( arg )
    def meaning( p : SinkBuiltin, arg : A ) : R = leaf( arg )
    def meaning( p : SourceBuiltin, arg : A ) : R = leaf( arg )
    def meaning( p : EmptyGraphBuiltin, arg : A ) : R = leaf( arg )
    def meaning( p : Verity, arg : A ) : R = leaf( arg )
    def meaning( p : Absurdity, arg : A ) : R = leaf( arg )
    def meaning( p : Nullity, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeQuotation, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeIntegral, arg : A ) : R = leaf( arg )
    def meaning( p : EdgeString, arg : A ) : R = leaf( arg )
    def meaning( p : VertexQuotation, arg : A ) : R = leaf( arg )
    def meaning( p : VertexIntegral, arg : A ) : R = leaf( arg )
    def meaning( p : VertexString, arg : A ) : R = leaf( arg )

/* GraphExpr */
    def visit( p : Isolated, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_2.accept( this, arg ),
	combine(
	  p.graphexpr_1.accept( this, arg ),
	  meaning( p, arg ),
	  arg
	),
	arg
      )
    }
    def visit( p : Selected, arg : A ) : R
    =
    {
      combine(
	p.selectionexpr_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

    def visit( p : Connected, arg : A ) : R
    =
    {
      combine(
	p.vertexselectionexpr_2.accept( this, arg ),
	combine(
	  p.vertexselectionexpr_1.accept( this, arg ),
	  combine(
	    p.edgeplus_.accept( this, arg ),
	    meaning( p, arg ),
	    arg
	  ),
	  arg
	),
	arg
      )
    }

    def visit( p : Recursed, arg : A ) : R
    =
    {
      combine(
	p.actuals_.accept( this, arg ),
	combine(
	  p.graphexpr_.accept( this, arg ),
	  combine(
	    p.formals_.accept( this, arg ),
	    meaning( p, arg ),
	    arg
	  ),
	  arg
	),
	arg
      )
    }

    def visit( p : Pointed, arg : A ) : R
    =
    {
      combine(
	p.vertex_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

    def visit( p : Variable, arg : A ) : R
    =
    {
      meaning( p, arg )
    }

    def visit( p : Applied, arg : A) : R
    =
    {
      combine(
	p.actuals_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

    def visit( p : Empty, arg : A ) : R
    =
    {
      meaning( p, arg )
    }

/* Formals */
    def visit( p : FormalsFullForm, arg : A ) : R
    =
    {
      meaning( p, arg )
    }
    def visit( p : FormalsVertexForm, arg : A ) : R
    =
    {
      meaning( p, arg )
    }

/* Actuals */
    def visit( p : ActualsFullForm, arg : A) : R
    =
    {
      (( (( meaning( p, arg ) /:
	   p.listvertexactual_.asScala //scala.collection.jcl.Conversions.convertList(  )
         )(
	{ ( acc : R, v : VertexActual ) =>
	  combine( v.accept( this, arg ), acc, arg )
       })) /:
	p.listedgeactual_.asScala //scala.collection.jcl.Conversions.convertList(  )
      )(
	{ ( acc : R, e : EdgeActual ) =>
	  combine( e.accept( this, arg ), acc, arg )
       }))
    }
    def visit( p : ActualsVertexForm, arg : A ) : R
    =
    {
      (( meaning( p, arg ) /:
	p.listvertexactual_.asScala //scala.collection.jcl.Conversions.convertList(  )
      )(
	{ ( acc : R, v : VertexActual ) =>
	  combine( v.accept( this, arg ), acc, arg )
       }))
    }

/* SelectionExpr */    
    def visit( p : Selection, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept(this, arg),
	(( meaning( p, arg ) /:
	  p.listbinding_.asScala //scala.collection.jcl.Conversions.convertList(  )
        )(
	  { ( acc : R, b : Binding ) =>
	    combine( b.accept( this, arg ), acc, arg )
	 })),
	arg
      )
    }

    def visit( p : ComprehensionExpr, arg : A ) : R
    =
    {
      combine(p.comprehension_.accept(this, arg), meaning( p, arg ), arg);
    }

/* VertexSelectionExpr */
    def visit( p : VertexSelection, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept(this, arg),
	(( meaning( p, arg ) /:
	  p.listvertexbinding_.asScala //scala.collection.jcl.Conversions.convertList( )	    
	)(
	  { ( acc : R, b : VertexBinding ) =>
	    combine( b.accept( this, arg ), acc, arg )
	 })),
	arg
      )
    }
    def visit( p : VertexIntensionSelection, arg : A ) :  R
    =
    {
      combine(
	p.vertexcomprehension_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* Comprehension */
    def visit( p : ComprehensionForm, arg : A ) : R
    =
    {
      val mg : R = meaning( p, arg )
      (( mg /: p.listconditionordecl_.asScala )(
	{ ( acc : R, c : ConditionOrDecl ) =>
	  combine( c.accept( this, arg ), acc, arg )
       }))
    }

/* VertexComprehension */
    def visit( p : VertexComprehensionForm, arg : A ) : R
    =
    {
      val mg : R = meaning( p, arg )
      (( mg /: p.listconditionordecl_.asScala )(
	{ ( acc : R, c : ConditionOrDecl ) =>
	  combine( c.accept( this, arg ), acc, arg )
       }))
    }

/* EdgeComprehension */
    def visit( p : EdgeComprehensionForm, arg : A ) : R
    =
    {
      (( meaning( p, arg ) /:
	p.listconditionordecl_.asScala //scala.collection.jcl.Conversions.convertList()	
      )(
	{ ( acc : R, c : ConditionOrDecl ) =>
	  combine( c.accept( this, arg ), acc, arg )
       }))
    }

/* GraphComprehension */
    def visit( p : GraphComprehensionForm, arg : A ) : R 
    =
    {
      (( meaning( p, arg ) /:
	p.listconditionordecl_.asScala //scala.collection.jcl.Conversions.convertList()	  
      )(
	{ ( acc : R, c : ConditionOrDecl ) =>
	  combine( c.accept( this, arg ), acc, arg )
       }))
    }

/* VertexBinding */
    def visit( p : LRBoundVertex, arg : A ) : R
    =
    {
      combine(
	p.vertex_.accept( this, arg ),
	combine(
	  p.vertexdeconstructor_.accept( this, arg ),
	  meaning( p, arg ),
	  arg
	),
	arg
      )
    }

/* EdgeBinding */
    def visit( p : LRBoundEdge, arg : A ) : R
    =
    {
      combine(
	p.edgeexpr_.accept( this, arg ),
	combine(
	  p.edgedeconstructor_.accept( this, arg ),
	  meaning( p, arg ),
	  arg
	),
	arg
      )
    }

/* GraphBinding */
    def visit( p : LRBoundGraph, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept( this, arg ),
	combine(
	  p.graphdeconstructor_.accept( this, arg ),
	  meaning( p, arg ),
	  arg
	),
	arg
      )
    }

/* Binding */
    def visit( p : BoundVertex, arg : A ) : R
    =
    {
      combine(
	p.vertexbinding_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit(p : BoundEdge, arg : A) : R
    =
    {
      combine(
	p.edgebinding_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : BoundGraph, arg : A ) : R
    =
    {
      combine(
	p.graphbinding_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* VertexGenerator */
    def visit( p : LRGenVertex, arg : A ) : R
    =
    {
      combine(
	p.vertexcollection_.accept( this, arg ),
	combine(
	  p.vertexdeconstructor_.accept( this, arg ),
	  meaning( p, arg ),
	  arg),
	arg)
    }

/* EdgeGenerator */
    def visit( p : LRGenEdge, arg : A) : R
    =
    {
      combine(
	p.edgecollection_.accept( this, arg ),
	combine(
	  p.edgedeconstructor_.accept( this, arg ),
	  meaning( p, arg ),
	  arg),
	arg)
    }

/* GraphGenerator */
    def visit( p : LRGenGraph, arg : A ) : R
    =
    {
      combine(
	p.graphcollection_.accept( this, arg ),
	combine(
	  p.graphdeconstructor_.accept( this, arg ),
	  meaning( p, arg ),
	  arg),
	arg)
    }

/* Generator */
    def visit( p : GenVertex, arg : A ) : R
    =
    {
      combine(
	p.vertexgenerator_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : GenEdge, arg : A ) : R
    =
    {
      combine(
	p.edgegenerator_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : GenGraph, arg : A ) : R
    =
    {
      combine(
	p.graphgenerator_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* VertexExpr */
    def visit( p : VertexSum, arg : A ) : R
    =
    {
      combine(
	p.vertexexpr_2.accept( this, arg ),
	combine(
	  p.vertexexpr_1.accept( this, arg ),
	  meaning( p, arg ),
	  arg
	),
	arg
      )
    }
    def visit( p : VertexMult, arg : A ) : R 
    =
    {
      combine(
	p.vertexexpr_2.accept( this, arg ),
	combine(
	  p.vertexexpr_1.accept( this, arg ),
	  meaning( p, arg ),
	  arg
	),
	arg
      )
    }
    def visit( p : VertexLiteral, arg : A ) : R
    =
    {
      combine(
	p.vertex_.accept(this, arg),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : VertexVariable, arg : A ) : R
    =
    {
      meaning( p, arg );
    }
    def visit( p : VertexNegated, arg : A ) : R 
    =
    {
      combine(
	p.vertexexpr_.accept(this, arg),
	meaning( p, arg ),
	arg
      )
    }

/* VertexDeconstructor */
    def visit( p : VertexExprLabel, arg : A ) : R
    =
    {
      combine(
	p.vertexexpr_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* VertexActual */
    def visit( p : VertexActualized, arg : A ) : R
    =
    {
      combine(
	p.vertexexpr_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* EdgeExpr */
    def visit( p : EdgeExprNominal, arg : A ) : R 
    =
    {
      combine(
	p.edge_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : EdgeExprStruct, arg : A ) : R
    =
    {
      combine(
	p.vertexexpr_2.accept(this, arg),
	combine(
	  p.vertexexpr_1.accept(this, arg),
	  combine(
	    p.edge_.accept(this, arg),
	    meaning( p, arg ),
	    arg),
	  arg
	),
	arg
      )
    }

/* EdgePlus */
    def visit( p : EdgeName, arg : A ) : R
    =
    {
      combine(
	p.edge_.accept(this, arg),
	meaning( p, arg ),
	arg)
    }
    def visit( p : EdgeWildcard, arg : A ) : R
    =
    {
      meaning( p, arg )
    }

/* EdgeLabel */
    def visit( p : EdgeLiteral, arg : A ) : R
    =
    {
      combine(
	p.edge_.accept( this, arg ),
	meaning( p, arg ),
	arg)
    }
    def visit( p : EdgeVariable, arg : A ) : R
    =
    {
      meaning( p, arg )
    }

/* EdgeExprPattern */
    def visit( p : EdgeExprLabel, arg : A ) : R
    =
    {
      combine(
	p.edgelabel_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : EdgePatternStruct, arg : A ) : R
    =
    {
      combine(
	p.edgedeconstructor_.accept(this, arg),
	meaning( p, arg ),
	arg
      )
    }

/* EdgeActual */
    def visit( p : EdgeActualized, arg : A ) : R
    =
    {
      combine(
	p.edgelabel_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* EdgeDeconstructor */
    def visit( p : EdgePatternDecon, arg : A ) : R
    =
    {
      combine(
	p.vertexdeconstructor_2.accept( this, arg ),
	combine(
	  p.vertexdeconstructor_1.accept( this, arg ),
	  combine(
	    p.edgelabel_.accept( this, arg ),
	    meaning( p, arg ),
	    arg
	  ),
	  arg
	),
	arg
      )
    }

/* GraphDeconstructor */
    def visit( p : GraphIsolatedPattern, arg : A ) : R
    =
    {
      combine(
	p.graphdeconstructor_2.accept( this, arg ),
	combine(
	  p.graphdeconstructor_1.accept( this, arg ),
	  meaning( p, arg ),
	  arg),
	arg
      )
    }
    def visit( p : GraphPointedPattern, arg : A ) : R
    =
    {
      combine(
	p.vertexdeconstructor_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : GraphConnectedPattern, arg : A ) : R
    =
    {
      combine(
	p.graphdeconstructor_2.accept( this, arg ),
	combine(
	  p.graphdeconstructor_1.accept( this, arg ),
	  combine(
	    p.edgelabel_.accept( this, arg ),
	    meaning( p, arg ),
	    arg),
	  arg),
	arg
      )
    }
    def visit( p : GraphLiteral, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* ConditionOrDecl */
    def visit( p : ConditionIn, arg : A ) : R
    =
    {
      combine(
	p.condition_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : DeclIn, arg : A ) : R
    =
    {
      combine(
	p.decl_.accept(this, arg),
	meaning( p, arg ),
	arg
      )
    }

/* Decl */
    def visit( p : GeneratorDecl, arg : A ) : R
    =
    {
      combine(
	p.generator_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : LocalDecl, arg : A ) : R
    =
    {
      combine(
	p.binding_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* VertexCollection */
    def visit( p : VertexIntension, arg : A ) : R
    =
    {
      combine(
	p.vertexcomprehension_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : VertexExtenionExpr, arg : A ) : R
    =
    {
      combine(
	p.vertexextension_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* EdgeCollection */
    def visit( p : EdgeIntension, arg : A ) : R
    =
    {
      combine(
	p.edgecomprehension_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : EdgeExtenionExpr, arg : A ) : R
    =
    {
      combine(
	p.edgeextension_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* GraphCollection */
    def visit( p : GraphIntension, arg : A ) : R
    =
    {
      combine(
	p.graphcomprehension_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : GraphExtenionExpr, arg : A ) : R
    =
    {
      combine(
	p.graphextension_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* VertexExtension */
    def visit( p : VertexExtensionForm, arg : A ) : R
    =
    {
      (( meaning( p, arg ) /:
	p.listvertex_.asScala //scala.collection.jcl.Conversions.convertList(  )
      )({
	( acc: R, v : Vertex) =>
	  combine( v.accept( this,arg ), acc, arg )
      }))
    }
    def visit( p : VertexExtensionBuiltinExpr, arg : A ) : R
    =
    {
      combine(
	p.vertexextensionbuiltin_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* EdgeExtension */
    def visit( p : EdgeExtensionForm, arg : A ) : R
    =
    {
      val mg : R = meaning( p, arg )
      (( mg /: p.listedge_.asScala )({
	( acc: R, e : Edge ) =>
	  combine( e.accept( this,arg ), acc, arg )
      }))
    }
    def visit( p : EdgeExtensionBuiltinExpr, arg : A ) : R
    =
    {
      combine(
	p.edgeextensionbuiltin_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* GraphExtension */
    def visit( p : GraphExtensionForm, arg : A ) : R
    =
    {
      (( meaning( p, arg ) /:
	p.listgraphexpr_.asScala //scala.collection.jcl.Conversions.convertList( )
      )({
	( acc: R, g : GraphExpr ) =>
	  combine( g.accept( this,arg ), acc, arg )
      }))
    }
    def visit( p : GraphExtensionBuiltinExpr, arg : A ) : R
    =
    {
      combine(
	p.graphextensionbuiltin_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* VertexExtensionBuiltin */
    def visit( p : VertexSet, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : SourceSet, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : SinkSet, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* EdgeExtensionBuiltin */
    def visit( p : EdgeSet, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* GraphExtensionBuiltin */
    def visit( p : GraphComponents, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept(this, arg),
	meaning( p, arg ),
	arg
      )
    }

/* Condition */
    def visit( p : ConjunctionCondition, arg : A ) : R
    =
    {
      combine(
	p.condition_2.accept( this, arg ),
	combine(
	  p.condition_1.accept( this, arg ),
	  meaning( p, arg ),
	  arg
	),
	arg
      )
    }
    def visit( p : DisjunctionCondition, arg : A ) : R
    =
    {
      combine(
	p.condition_2.accept( this, arg ),
	combine(
	  p.condition_1.accept( this, arg ),
	  meaning( p, arg ),
	  arg
	),
	arg
      )
    }

    def visit( p : StructuralCondition, arg : A ) : R
    =
    {
      combine(
	p.structurecondition_.accept( this, arg ),
	leaf( arg ),
	arg
      )
    }
    
    def visit( p : BaseCondition, arg : A ) : R
    =
    {
      combine(
	p.groundcondition_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* StructureCondition */
    def visit( p : GraphIsolatedCond, arg : A ) : R
    =
    {
      combine(
	p.structurecondition_2.accept( this, arg ),
	combine(
	  p.structurecondition_1.accept( this, arg ),
	  leaf( arg ),
	  arg
	),
	arg
      )
    }

    def visit( p : GraphPointedCond, arg : A ) : R 
    =
    {
      combine(
	p.vertexstructurecondition_.accept( this, arg ),
	leaf( arg ),
	arg
      )
    }

    def visit( p : GraphConnectedCond, arg : A ) : R
    =
    {
      combine(
	p.structurecondition_2.accept( this, arg ),
	combine(
	  p.structurecondition_1.accept( this, arg ),
	  combine(
	    p.edgelabelcondition_.accept( this, arg ),
	    leaf( arg ),
	    arg
	  ),
	  arg
	),
	arg
      )
    }

    def visit( p : GraphStructureLiteral, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept( this, arg ),
	leaf( arg ),
	arg
      )
    }

/* VertexStructureCondition */
    def visit( p : VertexStructureSum, arg : A ) : R
    =
    {
      combine(
	p.vertexstructurecondition_2.accept( this, arg ),
	combine(
	  p.vertexstructurecondition_1.accept( this, arg ),
	  leaf( arg ),
	  arg
	),
	arg
      )
    }
    def visit( p : VertexStructureMult, arg : A ) : R
    =
    {
      combine(
	p.vertexstructurecondition_2.accept( this, arg ),
	combine(
	  p.vertexstructurecondition_1.accept( this, arg ),
	  leaf( arg ),
	  arg
	),
	arg
      )
    }

    def visit( p : VertexStructureLiteral, arg : A ) : R 
    =
    {
      combine(
	p.vertex_.accept( this, arg ),
	leaf(arg),
	arg
      )
    }
    def visit( p : VertexStructureVariable, arg : A ) : R
    =
    {
      combine(
	p.atomicformula_.accept( this, arg ),
	leaf( arg ),
	arg
      )
    }
    def visit( p : VertexStructureNegated, arg : A ) : R
    =
    {
      combine(
	p.vertexstructurecondition_.accept( this, arg ),
	leaf( arg ),
	arg
      )
    }

/* EdgeLabelCondition */
    def visit( p : EdgeLabelLiteralCondition, arg : A ) : R
    =
    {
      combine(
	p.edge_.accept( this, arg ),
	leaf(arg),
	arg
      )
    }
    def visit( p : EdgeLabelAtomicCondition, arg : A ) : R
    =
    {
      combine(
	p.atomicformula_.accept( this, arg ),
	leaf(arg),
	arg
      )
    }

/* GroundCondition */
    def visit( p : VertexBuiltinExpr, arg : A ) : R
    =
    {
      combine(
	p.vertexbuiltin_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : GraphBuiltinExpr, arg : A ) : R
    =
    {
      combine(
	p.graphbuiltin_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : AtomicCondition, arg : A ) : R
    =
    {
      combine(
	p.atomicformula_.accept( this, arg ),
	meaning( p,arg ),
	arg
      )
    }
    def visit( p : NegatedCondition, arg : A ) : R
    =
    {
      combine(
	p.groundcondition_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }

/* VertexBuiltin */
    def visit( p : SinkBuiltin, arg : A ) : R
    =
    {
      combine(
	p.vertexexpr_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : SourceBuiltin, arg : A ) : R
    =
    {
      combine(
	p.vertexexpr_.accept(this, arg),
	meaning( p, arg ),
	arg
      )
    }

/* GraphBuiltin */
    def visit( p : EmptyGraphBuiltin, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept(this, arg),
	meaning( p, arg ),
	arg
      )
    }

/* AtomicFormula */
    def visit( p : Verity, arg : A ) : R
    =
    {
      meaning( p, arg )
    }
    def visit( p : Absurdity, arg : A ) : R
    =
    {
      meaning( p, arg )
    }
    def visit( p : Nullity, arg : A ) : R
    =
    {
      meaning( p, arg )
    }

/* Edge */
    def visit( p : EdgeQuotation, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept( this, arg ),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : EdgeIntegral, arg : A ) : R
    =
    {
      meaning( p, arg )
    }
    def visit( p : EdgeString, arg : A ) : R
    =
    {
      meaning( p, arg )
    }

/* Vertex */
    def visit( p : VertexQuotation, arg : A ) : R
    =
    {
      combine(
	p.graphexpr_.accept(this, arg),
	meaning( p, arg ),
	arg
      )
    }
    def visit( p : VertexIntegral, arg : A ) : R
    =
    {
      meaning( p, arg )
    }
    def visit( p : VertexString, arg : A ) : R
    =
    {
      meaning( p, arg )
    }
 
  }
