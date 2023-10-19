package expr;

public class Constant extends Expression {
    private final int value;


    public Constant(int value) {
        this.value = value;
    }

    @Override
    public int calculateValue() {
        return value;
    }

    @Override
    public String asString() {
        if (value < 0) {
            return "(" + value + ")";
        }
        return "" + value;
    }
    public static Constant of(int value) {
        return new Constant(value);
    }
}
