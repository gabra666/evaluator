package math.calculator;

import math.annotation.Operation;
import math.type.Double;
import math.type.Integer;

public class CoreNumberCalculator implements NumberCalculator {

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
}


     /*private static HashMap<String, Method> myMethods = new HashMap();

    static {

        for (Method method : CoreNumberCalculator.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Operation.class)) {
                myMethods.put(getMethodSignature(method), method);
            }
        }
   
    public Type getResult(Operator operator, Object[] object) {
        try {
            String signature = getMethodSignature(operator, object);
            return (Type) myMethods.get(signature).invoke(this, object);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CoreNumberCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String getMethodSignature(Operator operator, Object[] object) {
        String signature = operator.getName();
        for (Object obj : object) {
            signature += obj.getClass().getSimpleName();
        }
        return signature;
    }

    private static String getMethodSignature(Method method) {
        String signature = method.getName();
        Class<?>[] params = method.getParameterTypes();
        for (Class paramClass : params) {
            signature += paramClass.getSimpleName();
        }
        return signature;
    }
*/
