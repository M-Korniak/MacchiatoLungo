package program;

import expr.Variable;
import instruction.Block;

import java.util.List;

public class ProgramData {
    private ProgramVariables programVariables = Variable.getProgramVariables();
    private ProgramProcedures programProcedures = new ProgramProcedures();

    public void newVariable(char name, int value) {
        programVariables.newVariable(name, value);
    }
    public int popVariable(char name) {
        return programVariables.popVariable(name);
    }
    public Variable getVariable(char name) {
        return programVariables.getVariable(name);
    }
    public void print() { programVariables.print(); }
    public void printDeeper(int howDeep) { programVariables.printDeeper(howDeep); }

    public void newProcedure(String name, List<Character> params, Block block) {
        programProcedures.newProcedure(name, params, block);
    }
    public void popProcedure(String name) { programProcedures.popProcedure(name); }
    public Procedure getProcedure(String name) { return programProcedures.getProcedure(name); }
    public String writeVariable() { return programVariables.writeVariables(); }
    public String writeProcedures() { return programProcedures.writeProcedures(); }

}
