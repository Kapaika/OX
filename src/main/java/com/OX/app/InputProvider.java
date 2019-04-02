package com.OX.app;

import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
 class InputProvider {

    final private Scanner scanner;

    InputProvider(Scanner scanner) {
        this.scanner = scanner;
    }

    String nextLine() throws GameInterruptedByUserException {
        do {
            try {
                String input = scanner.nextLine();
                if (input.equals("q")) {
                    throw new GameInterruptedByUserException();
                }
                return input;
            } catch (NumberFormatException ignored) {
                System.out.println("Bledne dane");
            }
        } while (true);
    }

    int getIntFromUser() throws GameInterruptedByUserException {
        do {
            try {
                String input = scanner.nextLine();
                if (input.equals("q")) {
                    throw new GameInterruptedByUserException();
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException ignored) {
                System.out.println("Bledne dane");
            }
        } while (true);
    }
}
