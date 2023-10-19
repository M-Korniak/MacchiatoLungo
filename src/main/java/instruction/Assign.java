package instruction;

import expr.Expression;
import debugger.Debugger;
import program.ProgramData;

public class Assign extends Instruction {
    private char name;
    private Expression expression;
    public Assign(char name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void execute(ProgramData programData, Debugger debugger) throws Exception {
        try {
            if (debugger.shouldPrintInstruction()) { printInstruction(); }
            debugger.debug(programData);
            int value = expression.calculateValue();
            programData.popVariable(name);
            programData.newVariable(name, value);

        } catch (Exception e) {
            programData.print();
            printInstruction();
            System.exit(0);
        }
    }

    @Override
    protected void printInstruction() {
        System.out.println(name + " := " + expression);
    }

}
