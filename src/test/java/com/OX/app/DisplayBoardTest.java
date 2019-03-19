package com.OX.app;

import org.testng.annotations.Test;

/**
 * @author Bartosz Kupajski
 */
@Test
public class DisplayBoardTest {

    @Test
    public void testPrintBoard(){
        BoardCreator boardCreator = new BoardCreator(4,5);
        BoardPrinter boardPrinter = new BoardPrinter();
        Sign[][] tabX0 = boardCreator.createBoard();
        boardPrinter.printBoard(tabX0);
    }
}
