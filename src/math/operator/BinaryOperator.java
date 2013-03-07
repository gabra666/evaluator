package math.operator;

public class BinaryOperator extends Operator {

    public static final BinaryOperator ADD = new BinaryOperator("+", "add");
    public static final BinaryOperator SUBSTRACT = new BinaryOperator("-", "substract");
    public static final BinaryOperator MULTIPLY = new BinaryOperator("*", "multiply");
    public static final BinaryOperator DIVISION = new BinaryOperator("-", "division");

    private BinaryOperator(String symbol, String name) {
        super(symbol, name);
    }
}
