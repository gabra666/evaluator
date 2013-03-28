package evaluator.test;

import evaluator.Parser;
import evaluator.Token;
import evaluator.operators.BinaryOperator;
import evaluator.tokens.Constant;
import evaluator.tokens.operations.BinaryOperation;
import evaluator.types.Double;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest {
    
    @Test
    public void parserTest(){
        Parser parser = new Parser();
        Assert.assertNull(parser.getTree(""));
    }
    
    @Test
    public void parserAddTest(){
        Parser parser = new Parser();
        Token addToken = new BinaryOperation(new Constant(new Double(1.0)), new Constant(new Double(2.0)), BinaryOperator.ADD);
        Token token = parser.getTree("1.0 + 2.0");
        Assert.assertEquals(token.evaluate().getValue(), addToken.evaluate().getValue());
        
    }
    
    @Test
    public void doubleAddTest(){
        Parser parser = new Parser();
         Token addToken = 
             new BinaryOperation(
                 new BinaryOperation(
                    new Constant(new Double(1.0)),
                    new Constant(new Double(2.0)),
                    BinaryOperator.ADD),
                 new Constant(new Double(2.0)), 
                 BinaryOperator.ADD
             );
         Token token = parser.getTree("1.0 + 2.0 + 2.0");
         Assert.assertEquals(token.toString(), addToken.toString());    
    }
    
}
