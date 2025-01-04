package util;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    public static double getDouble(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }
}
