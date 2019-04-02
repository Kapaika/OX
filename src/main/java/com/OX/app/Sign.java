package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
enum Sign {
    X("X"),
    O("O"),
    N(" ");

    final private String text;

    Sign(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
