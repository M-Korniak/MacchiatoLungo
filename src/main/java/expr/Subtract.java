package expr;

public class Subtract extends Operator {
    public Subtract(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int calculateValue() throws Exception {
        return left.calculateValue() - right.calculateValue();
    }
    @Override
    protected int getWeight() {
        return 10;
    }
    @Override
    protected String getSymbol() {
        return " - ";
    }
    public static Subtract of(Expression expressionLeft, Expression expressionRight) {
        return new Subtract(expressionLeft, expressionRight);
    }
}
