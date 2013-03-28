package evaluator;

import evaluator.operators.BinaryOperator;
import evaluator.tokens.Constant;
import evaluator.tokens.operations.BinaryOperation;
import evaluator.types.Double;
import java.util.Stack;
import java.util.StringTokenizer;

public class Parser {

    private StringTokenizer treeTokenizer;
    private Stack<Token> treeStack;
    private Stack<Token> operatorStack;

    public Parser() {
        treeStack = new Stack();
        operatorStack = new Stack();
    }

    public Token getTree(String operationString) {
        treeTokenizer = new StringTokenizer(operationString);
        while (treeTokenizer.hasMoreTokens()) {
            getToken(treeTokenizer.nextToken());
        }
        return constructTree();
    }

    private void getToken(String tokenString) {
        switch (tokenString) {
            case "+":
                pushOperator(new BinaryOperation(null, null, BinaryOperator.ADD));
                break;
            case "-":
                pushOperator(new BinaryOperation(null, null, BinaryOperator.SUBSTRACT));
                break;
            case "*":
                pushOperator(new BinaryOperation(null, null, BinaryOperator.MULTIPLY));
                break;
            case "/":
                pushOperator(new BinaryOperation(null, null, BinaryOperator.DIVISION));
                break;
            default:
                treeStack.push(new Constant(new Double(tokenString)));
                break;
        }
    }

    private void pushOperator(Token token) {
        if (!operatorStack.empty()) {
            addOperator(token);
        } else {
            operatorStack.push(token);
        }
    }

    private Token constructTree() {
        emptyOperatorStack();
        Token token = null;
        while (!treeStack.empty()) {
            token = recursiveConstruction(treeStack.pop());
        }
        return token;
    }

    private Token recursiveConstruction(Token token) {
        if (token instanceof BinaryOperation) {
            ((BinaryOperation) token).setRightChild(recursiveConstruction(treeStack.pop()));
            ((BinaryOperation) token).setLeftChild(recursiveConstruction(treeStack.pop()));
        }
        return token;
    }

    private void emptyOperatorStack() {
        while (!operatorStack.empty()) {
            treeStack.push(operatorStack.pop());
        }
    }

    private void moveOperator(Token token) {
        treeStack.push(operatorStack.pop());
        operatorStack.push(token);
    }

    private boolean checkPrecedence(Token tokenInStack, Token token) {
        Operator operatorInStack = ((BinaryOperation) tokenInStack).getOperator();
        Operator newOperator = ((BinaryOperation) token).getOperator();
        return newOperator.getPrecedence() > operatorInStack.getPrecedence();
    }

    private void addOperator(Token token) {
        if (checkPrecedence(operatorStack.peek(), token)) {
            operatorStack.push(token);
        } else {
            moveOperator(token);
        }
    }
}
