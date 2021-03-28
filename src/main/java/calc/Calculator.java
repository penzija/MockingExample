package calc;

public class Calculator {

    public int add(String numbers) {

        String[] arrayStringNumbers = numbers.split(",");
        int[] arrayConvertedNumbers = new int[arrayStringNumbers.length];
        int sum = 0;

        for (int i = 0; i < arrayStringNumbers.length; i++) {
            arrayConvertedNumbers[i] = Integer.parseInt(arrayStringNumbers[i]);
        }

        for (int i = 0; i < arrayConvertedNumbers.length; i++) {
            sum = sum + arrayConvertedNumbers[i];

        }
        return sum;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add("1,7,3"));
    }


}
