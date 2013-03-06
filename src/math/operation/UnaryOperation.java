package math.operation;

import math.data.Token;
import math.data.Type;
import math.operator.Operator;

public class UnaryOperation extends Operation{

    private final Token child;
    private final Operator operator;

    public UnaryOperation(Token child, Operator operator) {
        this.child = child;
        this.operator = operator;
    }

    public Operator getOperator() {
        return operator;
    }
    
    public Token getChild() {
        return child;
    }

    @Override
    public Type evaluate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
