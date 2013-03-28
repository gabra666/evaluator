package evaluator.test;

import junit.framework.Assert;
import evaluator.Token;
import evaluator.tokens.operations.BinaryOperation;
import evaluator.operators.BinaryOperator;
import evaluator.tokens.Constant;
import evaluator.types.Double;
import evaluator.types.Integer;
import org.junit.Test;

public class SubstractTest {

    @Test
    public void integerDoubleSubstractTest() {
        Token token = new BinaryOperation(new Constant(new Integer(-1)), new Constant(new Double(2.0)), BinaryOperator.SUBSTRACT);
        Assert.assertEquals(-3.0, token.evaluate().getValue());
    }

    @Test
    public void doubleIntegerSubstractTest() {
        Token token = new BinaryOperation(new Constant(new Double(1.0)),new Constant(new Integer(2)), BinaryOperator.SUBSTRACT);
        Assert.assertEquals(-1.0, token.evaluate().getValue());
    }

    @Test
    public void doubleDoubleSubstractTest() {
        Token token = new BinaryOperation(new Constant(new Double(1.0)), new Constant(new Double(2.0)), BinaryOperator.SUBSTRACT);
        Assert.assertEquals(-1.0, token.evaluate().getValue());
    }

    @Test
    public void integerIntegerSubstractTest() {
        Token token = new BinaryOperation(new Constant(new Integer(-1)),new Constant( new Integer(-2)), BinaryOperator.SUBSTRACT);
        Assert.assertEquals(1, token.evaluate().getValue());
    }
}
