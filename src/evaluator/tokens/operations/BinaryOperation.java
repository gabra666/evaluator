package evaluator.tokens.operations;

import evaluator.CalculatorSolver;
import evaluator.Operator;
import evaluator.Token;
import evaluator.Type;
import evaluator.operators.BinaryOperator;
import evaluator.tokens.Operation;

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
        return branchToString(leftChild) + operator.getSymbol() + branchToString(rightChild);
    }

    private boolean greaterPrecedence(BinaryOperation bOp1, BinaryOperation bOp2) {
        return (bOp1.getOperator().getPrecedence()
                > bOp2.getOperator().getPrecedence()) ? true : false;
    }

    private String branchToString(Token token) {
        return (token instanceof BinaryOperation && greaterPrecedence(this, (BinaryOperation) token))
                ? "(" + token.toString() + ")" : token.toString();
    }
}
