package tic;

import org.junit.jupiter.api.Test;
import tic.game.Manager;
import tic.io.MockIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class E2ETest {
    @Test
    void myobExample() throws IOException {
        testFiles("myob-in.txt", "myob-out.txt");

    }

    @Test
    void printTest() {
        System.out.println("Player {0} enter a coord x,y to place your {1} or enter \'q\' to give up: ");
    }

    private static final String base = "src/test/res/";
    void testFiles(String inputFile, String outputFile) throws IOException {
        MockIO io = new MockIO();
        io.setFileInput(base + inputFile);
        new Manager().begin(io);
        try {
//            Scanner expected = new Scanner(new File(base + outputFile));
//            Scanner actual = new Scanner(io.fullOutput);
            String expected = new String(Files.readAllBytes(Paths.get(base + outputFile)), StandardCharsets.UTF_8);
            String actual = io.fullOutput;

            assertEquals(expected, actual);
//            while (expected.hasNextLine()) {
//                assertEquals(expected.nextLine(), actual.nextLine());
//            }
//            expected.close();
        } catch (FileNotFoundException e) {
            fail();
        }
    }
}