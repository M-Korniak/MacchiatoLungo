package expr;

import program.ProgramVariables;
import stack.Stack;

public class Variable extends Expression{
    private Stack stack = new Stack();
    private char name;

    public static ProgramVariables getProgramVariables() {
        return programVariables;
    }
    private static ProgramVariables programVariables = new ProgramVariables();
    public Variable(char name) {
        this.name = name;
    }
    public void newValue(int x) {
        stack.push(x);
    }
    public int popValue() {
        return stack.pop();
    }
    @Override
    public int calculateValue() {
        return stack.peek();
    }
    public void print() {
        if (!stack.empty()) {
            System.out.println(name + " = " + stack.peek());
        }
    }
    public String writeVariable() {
        if (!stack.empty()) {
            return name + " = " + stack.peek() + "\n";
        }
        else
            return "";
    }
    public boolean printDeeper(int howDeep) {
        if (stack.size() - howDeep > 0) {
            System.out.println(name + " = " + stack.peekDeeper(howDeep));
            return true;
        }
        return false;
    }
    @Override
    protected String asString() {
        return "" + name;
    }
    public static Variable named(char name) {
        return programVariables.getVariable(name);
    }
}
