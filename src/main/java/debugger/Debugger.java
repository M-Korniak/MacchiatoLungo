package debugger;

import program.ProgramData;

import java.io.IOException;

public abstract class Debugger {

    public abstract void debug(ProgramData variables) throws IOException;
    public abstract boolean shouldPrintInstruction();

}
