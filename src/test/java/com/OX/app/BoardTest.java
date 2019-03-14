package com.OX.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Bartosz Kupajski
 */
@Test
public class BoardTest {

    @Test
    public void testOfBoardCreation(){
        Board board = new Board();
        Assert.assertNotNull(board);
    }

    @DataProvider
    public Object[][] differentSizeOfPlayingBoardScenario(){
        return new Object[][]{
                {-1,5},
                {5,-1},
                {Integer.MIN_VALUE,5},
                {1,Integer.MIN_VALUE},
                {-1,-2}
        };
    }

    @Test(dataProvider = "differentSizeOfPlayingBoardScenario", expectedExceptions = {NegativeArraySizeException.class})
    public void testOfInitilizeBoard(int row, int col){
        Board board = new Board();
        board.createPlayingBoard(row, col);
    }

}
