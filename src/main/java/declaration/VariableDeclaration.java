package declaration;

import expr.Expression;
import program.ProgramData;

public class VariableDeclaration extends Declaration {
    private char name;
    private Expression expression;
    public VariableDeclaration(char name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }
    @Override
    public void execute(ProgramData programData) throws Exception {
        try {
            programData.newVariable(name, expression.calculateValue());
        } catch(Exception e) {
            programData.print();
            System.out.println("var " + name + " " + expression);
            System.exit(0);
        }
    }
    @Override
    public void pop(ProgramData programData) {
        programData.popVariable(name);
    }
}
