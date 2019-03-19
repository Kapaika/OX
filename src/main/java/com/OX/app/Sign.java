package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
public enum Sign {
    X("X"),
    O("O"),
    N(" ");

    private String text;

    Sign(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
