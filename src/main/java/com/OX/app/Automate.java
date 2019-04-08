package com.OX.app;

import java.util.Random;

/**
 * @author Bartosz Kupajski
 */
public class Automate {

    private int numberOfRows;
    private int numberOfCols;
    private int conditionToWin;
    private int counter = 0;
    private StringBuilder stringBuilder = new StringBuilder();

    public Automate(int numberOfRows, int numberOfCols, int conditionToWin) {
        this.numberOfRows = numberOfRows;
        this.numberOfCols = numberOfCols;
        this.conditionToWin = conditionToWin;
    }

    public static void main(String[] args) {
        //Automate automate = new Automate(5,5,3);
        Automate automate = new Automate(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        automate.automateGenerator();
    }

    void automateGenerator() {
        beginningOfTheGameCreator();
        horizontalGenerator(numberOfRows,numberOfCols,conditionToWin);
        verticalGenerator(numberOfRows,numberOfCols,conditionToWin);
        tieGenerator(numberOfRows,numberOfCols,conditionToWin);
        diagonalGenerator(numberOfRows,numberOfCols,conditionToWin);
        reverseGenerator(numberOfRows,numberOfCols,conditionToWin);
    }

    private void beginningOfTheGameCreator() {
        stringBuilder.append('1').append('\n')
                .append('b').append('\n')
                .append('k').append('\n')
                .append(numberOfRows).append('\n')
                .append(numberOfCols).append('\n')
                .append(conditionToWin).append('\n')
                .append('b').append('\n');
    }

    private void horizontalGenerator(int numberOfRows, int numberOfCols, int inLineToWin) {

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
            for (int i = 0; i <= numberOfCols - inLineToWin - 1; i++) {
                BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfCols);
                Board board = boardCreator.createBoard();
                BoardPrinter boardPrinter = new BoardPrinter(board);
                for (int j = i; j < i + inLineToWin + 1; j++) {
                    Move move = new Move(new Coordinates(start, j), firstPlayer);
                    stringBuilder.append(start).append('\n').append(j).append('\n');
                    board.makeAMove(move);
                    if (horizontalChecker.check(board, move, inLineToWin)) {
                        boardPrinter.printBoard();
                        System.out.println("Wygrana");
                        counter++;
                        break;
                    }
                    randomY = random.nextInt(numberOfCols);
                    do {
                        randomX = random.nextInt(numberOfRows);
                        secondPlayerCoordinates = new Coordinates(randomX, randomY);
                    } while (randomX == start || board.playingBoard[randomX][randomY] != Sign.N);
                    stringBuilder.append(randomX).append('\n').append(randomY).append('\n');
                    secondPlayerMove = new Move(secondPlayerCoordinates, secondPlayer);
                    board.makeAMove(secondPlayerMove);
                    boardPrinter.printBoard();
                }
            }
        }

    }

    private void verticalGenerator(int numberOfRows, int numberOfCols, int inLineToWin) {

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
        for (int start = 0; start < numberOfCols; start++) {
            for (int i = 0; i <= numberOfRows - inLineToWin - 1; i++) {
                BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfCols);
                Board board = boardCreator.createBoard();
                BoardPrinter boardPrinter = new BoardPrinter(board);
                for (int j = i; j < i + inLineToWin + 1; j++) {
                    Move move = new Move(new Coordinates(j, start), player);
                    stringBuilder.append(j).append('\n').append(start).append('\n');
                    board.makeAMove(move);
                    if (verticalChecker.check(board, move, inLineToWin)) {
                        boardPrinter.printBoard();
                        System.out.println("Wygrana");
                        counter++;
                        break;
                    }
                    randomX = random.nextInt(numberOfRows);
                    do {
                        randomY = random.nextInt(numberOfCols);
                        secondPlayerCoordinates = new Coordinates(randomX, randomY);
                    } while (randomY == start || board.playingBoard[randomX][randomY] != Sign.N);
                    secondPlayerMove = new Move(secondPlayerCoordinates, secondPlayer);
                    stringBuilder.append(randomX).append('\n').append(randomY).append('\n');
                    board.makeAMove(secondPlayerMove);
                }
            }
        }
    }

    private void diagonalGenerator(int numberOfRows, int numberOfCols, int inLineToWin){
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

        for (int smallSquareX = 0; smallSquareX < numberOfCols - inLineToWin; smallSquareX++) {
            for (int smallSquareY = 0; smallSquareY < numberOfRows - inLineToWin; smallSquareY++) {
                BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfCols);
                Board board = boardCreator.createBoard();
                BoardPrinter boardPrinter = new BoardPrinter(board);
                for (int i = 0; i <= inLineToWin; i++) {
                    Coordinates coordinates = new Coordinates(smallSquareX + i, smallSquareY + i);
                    stringBuilder.append(smallSquareX+i).append('\n').append(smallSquareY+i).append('\n');
                    Move move = new Move(coordinates, player);
                    board.makeAMove(move);
                    if (diagonalChecker.check(board, move, inLineToWin)) {
                        boardPrinter.printBoard();
                        System.out.println("Wygrana");
                        counter++;
                        break;
                    }
                    do {
                        randomY = random.nextInt(numberOfCols);
                        randomX = random.nextInt(numberOfRows);
                        secondPlayerCoordinates = new Coordinates(randomX, randomY);
                    } while (randomX != i || (board.playingBoard[randomX][randomY] == Sign.O || board.playingBoard[randomX][randomY] == Sign.X));
                    secondPlayerMove = new Move(secondPlayerCoordinates, secondPlayer);
                    stringBuilder.append(secondPlayerCoordinates.x).append('\n').append(secondPlayerCoordinates.y).append('\n');
                    board.makeAMove(secondPlayerMove);
                }

            }
        }
    }

    private void tieGenerator(int numberOfRows,int numberOfCols,int inLineToWin) {

        Player player = new Player("Bartosz");
        player.setSign(Sign.O);
        Player secondPlayer = new Player("Maciej");
        secondPlayer.setSign(Sign.X);
        int changeSignFirst = 0;

        BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfCols);
        Board board = boardCreator.createBoard();
        BoardPrinter boardPrinter = new BoardPrinter(board);

        TieChecker tieChecker = new TieChecker();

        for (int smallSquareX = 0; smallSquareX < numberOfCols; smallSquareX++) {

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
                        counter++;
                        System.out.println("Remis");
                    }
                } else {
                    Move move = new Move(coordinates, secondPlayer);
                    board.makeAMove(move);
                    if (tieChecker.check(board.playingBoard)) {
                        boardPrinter.printBoard();
                        counter++;
                        System.out.println("Remis");
                    }
                }
            }
            changeSignFirst++;

        }
    }

    private void reverseGenerator(int numberOfRows, int numberOfCols, int inLineToWin){

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


        for (int smallSquareX = inLineToWin; smallSquareX < numberOfCols; smallSquareX++) {
            for (int smallSquareY = 0; smallSquareY < numberOfRows - inLineToWin; smallSquareY++) {
                BoardCreator boardCreator = new BoardCreator(numberOfRows, numberOfCols);
                Board board = boardCreator.createBoard();
                BoardPrinter boardPrinter = new BoardPrinter(board);
                for (int i = 0; i <= inLineToWin; i++) {
                    Coordinates coordinates = new Coordinates(smallSquareX - i, smallSquareY + i);
                    Move move = new Move(coordinates, player);
                    stringBuilder.append(smallSquareX-i).append('\n').append(smallSquareY+i).append('\n');
                    board.makeAMove(move);
                    if (reverseDiagonalChecker.check(board, move, inLineToWin)) {
                        boardPrinter.printBoard();
                        System.out.println("Wygrana");
                        counter++;
                        break;
                    }
                    do {
                        randomY = random.nextInt(numberOfCols);
                        randomX = random.nextInt(numberOfRows);
                        secondPlayerCoordinates = new Coordinates(randomX, randomY);
                    } while (randomX != smallSquareX || (board.playingBoard[randomX][randomY] == Sign.O || board.playingBoard[randomX][randomY] == Sign.X));
                    secondPlayerMove = new Move(secondPlayerCoordinates, secondPlayer);
                    stringBuilder.append(secondPlayerCoordinates.x).append('\n').append(secondPlayerCoordinates.y).append('\n');
                    board.makeAMove(secondPlayerMove);
                }

            }
        }
    }
}
