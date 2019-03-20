package com.OX.app;

import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * @author Bartosz Kupajski
 */
@Test
public class GameRulesTest {

    public void testCreationGameRulesTest(){
        GameRules gameRules = new GameRules();
    }

    public void testGameSize() {
        GameRules gameRules = new GameRules();
        gameRules.setSizeOfABoard(5, 6);

        assert gameRules.sizeOfABoard.y==6;
    }
}
