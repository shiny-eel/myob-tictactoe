package tic.io;

import java.io.IOException;
import java.util.Scanner;

public abstract class IO {
    Scanner _in;

    public void showOutput(String output) {
        System.out.println(output);
    }

    public String getInput() {
        return _in.nextLine();
    }

}
