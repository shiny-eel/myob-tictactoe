package tic.io;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MockIO extends IO {
    public String lastOut;

    public MockIO(String filePath) throws IOException {
        File file = new File(filePath);
        _in = new Scanner(file);
    }

    @Override
    public void showOutput(String output) {
        lastOut = output;
        super.showOutput(output);
    }

    //    @Override
//    public String getInput() {
//        return "Fake";
//    }
}
