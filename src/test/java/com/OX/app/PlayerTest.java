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
        playerX.setState();
        assert playerX.sign == Sign.O || playerX.sign == Sign.X;
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

    @Test(dataProvider = "numberOfChangingSignMethodsAndSignResult")
    public void testChangingSignMethod(int numberOfMethodExecution, Sign currentSign, Sign expectedSign){
        Player player = new Player("Bartosz");
        player.setSign(currentSign);
        for(int i = 1 ; i<=numberOfMethodExecution; i++){
            player.changeState();
        }
        Assert.assertEquals(player.sign,expectedSign);
    }

}
