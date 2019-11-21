package tic.game.turn.result;

import tic.game.Manager;
import tic.io.IO;

public class Victory extends Result {
    @Override
    public void handle(Manager manager, IO io) {
        io.showOutput("VICTORY!"); // TODO
        manager.displayGame();
    }
}
