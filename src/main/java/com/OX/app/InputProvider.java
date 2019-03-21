package com.OX.app;

import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
 class InputProvider {

    private static final Scanner inputProvider = new Scanner(System.in);

    static int nextInt() {
        return inputProvider.nextInt();
    }
    static String nextLine() {
        return inputProvider.nextLine();
    }

}