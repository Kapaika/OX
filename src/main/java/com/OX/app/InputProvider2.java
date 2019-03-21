package com.OX.app;

import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
public class InputProvider2 {

    private Scanner scanner;

    public InputProvider2() {
    }

    public InputProvider2(Scanner scanner) {
        this.scanner = scanner;
    }

    int nextInt() {
        return this.scanner.nextInt();
    }
    String nextLine() {
        return this.scanner.nextLine();
    }
}
