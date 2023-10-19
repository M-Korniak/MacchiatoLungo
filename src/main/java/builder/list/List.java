package builder.list;

import expr.Expression;

import java.util.ArrayList;

public class List {
    public static java.util.List<Character> of(char... params) {
        java.util.List<Character> list = new ArrayList<>();
        for (char param : params) {
            list.add(param);
        }
        return list;
    }
    public static java.util.List<Expression> of(Expression... expressions) {
        java.util.List<Expression> list = new ArrayList<>();
        for (Expression expression : expressions) {
            list.add(expression);
        }
        return list;
    }
}
