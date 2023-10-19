package declaration;

import instruction.Block;
import program.ProgramData;

import java.util.List;

public class ProcedureDeclaration extends Declaration {
    private String name;
    List<Character> params;
    private Block block;

    public ProcedureDeclaration(String name, List<Character> params, Block block) {
        this.name = name;
        this.params = params;
        this.block = block;
    }

    @Override
    public void execute(ProgramData programData) throws Exception {
        programData.newProcedure(name, params, block);
    }

    @Override
    public void pop(ProgramData programData) {
        programData.popProcedure(name);
    }
}