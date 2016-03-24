// import ANTLR runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

// import Java Map Libs
import java.io.FileInputStream;
import java.util.*;

// import Java Stack Libs

// import Java console IO
import java.io.Console;
import java.io.IOException;


class EvalListener extends ExprBaseListener {
    // hash-map for variables' integer value for assignment
    Map<String, Integer> vars = new HashMap<String, Integer>();
    // Hash-map for operators' integer value to represent priority.
    Map<String, Integer> opPriority = new HashMap<String, Integer>();
    // stack for expression tree evaluation
    Stack<Object> evalStack = new Stack<Object>();
    // stack for operators (+-*/()) in shunting-yard algorithm
    Stack<String> opStack = new Stack<String>();
    // value for checking in terminal node if this is from assn or expr.
    boolean isAssnPropBlocked = false;

    //Initialize Class.
    public EvalListener() {
        opPriority.put("+", 0);
        opPriority.put("-", 0);
        opPriority.put("*", 1);
        opPriority.put("/", 1);
    }

    @Override
    public void enterProg(ExprParser.ProgContext ctx) {
        //System.out.println("enterProg: ");
    }

    @Override
    public void exitProg(ExprParser.ProgContext ctx) {
       // System.out.println("exitProg: ");

    }

    @Override
    public void enterExpr(ExprParser.ExprContext ctx) {
       // System.out.println("enterExpr: ");


    }

    @Override
    public void exitExpr(ExprParser.ExprContext ctx) {
        //if it is expr which is direct child of prog and is needed to be calculated.
        if(ctx.getParent().getParent() == null){
            while(!opStack.isEmpty()){
                evalStack.push(opStack.pop());
            }
            //System.out.println("output stack is " + evalStack.toString());
            System.out.println(calcPostFix());
        }
       // System.out.println("exitExpr: ");
    }


    @Override
    public void enterAssn(ExprParser.AssnContext ctx) {
       // System.out.println("enterAssn: ");
       // System.out.println(ctx.ID().getText());
       // System.out.println(ctx.INT().getText());
        vars.put(ctx.ID().getText(), Integer.parseInt(ctx.INT().getText()));
        isAssnPropBlocked = true;
    }

    @Override
    public void exitAssn(ExprParser.AssnContext ctx) {
      //  System.out.println("exitAssn: ");
        isAssnPropBlocked = false;
    }

    // Add more override methods if needed

    @Override
    public void visitTerminal(TerminalNode node) {
        String s = node.getText();
        if(s.matches("[\\+|\\-|*|/|(|)]"))  pushOpToStack(s);
        else if (s.matches("[0-9]+")) { // INT
            //System.out.println("Terminal-INT " + s);
            //Use Flag to check if this signal from assn or expr.
            if(!isAssnPropBlocked){
                evalStack.push(Integer.parseInt(s));
            }
        } else if(s.matches("[a-zA-Z]")){ // ID
            //Now it will print even NEWLINE WS,
            //System.out.println("Terminal-ID " + s);
            if(!isAssnPropBlocked){
                if(vars.containsKey(s))
                    evalStack.push(vars.get(s));
                else {
                    System.err.println("No assignment");
                    System.exit(1);
                }
            }
        }
    }
    /*
     * Compare operator based on Shunting-Yard Algorithm.
     */
    public void pushOpToStack(String op) {
        //System.out.println("Terminal "+op);
        if (opStack.empty() || op.equals("(") || opStack.lastElement().equals("(")) {
            opStack.push(op);
        } else if (op.equals(")")){
            if(opStack.empty()) {
                System.err.println("No (");
                return;
            }
            while(!opStack.lastElement().equals("(")){
                evalStack.push(opStack.pop());
            }
            opStack.pop();
        }else if (opPriority.get(op) <= opPriority.get(opStack.lastElement())){
            evalStack.push(opStack.pop());
            pushOpToStack(op);
         //if input op' priority is lower than lastElement in stack.
        } else
            opStack.push(op);
    }

    public int calcPostFix(){
        if(evalStack.size() == 1) return ((Number)evalStack.remove(0)).intValue();
        for(int i=0; i < evalStack.size(); i++){
            if( evalStack.get(i) instanceof String){
                //Change of removing sequence will change the results.
                String s = (String) evalStack.remove(i);
                int operand2 = (Integer) evalStack.remove(i - 1);
                int operand1 = (Integer) evalStack.remove(i - 2);

                switch (s) {
                    case "+":
                        evalStack.add(i-2, operand1 + operand2);
                        break;
                    case "-":
                        evalStack.add(i-2, operand1 - operand2);
                        break;
                    case "*":
                        evalStack.add(i-2, operand1 * operand2);
                        break;
                    //문제는 실수값이 나올 수 있는데 / 연산자 때문에 몫만 구해짐.
                    case "/":
                        if(operand1%operand2 == 0)
                            evalStack.add(i-2, operand1 / operand2);
                        break;
                }
                break;
            }
        }
    return calcPostFix();
    }
}
public class ExprEvalApp {
   public static void main(String[] args) throws IOException {
       //file stream.
       FileInputStream inputStream = null;
       Console c = System.console();
      if (c == null) {
         System.err.println("No Console");
         System.exit(1);
      }
       //! i comment this area because i noticed that it should get input from file.
       //Use Reader class as input. In the original skeleton code it uses c.readLine I need multi-line input. Instead of implementing it by
       //other methods It is possible just pass Reader class to ANTLRInputStream because it is already implemented in it.
       //Reader input = c.reader();

       if(args.length == 1){
        inputStream  = new FileInputStream(args[0]);
       }else {
           System.out.println("** Expression Eval w/ antlr-listener **");
           String filePath = c.readLine("File Path Input: ");
           inputStream = new FileInputStream(filePath);
       }


      // Get lexer
      ExprLexer lexer = new ExprLexer(new ANTLRInputStream(inputStream));
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
