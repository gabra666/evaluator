package evaluator.test;

import evaluator.Token;
import evaluator.operators.BinaryOperator;
import evaluator.tokens.Constant;
import evaluator.tokens.operations.BinaryOperation;
import evaluator.types.Double;
import junit.framework.Assert;
import org.junit.Test;

public class TreeToStringTest {
    
 @Test
 public void multiplyAddTreeToString(){
     Token addToken = 
             new BinaryOperation(
                 new BinaryOperation(
                    new Constant(new Double(1.0)),
                    new Constant(new Double(2.0)),
                    BinaryOperator.ADD),
                 new Constant(new Double(2.0)), 
                 BinaryOperator.MULTIPLY
             );
     Assert.assertEquals("(1.0+2.0)*2.0", addToken.toString());
 }
 
 @Test
 public void multiplyDoubleAddTreeToString(){
     Token addToken = 
             new BinaryOperation(
                 new BinaryOperation(
                    new Constant(new Double(1.0)),
                    new Constant(new Double(2.0)),
                    BinaryOperator.ADD),
                 new BinaryOperation(
                    new Constant(new Double(1.0)),
                    new Constant(new Double(2.0)),
                    BinaryOperator.ADD), 
                 BinaryOperator.MULTIPLY
             );
     Assert.assertEquals("(1.0+2.0)*(1.0+2.0)", addToken.toString());
 }
 
 @Test
 public void addMultiplyTreeToString(){
     Token addToken = 
             new BinaryOperation(
                 new BinaryOperation(
                    new Constant(new Double(1.0)),
                    new Constant(new Double(2.0)),
                    BinaryOperator.MULTIPLY),
                 new Constant(new Double(2.0)), 
                 BinaryOperator.ADD
             );
     Assert.assertEquals("1.0*2.0+2.0", addToken.toString());
 }
 
  @Test
 public void tripleAddTreeToString(){
     Token addToken = 
             new BinaryOperation(
                 new BinaryOperation(
                    new Constant(new Double(1.0)),
                    new Constant(new Double(2.0)),
                    BinaryOperator.ADD),
                 new BinaryOperation(
                    new Constant(new Double(1.0)),
                    new Constant(new Double(2.0)),
                    BinaryOperator.ADD), 
                 BinaryOperator.ADD
             );
     Assert.assertEquals("1.0+2.0+1.0+2.0", addToken.toString());
 }
 
 
}
