package tic.game.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tic.game.Player;
import tic.io.MockIO;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    private Board board;
    private MockIO io;
    private Player p1, p2;

    @BeforeEach
    public void setUp() throws IOException {
        board = new Board();
        p1 = new Player("X", 1, board);
        p2 = new Player("O", 2, board);
        io = new MockIO();
    }

    @Test
    public void emptyBoard() {
        board.display(io);
        String empty = ". . .\n" +
                ". . .\n" +
                ". . .\n";
        assertEquals(empty, io.lastOut);
    }

    @Test
    public void populateBoard() throws BoardException {
        board.place(0, 0, p1);
        board.display(io);
        String expected = "X . .\n" +
                ". . .\n" +
                ". . .\n";
        assertEquals(expected, io.lastOut);

        board.place(2, 2, p2);
        board.display(io);
        expected = "X . .\n" +
                ". . .\n" +
                ". . O\n";
        assertEquals(expected, io.lastOut);
    }

    @Test
    public void testHorizontalWinCondition() throws BoardException {
        boolean result;
        result = board.place(0, 0, p1);
        assertEquals(false, result);
        result = board.place(0, 1, p1);
        assertEquals(false, result);
        result = board.place(0, 2, p1);
        assertEquals(true, result);
    }

    @Test
    public void testVerticalWinCondition() throws BoardException {
        boolean result;
        result = board.place(0, 1, p2);
        assertEquals(false, result);
        result = board.place(1, 1, p2);
        assertEquals(false, result);
        result = board.place(2, 1, p2);
        assertEquals(true, result);
    }

    @Test
    public void testDiagonalWinConditionA() throws BoardException {
        boolean result;
        result = board.place(2, 0, p1);
        assertEquals(false, result);
        result = board.place(1, 1, p1);
        assertEquals(false, result);
        result = board.place(0, 2, p1);
        assertEquals(true, result);
    }

    @Test
    public void testDiagonalWinConditionB() throws BoardException {
        boolean result;
        result = board.place(0, 0, p1);
        assertEquals(false, result);
        result = board.place(1, 1, p1);
        assertEquals(false, result);
        result = board.place(2, 2, p1);
        assertEquals(true, result);
    }
}