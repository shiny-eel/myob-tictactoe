package tic.game.turn.result;

import tic.game.Manager;
import tic.io.IO;

public class NextPlayer extends Result {
    private static String ACCEPT_MSG = "Move accepted, here's the current board:\n";
    @Override
    public void handle(Manager manager, IO io) {
        io.showOutput(ACCEPT_MSG);
        manager.displayGame();
        manager.nextPlayer();
        manager.nextTurn();
    }
}
