package instruction;

import debugger.Debugger;
import program.ProgramData;

public abstract class Instruction {
    public abstract void execute(ProgramData programData, Debugger debugger) throws Exception;
    protected abstract void printInstruction();
}
