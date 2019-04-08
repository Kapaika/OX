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

    String nextLine() {
        return this.scanner.nextLine();
    }
}
