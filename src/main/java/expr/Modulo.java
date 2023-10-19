package expr;

public class Modulo extends Operator {
    public Modulo(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int calculateValue() throws Exception {
        int leftValue = left.calculateValue();
        int rightValue = right.calculateValue();
        if (rightValue != 0)
            return leftValue % rightValue;
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
        return " % ";
    }

    public static Modulo of(Expression expressionLeft, Expression expressionRight) {
        return new Modulo(expressionLeft, expressionRight);
    }
}
