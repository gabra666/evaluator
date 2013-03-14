package evaluator.tokens;

import evaluator.Type;

public class NamedConstant extends Constant {
    
    private String name;

    public NamedConstant(String name, Type<?> value) {
        super(value);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
