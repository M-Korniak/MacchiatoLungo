package expr;

public abstract class Expression {
    public abstract int calculateValue() throws Exception;

    @Override
    public String toString() {
        return asString();
    }
    protected abstract String asString();
    protected int getWeight() {
        return Integer.MAX_VALUE;
    }
}
