package tic.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tic.game.board.Board;
import tic.game.board.BoardException;
import tic.game.turn.result.*;
import tic.io.MockIO;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {
    Player p1, p2;
    Board board;
    MockIO io;

    @BeforeEach
    void setUp() {
        board = new Board();
        io = new MockIO();
        p1 = new Player("X", 1, board);
        p2 = new Player("O", 2, board);
    }

    @Test
    void LegalMoveTest() {
        io.queueInput("1,1");
        Result result = p1.executeTurn(io);
        assertTrue(result instanceof NextPlayer);
    }

    @Test
    void TakenMoveTest() {
        io.queueInput("1,1");
        io.queueInput("1,1");
        p1.executeTurn(io);
        Result result = p2.executeTurn(io);
        assertTrue(result instanceof RepeatPlayer);
    }

    @Test
    void OutOfBoundsMoveTest() {
        io.queueInput("0,1");
        io.queueInput("1,4");
        Result result = p2.executeTurn(io);
        assertTrue(result instanceof RepeatPlayer);
//        assertTrue((RepeatPlayer)
        result = p1.executeTurn(io);
        assertTrue(result instanceof RepeatPlayer);
    }

    @Test
    void WinMoveTest() {
        io.queueInput("1,1");
        io.queueInput("1,2");
        io.queueInput("1,3");
        p1.executeTurn(io);
        p1.executeTurn(io);
        Result result = p1.executeTurn(io);
        assertTrue(result instanceof Victory);
    }

    @Test
    void DrawMoveTest() throws BoardException {
        board.place(0, 0, p1);
        board.place(0, 1, p2);
        board.place(0, 2, p1);
        board.place(1, 0, p2);
        board.place(1, 1, p1);
        board.place(1, 2, p2);
        board.place(2, 0, p2);
        board.place(2, 1, p1);
        io.queueInput("3,3");
        Result result = p2.executeTurn(io);
        assertTrue(result instanceof Draw);
    }


}