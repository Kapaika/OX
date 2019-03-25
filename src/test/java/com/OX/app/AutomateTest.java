package com.OX.app;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class AutomateTest {

    @DataProvider
    public Object[][] horizontalAutomateData() {
        return new Object[][]{
                {7, 6, 3},
        };
    }

    @Test(dataProvider = "horizontalAutomateData")
    public void horizontalAutomateTest(int numberOfRows, int numberOfBoardCols, int inLineToWin) {
        inLineToWin = inLineToWin - 1;
        Player player = new Player("Bartosz");
        player.setSign(Sign.X);
        HorizontalChecker horizontalChecker = new HorizontalChecker();
        for (int start = 0; start < numberOfRows; start++) {
            for (int i = 0; i <= numberOfBoardCols - inLineToWin - 1; i++) {
                BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfBoardCols);
                Board board = boardCreator.createBoard();
                BoardPrinter boardPrinter = new BoardPrinter(board);
                for (int j = i; j < i + inLineToWin + 1; j++) {
                    Move move = new Move(new Coordinates(start, j), player);
                    board.makeAMove(move);
                    if (horizontalChecker.check(board, move, inLineToWin)) {
                        boardPrinter.printBoard();
                        System.out.println("Wygrana");
                    }
                }
            }
        }
    }


    @DataProvider
    public Object[][] verticalAutomateData() {
        return new Object[][]{
                {6, 7, 3},
        };
    }

    @Test(dataProvider = "verticalAutomateData")
    public void verticalAutomateTest(int numberOfRows, int numberOfBoardCols, int inLineToWin) {
        inLineToWin = inLineToWin - 1;
        Player player = new Player("Bartosz");
        player.setSign(Sign.X);
        VerticalChecker verticalChecker = new VerticalChecker();
        for (int start = 0; start < numberOfBoardCols; start++) {
            for (int i = 0; i <= numberOfRows - inLineToWin - 1; i++) {
                BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfBoardCols);
                Board board = boardCreator.createBoard();
                BoardPrinter boardPrinter = new BoardPrinter(board);
                for (int j = i; j < i + inLineToWin + 1; j++) {
                    Move move = new Move(new Coordinates(j, start), player);
                    board.makeAMove(move);
                    if (verticalChecker.check(board, move, inLineToWin)) {
                        boardPrinter.printBoard();
                        System.out.println("Wygrana");
                    }
                }
            }
        }
    }


    @DataProvider
    public Object[][] diagonalAutomateData() {
        return new Object[][]{
                {5, 5, 3},
        };
    }

    @Test(dataProvider = "diagonalAutomateData")
    public void diagonalAutomateTest(int numberOfRows, int numberOfBoardCols, int inLineToWin) {
        inLineToWin = inLineToWin - 1;
        Player player = new Player("Bartosz");
        player.setSign(Sign.X);
        DiagonalChecker diagonalChecker = new DiagonalChecker();
        for(int start = 0 ; start<numberOfBoardCols-inLineToWin;start++){
            BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfBoardCols);
            Board board = boardCreator.createBoard();
            BoardPrinter boardPrinter = new BoardPrinter(board);
            for (int i = start; i <= start + inLineToWin; i++) {
                for (int j = i; j < i + 1; j++) {
                    Move move = new Move(new Coordinates(i, j), player);
                    board.makeAMove(move);
                    boardPrinter.printBoard();
                    if (diagonalChecker.check(board, move, inLineToWin)) {
                        System.out.println("Wygrana");
                    }
                }
            }
        }

    }


//    @Test(dataProvider = "diagonalAutomateData")
//    public void diagonalAutomateTest(int numberOfRows, int numberOfBoardCols, int inLineToWin) {
//        inLineToWin = inLineToWin - 1;
//        Player player = new Player("Bartosz");
//        player.setSign(Sign.X);
//        DiagonalChecker diagonalChecker = new DiagonalChecker();
//        BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfBoardCols);
//        Board board = boardCreator.createBoard();
//        BoardPrinter boardPrinter = new BoardPrinter(board);
//        for (int start = 0; start < numberOfBoardCols - inLineToWin; start++) {
//            for (int i = start; i < inLineToWin + start + 1; i++) {
//                Move move = new Move(new Coordinates(start, i), player);
//                board.makeAMove(move);
//                boardPrinter.printBoard();
//            }
//        }
//
//    }

}
