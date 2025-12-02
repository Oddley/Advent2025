package Day1Test;

import Day1.Dial;
import Day1.Rotation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DialTest extends Day1.Dial {

    private static final Dial dial = new Dial();
    private static final Rotation leftZero = new Rotation(Rotation.Directions.Left, 0);
    private static final Rotation leftOne = new Rotation(Rotation.Directions.Left, 1);
    private static final Rotation rightZero = new Rotation(Rotation.Directions.Right, 0);
    private static final Rotation rightOne = new Rotation(Rotation.Directions.Right, 1);

    @Test
    void rotateZero() {
        var value = 5;
        assertAll(
                ()->assertEquals(value, dial.Rotate(value, rightZero)),
                ()->assertEquals(value, dial.Rotate(value, leftZero))
        );
    }

    @Test
    void rotateOne() {
        var start = 5;
        assertAll(
                ()->assertEquals(6, dial.Rotate(start, rightOne)),
                ()->assertEquals(4, dial.Rotate(start, leftOne))
        );
    }

    @Test
    void rotateToZero() {
        assertAll(
                ()->assertEquals(0, dial.Rotate(99, rightOne)),
                ()->assertEquals(0, dial.Rotate(1, leftOne))
        );
    }

    @Test
    void rotateToNintyNine()
    {
        assertAll(
                ()->assertEquals(99, dial.Rotate(98, rightOne)),
                ()->assertEquals(99, dial.Rotate(0, leftOne))
        );
    }

    @Test
    void rotateOneHundredOne()
    {
        assertAll(
                ()->assertEquals(6, dial.Rotate(5, new Rotation(Rotation.Directions.Right, 101))),
                ()->assertEquals(4, dial.Rotate(5, new Rotation(Rotation.Directions.Left, 101)))
        );
    }

    @Test
    void rotateFiveHundred()
    {
        assertAll(
                ()->assertEquals(5, dial.Rotate(5, new Rotation(Rotation.Directions.Right, 500))),
                ()->assertEquals(5, dial.Rotate(5, new Rotation(Rotation.Directions.Left, 500)))
        );
    }

    @Test
    void wrapZero()
    {
        assertAll(
                ()->assertEquals(0, dial.GetZeroTouchCount(5, rightOne)),
                ()->assertEquals(0, dial.GetZeroTouchCount(5, leftOne))
        );
    }

    @Test
    void wrapShortStartingZero()
    {
        assertAll(
                ()->assertEquals(0, dial.GetZeroTouchCount(0, rightOne)),
                ()->assertEquals(0, dial.GetZeroTouchCount(0, leftOne))
        );
    }

    @Test
    void wrapShortStartingNinteyNine()
    {
        assertAll(
                ()->assertEquals(1, dial.GetZeroTouchCount(99, rightOne)),
                ()->assertEquals(0, dial.GetZeroTouchCount(99, leftOne))
        );
    }

    @Test
    void wrapOneHundred()
    {
        assertAll(
                ()->assertEquals(1, dial.GetZeroTouchCount(5, new Rotation(Rotation.Directions.Right, 100))),
                ()->assertEquals(1, dial.GetZeroTouchCount(5, new Rotation(Rotation.Directions.Left, 100)))
        );
    }

    @Test
    void wrapOneHundredStartingZero()
    {
        assertAll(
                ()->assertEquals(1, dial.GetZeroTouchCount(0, new Rotation(Rotation.Directions.Right, 100))),
                ()->assertEquals(1, dial.GetZeroTouchCount(0, new Rotation(Rotation.Directions.Left, 100)))
        );
    }

    @Test
    void wrapFiveHundred()
    {
        assertAll(
                ()->assertEquals(5, dial.GetZeroTouchCount(5, new Rotation(Rotation.Directions.Right, 500))),
                ()->assertEquals(5, dial.GetZeroTouchCount(5, new Rotation(Rotation.Directions.Left, 500)))
        );
    }

    @Test
    void wrapLeftToZero()
    {
        assertEquals(2, dial.GetZeroTouchCount(1, new Rotation(Rotation.Directions.Left, 101)));
    }
}