package math.operator;

public class BinaryOperator extends Operator {

    private static final Operator ADD = new Operator("+", "add");
    private static final Operator SUBSTRACT = new Operator("-", "substract");

    private BinaryOperator(String symbol, String name) {
        super(symbol, name);
    }
}
