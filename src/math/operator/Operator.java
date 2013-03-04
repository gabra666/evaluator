package math.operator;

public  class Operator  {
    
    private final String symbol;
    private static final Operator ADD = new Operator("+");
    private static final Operator SUBSTRACT = new Operator("-");

    private Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
    
    
    
}
