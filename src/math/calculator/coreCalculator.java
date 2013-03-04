package math.calculator;

import math.annotation.Operation;

public class coreCalculator implements NumberCalculator{

    public coreCalculator() {
    }
    
    @Operation("+")
    public Double add(Double p0, Double p1){
        return p0+p1;
    }
    @Operation("+")
    public Double add(Double p0, Integer p1){
        return p0+p1;
    }
    @Operation("+")
    public Double add(Integer p0, Double p1){
        return p0+p1;
    }
    @Operation("+")
    public Integer add(Integer p0, Integer p1){
        return p0+p1;
    }
    @Operation("-")
    public Double substract(Double p0, Double p1){
        return p0-p1;
    }
    @Operation("-")
    public Double substract(Double p0, Integer p1){
        return p0-p1;
    }
    @Operation("-")
    public Double substract(Integer p0, Double p1){
        return p0-p1;
    }
    @Operation("-")
    public Integer substract(Integer p0, Integer p1){
        return p0-p1;
    }
    
    
}
 
