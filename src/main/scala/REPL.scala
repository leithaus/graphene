// -*- mode: Scala;-*- 
// Filename:    REPL.scala 
// Authors:     lgm                                                    
// Creation:    Thu May  8 10:18:48 2008 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

package com.biosimilarity.GraphL.model

import com.biosimilarity.GraphL.model.GraphL._

import org.jgrapht._
import org.jgrapht.graph._
import org.jgrapht.ext._

import scala.collection.immutable.HashMap

import java.io.StringReader

class REPL
extends Eval.Evaluator
with Eval.ConcreteGraphTypes 
with Eval.GraphFormatConversions {
  // parsing
  def lexer (str : String) = new Yylex( new StringReader( str ) )
  def parser (str : String) = new parser( lexer( str ) )
  def clientRequestParseTree (str : String) = (parser( str )).pGraphExpr()
  def read (str : String) = clientRequestParseTree(str)  
  
  // evaluation
  case class Normalizer( evCtxt : EvaluationContext )
       extends StdGraphEvaluator {
	 def context = evCtxt
	 def evaluateGraph( expr : Absyn.GraphExpr ) : GraphType
	 = {
	   evaluateGraph( expr, evCtxt )
	 }
       }

  def eval ( expr : Absyn.GraphExpr ) : GraphType
  =
  {
    new Normalizer(
      new EvaluationContext(
	new DefaultDirectedGraph[Absyn.Vertex,GraphLEdge](
	  new GraphLEdgeFactory()
	),
	new HashMap[Absyn.VertexVariable,VertexType]().asInstanceOf[VEnvType],
	new HashMap[Absyn.EdgeVariable,EdgeType]().asInstanceOf[EEnvType],
	new HashMap[Absyn.Variable,GraphType]().asInstanceOf[GEnvType],
	None,
	None,
	None
	)
    ).evaluateGraph( expr ).asInstanceOf[GraphType]
  }

  // printing
  def showClientRequestParseTree (str : String)
  = PrettyPrinter.show(clientRequestParseTree(str))  

  def generateGraphML ( graph : GraphType )
  = toGraphMLStr( graph )

  // REP(the 'L' is in the webserver)
  def readEvalPrintAsGraphML( clientRequestStr : String ) : String 
  = toGraphMLStr( eval( read( clientRequestStr ) ) )
  def readEvalPrintAsDot( clientRequestStr : String ) : String 
  = toDotStr( eval( read( clientRequestStr ) ) )
  def readEvalPrintAsSVG( clientRequestStr : String ) : Option[String]
  = formatGraph( eval( read( clientRequestStr ) ),  "svg", true )
  def readEvalPrint( clientRequestStr : String ) : String
  = readEvalPrintAsSVG( clientRequestStr ) match {
      case None => ""
      case Some( str ) => str
  }
}
