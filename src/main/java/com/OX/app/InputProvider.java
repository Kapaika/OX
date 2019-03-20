package com.OX.app;

import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
public class InputProvider {

    private static final Scanner inputProvider = new Scanner(System.in);

    public static int nextInt() {
        return inputProvider.nextInt();
    }

}