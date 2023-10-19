package instruction;

import declaration.Declaration;
import expr.Expression;
import debugger.Debugger;
import program.ProgramData;

public class IfInstruction extends Instruction {
    private Expression expression1;
    private Expression expression2;
    private String sign;
    private Instruction[] instructionsThen;
    private Instruction[] instructionsElse;

    public IfInstruction(Expression expression1, String sign, Expression expression2,
                         Instruction[] instructionsThen, Instruction[] instructionsElse)  {
        this.instructionsElse = instructionsElse;
        this.instructionsThen = instructionsThen;
        this.sign = sign;
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public void execute(ProgramData programData, Debugger debugger) throws Exception {
        try {
            if (debugger.shouldPrintInstruction()) { printInstruction(); }
            Comparison comparison = new Comparison(sign);
            if (comparison.compare(expression1, expression2)) {
                Block block = new Block(new Declaration[0], instructionsThen);
                debugger.debug(programData);
                block.execute(programData, debugger);
            }
            else {
                Block block = new Block(new Declaration[0], instructionsElse);
                debugger.debug(programData);
                block.execute(programData, debugger);
            }
        } catch (Exception e) {
            programData.print();
            printInstruction();
            System.exit(0);
        }
    }
    @Override
    protected void printInstruction() {
        System.out.println("if " + expression1 + " " + sign + " " + expression2);
    }
}
