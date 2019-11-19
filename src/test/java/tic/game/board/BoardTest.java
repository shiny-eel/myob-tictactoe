package tic.game.board;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tic.game.Player;
import tic.io.IO;
import tic.io.MockIO;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private MockIO io;
    private Player p1, p2;


    @BeforeEach
    public void setUp() throws IOException {
        p1 = new Player("X");
        p2 = new Player("O");
        board = new Board();
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
    public void populateBoard() {
        board.place(0,0, p1);
        board.display(io);
        String expected = "X . .\n" +
                ". . .\n" +
                ". . .\n";
        assertEquals(expected, io.lastOut);

        board.place(2,2, p2);
        board.display(io);
        expected = "X . .\n" +
                ". . .\n" +
                ". . O\n";
        assertEquals(expected, io.lastOut);
    }
}