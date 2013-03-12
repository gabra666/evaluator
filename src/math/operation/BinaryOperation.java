package math.operation;

import math.calculator.CalculatorSolver;
import math.data.Token;
import math.data.Type;
import math.operator.BinaryOperator;
import math.operator.Operator;

public class BinaryOperation extends Operation{

    private final Token leftChild;
    private final Token rightChild;
    private final BinaryOperator operator;
    private CalculatorSolver calculatorSolver = new CalculatorSolver();

    public BinaryOperation(Token LeftChild, Token RightChild, BinaryOperator operator) {
        this.leftChild = LeftChild;
        this.rightChild = RightChild;
        this.operator = operator;
    }

    public Operator getOperator() {
        return operator;
    }

    
    public Token getLeftChild() {
        return leftChild;
    }

    public Token getRightChild() {
        return rightChild;
    }

    @Override
    public Type evaluate() {
        Type leftEvaluate = leftChild.evaluate(); 
        Type rightEvaluate = rightChild.evaluate(); 
        return calculatorSolver.getResult(operator, new Object[]{leftEvaluate,rightEvaluate});
    }
    
    

}
