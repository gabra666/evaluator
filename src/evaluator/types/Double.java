package evaluator.types;

import evaluator.Type;

public class Double extends Type<java.lang.Double> {

    public Double(java.lang.Double value) {
        super(value);
    }

    public Double(String tokenString) {
        super(java.lang.Double.valueOf(tokenString));
    }
}
