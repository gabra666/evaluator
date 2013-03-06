package math.calculator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import math.annotation.Operation;
import math.data.Type;
import math.operator.Operator;
import math.type.Double;
import math.type.Integer;

public class CoreNumberCalculator implements NumberCalculator {

     private static HashMap<String,Method> myMethods= new HashMap();
    
    static{
        
        for(Method method: CoreNumberCalculator.class.getDeclaredMethods()){
            if(method.isAnnotationPresent(Operation.class)){
                myMethods.put(method.getName()+" "+method., method);
            }
        }
    }

    
    public CoreNumberCalculator() {
    }

    @Operation("+")
    @Override
    public Double add(Double p0, Double p1) {
        return new Double(p0.getValue() + p1.getValue());
    }

    @Operation("+")
    @Override
    public Double add(Double p0, Integer p1) {
        return new Double(p0.getValue() + p1.getValue());
    }

    @Operation("+")
    @Override
    public Double add(Integer p0, Double p1) {
        return new Double(p0.getValue() + p1.getValue());
    }

    @Operation("+")
    @Override
    public Integer add(Integer p0, Integer p1) {
        return new Integer(p0.getValue() + p1.getValue());
    }

    @Operation("-")
    @Override
    public Double substract(Double p0, Double p1) {
        return new Double(p0.getValue() - p1.getValue());
    }

    @Operation("-")
    @Override
    public Double substract(Double p0, Integer p1) {
        return new Double(p0.getValue() - p1.getValue());
    }

    @Operation("-")
    @Override
    public Double substract(Integer p0, Double p1) {
        return new Double(p0.getValue() - p1.getValue());
    }

    @Operation("-")
    @Override
    public Integer substract(Integer p0, Integer p1) {
        return new Integer(p0.getValue() - p1.getValue());
    }

    @Operation("*")
    @Override
    public Double multiply(Double p0, Double p1) {
        return new Double(p0.getValue() * p1.getValue());
    }

    @Operation("*")
    @Override
    public Double multiply(Double p0, Integer p1) {
        return new Double(p0.getValue() * p1.getValue());
    }

    @Operation("*")
    @Override
    public Double multiply(Integer p0, Double p1) {
        return new Double(p0.getValue() * p1.getValue());
    }

    @Operation("*")
    @Override
    public Integer multiply(Integer p0, Integer p1) {
        return new Integer(p0.getValue() * p1.getValue());
    }

    public Type getResult(Operator operator, Object[] object) {
        try { 
            return(Type) myMethods.get(name).invoke(this, object);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CoreNumberCalculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CoreNumberCalculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CoreNumberCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
