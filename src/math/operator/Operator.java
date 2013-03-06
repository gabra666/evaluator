package math.operator;

public class Operator {

    private final String symbol;
    private final String name;

    public Operator(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}
