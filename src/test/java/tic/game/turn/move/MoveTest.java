package tic.game.turn.move;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tic.game.Manager;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {
    PlaceMove placeMove;
    QuitMove quitMove;
    Manager manager;

    @BeforeEach
    void setUp() {
        placeMove = new PlaceMove(manager);
        quitMove = new QuitMove(manager);

    }

    @Test
    void testPlaceMoveRegex() {
        String input = "1,2";
        assertTrue(placeMove.matches(input));

        input = "0,2";
        assertFalse(placeMove.matches(input));

        input = "2,0";
        assertFalse(placeMove.matches(input));

        input = "0,4";
        assertFalse(placeMove.matches(input));

        input = "q";
        assertFalse(placeMove.matches(input));
    }

    @Test
    void testQuitMoveRegex() {
        String input = "q";
        assertTrue(quitMove.matches(input));

        input = "1,2";
        assertFalse(quitMove.matches(input));

        input = "";
        assertFalse(quitMove.matches(input));

        input = " ";
        assertFalse(quitMove.matches(input));
    }
}