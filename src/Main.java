//
//  Main.java
//  Calculator
//
//  Created by Nodirbek Kadamov on 11/24/24.
//

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println(input + " = " + result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter integers with spacing.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Please enter your numbers with spacing between them" );
        }
    }

    public static String calc(String input) {
        String[] values = input.split(" ");
        if (values.length != 3) {
            throw new IllegalArgumentException("Error: Input must be in the format '<number> <operator> <number>'.");
        }
        int a = Integer.parseInt(values[0]);
        String operator = values[1];
        int b = Integer.parseInt(values[2]);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Error: input value is not in range: 1 - 10");
        }

        int result = switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Error: Unsupported operator: " + operator);
        };

        return String.valueOf(result);
    }
}