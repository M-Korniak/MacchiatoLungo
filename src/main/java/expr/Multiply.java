package expr;

public class Multiply extends Operator {
    public Multiply(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int calculateValue() throws Exception {
        return left.calculateValue() * right.calculateValue();
    }
    @Override
    protected int getWeight() {
        return 100;
    }
    @Override
    protected String getSymbol() {
        return " * ";
    }
    public static Multiply of(Expression expressionLeft, Expression expressionRight) {
        return new Multiply(expressionLeft, expressionRight);
    }
}
