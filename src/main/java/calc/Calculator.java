package calc;

public class Calculator {

    public int add(String numbers) {
        if (numbers.isBlank()) {
            return 0;
        }

        if (numbers.contains("//")) {
            String delimiter = numbers.substring(numbers.indexOf("/"), numbers.indexOf("\n") + 1);
            String removedExtraText = numbers.replace(delimiter, "");
            numbers = removedExtraText;
        }

        //System.out.println(numbers);

        String[] arrayStringNumbers = numbers.split("[, \n;]");
        int[] arrayConvertedNumbers = new int[arrayStringNumbers.length];
        int sum = 0;

        for (int i = 0; i < arrayStringNumbers.length; i++) {
            arrayConvertedNumbers[i] = Integer.parseInt(arrayStringNumbers[i]);
        }

        for (int i = 0; i < arrayConvertedNumbers.length; i++) {
            if (arrayConvertedNumbers[i] < 0) {
                throw new IllegalArgumentException("Negative numbers not allowed: (" + arrayConvertedNumbers[i] + ")");
            }

        }

        for (int i = 0; i < arrayConvertedNumbers.length; i++) {
            sum = sum + arrayConvertedNumbers[i];
        }
        return sum;

    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add("2\n4 -7,5"));
    }
}
