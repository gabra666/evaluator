package math.operation;

import math.calculator.CalculatorSolver;
import math.data.Token;
import math.data.Type;
import math.operator.Operator;

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
        return calculatorSolver.getResult(operator, new Object[]{child.evaluate()});
    }

    @Override
    public String ToString() {
        return child.ToString()+operator.getSymbol();
    }
    
    
}
