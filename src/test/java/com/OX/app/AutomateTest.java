package com.OX.app;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class AutomateTest {

    @DataProvider
    public Object[][] horizontalAutomateData(){
        return new Object[][]{
                {3,3,2,3},
                {3,3,0,3},
                {3,3,1,3},
        };
    }

    @Test(dataProvider = "horizontalAutomateData" )
    public void horizontalAutomateTest(int numberOfRows, int numberOfBoardCols, int whichRow, int inLineToWin) {
        inLineToWin = inLineToWin-1;
        Player player = new Player("Bartosz");
        player.setSign(Sign.X);
        HorizontalChecker horizontalChecker = new HorizontalChecker();
        for(int i = 0 ; i<=numberOfBoardCols-inLineToWin-1; i++){
            BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfBoardCols);
            Board board = boardCreator.createBoard();
            BoardPrinter boardPrinter = new BoardPrinter(board);
            for(int j=i; j<i+inLineToWin+1; j++){
                Move move = new Move(new Coordinates(whichRow,j), player);
                board.makeAMove(move);
                if (horizontalChecker.check(board,move,inLineToWin)) {
                    boardPrinter.printBoard();
                    System.out.println("Wygrana");
                }

            }
        }
    }


    @DataProvider
    public Object[][] verticalAutomateData(){
        return new Object[][]{
                {3,3,0,3},
                {3,3,1,3},
                {3,3,2,3},
        };
    }

    @Test(dataProvider = "verticalAutomateData")
    public void verticalAutomateTest(int numberOfRows, int numberOfBoardCols, int whichRow, int inLineToWin){
        inLineToWin = inLineToWin-1;
        Player player = new Player("Bartosz");
        player.setSign(Sign.X);
        VerticalChecker verticalChecker = new VerticalChecker();
        for(int i = 0 ; i<=numberOfRows-inLineToWin-1; i++){
            BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfBoardCols);
            Board board = boardCreator.createBoard();
            BoardPrinter boardPrinter = new BoardPrinter(board);
            for(int j=i; j<i+inLineToWin+1; j++){
                Move move = new Move(new Coordinates(j,whichRow), player);
                board.makeAMove(move);
                if (verticalChecker.check(board,move,inLineToWin)) {
                    boardPrinter.printBoard();
                    System.out.println("Wygrana");
                }
            }
        }
    }


    @DataProvider
    public Object[][] diagonalAutomateData(){
        return new Object[][]{
                {5,5,3},
        };
    }

    @Test(dataProvider = "diagonalAutomateData")
    public void diagonalAutomateTest(int numberOfRows, int numberOfBoardCols, int inLineToWin){
        inLineToWin = inLineToWin-1;
        Player player = new Player("Bartosz");
        player.setSign(Sign.X);
        DiagonalChecker diagonalChecker = new DiagonalChecker();
        for(int start = 0 ; start<=numberOfBoardCols-inLineToWin ; start++){
            BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfBoardCols);
            Board board = boardCreator.createBoard();
            BoardPrinter boardPrinter = new BoardPrinter(board);
            for(int i = start ; i<=inLineToWin; i++){
                for(int j= i ; j<i+1; j++){
                    Move move = new Move(new Coordinates(i,j), player);
                    board.makeAMove(move);
                    boardPrinter.printBoard();
                    if (diagonalChecker.check(board,move,inLineToWin)) {
                        System.out.println("Wygrana");
                    }
                }
            }
        }
    }
}
