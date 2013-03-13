package math.data;

public class Type<T> extends Token{

    private T value;

    public Type(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public Type evaluate() {
        return this;
    }

    @Override
    public String ToString() {
        return value.toString();
    }
}
