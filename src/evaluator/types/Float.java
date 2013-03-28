package evaluator.types;

import evaluator.Type;

public class Float extends Type<java.lang.Float> {

    public Float(java.lang.Float value) {
        super(value);
    }

    public Float(String value) {
        super(java.lang.Float.valueOf(value));
    }
}
