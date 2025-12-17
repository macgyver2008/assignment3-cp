/*
 * The "Hello Word!" program, just proves you can print to terminal.
 *
 * @author  Yoochan Han
 * @version Beta 0.9
 * @since   2025-12.12
 */
import java.util.InputMismatchException;
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
        try {
            int repeats = scanner.nextInt();
            if (repeats > 0) {
                double answer = catalanCalculate(1, repeats);
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Positive number please");
        }
    }

    /**
     * Calculate catalan number with recursive loops.
     * @param catalNum
     * @param repeats
     * @return answer
     */
    public static double catalanCalculate(
    final double catalNum, final int repeats) {
        double answer;
        int repeat = repeats;
        double number = catalNum;
        if (repeat <= 0) {
        return 0;
        } else {
        answer = factorial(2 * number)
        / factorial(number + 1) / factorial(number);
        System.out.println(number + "'s number: " + answer);
        if (repeat == 1) {
            System.out.println(
                "The " + number + "'s number in Catalan number:" + answer);
        }
        return catalanCalculate(number + 1, repeat - 1);
        }
    }

    /**
     * @param factNum
     * @return number
     */
    public static double factorial(final double factNum) {
        double number = factNum;
        double answer = 0;
        if (number <= 0) {
            System.out.print("wrong number for factorial");
        } else if (number == 1) {
            answer = 1;
        } else {
            answer = number * factorial(number - 1);
            // System.out.println("factorial: " + answer);
        }
        return answer;
    }
}
