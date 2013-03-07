package math.test;

import junit.framework.Assert;
import math.data.Constant;
import math.data.Token;
import math.operation.BinaryOperation;
import math.operator.BinaryOperator;
import math.type.Double;
import org.junit.Test;


public class GeneralTest {
    
    public GeneralTest() {
    }
    
    
    

    @Test
    public void firstAddTest(){
        
        Double n1= new Double(1.0);
        Double n2= new Double(2.0);
        
        Constant c1=new Constant(n1);
        Constant c2=new Constant(n2);
        
        Token addToken= new BinaryOperation(c1,c2,BinaryOperator.ADD) ;
        
        Assert.assertEquals(3, addToken.evaluate(), 0.0);
    }
}
