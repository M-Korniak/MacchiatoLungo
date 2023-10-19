package builder;

import expr.Expression;
import instruction.*;

import java.util.ArrayList;
import java.util.List;

public class ForLoopBuilder {
    private char name;
    private Expression expression;

    private List<Instruction> instructions;

    public ForLoopBuilder(char name, Expression expression) {
        this.name = name;
        this.expression = expression;
        instructions = new ArrayList<>();
    }
    public ForLoopBuilder assign(char name, Expression expression) {
        instructions.add(new Assign(name, expression));
        return this;
    }
    public ForLoopBuilder block(Block block) {
        instructions.add(block);
        return this;
    }
    public ForLoopBuilder forLoop(ForLoop forLoop) {
        instructions.add(forLoop);
        return this;
    }
    public ForLoopBuilder ifInstruction(IfInstruction ifInstruction) {
        instructions.add(ifInstruction);
        return this;
    }
    public ForLoopBuilder invoke(String name, List<Expression> paramsValues) {
        instructions.add(new Invocation(name, paramsValues));
        return this;
    }
    public ForLoopBuilder print(Expression expression) {
        instructions.add(new Print(expression));
        return this;
    }
    public ForLoop build() {
        Instruction[] instructionsArray = new Instruction[instructions.size()];
        instructionsArray = instructions.toArray(instructionsArray);

        return new ForLoop(name, expression, instructionsArray);
    }

}
