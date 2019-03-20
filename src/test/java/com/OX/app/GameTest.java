package com.OX.app;

import Exceptions.TooManyPlayersException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Bartosz Kupajski
 */
@Test
public class GameTest {

    public void testGameCreation(){
        Game game = new Game();
    }

    public void testIfGameIsNotANull(){
        Game game = new Game();
        Assert.assertNotNull(game);
    }

//    public void testIfPlayersCanBeAddToTheList(){
//        Game game = new Game();
//        game.addPlayer(new Player("Bartosz"));
//        game.addPlayer(new Player("Maciej"));
//        List<Player> playerList = game.getListOfPlayers();
//        Integer sizeOfAPlayerList = playerList.size();
//        Assert.assertEquals(sizeOfAPlayerList,Integer.valueOf(2));
//    }
//
//    @Test(expectedExceptions = {TooManyPlayersException.class})
//    public void testIfGamesCantHaveMoreThanTwoPlayers(){
//        Game game = new Game();
//        game.addPlayer(new Player("Bartosz"));
//        game.addPlayer(new Player("Maciej"));
//        game.addPlayer(new Player("Wojciech"));
//        game.addPlayer(new Player("Marcin"));
//    }


//    public void testIfPlayerHaveChanged(){
//        Game game = new Game();
//        Player playerOne = new Player("Bartosz");
//        Player playerTwo = new Player("Maciej");
//        game.addPlayer(playerOne);
//        game.addPlayer(playerTwo);
//        List<Player> playerList = game.getListOfPlayers();
//        Player playerChangedToPlayerOne = game.changePlayer(playerList,playerTwo);
//        Player playerChangedToPlayerTwo = game.changePlayer(playerList,playerOne);
//        assert playerChangedToPlayerOne.equals(playerOne);
//        assert playerChangedToPlayerTwo.equals(playerTwo);
//    }
}
