package com.OX.app;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

@Test
public class AutomateTest {

    int numberOfRows = 5;
    int numberOfCols = 5;
    int conditionToWin = 3;

    @DataProvider
    public Object[][] horizontalAutomateData() {
        return new Object[][]{
                {numberOfRows, numberOfCols, conditionToWin},
        };
    }

    @Test(dataProvider = "horizontalAutomateData")
    public void horizontalAutomateTest(int numberOfRows, int numberOfBoardCols, int inLineToWin) {
        inLineToWin = inLineToWin - 1;
        Player firstPlayer = new Player("Bartosz");
        firstPlayer.setSign(Sign.X);
        Player secondPlayer = new Player("Maciej");
        secondPlayer.setSign(Sign.O);
        Random random = new Random();
        int randomX;
        int randomY;
        Move secondPlayerMove;
        Coordinates secondPlayerCoordinates;
        HorizontalChecker horizontalChecker = new HorizontalChecker();
        for (int start = 0; start < numberOfRows; start++) {
            for (int i = 0; i <= numberOfBoardCols - inLineToWin - 1; i++) {
                BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfBoardCols);
                Board board = boardCreator.createBoard();
                BoardPrinter boardPrinter = new BoardPrinter(board);
                for (int j = i; j < i + inLineToWin + 1; j++) {
                    Move move = new Move(new Coordinates(start, j), firstPlayer);
                    board.makeAMove(move);
                    if (horizontalChecker.check(board, move, inLineToWin)) {
                        boardPrinter.printBoard();
                        System.out.println("Wygrana");
                        break;
                    }
                    randomY = random.nextInt(numberOfBoardCols);
                    do {
                        randomX = random.nextInt(numberOfRows);
                        secondPlayerCoordinates = new Coordinates(randomX, randomY);
                    } while (randomX == start || board.playingBoard[randomX][randomY] == Sign.O);
                    secondPlayerMove = new Move(secondPlayerCoordinates, secondPlayer);
                    board.makeAMove(secondPlayerMove);
                }
            }
        }
    }


    @DataProvider
    public Object[][] verticalAutomateData() {
        return new Object[][]{
                {numberOfRows, numberOfCols, conditionToWin},
        };
    }


    @Test(dataProvider = "verticalAutomateData")
    public void verticalAutomateTest(int numberOfRows, int numberOfBoardCols, int inLineToWin) {
        inLineToWin = inLineToWin - 1;
        Player player = new Player("Bartosz");
        player.setSign(Sign.X);
        Player secondPlayer = new Player("Maciej");
        secondPlayer.setSign(Sign.O);
        Random random = new Random();
        int randomX;
        int randomY;
        Move secondPlayerMove;
        Coordinates secondPlayerCoordinates;
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
                    randomX = random.nextInt(numberOfRows);
                    do {
                        randomY = random.nextInt(numberOfBoardCols);
                        secondPlayerCoordinates = new Coordinates(randomX, randomY);
                    } while (randomY == start || board.playingBoard[randomX][randomY] == Sign.O);
                    secondPlayerMove = new Move(secondPlayerCoordinates, secondPlayer);
                    board.makeAMove(secondPlayerMove);
                }
            }
        }
    }

    @DataProvider
    public Object[][] diagonalAutomateData() {
        return new Object[][]{
                {numberOfRows, numberOfCols, conditionToWin},
        };
    }

    @Test(dataProvider = "diagonalAutomateData")
    public void diagonalAutomateTest(int numberOfRows, int numberOfBoardCols, int inLineToWin) {
        inLineToWin = inLineToWin - 1;
        Player player = new Player("Bartosz");
        player.setSign(Sign.X);
        Player secondPlayer = new Player("Maciej");
        secondPlayer.setSign(Sign.O);
        Random random = new Random();
        int randomX;
        int randomY;
        Move secondPlayerMove;
        Coordinates secondPlayerCoordinates;
        DiagonalChecker diagonalChecker = new DiagonalChecker();

        for (int smallSquareX = 0; smallSquareX < numberOfBoardCols - inLineToWin; smallSquareX++) {
            for (int smallSquareY = 0; smallSquareY < numberOfRows - inLineToWin; smallSquareY++) {
                BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfBoardCols);
                Board board = boardCreator.createBoard();
                BoardPrinter boardPrinter = new BoardPrinter(board);
                for (int i = 0; i <= inLineToWin; i++) {
                    Coordinates coordinates = new Coordinates(smallSquareX + i, smallSquareY + i);
                    Move move = new Move(coordinates, player);
                    board.makeAMove(move);
                    if (diagonalChecker.check(board, move, inLineToWin)) {
                        boardPrinter.printBoard();
                        System.out.println("Wygrana");
                        break;
                    }
                    do {
                        randomY = random.nextInt(numberOfBoardCols);
                        randomX = random.nextInt(numberOfRows);
                        secondPlayerCoordinates = new Coordinates(randomX, randomY);
                    } while (randomX != i || (board.playingBoard[randomX][randomY] == Sign.O || board.playingBoard[randomX][randomY] == Sign.X));
                    secondPlayerMove = new Move(secondPlayerCoordinates, secondPlayer);
                    board.makeAMove(secondPlayerMove);
                }

            }
        }
    }

    @DataProvider
    public Object[][] reverseDiagonalAutomateData() {
        return new Object[][]{
                {numberOfRows, numberOfCols, conditionToWin},
        };
    }

    @Test(dataProvider = "reverseDiagonalAutomateData")
    public void reverseDiagonalAutomateTest(int numberOfRows, int numberOfBoardCols, int inLineToWin) {
        inLineToWin = inLineToWin - 1;
        Player player = new Player("Bartosz");
        player.setSign(Sign.X);
        Player secondPlayer = new Player("Maciej");
        secondPlayer.setSign(Sign.O);
        Random random = new Random();
        int randomX;
        int randomY;
        Move secondPlayerMove;
        Coordinates secondPlayerCoordinates;
        ReverseDiagonalChecker reverseDiagonalChecker = new ReverseDiagonalChecker();


        for (int smallSquareX = inLineToWin; smallSquareX < numberOfBoardCols; smallSquareX++) {
            for (int smallSquareY = 0; smallSquareY < numberOfRows - inLineToWin; smallSquareY++) {
                BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfBoardCols);
                Board board = boardCreator.createBoard();
                BoardPrinter boardPrinter = new BoardPrinter(board);
                for (int i = 0; i <= inLineToWin; i++) {
                    Coordinates coordinates = new Coordinates(smallSquareX - i, smallSquareY + i);
                    Move move = new Move(coordinates, player);
                    board.makeAMove(move);
                    if (reverseDiagonalChecker.check(board, move, inLineToWin)) {
                        boardPrinter.printBoard();
                        System.out.println("Wygrana");
                        break;
                    }
                    do {
                        randomY = random.nextInt(numberOfBoardCols);
                        randomX = random.nextInt(numberOfRows);
                        secondPlayerCoordinates = new Coordinates(randomX, randomY);
                    } while (randomX != smallSquareX || (board.playingBoard[randomX][randomY] == Sign.O || board.playingBoard[randomX][randomY] == Sign.X));
                    secondPlayerMove = new Move(secondPlayerCoordinates, secondPlayer);
                    board.makeAMove(secondPlayerMove);
                }

            }
        }
    }

    @Test(dataProvider = "reverseDiagonalAutomateData")
    public void tieAutomateTest(int numberOfRows, int numberOfBoardCols, int inLineToWin) {
        Player player = new Player("Bartosz");
        player.setSign(Sign.O);
        Player secondPlayer = new Player("Maciej");
        secondPlayer.setSign(Sign.X);
        int changeSignFirst = 0;

        BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfBoardCols);
        Board board = boardCreator.createBoard();
        BoardPrinter boardPrinter = new BoardPrinter(board);

        TieChecker tieChecker = new TieChecker();

        for (int smallSquareX = 0; smallSquareX < numberOfBoardCols; smallSquareX++) {

            if (changeSignFirst == 2) {
                if (player.sign == Sign.X) {
                    player.setSign(Sign.O);
                    secondPlayer.setSign(Sign.X);
                } else {
                    player.setSign(Sign.X);
                    secondPlayer.setSign(Sign.O);
                }
                changeSignFirst = 0;
            }

            for (int smallSquareY = 0; smallSquareY < numberOfRows; smallSquareY++) {

                Coordinates coordinates = new Coordinates(smallSquareX, smallSquareY);

                if (smallSquareY % 2 == 0) {
                    Move move = new Move(coordinates, player);
                    board.makeAMove(move);
                    if (tieChecker.check(board.playingBoard)) {
                        boardPrinter.printBoard();
                        System.out.println("Remis");
                    }
                } else {
                    Move move = new Move(coordinates, secondPlayer);
                    board.makeAMove(move);
                    if (tieChecker.check(board.playingBoard)) {
                        boardPrinter.printBoard();
                        System.out.println("Remis");
                    }
                }
            }
            changeSignFirst++;
        }
    }
}
