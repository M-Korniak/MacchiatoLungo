package program;

import expr.Variable;

public class ProgramVariables {
    private final static int DEFAULT_LENGTH = 26;
    private Variable[] variables = new Variable[DEFAULT_LENGTH];
    public ProgramVariables() {
        for (int i = 0; i < DEFAULT_LENGTH; i++) {
            variables[i] = new Variable((char)(i + 'a'));
        }
    }
    public void newVariable(char name, int value) {
        variables[(int)(name - 'a')].newValue(value);
    }
    public int popVariable(char name) {
        return variables[(int)(name - 'a')].popValue();
    }
    public Variable getVariable(char name) {
        return variables[(int)(name - 'a')];
    }

    public void print() {
        for (Variable variable : variables)
            variable.print();
    }
    public String writeVariables() {
        String output = "";
        for (Variable variable : variables) {
            output += variable.writeVariable();
        }
        return output;
    }
    public void printDeeper(int howDeep) {
        boolean okay = false;
        for (Variable variable : variables)
            if (variable.printDeeper(howDeep))
                okay = true;
        if (!okay)
            System.out.println("Too deep invocation");
    }
}
