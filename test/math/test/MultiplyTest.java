package math.test;

import junit.framework.Assert;
import evaluator.Token;
import evaluator.tokens.operations.BinaryOperation;
import evaluator.operators.BinaryOperator;
import evaluator.tokens.Constant;
import org.junit.Test;
import evaluator.types.Double;
import evaluator.types.Integer;

public class MultiplyTest {

    @Test
    public void integerDoubleMultiplyTest() {
        Token addToken = new BinaryOperation(new Constant(new Integer(-1)), new Constant(new Double(2.0)), BinaryOperator.MULTIPLY);
        Assert.assertEquals(-2.0, addToken.evaluate().getValue());
    }

    @Test
    public void doubleIntegerMultiplyTest() {
        Token addToken = new BinaryOperation(new Constant(new Double(1.0)), new Constant(new Integer(2)), BinaryOperator.MULTIPLY);
        Assert.assertEquals(2.0, addToken.evaluate().getValue());
    }

    @Test
    public void doubleDoubleMultiplyTest() {
        Token addToken = new BinaryOperation(new Constant(new Double(1.0)), new Constant(new Double(2.0)), BinaryOperator.MULTIPLY);
        Assert.assertEquals(2.0, addToken.evaluate().getValue());
    }

    @Test
    public void integerIntegerMultiplyTest() {
        Token addToken = new BinaryOperation(new Constant(new Integer(-1)), new evaluator.types.Integer(-2), BinaryOperator.MULTIPLY);
        Assert.assertEquals(2, addToken.evaluate().getValue());
    }
}
