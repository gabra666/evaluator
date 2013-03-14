package math.test;

import junit.framework.Assert;
import evaluator.CalculatorSolver;
import evaluator.Token;
import evaluator.tokens.operations.BinaryOperation;
import evaluator.operators.BinaryOperator;
import evaluator.tokens.Constant;
import evaluator.types.Double;
import evaluator.types.Integer;
import org.junit.Test;

public class AddTest {

    public AddTest() {
    }

    @Test
    public void doubleDoubleAddTest() {
        Token addToken = new BinaryOperation(new Constant(new Double(1.0)), new Constant(new Double(2.0)), BinaryOperator.ADD);
        Assert.assertEquals(3.0, addToken.evaluate().getValue());
    }

    @Test
    public void doubleIntegerAddTest() {
        Token addToken = new BinaryOperation(new Constant(new Double(1.0)),new Constant(new Integer(2)), BinaryOperator.ADD);
        Assert.assertEquals(3.0, addToken.evaluate().getValue());
    }

    @Test
    public void integerDoubleAddTest() {
        Token addToken = new BinaryOperation(new Constant(new Integer(1)),new Constant(new Double(2.0)), BinaryOperator.ADD);
        Assert.assertEquals(3.0, addToken.evaluate().getValue());
    }

    @Test
    public void integerIntegerAddTest() {
        Token addToken = new BinaryOperation(new Constant(new Integer(1)),new Constant(new Integer(2)), BinaryOperator.ADD);
        Assert.assertEquals(3, addToken.evaluate().getValue());
    }
}
