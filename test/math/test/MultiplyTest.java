package math.test;

import junit.framework.Assert;
import math.data.Token;
import math.operation.BinaryOperation;
import math.operator.BinaryOperator;
import org.junit.Test;

public class MultiplyTest {

    @Test
    public void integerDoubleMultiplyTest() {
        Token addToken = new BinaryOperation(new math.type.Integer(-1), new math.type.Double(2.0), BinaryOperator.MULTIPLY);
        Assert.assertEquals(-2.0, addToken.evaluate().getValue());
    }

    @Test
    public void doubleIntegerMultiplyTest() {
        Token addToken = new BinaryOperation(new math.type.Double(1.0), new math.type.Integer(2), BinaryOperator.MULTIPLY);
        Assert.assertEquals(2.0, addToken.evaluate().getValue());
    }

    @Test
    public void doubleDoubleMultiplyTest() {
        Token addToken = new BinaryOperation(new math.type.Double(1.0), new math.type.Double(2.0), BinaryOperator.MULTIPLY);
        Assert.assertEquals(2.0, addToken.evaluate().getValue());
    }

    @Test
    public void integerIntegerMultiplyTest() {
        Token addToken = new BinaryOperation(new math.type.Integer(-1), new math.type.Integer(-2), BinaryOperator.MULTIPLY);
        Assert.assertEquals(2, addToken.evaluate().getValue());
    }
}
