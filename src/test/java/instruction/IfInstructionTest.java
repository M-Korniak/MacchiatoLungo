package instruction;

import builder.ForLoopBuilder;
import builder.IfInstructionBuilder;
import builder.ProgramBuilder;
import debugger.EmptyDebugger;
import expr.Constant;
import expr.Variable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import program.Program;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class IfInstructionTest {
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
    public void IfInstructionTest() throws Exception {
        Program program = new ProgramBuilder()
                .declareVariable('a', Constant.of(0))
                .ifInstruction(new IfInstructionBuilder(Constant.of(0), "<", Constant.of(1))
                        .assign('a', Constant.of(1))
                        .build())
                .build();

        program.execute(new EmptyDebugger());
        assertEquals("a = 1\n", outContent.toString());
    }

}