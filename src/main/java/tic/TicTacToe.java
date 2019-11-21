package tic;

import tic.game.Manager;
import tic.game.board.Board;
import tic.io.ConsoleIO;
import tic.io.IO;

import java.io.IOException;

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
