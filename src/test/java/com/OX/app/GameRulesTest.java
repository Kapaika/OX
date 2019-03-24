package com.OX.app;
import org.testng.annotations.Test;
/**
 * @author Bartosz Kupajski
 */
@Test
public class GameRulesTest {

    public void testCreationGameRulesTest(){
        GameRules gameRules = new GameRules();
    }

    @Test(expectedExceptions = {TooSmallWinningConditionExceptionException.class})
    public void testToSmallWinnindContionsException() throws TooSmallWinningConditionExceptionException, WinningConditionMoreThanASizeOfBoardExcetpion {
        GameRules gameRules = new GameRules();
        gameRules.setInLineToWinCondition(2);
    }

    @Test()
    public void testNormalInLineToWinCondition() throws TooSmallWinningConditionExceptionException, WinningConditionMoreThanASizeOfBoardExcetpion, TooSmallBoardException {
        GameRules gameRules = new GameRules();
        gameRules.sizeOfABoard(new Coordinates(4,4));
        gameRules.setInLineToWinCondition(3);
    }

    @Test(expectedExceptions = {TooSmallBoardException.class})
    public void testToSmallSizeOfABoardException() throws TooSmallBoardException {
        GameRules gameRules = new GameRules();
        gameRules.sizeOfABoard(new Coordinates(2,2));
    }

    @Test(expectedExceptions = {WinningConditionMoreThanASizeOfBoardExcetpion.class})
    public void testWinningInLineBiggerThanSizeOfABoard() throws TooSmallBoardException, TooSmallWinningConditionExceptionException, WinningConditionMoreThanASizeOfBoardExcetpion {
        GameRules gameRules = new GameRules();
        gameRules.sizeOfABoard(new Coordinates(4,4));
        gameRules.setInLineToWinCondition(5);
    }
}
