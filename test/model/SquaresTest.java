package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquaresTest {
    private Squares OneByOne;
    private Squares TwoByTwo;
    private Squares ThreeByThree;
    private Squares FourByFour;

    @BeforeEach
    void runBefore() {
        OneByOne = new Squares(1, 1);
        TwoByTwo = new Squares(2, 2);
        ThreeByThree = new Squares(3, 3);
        ThreeByThree.toggleValue(0, 0);
        ThreeByThree.toggleValue(1, 1);
        ThreeByThree.toggleValue(1, 2);
        ThreeByThree.toggleValue(2, 2);
        FourByFour = new Squares(4, 4);
        FourByFour.toggleValue(1, 0);  //Setting up FourByFour to model a simple glider
        FourByFour.toggleValue(0, 2);
        FourByFour.toggleValue(1, 2);
        FourByFour.toggleValue(2, 2);
        FourByFour.toggleValue(2, 1);
    }

    //Tests Constructor & Getter and Setter Methods (intrinsically)
    @Test
    void testSquares() {
        assertEquals("0 \n", OneByOne.toString());
        assertEquals("0 0 \n0 0 \n", TwoByTwo.toString());
        assertEquals("1 0 0 \n0 1 1 \n0 0 1 \n", ThreeByThree.toString());
    }

    @Test
    void testNextGen() {
        ThreeByThree.nextGen();
        assertEquals("0 1 0 \n0 1 1 \n0 1 1 \n", ThreeByThree.toString());
    }

    @Test
    void testIsLonely() {
        assertEquals(false, ThreeByThree.kill(1, 1));
        assertEquals(true, ThreeByThree.kill(0, 0));
    }

    @Test
    void testIsOverpopulated() {
        FourByFour.toggleValue(1, 1);
        assertEquals(true, FourByFour.kill(1, 1));
        assertEquals(false, FourByFour.kill(0, 2));
    }

    @Test
    void testMakeNew() {
        assertEquals(true, FourByFour.makeNew(0, 1));
        assertEquals(false, FourByFour.makeNew(0,0));
    }

    @Test
    void testAliveNeighbours() {
        assertEquals(1, FourByFour.aliveNeighbours(0,0));
        assertEquals(5, FourByFour.aliveNeighbours(1, 1));
        FourByFour.toggleValue(1, 1);  //Testing that the cell itself is not counted as a neighbour
        assertEquals(5, FourByFour.aliveNeighbours(1, 1));
    }

    //This test is implemented to test the full range of motion of a simple repeating pattern that should exist in the
    //traditional representation of the game of life.
    @Test
    void testBasicGlider() {
        assertEquals("0 0 1 0 \n1 0 1 0 \n0 1 1 0 \n0 0 0 0 \n", FourByFour.toString());
        FourByFour.nextGen();
        assertEquals("0 1 0 0 \n0 0 1 1 \n0 1 1 0 \n0 0 0 0 \n", FourByFour.toString());
        FourByFour.nextGen();
        assertEquals("0 0 1 0 \n0 0 0 1 \n0 1 1 1 \n0 0 0 0 \n", FourByFour.toString());
        FourByFour.nextGen();
        assertEquals("0 0 0 0 \n0 1 0 1 \n0 0 1 1 \n0 0 1 0 \n", FourByFour.toString());
        FourByFour.nextGen();
        assertEquals("0 0 0 0 \n0 0 0 1 \n0 1 0 1 \n0 0 1 1 \n", FourByFour.toString());
    }

}
