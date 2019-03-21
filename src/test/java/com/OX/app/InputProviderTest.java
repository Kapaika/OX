package com.OX.app;

import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
@Test
public class InputProviderTest {

    @Test
    public void testTheNextLine(){
        InputProvider inputProvider = new InputProvider(new Scanner("Siemanko"));
        String elo = inputProvider.nextLine();
        assert elo.equals("Siemanko");
    }
}
