/*
 * The "Hello Word!" program, just proves you can print to terminal.
 *
 * @author  Yoochan Han
 * @version Beta 0.9
 * @since   2025-12.12
 */
import java.util.Scanner;
/**
 * This is the standard "Hello, World!" program.
 */
public final class CatalanNumber {
    
    // final
    /**
     * Prevent instantiation.
     * Throw an exception IllegalStateException.
     * if this is ever called
     *
     * @throws IllegalStateException if this is ever called
     *
     */
    private CatalanNumber() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * The starting main() function.
     *
     * @param args No args will be used
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeats = scanner.nextInt();
        double answer = catalanCalculate(1, repeats);
        System.out.println("The answer: " + answer);
    }

    public static double catalanCalculate(double catalNum, int repeats) {
        double answer;
        int repeat = repeats;
        double number = catalNum;
        if (repeat <= 0) {
        return 0;
        } else {
        answer = factorial(2 * number) / factorial(number + 1) /factorial(number);
        System.out.println(repeats + "'s number: " + answer);
        // return catalanCalculate(number++, repeat--);
        return catalanCalculate(number++, repeat--);
        }
    }

    /**
     * @param factNum
     * @return number
     */
    public static double factorial(double factNum) {
        double number = factNum;
        double asnwer = 0;
        if (number <=0) {
            System.out.print("wrong number for factorial");
        } else if (number == 1) {
            asnwer = 1;
        } else {
            asnwer = number * factorial(number - 1);
            // System.out.println("factorial: " + asnwer);
        }
        return asnwer;
    }
}
