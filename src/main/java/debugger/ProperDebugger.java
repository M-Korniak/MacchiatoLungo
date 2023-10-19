package debugger;

import program.ProgramData;

import java.io.IOException;
import java.util.Scanner;

public class ProperDebugger extends Debugger {
    private int howManySteps = -1;
    @Override
    public void debug(ProgramData programData) throws IOException {
        if (howManySteps > 0) {
            howManySteps--;
            return;
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        switch(input) {
            case "c" -> { howManySteps = Integer.MAX_VALUE; }
            case "s" -> { howManySteps = scanner.nextInt() - 1; }
            case "d" -> { programData.printDeeper(scanner.nextInt());
                debug(programData); }
            case "e" -> { System.exit(0); }
            case "m" -> {
                String filePath = scanner.next();
                WriteFile writeFile = new WriteFile(filePath);
                writeFile.writeFile(programData.writeVariable()
                        + programData.writeProcedures());
            }
            default -> {
                System.out.println("Wrong debugger command!");
                System.exit(1);
            }
        }
    }
    public boolean shouldPrintInstruction() {
        return howManySteps == 0;
    }
}
