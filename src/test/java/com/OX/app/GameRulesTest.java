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

    @Test(expectedExceptions = {toSmallWinningConditionExceptionException.class})
    public void testToSmallWinnindContionsException() throws toSmallWinningConditionExceptionException, winningConditionMoreThanASizeOfBoardExcetpion {
        GameRules gameRules = new GameRules();
        gameRules.setInLineToWinCondition(2);
    }

    @Test()
    public void testNormalInLineToWinCondition() throws toSmallWinningConditionExceptionException, winningConditionMoreThanASizeOfBoardExcetpion, toSmallBoardException {
        GameRules gameRules = new GameRules();
        gameRules.sizeOfABoard(4,4);
        gameRules.setInLineToWinCondition(3);
    }

    @Test(expectedExceptions = {toSmallBoardException.class})
    public void testToSmallSizeOfABoardException() throws toSmallBoardException {
        GameRules gameRules = new GameRules();
        gameRules.sizeOfABoard(2,2);
    }

    @Test(expectedExceptions = {winningConditionMoreThanASizeOfBoardExcetpion.class})
    public void testWinningInLineBiggerThanSizeOfABoard() throws toSmallBoardException, toSmallWinningConditionExceptionException, winningConditionMoreThanASizeOfBoardExcetpion {
        GameRules gameRules = new GameRules();
        gameRules.sizeOfABoard(4,4);
        gameRules.setInLineToWinCondition(5);
    }
}
