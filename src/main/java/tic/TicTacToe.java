package tic;

import tic.game.Manager;
import tic.io.ConsoleIO;
import tic.io.IO;

public class TicTacToe {

    public static void main(String[] args) {
        new TicTacToe().play(new ConsoleIO());
//            new TicTacToe().play(new MockIO("src/main/res/base.txt"));
    }

    void play(IO io) {
        // Start game
        new Manager().begin(io);

//        }

    }
}
