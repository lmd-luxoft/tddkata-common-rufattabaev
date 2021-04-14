import org.junit.jupiter.api.Test;
import tddkata.Calc;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void testEmptyString() {
        Calc calc = new Calc();
        int actual = calc.sum("");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void testOneArg() {
        Calc calc = new Calc();
        int actual = calc.sum("1");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void testZeroPlusZero() {
        Calc calc = new Calc();
        int actual = calc.sum("0,0");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void testZeroPlusOne() {
        Calc calc = new Calc();
        int actual = calc.sum("0,1");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void testOnePlusOne() {
        Calc calc = new Calc();
        int actual = calc.sum("1,1");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void testOnePlusTwo() {
        Calc calc = new Calc();
        int actual = calc.sum("1,2");
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void testTwoPlusTwo() {
        Calc calc = new Calc();
        int actual = calc.sum("2,2");
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void testDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("2;2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void testIllegalArg() {
        Calc calc = new Calc();
        int actual = calc.sum("incorrect arg");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void testThreeArgs() {
        Calc calc = new Calc();
        int actual = calc.sum("1,2,3");
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void testNull() {
        Calc calc = new Calc();
        int actual = calc.sum(null);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void testNewLineAllowedAsDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("1\n2");
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void testNewLineAndCommaAllowedAsDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("1\n2,3");
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void testOneDelimiterNextToAnother() {
        Calc calc = new Calc();
        int actual = calc.sum("1,\n2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void testCustomDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("//;\n1;2");
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void testWrongCustomDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("//;\n1,2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void testWrongDeclarationCustomDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("/;\n1;2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void testNewLineMissedWhileDeclarationCustomDelimiter() {
        Calc calc = new Calc();
        int actual = calc.sum("//;1;2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void testNegativeValuesThrowsException() {
        Calc calc = new Calc();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.sum("-1,-2,3"));
        String expected = "negatives not allowed [-1,-2]";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void testNegativeValuesWithCustomDelimiterThrowsException() {
        Calc calc = new Calc();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.sum("//;\n-4;-5;6"));
        String expected = "negatives not allowed [-4,-5]";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }
}
