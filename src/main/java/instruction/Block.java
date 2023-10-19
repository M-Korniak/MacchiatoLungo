package instruction;

import debugger.Debugger;
import declaration.Declaration;
import program.ProgramData;

public class Block extends Instruction{
    private Declaration[] declarations;
    private Instruction[] instructions;
    public Block(Declaration[] declarations, Instruction[] instructions) {
        this.declarations = declarations;
        this.instructions = instructions;
    }

    @Override
    public void execute(ProgramData programData, Debugger debugger) throws Exception {
        for (Declaration declaration : declarations)
            declaration.execute(programData);
        for (Instruction instruction : instructions)
            instruction.execute(programData, debugger);
        for (Declaration declaration : declarations)
            declaration.pop(programData);
    }

    public void executeMain(ProgramData programData, Debugger debugger) throws Exception {
        for (Declaration declaration : declarations)
            declaration.execute(programData);
        for (Instruction instruction : instructions)
            instruction.execute(programData, debugger);
        programData.print();
        for (Declaration declaration : declarations)
            declaration.pop(programData);
    }

    @Override
    protected void printInstruction() {
        System.out.println("begin block");
    }
}
