// import ANTLR runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

// import Java Map Libs
import java.util.HashMap;
import java.util.Map;

// import Java Stack Libs
import java.util.Stack;

// import Java console IO
import java.io.Console;
import java.io.IOException;


class EvalListener extends ExprBaseListener {
   // hash-map for variables' integer value for assignment
   Map<String, Integer> vars = new HashMap<String, Integer>(); 

   // stack for expression tree evaluation
   Stack<Integer> evalStack = new Stack<Integer>();
   // stack for operators (+-*/) in shunting-yard algorithm 
   Stack<String> opStack = new Stack<String>();

   @Override
   public void exitProg(ExprParser.ProgContext ctx) {
      System.out.println("exitProg: "); 

   }
   
   @Override
   public void exitExpr(ExprParser.ExprContext ctx) {
      System.out.println("exitExpr: "); 

   }

   @Override
   public void enterAssn(ExprParser.AssnContext ctx) {
      System.out.println("enterAssn: "); 
   }
   @Override
   public void exitAssn(ExprParser.AssnContext ctx) {
      System.out.println("exitAssn: "); 
   }

   // Add more overrride methods if needed
 
   @Override 
   public void visitTerminal(TerminalNode node) {
      String s = node.getText();

      switch(s) {
      case "+": 
          System.out.println("Terminal PLUS");
          opStack.push("+");
          break;
      case "-": 
          System.out.println("Terminal MINUS");
          opStack.push("-");
          break;
      case "*": 
          System.out.println("Terminal MULTIPLY");
          opStack.push("*");
          break;
      case "/": 
          System.out.println("Terminal DIVIDE");
          opStack.push("/");
          break;
      case "(": 
          System.out.println("Terminal LEFT_PAR");
          break;
      case ")": 
          System.out.println("Terminal RIGHT_PAR");
          break;
      default:
          if (s.matches("[0-9]+")) { // INT
             System.out.println("Terminal-INT " + s);
             Integer i = new Integer(s);
             evalStack.push(i);
          } else { // ID
             System.out.println("Terminal-ID " + s);
             // lookup vars-Map and push to evalStack
             // Integer v = ....
             // evalStack.push(v);
          } 
      }
   }
}

public class ExprEvalApp {
   public static void main(String[] args) throws IOException {
      System.out.println("** Expression Eval w/ antlr-listener **");

      Console c = System.console();
      if (c == null) {
         System.err.println("No Console");
         System.exit(1);
      }
      String input = c.readLine("Input: ");
      //input += '\n';

      // Get lexer
      ExprLexer lexer = new ExprLexer(new ANTLRInputStream(input));
      // Get a list of matched tokens
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      // Pass tokens to parser
      ExprParser parser = new ExprParser(tokens);
      // Walk parse-tree and attach our listener
      ParseTreeWalker walker = new ParseTreeWalker();
      EvalListener listener = new EvalListener();
      walker.walk(listener, parser.prog());	// walk from the root of parse tree
   }
} 
