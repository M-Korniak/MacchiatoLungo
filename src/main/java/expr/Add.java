package expr;

public class Add extends Operator {
    public Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int calculateValue() throws Exception {
        return left.calculateValue() + right.calculateValue();
    }

    @Override
    protected int getWeight() {
        return 10;
    }
    @Override
    protected String getSymbol() {
        return " + ";
    }

    public static Add of(Expression expressionLeft, Expression expressionRight) {
        return new Add(expressionLeft, expressionRight);
    }
}
