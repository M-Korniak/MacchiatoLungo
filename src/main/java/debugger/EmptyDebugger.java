package debugger;

import program.ProgramData;

public class EmptyDebugger extends Debugger {
    @Override
    public void debug(ProgramData variables) {
        return;
    }

    @Override
    public boolean shouldPrintInstruction() { return false; }

}
