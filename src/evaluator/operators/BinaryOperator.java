package evaluator.operators;

import evaluator.Operator;

public class BinaryOperator extends Operator {

    public static final BinaryOperator ADD = new BinaryOperator("+", "add", 1);
    public static final BinaryOperator SUBSTRACT = new BinaryOperator("-", "substract", 1);
    public static final BinaryOperator MULTIPLY = new BinaryOperator("*", "multiply", 2);
    public static final BinaryOperator DIVISION = new BinaryOperator("/", "division", 2);

    private BinaryOperator(String symbol, String name, int precedence) {
        super(symbol, name, precedence);
    }
}
