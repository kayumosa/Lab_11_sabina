import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine().trim();
            if (input.length() == 0) {
                System.out.println("Input cannot be empty. Try again.");
            }
        } while (input.length() == 0);
        return input;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int value = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine(); // clear buffer
                valid = true;
            } else {
                System.out.println("Invalid number. Try again.");
                pipe.nextLine(); // clear invalid input
            }
        } while (!valid);
        return value;
    }
}

