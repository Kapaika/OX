package com.OX.app;

import java.io.PrintStream;

/**
 * @author Bartosz Kupajski
 */
public class Output {

    private final PrintStream printStream;

    public Output(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print(String text) {
        printStream.println(text);
    }
}
