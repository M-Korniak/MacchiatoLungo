package instruction;

import declaration.Declaration;
import expr.Expression;

import debugger.Debugger;
import program.ProgramData;

public class ForLoop extends Instruction {

    private char name;
    private Expression expression;
    private Instruction[] instructions;
    public ForLoop(char name, Expression expression, Instruction[] instructions) {
        this.instructions = instructions;
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void execute(ProgramData programData, Debugger debugger) throws Exception {
        try {
            int loopHowManyTimes = expression.calculateValue();
            Block block = new Block(new Declaration[0] , instructions);
            for (int i = 0; i < loopHowManyTimes; i++) {
                if (debugger.shouldPrintInstruction()) { printInstruction(); }
                debugger.debug(programData);
                programData.newVariable(name, i);
                block.execute(programData, debugger);
                programData.popVariable(name);
            }
        } catch (Exception e) {
            programData.print();
            printInstruction();
            System.exit(0);
        }
    }

    @Override
    protected void printInstruction() {
        System.out.println("for " + name + " " + expression);
    }

}
