package instruction;

import expr.Expression;

public class Comparison {
    String sign;
    public Comparison(String sign) {
        this.sign = sign;
    }
    public boolean compare(Expression e1, Expression e2) throws Exception {
        int value1 = e1.calculateValue();
        int value2 = e2.calculateValue();
        switch(sign) {
            case "=" -> { return value1 == value2; }
            case "<>" -> { return value1 != value2; }
            case "<" -> { return value1 < value2; }
            case ">" -> { return  value1 > value2; }
            case ">=" -> { return value1 >= value2; }
            case "<=" -> { return value1 <= value2; }
        }
        return false;
    }
}
