package com.OX.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;


/**
 * @author Bartosz Kupajski
 */
@Test
public class InputProviderTest {

    @Test(expectedExceptions = GameInterruptedByUserException.class)
    public void inputProviderQuitTestFromNextLine() throws GameInterruptedByUserException {
        Scanner scanner = new Scanner("q");
        InputProvider inputProvider = new InputProvider(scanner);
        inputProvider.nextLine();
    }

    @Test(expectedExceptions = GameInterruptedByUserException.class)
    public void inputProviderQuitTestFromNextIntFromUser() throws GameInterruptedByUserException {
        Scanner scanner = new Scanner("q");
        InputProvider inputProvider = new InputProvider(scanner);
        inputProvider.getIntFromUser();
    }

    @Test
    public void inputProviderWrongDataChecker() throws GameInterruptedByUserException {
        Scanner scanner = new Scanner("ELO\nELO\n2");
        InputProvider inputProvider = new InputProvider(scanner);
        int result = inputProvider.getIntFromUser();
        Assert.assertEquals(result,2);
    }
}
