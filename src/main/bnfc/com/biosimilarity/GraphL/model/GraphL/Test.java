package com.biosimilarity.GraphL.model.GraphL;
import java_cup.runtime.*;
import com.biosimilarity.GraphL.model.GraphL.*;
import com.biosimilarity.GraphL.model.GraphL.Absyn.*;
import java.io.*;

public class Test
{
  public static void main(String args[]) throws Exception
  {
    Yylex l = null;
    parser p;
    try
    {
      if (args.length == 0) l = new Yylex(System.in);
      else l = new Yylex(new FileReader(args[0]));
    }
    catch(FileNotFoundException e)
    {
     System.err.println("Error: File not found: " + args[0]);
     System.exit(1);
    }
    p = new parser(l);
    /* The default parser is the first-defined entry point. */
    /* You may want to change this. Other options are: */
    /* pFormals, pActuals, pSelectionExpr, pVertexSelectionExpr, pComprehension, pVertexComprehension, pEdgeComprehension, pGraphComprehension, pVertexBinding, pEdgeBinding, pGraphBinding, pBinding, pVertexGenerator, pEdgeGenerator, pGraphGenerator, pGenerator, pVertexExpr, pVertexDeconstructor, pVertexActual, pEdgeExpr, pEdgePlus, pEdgeLabel, pEdgeExprPattern, pEdgeActual, pEdgeDeconstructor, pGraphDeconstructor, pConditionOrDecl, pDecl, pVertexCollection, pEdgeCollection, pGraphCollection, pVertexExtension, pEdgeExtension, pGraphExtension, pVertexExtensionBuiltin, pEdgeExtensionBuiltin, pGraphExtensionBuiltin, pCondition, pStructureCondition, pVertexStructureCondition, pEdgeLabelCondition, pGroundCondition, pVertexBuiltin, pGraphBuiltin, pAtomicFormula, pListConditionOrDecl, pListCondition, pListVertex, pListEdge, pListVertexActual, pListEdgeActual, pListGraphExpr, pListLIdent, pListBinding, pListVertexBinding, pEdge, pVertex */
    try
    {
      com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExpr parse_tree = p.pGraphExpr();
      System.out.println();
      System.out.println("Parse Succesful!");
      System.out.println();
      System.out.println("[Abstract Syntax]");
      System.out.println();
      System.out.println(PrettyPrinter.show(parse_tree));
      System.out.println();
      System.out.println("[Linearized Tree]");
      System.out.println();
      System.out.println(PrettyPrinter.print(parse_tree));
    }
    catch(Throwable e)
    {
      System.err.println("At line " + String.valueOf(l.line_num()) + ", near \"" + l.buff() + "\" :");
      System.err.println("     " + e.getMessage());
      System.exit(1);
    }
  }
}
