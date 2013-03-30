package evaluator.operators;

import evaluator.Operator;
import evaluator.annotations.Operators;

public class UnaryOperator extends Operator{
    
    @Operators
    public static final UnaryOperator SIN = new UnaryOperator("SIN", "sin", 1);
    @Operators
    public static final UnaryOperator COS = new UnaryOperator("COS", "cos", 1);
    @Operators
    public static final UnaryOperator TAN = new UnaryOperator("TAN", "tan", 1);
    

    private UnaryOperator(String symbol, String name, int precedence) {
        super(symbol, name, precedence);
    }
    
}
