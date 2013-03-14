package math.test;

import junit.framework.Assert;
import evaluator.Token;
import evaluator.tokens.operations.BinaryOperation;
import evaluator.operators.BinaryOperator;
import org.junit.Test;

public class TreeToStringTest {
    
 /* @Before
  public void simpleTree(){
      Token addToken = new BinaryOperation(new math.type.Double(1.0), new math.type.Double(2.0), BinaryOperator.ADD);
  }*/
    
    
 @Test
 public void simpleAddTreeToString(){
     Token addToken = new BinaryOperation(new evaluator.types.Double(1.0), new evaluator.types.Double(2.0), BinaryOperator.ADD);
     Assert.assertEquals("1.0+2.0", addToken.ToString());
 }
}
