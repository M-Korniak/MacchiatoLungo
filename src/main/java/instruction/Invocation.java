package instruction;

import debugger.Debugger;
import expr.Expression;
import program.Procedure;
import program.ProgramData;

import java.util.List;

public class Invocation extends Instruction {
    private String name;
    private List<Expression> paramsValues;

    public Invocation(String name, List<Expression> paramsValues) {
        this.name = name;
        this.paramsValues = paramsValues;
    }

    @Override
    public void execute(ProgramData programData, Debugger debugger) throws Exception {
        try {
            Procedure procedure = programData.getProcedure(name);
            procedure.execute(paramsValues, programData, debugger);
        } catch (Exception e){
            programData.print();
            printInstruction();
            System.exit(0);
        }
    }

    @Override
    protected void printInstruction() {
        System.out.println(name + "invocation");
    }
}
