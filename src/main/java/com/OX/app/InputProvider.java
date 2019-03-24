package com.OX.app;

import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
 class InputProvider {

    private Scanner scanner;

    InputProvider(Scanner scanner) {
        this.scanner = scanner;
    }

    int nextInt() {
        return this.scanner.nextInt();
    }

    String nextLine() throws GameInterruptedByUserException {
        do {
            try {
                String input = scanner.nextLine();
                if (input.equals("quit")) {
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
                if (input.equals("quit")) {
                    throw new GameInterruptedByUserException();
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException ignored) {
                System.out.println("Bledne dane");
            }
        } while (true);
    }
}
