package com.OX.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *  Bartosz Kupajski
 */
@Test
public class WinningTest {

    @DataProvider
    public Object[][] winningHorizontalConditionCreated(){
        return new Object[][] {
                {0,0,1,2,Sign.X},
                {1,0,1,2,Sign.X},
                {2,0,1,2,Sign.X},
                {0,0,1,2,Sign.O},
                {1,0,1,2,Sign.O},
                {4,0,1,2,Sign.O},
        };
    }

    @Test(dataProvider = "winningHorizontalConditionCreated")
    public void testIfWinningCheckerIsWorkingHorizontalInBestScenario(int x, int y, int z, int v , Sign sign){
        BoardCreator boardCreator = new BoardCreator(5,5);
        Board board = new Board(boardCreator.createBoard());
        Player player = new Player("Bartosz");
        player.setSign(sign);
        Coordinates coordinates1 = new Coordinates(x,y);
        Coordinates coordinates2 = new Coordinates(x,z);
        Coordinates coordinates3 = new Coordinates(x,v);
        Move firstMove = new Move(coordinates1,player);
        firstMove.makeAMove(board);
        Move secondMove = new Move(coordinates2,player);
        secondMove.makeAMove(board);
        Move thirdMove = new Move(coordinates3,player);
        thirdMove.makeAMove(board);
        WinningChecker winningChecker = new WinningChecker();
        Boolean result = winningChecker.check(board,firstMove,3);
        Assert.assertTrue(result);
    }

    @DataProvider
    public Object[][] notWinningHorizontalConditionCreated(){
        return new Object[][] {
                {0,1,2,Sign.X},
                {0,1,2,Sign.O},
        };
    }

    @Test(dataProvider = "notWinningHorizontalConditionCreated")
    public void testIfWinningCheckerIsNotWorkingHorizontalInBestScenario(int x, int y, int z, Sign sign){
        BoardCreator boardCreator = new BoardCreator(5,5);
        Board board = new Board(boardCreator.createBoard());
        Player player = new Player("Bartosz");
        player.setSign(sign);
        Coordinates coordinates1 = new Coordinates(x,x);
        Coordinates coordinates2 = new Coordinates(x,y);
        Coordinates coordinates3 = new Coordinates(z,z);
        Move firstMove = new Move(coordinates1,player);
        firstMove.makeAMove(board);
        Move secondMove = new Move(coordinates2,player);
        secondMove.makeAMove(board);
        Move thirdMove = new Move(coordinates3,player);
        thirdMove.makeAMove(board);
        WinningChecker winningChecker = new WinningChecker();
        Boolean result = winningChecker.check(board,thirdMove,3);
        Assert.assertFalse(result);
    }


    @DataProvider
    public Object[][] winningHorizontalConditionInBothLinesCreated(){
        return new Object[][] {
                {0,1,2,3,Sign.X},
                {1,1,2,3,Sign.X},
                {2,1,2,3,Sign.O},
                {3,1,2,3,Sign.O},
                {6,4,5,6,Sign.O},
                {0,0,2,1,Sign.O},
        };
    }

    @Test(dataProvider = "winningHorizontalConditionInBothLinesCreated")
    public void testIfWinningCheckerIsWorkingHorizontalInBothWays(int x, int y, int z,int v, Sign sign){
        BoardCreator boardCreator = new BoardCreator(7,7);
        Board board = new Board(boardCreator.createBoard());
        Player player = new Player("Bartosz");
        player.setSign(sign);
        Coordinates coordinates1 = new Coordinates(x,y);
        Coordinates coordinates2 = new Coordinates(x,v);
        Coordinates coordinates3 = new Coordinates(x,z);
        Move firstMove = new Move(coordinates1,player);
        firstMove.makeAMove(board);
        Move secondMove = new Move(coordinates2,player);
        secondMove.makeAMove(board);
        Move thirdMove = new Move(coordinates3,player);
        thirdMove.makeAMove(board);
        WinningChecker winningChecker = new WinningChecker();
        Boolean result = winningChecker.check(board,thirdMove,3);
        Assert.assertTrue(result);
    }

