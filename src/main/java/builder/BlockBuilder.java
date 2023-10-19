package builder;


import declaration.Declaration;
import declaration.ProcedureDeclaration;
import declaration.VariableDeclaration;
import expr.Expression;
import instruction.*;

import java.util.ArrayList;
import java.util.List;
public class BlockBuilder {
    List<Declaration> declaration;
    List<Instruction> instructions;
    public BlockBuilder() {
        declaration = new ArrayList<>();
        instructions = new ArrayList<>();
    }
    public BlockBuilder declareVariable(char name, Expression expression) {
        declaration.add(new VariableDeclaration(name, expression));
        return this;
    }
    public BlockBuilder declareProcedure(String name, List<Character> params, Block block) {
        declaration.add(new ProcedureDeclaration(name, params, block));
        return this;
    }
    public BlockBuilder assign(char name, Expression expression) {
        instructions.add(new Assign(name, expression));
        return this;
    }
    public BlockBuilder block(Block block) {
        instructions.add(block);
        return this;
    }
    public BlockBuilder forLoop(ForLoop forLoop) {
        instructions.add(forLoop);
        return this;
    }
    public BlockBuilder ifInstruction(IfInstruction ifInstruction) {
        instructions.add(ifInstruction);
        return this;
    }
    public BlockBuilder invoke(String name, List<Expression> paramsValues) {
        instructions.add(new Invocation(name, paramsValues));
        return this;
    }
    public BlockBuilder print(Expression expression) {
        instructions.add(new Print(expression));
        return this;
    }
    public Block build() {
        Declaration[] declarationsArray = new Declaration[declaration.size()];
        declarationsArray = declaration.toArray(declarationsArray);

        Instruction[] instructionsArray = new Instruction[instructions.size()];
        instructionsArray = instructions.toArray(instructionsArray);
        return new Block(declarationsArray, instructionsArray);
    }
}
