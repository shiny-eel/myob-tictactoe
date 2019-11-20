package tic.game.board;

import tic.game.Player;
import tic.io.Displayable;
import tic.io.IO;

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

    boolean place(int row, int col, Player player) throws BoardException {
        try {
            _map[row][col].owner = player;

            // Check vertical and horizontals
            if (matches(0, col, 1, col)
                    && matches(0, col, 2, col)
                    || matches(row, 0, row, 1)
                    && matches(row, 0, row, 2))
                return true;

            // Check diagonals
            if (matches(0, 0, 1, 1)
                    && matches(0, 0, 2, 2)
                    || matches(2, 0, 1, 1)
                    && matches(2, 0, 0, 2))
                return true;
        } catch (IndexOutOfBoundsException e) {
            throw new BoardException("Coordinate does not exist on board.");
        }

        return false;
    }

    boolean isEmpty(int row, int col) throws BoardException {
        try {
            return (_map[row][col].owner == null);
        } catch (IndexOutOfBoundsException e) {
            throw new BoardException("Coordinate does not exist on board.");
        }
    }

    @Override
    public void display(IO io) {
        StringBuilder out = new StringBuilder();
        for (int row = 0; row < _rows; row++) {
            for (int col = 0; col < _cols; col++) {
                if (col > 0) out.append(" ");
                out.append(_map[row][col]);
            }
            out.append("\n");
        }
        io.showOutput(out.toString());
    }

    private boolean matches(int r1, int c1, int r2, int c2) throws BoardException {
        try {
            if (_map[r1][c1].owner == null)
                return false;
        return _map[r1][c1].owner == _map[r2][c2].owner;
        } catch (IndexOutOfBoundsException e) {
            throw new BoardException("Coordinate does not exist on board.");
        }
    }
}
