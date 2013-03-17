package evaluator;

import evaluator.annotations.Operation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class CalculatorSolver {

    private HashMap<String, Method> methodBySignature = new HashMap<>();

    public CalculatorSolver() {
        Reflections ref = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forJavaClassPath()));
        addMethods(ref.getSubTypesOf(Calculator.class));
    }

    private void addMethods(Set<Class<? extends Calculator>> classes) {
        for (Class<?> theClass : classes) {
            addMethods(theClass);
        }
    }

    private void addMethods(Class<?> theClass) {
        for (Method method : theClass.getDeclaredMethods()) {
            if (!method.isAnnotationPresent(Operation.class)) continue;
            methodBySignature.put(getSignature(method), method);
        }
    }
    
    public Type getResult(Operator operator, Type[] types) {
        try {
            String signature = getSignature(operator, types);
            return (Type) methodBySignature.get(signature).invoke(null, types);
        } 
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        }
        return null;
    }

    private String getSignature(Method method) {
        String signature = method.getName();
        Class<?>[] params = method.getParameterTypes();
        for (Class paramClass : params) signature += paramClass.getSimpleName();
        return signature;
    }

    private String getSignature(Operator operator, Object[] object) {
        String signature = operator.getName();
        for (Object obj : object) signature += obj.getClass().getSimpleName();
        return signature;
    }

}
