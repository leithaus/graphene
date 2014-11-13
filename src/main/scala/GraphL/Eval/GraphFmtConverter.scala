// -*- mode: Scala;-*- 
// Filename:    GraphFmtConverter.scala 
// Authors:     lgm                                                    
// Creation:    Sun Jan  4 13:43:54 2009 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

package com.biosimilarity.GraphL.model.GraphL.Eval

import com.biosimilarity.GraphL.model.GraphL._

import org.jgrapht._
import org.jgrapht.graph._
import org.jgrapht.ext._

import scala.xml._
import scala.actors._
import scala.collection.mutable.HashMap

import java.io.StringWriter

trait GraphFormatConversions 
extends ConcreteGraphTypes {
  // OK -- i know there ** M U S T ** be a non-polling way to get the result
  // from the scala actor -- but the documentation is so far from what
  // actually works -- and i don't have time to dig -- so... i've
  // written a polling interface
  
  case class Receiver(
    _pendingStr : String,
    _results : HashMap[String,String]
  )
  {	 
    val _locks : HashMap[String,Boolean] =
      new HashMap[String,Boolean]()

    def enterReq() : String = {
      val reqId : String = ("req" + System.currentTimeMillis);
      _results.update( reqId, _pendingStr );
      reqId
    }
    def enterResp( key : String, ans : String ) : Unit = {
      _results.update( key, ans );
      _locks.update( key, true )
    }
  def state( key : String ) : String =
    _results.get( key ) match {
      case None => "completed"
      case Some( stuff ) => {
	if ( stuff == _pendingStr ) {
	  _pendingStr
	}
	else { stuff }
      }
    }
    
    def poll( key : String ) : Option[String] = {    
      var loop : Boolean = true;
      var ans : Option[String] = None;
      while( loop ) {
	//println( "polling for request: " + key );
	_locks.get( key ) match {
	  case None => loop = true
	  case Some( stuff ) => {
	    loop = false;
	    ans = _results.get( key )
	  }
	}
      };
      ans
    }
  }

  val _receptionista : Receiver =
    Receiver(
      ("pending" + System.currentTimeMillis),
      new HashMap[String,String]()
    )

  case class Convert(
    _key : String,
    _graph : GraphType,
    _trgtFmt : String,
    _receiver : Receiver
  ) {
    def reqId = _key
    def graph = _graph
    def trgtFmt = _trgtFmt
    def receiver = _receiver
  }

  case class Conversion(
    _key : String,
    _trgtFmt : String,
    _location : Option[String],
    _receiver : Receiver
  ) {
    def reqId = _key
    def trgtFmt = _trgtFmt
    def location = _location
    def receiver = _receiver
  }

  case class Stop() {}
  case class Ping() {}

  object GraphFormatConverter
       extends Actor {
	 def act() {
	   react {
	     case Convert( key, graph, trgtFmt, cont ) =>
	       //println( "about to send generateFmt msg to " + Actor.self )
	       Actor.self ! generateFmt( key, graph, trgtFmt, cont )
	       act()
	     case Conversion( key, trgtFmt, Some( trgtFmtFileName ), cont ) =>
	       //println( Actor.self + ": processing Conversion msg" )
	       cont.enterResp(
		 key, readFmtFromFile( trgtFmt, trgtFmtFileName )
	       )
	       act()
	     case Stop() => 
	       //println( "stopping" )
	   }
	 }
	 
	 def generateFmt (
	   key : String,
	   graph : GraphType,
	   trgtFmt : String,
	   receiver : Receiver
	 ) : Unit
	 = 
	   try {
	     //println( Actor.self + ": processing generateFmt msg" );
	     val fileName : String = ("Graph" + System.currentTimeMillis);
	     val dotFileName : String = fileName + ".dot";
	     val trgtFmtFileName : String = fileName + "." + trgtFmt;
	     val dotCmdLine : String =
	       ("dot -T"
		+ trgtFmt
		+ " "
		+ dotFileName
		+ " -o "
		+ trgtFmtFileName);    
	     
	     toDotFile( dotFileName, graph );    
	     
	     val lChldProc : Process = Runtime.getRuntime().exec( dotCmdLine );
	     lChldProc.waitFor();    
	     //println( "about to send Conversion msg to " + Actor.self );
	     (Actor.self !
	      Conversion( key, trgtFmt, Some( trgtFmtFileName ), receiver ))
	   }
	 catch {
	   case _ => Conversion( key, trgtFmt, None, receiver )
	 }

	 def readFmtFromFile(
	   trgtFmt : String,
	   trgtFmtFileName : String
	 ) : String = {
	   trgtFmt match {
	     case "svg" => {
	       val loadNode = xml.XML.loadFile( trgtFmtFileName );
	       loadNode.toString
	     }
	     case _ => {
	       val sw : StringWriter = new StringWriter();
	       val src = scala.io.Source.fromFile( trgtFmtFileName );
	       val lines = src.getLines;
	       val lineList = lines.toList
	       for ( line <- lineList )
	       yield {
		 //println( line );
		 sw.write( line )
	       };
	       sw.flush();
	       sw.toString()
	     }
	   }
	 }
       }
  
  def formatGraph(
    graph : GraphType,
    trgtFmt : String,
    waitForAnAnswer : Boolean
  ) : Option[String] = {	   
    val reqId : String = _receptionista.enterReq()
    //println( "processing request: " + reqId )
    //println( "receptionista in state " + _receptionista.state( reqId ) )
    
    GraphFormatConverter.start();
    
    (GraphFormatConverter
     ! Convert( reqId, graph, trgtFmt, _receptionista ));
    
    waitForAnAnswer match {
      case true => _receptionista.poll( reqId )
      case _ => None
    }
  }
}

object TheGraphFormatConversions  
       extends GraphFormatConversions {	 	 	 
       }
