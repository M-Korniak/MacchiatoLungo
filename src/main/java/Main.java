import builder.BlockBuilder;
import builder.ProgramBuilder;
import builder.list.List;
import debugger.ProperDebugger;
import declaration.Declaration;
import expr.*;
import instruction.*;
import program.Program;
import program.ProgramVariables;

public class Main {
    public static void main(String[] args) throws Exception {
        Program program = new ProgramBuilder()
                .declareVariable('x', Constant.of(101))
                .declareVariable('y', Constant.of(1))
                .declareProcedure("out", List.of('a'), new BlockBuilder()
                        .print(Add.of(Variable.named('a'), Variable.named('x')))
                        .build()
                )
                .assign('x', Subtract.of(Variable.named('x'), Variable.named('y')))
                .invoke("out", List.of(Variable.named('x')))
                .invoke("out", List.of(Constant.of(100)))
                .block(new BlockBuilder()
                        .declareVariable('x', Constant.of(10))
                        .invoke("out", List.of(Constant.of(100)))
                        .build()
                )
                .build();
        ProperDebugger debugger = new ProperDebugger();
        program.execute(debugger);
    }


}