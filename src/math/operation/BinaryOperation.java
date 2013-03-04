package math.operation;

import math.data.Token;
import math.operator.Operator;
import math.type.Type;

public class BinaryOperation extends Operation{

    private final Token LeftChild;
    private final Token RightChild;
    private final Operator operator;

    public BinaryOperation(Token LeftChild, Token RightChild, Operator operator) {
        this.LeftChild = LeftChild;
        this.RightChild = RightChild;
        this.operator = operator;
    }

    public Operator getOperator() {
        return operator;
    }

    
    public Token getLeftChild() {
        return LeftChild;
    }

    public Token getRightChild() {
        return RightChild;
    }

    @Override
    public Type evaluate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    

}
