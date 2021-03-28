package calc;

import org.junit.jupiter.api.Test;

import java.util.IllegalFormatException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void sumTwoNumbers() {
        Calculator calc = new Calculator();
        int actualSum = calc.add("3,5");

        assertEquals(8, actualSum);
    }

    @Test
    void noTextInserted() {
        Calculator calc = new Calculator();
        int actualSum = calc.add("");

        assertEquals(0, actualSum);
    }

    @Test
    void sumOfManyNumbers() {
        Calculator calculator = new Calculator();
        int actualSum = calculator.add("2,1,7,5");

        assertEquals(15, actualSum);
    }

    @Test
    void sumNumbersWithSpacesAndCommas() {
        Calculator calculator = new Calculator();
        int actualSum = calculator.add("2,11 7 5");

        assertEquals(25, actualSum);
    }

    @Test
    void sumNumbersWithMoreExtraSigns() {
        Calculator calculator = new Calculator();

        int actualSum = calculator.add("2\n4 7,5");

        assertEquals(18, actualSum);
    }

    @Test
    void inputWithManyNonNumbersOnBeginning() {
        Calculator calculator = new Calculator();

        int actualSum = calculator.add("3,//&%$#&$\n4 7;5");

        assertEquals(19, actualSum);
    }

    @Test
    void exceptionOnNegativeNumber() {
        Calculator calculator = new Calculator();

        assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,3"));
    }

    @Test
    void inputNumberBiggerThan1000() {
        Calculator calculator = new Calculator();

        int actualSum = calculator.add("1001,//&%$#&$\n4 7;5");

        assertEquals(16, actualSum);
    }
}