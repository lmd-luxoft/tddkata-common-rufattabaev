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

    @Test
    public void testThreeArgs() {
        Calc calc = new Calc();
        int actual = calc.sum("1,2,3");
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void testNull() {
        Calc calc = new Calc();
        int actual = calc.sum(null);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void testNewLineAllowedAsDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("1\n2");
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testNewLineAndCommaAllowedAsDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("1\n2,3");
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void testOneDelimiterNextToAnother() {
        Calc calc = new Calc();
        int actual = calc.sum("1,\n2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void testCustomDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("//;\n1;2");
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testWrongCustomDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("//;\n1,2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void testWrongDeclarationCustomDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("/;\n1;2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void testNewLineMissedWhileDeclarationCustomDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("//;1;2");
        int expected = -1;
        assertEquals(expected, actual);
    }
}
