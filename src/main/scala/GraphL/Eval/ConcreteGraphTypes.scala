package com.biosimilarity.GraphL.model.GraphL.Eval

import com.biosimilarity.GraphL.model.GraphL._
import com.biosimilarity.GraphL.model.GraphL.Eval._

import org.jgrapht._
import org.jgrapht.graph._
import org.jgrapht.ext._

import scala.collection.immutable.HashMap

import java.io.FileWriter
import java.io.StringWriter
import java.io.PrintWriter

import java.util.Collections
import java.util.List
import java.util.ArrayList

trait ConcreteGraphTypes {
  type VertexType = Absyn.Vertex
  type EdgeType = GraphLEdge
  type GraphType = DirectedGraph[Absyn.Vertex,GraphLEdge]

  trait GraphLIdentifierProvider {
    def generateUniqueLabels : Boolean = false
    def nextSeqTag : String 
    val memoPad : scala.collection.mutable.Map[Absyn.Vertex,String] =
      new scala.collection.mutable.HashMap[Absyn.Vertex,String]
    def getName( absV : Absyn.Vertex ) : String =
      memoPad.get( absV ) match {
	case Some( name ) => name
	case None => {
	  val name : String = computeName( absV );
	  memoPad += ( absV -> name )
	  name
	}
      }

    def grabName( absV : Absyn.Vertex ) : String =
      absV match {
	case integral : Absyn.VertexIntegral =>
	  integral.integer_.toString
	case str : Absyn.VertexString =>
	  str.string_
	case quote : Absyn.VertexQuotation =>
	  quote.graphexpr_.toString
      }

    def computeName( absV : Absyn.Vertex ) : String =
      (grabName( absV )
       + (if (generateUniqueLabels) {
	   (":" + System.currentTimeMillis)
	   }
	  else { "" })) //+ nextSeqTag
  }

  case class GraphLVertexIdProvider( label : Int, _genUnqLbls : Boolean )       
       extends VertexNameProvider[Absyn.Vertex] 
       with GraphLIdentifierProvider {
	 var count : Int = label
	 override def generateUniqueLabels : Boolean = _genUnqLbls
	 override def nextSeqTag : String = {
	   count = count + 1;
	   ((count * 3) + 1).toString
	 }
	 override def getVertexName( absV : Absyn.Vertex ) : String =
	   getName( absV )
       }

  case class GraphLVertexDotIdProvider(
    labelseed : Int, genUnqLbls : Boolean
  )
      extends GraphLVertexIdProvider( labelseed, genUnqLbls ) {
	override def getVertexName( absV : Absyn.Vertex ) : String =
	  getName( absV ).replace( '.', '_' )
      }

  case class GraphLVertexLabelProvider( label : Int, _genUnqLbls : Boolean )
       extends VertexNameProvider[Absyn.Vertex] 
       with GraphLIdentifierProvider {
	 override def generateUniqueLabels : Boolean = _genUnqLbls
	 var count : Int = label
	 override def nextSeqTag : String = {
	   count = count + 1;
	   ((count * 3) + 2).toString
	 }
	 override def getVertexName( absV : Absyn.Vertex ) : String =
	   getName( absV ).replace( '.', '_' )
       }

  case class GraphLEdgeNameProvider( label : Int, _genUnqLbls : Boolean )
       extends EdgeNameProvider[GraphLEdge] 
       with GraphLIdentifierProvider {
	 override def generateUniqueLabels : Boolean = _genUnqLbls
	 var count : Int = label
	 override def nextSeqTag : String = {
	   count = count + 1;
	   //(count * 3).toString
	   count.toString
	 }
	 override def getEdgeName( edge : GraphLEdge ) : String =
	   edge.wire match {
	     case None => nextSeqTag
	     case Some( aedge ) => aedge match {
	       case edgeint : Absyn.EdgeIntegral =>
		 edgeint.integer_.toString
	       case edgestr : Absyn.EdgeString =>
		 edgestr.string_
	       case edgeq : Absyn.EdgeQuotation =>
		 edgeq.graphexpr_.toString
	     }
	   }
       }

  trait Edgy[A,W,B] {
    def src : A
    def trgt : B
    def wire : W
  }
  class GraphLEdge() extends Edgy[Absyn.Vertex, Option[Absyn.Edge], Absyn.Vertex] {
    var _src : Absyn.Vertex = null
    var _trgt : Absyn.Vertex = null    
    var _wire : Option[Absyn.Edge] = None
    override def src = _src
    override def trgt = _trgt
    override def wire = _wire
    override def toString : String =
      ("("
       + src.toString
       + " -> "
       + trgt.toString
       + ")")
  }

  class GraphLEdgeFactory extends EdgeFactory[Absyn.Vertex,GraphLEdge] {
    override def createEdge(
      src : Absyn.Vertex,
      trgt : Absyn.Vertex
    ) : GraphLEdge =
      {
	val ans = new GraphLEdge()
	ans._src = src
	ans._trgt = trgt
	ans
      }
  }

  def toDotFile(
    fileName : String,
    graph : DirectedGraph[Absyn.Vertex,GraphLEdge]
  ) : Unit = 
    new DOTExporter[Absyn.Vertex,GraphLEdge](
      new GraphLVertexDotIdProvider(0,false),
      new GraphLVertexLabelProvider(0,false),
      new GraphLEdgeNameProvider(0,false)
    ).export( new FileWriter( fileName ), graph )

  def toDotStr(
    graph : GraphType
  ) : String = {
    val sw : StringWriter = new StringWriter( );
    new DOTExporter[Absyn.Vertex,GraphLEdge](
      new GraphLVertexDotIdProvider(0,false),
      new GraphLVertexLabelProvider(0,false),
      new GraphLEdgeNameProvider(0,false)
    ).export( new PrintWriter( sw ), graph );
    sw.toString
  }

  def toGraphMLFile(
    fileName : String,
    graph : GraphType
  ) : Unit = 
    new GraphMLExporter[Absyn.Vertex,GraphLEdge](
      new GraphLVertexDotIdProvider(0,false),
      new GraphLVertexLabelProvider(0,false),
      new GraphLEdgeNameProvider(0,false),
      new GraphLEdgeNameProvider(0,false)
    ).export( new FileWriter( fileName ), graph )

  def toGraphMLStr(
    graph : GraphType
  ) : String = {
    val sw : StringWriter = new StringWriter( );
    new GraphMLExporter[Absyn.Vertex,GraphLEdge](
      new GraphLVertexDotIdProvider(0,false),
      new GraphLVertexLabelProvider(0,false),
      new GraphLEdgeNameProvider(0,false),
      new GraphLEdgeNameProvider(0,false)
    ).export( new PrintWriter( sw ), graph );
    sw.toString
  }
}


