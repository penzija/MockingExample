package calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void sumTwoNumbers() {
        Calculator calc = new Calculator();
        int actualSum = calc.add("3,5");

        assertEquals(8, actualSum);
    }

    @Test
    void sumManyNumbers() {
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


}