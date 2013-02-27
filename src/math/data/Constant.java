package math.data;

import math.type.Type;

public class Constant extends Node {

    private final Type value;

    public Constant(Type value) {
        this.value = value;
    }

    @Override
    public Type evaluate() {
        return value;
    }
}
