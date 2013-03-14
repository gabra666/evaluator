package evaluator.tokens.operations;

import evaluator.tokens.Operation;
import evaluator.CalculatorSolver;
import evaluator.Token;
import evaluator.Type;
import evaluator.Operator;

public class UnaryOperation extends Operation{

    private final Token child;
    private final Operator operator;
    private CalculatorSolver calculatorSolver= new CalculatorSolver();

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
        return calculatorSolver.getResult(operator, new Type[]{child.evaluate()});
    }

    @Override
    public String toString() {
        return child.toString()+operator.getSymbol();
    }
    
    
}
