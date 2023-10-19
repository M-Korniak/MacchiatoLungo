package program;
import debugger.Debugger;
import instruction.Block;
public class Program {
    private Block block;
    private ProgramData programData;
    public Program(Block block, ProgramData programData) {
        this.block = block;
        this.programData = programData;
    }
    public void execute(Debugger debugger) throws Exception {
        block.executeMain(programData, debugger);
    }
}
