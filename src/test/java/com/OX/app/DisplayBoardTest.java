package com.OX.app;

import org.testng.annotations.Test;

/**
 * @author Bartosz Kupajski
 */
@Test
public class DisplayBoardTest {

    public void testPrintBoard(){
        BoardCreator boardCreator = new BoardCreator(3,3);
        Board board = new Board(boardCreator.createBoard());
        BoardPrinter boardPrinter = new BoardPrinter(board);
        boardPrinter.printBoard();
        assert true;
    }
}
