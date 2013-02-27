package math.operator;

import math.data.Node;
import math.type.Type;

public class BinaryOperator extends Operator {

    
    private final Node rigthChild;
    private final Node leftChild;

    public BinaryOperator(Node rigthChild, Node leftChild) {
        this.rigthChild = rigthChild;
        this.leftChild = leftChild;
    }

    public Node getRigthChild() {
        return rigthChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    @Override
    public Type evaluate() {
        
        return null;
    }
}
