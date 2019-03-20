package com.OX.app;

import Exceptions.FieldAlreadyTakenException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Bartosz Kupajski
 */
@Test
public class MoveTest {

    @Test
    public void testIfMoveIsDone(){
        BoardCreator boardCreator = new BoardCreator(3,3);
        Board board = new Board(boardCreator.createBoard());
        Player player = new Player("Bartosz");
        player.setSign(Sign.O);
        Coordinates coordinates = new Coordinates(0,0);
        Move move = new Move(coordinates,player);
        move.makeAMove(board);
        Assert.assertEquals(board.playingBoard[0][0],player.getSign());
    }


    @DataProvider
    public Object[][] coordinatesToTestAlreadyTakenField(){
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

    @Test(dataProvider = "coordinatesToTestAlreadyTakenField", expectedExceptions = {FieldAlreadyTakenException.class})
    public void testIfMoveCantBeDoneIfFieldIsAlreadyWritten(int x, int y){
        BoardCreator boardCreator = new BoardCreator(3,3);
        Board board = new Board(boardCreator.createBoard());
        Player player = new Player("Bartosz");
        player.setSign(Sign.O);
        Coordinates coordinates = new Coordinates(x,y);
        Move move = new Move(coordinates,player);
        move.makeAMove(board);
        Move move2 = new Move(coordinates,player);
        move2.makeAMove(board);
    }

    @Test()
    public void testIfICanTakeAMoveWithDifferentSigns(){
        BoardCreator boardCreator = new BoardCreator(3,3);
        Board board = new Board(boardCreator.createBoard());
        Player firstPlayer = new Player("Bartosz");
        firstPlayer.setSign(Sign.O);
        Coordinates firstPlayerCoordinates = new Coordinates(0,0);
        Move move = new Move(firstPlayerCoordinates,firstPlayer);
        move.makeAMove(board);
        Coordinates secondPlayerCoordinates = new Coordinates(1,1);
        Player secondPlayer = new Player("Maciej");
        secondPlayer.setSign(Sign.X);
        Move move2 = new Move(secondPlayerCoordinates,secondPlayer);
        move2.makeAMove(board);
        BoardPrinter boardPrinter = new BoardPrinter(board);
        boardPrinter.printBoard();
        assert board.playingBoard[secondPlayerCoordinates.x][secondPlayerCoordinates.y] == Sign.X;
        assert board.playingBoard[firstPlayerCoordinates.x][firstPlayerCoordinates.y] == Sign.O;
    }


    @DataProvider
    public Object[][] arrayOfBoundExceptionChecker(){
        return new Object[][]{
                {8,5,Sign.O},
                {Integer.MAX_VALUE,5,Sign.O},
        };
    }


    @Test(dataProvider = "arrayOfBoundExceptionChecker", expectedExceptions = {ArrayIndexOutOfBoundsException.class})
    public void testArrayOfTheBoundException(int x, int y, Sign sign){
        BoardCreator boardCreator = new BoardCreator(y,    y);
        Board board = new Board(boardCreator.createBoard());
        Player player = new Player("Bartosz");
        player.setSign(sign);
        Coordinates coordinates1 = new Coordinates(x,x);
        Move firstMove = new Move(coordinates1,player);
        firstMove.makeAMove(board);

    }



}
