package tic.game.board;

import tic.game.Player;
import tic.io.Displayable;
import tic.io.IO;

/**
 * Represents the 3x3 tictactoe grid.
 * Has the responsibility of holding the state of the board.
 */
public class Board implements Displayable {

    private Tile[][] _map;
    private int _rows = 3;
    private int _cols = 3;
    private static final String BAD_COORD = "Coordinate does not exist on board.";

    public Board() {
        _map = new Tile[_rows][_cols];
        for (int row = 0; row < _rows; row++) {
            for (int col = 0; col < _cols; col++) {
                _map[row][col] = new Tile();
            }
        }
    }

    /**
     * Method to place a player's symbol upon the board.
     * @param row the index 0 row coord
     * @param col the index 0 column coord
     * @param player the player attempting to place a symbol
     * @return a boolean - TRUE if the the win condition has been met.
     *      FALSE otherwise.
     * @throws BoardException when row and col out of bounds.
     */
    public boolean place(int row, int col, Player player) throws BoardException {
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
            throw new BoardException(BAD_COORD);
        }
        return false;
    }

    public boolean isFull() {
        for (int row = 0; row < _rows; row++) {
            for (int col = 0; col < _cols; col++) {
                if (_map[row][col].owner == null)
                    return false;
            }
        }
        return true;
    }

    public boolean isEmpty(int row, int col) throws BoardException {
        try {
            return (_map[row][col].owner == null);
        } catch (IndexOutOfBoundsException e) {
            throw new BoardException(BAD_COORD);
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
            throw new BoardException(BAD_COORD);
        }
    }
}
