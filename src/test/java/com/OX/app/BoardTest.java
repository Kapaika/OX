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

    @DataProvider
    public Object[][] fillingWithSignCreation(){
        return new Object[][]{
                {0,0},
                {0,1},
                {0,2},
                {1,0},
                {1,1},
                {1,2},
                {2,0},
                {2,1},
                {2,2},
        };
    }

    @Test(dataProvider = "fillingWithSignCreation")
    public void testOfCreationTheBoardByBoardCreator(int row, int col){
        BoardCreator bd = new BoardCreator(3,3);
        Sign[][] tabXO = bd.createBoard();
        assert tabXO[row][col]==Sign.N;
    }

    @Test
    public void testPrintBoard(){
        BoardCreator bd = new BoardCreator(3,3);
        Sign[][] tabXO = bd.createBoard();
        BoardPrinter boardPrinter = new BoardPrinter();
        boardPrinter.printBoard(tabXO);
    }



}
