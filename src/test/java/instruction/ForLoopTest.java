package instruction;

import builder.BlockBuilder;
import builder.ForLoopBuilder;
import builder.ProgramBuilder;
import debugger.EmptyDebugger;
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

class ForLoopTest {
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
    public void ForLoopTest() throws Exception {
        Program program = new ProgramBuilder()
                .forLoop(new ForLoopBuilder('i', Constant.of(2))
                        .print(Variable.named('i'))
                        .build())
                .build();

        program.execute(new EmptyDebugger());
        assertEquals("0\n1\n", outContent.toString());
    }

}