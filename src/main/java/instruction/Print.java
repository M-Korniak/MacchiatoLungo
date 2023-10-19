package instruction;

import expr.Expression;
import debugger.Debugger;
import program.ProgramData;

public class Print extends Instruction {
    private Expression expression;
    public Print(Expression expression)  {
        this.expression = expression;
    }
    @Override
    public void execute(ProgramData programData, Debugger debugger) throws Exception {
        try {
            if (debugger.shouldPrintInstruction()) { printInstruction(); }
            debugger.debug(programData);
            int value = expression.calculateValue();
            System.out.println(value);
        } catch (Exception e) {
            programData.print();
            printInstruction();
            System.exit(0);
        }
    }
    @Override
    protected void printInstruction() {
        System.out.println("Print " + expression);
    }
}