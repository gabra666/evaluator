package evaluator.types;

import evaluator.Type;

public class Integer extends Type<java.lang.Integer> {

    public Integer(java.lang.Integer value) {
        super(value);
    }
    
     public Integer(String value) {
        super(java.lang.Integer.valueOf(value));
    }
}
