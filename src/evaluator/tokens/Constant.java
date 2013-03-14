package evaluator.tokens;

import evaluator.Token;
import evaluator.Type;

public class Constant extends Token {

    private final Type<?> value;

    public Constant(Type<?> value) {
        this.value = value;
    }

    @Override
    public Type<?> evaluate() {
        return value;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
