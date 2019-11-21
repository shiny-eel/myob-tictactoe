package tic.game.turn.result;

import tic.game.Manager;
import tic.io.IO;

public abstract class Result {
    public abstract void handle(Manager manager, IO io);
}
