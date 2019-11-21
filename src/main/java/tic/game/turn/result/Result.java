package tic.game.turn.result;

import tic.game.Manager;
import tic.io.IO;

/**
 * Represents any possible 'result' of a move in the tictactoe game.
 * Has the responsibility of calling the manager and IO to deal with the result.
 */
public abstract class Result {
    public abstract void handle(Manager manager, IO io);
}
