package tic.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class MockIO extends IO {
    public String lastOut;
    //    public ArrayDeque<String> outputQueue;
    public String fullOutput = "";
    private ArrayDeque<String> inputQueue;

    public MockIO() {
        inputQueue = new ArrayDeque<>();
//        outputQueue = new ArrayDeque<>();
    }

    public void setFileInput(String filePath) throws IOException {
        File file = new File(filePath);
        _in = new Scanner(file);
    }

    public void queueInput(String line) {
        inputQueue.addLast(line);
    }

    @Override
    public void showOutput(String output) {
        lastOut = output;
        fullOutput += output + "\n";
//        outputQueue.addLast(output);
//        super.showOutput(output);
    }

    @Override
    public String getInput() {
        if (!inputQueue.isEmpty())
            return inputQueue.pollFirst();
        if (_in != null)
            return super.getInput();
        return "MOCK IO HAS NO INPUT SET";
    }
}
