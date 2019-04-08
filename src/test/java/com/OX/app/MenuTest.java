package com.OX.app;

import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
@Test
public class MenuTest {

    @Test
    public void threeOnThreeGame(){
        InputProvider inputProvider = new InputProvider(new Scanner("1\nb\nk\n3\n3\n3\nb\n" +
                "0\n0\n0\n1\n1\n1\n0\n2\n2\n2\n" +
                "0\n0\n0\n1\n1\n1\n0\n2\n2\n2\n" +
                "0\n0\n0\n1\n1\n1\n0\n2\n2\n2\n"));
        Menu menu = new Menu(inputProvider);
        menu.start();
    }

    @Test
    public void threeOnThreeGameExcpetionsHandled(){
        InputProvider inputProvider = new InputProvider(new Scanner("1\nb\nk\n2\n2\n3\n3\n2\n3\nG\nb\n0\n0\n0\n0\n0\n1\n8\n8\n" +
                "1\n1\n0\n2\n2\n2\n0\n0\n0\n1\n1\n1\n0\n2\n2\n2\n" +
                "0\n0\n0\n1\n1\n1\n0\n2\n2\n2\n"));
        Menu menu = new Menu(inputProvider);
        menu.start();
    }
}
