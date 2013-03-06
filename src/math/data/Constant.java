package math.data;

public class Constant extends Token {

    private final Type value;

    public Constant(Type value) {
        this.value = value;
    }

    @Override
    public Type evaluate() {
        return value;
    }
}
