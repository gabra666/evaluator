package math.calculator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import math.annotation.Operation;
import math.data.Type;
import math.operator.Operator;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class CalculatorSolver {

    private HashMap<String, Class<?>> calculatorsBySignature = new HashMap<>();
    private HashMap<String, Method> methodBySignature = new HashMap<>();
    private Reflections ref;

    public CalculatorSolver() {
        ref = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath()));
        findCalculatorsMethods();
    }

    private void findCalculatorsMethods() {
        Set<Class<? extends NumberCalculator>> allClasses = ref.getSubTypesOf(NumberCalculator.class);

        for (Class<?> c : allClasses) {
            Method[] methods = c.getDeclaredMethods();
            for (Method m : methods) {
                if (m.isAnnotationPresent(Operation.class)) {
                    calculatorsBySignature.put(getMethodSignature(m), c);
                    methodBySignature.put(getMethodSignature(m), m);
                }
            }
        }
    }
       public Type getResult(Operator operator, Object[] object) {
        try {

            String signature = getMethodSignature(operator, object);
            return (Type) methodBySignature.get(signature).invoke(calculatorsBySignature.get(signature).newInstance(), object);
        } catch (InstantiationException|IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CoreNumberCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String getMethodSignature(Method method) {
        String signature = method.getName();
        Class<?>[] params = method.getParameterTypes();
        for (Class paramClass : params) {
            signature += paramClass.getSimpleName();
        }
        return signature;
    }

 

    private String getMethodSignature(Operator operator, Object[] object) {
        String signature = operator.getName();
        for (Object obj : object) {
            signature += obj.getClass().getSimpleName();
        }
        return signature;
    }
}
