package evaluator.test;

import evaluator.Parser;
import evaluator.Token;
import evaluator.operators.BinaryOperator;
import evaluator.tokens.Constant;
import evaluator.tokens.operations.BinaryOperation;
import evaluator.types.Double;
import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MockitoTest {

    @Test
    public void simpleAddMockTest() {
        Token addToken = Mockito.mock(BinaryOperation.class);
        Mockito.when(addToken.evaluate()).thenReturn(new Double(3.0));
        Assert.assertEquals(3.0, addToken.evaluate().getValue());
    }

    @Test
    public void treeToStringMockTest() {
        Token addToken = Mockito.mock(BinaryOperation.class);
        Mockito.when(addToken.toString()).thenReturn("(1.0+2.0)*2.0");
        Assert.assertEquals("(1.0+2.0)*2.0", addToken.toString());

    }

    public void parsingEmptyStringMockTest() {
        Parser parser = Mockito.mock(Parser.class);
        Mockito.when(parser.getTree("")).thenReturn(null);
        Assert.assertEquals(null, parser.getTree(""));
    }

    @Test
    public void parsingStringMockTest() {
        Parser parser = Mockito.mock(Parser.class);
        Mockito.when(parser.getTree("1.0 + 2.0")).thenReturn(
                new BinaryOperation(new Constant(new Double(1.0)),
                new Constant(new Double(2.0)),
                BinaryOperator.ADD));
        
        Token addToken = parser.getTree("1.0 + 2.0");
        Token token = Mockito.mock(BinaryOperation.class);
        Mockito.when(token.evaluate()).thenReturn(new Double(3.0));

        Assert.assertEquals(token.evaluate().getValue(), addToken.evaluate().getValue());
    }
}
