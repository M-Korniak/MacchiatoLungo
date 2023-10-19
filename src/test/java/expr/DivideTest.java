package expr;

import builder.BlockBuilder;
import builder.ProgramBuilder;
import builder.list.List;
import debugger.EmptyDebugger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import program.Program;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {
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
    public void divideTest() throws Exception {
        Program program = new ProgramBuilder()
                .declareVariable('x', Divide.of(Constant.of(6), Constant.of(2)))
                .build();
        program.execute(new EmptyDebugger());
        assertEquals("x = 3\n", outContent.toString());
    }
}