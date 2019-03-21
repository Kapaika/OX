package com.OX.app;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * @author Bartosz Kupajski
 */
@Test
public class GameCompetitorsTest{

    @Test
    public void testDefaultConstructor(){
        GameCompetitors gameCompetitors;
    }


    @Test
    public void testConstructorWithList() throws NoSuchPlayerException {
        ArrayList<Player> playersList = new ArrayList<>();
        GameCompetitors gameCompetitors = new GameCompetitors(playersList);
        gameCompetitors.addingPlayersWithNameAndSign("Bartosz");
        gameCompetitors.addingPlayersWithNameAndSign("Maciej");
        gameCompetitors.chooseStartingPlayer("Bartosz");
    }


    @Test(expectedExceptions = {NoSuchPlayerException.class})
    public void testNoSuchAPlayerException() throws NoSuchPlayerException {
        ArrayList<Player> playersList = new ArrayList<>();
        GameCompetitors gameCompetitors = new GameCompetitors(playersList);
        gameCompetitors.addingPlayersWithNameAndSign("Bartosz");
        gameCompetitors.addingPlayersWithNameAndSign("Maciej");
        gameCompetitors.chooseStartingPlayer("Grzegorz");
    }
}
