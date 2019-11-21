package tic;

import org.junit.jupiter.api.Test;
import tic.game.Manager;
import tic.io.MockIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class E2ETest {
    @Test
    void myobExample() throws IOException {
        testFiles("myob-in.txt", "myob-out.txt");

    }

    private static final String base = "src/test/res/";

    void testFiles(String inputFile, String outputFile) throws IOException {
        MockIO io = new MockIO();
        io.setFileInput(base + inputFile);
        new Manager().begin(io);
        try {
            String expected = Files.readString(Paths.get(base + outputFile));
            String actual = io.fullOutput;

            assertEquals(expected, actual);
        } catch (FileNotFoundException e) {
            fail();
        }
    }
}