package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String DEFAULT_PATH = System.getProperty("user.home")
            + File.separator
            + "output.txt";

    private Path currentPath = Paths.get(DEFAULT_PATH);

    /**
     * @param newPath new set path
     */
    public final void setFile(final Path newPath) {
        if (Files.exists(newPath)) {
            this.currentPath = newPath;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @return current path
     */
    public final Path getFile() {
        return this.currentPath;
    }

    /**
     * @return string current path
     */
    public final String pathToString() {
        return this.currentPath.toString();
    }

    /**
     * @param strings string to write
     * @throws IOException execption
     */
    public final void writeString(final String... strings) throws IOException {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(currentPath, StandardCharsets.UTF_8))) {
            for (final String string : strings) {
                writer.println(string);
            }
        }
    }
}