    @DataProvider
    public Object[][] winningVerticalConditionInBothLinesCreated(){
        return new Object[][] {
                {0,1,2,3,Sign.X},
                {1,1,2,3,Sign.X},
                {2,1,2,3,Sign.X},
                {3,1,2,3,Sign.X},
                {4,1,2,3,Sign.X},
        };
    }

    @Test(dataProvider = "winningVerticalConditionInBothLinesCreated")
    public void testIfWinningCheckerIsWorkingVerticalInBothWays(int x, int y, int z,int v, Sign sign){
        BoardCreator boardCreator = new BoardCreator(5,    5);
        Board board = new Board(boardCreator.createBoard());
        Player player = new Player("Bartosz");
        player.setSign(sign);
        Coordinates coordinates1 = new Coordinates(y,x);
        Coordinates coordinates2 = new Coordinates(v,x);
        Coordinates coordinates3 = new Coordinates(z,x);
        Move firstMove = new Move(coordinates1,player);
        firstMove.makeAMove(board);
        Move secondMove = new Move(coordinates2,player);
        secondMove.makeAMove(board);
        Move thirdMove = new Move(coordinates3,player);
        thirdMove.makeAMove(board);
        WinningChecker winningChecker = new WinningChecker();
        Boolean result = winningChecker.check(board,thirdMove,3);
        Assert.assertTrue(result);
    }

    @DataProvider
    public Object[][] winningDiagonalConditionInBothLinesCreated(){
        return new Object[][] {
                {0,1,2,3,Sign.X},
                {3,2,1,0,Sign.X},
                {2,3,1,0,Sign.X},
                {4,3,2,0,Sign.X},
        };
    }

    @Test(dataProvider = "winningDiagonalConditionInBothLinesCreated")
    public void testWinningDiagonalScenario(int x, int y, int z,int v, Sign sign){
        BoardCreator boardCreator = new BoardCreator(5,    5);
        Board board = new Board(boardCreator.createBoard());
        Player player = new Player("Bartosz");
        player.setSign(sign);
        Coordinates coordinates1 = new Coordinates(x,x);
        Coordinates coordinates2 = new Coordinates(y,y);
        Coordinates coordinates3 = new Coordinates(z,z);
        Move firstMove = new Move(coordinates1,player);
        firstMove.makeAMove(board);
        Move secondMove = new Move(coordinates2,player);
        secondMove.makeAMove(board);
        Move thirdMove = new Move(coordinates3,player);
        thirdMove.makeAMove(board);
        WinningChecker winningChecker = new WinningChecker();
        Boolean result = winningChecker.check(board,firstMove,3);
        Assert.assertTrue(result);
    }

    @DataProvider
    public Object[][] winningReverseDiagonalConditionInBothLinesCreated(){
        return new Object[][] {
                {0,1,2,3,4,Sign.X},

        };
    }

    @Test(dataProvider = "winningReverseDiagonalConditionInBothLinesCreated")
    public void testWinningReverseDiagonalScenario(int x, int y, int z, int v, int b, Sign sign){
        BoardCreator boardCreator = new BoardCreator(5,    5);
        Board board = new Board(boardCreator.createBoard());
        Player player = new Player("Bartosz");
        player.setSign(sign);
        Coordinates coordinates1 = new Coordinates(z,z);
        Coordinates coordinates2 = new Coordinates(y,v);
        Coordinates coordinates3 = new Coordinates(x,b);
        Move firstMove = new Move(coordinates1,player);
        firstMove.makeAMove(board);
        Move secondMove = new Move(coordinates2,player);
        secondMove.makeAMove(board);
        Move thirdMove = new Move(coordinates3,player);
        thirdMove.makeAMove(board);
        WinningChecker winningChecker = new WinningChecker();
        Boolean result = winningChecker.check(board,firstMove,3);
        Assert.assertTrue(result);
    }
}
