package instruction;

import builder.BlockBuilder;
import builder.ProgramBuilder;
import builder.list.List;
import debugger.EmptyDebugger;
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

class BlockTest {
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
    public void BlockTest() throws Exception {
        Program program = new ProgramBuilder()
                .declareVariable('x', Constant.of(101))
                .declareVariable('y', Constant.of(1))
                .assign('x', Subtract.of(Variable.named('x'), Variable.named('y')))
                .block(new BlockBuilder()
                        .declareVariable('x', Constant.of(10))
                        .print(Variable.named('x'))
                        .build()
                )
                .build();
        program.execute(new EmptyDebugger());
        assertEquals("10\nx = 100\ny = 1\n", outContent.toString());
    }


}