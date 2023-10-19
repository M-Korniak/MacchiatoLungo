package builder;

import expr.Expression;
import instruction.*;

import java.util.ArrayList;
import java.util.List;

public class IfInstructionBuilder {
    private Expression expression1;
    private Expression expression2;
    private String sign;
    private List<Instruction> instructionThen;
    private List<Instruction> instructionElse;
    private List<Instruction> instructions;

    public IfInstructionBuilder(Expression expression1, String sign, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.sign = sign;
        instructionThen = new ArrayList<>();
        instructionElse = new ArrayList<>();
        instructions = instructionThen;
    }
    public IfInstructionBuilder assign(char name, Expression expression) {
        instructions.add(new Assign(name, expression));
        return this;
    }
    public IfInstructionBuilder block(Block block) {
        instructions.add(block);
        return this;
    }
    public IfInstructionBuilder forLoop(ForLoop forLoop) {
        instructions.add(forLoop);
        return this;
    }
    public IfInstructionBuilder ifInstruction(IfInstruction ifInstruction) {
        instructions.add(ifInstruction);
        return this;
    }
    public IfInstructionBuilder invoke(String name, List<Expression> paramsValues) {
        instructions.add(new Invocation(name, paramsValues));
        return this;
    }
    public IfInstructionBuilder print(Expression expression) {
        instructions.add(new Print(expression));
        return this;
    }
    public IfInstructionBuilder elseInstructions() {
        instructions = instructionElse;
        return this;
    }
    public IfInstruction build() {
        Instruction[] instructionThenArray = new Instruction[instructionThen.size()];
        instructionThenArray = instructionThen.toArray(instructionThenArray);

        Instruction[] instructionElseArray = new Instruction[instructionElse.size()];
        instructionElseArray = instructionElse.toArray(instructionElseArray);

        return new IfInstruction(expression1, sign, expression2, instructionThenArray, instructionElseArray);
    }

}
