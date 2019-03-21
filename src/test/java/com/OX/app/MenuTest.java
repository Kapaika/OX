package com.OX.app;

import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
@Test
public class MenuTest {

    @Test
    public void firstMenuTest(){
        InputProvider inputProvider = new InputProvider(new Scanner("bartosz\ntomasz\n3\n3\n3\nbartosz\n0\n0\n0\n1\n1\n1\n0\n2\n2\n2\n0\n0\n0\n1\n1\n1\n0\n2\n2\n2\n0\n0\n0\n1\n1\n1\n0\n2\n2\n2"));
        Menu menu = new Menu(inputProvider);
        menu.start();
    }
}
