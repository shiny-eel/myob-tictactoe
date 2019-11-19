package tic;

import tic.game.board.Board;
import tic.io.ConsoleIO;
import tic.io.IO;
import tic.io.MockIO;

import java.io.IOException;

public class TicTacToe {

    public static void main(String[] args) {
        try {
//            new TicTacToe().play(new ConsoleIO());
            new TicTacToe().play(new MockIO("src/main/res/base.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void play(IO io) {
        // Start game
        Board b = new Board();
        for (int i=0; i<5; i++) {
            System.out.println(io.getInput());
            b.display(io);
        }

    }
}
