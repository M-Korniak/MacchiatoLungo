package instruction;

import builder.BlockBuilder;
import builder.IfInstructionBuilder;
import builder.ProgramBuilder;
import builder.list.List;
import debugger.EmptyDebugger;
import debugger.ProperDebugger;
import expr.Add;
import expr.Constant;
import expr.Subtract;
import expr.Variable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import program.Program;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InvocationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @Test
    public void InvocationTest() throws Exception {
        Program program = new ProgramBuilder()
                .declareVariable('x', Constant.of(101))
                .declareProcedure("out", List.of('a'), new BlockBuilder()
                        .print(Add.of(Variable.named('a'), Variable.named('x')))
                        .build()
                )
                .assign('x', Subtract.of(Variable.named('x'), Variable.named('x')))
                .invoke("out", List.of(Variable.named('x')))
                .invoke("out", List.of(Constant.of(100)))
                .build();
        program.execute(new EmptyDebugger());
        assertEquals("0\n100\nx = 0\n", outContent.toString());
    }


}