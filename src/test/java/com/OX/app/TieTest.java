package com.OX.app;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Bartosz Kupajski
 */
@Test
public class TieTest {



    @Test
    public void testIfItIsATie(){
        BoardCreator boardCreator = new BoardCreator(3,    3);
        Board board = boardCreator.createBoard();
        TieChecker tieChecker = new TieChecker();
        Player firstPlayer = new Player("Bartosz");
        firstPlayer.setSign(Sign.O);
        Player secondPlayer = new Player("Maciej");
        secondPlayer.setSign(Sign.X);
        Coordinates coordinates1 = new Coordinates(0,0);
        Coordinates coordinates2 = new Coordinates(0,1);
        Coordinates coordinates3 = new Coordinates(0,2);
        Coordinates coordinates4 = new Coordinates(1,0);
        Coordinates coordinates5 = new Coordinates(1,1);
        Coordinates coordinates6 = new Coordinates(1,2);
        Coordinates coordinates7 = new Coordinates(2,0);
        Coordinates coordinates8 = new Coordinates(2,1);
        Coordinates coordinates9 = new Coordinates(2,2);
        Move firstMove = new Move(coordinates1,firstPlayer);
        firstMove.makeAMove(board);
        Move secondMove = new Move(coordinates2,secondPlayer);
        secondMove.makeAMove(board);
        Move thirdMove = new Move(coordinates3,firstPlayer);
        thirdMove.makeAMove(board);
        Move fourthtMove = new Move(coordinates4,secondPlayer);
        fourthtMove.makeAMove(board);
        Move fifthMove = new Move(coordinates5,firstPlayer);
        fifthMove.makeAMove(board);
        Move sixthMove = new Move(coordinates6,secondPlayer);
        sixthMove.makeAMove(board);
        Move seventhMove = new Move(coordinates7,firstPlayer);
        seventhMove.makeAMove(board);
        Move eightMove = new Move(coordinates8,secondPlayer);
        eightMove.makeAMove(board);
        Move ninenthMove = new Move(coordinates9,firstPlayer);
        ninenthMove.makeAMove(board);
        boolean result = tieChecker.check(board.playingBoard);
        Assert.assertTrue(result);
    }

    @Test
    public void testIfItIsNotATie(){
        BoardCreator boardCreator = new BoardCreator(3,    3);
        Board board = boardCreator.createBoard();
        TieChecker tieChecker = new TieChecker();
        Player firstPlayer = new Player("Bartosz");
        firstPlayer.setSign(Sign.O);
        Player secondPlayer = new Player("Maciej");
        secondPlayer.setSign(Sign.X);
        Coordinates coordinates1 = new Coordinates(0,0);
        Coordinates coordinates2 = new Coordinates(0,1);
        Coordinates coordinates3 = new Coordinates(0,2);
        Coordinates coordinates4 = new Coordinates(1,0);
        Coordinates coordinates5 = new Coordinates(1,1);
        Coordinates coordinates6 = new Coordinates(1,2);
        Coordinates coordinates7 = new Coordinates(2,0);
        Coordinates coordinates8 = new Coordinates(2,1);

        Move firstMove = new Move(coordinates1,firstPlayer);
        firstMove.makeAMove(board);
        Move secondMove = new Move(coordinates2,secondPlayer);
        secondMove.makeAMove(board);
        Move thirdMove = new Move(coordinates3,firstPlayer);
        thirdMove.makeAMove(board);
        Move fourthMove = new Move(coordinates4,secondPlayer);
        fourthMove.makeAMove(board);
        Move fifthMove = new Move(coordinates5,firstPlayer);
        fifthMove.makeAMove(board);
        Move sixthMove = new Move(coordinates6,secondPlayer);
        sixthMove.makeAMove(board);
        Move seventhMove = new Move(coordinates7,firstPlayer);
        seventhMove.makeAMove(board);
        Move eightMove = new Move(coordinates8,secondPlayer);
        eightMove.makeAMove(board);
        boolean result = tieChecker.check(board.playingBoard);
        Assert.assertFalse(result);
    }

}
