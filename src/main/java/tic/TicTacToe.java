package tic;

import tic.game.Manager;
import tic.io.ConsoleIO;
import tic.io.IO;

public class TicTacToe {

    /**
     * Entry into the game.
     * @param args: No arguments are required for this program.
     */
    public static void main(String[] args) {
        new TicTacToe().play(new ConsoleIO());
    }

    void play(IO io) {
        new Manager().begin(io);
    }
}
