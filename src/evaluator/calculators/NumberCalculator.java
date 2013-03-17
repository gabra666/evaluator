package evaluator.calculators;

import evaluator.Calculator;
import evaluator.annotations.Constant;
import evaluator.annotations.Operation;
import evaluator.types.Double;
import evaluator.types.Integer;

public class NumberCalculator implements Calculator {

    public NumberCalculator() {
    }
    @Constant
    public static final double PI = Math.PI;

    @Operation("+")
    public static Double add(Double p0, Double p1) {
        return new Double(p0.getValue() + p1.getValue());
    }

    @Operation("+")
    public static Double add(Double p0, Integer p1) {
        return new Double(p0.getValue() + p1.getValue());
    }

    @Operation("+")
    public static Double add(Integer p0, Double p1) {
        return new Double(p0.getValue() + p1.getValue());
    }

    @Operation("+")
    public static Integer add(Integer p0, Integer p1) {
        return new Integer(p0.getValue() + p1.getValue());
    }

    @Operation("-")
    public static Double substract(Double p0, Double p1) {
        return new Double(p0.getValue() - p1.getValue());
    }

    @Operation("-")
    public static Double substract(Double p0, Integer p1) {
        return new Double(p0.getValue() - p1.getValue());
    }

    @Operation("-")
    public static Double substract(Integer p0, Double p1) {
        return new Double(p0.getValue() - p1.getValue());
    }

    @Operation("-")
    public static Integer substract(Integer p0, Integer p1) {
        return new Integer(p0.getValue() - p1.getValue());
    }

    @Operation("*")
    public static Double multiply(Double p0, Double p1) {
        return new Double(p0.getValue() * p1.getValue());
    }

    @Operation("*")
    public static Double multiply(Double p0, Integer p1) {
        return new Double(p0.getValue() * p1.getValue());
    }

    @Operation("*")
    public static Double multiply(Integer p0, Double p1) {
        return new Double(p0.getValue() * p1.getValue());
    }

    @Operation("*")
    public static Integer multiply(Integer p0, Integer p1) {
        return new Integer(p0.getValue() * p1.getValue());
    }
}
