package tic.game.board;

import tic.game.Player;
import tic.io.Displayable;
import tic.io.IO;

import java.util.Arrays;

public class Board implements Displayable {

    private Tile[][] _map;
    private int _rows = 3;
    private int _cols = 3;
    public Board() {
        _map = new Tile[_rows][_cols];
        for (int row = 0; row < _rows; row++) {
            for (int col = 0; col < _cols; col++) {
                _map[row][col] = new Tile();
            }
        }
    }

    boolean place(int row, int col, Player player) {
        _map[row][col].owner = player;

        // Check vertical and horizontals
        if (_map[0][col].owner == _map[1][col].owner
                && _map[0][col].owner == _map[2][col].owner
                || _map[row][0].owner == _map[row][1].owner
                && _map[row][0].owner == _map[row][2].owner)
            return true;

        // Check diagonals
        if (_map[1][1].owner != null &&
                (_map[0][0].owner == _map[1][1].owner
                        && _map[0][0].owner == _map[2][2].owner
                        || _map[2][0].owner == _map[1][1].owner
                        && _map[2][0].owner == _map[0][2].owner))
            return true;
        return false;
    }

    boolean isEmpty(int row, int col) {
        return (_map[row][col].owner == null);
    }

    @Override
    public void display(IO io) {
        String out = "";
        for (int row = 0; row < _rows; row++) {
            for (int col = 0; col < _cols; col++) {
                if (col > 0) out += " ";
                out += _map[row][col];
            }
            out += "\n";
        }
        io.showOutput(out);
    }

}
