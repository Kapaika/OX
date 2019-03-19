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
        Board board = new Board(null);
        Assert.assertNotNull(board);
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
        BoardCreator bd = new BoardCreator(3,4);
        Board board =  new Board(bd.createBoard());
        BoardPrinter boardPrinter = new BoardPrinter(board);
        boardPrinter.printBoard();
    }

}
