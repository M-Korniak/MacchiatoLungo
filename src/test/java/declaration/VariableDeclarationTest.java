package declaration;

import builder.BlockBuilder;
import builder.ProgramBuilder;
import builder.list.List;
import debugger.EmptyDebugger;
import expr.Add;
import expr.Constant;
import expr.Variable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import program.Program;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class VariableDeclarationTest {
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
    public void VariableDeclarationTest() throws Exception {
        Program program = new ProgramBuilder()
                .declareVariable('x', Constant.of(90))
                .declareProcedure("out", List.of('a'), new BlockBuilder()
                        .print(Add.of(Variable.named('a'), Variable.named('x')))
                        .build()
                )
                .invoke("out", List.of(Constant.of(100)))
                .build();
        program.execute(new EmptyDebugger());
        assertEquals("190\nx = 90\n", outContent.toString());
    }
}