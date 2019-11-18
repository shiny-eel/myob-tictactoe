package tic.io;

import java.io.IOException;
import java.util.Scanner;

public abstract class IO {
    Scanner _in;

    public String getInput() {
        return _in.nextLine();
    }
}
