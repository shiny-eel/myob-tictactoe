package tic.game.board;

import tic.game.Player;

public class Tile {
    protected Player owner;

    @Override
    public String toString() {
        if (owner != null)
            return owner.getSymbol();
        return ".";
    }
}
