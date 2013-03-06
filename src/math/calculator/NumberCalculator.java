package math.calculator;
import math.type.Double;
import math.type.Integer;

public interface NumberCalculator {
    
    
    public Double add(Double p0, Double p1);
    public Double add(Double p0, Integer p1);
    public Double add(Integer p0, Double p1);
    public Integer add(Integer p0, Integer p1);
    
    public Double substract(Double p0, Double p1);
    public Double substract(Double p0, Integer p1);
    public Double substract(Integer p0, Double p1);
    public Integer substract(Integer p0, Integer p1);
    
    public Double multiply(Double p0, Double p1);
    public Double multiply(Double p0, Integer p1);
    public Double multiply(Integer p0, Double p1);
    public Integer multiply(Integer p0, Integer p1);
      
    
}
