package evaluator.tokens.operations;

import evaluator.tokens.Operation;
import evaluator.CalculatorSolver;
import evaluator.Token;
import evaluator.Type;
import evaluator.operators.BinaryOperator;
import evaluator.Operator;

public class BinaryOperation extends Operation {

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
        return calculatorSolver.getResult(operator, new Type[]{leftChild.evaluate(), rightChild.evaluate()});
    }

    @Override
    public String toString() {
        
        int leftPrecedence;
        int rightPrecedence;
        int myPrecedence = operator.getPrecedence();
        String tree = "";

        if (leftChild instanceof BinaryOperation) {
            leftPrecedence = ((BinaryOperation) leftChild).getOperator().getPrecedence();
            tree += (myPrecedence < leftPrecedence) ? "(" + leftChild.toString() + ")" : leftChild.toString();


        }
        
        tree += operator.getSymbol();

        if (rightChild instanceof BinaryOperation) {
            rightPrecedence = ((BinaryOperation) rightChild).getOperator().getPrecedence();
            tree += (myPrecedence < rightPrecedence) ? "(" + rightChild.toString() + ")" : rightChild.toString();
        }
        return tree;
    }
}
