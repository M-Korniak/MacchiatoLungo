package program;

import debugger.Debugger;
import expr.Expression;
import instruction.Block;

import java.util.List;

public class Procedure {
    private String name;
    private List<Character> params;
    private Block block;

    public Procedure(String name, List<Character> params, Block block) {
        this.name = name;
        this.params = params;
        this.block = block;
    }
    public void execute(List<Expression> paramsValues, ProgramData programData, Debugger debugger) throws Exception {
        if (params.size() != paramsValues.size()) {
            System.out.println("Wrong number of arguments in " + name + "!");
            System.exit(1);
        }
        else {
            for (int i = 0; i < params.size(); i++) {
                programData.newVariable(params.get(i), paramsValues.get(i).calculateValue());
            }
            block.execute(programData, debugger);
            for (char param : params) {
                programData.popVariable(param);
            }
        }
    }
    public String writeProcedure() {
        String output = "";
        output += name;
        for (char params : params) {
            output += " ";
            output += params;
        }
        output += "\n";
        return output;
    }

}
