package expr;

public class Divide extends Operator {
    public Divide(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int calculateValue() throws Exception {
        int leftValue = left.calculateValue();
        int rightValue = right.calculateValue();
        if (rightValue != 0)
            return leftValue / rightValue;
        else {
            throw new Exception("Division by zero");
        }
    }
    @Override
    protected int getWeight() {
        return 100;
    }
    @Override
    protected String getSymbol() {
        return " / ";
    }
    public static Divide of(Expression expressionLeft, Expression expressionRight) {
        return new Divide(expressionLeft, expressionRight);
    }
}
