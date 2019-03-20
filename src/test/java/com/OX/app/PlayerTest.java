package com.OX.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Bartosz Kupajski
 */
@Test
public class PlayerTest {

    public void createPlayerTest(){
        Player playerX = new Player("Bartosz");
        Player playerO = new Player("Milosz");
        Assert.assertNotEquals(playerO,playerX);
    }

    public void testCheckingTheCorrectnessOfPlayerSignsX(){
        Player playerX = new Player("Bartosz");
        playerX.setSign(Sign.O);
        assert playerX.sign == Sign.O;
    }

    @DataProvider
    public Object[][] numberOfChangingSignMethodsAndSignResult(){
        return new Object[][]{
                {1,Sign.O,Sign.X},
                {2,Sign.O,Sign.O},
                {3,Sign.O,Sign.X},
                {1,Sign.X,Sign.O},
                {2,Sign.O,Sign.O},
                {3,Sign.O,Sign.X},
        };
    }


}
