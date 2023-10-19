package debugger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteFile {
    private String pathToFile;
    Path path;
    public WriteFile(String pathToFile) {
        this.pathToFile = pathToFile;
        path = Paths.get(pathToFile);
    }

    public void writeFile(String content) throws IOException {
        try {
            Files.writeString(path, content);
        } catch(Exception e) {
            System.out.println("Wrong path!");
            System.exit(1);
        }
    }
}
