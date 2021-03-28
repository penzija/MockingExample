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

}