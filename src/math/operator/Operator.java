package math.operator;

public class Operator {

    private final String symbol;
    private final String name;
    private int precedence;

    public Operator(String symbol, String name, int precedence) {
        this.symbol = symbol;
        this.name = name;
        this.precedence = precedence;
    }

    public int getPrecedence() {
        return precedence;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }
    
    
    
    
}
