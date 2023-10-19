package builder;

import declaration.Declaration;
import declaration.ProcedureDeclaration;
import declaration.VariableDeclaration;
import expr.Expression;
import instruction.*;
import program.Program;
import program.ProgramData;

import java.util.ArrayList;
import java.util.List;

public class ProgramBuilder {
    List<Declaration> declaration;
    List<Instruction> instructions;
    ProgramData programData;
    public ProgramBuilder() {
        declaration = new ArrayList<>();
        instructions = new ArrayList<>();
        programData = new ProgramData();
    }
    public ProgramBuilder declareVariable(char name, Expression expression) {
        declaration.add(new VariableDeclaration(name, expression));
        return this;
    }
    public ProgramBuilder declareProcedure(String name, List<Character> params, Block block) {
        declaration.add(new ProcedureDeclaration(name, params, block));
        return this;
    }
    public ProgramBuilder assign(char name, Expression expression) {
        instructions.add(new Assign(name, expression));
        return this;
    }
    public ProgramBuilder block(Block block) {
        instructions.add(block);
        return this;
    }
    public ProgramBuilder forLoop(ForLoop forLoop) {
        instructions.add(forLoop);
        return this;
    }
    public ProgramBuilder ifInstruction(IfInstruction ifInstruction) {
        instructions.add(ifInstruction);
        return this;
    }
    public ProgramBuilder invoke(String name, List<Expression> paramsValues) {
        instructions.add(new Invocation(name, paramsValues));
        return this;
    }
    public ProgramBuilder print(Expression expression) {
        instructions.add(new Print(expression));
        return this;
    }
    public Program build() {
        Declaration[] declarationsArray = new Declaration[declaration.size()];
        declarationsArray = declaration.toArray(declarationsArray);

        Instruction[] instructionsArray = new Instruction[instructions.size()];
        instructionsArray = instructions.toArray(instructionsArray);
        Block block = new Block(declarationsArray, instructionsArray);

        return new Program(block, programData);
    }
}
