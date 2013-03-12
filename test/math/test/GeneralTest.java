package math.test;

import junit.framework.Assert;
import math.calculator.CalculatorSolver;
import math.data.Token;
import math.operation.BinaryOperation;
import math.operator.BinaryOperator;
import math.type.Double;
import math.type.Integer;
import org.junit.Test;

public class GeneralTest {

    public GeneralTest() {
    }

    @Test
    public void doubleDoubleAddTest() {
        Token addToken = new BinaryOperation(new Double(1.0), new Double(2.0), BinaryOperator.ADD);
        Assert.assertEquals(3.0, addToken.evaluate().getValue());
    }

    @Test
    public void doubleIntegerAddTest() {
        Token addToken = new BinaryOperation(new Double(1.0), new Integer(2), BinaryOperator.ADD);
        Assert.assertEquals(3.0, addToken.evaluate().getValue());
    }

    @Test
    public void integerDoubleAddTest() {
        Token addToken = new BinaryOperation(new Integer(1), new Double(2.0), BinaryOperator.ADD);
        Assert.assertEquals(3.0, addToken.evaluate().getValue());
    }

    @Test
    public void integerIntegerAddTest() {
        Token addToken = new BinaryOperation(new Integer(1), new Integer(2), BinaryOperator.ADD);
        Assert.assertEquals(3, addToken.evaluate().getValue());
    }
    
    @Test
    public void doubleDoubleSubstractTest() {
        Token addToken = new BinaryOperation(new Double(1.0), new Double(2.0), BinaryOperator.SUBSTRACT);
        Assert.assertEquals(-1.0, addToken.evaluate().getValue());
    }

    @Test
    public void doubleIntegerSubstractTest() {
        Token addToken = new BinaryOperation(new Double(1.0), new Integer(2), BinaryOperator.SUBSTRACT);
        Assert.assertEquals(-1.0, addToken.evaluate().getValue());
    }

    @Test
    public void integerDoubleSubstractTest() {
        Token addToken = new BinaryOperation(new Integer(-1), new Double(2.0), BinaryOperator.SUBSTRACT);
        Assert.assertEquals(-3.0, addToken.evaluate().getValue());
    }

    @Test
    public void integerIntegerSubstractTest() {
        Token addToken = new BinaryOperation(new Integer(-1), new Integer(-2), BinaryOperator.SUBSTRACT);
        Assert.assertEquals(1, addToken.evaluate().getValue());
    }
    
    
    
    @Test
    public void calculatorSolverTest(){
        CalculatorSolver cs = new CalculatorSolver();
        Token addToken = new BinaryOperation(new Integer(-1), new Integer(-2), BinaryOperator.SUBSTRACT);
        Assert.assertEquals(1, addToken.evaluate().getValue());
    }
}
