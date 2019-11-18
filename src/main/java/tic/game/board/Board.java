package tic.game.board;

import tic.io.Displayable;
import tic.io.IO;

public class Board implements Displayable {
    @Override
    public void display(IO io) {
        io.showOutput("THIS IS THE BOARD");
    }
}
