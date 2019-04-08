package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
public class ConsoleOutput implements Output {

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayError(String error) {
        System.err.println(error);
    }
}
