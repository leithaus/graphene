package com.biosimilarity.GraphL.model.GraphL;
import com.biosimilarity.GraphL.model.GraphL.Absyn.*;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + 2;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       _n_ = _n_ - 2;
       backup();
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExpr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExpr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.Formals foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.Formals foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.Actuals foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.Actuals foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.SelectionExpr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.SelectionExpr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelectionExpr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelectionExpr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.Comprehension foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.Comprehension foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehension foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehension foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehension foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehension foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehension foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehension foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBinding foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBinding foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeBinding foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeBinding foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBinding foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBinding foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.Binding foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.Binding foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexGenerator foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexGenerator foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeGenerator foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeGenerator foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphGenerator foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphGenerator foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.Generator foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.Generator foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExpr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExpr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexDeconstructor foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexDeconstructor foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActual foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActual foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExpr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExpr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePlus foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePlus foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabel foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabel foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprPattern foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprPattern foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActual foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActual foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeDeconstructor foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeDeconstructor foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphDeconstructor foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphDeconstructor foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionOrDecl foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionOrDecl foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.Decl foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.Decl foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexCollection foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexCollection foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeCollection foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeCollection foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphCollection foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphCollection foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtension foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtension foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtension foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtension foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtension foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtension foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltin foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltin foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltin foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltin foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltin foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltin foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.Condition foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.Condition foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.StructureCondition foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.StructureCondition foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureCondition foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureCondition foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelCondition foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelCondition foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.GroundCondition foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.GroundCondition foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltin foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltin foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltin foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltin foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicFormula foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicFormula foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.ListConditionOrDecl foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.ListConditionOrDecl foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.ListCondition foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.ListCondition foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.ListVertex foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.ListVertex foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.ListEdge foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.ListEdge foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.ListVertexActual foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.ListVertexActual foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.ListEdgeActual foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.ListEdgeActual foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.ListGraphExpr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.ListGraphExpr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.ListLIdent foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.ListLIdent foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.ListBinding foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.ListBinding foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.ListVertexBinding foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.ListVertexBinding foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.Edge foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.Edge foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.GraphL.model.GraphL.Absyn.Vertex foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.GraphL.model.GraphL.Absyn.Vertex foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExpr foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Isolated)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Isolated _isolated = (com.biosimilarity.GraphL.model.GraphL.Absyn.Isolated) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_isolated.graphexpr_1, 0);
       render("|");
       pp(_isolated.graphexpr_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Selected)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Selected _selected = (com.biosimilarity.GraphL.model.GraphL.Absyn.Selected) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_selected.selectionexpr_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Connected)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Connected _connected = (com.biosimilarity.GraphL.model.GraphL.Absyn.Connected) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_connected.edgeplus_, 0);
       render("(");
       pp(_connected.vertexselectionexpr_1, 0);
       render(",");
       pp(_connected.vertexselectionexpr_2, 0);
       render(")");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Recursed)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Recursed _recursed = (com.biosimilarity.GraphL.model.GraphL.Absyn.Recursed) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("(");
       render("rec");
       pp(_recursed.uident_, 0);
       pp(_recursed.formals_, 0);
       render("=");
       pp(_recursed.graphexpr_, 2);
       render(")");
       pp(_recursed.actuals_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Pointed)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Pointed _pointed = (com.biosimilarity.GraphL.model.GraphL.Absyn.Pointed) foo;
       if (_i_ > 2) render(_L_PAREN);
       render("<");
       pp(_pointed.vertex_, 0);
       render(">");
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Variable)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Variable _variable = (com.biosimilarity.GraphL.model.GraphL.Absyn.Variable) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_variable.uident_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Applied)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Applied _applied = (com.biosimilarity.GraphL.model.GraphL.Absyn.Applied) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_applied.uident_, 0);
       pp(_applied.actuals_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Empty)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Empty _empty = (com.biosimilarity.GraphL.model.GraphL.Absyn.Empty) foo;
       if (_i_ > 2) render(_L_PAREN);
       render("Nil");
       if (_i_ > 2) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.Formals foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsFullForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsFullForm _formalsfullform = (com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsFullForm) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("(");
       pp(_formalsfullform.listlident_1, 0);
       render(";");
       pp(_formalsfullform.listlident_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsVertexForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsVertexForm _formalsvertexform = (com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsVertexForm) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("(");
       pp(_formalsvertexform.listlident_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.Actuals foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsFullForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsFullForm _actualsfullform = (com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsFullForm) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("<");
       pp(_actualsfullform.listvertexactual_, 0);
       render(";");
       pp(_actualsfullform.listedgeactual_, 0);
       render(">");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsVertexForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsVertexForm _actualsvertexform = (com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsVertexForm) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("<");
       pp(_actualsvertexform.listvertexactual_, 0);
       render(">");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.SelectionExpr foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Selection)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Selection _selection = (com.biosimilarity.GraphL.model.GraphL.Absyn.Selection) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("let");
       pp(_selection.listbinding_, 0);
       render("in");
       pp(_selection.graphexpr_, 2);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionExpr _comprehensionexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_comprehensionexpr.comprehension_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelectionExpr foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection _vertexselection = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("let");
       pp(_vertexselection.listvertexbinding_, 0);
       render("in");
       pp(_vertexselection.graphexpr_, 2);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntensionSelection)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntensionSelection _vertexintensionselection = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntensionSelection) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vertexintensionselection.vertexcomprehension_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.Comprehension foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionForm _comprehensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionForm) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("{");
       pp(_comprehensionform.generator_, 0);
       render("|");
       pp(_comprehensionform.listconditionordecl_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehension foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehensionForm _vertexcomprehensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehensionForm) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("{");
       pp(_vertexcomprehensionform.vertexgenerator_, 0);
       render("|");
       pp(_vertexcomprehensionform.listconditionordecl_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehension foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehensionForm _edgecomprehensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehensionForm) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("{");
       pp(_edgecomprehensionform.edgegenerator_, 0);
       render("|");
       pp(_edgecomprehensionform.listconditionordecl_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehension foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehensionForm _graphcomprehensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehensionForm) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("{");
       pp(_graphcomprehensionform.graphgenerator_, 0);
       render("|");
       pp(_graphcomprehensionform.listconditionordecl_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBinding foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundVertex)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundVertex _lrboundvertex = (com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundVertex) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_lrboundvertex.vertexdeconstructor_, 0);
       render("=");
       pp(_lrboundvertex.vertex_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeBinding foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundEdge)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundEdge _lrboundedge = (com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundEdge) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_lrboundedge.edgedeconstructor_, 0);
       render("=");
       pp(_lrboundedge.edgeexpr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBinding foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundGraph)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundGraph _lrboundgraph = (com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundGraph) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_lrboundgraph.graphdeconstructor_, 0);
       render("=");
       pp(_lrboundgraph.graphexpr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.Binding foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.BoundVertex)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.BoundVertex _boundvertex = (com.biosimilarity.GraphL.model.GraphL.Absyn.BoundVertex) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_boundvertex.vertexbinding_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.BoundEdge)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.BoundEdge _boundedge = (com.biosimilarity.GraphL.model.GraphL.Absyn.BoundEdge) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_boundedge.edgebinding_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.BoundGraph)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.BoundGraph _boundgraph = (com.biosimilarity.GraphL.model.GraphL.Absyn.BoundGraph) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_boundgraph.graphbinding_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexGenerator foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenVertex)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenVertex _lrgenvertex = (com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenVertex) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_lrgenvertex.vertexdeconstructor_, 0);
       render("<-");
       pp(_lrgenvertex.vertexcollection_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeGenerator foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenEdge)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenEdge _lrgenedge = (com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenEdge) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_lrgenedge.edgedeconstructor_, 0);
       render("<-");
       pp(_lrgenedge.edgecollection_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphGenerator foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenGraph)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenGraph _lrgengraph = (com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenGraph) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_lrgengraph.graphdeconstructor_, 0);
       render("<-");
       pp(_lrgengraph.graphcollection_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.Generator foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GenVertex)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GenVertex _genvertex = (com.biosimilarity.GraphL.model.GraphL.Absyn.GenVertex) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_genvertex.vertexgenerator_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GenEdge)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GenEdge _genedge = (com.biosimilarity.GraphL.model.GraphL.Absyn.GenEdge) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_genedge.edgegenerator_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph _gengraph = (com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_gengraph.graphgenerator_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExpr foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSum)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSum _vertexsum = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSum) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vertexsum.vertexexpr_1, 0);
       render("+");
       pp(_vertexsum.vertexexpr_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexMult)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexMult _vertexmult = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexMult) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_vertexmult.vertexexpr_1, 1);
       render("*");
       pp(_vertexmult.vertexexpr_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexLiteral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexLiteral _vertexliteral = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexLiteral) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_vertexliteral.vertex_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexVariable)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexVariable _vertexvariable = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexVariable) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_vertexvariable.lident_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexNegated)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexNegated _vertexnegated = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexNegated) foo;
       if (_i_ > 2) render(_L_PAREN);
       render("-");
       pp(_vertexnegated.vertexexpr_, 2);
       if (_i_ > 2) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexDeconstructor foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExprLabel)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExprLabel _vertexexprlabel = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExprLabel) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vertexexprlabel.vertexexpr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActual foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActualized)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActualized _vertexactualized = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActualized) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vertexactualized.vertexexpr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExpr foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprNominal)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprNominal _edgeexprnominal = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprNominal) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgeexprnominal.edge_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprStruct)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprStruct _edgeexprstruct = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprStruct) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgeexprstruct.edge_, 0);
       render("(");
       pp(_edgeexprstruct.vertexexpr_1, 0);
       render(",");
       pp(_edgeexprstruct.vertexexpr_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePlus foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeName)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeName _edgename = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeName) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgename.edge_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeWildcard)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeWildcard _edgewildcard = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeWildcard) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgewildcard.wild_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabel foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLiteral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLiteral _edgeliteral = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLiteral) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgeliteral.edge_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeVariable)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeVariable _edgevariable = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeVariable) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgevariable.lident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprPattern foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprLabel)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprLabel _edgeexprlabel = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprLabel) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgeexprlabel.edgelabel_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternStruct)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternStruct _edgepatternstruct = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternStruct) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgepatternstruct.edgedeconstructor_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActual foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActualized)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActualized _edgeactualized = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActualized) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgeactualized.edgelabel_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeDeconstructor foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternDecon)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternDecon _edgepatterndecon = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternDecon) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgepatterndecon.edgelabel_, 0);
       render("?(");
       pp(_edgepatterndecon.vertexdeconstructor_1, 0);
       render(",");
       pp(_edgepatterndecon.vertexdeconstructor_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphDeconstructor foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedPattern)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedPattern _graphisolatedpattern = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedPattern) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_graphisolatedpattern.graphdeconstructor_1, 0);
       render("*");
       pp(_graphisolatedpattern.graphdeconstructor_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedPattern)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedPattern _graphpointedpattern = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedPattern) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("<?");
       pp(_graphpointedpattern.vertexdeconstructor_, 0);
       render("?>");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedPattern)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedPattern _graphconnectedpattern = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedPattern) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_graphconnectedpattern.edgelabel_, 0);
       render("?(");
       pp(_graphconnectedpattern.graphdeconstructor_1, 2);
       render(",");
       pp(_graphconnectedpattern.graphdeconstructor_2, 2);
       render(")");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphLiteral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphLiteral _graphliteral = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphLiteral) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_graphliteral.graphexpr_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionOrDecl foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionIn)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionIn _conditionin = (com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionIn) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_conditionin.condition_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.DeclIn)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.DeclIn _declin = (com.biosimilarity.GraphL.model.GraphL.Absyn.DeclIn) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_declin.decl_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.Decl foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl _generatordecl = (com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_generatordecl.generator_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LocalDecl)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LocalDecl _localdecl = (com.biosimilarity.GraphL.model.GraphL.Absyn.LocalDecl) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("let");
       pp(_localdecl.binding_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexCollection foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntension)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntension _vertexintension = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntension) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vertexintension.vertexcomprehension_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtenionExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtenionExpr _vertexextenionexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtenionExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vertexextenionexpr.vertexextension_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeCollection foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntension)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntension _edgeintension = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntension) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgeintension.edgecomprehension_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtenionExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtenionExpr _edgeextenionexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtenionExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgeextenionexpr.edgeextension_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphCollection foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIntension)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIntension _graphintension = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIntension) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_graphintension.graphcomprehension_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtenionExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtenionExpr _graphextenionexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtenionExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_graphextenionexpr.graphextension_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtension foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionForm _vertexextensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionForm) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("{@");
       pp(_vertexextensionform.listvertex_, 0);
       render("@}");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltinExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltinExpr _vertexextensionbuiltinexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltinExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vertexextensionbuiltinexpr.vertexextensionbuiltin_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtension foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionForm _edgeextensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionForm) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("{-");
       pp(_edgeextensionform.listedge_, 0);
       render("-}");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltinExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltinExpr _edgeextensionbuiltinexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltinExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgeextensionbuiltinexpr.edgeextensionbuiltin_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtension foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionForm _graphextensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionForm) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("{*");
       pp(_graphextensionform.listgraphexpr_, 0);
       render("*}");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltinExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltinExpr _graphextensionbuiltinexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltinExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_graphextensionbuiltinexpr.graphextensionbuiltin_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltin foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSet)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSet _vertexset = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSet) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("vertices");
       render("(");
       pp(_vertexset.graphexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.SourceSet)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.SourceSet _sourceset = (com.biosimilarity.GraphL.model.GraphL.Absyn.SourceSet) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("sources");
       render("(");
       pp(_sourceset.graphexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.SinkSet)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.SinkSet _sinkset = (com.biosimilarity.GraphL.model.GraphL.Absyn.SinkSet) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("sinks");
       render("(");
       pp(_sinkset.graphexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltin foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeSet)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeSet _edgeset = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeSet) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("edges");
       render("(");
       pp(_edgeset.graphexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltin foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComponents)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComponents _graphcomponents = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComponents) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("components");
       render("(");
       pp(_graphcomponents.graphexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.Condition foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.ConjunctionCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.ConjunctionCondition _conjunctioncondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.ConjunctionCondition) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_conjunctioncondition.condition_1, 0);
       render("||");
       pp(_conjunctioncondition.condition_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.DisjunctionCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.DisjunctionCondition _disjunctioncondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.DisjunctionCondition) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_disjunctioncondition.condition_1, 1);
       render("&");
       pp(_disjunctioncondition.condition_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.StructuralCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.StructuralCondition _structuralcondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.StructuralCondition) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_structuralcondition.structurecondition_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.BaseCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.BaseCondition _basecondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.BaseCondition) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_basecondition.groundcondition_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.StructureCondition foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedCond)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedCond _graphisolatedcond = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedCond) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_graphisolatedcond.structurecondition_1, 0);
       render("*");
       pp(_graphisolatedcond.structurecondition_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedCond)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedCond _graphpointedcond = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedCond) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("<??");
       pp(_graphpointedcond.vertexstructurecondition_, 0);
       render("??>");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedCond)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedCond _graphconnectedcond = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedCond) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_graphconnectedcond.edgelabelcondition_, 0);
       render("??(");
       pp(_graphconnectedcond.structurecondition_1, 2);
       render(",");
       pp(_graphconnectedcond.structurecondition_2, 2);
       render(")");
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphStructureLiteral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphStructureLiteral _graphstructureliteral = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphStructureLiteral) foo;
       if (_i_ > 2) render(_L_PAREN);
       render("'");
       pp(_graphstructureliteral.graphexpr_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureCondition foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureSum)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureSum _vertexstructuresum = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureSum) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vertexstructuresum.vertexstructurecondition_1, 0);
       render("+");
       pp(_vertexstructuresum.vertexstructurecondition_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult _vertexstructuremult = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_vertexstructuremult.vertexstructurecondition_1, 1);
       render("*");
       pp(_vertexstructuremult.vertexstructurecondition_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureLiteral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureLiteral _vertexstructureliteral = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureLiteral) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_vertexstructureliteral.vertex_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureVariable)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureVariable _vertexstructurevariable = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureVariable) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_vertexstructurevariable.atomicformula_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureNegated)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureNegated _vertexstructurenegated = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureNegated) foo;
       if (_i_ > 2) render(_L_PAREN);
       render("-");
       pp(_vertexstructurenegated.vertexstructurecondition_, 2);
       if (_i_ > 2) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelCondition foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelLiteralCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelLiteralCondition _edgelabelliteralcondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelLiteralCondition) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgelabelliteralcondition.edge_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelAtomicCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelAtomicCondition _edgelabelatomiccondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelAtomicCondition) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_edgelabelatomiccondition.atomicformula_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.GroundCondition foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltinExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltinExpr _vertexbuiltinexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltinExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vertexbuiltinexpr.vertexbuiltin_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltinExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltinExpr _graphbuiltinexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltinExpr) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_graphbuiltinexpr.graphbuiltin_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicCondition _atomiccondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicCondition) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_atomiccondition.atomicformula_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.NegatedCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.NegatedCondition _negatedcondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.NegatedCondition) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("~");
       pp(_negatedcondition.groundcondition_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltin foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.SinkBuiltin)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.SinkBuiltin _sinkbuiltin = (com.biosimilarity.GraphL.model.GraphL.Absyn.SinkBuiltin) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("sink");
       render("(");
       pp(_sinkbuiltin.vertexexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.SourceBuiltin)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.SourceBuiltin _sourcebuiltin = (com.biosimilarity.GraphL.model.GraphL.Absyn.SourceBuiltin) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("source");
       render("(");
       pp(_sourcebuiltin.vertexexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltin foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EmptyGraphBuiltin)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EmptyGraphBuiltin _emptygraphbuiltin = (com.biosimilarity.GraphL.model.GraphL.Absyn.EmptyGraphBuiltin) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("empty");
       render("(");
       pp(_emptygraphbuiltin.graphexpr_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicFormula foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Verity)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Verity _verity = (com.biosimilarity.GraphL.model.GraphL.Absyn.Verity) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("true");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Absurdity)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Absurdity _absurdity = (com.biosimilarity.GraphL.model.GraphL.Absyn.Absurdity) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("false");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Nullity)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Nullity _nullity = (com.biosimilarity.GraphL.model.GraphL.Absyn.Nullity) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("null");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.ListConditionOrDecl foo, int _i_)
  {
     for (java.util.Iterator<ConditionOrDecl> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.ListCondition foo, int _i_)
  {
     for (java.util.Iterator<Condition> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.ListVertex foo, int _i_)
  {
     for (java.util.Iterator<Vertex> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.ListEdge foo, int _i_)
  {
     for (java.util.Iterator<Edge> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.ListVertexActual foo, int _i_)
  {
     for (java.util.Iterator<VertexActual> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.ListEdgeActual foo, int _i_)
  {
     for (java.util.Iterator<EdgeActual> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.ListGraphExpr foo, int _i_)
  {
     for (java.util.Iterator<GraphExpr> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.ListLIdent foo, int _i_)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.ListBinding foo, int _i_)
  {
     for (java.util.Iterator<Binding> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(";");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.ListVertexBinding foo, int _i_)
  {
     for (java.util.Iterator<VertexBinding> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(";");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.Edge foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeQuotation)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeQuotation _edgequotation = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeQuotation) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("((");
       pp(_edgequotation.graphexpr_, 0);
       render("))");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntegral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntegral _edgeintegral = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntegral) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("((");
       pp(_edgeintegral.integer_, 0);
       render("))");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeString)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeString _edgestring = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeString) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("((");
       printQuoted(_edgestring.string_);
       render("))");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.GraphL.model.GraphL.Absyn.Vertex foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexQuotation)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexQuotation _vertexquotation = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexQuotation) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("[[");
       pp(_vertexquotation.graphexpr_, 0);
       render("]]");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntegral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntegral _vertexintegral = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntegral) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("[[");
       pp(_vertexintegral.integer_, 0);
       render("]]");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexString)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexString _vertexstring = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexString) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("[[");
       printQuoted(_vertexstring.string_);
       render("]]");
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExpr foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Isolated)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Isolated _isolated = (com.biosimilarity.GraphL.model.GraphL.Absyn.Isolated) foo;
       render("(");
       render("Isolated");
       sh(_isolated.graphexpr_1);
       sh(_isolated.graphexpr_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Selected)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Selected _selected = (com.biosimilarity.GraphL.model.GraphL.Absyn.Selected) foo;
       render("(");
       render("Selected");
       sh(_selected.selectionexpr_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Connected)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Connected _connected = (com.biosimilarity.GraphL.model.GraphL.Absyn.Connected) foo;
       render("(");
       render("Connected");
       sh(_connected.edgeplus_);
       sh(_connected.vertexselectionexpr_1);
       sh(_connected.vertexselectionexpr_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Recursed)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Recursed _recursed = (com.biosimilarity.GraphL.model.GraphL.Absyn.Recursed) foo;
       render("(");
       render("Recursed");
       sh(_recursed.uident_);
       sh(_recursed.formals_);
       sh(_recursed.graphexpr_);
       sh(_recursed.actuals_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Pointed)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Pointed _pointed = (com.biosimilarity.GraphL.model.GraphL.Absyn.Pointed) foo;
       render("(");
       render("Pointed");
       sh(_pointed.vertex_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Variable)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Variable _variable = (com.biosimilarity.GraphL.model.GraphL.Absyn.Variable) foo;
       render("(");
       render("Variable");
       sh(_variable.uident_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Applied)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Applied _applied = (com.biosimilarity.GraphL.model.GraphL.Absyn.Applied) foo;
       render("(");
       render("Applied");
       sh(_applied.uident_);
       sh(_applied.actuals_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Empty)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Empty _empty = (com.biosimilarity.GraphL.model.GraphL.Absyn.Empty) foo;
       render("Empty");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.Formals foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsFullForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsFullForm _formalsfullform = (com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsFullForm) foo;
       render("(");
       render("FormalsFullForm");
       render("[");
       sh(_formalsfullform.listlident_1);
       render("]");
       render("[");
       sh(_formalsfullform.listlident_2);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsVertexForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsVertexForm _formalsvertexform = (com.biosimilarity.GraphL.model.GraphL.Absyn.FormalsVertexForm) foo;
       render("(");
       render("FormalsVertexForm");
       render("[");
       sh(_formalsvertexform.listlident_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.Actuals foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsFullForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsFullForm _actualsfullform = (com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsFullForm) foo;
       render("(");
       render("ActualsFullForm");
       render("[");
       sh(_actualsfullform.listvertexactual_);
       render("]");
       render("[");
       sh(_actualsfullform.listedgeactual_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsVertexForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsVertexForm _actualsvertexform = (com.biosimilarity.GraphL.model.GraphL.Absyn.ActualsVertexForm) foo;
       render("(");
       render("ActualsVertexForm");
       render("[");
       sh(_actualsvertexform.listvertexactual_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.SelectionExpr foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Selection)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Selection _selection = (com.biosimilarity.GraphL.model.GraphL.Absyn.Selection) foo;
       render("(");
       render("Selection");
       render("[");
       sh(_selection.listbinding_);
       render("]");
       sh(_selection.graphexpr_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionExpr _comprehensionexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionExpr) foo;
       render("(");
       render("ComprehensionExpr");
       sh(_comprehensionexpr.comprehension_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelectionExpr foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection _vertexselection = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSelection) foo;
       render("(");
       render("VertexSelection");
       render("[");
       sh(_vertexselection.listvertexbinding_);
       render("]");
       sh(_vertexselection.graphexpr_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntensionSelection)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntensionSelection _vertexintensionselection = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntensionSelection) foo;
       render("(");
       render("VertexIntensionSelection");
       sh(_vertexintensionselection.vertexcomprehension_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.Comprehension foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionForm _comprehensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.ComprehensionForm) foo;
       render("(");
       render("ComprehensionForm");
       sh(_comprehensionform.generator_);
       render("[");
       sh(_comprehensionform.listconditionordecl_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehension foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehensionForm _vertexcomprehensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexComprehensionForm) foo;
       render("(");
       render("VertexComprehensionForm");
       sh(_vertexcomprehensionform.vertexgenerator_);
       render("[");
       sh(_vertexcomprehensionform.listconditionordecl_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehension foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehensionForm _edgecomprehensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeComprehensionForm) foo;
       render("(");
       render("EdgeComprehensionForm");
       sh(_edgecomprehensionform.edgegenerator_);
       render("[");
       sh(_edgecomprehensionform.listconditionordecl_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehension foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehensionForm _graphcomprehensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComprehensionForm) foo;
       render("(");
       render("GraphComprehensionForm");
       sh(_graphcomprehensionform.graphgenerator_);
       render("[");
       sh(_graphcomprehensionform.listconditionordecl_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBinding foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundVertex)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundVertex _lrboundvertex = (com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundVertex) foo;
       render("(");
       render("LRBoundVertex");
       sh(_lrboundvertex.vertexdeconstructor_);
       sh(_lrboundvertex.vertex_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeBinding foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundEdge)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundEdge _lrboundedge = (com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundEdge) foo;
       render("(");
       render("LRBoundEdge");
       sh(_lrboundedge.edgedeconstructor_);
       sh(_lrboundedge.edgeexpr_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBinding foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundGraph)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundGraph _lrboundgraph = (com.biosimilarity.GraphL.model.GraphL.Absyn.LRBoundGraph) foo;
       render("(");
       render("LRBoundGraph");
       sh(_lrboundgraph.graphdeconstructor_);
       sh(_lrboundgraph.graphexpr_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.Binding foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.BoundVertex)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.BoundVertex _boundvertex = (com.biosimilarity.GraphL.model.GraphL.Absyn.BoundVertex) foo;
       render("(");
       render("BoundVertex");
       sh(_boundvertex.vertexbinding_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.BoundEdge)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.BoundEdge _boundedge = (com.biosimilarity.GraphL.model.GraphL.Absyn.BoundEdge) foo;
       render("(");
       render("BoundEdge");
       sh(_boundedge.edgebinding_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.BoundGraph)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.BoundGraph _boundgraph = (com.biosimilarity.GraphL.model.GraphL.Absyn.BoundGraph) foo;
       render("(");
       render("BoundGraph");
       sh(_boundgraph.graphbinding_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexGenerator foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenVertex)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenVertex _lrgenvertex = (com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenVertex) foo;
       render("(");
       render("LRGenVertex");
       sh(_lrgenvertex.vertexdeconstructor_);
       sh(_lrgenvertex.vertexcollection_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeGenerator foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenEdge)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenEdge _lrgenedge = (com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenEdge) foo;
       render("(");
       render("LRGenEdge");
       sh(_lrgenedge.edgedeconstructor_);
       sh(_lrgenedge.edgecollection_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphGenerator foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenGraph)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenGraph _lrgengraph = (com.biosimilarity.GraphL.model.GraphL.Absyn.LRGenGraph) foo;
       render("(");
       render("LRGenGraph");
       sh(_lrgengraph.graphdeconstructor_);
       sh(_lrgengraph.graphcollection_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.Generator foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GenVertex)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GenVertex _genvertex = (com.biosimilarity.GraphL.model.GraphL.Absyn.GenVertex) foo;
       render("(");
       render("GenVertex");
       sh(_genvertex.vertexgenerator_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GenEdge)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GenEdge _genedge = (com.biosimilarity.GraphL.model.GraphL.Absyn.GenEdge) foo;
       render("(");
       render("GenEdge");
       sh(_genedge.edgegenerator_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph _gengraph = (com.biosimilarity.GraphL.model.GraphL.Absyn.GenGraph) foo;
       render("(");
       render("GenGraph");
       sh(_gengraph.graphgenerator_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExpr foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSum)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSum _vertexsum = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSum) foo;
       render("(");
       render("VertexSum");
       sh(_vertexsum.vertexexpr_1);
       sh(_vertexsum.vertexexpr_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexMult)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexMult _vertexmult = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexMult) foo;
       render("(");
       render("VertexMult");
       sh(_vertexmult.vertexexpr_1);
       sh(_vertexmult.vertexexpr_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexLiteral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexLiteral _vertexliteral = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexLiteral) foo;
       render("(");
       render("VertexLiteral");
       sh(_vertexliteral.vertex_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexVariable)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexVariable _vertexvariable = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexVariable) foo;
       render("(");
       render("VertexVariable");
       sh(_vertexvariable.lident_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexNegated)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexNegated _vertexnegated = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexNegated) foo;
       render("(");
       render("VertexNegated");
       sh(_vertexnegated.vertexexpr_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexDeconstructor foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExprLabel)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExprLabel _vertexexprlabel = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExprLabel) foo;
       render("(");
       render("VertexExprLabel");
       sh(_vertexexprlabel.vertexexpr_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActual foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActualized)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActualized _vertexactualized = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexActualized) foo;
       render("(");
       render("VertexActualized");
       sh(_vertexactualized.vertexexpr_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExpr foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprNominal)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprNominal _edgeexprnominal = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprNominal) foo;
       render("(");
       render("EdgeExprNominal");
       sh(_edgeexprnominal.edge_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprStruct)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprStruct _edgeexprstruct = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprStruct) foo;
       render("(");
       render("EdgeExprStruct");
       sh(_edgeexprstruct.edge_);
       sh(_edgeexprstruct.vertexexpr_1);
       sh(_edgeexprstruct.vertexexpr_2);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePlus foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeName)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeName _edgename = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeName) foo;
       render("(");
       render("EdgeName");
       sh(_edgename.edge_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeWildcard)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeWildcard _edgewildcard = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeWildcard) foo;
       render("(");
       render("EdgeWildcard");
       sh(_edgewildcard.wild_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabel foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLiteral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLiteral _edgeliteral = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLiteral) foo;
       render("(");
       render("EdgeLiteral");
       sh(_edgeliteral.edge_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeVariable)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeVariable _edgevariable = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeVariable) foo;
       render("(");
       render("EdgeVariable");
       sh(_edgevariable.lident_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprPattern foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprLabel)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprLabel _edgeexprlabel = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExprLabel) foo;
       render("(");
       render("EdgeExprLabel");
       sh(_edgeexprlabel.edgelabel_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternStruct)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternStruct _edgepatternstruct = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternStruct) foo;
       render("(");
       render("EdgePatternStruct");
       sh(_edgepatternstruct.edgedeconstructor_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActual foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActualized)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActualized _edgeactualized = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeActualized) foo;
       render("(");
       render("EdgeActualized");
       sh(_edgeactualized.edgelabel_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeDeconstructor foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternDecon)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternDecon _edgepatterndecon = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgePatternDecon) foo;
       render("(");
       render("EdgePatternDecon");
       sh(_edgepatterndecon.edgelabel_);
       sh(_edgepatterndecon.vertexdeconstructor_1);
       sh(_edgepatterndecon.vertexdeconstructor_2);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphDeconstructor foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedPattern)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedPattern _graphisolatedpattern = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedPattern) foo;
       render("(");
       render("GraphIsolatedPattern");
       sh(_graphisolatedpattern.graphdeconstructor_1);
       sh(_graphisolatedpattern.graphdeconstructor_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedPattern)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedPattern _graphpointedpattern = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedPattern) foo;
       render("(");
       render("GraphPointedPattern");
       sh(_graphpointedpattern.vertexdeconstructor_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedPattern)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedPattern _graphconnectedpattern = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedPattern) foo;
       render("(");
       render("GraphConnectedPattern");
       sh(_graphconnectedpattern.edgelabel_);
       sh(_graphconnectedpattern.graphdeconstructor_1);
       sh(_graphconnectedpattern.graphdeconstructor_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphLiteral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphLiteral _graphliteral = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphLiteral) foo;
       render("(");
       render("GraphLiteral");
       sh(_graphliteral.graphexpr_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionOrDecl foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionIn)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionIn _conditionin = (com.biosimilarity.GraphL.model.GraphL.Absyn.ConditionIn) foo;
       render("(");
       render("ConditionIn");
       sh(_conditionin.condition_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.DeclIn)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.DeclIn _declin = (com.biosimilarity.GraphL.model.GraphL.Absyn.DeclIn) foo;
       render("(");
       render("DeclIn");
       sh(_declin.decl_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.Decl foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl _generatordecl = (com.biosimilarity.GraphL.model.GraphL.Absyn.GeneratorDecl) foo;
       render("(");
       render("GeneratorDecl");
       sh(_generatordecl.generator_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.LocalDecl)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.LocalDecl _localdecl = (com.biosimilarity.GraphL.model.GraphL.Absyn.LocalDecl) foo;
       render("(");
       render("LocalDecl");
       sh(_localdecl.binding_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexCollection foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntension)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntension _vertexintension = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntension) foo;
       render("(");
       render("VertexIntension");
       sh(_vertexintension.vertexcomprehension_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtenionExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtenionExpr _vertexextenionexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtenionExpr) foo;
       render("(");
       render("VertexExtenionExpr");
       sh(_vertexextenionexpr.vertexextension_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeCollection foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntension)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntension _edgeintension = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntension) foo;
       render("(");
       render("EdgeIntension");
       sh(_edgeintension.edgecomprehension_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtenionExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtenionExpr _edgeextenionexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtenionExpr) foo;
       render("(");
       render("EdgeExtenionExpr");
       sh(_edgeextenionexpr.edgeextension_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphCollection foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIntension)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIntension _graphintension = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIntension) foo;
       render("(");
       render("GraphIntension");
       sh(_graphintension.graphcomprehension_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtenionExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtenionExpr _graphextenionexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtenionExpr) foo;
       render("(");
       render("GraphExtenionExpr");
       sh(_graphextenionexpr.graphextension_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtension foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionForm _vertexextensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionForm) foo;
       render("(");
       render("VertexExtensionForm");
       render("[");
       sh(_vertexextensionform.listvertex_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltinExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltinExpr _vertexextensionbuiltinexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltinExpr) foo;
       render("(");
       render("VertexExtensionBuiltinExpr");
       sh(_vertexextensionbuiltinexpr.vertexextensionbuiltin_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtension foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionForm _edgeextensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionForm) foo;
       render("(");
       render("EdgeExtensionForm");
       render("[");
       sh(_edgeextensionform.listedge_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltinExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltinExpr _edgeextensionbuiltinexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltinExpr) foo;
       render("(");
       render("EdgeExtensionBuiltinExpr");
       sh(_edgeextensionbuiltinexpr.edgeextensionbuiltin_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtension foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionForm)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionForm _graphextensionform = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionForm) foo;
       render("(");
       render("GraphExtensionForm");
       render("[");
       sh(_graphextensionform.listgraphexpr_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltinExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltinExpr _graphextensionbuiltinexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltinExpr) foo;
       render("(");
       render("GraphExtensionBuiltinExpr");
       sh(_graphextensionbuiltinexpr.graphextensionbuiltin_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexExtensionBuiltin foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSet)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSet _vertexset = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexSet) foo;
       render("(");
       render("VertexSet");
       sh(_vertexset.graphexpr_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.SourceSet)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.SourceSet _sourceset = (com.biosimilarity.GraphL.model.GraphL.Absyn.SourceSet) foo;
       render("(");
       render("SourceSet");
       sh(_sourceset.graphexpr_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.SinkSet)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.SinkSet _sinkset = (com.biosimilarity.GraphL.model.GraphL.Absyn.SinkSet) foo;
       render("(");
       render("SinkSet");
       sh(_sinkset.graphexpr_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeExtensionBuiltin foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeSet)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeSet _edgeset = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeSet) foo;
       render("(");
       render("EdgeSet");
       sh(_edgeset.graphexpr_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphExtensionBuiltin foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComponents)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComponents _graphcomponents = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphComponents) foo;
       render("(");
       render("GraphComponents");
       sh(_graphcomponents.graphexpr_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.Condition foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.ConjunctionCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.ConjunctionCondition _conjunctioncondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.ConjunctionCondition) foo;
       render("(");
       render("ConjunctionCondition");
       sh(_conjunctioncondition.condition_1);
       sh(_conjunctioncondition.condition_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.DisjunctionCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.DisjunctionCondition _disjunctioncondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.DisjunctionCondition) foo;
       render("(");
       render("DisjunctionCondition");
       sh(_disjunctioncondition.condition_1);
       sh(_disjunctioncondition.condition_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.StructuralCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.StructuralCondition _structuralcondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.StructuralCondition) foo;
       render("(");
       render("StructuralCondition");
       sh(_structuralcondition.structurecondition_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.BaseCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.BaseCondition _basecondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.BaseCondition) foo;
       render("(");
       render("BaseCondition");
       sh(_basecondition.groundcondition_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.StructureCondition foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedCond)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedCond _graphisolatedcond = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphIsolatedCond) foo;
       render("(");
       render("GraphIsolatedCond");
       sh(_graphisolatedcond.structurecondition_1);
       sh(_graphisolatedcond.structurecondition_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedCond)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedCond _graphpointedcond = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphPointedCond) foo;
       render("(");
       render("GraphPointedCond");
       sh(_graphpointedcond.vertexstructurecondition_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedCond)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedCond _graphconnectedcond = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphConnectedCond) foo;
       render("(");
       render("GraphConnectedCond");
       sh(_graphconnectedcond.edgelabelcondition_);
       sh(_graphconnectedcond.structurecondition_1);
       sh(_graphconnectedcond.structurecondition_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphStructureLiteral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphStructureLiteral _graphstructureliteral = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphStructureLiteral) foo;
       render("(");
       render("GraphStructureLiteral");
       sh(_graphstructureliteral.graphexpr_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureCondition foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureSum)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureSum _vertexstructuresum = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureSum) foo;
       render("(");
       render("VertexStructureSum");
       sh(_vertexstructuresum.vertexstructurecondition_1);
       sh(_vertexstructuresum.vertexstructurecondition_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult _vertexstructuremult = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureMult) foo;
       render("(");
       render("VertexStructureMult");
       sh(_vertexstructuremult.vertexstructurecondition_1);
       sh(_vertexstructuremult.vertexstructurecondition_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureLiteral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureLiteral _vertexstructureliteral = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureLiteral) foo;
       render("(");
       render("VertexStructureLiteral");
       sh(_vertexstructureliteral.vertex_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureVariable)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureVariable _vertexstructurevariable = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureVariable) foo;
       render("(");
       render("VertexStructureVariable");
       sh(_vertexstructurevariable.atomicformula_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureNegated)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureNegated _vertexstructurenegated = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexStructureNegated) foo;
       render("(");
       render("VertexStructureNegated");
       sh(_vertexstructurenegated.vertexstructurecondition_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelCondition foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelLiteralCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelLiteralCondition _edgelabelliteralcondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelLiteralCondition) foo;
       render("(");
       render("EdgeLabelLiteralCondition");
       sh(_edgelabelliteralcondition.edge_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelAtomicCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelAtomicCondition _edgelabelatomiccondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeLabelAtomicCondition) foo;
       render("(");
       render("EdgeLabelAtomicCondition");
       sh(_edgelabelatomiccondition.atomicformula_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.GroundCondition foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltinExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltinExpr _vertexbuiltinexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltinExpr) foo;
       render("(");
       render("VertexBuiltinExpr");
       sh(_vertexbuiltinexpr.vertexbuiltin_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltinExpr)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltinExpr _graphbuiltinexpr = (com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltinExpr) foo;
       render("(");
       render("GraphBuiltinExpr");
       sh(_graphbuiltinexpr.graphbuiltin_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicCondition _atomiccondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicCondition) foo;
       render("(");
       render("AtomicCondition");
       sh(_atomiccondition.atomicformula_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.NegatedCondition)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.NegatedCondition _negatedcondition = (com.biosimilarity.GraphL.model.GraphL.Absyn.NegatedCondition) foo;
       render("(");
       render("NegatedCondition");
       sh(_negatedcondition.groundcondition_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.VertexBuiltin foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.SinkBuiltin)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.SinkBuiltin _sinkbuiltin = (com.biosimilarity.GraphL.model.GraphL.Absyn.SinkBuiltin) foo;
       render("(");
       render("SinkBuiltin");
       sh(_sinkbuiltin.vertexexpr_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.SourceBuiltin)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.SourceBuiltin _sourcebuiltin = (com.biosimilarity.GraphL.model.GraphL.Absyn.SourceBuiltin) foo;
       render("(");
       render("SourceBuiltin");
       sh(_sourcebuiltin.vertexexpr_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.GraphBuiltin foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EmptyGraphBuiltin)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EmptyGraphBuiltin _emptygraphbuiltin = (com.biosimilarity.GraphL.model.GraphL.Absyn.EmptyGraphBuiltin) foo;
       render("(");
       render("EmptyGraphBuiltin");
       sh(_emptygraphbuiltin.graphexpr_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.AtomicFormula foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Verity)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Verity _verity = (com.biosimilarity.GraphL.model.GraphL.Absyn.Verity) foo;
       render("Verity");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Absurdity)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Absurdity _absurdity = (com.biosimilarity.GraphL.model.GraphL.Absyn.Absurdity) foo;
       render("Absurdity");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.Nullity)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.Nullity _nullity = (com.biosimilarity.GraphL.model.GraphL.Absyn.Nullity) foo;
       render("Nullity");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.ListConditionOrDecl foo)
  {
     for (java.util.Iterator<ConditionOrDecl> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.ListCondition foo)
  {
     for (java.util.Iterator<Condition> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.ListVertex foo)
  {
     for (java.util.Iterator<Vertex> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.ListEdge foo)
  {
     for (java.util.Iterator<Edge> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.ListVertexActual foo)
  {
     for (java.util.Iterator<VertexActual> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.ListEdgeActual foo)
  {
     for (java.util.Iterator<EdgeActual> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.ListGraphExpr foo)
  {
     for (java.util.Iterator<GraphExpr> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.ListLIdent foo)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.ListBinding foo)
  {
     for (java.util.Iterator<Binding> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.ListVertexBinding foo)
  {
     for (java.util.Iterator<VertexBinding> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.Edge foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeQuotation)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeQuotation _edgequotation = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeQuotation) foo;
       render("(");
       render("EdgeQuotation");
       sh(_edgequotation.graphexpr_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntegral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntegral _edgeintegral = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeIntegral) foo;
       render("(");
       render("EdgeIntegral");
       sh(_edgeintegral.integer_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeString)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeString _edgestring = (com.biosimilarity.GraphL.model.GraphL.Absyn.EdgeString) foo;
       render("(");
       render("EdgeString");
       sh(_edgestring.string_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.GraphL.model.GraphL.Absyn.Vertex foo)
  {
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexQuotation)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexQuotation _vertexquotation = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexQuotation) foo;
       render("(");
       render("VertexQuotation");
       sh(_vertexquotation.graphexpr_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntegral)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntegral _vertexintegral = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexIntegral) foo;
       render("(");
       render("VertexIntegral");
       sh(_vertexintegral.integer_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.GraphL.model.GraphL.Absyn.VertexString)
    {
       com.biosimilarity.GraphL.model.GraphL.Absyn.VertexString _vertexstring = (com.biosimilarity.GraphL.model.GraphL.Absyn.VertexString) foo;
       render("(");
       render("VertexString");
       sh(_vertexstring.string_);
       render(")");
    }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(d); buf_.append(" "); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(d.toString()); }
  private static void sh(Character c) { render(c.toString()); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(" ");
      n--;
    }
  }
  private static void backup()
  {
     if (buf_.charAt(buf_.length() - 1) == ' ') {
      buf_.setLength(buf_.length() - 1);
    }
  }
  private static void trim()
  {
     while (buf_.length() > 0 && buf_.charAt(0) == ' ')
        buf_.deleteCharAt(0); 
    while (buf_.length() > 0 && buf_.charAt(buf_.length()-1) == ' ')
        buf_.deleteCharAt(buf_.length()-1);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

