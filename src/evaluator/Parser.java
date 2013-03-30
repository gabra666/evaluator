package evaluator;

import evaluator.annotations.Operators;
import evaluator.operators.BinaryOperator;
import evaluator.tokens.Constant;
import evaluator.tokens.operations.BinaryOperation;
import evaluator.types.Double;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class Parser {

    private StringTokenizer treeTokenizer;
    private Stack<Token> treeStack;
    private Stack<Token> operatorStack;
    private HashMap<String, Operator> operatorsMap = new HashMap<>();

    public Parser() {
        treeStack = new Stack();
        operatorStack = new Stack();
        Reflections ref = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forJavaClassPath()));
        addOperatorsToHash(ref.getSubTypesOf(Operator.class));
    }

    public Token getTree(String operationString) {
        treeTokenizer = new StringTokenizer(operationString);
        while (treeTokenizer.hasMoreTokens()) {
            getToken(treeTokenizer.nextToken());
        }
        return constructTree();
    }

    private void getToken(String tokenString) {
        Operator operator = operatorsMap.get(tokenString);
        if (operator != null) {
            pushOperator(new BinaryOperation(null, null, (BinaryOperator) operator));
        } else {
            treeStack.push(new Constant(new Double(tokenString)));
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

    private void addOperatorsToHash(Set<Class<? extends Operator>> operators) {
        for (Class<?> theOperator : operators) {
            addOperatorsToHash(theOperator);
        }
    }

    private void addOperatorsToHash(Class<?> theOperator) {
        for (Field field : theOperator.getDeclaredFields()) {
            try {
                if (!field.isAnnotationPresent(Operators.class)) continue;
                Operator operator = (Operator) field.get(null);
                operatorsMap.put(operator.getSymbol(), operator);
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
