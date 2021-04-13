import org.junit.jupiter.api.Test;
import tddkata.Calc;

import static org.junit.jupiter.api.Assertions.*;

public class CalcTest {

    @Test
    public void testEmptyString() {
        Calc calc = new Calc();
        int actual = calc.sum("");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testOneArg() {
        Calc calc = new Calc();
        int actual = calc.sum("1");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testZeroPlusZero() {
        Calc calc = new Calc();
        int actual = calc.sum("0,0");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testZeroPlusOne() {
        Calc calc = new Calc();
        int actual = calc.sum("0,1");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testOnePlusOne() {
        Calc calc = new Calc();
        int actual = calc.sum("1,1");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void testOnePlusTwo() {
        Calc calc = new Calc();
        int actual = calc.sum("1,2");
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testTwoPlusTwo() {
        Calc calc = new Calc();
        int actual = calc.sum("2,2");
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void testDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("2;2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void testIllegalArg() {
        Calc calc = new Calc();
        int actual = calc.sum("incorrect arg");
        int expected = -1;
        assertEquals(expected, actual);
    }
}
